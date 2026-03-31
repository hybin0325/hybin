# 分布式系统蓝图（Spring Boot 2.4 + Spring Cloud + Nacos）

> 目标：提供“权限服务 + 用户服务 + 网关服务”的可落地设计，满足 `token` 与 `签名` 双重接口安全。

## 1. 技术栈与职责

- **Spring Boot 2.4.x**：微服务基础运行框架。
- **Spring Cloud（2020.x）**：服务治理、负载均衡、配置协作。
- **Nacos**：服务注册发现 + 配置中心。
- **Spring Cloud Gateway**：统一入口、鉴权前置、限流与灰度。
- **Redis**：Token 黑名单、验证码、签名防重放（nonce/timestamp）缓存。
- **MyBatis-Plus 3.5.x**：用户、角色、权限等数据访问。
- **Spring Security + OAuth2**：登录认证与令牌颁发。
- **Knife4j 2.0.9**：接口文档与调试。

## 2. 服务拆分

> 用户定位：本文中的“用户”默认是 **App 端 C 端用户**（非后台管理人员）。

### 2.1 网关服务（gateway-service）

核心职责：

1. 统一路由转发（按 `Path` + `lb://service-name`）。
2. 校验 Access Token（JWT 或远程 introspection）。
3. 签名验签（`appId + timestamp + nonce + bodyHash + sign`）。
4. 防重放：`nonce + timestamp` 写入 Redis，设置短 TTL（如 5 分钟）。
5. 白名单接口放行（登录、验证码、文档等）。
6. 验证码能力放在网关服务统一提供（图形验证码/行为验证码/邮件验证码触发入口）。

建议过滤器顺序：

1. `RequestId` 注入。
2. 时间戳窗口校验。
3. nonce 防重放校验。
4. 签名校验。
5. Token 校验。
6. 权限元数据透传（用户ID、租户ID、角色）。

### 2.2 权限服务（auth-service）

核心职责：

1. 账号密码 / 短信验证码登录。
2. OAuth2 授权与 Token 发放（建议 JWT + refresh token）。
3. 用户角色权限聚合（RBAC）。
4. Token 撤销与黑名单（Redis）。
5. 对外提供公钥或 JWK（若使用非对称签名 JWT）。
6. 支持第三方登录（Google / Facebook / Apple），客户端可上传 `openid`（建议同时上传 provider + idToken/accessToken）。
7. 支持邮箱注册、邮箱密码登录、邮箱验证码登录。

关键表建议：

- `sys_user`
- `sys_role`
- `sys_permission`
- `sys_user_role`
- `sys_role_permission`
- `oauth_client_details`（如沿用 OAuth2 客户端表）
- `sys_social_account`（第三方账号绑定表）
- `sys_email_verify_log`（邮箱验证码/激活记录）

第三方登录字段建议（`sys_social_account`）：

- `id`
- `user_id`
- `provider`（`google` / `facebook` / `apple`）
- `openid`（第三方唯一用户标识）
- `union_id`（有则存）
- `access_token`（可选，建议加密存储）
- `refresh_token`（可选，建议加密存储）
- `expires_at`
- `id_token`（可选，建议加密存储）
- `create_time` / `update_time`

### 2.3 用户服务（user-service）

核心职责：

1. 用户档案信息（查询、编辑、启停用）。
2. 用户组织关系（部门/岗位/租户）。
3. 仅处理业务数据，不直接发 Token。
4. 通过网关传入的用户上下文进行鉴权与审计。
5. 面向 App 用户支持设备信息管理（deviceId、pushToken、登录终端类型）。
6. 支持 App 用户资料（昵称、头像、手机号、邮箱、注销状态）。

App 用户数据建议：

- `app_user`
- `app_user_profile`
- `app_user_device`
- `app_user_bind`（邮箱/三方绑定关系）

## 3. Nacos 规划

建议命名：

- Namespace：按环境拆分（`dev`、`test`、`prod`）。
- Group：按业务域拆分（`DEFAULT_GROUP`、`AUTH_GROUP`）。
- Data ID：`${spring.application.name}-${profile}.yaml`。

配置拆分：

