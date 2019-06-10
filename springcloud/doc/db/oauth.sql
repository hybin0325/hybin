/*
Navicat MySQL Data Transfer

Source Server         : 121.196.212.59
Source Server Version : 50725
Source Host           : 121.196.212.59:3306
Source Database       : shopwwi

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-11 15:35:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密的access_token的值',
  `token` blob COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
  `authentication_id` varchar(128) NOT NULL COMMENT 'MD5加密过的username,client_id,scope',
  `user_name` varchar(256) DEFAULT NULL COMMENT '登录的用户名',
  `client_id` varchar(256) DEFAULT NULL COMMENT '客户端ID',
  `authentication` blob COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据',
  `refresh_token` varchar(256) DEFAULT NULL COMMENT 'MD5加密果的refresh_token的值',
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问令牌表';

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_approvals`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL COMMENT '登录的用户名',
  `clientId` varchar(256) DEFAULT NULL COMMENT '客户端ID',
  `scope` varchar(256) DEFAULT NULL COMMENT '申请的权限',
  `status` varchar(10) DEFAULT NULL COMMENT '状态（Approve或Deny',
  `expiresAt` datetime DEFAULT NULL COMMENT '过期时间',
  `lastModifiedAt` datetime DEFAULT NULL COMMENT '最终修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权记录表';

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL DEFAULT '客户端ID',
  `resource_ids` varchar(256) DEFAULT NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
  `client_secret` varchar(256) DEFAULT NULL COMMENT '客户端密匙',
  `scope` varchar(256) DEFAULT NULL COMMENT '客户端申请的权限范围',
  `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '客户端支持的grant_type',
  `web_server_redirect_uri` varchar(256) DEFAULT NULL COMMENT '重定向URI',
  `authorities` varchar(256) DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '访问令牌有效时间值(单位:秒)',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '更新令牌有效时间值(单位:秒)',
  `additional_information` varchar(4096) DEFAULT NULL COMMENT '预留字段',
  `autoapprove` varchar(256) DEFAULT NULL COMMENT '用户是否自动Approval操作',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户端信息';

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('test_client', 'order', '$2a$10$2szDKjvKHJCWE6YQNznogOeQF3USZHmCYj1fG7YbfK.vnTgNKLzri', 'read', 'client_credentials,authorization_code,password,refresh_token', 'http://baidu.com', null, '7200', '108000', null, null);

-- ----------------------------
-- Table structure for `oauth_client_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` text COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
  `authentication_id` varchar(255) DEFAULT NULL COMMENT 'MD5加密过的username,client_id,scope',
  `user_name` varchar(255) DEFAULT NULL COMMENT '登录的用户名',
  `client_id` varchar(255) DEFAULT NULL COMMENT '客户端ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL COMMENT '授权码(未加密)',
  `authentication` blob COMMENT 'AuthorizationRequestHolder.java对象序列化后的二进制数据'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权码表';

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL COMMENT 'MD5加密过的refresh_token的值',
  `token` blob COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据',
  `authentication` blob COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='更新令牌表';

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------
