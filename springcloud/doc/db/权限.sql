/*
Navicat MySQL Data Transfer

Source Server         : 121.196.212.59
Source Server Version : 50725
Source Host           : 121.196.212.59:3306
Source Database       : shopwwi

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-11 15:36:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shopwwi_sys_logs`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_sys_logs`;
CREATE TABLE `shopwwi_sys_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `module` varchar(50) DEFAULT NULL COMMENT '模块名',
  `flag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '成功失败',
  `remark` text COMMENT '备注',
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `create_date` (`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopwwi_sys_logs
-- ----------------------------

-- ----------------------------
-- Table structure for `shopwwi_sys_resources`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_sys_resources`;
CREATE TABLE `shopwwi_sys_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `code` varchar(100) DEFAULT NULL COMMENT '资源code',
  `type` varchar(100) DEFAULT NULL COMMENT '资源类型',
  `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `parent_id` bigint(20) NOT NULL COMMENT '上级ID',
  `url` varchar(200) DEFAULT NULL COMMENT '资源url',
  `method` varchar(20) DEFAULT NULL COMMENT '资源方法',
  `description` varchar(500) DEFAULT NULL COMMENT '简介',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(100) NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) NOT NULL COMMENT '更新人',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_resources_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of shopwwi_sys_resources
-- ----------------------------
INSERT INTO `shopwwi_sys_resources` VALUES ('101', 'user_manager:btn_add', 'button', '新增', '0', '/users', 'POST', '新增用户功能', '2019-04-24 17:28:58', '2019-04-24 17:28:58', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('102', 'user_manager:btn_edit', 'button', '编辑', '0', '/users', 'PUT', '编辑用户功能', '2019-04-24 17:28:58', '2019-04-24 17:28:58', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('103', 'user_manager:btn_del', 'button', '删除', '0', '/users/{id}', 'DELETE', '删除用户功能', '2019-04-24 17:28:58', '2019-04-24 17:28:58', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('104', 'user_manager:view', 'url', '查看', '0', '/users/{id}', 'GET', '查询用户功能', '2019-04-24 17:28:58', '2019-04-24 17:28:58', 'system', 'system', '0', '1');
INSERT INTO `shopwwi_sys_resources` VALUES ('105', 'sys', 'url', '系统设置', '0', '/', 'POST', '系统设置', '2019-05-06 09:23:20', '2019-05-06 09:23:17', 'system', 'system', '0', '1');
INSERT INTO `shopwwi_sys_resources` VALUES ('106', 'sys:menu', 'url', '菜单', '105', 'pages/menu/menuList.html', 'POST', '菜单管理', '2019-05-06 09:26:19', '2019-05-06 09:26:21', 'system', 'system', '0', '1');
INSERT INTO `shopwwi_sys_resources` VALUES ('107', 'sys:menu:query', 'button', '查询', '106', '/resources/all', 'PSOT', '菜单查询', '2019-05-06 09:28:59', '2019-05-06 09:29:04', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('108', 'sys:menu:add', 'button', '新增', '106', '/resources/save', 'PSOT', '菜单新增', '2019-05-06 09:29:53', '2019-05-06 09:29:50', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('109', 'sys:menu:del', 'button', '删除', '106', '/resources/{id}', 'DELETE', '菜单删除', '2019-05-06 09:31:12', '2019-05-06 09:31:18', 'sysyem', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('110', 'sys:role', 'url', '角色', '105', '/roles', 'POST', '角色管理', '2019-05-06 09:32:55', '2019-05-06 09:32:58', 'system', 'system', '0', '1');
INSERT INTO `shopwwi_sys_resources` VALUES ('111', 'sys:role:query', 'button', '查询', '110', '/roles/page', 'POST', '角色查询', '2019-05-06 09:34:20', '2019-05-06 09:34:23', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('112', 'sys:role:add', 'button', '新增', '110', '/roles/saveOrUp', 'POST', '角色新增', '2019-05-06 09:35:55', '2019-05-06 09:35:59', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('113', 'sys:role:del', 'button', '删除', '110', '/roles/{id}', 'DELETE', '角色删除', '2019-05-06 09:36:59', '2019-05-06 09:36:55', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('114', 'sys:user', 'url', '账号管理', '0', '/users', 'POST', '账号管理', '2019-05-06 09:40:03', '2019-05-06 09:40:06', 'system', 'system', '0', '1');
INSERT INTO `shopwwi_sys_resources` VALUES ('115', 'sys:user:query', 'button', '查询', '114', '/users/page', 'POST', '账号查询', '2019-05-06 09:40:33', '2019-05-06 09:40:31', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('116', 'sys:user:add', 'button', '新增', '114', '/users/add', 'POST', '账号新增', '2019-05-06 09:41:56', '2019-05-06 09:41:53', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('117', 'sys:user:del', 'button', '删除', '114', '/users/{id}', 'DELETE', '账号删除', '2019-05-06 09:42:07', '2019-05-06 09:42:05', 'system', 'system', '0', '2');
INSERT INTO `shopwwi_sys_resources` VALUES ('118', 'sys:user:password', 'button', '修改密码', '114', '/users/{id}', 'GET', '修改密码', '2019-05-06 14:24:45', '2019-05-06 14:24:42', 'system', 'system', '0', '2');

-- ----------------------------
-- Table structure for `shopwwi_sys_roles`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_sys_roles`;
CREATE TABLE `shopwwi_sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `code` varchar(100) NOT NULL COMMENT '角色code',
  `name` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '简介',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(100) NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role-code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of shopwwi_sys_roles
-- ----------------------------
INSERT INTO `shopwwi_sys_roles` VALUES ('101', 'ADMIN', '超级管理员', '公司IT总负责人', '2019-04-24 17:28:47', '2019-04-24 17:28:47', 'system', 'system');
INSERT INTO `shopwwi_sys_roles` VALUES ('102', 'FIN', '财务', '财务', '2019-04-24 17:28:47', '2019-04-24 17:28:47', 'system', 'system');
INSERT INTO `shopwwi_sys_roles` VALUES ('103', 'IT', 'IT', 'IT角色', '2019-04-24 17:28:47', '2019-04-24 17:28:47', 'system', 'system');

-- ----------------------------
-- Table structure for `shopwwi_sys_roles_resources_relation`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_sys_roles_resources_relation`;
CREATE TABLE `shopwwi_sys_roles_resources_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `resource_id` int(11) NOT NULL COMMENT '角色id',
  `role_id` int(11) NOT NULL COMMENT '资源id',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(100) NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='角色和资源关系表';

-- ----------------------------
-- Records of shopwwi_sys_roles_resources_relation
-- ----------------------------
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('101', '101', '101', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('102', '102', '101', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('103', '103', '101', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('104', '104', '101', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('105', '104', '102', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('106', '101', '103', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('107', '102', '103', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('108', '103', '103', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('109', '104', '103', '2019-04-24 17:29:20', '2019-04-24 17:29:20', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('110', '106', '101', '2019-05-06 15:58:04', '2019-05-06 15:58:00', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('111', '107', '101', '2019-05-06 15:58:25', '2019-05-06 15:58:21', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('112', '108', '101', '2019-05-06 15:59:37', '2019-05-06 15:59:37', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('113', '109', '101', '2019-05-06 16:00:05', '2019-05-06 16:00:05', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('114', '110', '101', '2019-05-06 16:00:22', '2019-05-06 16:00:22', 'system', 'system');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('115', '111', '101', '2019-05-06 16:00:38', '2019-05-06 16:00:38', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('116', '112', '101', '2019-05-06 16:00:48', '2019-05-06 16:00:48', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('117', '113', '101', '2019-05-06 16:00:58', '2019-05-06 16:00:58', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('118', '114', '101', '2019-05-06 16:01:18', '2019-05-06 16:01:18', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('119', '115', '101', '2019-05-06 16:01:43', '2019-05-06 16:01:43', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('120', '116', '101', '2019-05-06 16:01:52', '2019-05-06 16:01:52', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('121', '117', '101', '2019-05-06 16:02:02', '2019-05-06 16:02:02', 'admin', 'admin');
INSERT INTO `shopwwi_sys_roles_resources_relation` VALUES ('122', '118', '101', '2019-05-06 16:02:11', '2019-05-06 16:02:11', 'admin', 'admin');

-- ----------------------------
-- Table structure for `shopwwi_sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_sys_users`;
CREATE TABLE `shopwwi_sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '用户密码密文',
  `name` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '用户手机',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否有效用户',
  `account_non_expired` tinyint(1) DEFAULT NULL COMMENT '账号是否未过期',
  `credentials_non_expired` tinyint(1) DEFAULT NULL COMMENT '密码是否未过期',
  `account_non_locked` tinyint(1) DEFAULT NULL COMMENT '是否未锁定',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(100) NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_users_username` (`username`),
  UNIQUE KEY `ux_users_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of shopwwi_sys_users
-- ----------------------------
INSERT INTO `shopwwi_sys_users` VALUES ('1', '111', '111', '111', null, '0', null, null, null, '2019-04-24 17:26:48', '2019-04-24 17:26:48', '11', '111');
INSERT INTO `shopwwi_sys_users` VALUES ('101', 'admin', '$2a$10$vYA9wKn/hVGOtwQw2eHiceeIGNBdfLYpDmbzHgBSVmOfHXPH4iYdS', '超级管理员', '', '1', '1', '1', '1', '2019-04-24 17:28:17', '2019-04-24 17:28:17', 'system', 'system');
INSERT INTO `shopwwi_sys_users` VALUES ('102', 'zhoutaoo', '$2a$10$vYA9wKn/hVGOtwQw2eHiceeIGNBdfLYpDmbzHgBSVmOfHXPH4iYdS', '周涛', '15619841000', '1', '1', '1', '1', '2019-04-24 17:28:17', '2019-04-24 17:28:17', 'system', 'system');
INSERT INTO `shopwwi_sys_users` VALUES ('103', 'admin123', '$2a$10$9GiPd3bEye0Tzc9elFODCOFQ3EEUNt9N5UJX3nj9exYwxILuzgE3.', '测试2', null, '1', '1', '1', '1', '2019-04-28 18:01:38', '2019-04-28 18:01:38', 'system', 'system');

-- ----------------------------
-- Table structure for `shopwwi_sys_users_roles_relation`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_sys_users_roles_relation`;
CREATE TABLE `shopwwi_sys_users_roles_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(100) NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='用户和角色关系表';

-- ----------------------------
-- Records of shopwwi_sys_users_roles_relation
-- ----------------------------
INSERT INTO `shopwwi_sys_users_roles_relation` VALUES ('101', '101', '101', '2019-04-24 17:29:14', '2019-04-24 17:29:14', 'system', 'system');
INSERT INTO `shopwwi_sys_users_roles_relation` VALUES ('102', '102', '101', '2019-04-24 17:29:14', '2019-04-24 17:29:14', 'system', 'system');
INSERT INTO `shopwwi_sys_users_roles_relation` VALUES ('103', '102', '103', '2019-04-24 17:29:14', '2019-04-24 17:29:14', 'system', 'system');
INSERT INTO `shopwwi_sys_users_roles_relation` VALUES ('104', '103', '103', '2019-04-28 18:10:01', '2019-04-28 18:10:07', 'system', 'system');