- `gateway-service-dev.yaml`
- `auth-service-dev.yaml`
- `user-service-dev.yaml`
- `shared-redis-dev.yaml`
- `shared-security-dev.yaml`

## 4. 接口安全：Token + 签名双重校验

## 4.0 邮件注册、登录约定

推荐接口：

- `POST /auth/email/register`（邮箱注册）
- `POST /auth/email/login`（邮箱+密码登录）
- `POST /gateway/captcha/email/send`（网关发送邮箱验证码）
- `POST /auth/email/code/login`（邮箱验证码登录）

注册请求体建议：

```json
{
  "email": "user@example.com",
  "password": "StrongP@ssw0rd",
  "emailCode": "123456",
  "clientId": "app-web"
}
```

服务端处理建议：

1. 邮箱格式校验 + 域名黑白名单策略（可选）。
2. 密码强度校验（长度、大小写、数字、特殊字符）。
3. 密码存储使用 `BCrypt/Argon2`，严禁明文。
4. 邮箱验证码校验通过后才允许注册/登录。
5. 支持邮箱激活状态（`email_verified`）控制敏感接口访问。
6. 登录成功后统一签发系统 `access_token/refresh_token`。
7. 建议在 token 中增加 App 用户标识（如 `userType=APP_USER`、`deviceId`）。

网关验证码职责建议：

1. **验证码统一签发入口在 gateway-service**，auth-service 只负责消费校验结果。
2. 网关生成验证码后写入 Redis（含 `scene/email/ip/ttl`）并发送邮件。
3. auth-service 在注册/登录前通过网关或共享组件校验验证码是否有效。
4. 网关对验证码发送接口做限流（按 `IP + email + scene`）。
5. 验证码校验成功后立即失效（一次一用）。

## 4.1 第三方登录（客户端传 openid）安全约定

推荐登录接口：

- `POST /auth/social/login`

推荐请求体：

```json
{
  "provider": "google",
  "openid": "xxx",
  "idToken": "xxx",
  "accessToken": "xxx",
  "clientId": "app-web",
  "deviceId": "device-001"
}
```

服务端处理建议：

1. **必须校验 provider**：仅允许 `google/facebook/apple`。
2. **优先校验 idToken/accessToken**：通过对应官方接口验签或换取用户信息，不建议只信任客户端传的 openid。
3. **账号映射**：按 `(provider, openid)` 查 `sys_social_account`。
4. **首次登录自动绑定/注册**：创建本地用户并建立绑定关系。
5. **签发本系统 Token**：成功后仍返回本系统 `access_token/refresh_token`，后续统一走网关鉴权。
6. **风控**：同一 openid 频繁失败登录应限流并记录审计日志。

## 4.2 请求头规范

- `Authorization: Bearer <access_token>`
- `X-App-Id: <clientId>`
- `X-Timestamp: <epoch_millis>`
- `X-Nonce: <uuid>`
- `X-Sign: <hex/base64-sign>`
- `X-Body-Sha256: <body hash>`（GET 可为空串 hash）

## 4.3 签名串拼装（示例）

```text
HTTP_METHOD + "\n" +
REQUEST_PATH + "\n" +
QUERY_STRING_SORTED + "\n" +
X-Timestamp + "\n" +
X-Nonce + "\n" +
X-Body-Sha256
```

签名算法建议：

- 对外开放接口：`HMAC-SHA256(secret)`。
- 内部高安全接口：`RSA/ECDSA` 非对称签名。

## 4.4 防重放策略

- 时间戳窗口：默认 ±300 秒。
- Redis Key：`sign:nonce:{appId}:{nonce}`。
- TTL：300 秒。
- 若 key 已存在则拒绝请求。

## 5. 网关路由与鉴权建议

- 白名单：`/auth/login`、`/auth/refresh`、`/doc.html`、`/v3/api-docs/**`。
- 鉴权：其余路径统一要求 token + sign。
- 方法级鉴权：下游服务使用 `@PreAuthorize` 做细粒度控制。
- 限流：按 `appId + uri` 维度设置令牌桶。
- App 用户接口建议额外按 `userId + deviceId` 限流，防止设备刷接口。

