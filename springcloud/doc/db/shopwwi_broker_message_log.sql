/*
Navicat MySQL Data Transfer

Source Server         : 121.196.212.59
Source Server Version : 50725
Source Host           : 121.196.212.59:3306
Source Database       : shopwwi

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-06-10 09:29:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shopwwi_broker_message_log`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_broker_message_log`;
CREATE TABLE `shopwwi_broker_message_log` (
  `message_id` bigint(20) unsigned NOT NULL COMMENT '消息唯一ID',
  `message` text COMMENT '消息内容',
  `try_count` int(11) DEFAULT '0' COMMENT '重复次数',
  `status` varchar(4) DEFAULT NULL COMMENT '消息投递状态 0 投递中 1 投递成功 2 投递失败',
  `next_retry` datetime DEFAULT NULL COMMENT '下一次重试时间 或 超时时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `routing_key` varchar(200) DEFAULT NULL,
  `exchange` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `message_key` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopwwi_broker_message_log
-- ----------------------------

-- ----------------------------
-- Table structure for `shopwwi_car_park_log`
-- ----------------------------
DROP TABLE IF EXISTS `shopwwi_car_park_log`;
CREATE TABLE `shopwwi_car_park_log` (
  `id` bigint(20) NOT NULL,
  `iden` varchar(50) DEFAULT NULL COMMENT '记录唯一标识',
  `plate_num` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `channel_id` bigint(20) DEFAULT NULL COMMENT '入场通道ID',
  `cname` varchar(50) DEFAULT NULL COMMENT '入场通道名称',
  `control_id` bigint(20) DEFAULT NULL COMMENT '入场摄像机ID',
  `dname` varchar(50) DEFAULT NULL COMMENT '入场设备名称',
  `auid` bigint(20) DEFAULT NULL COMMENT '值班员ID',
  `real_name` varchar(50) DEFAULT NULL COMMENT '值班员姓名',
  `card_id` bigint(20) DEFAULT NULL COMMENT '车辆ID',
  `car_type_id` bigint(20) DEFAULT NULL COMMENT '车辆类型ID',
  `car_type` varchar(50) DEFAULT NULL COMMENT '车辆类型名称',
  `card_type_id` int(11) DEFAULT NULL COMMENT '计费类型ID',
  `card_type` varchar(50) DEFAULT NULL COMMENT '计费类型名称',
  `in_time` datetime DEFAULT NULL COMMENT '入场时间戳',
  `pic_plate_num` varchar(500) DEFAULT NULL COMMENT '保存图片',
  `card_no` varchar(50) DEFAULT NULL COMMENT '注册号/卡号',
  `out_time` datetime DEFAULT NULL COMMENT '出场时间戳',
  `cpc_id` bigint(20) DEFAULT NULL COMMENT '收费终端',
  `cpc_name` varchar(50) DEFAULT NULL COMMENT '出场收费终端名称',
  `cpc_ip` varchar(50) DEFAULT NULL COMMENT '收费终端IP',
  `state` int(11) DEFAULT NULL COMMENT '通行方式',
  `create_date` datetime DEFAULT NULL COMMENT '表保存日期',
  `channel_name` varchar(20) DEFAULT NULL,
  `in_photo` varchar(100) DEFAULT NULL,
  `out_photo` varchar(100) DEFAULT NULL,
  `dld` varchar(100) DEFAULT NULL COMMENT '所属门店',
  `clique` varchar(100) DEFAULT NULL COMMENT '所属集团',
  PRIMARY KEY (`id`),
  KEY `id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopwwi_car_park_log
-- ----------------------------
