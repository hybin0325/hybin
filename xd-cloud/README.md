# xd-cloud

最小可运行工程骨架（Spring Boot 2.4 + Spring Cloud + Nacos）：

- `gateway-service`：统一入口、验证码入口、Token+签名全局过滤器占位。
- `auth-service`：邮箱登录、三方登录（openid）接口占位。
- `user-service`：App 用户资料接口示例。
- `common-core`：公共响应模型。

## 快速启动（本地需 Nacos/Redis）

```bash
mvn -pl gateway-service,auth-service,user-service -am spring-boot:run
```

## 已预留后续扩展点

- 网关：JWT 校验、签名验签、nonce 防重放。
- 认证：邮箱验证码校验、OAuth2/JWT 签发、第三方 token 验签。
- 用户：MyBatis-Plus 持久层、设备维度风控。