## 6. Redis 关键键设计

- `auth:token:blacklist:{jti}`（token 黑名单）
- `auth:refresh:{userId}:{clientId}`（refresh token 会话）
- `sign:nonce:{appId}:{nonce}`（防重放）
- `captcha:{scene}:{uuid}`（验证码）
- `perm:user:{userId}`（权限缓存）
- `social:bind:{provider}:{openid}`（第三方账号绑定缓存）
- `email:code:{scene}:{email}`（邮箱验证码）
- `email:register:lock:{email}`（注册限流锁）
- `gateway:captcha:img:{uuid}`（网关图形验证码）
- `gateway:captcha:email:{scene}:{email}`（网关邮箱验证码）
- `gateway:captcha:send:limit:{ip}:{email}`（网关验证码发送频控）

## 7. MyBatis-Plus 3.5 实践要点

- 使用 `BaseMapper<T>` + `ServiceImpl<M, T>`。
- 开启分页插件 `PaginationInnerInterceptor`。
- 统一字段：`create_time/update_time/create_by/update_by/del_flag`。
- 乐观锁：`@Version`。
- 逻辑删除：`@TableLogic`。

## 8. Knife4j 2.0.9 落地建议

- 每个服务独立分组：`auth`、`user`。
- 网关聚合文档展示。
- 生产环境关闭在线调试，仅保留只读文档。

### 8.1 网关聚合 Knife4j（推荐做法）

目标：

- 统一通过网关访问文档，避免直连各微服务。
- 对文档入口做权限控制，防止生产环境泄露内部 API。

建议路径：

- 网关入口：`/doc.html`
- 各服务 OpenAPI：`/auth/v3/api-docs`、`/user/v3/api-docs`

网关路由建议（示意）：

1. `Path=/auth/**` -> `lb://auth-service`
2. `Path=/user/**` -> `lb://user-service`
3. 保证 `/auth/v3/api-docs` 与 `/user/v3/api-docs` 可由网关转发

Knife4j 网关聚合分组建议：

- `Auth服务` -> `/auth/v3/api-docs`
- `User服务` -> `/user/v3/api-docs`

安全建议：

1. `dev/test` 可开放聚合文档给开发人员。
2. `prod` 仅允许内网/VPN访问，或对 `/doc.html` 加登录鉴权（如仅管理员角色可见）。
3. 不建议在生产环境开放“在线调试”按钮。
4. 网关需要保留 `X-Forwarded-*` 头，避免文档调试时回调地址错误。

## 9. 最小落地顺序（推荐）

1. 先打通 Nacos 注册与网关路由。
2. 再完成 auth-service 登录与 token 发放。
3. 在网关增加 token 过滤器。
4. 增加签名过滤器 + Redis 防重放。
5. 补齐 user-service 的 RBAC 注解鉴权。
6. 最后接入 Knife4j 聚合文档与压测。
7. 增加第三方登录联调（Google/Facebook/Apple）与 openid 绑定校验。
8. 增加邮箱注册/登录链路与验证码防刷策略。
9. 验证码接口统一收口到 gateway-service，并完成网关限流与审计。

## 10. 常见坑位

- Spring Boot 2.4 与旧版 Spring Cloud Alibaba 版本不匹配。
- Gateway 读取请求体后未回写导致下游拿不到 body。
- 网关和下游重复验签导致性能下降（建议“网关强校验 + 下游抽查/关键接口再验”）。
- token 过期与网关时钟漂移造成误判（需 NTP 对时）。
- 第三方登录仅依赖 openid 不验 token 真实性，存在伪造风险（必须做 provider 官方校验）。
- 邮箱验证码无频控会被刷接口，需按 IP + email 双维度限流。
- 验证码分散在多个服务会导致策略不一致，建议统一放网关服务治理。

---

如果你希望，我可以下一步直接给你：

1. 三个服务的 `pom.xml` 依赖清单（精确到可运行组合）。
2. `gateway` 的 Token + 签名全局过滤器代码模板。
3. `auth-service` 的 OAuth2/JWT 最小可运行样例。
4. 一份可导入 Nacos 的基础配置 YAML。
