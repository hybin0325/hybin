/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.11
Source Server Version : 50718
Source Host           : 192.168.0.11:3306
Source Database       : his-foundation

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-02-02 10:59:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fdn_custom`
-- ----------------------------
DROP TABLE IF EXISTS `fdn_custom`;
CREATE TABLE `fdn_custom` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '序号',
  `name` varchar(255) DEFAULT NULL COMMENT '字段名称',
  `type` int(11) NOT NULL COMMENT '字段类型',
  `real_value` varchar(255) DEFAULT NULL COMMENT '字段值',
  `default_value` varchar(255) DEFAULT NULL COMMENT '默认值',
  `is_required` int(255) DEFAULT NULL COMMENT '是否必填',
  `p_table` varchar(255) DEFAULT NULL COMMENT '关联表单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fdn_custom
-- ----------------------------
INSERT INTO `fdn_custom` VALUES ('01da8bef-a47d-4a37-ac49-b91adabfad65', '4', 'string', '1', 'string', 'string', '1', 'string');
INSERT INTO `fdn_custom` VALUES ('1', '1', '姓名', '1', '张三', '张三', '1', null);
INSERT INTO `fdn_custom` VALUES ('2', '2', '年龄', '1', '50', '5067', '1', null);

-- ----------------------------
-- Table structure for `fdn_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `fdn_dictionary`;
CREATE TABLE `fdn_dictionary` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '条目显示名称',
  `desc` varchar(500) DEFAULT NULL COMMENT '条目描述',
  `group` varchar(50) DEFAULT NULL COMMENT '条目分组,硬编码.例如,"职位定义"',
  `sort` int(50) DEFAULT NULL COMMENT '排序码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='初始化"职务定义",可能的数据为: "1000000000","院长","","职务定义","1" "1000000001","书记","","职务定义","2" ...';

-- ----------------------------
-- Records of fdn_dictionary
-- ----------------------------
INSERT INTO `fdn_dictionary` VALUES ('10142da3-6837-4ca3-94d8-0f87deb6df03', '院长3345', null, null, '2');
INSERT INTO `fdn_dictionary` VALUES ('1111', 'zs', null, null, '1');
INSERT INTO `fdn_dictionary` VALUES ('2642be2a-f391-4cb0-813f-7a887292791c', 'ddddsdfasdf', null, null, '3');
INSERT INTO `fdn_dictionary` VALUES ('29d9c372-d889-448c-a983-cd504909d1ef', 'fffff', null, null, '6');
INSERT INTO `fdn_dictionary` VALUES ('b08a0099-ea51-4457-acaf-25cc84d63180', '新增一个', null, null, '11');

-- ----------------------------
-- Table structure for `fdn_param`
-- ----------------------------
DROP TABLE IF EXISTS `fdn_param`;
CREATE TABLE `fdn_param` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fdn_param
-- ----------------------------
INSERT INTO `fdn_param` VALUES ('9ea9e677-a921-4d26-a06b-967c7d54d542', 'init_pwd', '123456', 'init pwd', '2017-11-09 17:41:25', '2017-11-09 17:41:27');

-- ----------------------------
-- Table structure for `lcn_tx_his_foundation`
-- ----------------------------
DROP TABLE IF EXISTS `lcn_tx_his_foundation`;
CREATE TABLE `lcn_tx_his_foundation` (
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
-- Records of lcn_tx_his_foundation
-- ----------------------------
