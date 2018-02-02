/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.11
Source Server Version : 50718
Source Host           : 192.168.0.11:3306
Source Database       : his-cms

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-02-02 10:59:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cms_auth`
-- ----------------------------
DROP TABLE IF EXISTS `cms_auth`;
CREATE TABLE `cms_auth` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `auth` varchar(128) DEFAULT NULL COMMENT '权限类型',
  `type` int(11) DEFAULT NULL COMMENT '文件夹0 文件1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_auth
-- ----------------------------
INSERT INTO `cms_auth` VALUES ('1', '可见', 'dir_view', '0');
INSERT INTO `cms_auth` VALUES ('10', '可见', 'file_view', '1');
INSERT INTO `cms_auth` VALUES ('11', '预览', 'file_scan', '1');
INSERT INTO `cms_auth` VALUES ('12', '打印', 'file_print', '1');
INSERT INTO `cms_auth` VALUES ('13', '下载', 'file_down', '1');
INSERT INTO `cms_auth` VALUES ('14', '修改', 'file_update', '1');
INSERT INTO `cms_auth` VALUES ('15', '删除', 'file_delete', '1');
INSERT INTO `cms_auth` VALUES ('16', '完全控制', 'file_all_auth', '1');
INSERT INTO `cms_auth` VALUES ('2', '创建文件夹', 'dir_create', '0');
INSERT INTO `cms_auth` VALUES ('3', '创建文件', 'dir_create_file', '0');
INSERT INTO `cms_auth` VALUES ('4', '预览文件', 'dir_scan_file', '0');
INSERT INTO `cms_auth` VALUES ('5', '打印文件', 'dir_print_file', '0');
INSERT INTO `cms_auth` VALUES ('6', '下载文件', 'dir_down_file', '0');
INSERT INTO `cms_auth` VALUES ('7', '修改', 'dir_update_file', '0');
INSERT INTO `cms_auth` VALUES ('8', '删除文件', 'dir_delete_file', '0');
INSERT INTO `cms_auth` VALUES ('9', '完全控制', 'dir_all_auth', '0');

-- ----------------------------
-- Table structure for `cms_comment`
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment` (
  `id` varchar(64) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `content` varchar(800) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user_id` varchar(64) DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `praise` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `file_id` varchar(64) DEFAULT NULL COMMENT '关联cms_file主键',
  KEY `cms_comment_title_index` (`title`) USING BTREE,
  KEY `cms_comment_content_index` (`content`) USING BTREE,
  KEY `cms_comment_create_user_index` (`create_user_id`) USING BTREE,
  KEY `cms_comment_type` (`type`) USING BTREE,
  KEY `cms_comment_fileId` (`file_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_comment
-- ----------------------------
INSERT INTO `cms_comment` VALUES ('57f6dd11-1c35-44e7-b724-1de7f14d452f', '问了一个坑爹问题', '问了一个坑爹问题', '2018-01-19 16:59:41', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '', '0', '0', '0', '1', '1');
INSERT INTO `cms_comment` VALUES ('f3a782fa-7c02-42da-b448-f2343ab74e59', '问了一个坑爹问题', '问了一个坑爹问题', '2018-01-19 17:08:08', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '', '0', '0', '0', '1', null);
INSERT INTO `cms_comment` VALUES ('530f9c56-ea84-49ad-b113-66db1b5f4655', '坑爹吗？', '坑爹吗？哪坑爹了', '2018-01-19 17:08:39', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '57f6dd11-1c35-44e7-b724-1de7f14d452f', '1', '1', '0', '1', null);
INSERT INTO `cms_comment` VALUES ('530f9c56-ea84-49ad-bse66db1b5f4655', 'abc', 'abc', '2018-01-20 09:43:20', 'c', 'c', null, '0', '0', '0', '1', null);
INSERT INTO `cms_comment` VALUES ('530f9c56-ea84-49ad-b113-66dbdsaf3dscv', 'dda', 'dda', null, 'c', 'c', null, '0', '0', '0', '1', null);
INSERT INTO `cms_comment` VALUES ('c530f9c56-ea84-49ad-b113-sdevd', 'dasfd', 'a2fd', null, '6c0f3e926f06446781f9dc013faf75c7', 'admin', '530f9c56-ea84-49ad-b113-66dbdsaf3dscv', '0', '1', '0', '1', null);
INSERT INTO `cms_comment` VALUES ('0d49370f-0948-4abf-81c1-f779960b1c03', 'sdafsafdsafdsaf', 'dsafdsafdsafdsaf', '2018-01-20 14:17:24', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '57f6dd11-1c35-44e7-b724-1de7f14d452f', '0', '1', '0', '1', null);

-- ----------------------------
-- Table structure for `cms_file`
-- ----------------------------
DROP TABLE IF EXISTS `cms_file`;
CREATE TABLE `cms_file` (
  `id` varchar(64) NOT NULL,
  `name` varchar(256) DEFAULT NULL COMMENT '标题',
  `size` decimal(10,0) DEFAULT NULL,
  `create_user` varchar(128) DEFAULT NULL COMMENT '创建者',
  `create_user_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `type` int(11) unsigned DEFAULT NULL COMMENT '文件1 或者文件夹0',
  `version` decimal(10,0) DEFAULT NULL COMMENT '文件版本',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `pid` varchar(64) DEFAULT NULL COMMENT '父节点ID',
  `update_user` varchar(128) DEFAULT NULL COMMENT '更新者',
  `update_user_id` varchar(64) DEFAULT NULL COMMENT '更新者ID',
  `url` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cms_file_name_index` (`name`) USING BTREE,
  KEY `cms_file_create_user_id_index` (`create_user_id`) USING BTREE,
  KEY `cms_file_pid_index` (`pid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_file
-- ----------------------------
INSERT INTO `cms_file` VALUES ('1', '请假管理制度', null, '1', '1', '2018-01-19 10:12:20', '2018-01-19 10:12:22', '请假管理制度', '0', '1', '0', null, null, null, null, null);
INSERT INTO `cms_file` VALUES ('318d049c-6d8d-4abc-8b3a-a3fa3d29ef50', 'abc.xls', '24576', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 10:34:01', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqk4-AUmwSAABgACv0VzQ539.xls', 'xls');
INSERT INTO `cms_file` VALUES ('35e45939-5821-41b1-9e72-5a2246c68a42', '我是文件夹', null, null, null, null, null, '描述描述描述描述描述', '0', null, '1', null, null, null, null, null);
INSERT INTO `cms_file` VALUES ('40eefd31-0f1d-4e9a-bf61-a188091d5d15', '导出1516605057888.xls', '52224', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-24 13:56:41', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1poIBGAEG7LAADMAGS9_tM453.xls', 'xls');
INSERT INTO `cms_file` VALUES ('4ceeb4d5-4d25-40fa-b8c5-f191967a2bec', 'abc.xls', '24576', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 11:36:31', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/07/wKgAC1pqojeALxK1AABgACv0VzQ293.xls', 'xls');
INSERT INTO `cms_file` VALUES ('793f6221-1a9c-46df-9e94-f20f505ea7ab', '导出1516605057888.xls', '52224', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-24 11:25:43', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn_K2AYrzOAADMAGS9_tM533.xls', 'xls');
INSERT INTO `cms_file` VALUES ('8947cc89-187a-4a01-9603-54a53dc3da9e', 'abc.xls', '24576', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 10:51:13', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pql5mAcYfsAABgACv0VzQ342.xls', 'xls');
INSERT INTO `cms_file` VALUES ('94d1f856-6c90-4f47-8151-a530b22fe8c1', 'abc.xls', '24576', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 10:50:56', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pql4iAMi9DAABgACv0VzQ690.xls', 'xls');
INSERT INTO `cms_file` VALUES ('a2039f01-b049-4868-b64c-31ef0e1a7c8d', '我是文件夹', null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', null, null, '描述描述描述描述描述', '0', null, '1', null, null, null, null, null);
INSERT INTO `cms_file` VALUES ('a2039f01-b049-4868-b64c-3x1ef0e1a7c8d', '我是文件', null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 11:15:46', '2018-01-19 11:15:48', '我是文件我是文件我是文件', '1', null, '1', null, null, null, null, null);
INSERT INTO `cms_file` VALUES ('a7a377d5-e03e-4b50-a6f6-40f78b3f7518', '导出1516605057888.xls', '52224', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-24 14:08:30', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1poItaABnozAADMAGS9_tM243.xls', 'xls');
INSERT INTO `cms_file` VALUES ('a9f9170f-2eb7-4133-bd1c-cf70c6eb5b98', 'abc.xls', '24576', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 10:26:20', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqkcKAf6ZYAABgACv0VzQ579.xls', 'xls');
INSERT INTO `cms_file` VALUES ('e973dffa-9140-4f0f-b684-3b113ebfa9cd', '导出1516605057888.xls', '52224', null, null, '2018-01-24 11:22:23', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn--WANdkWAADMAGS9_tM124.xls', 'xls');
INSERT INTO `cms_file` VALUES ('f1b635a9-e42c-4b7a-964b-3d362988c4ca', 'abc.xls', '24576', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 10:27:50', null, null, '1', '1', '1', null, null, null, '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqkhyAIx7VAABgACv0VzQ654.xls', 'xls');

-- ----------------------------
-- Table structure for `cms_file_version`
-- ----------------------------
DROP TABLE IF EXISTS `cms_file_version`;
CREATE TABLE `cms_file_version` (
  `id` varchar(64) NOT NULL,
  `version` decimal(10,0) DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `create_user_id` varchar(64) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `file_id` varchar(64) DEFAULT NULL,
  `url` varchar(256) DEFAULT NULL,
  `file_type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_file_version
-- ----------------------------
INSERT INTO `cms_file_version` VALUES ('0a2f9f10-6e3b-4c71-979a-e35b599f4e07', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '24576', '2018-01-26 11:36:31', '4ceeb4d5-4d25-40fa-b8c5-f191967a2bec', '192.168.0.11:8181/group1/M00/00/07/wKgAC1pqojeALxK1AABgACv0VzQ293.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('31ab352b-f537-4e32-9e89-ed670977bce6', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '52224', '2018-01-24 11:25:43', '793f6221-1a9c-46df-9e94-f20f505ea7ab', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn_K2AYrzOAADMAGS9_tM533.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('36998118-60ef-457c-8a76-c2af73d7208d', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '52224', '2018-01-24 13:56:41', '40eefd31-0f1d-4e9a-bf61-a188091d5d15', '192.168.0.11:8181/group1/M00/00/06/wKgAC1poIBGAEG7LAADMAGS9_tM453.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('3b2daa38-a632-4cf9-8d8d-a6be21af27ae', '1', null, null, '52224', '2018-01-24 11:14:16', 'e583082e-ffec-4f41-9f1d-c3f7e6b84618', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn-f-ATVDkAADMAGS9_tM838.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('580caaa0-27f5-44ad-a508-6fabd61c04ad', '1', null, null, '52224', '2018-01-24 11:19:12', 'c8511690-a5b4-4de7-894e-1d63a262cfa3', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn-yaAPbrPAADMAGS9_tM018.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('628c32ae-9615-4ae8-ba60-d417847e30e4', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '24576', '2018-01-26 10:27:50', 'f1b635a9-e42c-4b7a-964b-3d362988c4ca', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqkhyAIx7VAABgACv0VzQ654.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('736374b6-24fd-417f-84cc-a692f0062f6c', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '24576', '2018-01-26 10:50:56', '94d1f856-6c90-4f47-8151-a530b22fe8c1', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pql4iAMi9DAABgACv0VzQ690.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('7a39b0f5-9ede-4124-90a4-844daa5f9f4f', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '24576', '2018-01-26 10:26:20', 'a9f9170f-2eb7-4133-bd1c-cf70c6eb5b98', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqkcKAf6ZYAABgACv0VzQ579.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('7fbaf768-7ceb-43b2-9031-9ae6f95f6118', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '24576', '2018-01-26 10:51:13', '8947cc89-187a-4a01-9603-54a53dc3da9e', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pql5mAcYfsAABgACv0VzQ342.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('836cd07c-c22a-4666-a2b3-437fc5ac78c1', '1', null, null, '52224', '2018-01-24 11:17:10', 'cc000671-cb52-4dfd-893c-843570c9b15b', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn-qyAXldcAADMAGS9_tM446.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('ab6cea96-13d3-4730-99c4-4b54fa1a9c86', '1', null, null, '52224', '2018-01-24 11:22:23', 'e973dffa-9140-4f0f-b684-3b113ebfa9cd', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn--WANdkWAADMAGS9_tM124.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('b5c75205-86f0-4bd2-9061-45877b9f155b', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '24576', '2018-01-26 10:34:01', '318d049c-6d8d-4abc-8b3a-a3fa3d29ef50', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqk4-AUmwSAABgACv0VzQ539.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('bd7bfd97-60d8-4358-9b2c-a7c401e9cc03', '1', null, null, '52224', '2018-01-24 11:16:36', 'f28fcc63-7cd0-4385-824a-bbb78c0b72ad', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn-nqAEGcVAADMAGS9_tM934.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('e4fd30a5-e0a7-4c70-9516-8c7e878714d5', '1', 'admin', '6c0f3e926f06446781f9dc013faf75c7', '52224', '2018-01-24 14:08:30', 'a7a377d5-e03e-4b50-a6f6-40f78b3f7518', '192.168.0.11:8181/group1/M00/00/06/wKgAC1poItaABnozAADMAGS9_tM243.xls', 'xls');
INSERT INTO `cms_file_version` VALUES ('f55ff65a-2e29-4864-b9b1-b62f8e985e94', '1', null, null, '52224', '2018-01-24 11:09:48', '9dc63c86-3141-4e04-aa6f-9abef173a8d7', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pn-PKAYRvUAADMAGS9_tM271.xls', 'xls');

-- ----------------------------
-- Table structure for `cms_log`
-- ----------------------------
DROP TABLE IF EXISTS `cms_log`;
CREATE TABLE `cms_log` (
  `id` varchar(64) NOT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `type` varchar(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user_id` varchar(64) DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `file_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_log
-- ----------------------------
INSERT INTO `cms_log` VALUES ('12f5fb15-0708-43f6-8c4f-3535df1db0d0', '192.168.0.108', '创建文件\\文件夹', '2018-01-24 13:56:41', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null);
INSERT INTO `cms_log` VALUES ('3553cc38-803e-4af2-91b1-ab920348dd15', '192.168.0.108', '创建文件\\文件夹', '2018-01-26 10:51:13', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8947cc89-187a-4a01-9603-54a53dc3da9e');
INSERT INTO `cms_log` VALUES ('5a0c38de-d192-44f3-9e08-94fe30b9add0', '192.168.0.108', '创建文件\\文件夹', '2018-01-24 14:08:30', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a7a377d5-e03e-4b50-a6f6-40f78b3f7518');
INSERT INTO `cms_log` VALUES ('5f61c740-1874-4d8b-9308-f0d8b35e2aa7', '192.168.0.108', '创建文件\\文件夹', '2018-01-26 10:34:02', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '318d049c-6d8d-4abc-8b3a-a3fa3d29ef50');
INSERT INTO `cms_log` VALUES ('7669053f-901c-4724-af5c-42ad1e4dcd19', '192.168.0.108', '创建文件\\文件夹', '2018-01-26 10:27:52', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f1b635a9-e42c-4b7a-964b-3d362988c4ca');
INSERT INTO `cms_log` VALUES ('80f08663-20bf-4cda-911c-570935c05b73', '192.168.0.108', '创建文件\\文件夹', '2018-01-26 11:36:31', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4ceeb4d5-4d25-40fa-b8c5-f191967a2bec');
INSERT INTO `cms_log` VALUES ('860f9564-dbf3-470c-a997-5bb0b434e0cd', '192.168.0.108', '创建文件\\文件夹', '2018-01-26 10:50:57', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '94d1f856-6c90-4f47-8151-a530b22fe8c1');
INSERT INTO `cms_log` VALUES ('bc46547a-9038-4f27-8a59-bec4c4128fb0', '192.168.0.108', '创建文件\\文件夹', '2018-01-26 10:26:20', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a9f9170f-2eb7-4133-bd1c-cf70c6eb5b98');

-- ----------------------------
-- Table structure for `cms_permission`
-- ----------------------------
DROP TABLE IF EXISTS `cms_permission`;
CREATE TABLE `cms_permission` (
  `id` varchar(64) NOT NULL,
  `file_id` varchar(64) DEFAULT NULL COMMENT '文件夹或文件id',
  `auth_ids` varchar(500) DEFAULT NULL COMMENT '权限集合',
  `type` int(255) DEFAULT NULL COMMENT '类型',
  `type_id` varchar(255) DEFAULT NULL COMMENT '组织或者角色ID',
  `name` varchar(255) DEFAULT NULL COMMENT '组织机构名称',
  `update_user` varchar(64) DEFAULT NULL,
  `update_user_id` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `auth_oprate` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cms_permission_type_id_index` (`type_id`) USING BTREE,
  KEY `cms_permission_file_id_index` (`file_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_permission
-- ----------------------------
INSERT INTO `cms_permission` VALUES ('5cbc8a46-1437-4184-b609-72f798f43c07', '318d049c-6d8d-4abc-8b3a-a3fa3d29ef50', '[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"}]', '2', null, null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:47:00', '可见,创建文件夹,创建文件', 'dir_view,dir_create,dir_create_file,');
INSERT INTO `cms_permission` VALUES ('635588ca-66fb-431d-aac1-a593e22880f6', '318d049c-6d8d-4abc-8b3a-a3fa3d29ef50', '[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"}]', '3', null, null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:47:00', '可见,创建文件夹,创建文件', 'dir_view,dir_create,dir_create_file,');
INSERT INTO `cms_permission` VALUES ('673c7c5e-0d28-40f7-9b5d-2507c6011058', '318d049c-6d8d-4abc-8b3a-a3fa3d29ef50', '[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"}]', '1', null, null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:47:00', '可见,创建文件夹,创建文件', 'dir_view,dir_create,dir_create_file,');
INSERT INTO `cms_permission` VALUES ('9f57394b-44fb-44be-b631-c8275b333766', '1', '[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"}]', '1', '6c0f3e926f06446781f9dc013faf75c7', null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-25 14:49:43', '可见,创建文件夹,创建文件', null);
INSERT INTO `cms_permission` VALUES ('dc5d8dbe-0df6-490f-9572-83ba084a1725', '35e45939-5821-41b1-9e72-5a2246c68a42', '[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"}]', '2', '6c0f3e926f06446781f9dc013faf75c2', null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-25 14:49:43', '可见,创建文件夹,创建文件', null);
INSERT INTO `cms_permission` VALUES ('f1c8e889-8598-4347-8278-d514923c6445', 'e973dffa-9140-4f0f-b684-3b113ebfa9cd', '[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"}]', '3', '6c0f3e926f06446781f9dc013faf75c1', null, 'admin', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-25 14:49:43', '可见,创建文件夹,创建文件', null);

-- ----------------------------
-- Table structure for `lcn_tx_his_cms`
-- ----------------------------
DROP TABLE IF EXISTS `lcn_tx_his_cms`;
CREATE TABLE `lcn_tx_his_cms` (
  `id` varchar(10) NOT NULL,
  `retried_count` int(3) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_time` datetime NOT NULL,
  `state` int(2) NOT NULL,
  `group_id` varchar(10) NOT NULL,
  `l_unique` varchar(32) NOT NULL,
  `task_id` varchar(10) NOT NULL,
  `invocation` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lcn_tx_his_cms
-- ----------------------------
