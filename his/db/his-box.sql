/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.11
Source Server Version : 50718
Source Host           : 192.168.0.11:3306
Source Database       : his-box

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-02-02 10:58:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `box_0112ff6d801f4522ba854b2b054412fa`
-- ----------------------------
DROP TABLE IF EXISTS `box_0112ff6d801f4522ba854b2b054412fa`;
CREATE TABLE `box_0112ff6d801f4522ba854b2b054412fa` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_0112ff6d801f4522ba854b2b054412fa
-- ----------------------------
INSERT INTO `box_0112ff6d801f4522ba854b2b054412fa` VALUES ('2fab5131-62a5-47d7-9b50-ab2358cb5356', '0112ff6d801f4522ba854b2b054412fa', '张三', '1.0', '55.0', 'admin', '0');
INSERT INTO `box_0112ff6d801f4522ba854b2b054412fa` VALUES ('9d2af0fa-a4b1-4788-b81a-17f4c4e0f32c', '0112ff6d801f4522ba854b2b054412fa', '李四', '2.0', '66.0', 'test1', '0');

-- ----------------------------
-- Table structure for `box_0c181bd3b4de4202aa9f8d1afb5d2d36`
-- ----------------------------
DROP TABLE IF EXISTS `box_0c181bd3b4de4202aa9f8d1afb5d2d36`;
CREATE TABLE `box_0c181bd3b4de4202aa9f8d1afb5d2d36` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_0c181bd3b4de4202aa9f8d1afb5d2d36
-- ----------------------------
INSERT INTO `box_0c181bd3b4de4202aa9f8d1afb5d2d36` VALUES ('5a31de5e-e92c-45ca-a628-11725f6597b2', '0c181bd3b4de4202aa9f8d1afb5d2d36', '李四', 'lisi', '2.0', '66.0', '0');
INSERT INTO `box_0c181bd3b4de4202aa9f8d1afb5d2d36` VALUES ('9553fbb4-02bd-4684-8112-447a916c33b1', '0c181bd3b4de4202aa9f8d1afb5d2d36', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_11bf79240f9d43b2bf68b7ef58ec2ab3`
-- ----------------------------
DROP TABLE IF EXISTS `box_11bf79240f9d43b2bf68b7ef58ec2ab3`;
CREATE TABLE `box_11bf79240f9d43b2bf68b7ef58ec2ab3` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_11bf79240f9d43b2bf68b7ef58ec2ab3
-- ----------------------------
INSERT INTO `box_11bf79240f9d43b2bf68b7ef58ec2ab3` VALUES ('cec06c0f-061f-4116-ba23-b6aa1ec2d573', '11bf79240f9d43b2bf68b7ef58ec2ab3', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_17423f8d07d34919969ffdfc5815fe23`
-- ----------------------------
DROP TABLE IF EXISTS `box_17423f8d07d34919969ffdfc5815fe23`;
CREATE TABLE `box_17423f8d07d34919969ffdfc5815fe23` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_17423f8d07d34919969ffdfc5815fe23
-- ----------------------------

-- ----------------------------
-- Table structure for `box_189a9c472ac44f4286006d50094947e2`
-- ----------------------------
DROP TABLE IF EXISTS `box_189a9c472ac44f4286006d50094947e2`;
CREATE TABLE `box_189a9c472ac44f4286006d50094947e2` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_189a9c472ac44f4286006d50094947e2
-- ----------------------------

-- ----------------------------
-- Table structure for `box_1d5a2687bb274a74ac01a9cda7926e76`
-- ----------------------------
DROP TABLE IF EXISTS `box_1d5a2687bb274a74ac01a9cda7926e76`;
CREATE TABLE `box_1d5a2687bb274a74ac01a9cda7926e76` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_1d5a2687bb274a74ac01a9cda7926e76
-- ----------------------------

-- ----------------------------
-- Table structure for `box_2fa5a25f4f044adaaca39b3376fae015`
-- ----------------------------
DROP TABLE IF EXISTS `box_2fa5a25f4f044adaaca39b3376fae015`;
CREATE TABLE `box_2fa5a25f4f044adaaca39b3376fae015` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `number` varchar(128) DEFAULT NULL,
  `dengluming` varchar(128) DEFAULT NULL,
  `yonghuming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_2fa5a25f4f044adaaca39b3376fae015
-- ----------------------------
INSERT INTO `box_2fa5a25f4f044adaaca39b3376fae015` VALUES ('29645027-096a-436b-a6b8-4e3b95822709', '2fa5a25f4f044adaaca39b3376fae015', '1.0', 'admin', 'admin', 'admin', '0');
INSERT INTO `box_2fa5a25f4f044adaaca39b3376fae015` VALUES ('575b91a3-1b43-4fcf-a0bd-8ea7f492d4c8', '2fa5a25f4f044adaaca39b3376fae015', '2.0', 'aa', 'aa', 'zhangsan', '0');
INSERT INTO `box_2fa5a25f4f044adaaca39b3376fae015` VALUES ('adddb36f-41dd-4eda-aa2d-e3ea7f351366', '2fa5a25f4f044adaaca39b3376fae015', '3.0', 'dd', 'dd', 'lisi', '0');

-- ----------------------------
-- Table structure for `box_378a606a6cc14415a4568a9e92752497`
-- ----------------------------
DROP TABLE IF EXISTS `box_378a606a6cc14415a4568a9e92752497`;
CREATE TABLE `box_378a606a6cc14415a4568a9e92752497` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_378a606a6cc14415a4568a9e92752497
-- ----------------------------
INSERT INTO `box_378a606a6cc14415a4568a9e92752497` VALUES ('2b2178ca-ad2b-4d53-9b65-2e5e0ac9a698', '378a606a6cc14415a4568a9e92752497', '李四', 'lisi', '2.0', '66.0', '0');
INSERT INTO `box_378a606a6cc14415a4568a9e92752497` VALUES ('81bbecc3-a2cd-4759-a061-9a65ee3fa2cd', '378a606a6cc14415a4568a9e92752497', '张三', 'zhangsan', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_37d46a02466242a4adcd8cb5a260b65e`
-- ----------------------------
DROP TABLE IF EXISTS `box_37d46a02466242a4adcd8cb5a260b65e`;
CREATE TABLE `box_37d46a02466242a4adcd8cb5a260b65e` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_37d46a02466242a4adcd8cb5a260b65e
-- ----------------------------
INSERT INTO `box_37d46a02466242a4adcd8cb5a260b65e` VALUES ('1a23eed4-111e-4c6c-b206-e1328a6bb637', '37d46a02466242a4adcd8cb5a260b65e', '张三', '1.0', '55.0', 'admin', '3');

-- ----------------------------
-- Table structure for `box_47aa7ac3db384393b16e59334d743c52`
-- ----------------------------
DROP TABLE IF EXISTS `box_47aa7ac3db384393b16e59334d743c52`;
CREATE TABLE `box_47aa7ac3db384393b16e59334d743c52` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_47aa7ac3db384393b16e59334d743c52
-- ----------------------------
INSERT INTO `box_47aa7ac3db384393b16e59334d743c52` VALUES ('0998cbb4-fbd1-459b-af18-4f4af33506f9', '47aa7ac3db384393b16e59334d743c52', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_486a1b70fa4b488b85253ee5b82f666f`
-- ----------------------------
DROP TABLE IF EXISTS `box_486a1b70fa4b488b85253ee5b82f666f`;
CREATE TABLE `box_486a1b70fa4b488b85253ee5b82f666f` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_486a1b70fa4b488b85253ee5b82f666f
-- ----------------------------

-- ----------------------------
-- Table structure for `box_4a37977e7a524e87b9ce75f84b133025`
-- ----------------------------
DROP TABLE IF EXISTS `box_4a37977e7a524e87b9ce75f84b133025`;
CREATE TABLE `box_4a37977e7a524e87b9ce75f84b133025` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_4a37977e7a524e87b9ce75f84b133025
-- ----------------------------

-- ----------------------------
-- Table structure for `box_4b8e9f81f2dc404092cf18050655d3a2`
-- ----------------------------
DROP TABLE IF EXISTS `box_4b8e9f81f2dc404092cf18050655d3a2`;
CREATE TABLE `box_4b8e9f81f2dc404092cf18050655d3a2` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_4b8e9f81f2dc404092cf18050655d3a2
-- ----------------------------
INSERT INTO `box_4b8e9f81f2dc404092cf18050655d3a2` VALUES ('eabdf957-2542-4c1c-be91-4aa46de4b9ee', '4b8e9f81f2dc404092cf18050655d3a2', '张三', '1.0', '55.0', 'admin', '3');

-- ----------------------------
-- Table structure for `box_4d2e2d53ca074a7497c5ce0bd5687806`
-- ----------------------------
DROP TABLE IF EXISTS `box_4d2e2d53ca074a7497c5ce0bd5687806`;
CREATE TABLE `box_4d2e2d53ca074a7497c5ce0bd5687806` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_4d2e2d53ca074a7497c5ce0bd5687806
-- ----------------------------

-- ----------------------------
-- Table structure for `box_4ec0fabfe7ff40498b995f4f149927af`
-- ----------------------------
DROP TABLE IF EXISTS `box_4ec0fabfe7ff40498b995f4f149927af`;
CREATE TABLE `box_4ec0fabfe7ff40498b995f4f149927af` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_4ec0fabfe7ff40498b995f4f149927af
-- ----------------------------

-- ----------------------------
-- Table structure for `box_4fef97409d3847beb819f2402095ff6e`
-- ----------------------------
DROP TABLE IF EXISTS `box_4fef97409d3847beb819f2402095ff6e`;
CREATE TABLE `box_4fef97409d3847beb819f2402095ff6e` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `bhh` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_4fef97409d3847beb819f2402095ff6e
-- ----------------------------
INSERT INTO `box_4fef97409d3847beb819f2402095ff6e` VALUES ('2c7c15a2-aa85-4a7c-96c1-0ad30589db13', '4fef97409d3847beb819f2402095ff6e', 'lisi', 'lisi', 'asf', '0');
INSERT INTO `box_4fef97409d3847beb819f2402095ff6e` VALUES ('576278b0-d0a4-4859-bcff-3c71312cf397', '4fef97409d3847beb819f2402095ff6e', '张三', 'zhangsan', 'asf', '0');

-- ----------------------------
-- Table structure for `box_5232754b71044fa3b443e75ad7e916d6`
-- ----------------------------
DROP TABLE IF EXISTS `box_5232754b71044fa3b443e75ad7e916d6`;
CREATE TABLE `box_5232754b71044fa3b443e75ad7e916d6` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_5232754b71044fa3b443e75ad7e916d6
-- ----------------------------

-- ----------------------------
-- Table structure for `box_54732f307b6c47cab57f3f428955656f`
-- ----------------------------
DROP TABLE IF EXISTS `box_54732f307b6c47cab57f3f428955656f`;
CREATE TABLE `box_54732f307b6c47cab57f3f428955656f` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_54732f307b6c47cab57f3f428955656f
-- ----------------------------
INSERT INTO `box_54732f307b6c47cab57f3f428955656f` VALUES ('ff47d046-9dbe-4d12-ac8d-92f1a91b0bc4', '54732f307b6c47cab57f3f428955656f', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_54e3bb7621bb423ebf2be41900fd6d35`
-- ----------------------------
DROP TABLE IF EXISTS `box_54e3bb7621bb423ebf2be41900fd6d35`;
CREATE TABLE `box_54e3bb7621bb423ebf2be41900fd6d35` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_54e3bb7621bb423ebf2be41900fd6d35
-- ----------------------------
INSERT INTO `box_54e3bb7621bb423ebf2be41900fd6d35` VALUES ('3676339c-5ea5-4e55-8200-ec2646d7d59b', '54e3bb7621bb423ebf2be41900fd6d35', '李四', 'lisi', '2.0', '66.0', '0');
INSERT INTO `box_54e3bb7621bb423ebf2be41900fd6d35` VALUES ('8b58f67b-9b17-4eef-bdcd-368af6605ff1', '54e3bb7621bb423ebf2be41900fd6d35', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_57950932014e4003873fc2bc8032662a`
-- ----------------------------
DROP TABLE IF EXISTS `box_57950932014e4003873fc2bc8032662a`;
CREATE TABLE `box_57950932014e4003873fc2bc8032662a` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_57950932014e4003873fc2bc8032662a
-- ----------------------------
INSERT INTO `box_57950932014e4003873fc2bc8032662a` VALUES ('246fe71d-7b9e-4eec-9155-5a4a994aee12', '57950932014e4003873fc2bc8032662a', '李四', 'lisi', '2.0', '66.0', '0');
INSERT INTO `box_57950932014e4003873fc2bc8032662a` VALUES ('f3389c88-a761-40b5-8bd6-e70eb6284ecc', '57950932014e4003873fc2bc8032662a', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_585db057707c4bb0a06d450822245db1`
-- ----------------------------
DROP TABLE IF EXISTS `box_585db057707c4bb0a06d450822245db1`;
CREATE TABLE `box_585db057707c4bb0a06d450822245db1` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_585db057707c4bb0a06d450822245db1
-- ----------------------------
INSERT INTO `box_585db057707c4bb0a06d450822245db1` VALUES ('bb2b1947-a5b3-4a0a-b2b6-d4b41cd83b5a', '585db057707c4bb0a06d450822245db1', '张三', 'admin', '0');

-- ----------------------------
-- Table structure for `box_5b5877bba7d84e7aaa4940d4e43f15d2`
-- ----------------------------
DROP TABLE IF EXISTS `box_5b5877bba7d84e7aaa4940d4e43f15d2`;
CREATE TABLE `box_5b5877bba7d84e7aaa4940d4e43f15d2` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_5b5877bba7d84e7aaa4940d4e43f15d2
-- ----------------------------
INSERT INTO `box_5b5877bba7d84e7aaa4940d4e43f15d2` VALUES ('bb554b96-9186-4c09-ad56-96f373c9a208', '5b5877bba7d84e7aaa4940d4e43f15d2', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_5b7acaa6e9b9410bb1e1a5baf2afa392`
-- ----------------------------
DROP TABLE IF EXISTS `box_5b7acaa6e9b9410bb1e1a5baf2afa392`;
CREATE TABLE `box_5b7acaa6e9b9410bb1e1a5baf2afa392` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_5b7acaa6e9b9410bb1e1a5baf2afa392
-- ----------------------------
INSERT INTO `box_5b7acaa6e9b9410bb1e1a5baf2afa392` VALUES ('bd4d4a80-9e79-4742-a0ee-11d0f14a6687', '5b7acaa6e9b9410bb1e1a5baf2afa392', '张三', '1.0', '55.0', 'admin', '3');

-- ----------------------------
-- Table structure for `box_624b0f0db81d4cdaae2f4608b798d069`
-- ----------------------------
DROP TABLE IF EXISTS `box_624b0f0db81d4cdaae2f4608b798d069`;
CREATE TABLE `box_624b0f0db81d4cdaae2f4608b798d069` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_624b0f0db81d4cdaae2f4608b798d069
-- ----------------------------
INSERT INTO `box_624b0f0db81d4cdaae2f4608b798d069` VALUES ('02916e00-380d-417b-8178-ce89e2bd81d9', '624b0f0db81d4cdaae2f4608b798d069', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_6299bc217cd648588a34b7a1d1c7b72e`
-- ----------------------------
DROP TABLE IF EXISTS `box_6299bc217cd648588a34b7a1d1c7b72e`;
CREATE TABLE `box_6299bc217cd648588a34b7a1d1c7b72e` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_6299bc217cd648588a34b7a1d1c7b72e
-- ----------------------------
INSERT INTO `box_6299bc217cd648588a34b7a1d1c7b72e` VALUES ('131a6664-92fd-4ed5-967c-4effe28e319c', '6299bc217cd648588a34b7a1d1c7b72e', '张三', '1.0', '55.0', 'admin', '1');

-- ----------------------------
-- Table structure for `box_672f11000229409f85a2e95ecfbab441`
-- ----------------------------
DROP TABLE IF EXISTS `box_672f11000229409f85a2e95ecfbab441`;
CREATE TABLE `box_672f11000229409f85a2e95ecfbab441` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_672f11000229409f85a2e95ecfbab441
-- ----------------------------
INSERT INTO `box_672f11000229409f85a2e95ecfbab441` VALUES ('a65aa227-dc5f-42e0-8057-9ac01ff1699c', '672f11000229409f85a2e95ecfbab441', '李四', 'lisi11', '2.0', '66.0', '0');
INSERT INTO `box_672f11000229409f85a2e95ecfbab441` VALUES ('de487f6f-e1e9-465f-8af5-7d2c7c699ce5', '672f11000229409f85a2e95ecfbab441', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_69f0d4a2475e44da816c11de64138493`
-- ----------------------------
DROP TABLE IF EXISTS `box_69f0d4a2475e44da816c11de64138493`;
CREATE TABLE `box_69f0d4a2475e44da816c11de64138493` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `number` varchar(128) DEFAULT NULL,
  `dengluming` varchar(128) DEFAULT NULL,
  `yonghuming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_69f0d4a2475e44da816c11de64138493
-- ----------------------------
INSERT INTO `box_69f0d4a2475e44da816c11de64138493` VALUES ('4b1eb031-493f-41c0-b70d-eaf7d78c933c', '69f0d4a2475e44da816c11de64138493', '2.0', 'aa', 'aa', 'zhangsan', '0');
INSERT INTO `box_69f0d4a2475e44da816c11de64138493` VALUES ('508e84fe-9114-4868-9bfa-1dc2cd8496a8', '69f0d4a2475e44da816c11de64138493', '3.0', 'dd', 'dd', 'lisi', '1');
INSERT INTO `box_69f0d4a2475e44da816c11de64138493` VALUES ('f9106f0e-844d-43d7-ba1e-2bebbb88f001', '69f0d4a2475e44da816c11de64138493', '1.0', 'admin', 'admin', 'admin', '1');

-- ----------------------------
-- Table structure for `box_74a23b593b514d56870df8e04d61ba77`
-- ----------------------------
DROP TABLE IF EXISTS `box_74a23b593b514d56870df8e04d61ba77`;
CREATE TABLE `box_74a23b593b514d56870df8e04d61ba77` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_74a23b593b514d56870df8e04d61ba77
-- ----------------------------
INSERT INTO `box_74a23b593b514d56870df8e04d61ba77` VALUES ('6b29695a-e471-4e74-bed8-a909e75ee695', '74a23b593b514d56870df8e04d61ba77', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_76c91ecb4c6e4cc091cb06884b591d06`
-- ----------------------------
DROP TABLE IF EXISTS `box_76c91ecb4c6e4cc091cb06884b591d06`;
CREATE TABLE `box_76c91ecb4c6e4cc091cb06884b591d06` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_76c91ecb4c6e4cc091cb06884b591d06
-- ----------------------------

-- ----------------------------
-- Table structure for `box_7963fbfcaf2e409f9bc980ab80efc45e`
-- ----------------------------
DROP TABLE IF EXISTS `box_7963fbfcaf2e409f9bc980ab80efc45e`;
CREATE TABLE `box_7963fbfcaf2e409f9bc980ab80efc45e` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_7963fbfcaf2e409f9bc980ab80efc45e
-- ----------------------------
INSERT INTO `box_7963fbfcaf2e409f9bc980ab80efc45e` VALUES ('555bd8c3-00d6-4c01-9370-389c845a0a32', '7963fbfcaf2e409f9bc980ab80efc45e', '李四', '2.0', '66.0', 'test1', '0');
INSERT INTO `box_7963fbfcaf2e409f9bc980ab80efc45e` VALUES ('b2ba6daa-81fe-4396-995c-994c0c96675a', '7963fbfcaf2e409f9bc980ab80efc45e', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_79a7d6a004b345178561bc41af5288dd`
-- ----------------------------
DROP TABLE IF EXISTS `box_79a7d6a004b345178561bc41af5288dd`;
CREATE TABLE `box_79a7d6a004b345178561bc41af5288dd` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_79a7d6a004b345178561bc41af5288dd
-- ----------------------------

-- ----------------------------
-- Table structure for `box_7cf1c03b682248d8b892dfb1bbeda701`
-- ----------------------------
DROP TABLE IF EXISTS `box_7cf1c03b682248d8b892dfb1bbeda701`;
CREATE TABLE `box_7cf1c03b682248d8b892dfb1bbeda701` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `shijian` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_7cf1c03b682248d8b892dfb1bbeda701
-- ----------------------------
INSERT INTO `box_7cf1c03b682248d8b892dfb1bbeda701` VALUES ('197c7d24-6f6e-45be-a983-45cf706448ab', '7cf1c03b682248d8b892dfb1bbeda701', '张三', 'zhangsan', '13-Dec-2017', '0');
INSERT INTO `box_7cf1c03b682248d8b892dfb1bbeda701` VALUES ('a4b40196-6ef9-4f27-aa53-b49fda68f3c0', '7cf1c03b682248d8b892dfb1bbeda701', '测试1', 'ceshi1', '23-Dec-2017', '3');

-- ----------------------------
-- Table structure for `box_804af4f5a7c8419eb706502a7a74bb6b`
-- ----------------------------
DROP TABLE IF EXISTS `box_804af4f5a7c8419eb706502a7a74bb6b`;
CREATE TABLE `box_804af4f5a7c8419eb706502a7a74bb6b` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_804af4f5a7c8419eb706502a7a74bb6b
-- ----------------------------
INSERT INTO `box_804af4f5a7c8419eb706502a7a74bb6b` VALUES ('5dffbc2a-b034-45c6-8618-d477d91b8072', '804af4f5a7c8419eb706502a7a74bb6b', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_81ae2cb3d98f406eadc8532f22d43112`
-- ----------------------------
DROP TABLE IF EXISTS `box_81ae2cb3d98f406eadc8532f22d43112`;
CREATE TABLE `box_81ae2cb3d98f406eadc8532f22d43112` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_81ae2cb3d98f406eadc8532f22d43112
-- ----------------------------
INSERT INTO `box_81ae2cb3d98f406eadc8532f22d43112` VALUES ('a74d8652-3f1d-4bb8-9717-0f624982b36c', '81ae2cb3d98f406eadc8532f22d43112', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_842431949ed54414b85e35f67023b089`
-- ----------------------------
DROP TABLE IF EXISTS `box_842431949ed54414b85e35f67023b089`;
CREATE TABLE `box_842431949ed54414b85e35f67023b089` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_842431949ed54414b85e35f67023b089
-- ----------------------------

-- ----------------------------
-- Table structure for `box_8f35c2d6fda84087a9d9f4876b3d4b1d`
-- ----------------------------
DROP TABLE IF EXISTS `box_8f35c2d6fda84087a9d9f4876b3d4b1d`;
CREATE TABLE `box_8f35c2d6fda84087a9d9f4876b3d4b1d` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_8f35c2d6fda84087a9d9f4876b3d4b1d
-- ----------------------------

-- ----------------------------
-- Table structure for `box_9267268f2d85409183c222a6aeafd143`
-- ----------------------------
DROP TABLE IF EXISTS `box_9267268f2d85409183c222a6aeafd143`;
CREATE TABLE `box_9267268f2d85409183c222a6aeafd143` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_9267268f2d85409183c222a6aeafd143
-- ----------------------------
INSERT INTO `box_9267268f2d85409183c222a6aeafd143` VALUES ('eeefcc37-4840-4132-9d47-aceb9674e951', '9267268f2d85409183c222a6aeafd143', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_97455708691c46cba95bdb6f01309a38`
-- ----------------------------
DROP TABLE IF EXISTS `box_97455708691c46cba95bdb6f01309a38`;
CREATE TABLE `box_97455708691c46cba95bdb6f01309a38` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_97455708691c46cba95bdb6f01309a38
-- ----------------------------
INSERT INTO `box_97455708691c46cba95bdb6f01309a38` VALUES ('09ac5b73-0f03-4189-88ba-0cfed61b57fb', '97455708691c46cba95bdb6f01309a38', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_9bdeda0c4eed4f33b7e85dda5039822c`
-- ----------------------------
DROP TABLE IF EXISTS `box_9bdeda0c4eed4f33b7e85dda5039822c`;
CREATE TABLE `box_9bdeda0c4eed4f33b7e85dda5039822c` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_9bdeda0c4eed4f33b7e85dda5039822c
-- ----------------------------

-- ----------------------------
-- Table structure for `box_9d8eabbe39254f5eb4c8a9a6b97b5ed2`
-- ----------------------------
DROP TABLE IF EXISTS `box_9d8eabbe39254f5eb4c8a9a6b97b5ed2`;
CREATE TABLE `box_9d8eabbe39254f5eb4c8a9a6b97b5ed2` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_9d8eabbe39254f5eb4c8a9a6b97b5ed2
-- ----------------------------
INSERT INTO `box_9d8eabbe39254f5eb4c8a9a6b97b5ed2` VALUES ('71fdf6d6-40ba-4b92-8362-9612df30b27d', '9d8eabbe39254f5eb4c8a9a6b97b5ed2', '张三', 'zhangsan11', '1.0', '55.0', '0');
INSERT INTO `box_9d8eabbe39254f5eb4c8a9a6b97b5ed2` VALUES ('a4984034-8fa0-49f8-b448-8493655292fa', '9d8eabbe39254f5eb4c8a9a6b97b5ed2', '李四', 'lisi', '2.0', '66.0', '0');

-- ----------------------------
-- Table structure for `box_9d9a8ac5f65c409bb712a1151a04f122`
-- ----------------------------
DROP TABLE IF EXISTS `box_9d9a8ac5f65c409bb712a1151a04f122`;
CREATE TABLE `box_9d9a8ac5f65c409bb712a1151a04f122` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_9d9a8ac5f65c409bb712a1151a04f122
-- ----------------------------
INSERT INTO `box_9d9a8ac5f65c409bb712a1151a04f122` VALUES ('09dc54f7-155c-4500-ac24-6502a5ae6d36', '9d9a8ac5f65c409bb712a1151a04f122', '张三', '1.0', '55.0', 'admin', '3');

-- ----------------------------
-- Table structure for `box_a3a90bc8719345c1b192360f937e6526`
-- ----------------------------
DROP TABLE IF EXISTS `box_a3a90bc8719345c1b192360f937e6526`;
CREATE TABLE `box_a3a90bc8719345c1b192360f937e6526` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_a3a90bc8719345c1b192360f937e6526
-- ----------------------------
INSERT INTO `box_a3a90bc8719345c1b192360f937e6526` VALUES ('35a5dd51-a4cb-4d59-9fe7-1b39508112d5', 'a3a90bc8719345c1b192360f937e6526', '张三', '1.0', '55.0', 'admin', '3');

-- ----------------------------
-- Table structure for `box_a52dc6d7960e4f349b786429a9ad51cb`
-- ----------------------------
DROP TABLE IF EXISTS `box_a52dc6d7960e4f349b786429a9ad51cb`;
CREATE TABLE `box_a52dc6d7960e4f349b786429a9ad51cb` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_a52dc6d7960e4f349b786429a9ad51cb
-- ----------------------------
INSERT INTO `box_a52dc6d7960e4f349b786429a9ad51cb` VALUES ('419ccf30-7d47-4c57-b37a-46db2f7faec1', 'a52dc6d7960e4f349b786429a9ad51cb', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_a92c64ea98334bb9911b144e64cbdd28`
-- ----------------------------
DROP TABLE IF EXISTS `box_a92c64ea98334bb9911b144e64cbdd28`;
CREATE TABLE `box_a92c64ea98334bb9911b144e64cbdd28` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_a92c64ea98334bb9911b144e64cbdd28
-- ----------------------------
INSERT INTO `box_a92c64ea98334bb9911b144e64cbdd28` VALUES ('c4c82175-c3a5-479e-b3d8-935e5301de08', 'a92c64ea98334bb9911b144e64cbdd28', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_aabbcc`
-- ----------------------------
DROP TABLE IF EXISTS `box_aabbcc`;
CREATE TABLE `box_aabbcc` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `number` varchar(128) DEFAULT NULL,
  `dengluming` varchar(128) DEFAULT NULL,
  `yonghuming` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_aabbcc
-- ----------------------------
INSERT INTO `box_aabbcc` VALUES ('aa7f8ef2-39d0-415c-8d9f-cba17582e899', 'aabbcc', '2.0', 'aa', 'aa', '0');
INSERT INTO `box_aabbcc` VALUES ('e2bbe057-e9ef-4411-9bab-3137213ebe63', 'aabbcc', '3.0', 'dd', 'dd', '0');
INSERT INTO `box_aabbcc` VALUES ('f43090f0-9aeb-4605-bbe0-6473fb56ab51', 'aabbcc', '1.0', 'admin', 'admin', '0');

-- ----------------------------
-- Table structure for `box_authority`
-- ----------------------------
DROP TABLE IF EXISTS `box_authority`;
CREATE TABLE `box_authority` (
  `id` varchar(64) NOT NULL,
  `allow_subordinate` int(11) DEFAULT NULL,
  `allow_division` int(11) DEFAULT NULL,
  `box_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_authority
-- ----------------------------

-- ----------------------------
-- Table structure for `box_b100fefc8aee40a59f2464e7b960edda`
-- ----------------------------
DROP TABLE IF EXISTS `box_b100fefc8aee40a59f2464e7b960edda`;
CREATE TABLE `box_b100fefc8aee40a59f2464e7b960edda` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_b100fefc8aee40a59f2464e7b960edda
-- ----------------------------

-- ----------------------------
-- Table structure for `box_b665de5987b342df9655e44bee1fd65d`
-- ----------------------------
DROP TABLE IF EXISTS `box_b665de5987b342df9655e44bee1fd65d`;
CREATE TABLE `box_b665de5987b342df9655e44bee1fd65d` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_b665de5987b342df9655e44bee1fd65d
-- ----------------------------

-- ----------------------------
-- Table structure for `box_b78a2a1666374921886f7d00b2ee586d`
-- ----------------------------
DROP TABLE IF EXISTS `box_b78a2a1666374921886f7d00b2ee586d`;
CREATE TABLE `box_b78a2a1666374921886f7d00b2ee586d` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_b78a2a1666374921886f7d00b2ee586d
-- ----------------------------
INSERT INTO `box_b78a2a1666374921886f7d00b2ee586d` VALUES ('cb35717b-335c-430e-a74a-62c7a7e50ba6', 'b78a2a1666374921886f7d00b2ee586d', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_b9d36b3836944a4fb7d298a3e5394b98`
-- ----------------------------
DROP TABLE IF EXISTS `box_b9d36b3836944a4fb7d298a3e5394b98`;
CREATE TABLE `box_b9d36b3836944a4fb7d298a3e5394b98` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_b9d36b3836944a4fb7d298a3e5394b98
-- ----------------------------
INSERT INTO `box_b9d36b3836944a4fb7d298a3e5394b98` VALUES ('b6f52ba2-e132-4353-be5c-97db2f23950a', 'b9d36b3836944a4fb7d298a3e5394b98', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_bd8622d3f67e4aff9cf4d2cb658d193f`
-- ----------------------------
DROP TABLE IF EXISTS `box_bd8622d3f67e4aff9cf4d2cb658d193f`;
CREATE TABLE `box_bd8622d3f67e4aff9cf4d2cb658d193f` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_bd8622d3f67e4aff9cf4d2cb658d193f
-- ----------------------------
INSERT INTO `box_bd8622d3f67e4aff9cf4d2cb658d193f` VALUES ('6a5050e8-59a0-4c62-992c-36d68a6cc35a', 'bd8622d3f67e4aff9cf4d2cb658d193f', '张三', 'zhangsan11', '1.0', '55.0', '0');
INSERT INTO `box_bd8622d3f67e4aff9cf4d2cb658d193f` VALUES ('ce1c78e4-5b4c-404e-bf5a-e77fc90d37f4', 'bd8622d3f67e4aff9cf4d2cb658d193f', '李四', 'lisi', '2.0', '66.0', '0');

-- ----------------------------
-- Table structure for `box_be8f59c333c14cb8afc37981a5f9312b`
-- ----------------------------
DROP TABLE IF EXISTS `box_be8f59c333c14cb8afc37981a5f9312b`;
CREATE TABLE `box_be8f59c333c14cb8afc37981a5f9312b` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_be8f59c333c14cb8afc37981a5f9312b
-- ----------------------------

-- ----------------------------
-- Table structure for `box_c141fabca2774d7d983e18e700c6a99c`
-- ----------------------------
DROP TABLE IF EXISTS `box_c141fabca2774d7d983e18e700c6a99c`;
CREATE TABLE `box_c141fabca2774d7d983e18e700c6a99c` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_c141fabca2774d7d983e18e700c6a99c
-- ----------------------------

-- ----------------------------
-- Table structure for `box_c4530aa18d954fbf96a74648d6a1e642`
-- ----------------------------
DROP TABLE IF EXISTS `box_c4530aa18d954fbf96a74648d6a1e642`;
CREATE TABLE `box_c4530aa18d954fbf96a74648d6a1e642` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_c4530aa18d954fbf96a74648d6a1e642
-- ----------------------------
INSERT INTO `box_c4530aa18d954fbf96a74648d6a1e642` VALUES ('808e6efe-5224-402a-a647-b7e5615585a1', 'c4530aa18d954fbf96a74648d6a1e642', '张三', 'zhangsan', '1.0', '55.0', '0');
INSERT INTO `box_c4530aa18d954fbf96a74648d6a1e642` VALUES ('97f49c8d-f0a8-40fd-affe-10307ddaf94a', 'c4530aa18d954fbf96a74648d6a1e642', '李四', 'lisi', '2.0', '66.0', '0');

-- ----------------------------
-- Table structure for `box_cb97122a2b294fcbbcf1c0bdb6bd2722`
-- ----------------------------
DROP TABLE IF EXISTS `box_cb97122a2b294fcbbcf1c0bdb6bd2722`;
CREATE TABLE `box_cb97122a2b294fcbbcf1c0bdb6bd2722` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_cb97122a2b294fcbbcf1c0bdb6bd2722
-- ----------------------------

-- ----------------------------
-- Table structure for `box_cca5f1486d86481dae11f22dd20fcc93`
-- ----------------------------
DROP TABLE IF EXISTS `box_cca5f1486d86481dae11f22dd20fcc93`;
CREATE TABLE `box_cca5f1486d86481dae11f22dd20fcc93` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_cca5f1486d86481dae11f22dd20fcc93
-- ----------------------------
INSERT INTO `box_cca5f1486d86481dae11f22dd20fcc93` VALUES ('42df5ade-2825-40fc-810b-1a69a28d9a98', 'cca5f1486d86481dae11f22dd20fcc93', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_comment`
-- ----------------------------
DROP TABLE IF EXISTS `box_comment`;
CREATE TABLE `box_comment` (
  `id` varchar(64) NOT NULL,
  `content` varchar(800) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user_id` varchar(64) DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `praise` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `box_id` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_comment
-- ----------------------------
INSERT INTO `box_comment` VALUES ('009f2531-1391-4078-98da-533de109bff8', '222', '2018-01-18 18:14:43', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '2', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('00d1e479-cd25-480a-af89-021efd568c48', '1', '2018-01-23 10:22:51', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'e18b850ac1a2403cb87cfe4c0b028eda', '1');
INSERT INTO `box_comment` VALUES ('012cd6a6-318c-470e-b80c-2f7ba8d8dcfb', 'qqq', '2018-01-29 20:40:57', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '1', null, '0', '74a23b593b514d56870df8e04d61ba77', '1');
INSERT INTO `box_comment` VALUES ('0932b98a-7ac1-42e4-a2ed-24b42337cfd1', '22', '2018-01-24 13:57:44', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('0ab2316f-b901-44fa-9a48-8adb91aaf6d6', '从收件列表发起回复', '2018-01-19 11:25:29', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '9', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('0b4af4a0-0162-48b6-a63d-c8b865faf4f4', 'submitCommentLoading', '2018-01-19 11:22:42', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '8c0f07dd06c64b5b9b677e83e317ad01', '1');
INSERT INTO `box_comment` VALUES ('0cf5eb97-1e2f-42e4-9a08-71119c42f682', '测试回复是否正常', '2018-01-18 11:24:05', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('183045ff-4cc5-4659-936d-2731df2af040', 'dsddss', '2018-02-01 17:35:08', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '5ae39c03921e4fb68ff4f02f1763e57f', '1');
INSERT INTO `box_comment` VALUES ('1c13eebb-ab5b-4e27-b864-ebf73f34e2eb', '厉害啊', '2018-01-24 15:05:11', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'ea77b2fb4e1348a9b045d13ab6f998e9', '1');
INSERT INTO `box_comment` VALUES ('1e58a30c-3ae4-4697-90d3-af8ab32bb37e', '498989', '2018-01-31 15:13:11', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '3cb1c2977476478c829ac4dc9f6daaa1', '1');
INSERT INTO `box_comment` VALUES ('2186eb9a-b764-458c-a3d5-95b2a22ea197', '好像是吧', '2018-01-24 15:04:51', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'ea77b2fb4e1348a9b045d13ab6f998e9', '1');
INSERT INTO `box_comment` VALUES ('25e85f86-2ddd-4231-9b88-e1bc0683906e', '1', '2018-01-24 15:29:30', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('265e22ab-1073-4349-a6f7-0dd424d44c3a', '11', '2018-01-19 09:27:56', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('286ab309-bf1a-4015-beb7-0d1f5e5e8926', '测试回复6', '2018-01-18 14:19:34', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('38d04756-dff0-4804-ab2d-b3208a1061e0', '喂喂额问问', '2018-01-31 16:35:39', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '2d0b280b939d4a08b470619016d3cf2f', '1');
INSERT INTO `box_comment` VALUES ('3ab6863b-c865-4d9c-8526-9877ddde3f85', 'ioiio', '2018-01-20 17:17:59', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '3df0e17a-39b9-4cad-abb5-c15f65baeaa6', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('3ceaa493-9d3a-47ee-a54e-18deb9e92fc0', '312', '2018-01-24 15:03:09', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f6a25c72-ea7a-46af-9675-69201418344b', '1', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('3df0e17a-39b9-4cad-abb5-c15f65baeaa6', '\'l;\'l\'l', '2018-01-20 17:17:45', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', null, '0', null, '0', 'c3f8bafc39fa4f499184bd50647e7e2c', '1');
INSERT INTO `box_comment` VALUES ('3e2e095a-7132-4f67-9bd9-22b3443a4411', '是', '2018-01-20 09:39:45', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'aa92a03a-505e-415f-bc57-03b2b5b2d12c', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('3f5112cf-64d8-4310-a0eb-e6a62e1b1827', '测试回复评论', '2018-01-18 14:13:17', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ec88b355-037d-4de3-80b8-91b4f66274e2', '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('429b444a-05f6-4d44-8309-021eaad4441c', '2', '2018-01-18 16:55:31', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '1010177543954128afcef296b2cb6336', '1');
INSERT INTO `box_comment` VALUES ('433454ad-19bf-4f5f-8e0f-31da13d8341d', '啊', '2018-01-19 09:05:28', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '18d9b49a830c456dabde748d843ed416', '1');
INSERT INTO `box_comment` VALUES ('456eda1b-158f-4c71-bc08-b9907ce44a68', '从发件列表中操作回复', '2018-01-19 14:35:56', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('47ddc20d-75ea-44fe-9c05-a2d305207fae', 'adfsafdsaf', '2018-01-31 10:34:15', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '9c86319a-d99e-4713-a7fa-ddf067894c5c', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('492192f1-be8f-431c-8235-41bbc4a8a549', '回复这个试试', '2018-01-18 14:21:53', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '0cf5eb97-1e2f-42e4-9a08-71119c42f682', '3', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('50b4eb04-baea-4d30-9d89-a2184cc479eb', 'dsa2dsc', '2018-01-31 10:34:08', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', null, '1', null, '0', '24e3c8bdb8aa4a988f0140b3d9d60c6c', '1');
INSERT INTO `box_comment` VALUES ('50e6760d-56b7-41f2-be4e-8c0ea6f5e5fa', '2', '2018-01-24 14:54:29', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('520e2c13-bf59-4aec-962b-5c945bd52fbc', '天气好吗', '2018-01-18 14:19:56', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ec88b355-037d-4de3-80b8-91b4f66274e2', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('5c237473-4602-4ead-95a5-d24d97d91364', '测试', '2018-01-18 16:13:58', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'cecf2088-8ba9-4928-9578-9fe0fe9cf91a', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('5dd7224c-98ac-4b8a-9274-eb001842050f', '123', '2018-01-18 15:18:22', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('61098505-ebb9-4dd4-9066-c6c1d31019df', 'p;pp;p;', '2018-01-20 17:31:29', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', null, '0', null, '0', '3a00e49ed46f42f3a2af1836ed9103d9', '1');
INSERT INTO `box_comment` VALUES ('63f2b453-9a60-4044-9adf-e6c2fb70bb16', '啊啊', '2018-01-19 09:05:36', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '433454ad-19bf-4f5f-8e0f-31da13d8341d', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('6cee156b-0148-43f0-92e2-d5e368a02cea', 'dssddssdds', '2018-02-01 17:35:01', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '5ae39c03921e4fb68ff4f02f1763e57f', '1');
INSERT INTO `box_comment` VALUES ('70955ed9-fac9-46e0-ab08-f0a5f95c8cca', '测试收件列表操作回复', '2018-01-19 11:18:42', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '8c0f07dd06c64b5b9b677e83e317ad01', '1');
INSERT INTO `box_comment` VALUES ('767ae8fc-1341-428d-85bb-06991a0a14e2', '213', '2018-01-18 18:31:53', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'b8e90ed7-aa45-455a-a71a-55e11d34cd31', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('7c074b57-47d7-47f6-8559-4908b2b8244f', '2', '2018-01-24 14:54:09', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('7ff94f1e-d8b3-499b-aa48-f767c7ce330d', '新增一条回复', '2018-01-18 15:54:23', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '1010177543954128afcef296b2cb6336', '1');
INSERT INTO `box_comment` VALUES ('823c4d33-f2f5-4a48-9463-4b06cc6480bf', 'p;op', '2018-01-20 17:19:11', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', null, '0', null, '0', 'c77df5723c8341fa84b6f72f41041ce6', '1');
INSERT INTO `box_comment` VALUES ('89c0c2f3-09ad-4386-a026-a49375c8bb30', '没问题', '2018-01-18 14:22:04', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f1faea99-2ad5-4490-9d2e-5c374b2a9258', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('8c15d536-29d9-411e-90a4-4d4fb712821a', '喜马拉雅山的举手', '2018-01-24 15:53:43', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'd3974e87aa6445a1bb6f014a3a52d56e', '1');
INSERT INTO `box_comment` VALUES ('94421215-ee94-44e6-bdbe-0b68e460e47c', '测试从收件列表操作回复', '2018-01-19 11:20:48', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '8c0f07dd06c64b5b9b677e83e317ad01', '1');
INSERT INTO `box_comment` VALUES ('9924e2da-09d4-4539-8e89-c686d5f2913c', '测试回复5', '2018-01-18 14:13:06', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('9a4292ea-f869-431d-bbdb-03b8cd5402d9', '测试回复3', '2018-01-18 13:56:07', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('9c7ee27a-6c5a-44a7-8f9a-b31652a35665', '345', '2018-01-24 15:05:33', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f6a25c72-ea7a-46af-9675-69201418344b', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('9c86319a-d99e-4713-a7fa-ddf067894c5c', 'asf', '2018-01-31 10:30:29', 'safd383028dfasfdsa038829083902fdsajkfd', 'linsheng', null, '5', null, '0', '24e3c8bdb8aa4a988f0140b3d9d60c6c', '1');
INSERT INTO `box_comment` VALUES ('9d28ca64-cef8-4bcb-9949-3d52067ffa1b', 'ddsds', '2018-02-01 17:35:05', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '5ae39c03921e4fb68ff4f02f1763e57f', '1');
INSERT INTO `box_comment` VALUES ('9e2c2ffa-06f4-42e6-b905-753567fa61f1', '9898', '2018-01-31 15:14:01', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '1', null, '0', '94825402dc2e414a947d1e8b1e396374', '1');
INSERT INTO `box_comment` VALUES ('9f05e8db-b41c-421b-a4fb-07e5d8180b63', '1', '2018-01-23 10:22:51', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'e18b850ac1a2403cb87cfe4c0b028eda', '1');
INSERT INTO `box_comment` VALUES ('a2a99cf6-1768-4f8e-b62f-faad1353d5ff', '真的吗', '2018-01-18 15:18:00', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ec88b355-037d-4de3-80b8-91b4f66274e2', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('a88732b2-a0bf-4078-a44c-e39135a58e15', '真的吗', '2018-01-24 15:03:41', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'ea77b2fb4e1348a9b045d13ab6f998e9', '1');
INSERT INTO `box_comment` VALUES ('a9d93cf1-50d6-4d69-b784-6f25b632acf6', '测试', '2018-01-18 18:15:41', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ec88b355-037d-4de3-80b8-91b4f66274e2', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('aa92a03a-505e-415f-bc57-03b2b5b2d12c', '我', '2018-01-20 09:39:33', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '31c09a9e42634d4a8eb6bd90e721c0a2', '1');
INSERT INTO `box_comment` VALUES ('b3bde1e9-9552-4b2a-9786-10d955d7f974', '123', '2018-01-30 15:23:15', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '012cd6a6-318c-470e-b80c-2f7ba8d8dcfb', '1', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('b4ad5645-8c2a-444d-a66e-8f7dd50a2b2c', 'submitCommentLoading', '2018-01-19 11:22:46', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '8c0f07dd06c64b5b9b677e83e317ad01', '1');
INSERT INTO `box_comment` VALUES ('b63363f3-9f24-4d18-9a91-cdf71aa18f5a', '123', '2018-01-24 14:23:36', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'b8e90ed7-aa45-455a-a71a-55e11d34cd31', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('b8e90ed7-aa45-455a-a71a-55e11d34cd31', '23万', '2018-01-18 18:31:48', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'c599dd673915465a8bfe8c2d33cbd866', '1');
INSERT INTO `box_comment` VALUES ('bab48c49-1e12-4acf-982b-d04ace416b97', '4694464', '2018-01-31 15:13:16', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '3cb1c2977476478c829ac4dc9f6daaa1', '1');
INSERT INTO `box_comment` VALUES ('bc74e548-e0ca-4ede-bc1f-bbfb264da405', 'xdcx', '2018-01-31 10:34:20', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '50b4eb04-baea-4d30-9d89-a2184cc479eb', '22', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('bf316386-5529-4528-8693-5218cf3ffbbf', 'lastOrNextBox = goNum => (         () => {             const { detailData: { id }, history: { push } } = this.props;             this.fetchDetail(id, goNum)                 .then(id => {                     if (typeof id === \'string\') push(id);                 });         }     )', '2018-01-24 15:26:39', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '1', null, '0', 'ed051c2e099741489f54a58ee69a17cf', '1');
INSERT INTO `box_comment` VALUES ('c9cba346-d7d1-4af8-9d9e-4d4ce37b4146', 'qqqqqq', '2018-01-19 11:40:01', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '8c0f07dd06c64b5b9b677e83e317ad01', '1');
INSERT INTO `box_comment` VALUES ('ce65b4e9-da97-4a8a-9110-2f32883c2efe', 'dcw', '2018-01-31 10:30:36', 'safd383028dfasfdsa038829083902fdsajkfd', 'linsheng', null, '0', null, '0', '24e3c8bdb8aa4a988f0140b3d9d60c6c', '1');
INSERT INTO `box_comment` VALUES ('cecf2088-8ba9-4928-9578-9fe0fe9cf91a', '新增一条回复', '2018-01-18 15:54:21', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '1010177543954128afcef296b2cb6336', '1');
INSERT INTO `box_comment` VALUES ('d135eef9-2017-4d00-a9f6-91a0837daced', '测试回复4', '2018-01-18 13:59:50', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('d2fede6c-9cfd-43ca-a317-86df1d492771', '问问问问饿我', '2018-01-31 16:35:34', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', null, '0', null, '0', '2d0b280b939d4a08b470619016d3cf2f', '1');
INSERT INTO `box_comment` VALUES ('d5617e5f-5bd5-48ab-9e6d-6a2e183e1b31', '真的吗 ', '2018-01-24 15:25:00', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '6bf2827fa9d74c8086609ee295ae6895', '1');
INSERT INTO `box_comment` VALUES ('d98f24e0-2049-4ef0-933f-30c10ea75ee9', '吃了没', '2018-01-18 14:14:33', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ec88b355-037d-4de3-80b8-91b4f66274e2', '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('e21e5957-7d33-4dd6-9240-c59c5ecaea5f', '321', '2018-01-24 14:56:09', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'c599dd673915465a8bfe8c2d33cbd866', '1');
INSERT INTO `box_comment` VALUES ('ea981650-f0f2-4909-a87e-10d7c43a5a98', 'www', '2018-01-24 10:08:17', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '055188e4b60e482bb06349c2e701b5a4', '1');
INSERT INTO `box_comment` VALUES ('eb217101-e104-4212-871e-c03c2d518830', '不好', '2018-01-18 14:50:29', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ec88b355-037d-4de3-80b8-91b4f66274e2', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('ec88b355-037d-4de3-80b8-91b4f66274e2', '新增回复内容', '2018-01-17 18:11:50', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '3', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('ee017140-8eb5-4f67-92d3-bb03139672e1', '1', '2018-01-24 14:55:26', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '009f2531-1391-4078-98da-533de109bff8', '0', null, '0', null, '1');
INSERT INTO `box_comment` VALUES ('ef8c97cf-3098-4b8c-8c49-4975d3a76f93', '没什么问题', '2018-01-19 14:36:01', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('f1faea99-2ad5-4490-9d2e-5c374b2a9258', '测试回复2', '2018-01-18 13:53:42', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('f31f98ea-73dd-450d-8e88-844646985b82', '23', '2018-01-24 14:54:45', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('f4773f2b-cf55-4659-acde-6139d6367f42', '真的假的', '2018-01-24 15:04:59', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'ea77b2fb4e1348a9b045d13ab6f998e9', '1');
INSERT INTO `box_comment` VALUES ('f6a25c72-ea7a-46af-9675-69201418344b', '123', '2018-01-24 15:03:04', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', 'ea77b2fb4e1348a9b045d13ab6f998e9', '1');
INSERT INTO `box_comment` VALUES ('faf08f0c-6b78-493e-badb-d7b438f85480', '1', '2018-01-24 14:54:01', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '0aadc19f49374982871fb57860e73d15', '1');
INSERT INTO `box_comment` VALUES ('fcaf39f0-e2e6-4ef5-a826-e8a91efec970', 'submitCommentLoading', '2018-01-19 11:22:46', '6c0f3e926f06446781f9dc013faf75c7', 'admin', null, '0', null, '0', '8c0f07dd06c64b5b9b677e83e317ad01', '1');

-- ----------------------------
-- Table structure for `box_content`
-- ----------------------------
DROP TABLE IF EXISTS `box_content`;
CREATE TABLE `box_content` (
  `id` varchar(64) NOT NULL,
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `end_date` datetime DEFAULT NULL COMMENT '截止日期',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` int(11) DEFAULT NULL COMMENT '0未开始1正在进行2已完成',
  `type` int(11) DEFAULT NULL COMMENT '类型 1签收材料 2报告  3填表汇总 4下发数据 5问卷调查',
  `create_user` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `number` int(11) DEFAULT NULL,
  `spread` int(11) DEFAULT NULL,
  `auto_sign` int(11) DEFAULT NULL COMMENT '1为开启开封自动签收，0为关闭',
  `operate` varchar(64) DEFAULT NULL COMMENT '“add”新增，"update"修订，"delete"删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收发主体表';

-- ----------------------------
-- Records of box_content
-- ----------------------------
INSERT INTO `box_content` VALUES ('008c09b2db7b48169f8e84239d9e6ba8', '填表汇总-0130zy', '2018-02-04 10:47:51', null, '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:47:46', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('0112ff6d801f4522ba854b2b054412fa', '下发数据第24次测试', '2018-01-31 16:21:14', '<h2  style=\'text-align:center;\'>下发数据第24次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:21:11', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('024606e102e74d5e9b9ac4086ec2a8da', 'dsafdaf', '2018-02-04 16:09:46', '<p >dfsafdsafdsaf</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:09:47', null, null, '32', '0', null, null, null);
INSERT INTO `box_content` VALUES ('02529acb13c04d85a69b719237a398be', '填表汇总第1986次测试', '2018-02-05 10:25:40', '<p >填表汇总第1986次测试</p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:25:43', null, null, '33', '0', null, null, null);
INSERT INTO `box_content` VALUES ('04adf1158de34b968a2dbb58246e6a03', 'asd ', '2018-02-04 14:55:30', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 14:55:24', null, null, '32', '1', null, null, null);
INSERT INTO `box_content` VALUES ('04ee8cb7890c4a4c9b6ca5a5d23b1d08', '收报告第732次测试', '2018-02-03 17:26:35', '<h2  style=\'text-align:center;\'>收报告第732次测试</h2>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:26:30', null, null, null, '0', '1', null, null);
INSERT INTO `box_content` VALUES ('055188e4b60e482bb06349c2e701b5a4', 'eee', '2018-01-25 16:01:44', '<p >erererer</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 16:01:57', null, null, null, '8', null, null, null);
INSERT INTO `box_content` VALUES ('05dc6a5e69db4487b8e038ccef01ffc4', '签收材料第896次测试', '2018-02-04 09:36:08', '<h2  style=\'text-align:center;\'>签收材料第896次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:36:44', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('066bc75862be4424892a75805e85ecb4', 'asdf ', '2018-01-28 16:03:30', '<p ><br></p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:03:25', null, null, '27', '5', null, null, null);
INSERT INTO `box_content` VALUES ('06ecfdbcb11642cd99d06d4f2ea3aee1', '士大夫', '2018-01-24 15:49:50', '<p >阿斯蒂芬</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 15:50:01', null, null, '2', '7', null, null, null);
INSERT INTO `box_content` VALUES ('0aadc19f49374982871fb57860e73d15', '填表汇总第1024次测试', '2018-01-20 18:29:06', '<h2  style=\'text-align:center;\'>填表汇总第1024次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 18:11:04', null, null, '20', '12', null, null, null);
INSERT INTO `box_content` VALUES ('0c181bd3b4de4202aa9f8d1afb5d2d36', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 17:40:36', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('0e75147b7d3d488485646b271653f3e4', '问卷调查第1889次测试', '2018-02-05 17:07:56', '<p >问卷调查第1889次测试</p>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 17:07:55', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('1010177543954128afcef296b2cb6336', '问卷调查第1次测试', '2018-01-23 09:21:30', '<p  style=\'text-align:center;\'>问卷调查第1次测试</p>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 09:21:28', null, null, '5', null, null, null, null);
INSERT INTO `box_content` VALUES ('104e53f6cfd54049901c91ea7705c18d', '签收材料第912次测试', '2018-01-27 13:57:20', '<ul>\n  <li  style=\'text-align:center;\'>签收材料第912次测试</li>\n</ul>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 13:57:19', null, null, null, '1', '0', '0', '');
INSERT INTO `box_content` VALUES ('11bf79240f9d43b2bf68b7ef58ec2ab3', '下发数据第27次测试', '2018-01-31 16:37:04', '<h2  style=\'text-align:center;\'>下发数据第27次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:37:27', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('14223a92132c4853988d48b44dff99a8', '问卷调查第1524次测试', '2018-02-01 18:29:37', '<h2  style=\'text-align:center;\'>问卷调查第1524次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:29:30', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('14267b7a97c848f0a798df7f960d8a9f', 'zhaoyang0129', '2018-02-03 19:02:26', '<p >adf</p>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:02:19', null, null, null, '0', '0', null, null);
INSERT INTO `box_content` VALUES ('15ec6c44c2da4a8282206bdd69ad89bb', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 15:37:51', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('18d9b49a830c456dabde748d843ed416', '签收材料第2次测试', '2018-01-25 14:47:26', '<h2  style=\'text-align:center;\'>签收材料第2次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:50:58', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('192bdfa3b40f4d4887640948d6952b78', 'zhao', '2018-02-01 17:27:20', '<p >adf</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:27:16', null, null, '29', '0', null, null, null);
INSERT INTO `box_content` VALUES ('19a77c3ff2f144628dc056278d898001', '签收材料第902次测试', '2018-02-04 09:40:41', '<h2  style=\'text-align:center;\'>签收材料第902次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:40:38', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('1b6388ab1a574474accd7a0552ddcfff', '填表汇总第897次测试设置必填项', '2018-01-27 15:04:33', '<h3  style=\'text-align:center;\'>填表汇总第897次测试设置必填项</h3>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-25 15:08:40', null, null, '23', null, null, null, null);
INSERT INTO `box_content` VALUES ('1c4c253dba83496f9c0541f6fcceddaf', 'aavv', '2018-02-05 14:17:25', '<p >aa</p>', '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:17:24', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('2175666d708b4dc9bf3a3b8526abb98b', 'asdf ', '2018-02-04 09:53:19', '<p >asdf</p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:53:12', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('231c5bc0047044a38992bf72b8d13fb7', 'zhaoyang0130-3', '2018-02-03 19:13:19', '<p >asdf&nbsp;</p>', '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:13:16', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('24439695880c44f78458c1b3dcc83978', 'ererreer', '2018-01-25 16:03:15', '<p >fdffddfdf</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 16:03:21', null, null, '2', null, null, null, null);
INSERT INTO `box_content` VALUES ('24e3c8bdb8aa4a988f0140b3d9d60c6c', '1111', '2018-02-05 10:28:55', '<p >111</p>', '2', '1', 'safd383028dfasfdsa038829083902fdsajkfd', '2018-01-31 10:28:52', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('276ff70432564aaaac683fb66f2655b5', 'asd', '2018-02-05 14:10:23', '<p >asd</p>', '0', '1', '85df829495494a208d94cd64efe2d953', '2018-01-31 14:10:23', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('278c5e783388472eaa64faa606a1cdc5', '签收材料第852次测试', '2018-02-05 11:01:14', '<h2  style=\'text-align:center;\'>签收材料第852次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:01:14', null, null, null, '1', '1', '1', '');
INSERT INTO `box_content` VALUES ('27e2b82e10b44f4cabe24f7b315b1503', 'cccccc', '2018-02-04 16:13:31', '<p ><br></p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:13:25', null, null, null, '2', '0', '0', '');
INSERT INTO `box_content` VALUES ('285be4cdfd6c47cda043abf717913dda', '填表汇总第1298次测试', '2018-01-27 15:57:10', '<h2  style=\'text-align:center;\'>填表汇总第1298次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 15:57:07', null, null, '22', '1', null, null, null);
INSERT INTO `box_content` VALUES ('2991b304ecca41c9bde0ceb22a2cc6fd', 'cddd', '2018-02-05 14:12:13', '<p >aa</p>', '0', '1', 'f977c3d92de04d8f84270a20614e3b18', '2018-01-31 14:12:13', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('2b59f373760a48cabff49734cc74bdad', '收报告第1次测试', '2018-01-23 09:19:51', '<ul>\n  <li  style=\'text-align:center;\'>收报告第1次测试</li>\n</ul>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 09:19:51', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('2c977c62ebf94c709e607e95b56f17ab', '收报告第286次测试', '2018-02-01 17:02:17', '<h2  style=\'text-align:center;\'>收报告第286次测试</h2>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:02:14', null, null, null, '0', '1', null, null);
INSERT INTO `box_content` VALUES ('2d0b280b939d4a08b470619016d3cf2f', '1652', '2018-02-05 16:35:16', '<p >3232233232323</p>', '0', '2', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 16:35:15', null, null, null, '1', '0', null, null);
INSERT INTO `box_content` VALUES ('2e9fab2aa6184ac39dc5774944e76d9c', '问卷调查第1907次测试', '2018-02-06 17:46:53', '<h2  style=\'text-align:center;\'>问卷调查第1907次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 17:46:53', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('2f0e421b5f5744afaa029cd79133086c', '签收材料第68次测试', '2018-01-24 18:18:52', '<h2  style=\'text-align:center;\'>签收材料第68次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:18:52', null, null, null, null, '1', null, null);
INSERT INTO `box_content` VALUES ('2fa5a25f4f044adaaca39b3376fae015', '129zy', '2018-02-03 10:32:16', '<p >SA</p>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-29 20:29:43', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('30d35f56ff5d474c96a785f908898e49', '问卷调查第891次测试', '2018-01-28 16:11:33', '<h1 >问卷调查第891次测试</h1>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:11:31', null, null, '5', '1', '0', null, null);
INSERT INTO `box_content` VALUES ('31c09a9e42634d4a8eb6bd90e721c0a2', '填表汇总第88次测试', '2018-01-25 09:01:08', '<ul>\n  <li  style=\'text-align:center;\'>填表汇总第88次测试</li>\n</ul>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 09:01:05', null, null, '22', null, null, null, null);
INSERT INTO `box_content` VALUES ('322500f1a8984b9d80a2950ebcddb84a', '签收材料第324次测试', '2018-01-28 15:25:43', '<h2  style=\'text-align:center;\'>签收材料第324次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:38:42', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('33046447f45a44eab52fae5f8cda69ab', '签收材料第324次测试', '2018-01-28 15:25:43', '<h2  style=\'text-align:center;\'>签收材料第324次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:28:17', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('3539d2c9999b478ab672fefbd4e47381', '签收材料第67次测试', '2018-01-24 18:10:48', '<h2  style=\'text-align:right;\'>签收材料第67次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:14:15', null, null, null, null, '1', null, null);
INSERT INTO `box_content` VALUES ('3718ccd53786409f87917727dc691ccb', '传阅第1001次测试暂存到草稿箱', '2018-02-06 18:00:48', '<h2  style=\'text-align:center;\'>传阅第1001次测试暂存到草稿箱</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 18:02:39', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('378a606a6cc14415a4568a9e92752497', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 16:03:47', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('37d46a02466242a4adcd8cb5a260b65e', '下发数据第73次测试', '2018-02-03 14:11:57', '<h2  style=\'text-align:center;\'>下发数据第73次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 14:12:13', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('3a00e49ed46f42f3a2af1836ed9103d9', '[[[[[', '2018-01-23 17:32:08', '<p >[[</p>', '0', '5', '8a6fea61aee249848261dd684b7f8460', '2018-01-20 17:31:14', null, null, '5', null, '0', null, null);
INSERT INTO `box_content` VALUES ('3abd322d6c9e464685baab38bca28af5', 'aet', '2018-02-05 13:19:49', '<p >asfas</p>', '0', '2', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:19:51', null, null, null, '0', '0', null, null);
INSERT INTO `box_content` VALUES ('3cb1c2977476478c829ac4dc9f6daaa1', 'aaa', '2018-02-04 16:11:32', '<p ><br></p>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:11:27', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('40153f69dc6b44208ee54946c8e04930', '填表汇总第1608次测试', '2018-02-01 15:51:56', '<h2  style=\'text-align:center;\'>填表汇总第1608次测试</h2>', '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 15:51:55', null, null, '29', '0', null, null, null);
INSERT INTO `box_content` VALUES ('4098ebf6220d4293854f527b963b7910', 'asdf ', '2018-02-04 14:42:19', '<p ><br></p>', '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 14:42:13', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('40dc65d131d84e3b80219a02fe966c27', '昭', '2018-01-24 15:40:48', '<p >第三方</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 15:41:14', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('41b5d540060a402889d86d5abee22e7e', '测试重复发生', '2018-01-27 17:24:30', '<p  style=\'text-align:center;\'>测试重复发生</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:24:31', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('4409579659a540a8a49629bd6c6e43fe', '000', '2018-02-06 14:02:06', '<p ><br></p>', '0', '5', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-02-01 14:02:05', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('4466b1dbe3d1434cab6b8c3cb48b8988', '签收材料第769次测试设置值提交', '2018-01-27 10:09:13', '<h2  style=\'text-align:center;\'>签收材料第769次测试设置值提交</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:09:12', null, null, null, null, '1', '1', 'update,delete');
INSERT INTO `box_content` VALUES ('4623ab5935434c55b9458871a8a9181f', 'ad', '2018-02-04 10:18:41', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:18:36', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('4691d19717194e6381c9c8c98179fc1e', '问卷调查第1908次测试', '2018-02-05 10:13:32', '<h2  style=\'text-align:center;\'>问卷调查第1908次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:13:34', null, null, '5', '1', '0', null, null);
INSERT INTO `box_content` VALUES ('46fd9e80456a4325b09278ac10822ce6', 'sdfgsd', '2018-02-05 13:16:41', null, '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:16:48', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('47aa7ac3db384393b16e59334d743c52', '下发数据第42次测试', '2018-02-01 16:29:29', '<h2  style=\'text-align:center;\'>下发数据第42次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:29:23', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('48f034b84a77439192e3d383d767767c', 'zhongji测试2', '2018-02-04 11:12:26', '<p ><br></p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:12:21', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('49907faae92d4d7baf9083d45f08b312', '李四', '2018-02-05 14:57:59', '<p >李四</p>', '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:57:58', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('4b8e9f81f2dc404092cf18050655d3a2', '下发数据第93次测试', '2018-02-03 15:42:22', '<h2  style=\'text-align:center;\'>下发数据第93次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 15:42:24', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('4f5bac38ac134d3ca61dfdd3cdb45265', '填表汇总1812次测试', '2018-02-04 14:45:30', '<h2  style=\'text-align:center;\'>填表汇总1812次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 14:45:23', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('4fef97409d3847beb819f2402095ff6e', 'yuuu', '2018-02-05 13:24:26', '<p >asf</p>', '0', '4', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:24:55', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('4ff9d4a53203413a84eef67ca771dd28', '999', '2018-02-04 09:45:56', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:45:52', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('51603e06481b46d7bbf460cb00ba6d43', '收报告第298次测试', '2018-02-01 18:20:37', '<h2  style=\'text-align:center;\'>收报告第298次测试</h2>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:20:31', null, null, null, '0', '1', null, null);
INSERT INTO `box_content` VALUES ('522837a85423435aa8b12ce9bb415d90', 'chuji测试', '2018-02-04 11:42:10', '<p >啊</p>', '2', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:42:08', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('52f5691102cd4a4db9a2b76989f6e51f', 'ds', '2018-02-04 09:57:15', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:57:09', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('53c0f5d6b02c47c18c0b3f8114c13482', '收报告第297次测试', '2018-01-25 10:16:00', '<h2  style=\'text-align:center;\'>收报告第297次测试</h2>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 10:15:57', null, null, null, null, '1', null, null);
INSERT INTO `box_content` VALUES ('54732f307b6c47cab57f3f428955656f', '下发数据第41次测试', '2018-02-01 13:56:03', '<h2  style=\'text-align:center;\'>下发数据第41次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 13:55:58', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('54e3bb7621bb423ebf2be41900fd6d35', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 08:54:10', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('57950932014e4003873fc2bc8032662a', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 08:46:38', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('57e09261239b4cdd9815bed0aabc1f1c', '签收材料第324次测试', '2018-01-28 15:25:43', '<h2  style=\'text-align:center;\'>签收材料第324次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:39:05', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('585db057707c4bb0a06d450822245db1', '1111', '2018-02-01 10:57:37', null, '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 10:59:06', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('5aadba772e2e45e0ad2352cb038e67dc', 'sdf', '2018-02-04 09:49:38', null, '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:49:32', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('5ad9edd1f2cb4f0ab6f3df885e0a79ed', '问卷调查第2011次测试', '2018-02-05 14:11:04', '<h2  style=\'text-align:center;\'>问卷调查第2011次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 14:11:07', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('5ae39c03921e4fb68ff4f02f1763e57f', '99', '2018-02-06 17:34:26', '<p >eddssddssdsd</p>', '1', '1', '4dea9acd67954ea6a0753e339b03ba7d', '2018-02-01 17:34:27', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('5b038fbbde2f497fb72fe500102dc292', 'bbcc', '2018-02-05 14:24:37', '<p >aa</p>', '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:24:41', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('5b5877bba7d84e7aaa4940d4e43f15d2', '下发数据第86次测试', '2018-02-03 15:14:56', '<h2  style=\'text-align:center;\'>下发数据第86次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 15:17:01', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('5b7834cb032847c48a425e2855b3e1c6', '问卷调查第1226次测试', '2018-02-03 16:12:52', '<h2  style=\'text-align:center;\'>问卷调查第1226次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:12:49', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('5b7acaa6e9b9410bb1e1a5baf2afa392', '下发数据第366次测试', '2018-02-04 17:02:44', '<h1  style=\'text-align:center;\'>下发数据第366次测试</h1>', '2', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:03:06', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('5cd819bc40d0494e81a06c1c291e1cd0', '签收材料第529次测试', '2018-02-01 18:03:47', '<h2  style=\'text-align:center;\'>签收材料第529次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:03:41', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('5fb25edb52ee45c9bc53ebabe75d3cc3', '填表汇总第1723次测试', '2018-02-03 16:00:34', '<h2  style=\'text-align:center;\'>填表汇总第1723次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:03:31', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('61b92a1c56e044589ab382fc0539c3b4', 'ds ', '2018-01-28 15:48:34', '<p >das</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:48:31', null, null, null, '1', '1', '1', null);
INSERT INTO `box_content` VALUES ('6214b7ee04ed4c9c8ba2297498c04d28', '0122zy', '2018-01-27 10:04:56', '<p >ad&nbsp;</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:04:46', null, null, '22', null, null, null, null);
INSERT INTO `box_content` VALUES ('6245d71bcbc04ede85d35a554bd03d29', '填表汇总第1462次测试', '2018-01-28 16:10:32', '<h2  style=\'text-align:center;\'>填表汇总第1462次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:10:27', null, null, '28', '3', null, null, null);
INSERT INTO `box_content` VALUES ('624b0f0db81d4cdaae2f4608b798d069', '下发数据第52次测试', '2018-02-03 10:09:01', '<h2  style=\'text-align:center;\'>下发数据第52次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-29 20:06:34', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('6299bc217cd648588a34b7a1d1c7b72e', '下发数据第86次测试', '2018-02-03 15:14:56', '<h2  style=\'text-align:center;\'>下发数据第86次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 15:17:20', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('62ed3ffd4d9b4c4d9dc3558c4a3bd4c1', 'zy-填表汇总-0130', '2018-02-03 19:18:53', '<p >阿斯蒂芬</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:18:44', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('672f11000229409f85a2e95ecfbab441', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 08:54:33', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('68800675a5e740ca8ef5c03bf094517e', '签收材料第324次测试', '2018-01-28 15:25:43', '<h2  style=\'text-align:center;\'>签收材料第324次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:38:38', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('69f0d4a2475e44da816c11de64138493', 'bbbbb', '2018-02-04 16:12:13', '<p >d&nbsp;</p>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:12:30', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('6b0bcda9892e4cadaa6fb3404a896a00', 'cccx', '2018-02-04 21:16:26', null, '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-30 21:16:25', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('6bf2827fa9d74c8086609ee295ae6895', '填表汇总第1408次测试', '2018-01-29 10:55:51', '<h1  style=\'text-align:center;\'>填表汇总第1408次测试</h1>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-24 10:55:46', null, null, '29', '0', null, null, null);
INSERT INTO `box_content` VALUES ('6c11191e3200490c84a70bd543948ea4', '签收材料第66次测试', '2018-01-24 17:53:39', '<h2  style=\'text-align:center;\'>签收材料第66次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:06:42', null, null, null, null, '1', null, null);
INSERT INTO `box_content` VALUES ('72a30e3b9e3b43a6ad21bf8b8d9a519f', '32323232', '2018-02-05 14:59:53', '<p >3232323232</p>', '1', '2', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 14:59:53', null, null, null, '1', '0', null, null);
INSERT INTO `box_content` VALUES ('7363fad3490d4ae18487c06ad9244fcd', '问卷调查第1906次测试', '2018-02-05 10:10:52', '<h2  style=\'text-align:center;\'>问卷调查第1906次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:10:58', null, null, '5', '1', '0', null, null);
INSERT INTO `box_content` VALUES ('7414462812f4423686639b42fcb56396', '问卷调查第916次测试设置必填项', '2018-01-28 16:54:49', '<ul>\n  <li >问卷调查第916次测试设置必填项</li>\n</ul>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:54:43', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('74a23b593b514d56870df8e04d61ba77', '下发数据第52次测试', '2018-02-03 10:09:01', '<h2  style=\'text-align:center;\'>下发数据第52次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-29 20:06:23', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('74e2146f25774cc096b1afa00db4c36c', 'asdf ', '2018-02-04 09:47:54', '<p >asdf</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:47:49', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('75c0a87059ec48449159c1fbc983d64a', '签收材料第1126次测试', '2018-02-04 16:10:56', '<h2  style=\'text-align:center;\'>签收材料第1126次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:11:10', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('77262fb3438c4caf9e27b5fe429a9e82', '填表汇总第1424次测试', '2018-01-28 15:50:26', '<h2  style=\'text-align:center;\'>填表汇总第1424次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:50:20', null, null, '25', '0', null, null, null);
INSERT INTO `box_content` VALUES ('77c5f43d06b947c190ef753de1671a70', '填表汇总第1436次测试', '2018-01-28 15:57:43', '<h2  style=\'text-align:center;\'>填表汇总第1436次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:57:37', null, null, '27', '0', null, null, null);
INSERT INTO `box_content` VALUES ('792b853da83247ec96b2c6d1e32a8ea4', '填表汇总第1786次测试', '2018-02-04 10:09:22', '<h2  style=\'text-align:center;\'>填表汇总第1786次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:09:21', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('7963fbfcaf2e409f9bc980ab80efc45e', '下发数据第24次测试', '2018-01-31 16:15:19', '<h2  style=\'text-align:center;\'>下发数据第24次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:15:19', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('7cf1c03b682248d8b892dfb1bbeda701', '55555', '2018-02-05 16:40:00', '<p >555555</p>', '1', '4', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 16:40:27', null, null, null, '3', null, null, null);
INSERT INTO `box_content` VALUES ('7d33aa2eefec48709bf0d35ae895be81', '填表汇总第897次测试设置必填项', '2018-01-27 15:04:33', '<h3  style=\'text-align:center;\'>填表汇总第897次测试设置必填项</h3>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-25 15:09:34', null, null, '23', null, null, null, null);
INSERT INTO `box_content` VALUES ('804af4f5a7c8419eb706502a7a74bb6b', '下发数据第27次测试', '2018-01-31 16:37:04', '<h2  style=\'text-align:center;\'>下发数据第27次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:39:17', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('81ae2cb3d98f406eadc8532f22d43112', '下发数据第27次测试', '2018-01-31 16:37:04', '<h2  style=\'text-align:center;\'>下发数据第27次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:37:11', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('823998b8d54a4ec2b5e38d8804886d86', '0130-biao', '2018-02-04 09:42:49', '<p >ds&nbsp;</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:42:43', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('8253262e5d564b1cbc34517e194aaef5', '问卷调查第1552次测试', '2018-02-04 18:34:15', '<p >{\'问卷调查第1552次测试\'.split().reverse().join(\'\')}</p>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 18:34:13', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('8357937d22574fdfae1b8758ce698718', '问卷调查第1627次测试', '2018-02-05 09:48:03', '<h2  style=\'text-align:center;\'>问卷调查第1627次测试</h2>', '1', '5', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 09:48:03', null, null, '5', '1', '0', null, null);
INSERT INTO `box_content` VALUES ('8462d7ff9e4349f1a68ba9489548d4e5', '填表汇总0118', '2018-01-23 09:54:16', '<p >提交</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 09:54:21', null, null, '2', null, null, null, null);
INSERT INTO `box_content` VALUES ('84a48e32e91340679e96a9017d0eab7c', 'aabb', '2018-02-05 14:11:14', '<p >aa</p>', '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:11:14', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('84f5a249f00e45e3bb8714e3a637c461', '签收材料第1099次测试', '2018-02-06 17:41:04', '<h2  style=\'text-align:center;\'>签收材料第1099次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 17:41:05', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('854bfe9f300447538d87357dc95299f8', 'ddl', '2018-01-28 11:16:37', null, '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 11:18:09', null, null, '23', null, null, null, null);
INSERT INTO `box_content` VALUES ('880b685139254b558c33163f3373bbdf', '0130zhao-tian', '2018-02-04 09:35:45', '<p >asdf&nbsp;</p>', '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:35:53', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('88406a7d10694f33843ef212a20d6ba9', '卧槽', '2018-02-05 14:09:30', '<p >卧槽</p>', '2', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:09:33', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('88d89a4597e240c3b8f17d05d996f956', '签收材料第324次测试', '2018-01-28 15:25:43', '<h2  style=\'text-align:center;\'>签收材料第324次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:38:41', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('8a64c6a9e93f4b4e9c29d067071a9d17', 'zhongjiwudi 测试1', '2018-02-04 11:20:47', '<p ><br></p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:20:40', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('8c055a1e3da94e499d0b1f0565455b94', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 15:58:09', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('8c0f07dd06c64b5b9b677e83e317ad01', '签收材料测试数据', '2018-01-23 17:43:10', '<h3  style=\'text-align:center;\'>签收材料测试数据</h3>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:43:08', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('8dd7f6c8aa414b5db2beac000fd1cec8', '问卷调查第1229次测试', '2018-02-04 10:42:19', '<h2  style=\'text-align:center;\'>问卷调查第1229次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:42:16', null, null, '5', '2', '1', null, null);
INSERT INTO `box_content` VALUES ('9267268f2d85409183c222a6aeafd143', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 09:16:54', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('941245023700467a9b59f8f49dc0fb07', 'asdf', '2018-02-04 09:49:15', '<p >asdf</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:49:08', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('94825402dc2e414a947d1e8b1e396374', '收报告第821次测试', '2018-02-04 16:12:45', '<h2  style=\'text-align:center;\'>收报告第821次测试</h2>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:12:39', null, null, null, '1', '1', null, null);
INSERT INTO `box_content` VALUES ('95aa0c8f2bba4a74ab24b48d237f7ff7', '填表汇总第1432次测试', '2018-01-28 15:52:56', '<h2  style=\'text-align:center;\'>填表汇总第1432次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:52:51', null, null, '26', '0', null, null, null);
INSERT INTO `box_content` VALUES ('97455708691c46cba95bdb6f01309a38', '下发数据第24次测试', '2018-01-31 16:21:14', '<h2  style=\'text-align:center;\'>下发数据第24次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:26:27', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('9761c56f254e4e29839b6376ab9cbcaf', 'ZY下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 14:23:34', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('9a90c47db1fd425d8b0a3566c0fb7704', '填表汇总第1868次测试', '2018-02-04 16:50:42', '<h2  style=\'text-align:center;\'>填表汇总第1868次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:50:46', null, null, '33', '0', null, null, null);
INSERT INTO `box_content` VALUES ('9b7a976df24a4fdd877cb9c37d95b1bf', '问卷调查第1126次测试', '2018-02-01 17:10:57', '<h2  style=\'text-align:center;\'>问卷调查第1126次测试</h2>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:10:50', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('9b7fd822891f4240af154bf2a2918318', '签收材料第821次测试', '2018-01-27 10:21:59', '<h2  style=\'text-align:center;\'>签收材料第821次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:21:57', null, null, null, null, '1', '1', 'add,delete');
INSERT INTO `box_content` VALUES ('9d8eabbe39254f5eb4c8a9a6b97b5ed2', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 17:04:34', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('9d9a8ac5f65c409bb712a1151a04f122', '下发数据第101次测试', '2018-02-03 16:08:23', '<h2  style=\'text-align:center;\'>下发数据第101次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:08:19', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('9fdb8f22caac4d989f80e0d9fd7a7942', '问卷调查第1088次测试', '2018-02-01 17:05:17', '<h2  style=\'text-align:center;\'>问卷调查第1088次测试</h2>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:05:10', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('a0d567cd90a3499aa479bae0a8b3d3d2', '收报告第108次测试', '2018-01-24 10:19:21', '<ul>\n  <li  style=\'text-align:center;\'>收报告第108次测试</li>\n</ul>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 10:19:20', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('a3a90bc8719345c1b192360f937e6526', '下发数据第136次测试', '2018-02-04 10:36:43', '<h2  style=\'text-align:center;\'>下发数据第136次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:36:40', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('a4dc2c092ce44b32bab662f8302c19d2', '问卷调查第1888次测试', '2018-02-03 16:47:18', '<h2  style=\'text-align:center;\'>问卷调查第1888次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:43:54', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('a52dc6d7960e4f349b786429a9ad51cb', '下发数据第42次测试', '2018-02-01 16:16:04', '<h2  style=\'text-align:center;\'>下发数据第42次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:24:52', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('a92c64ea98334bb9911b144e64cbdd28', '下发数据第67次测试', '2018-02-03 10:11:01', '<h2  style=\'text-align:center;\'>下发数据第67次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-29 20:08:25', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('a92d9a37c6784cf29a11babb1c2ff2d9', '填表汇总1122', '2018-01-23 10:31:06', '<p >多少</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 10:31:00', null, null, '21', null, null, null, null);
INSERT INTO `box_content` VALUES ('ab5d3e12f76d446386459ed5f56a5a3c', 'ddl', '2018-01-28 11:16:37', null, '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 11:18:33', null, null, '23', null, null, null, null);
INSERT INTO `box_content` VALUES ('acd12065f71548bd9d10b2a6186df028', '签收材料第20次测试', '2018-01-23 17:52:31', '<h2  style=\'text-align:center;\'>签收材料第20次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:52:28', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('ad80a366bad14330885061097f4f20e4', '收报告第846次测试', '2018-02-04 09:46:43', '<h2  style=\'text-align:center;\'>收报告第846次测试</h2>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:46:40', null, null, null, '0', '1', null, null);
INSERT INTO `box_content` VALUES ('ad91fa0172f8426c8070edc26f9ec7ea', '填表汇总第1227次测试', '2018-01-27 15:30:40', '<h3  style=\'text-align:center;\'>填表汇总第1227次测试</h3>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 15:30:40', null, null, '22', null, null, null, null);
INSERT INTO `box_content` VALUES ('b573dd4c9b034f38b4a363bba6a3c671', '填表汇总1872次测试', '2018-02-04 16:52:43', '<h2  style=\'text-align:center;\'>填表汇总1872次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:52:45', null, null, '33', '0', null, null, null);
INSERT INTO `box_content` VALUES ('b6b1b896136f47a6b5e2dd3a3275f4e5', '问卷调查第906次测试', '2018-01-28 16:14:09', '<h2  style=\'text-align:center;\'>问卷调查第906次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:14:03', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('b78a2a1666374921886f7d00b2ee586d', '下发数据第42次测试', '2018-02-01 16:16:04', '<h2  style=\'text-align:center;\'>下发数据第42次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:16:55', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('b9d36b3836944a4fb7d298a3e5394b98', '下发数据第42次测试', '2018-02-01 16:16:04', '<h2  style=\'text-align:center;\'>下发数据第42次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:15:58', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('ba54812ab6574f21b6913c54b43fcf4a', '签收材料第521次测试', '2018-02-01 15:43:35', '<h2  style=\'text-align:center;\'>签收材料第521次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 15:43:29', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('bb54850f79824a47a04aac4f1221de41', 'zhongji 测试', '2018-02-04 11:11:20', '<p >撒地方</p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:11:15', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('bbe308240344402191a08c94f091d869', '收报告第869次测试', '2018-02-05 11:02:52', '<h2  style=\'text-align:center;\'>收报告第869次测试</h2>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:02:54', null, null, null, '1', '0', null, null);
INSERT INTO `box_content` VALUES ('bbf6f9f5d3894b91b89dad70394c74de', '填表汇总第1337次测试', '2018-01-28 15:43:26', '<h2  style=\'text-align:center;\'>填表汇总第1337次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:43:45', null, null, '24', '0', null, null, null);
INSERT INTO `box_content` VALUES ('bca01d4030994a35bee0ae3b3cd68ce0', '下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 11:05:10', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('bd7a64445b344253888690f5e246b458', '问卷调查第889次测试设置必填项', '2018-01-27 15:03:19', '<h3  style=\'text-align:center;\'>问卷调查第889次测试设置必填项</h3>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 15:03:21', null, null, '5', null, '0', null, null);
INSERT INTO `box_content` VALUES ('bd8622d3f67e4aff9cf4d2cb658d193f', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 16:29:35', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('bf29b0931e1f4153b97838173feed788', '签收材料第67次测试', '2018-01-24 18:10:48', '<h2  style=\'text-align:right;\'>签收材料第67次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:14:34', null, null, null, null, '1', null, null);
INSERT INTO `box_content` VALUES ('bfa741c8dcc94052a12e893afa876db7', '传阅第999次测试暂存到草稿箱', '2018-02-06 17:57:40', '<h2  style=\'text-align:center;\'>传阅第999次测试暂存到草稿箱</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 17:58:58', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('c02bbbc8d7514bc89ddc18b9cdb9a681', '333333', '2018-02-05 16:33:53', '<p >333333</p>', '0', '1', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 16:34:33', null, null, null, '1', '0', '0', '');
INSERT INTO `box_content` VALUES ('c089e69c9892498da56237329d2ab5f6', '问卷调查第2048次测试', '2018-02-05 11:16:39', '<h2  style=\'text-align:center;\'>问卷调查第2048次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:16:38', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('c13bb0a2ec214221ad9450b6dcc26199', '填表汇总第1721次测试', '2018-02-03 13:58:32', '<h2  style=\'text-align:center;\'>填表汇总第1721次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-29 23:56:16', null, null, '30', '0', null, null, null);
INSERT INTO `box_content` VALUES ('c2fa460b62264fa98a995494d2562d1c', 'zzyyyy', '2018-02-03 18:42:50', '<p >adf</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:00:16', null, null, null, '1', '0', '0', '');
INSERT INTO `box_content` VALUES ('c3f8bafc39fa4f499184bd50647e7e2c', '签收材料第98次测试', '2018-01-25 09:54:29', '<h2  style=\'text-align:center;\'>签收材料第98次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 09:54:26', null, null, null, null, '1', '1', null);
INSERT INTO `box_content` VALUES ('c4530aa18d954fbf96a74648d6a1e642', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 16:29:43', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('c599dd673915465a8bfe8c2d33cbd866', '下发数据第1次测试', '2018-01-23 09:20:28', '<h2  style=\'text-align:center;\'>下发数据第1次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 09:20:28', null, null, '6', null, null, null, null);
INSERT INTO `box_content` VALUES ('c77df5723c8341fa84b6f72f41041ce6', '收报告第321次测试收件人上传', '2018-01-25 10:47:06', '<h2  style=\'text-align:center;\'>收报告第321次测试收件人上传</h2>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 10:47:03', null, null, null, null, '0', null, null);
INSERT INTO `box_content` VALUES ('c802652eac504cbf889fe406a2b565c4', 'sdaf', '2018-02-04 10:10:27', '<p ><br></p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:10:21', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('c869df7ff10a4bdab25854dd1dffd9e0', '签收材料第882次测试', '2018-02-03 16:46:41', '<h2  style=\'text-align:center;\'>签收材料第882次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:52:11', null, null, null, '1', '1', '1', '');
INSERT INTO `box_content` VALUES ('c909f46bec3f4e4985c4096b959bfdf9', '签收材料第876次测试', '2018-02-03 17:32:06', '<h2  style=\'text-align:center;\'>签收材料第876次测试</h2>', '1', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:32:05', null, null, null, '0', '1', '1', '');
INSERT INTO `box_content` VALUES ('ca451ae5931b4519802045305653c5bb', '填表汇总1846次测试', '2018-02-04 15:51:23', '<h2  style=\'text-align:center;\'>填表汇总1846次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 15:53:37', null, null, '32', '0', null, null, null);
INSERT INTO `box_content` VALUES ('cabdcb2bec064d3b9704d210bbf7494c', '11', '2018-02-05 16:47:02', '<p >aa</p>', '0', '5', 'f977c3d92de04d8f84270a20614e3b18', '2018-01-31 16:47:04', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('cc151a5f25bf4af6a47623234aa44407', '艾玛', '2018-02-05 14:02:23', '<p >艾玛</p>', '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:02:24', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('cca5f1486d86481dae11f22dd20fcc93', '下发数据第42次测试', '2018-02-01 16:16:04', '<h2  style=\'text-align:center;\'>下发数据第42次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 16:19:09', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('ce76ffe4893143438d30030dde81c01b', '签收材料第421次测试', '2018-01-28 15:49:27', '<h2  style=\'text-align:center;\'>签收材料第421次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:49:22', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('cec7172e953345aa85925e97b5ba6955', 'asdf', '2018-02-04 10:07:04', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:06:58', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('d0c2d9f3d5644de7ab32e400bb501565', '问卷调查第992次测试', '2018-02-04 17:08:52', '<h2  style=\'text-align:center;\'>问卷调查第992次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:08:53', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('d261043725544327bb2618dbe29a96b1', 'dasf ', '2018-01-28 15:40:38', '<p >fad&nbsp;</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:40:36', null, null, null, null, '0', '0', null);
INSERT INTO `box_content` VALUES ('d3974e87aa6445a1bb6f014a3a52d56e', '问卷调查第1456次测试', '2018-01-29 15:52:07', '<h2  style=\'text-align:center;\'>问卷调查第1456次测试</h2>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-24 15:52:02', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('d60274f6da6c4367b49b7f8ed551a661', '下发数据第93次测试', '2018-02-03 15:42:22', '<h2  style=\'text-align:center;\'>下发数据第93次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 15:42:19', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('d65090d9a51e4603b32b7bddad88dada', '下发数据第128次测试', '2018-02-04 10:27:24', '<h2  style=\'text-align:center;\'>下发数据第128次测试</h2>', '1', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:27:21', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('d739ff6b114a4229bc5d0b237e41a0a0', '问卷调查第1010次测试', '2018-01-29 09:57:45', '<h2  style=\'text-align:center;\'>问卷调查第1010次测试</h2>', '0', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-24 09:57:40', null, null, '5', '0', '1', null, null);
INSERT INTO `box_content` VALUES ('d89b95726acf4f57a22b16be1c3c243e', 'zy0129-3', '2018-02-03 16:40:36', '<p >asd&nbsp;</p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:40:34', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('da6f7c234d6b4f3e842ab3591dc94431', '1', '2018-02-03 16:45:35', '<p >1</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:45:31', null, null, null, '1', '0', '0', '');
INSERT INTO `box_content` VALUES ('dd61359dca214824a493a9d0abfe264c', 'zsadf ', '2018-02-05 14:09:56', '<p >asdfas</p>', '0', '1', '85df829495494a208d94cd64efe2d953', '2018-01-31 14:09:56', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('dd67118a497b4679a09139b771b26eb8', '填表汇总第1798次测试', '2018-02-04 10:17:39', '<h2  style=\'text-align:center;\'>填表汇总第1798次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:17:38', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('ddaaf7b2caed4a52abd1ae9c777545ab', '填表汇总第1456次测试', '2018-01-28 16:07:57', '<h2  style=\'text-align:center;\'>填表汇总第1456次测试</h2>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:08:07', null, null, '28', '0', null, null, null);
INSERT INTO `box_content` VALUES ('ddb90680efb0403b884854f39ec74599', '签收材料第402次测试', '2018-01-28 15:40:01', '<h2  style=\'text-align:center;\'>签收材料第402次测试</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:39:56', null, null, null, '0', '1', '0', '');
INSERT INTO `box_content` VALUES ('e081b42935374c8e9abfbce081aa4a4c', '填表汇总第1868次测试', '2018-02-04 16:50:42', '<h2  style=\'text-align:center;\'>填表汇总第1868次测试</h2>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 16:50:42', null, null, '33', '0', null, null, null);
INSERT INTO `box_content` VALUES ('e18b850ac1a2403cb87cfe4c0b028eda', 'asdf ', '2018-01-27 16:06:32', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 16:06:23', null, null, '22', null, null, null, null);
INSERT INTO `box_content` VALUES ('e3c0affca82f45ef8d58d96bc49960aa', 'asd', '2018-02-04 10:19:14', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:19:10', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('e4397c9a686148b7aa577004aebad082', '22222', '2018-01-25 16:03:50', '<p >22222</p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 16:03:46', null, null, '2', null, null, null, null);
INSERT INTO `box_content` VALUES ('e62be4b2f9dc49d6a98d990260f17f75', '测', '2018-02-06 17:53:59', '<p ><br></p>', '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 17:54:25', null, null, '33', '0', null, null, null);
INSERT INTO `box_content` VALUES ('e92bb815bc3b4bae927f0570d9307f44', '66666', '2018-02-05 16:43:48', '<p >666666</p>', '1', '5', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 16:43:48', null, null, '5', '1', '0', null, null);
INSERT INTO `box_content` VALUES ('ea77b2fb4e1348a9b045d13ab6f998e9', '签收材料0117', '2018-01-22 18:10:52', '<p >暗室逢灯</p>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 18:10:47', null, null, null, '1', null, null, null);
INSERT INTO `box_content` VALUES ('eadf4ba641e14783adb3ecc72539af05', 'sd ', '2018-02-05 14:04:18', '<p ><br></p>', '0', '1', '85df829495494a208d94cd64efe2d953', '2018-01-31 14:04:18', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('ed051c2e099741489f54a58ee69a17cf', '问卷调查第909次测试', '2018-01-28 16:15:55', '<ul>\n  <li >问卷调查第909次测试</li>\n</ul>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 16:15:50', null, null, '5', '0', '0', null, null);
INSERT INTO `box_content` VALUES ('ed086f4f793a42a29e123cd44cd14b44', '收报告第12次测试', '2018-01-23 17:53:57', '<h2  style=\'text-align:center;\'>收报告第12次测试</h2>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:53:55', null, null, null, null, null, null, null);
INSERT INTO `box_content` VALUES ('ed3f1f05faf74d24bb7bdae361fb3494', '收报告第379次测试', '2018-02-01 18:27:39', '<h2  style=\'text-align:center;\'>收报告第379次测试</h2>', '1', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:27:33', null, null, null, '0', '0', null, null);
INSERT INTO `box_content` VALUES ('ef1f92a16a76405484457dfb9d1c2193', '真正zhongji测试', '2018-02-04 11:39:45', '<p >啊</p>', '2', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:39:40', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('f02ca7db15dd4896a77abbbf0cbe8628', 'zy00000', '2018-02-04 16:10:23', '<p ><br></p>', '1', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:10:17', null, null, '32', '0', null, null, null);
INSERT INTO `box_content` VALUES ('f0db06711a8f48b5a8aeffce8ebc4e3c', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 17:40:23', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('f1368e4d1ed94df0b13c856ecd6d0b0b', '下发数据第38次测试', '2018-02-01 09:38:18', '<h2  style=\'text-align:center;\'>下发数据第38次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 09:38:15', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('f355c530cda94c9ab8e2ef2debf8f38f', 'dsafdsaf', '2018-02-05 14:09:02', null, '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:09:02', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('f5456442718a41d4929dc5dd4c3baa2e', '签收材料第769次测试设置值提交', '2018-01-27 10:09:13', '<h2  style=\'text-align:center;\'>签收材料第769次测试设置值提交</h2>', '0', '1', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:14:34', null, null, null, null, '1', '1', 'update,delete');
INSERT INTO `box_content` VALUES ('f58b43aa66bf41ad9dee05570a72928a', 'das', '2018-02-04 10:06:08', null, '0', '3', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 10:06:02', null, null, '31', '0', null, null, null);
INSERT INTO `box_content` VALUES ('f74f2827879846b7a114f84212f7037c', 'vv', '2018-02-05 14:14:29', '<p >a</p>', '0', '1', 'safd383028dfasfdsa038829083902fdsajkfd', '2018-01-31 14:14:28', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('f7d4003d1b2b427c8fbf04611bbe6644', '下发数据第27次测试', '2018-01-31 16:37:04', '<h2  style=\'text-align:center;\'>下发数据第27次测试</h2>', '0', '4', '8a6fea61aee249848261dd684b7f8460', '2018-01-26 16:37:01', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('f8c1d37d8ba24203b178b737bfdd122a', 'yang0127', '2018-02-01 17:37:08', '<p ><br></p>', '0', '2', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:37:05', null, null, null, '0', '0', null, null);
INSERT INTO `box_content` VALUES ('f980dbccfb284ba5b0fd02a698d4e821', '问卷调查第882次测试', '2018-01-25 10:55:47', '<h2  style=\'text-align:center;\'>问卷调查第882次测试</h2>', '1', '5', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 10:55:43', null, null, '5', null, null, null, null);
INSERT INTO `box_content` VALUES ('fce11e7c96f74c7e9dc3c02b545dc243', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 19:13:20', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('fe2d02433add476badad87c536e0b491', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 17:02:41', null, null, null, '0', null, null, null);
INSERT INTO `box_content` VALUES ('fef9970b5e354281b959535a1eb5ae61', '1ta', '2018-02-05 13:18:42', '<p >sdfgsdfg</p>', '0', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:18:43', null, null, null, '0', '0', '0', '');
INSERT INTO `box_content` VALUES ('ff8b78f81c54471da949861b9d2fafba', 'Zhao下发数据第12次测试', '2018-01-31 10:14:05', '<h2  style=\'text-align:center;\'>下发数据第12次测试</h2>', '0', '4', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 15:36:13', null, null, null, '0', null, null, null);

-- ----------------------------
-- Table structure for `box_content_recipient`
-- ----------------------------
DROP TABLE IF EXISTS `box_content_recipient`;
CREATE TABLE `box_content_recipient` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `box_id` varchar(64) DEFAULT NULL,
  `number` int(11) DEFAULT NULL COMMENT '催次数',
  `status` int(11) DEFAULT NULL COMMENT '0未阅1已阅未处理2已忽略3已完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接收者表';

-- ----------------------------
-- Records of box_content_recipient
-- ----------------------------
INSERT INTO `box_content_recipient` VALUES ('005d06f8d6544180a1fb8446e5b3d6e9', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'e081b42935374c8e9abfbce081aa4a4c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('00dadee091dd4e188dd28acac7869cbe', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'da6f7c234d6b4f3e842ab3591dc94431', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('0124d8354a9043e6be626f43b13d8776', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'd0c2d9f3d5644de7ab32e400bb501565', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('013bdd50838c4c0c95b0705d5c476a1b', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0143c5d3e0d14f60a54c698a201d79d3', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('01b50346485f46c29e19236a0ca4efa8', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f5456442718a41d4929dc5dd4c3baa2e', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('01eb2a1a86f7485e9d7f367e2fa90928', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('02282ab45a0444108b467caf40c3023e', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('025f49710a244669a6fed25c7d2bb8c8', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '77c5f43d06b947c190ef753de1671a70', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('02c13bef33bc43fb99170fecb6f23055', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '278c5e783388472eaa64faa606a1cdc5', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('02efd59dbc3e449eb5e1502687ea6a4b', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('02fcf57a2f784a0eb5a75dfa91b732b8', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '8253262e5d564b1cbc34517e194aaef5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('033be9655a3b48c8b0329e663083f8bf', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('03520fda8cdc41c4856657d54f513111', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('03b32cc005974931b182e346f7c39fad', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('040bf672924e4d2bb476d167d467aec5', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('04148e899ae44d6e847022af5aae82b1', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('04387372899c414c9ba33c4229cceedc', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('045c7af47f59417c9d7ca710be04e479', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'a0d567cd90a3499aa479bae0a8b3d3d2', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('0494e24ba71e4f54829c7e3ca1049839', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '84f5a249f00e45e3bb8714e3a637c461', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('04b5b9e95c184b92bf38df780ce8ef8a', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '37d46a02466242a4adcd8cb5a260b65e', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('04fb6c5104244ce98e2b521ae1c1f587', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('057f7b13d7ed419b920dc7c98711a6a8', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'bb54850f79824a47a04aac4f1221de41', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('05a70f2f0c09407e8c216526482d346f', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '9761c56f254e4e29839b6376ab9cbcaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('05cfb43a918d477d8187d3e8df81063b', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ed086f4f793a42a29e123cd44cd14b44', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0607a9eba93e40a08d7066e39cf04afd', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0645ec175f854e1396b7bc94805fcc11', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('067fa69f7a4c4691ba03804fbb1ea804', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '1010177543954128afcef296b2cb6336', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('06b5767e834c4a20b265e99ac698a712', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('06ca84e771c64bbc94bb4cdfa32c3766', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '104e53f6cfd54049901c91ea7705c18d', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('06d7540a39a441098ff7f1f81b589ea2', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('06f2309b4c1e45729f4d0cc99b44e559', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('072e3a91c777436c99b801582a61ba8b', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '5fb25edb52ee45c9bc53ebabe75d3cc3', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('075a35e13a0f4d4d8bcab4d2519bd642', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('07699eba866a4966b54330c169992253', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('078772083c654e35a8d545871418ec60', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('07a53d1f89144a8893ed0cf92e226688', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('07a773248f0045bda9b080498c0c8c15', 'f977c3d92de04d8f84270a20614e3b18', '张三', '378a606a6cc14415a4568a9e92752497', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('07d0fe01999943b98e6298450b3d0d87', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '278c5e783388472eaa64faa606a1cdc5', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('07e62ce487974561a13cb4d6a63cf6c2', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('0800bbb69def41d69c46445f1c2341f9', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('08019d53-2d6f-4e14-8ac1-2a808c7cb192', '36d416641436467b8d68392fb11c537d', '门诊科', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('08276f77e7924d35b01fb74b9297988e', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '4691d19717194e6381c9c8c98179fc1e', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('08481b2bc9644ea9abf3804b12ac5fef', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '8dd7f6c8aa414b5db2beac000fd1cec8', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('087e4cdf30424c35adc5e1a0c2e8adaf', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ddb90680efb0403b884854f39ec74599', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('088514248bc64c8b8ba6f506441900cf', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '31c09a9e42634d4a8eb6bd90e721c0a2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0886b5cf925a4902a870e13047ce1485', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ce76ffe4893143438d30030dde81c01b', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('088841ef5b3a47dfaa52b8573bf08662', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('09247946a83041cf9f86cb6dfdf63dbd', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ce76ffe4893143438d30030dde81c01b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0952ddef7eab4351a45165dcc4588f43', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '6c11191e3200490c84a70bd543948ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('09621bc0aaea41928796f0ad2e80603e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '1b6388ab1a574474accd7a0552ddcfff', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('096ce799d11c403293fce2e9218e319e', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('09f24ec8a0a24ec9aec805951a23deaf', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '6c11191e3200490c84a70bd543948ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('09f6eb34eb7d4d8b92b25c0090df56a8', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0a1625f9666a490b9ca637f0503edc94', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '53c0f5d6b02c47c18c0b3f8114c13482', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('0a274c02c6d149488fb7e7a10c646b69', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '008c09b2db7b48169f8e84239d9e6ba8', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('0a44a941a83046a4b088de9e4e65171f', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c599dd673915465a8bfe8c2d33cbd866', '4', '2');
INSERT INTO `box_content_recipient` VALUES ('0afbf52852c14b1db2b63ee092dcc4f3', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0b081daa0c7945298993ecb100df791a', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '5b7834cb032847c48a425e2855b3e1c6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0b801d7ad3aa4437a032bc8a99afa3a9', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0ba062ad91024a4cb66af4e81bd61cfe', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd3974e87aa6445a1bb6f014a3a52d56e', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('0c037d5882984f488a6fa02d957446b2', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0c08b2ca14294ce0b5521c691c7800c6', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '27e2b82e10b44f4cabe24f7b315b1503', '2', '1');
INSERT INTO `box_content_recipient` VALUES ('0c4ba4f7f5fb4cd1bd959336610eb194', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ba54812ab6574f21b6913c54b43fcf4a', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('0c6a118dfdd7478c9ad6a8a696e8d801', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('0ca6f786fdb1452993388491855b952c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '84f5a249f00e45e3bb8714e3a637c461', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0ce44c5487644c2e9833f95b37ef51b1', '1f20b622fa6f459eac5ec26f3d5d8e31', 'rrrr', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0d00ef0e42694402918ece91750651bd', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '47aa7ac3db384393b16e59334d743c52', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('0d301aff59444c3280e9944eee13a9d2', '735ba536aaa541db9f7f2f2fb445a054', '111', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('0d46cf2f956e4b61a47d30bd5fbc72a4', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '19a77c3ff2f144628dc056278d898001', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0dbe463c3f6b48f491961961c126da42', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('0dca36296cfe47ec9a50682303216431', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a3a90bc8719345c1b192360f937e6526', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('0e1947de7a6848af82ee49d7dbc21339', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '066bc75862be4424892a75805e85ecb4', '4', '2');
INSERT INTO `box_content_recipient` VALUES ('0e33da070a04403cb64f9528c806fcb4', '735ba536aaa541db9f7f2f2fb445a054', '111', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('0e34ff1327f14ae4b277160dec1b4351', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('0e889d27ba3c4df296f423c0c573e79d', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('0e89341efd414c1287ad95359ac1130e', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '3718ccd53786409f87917727dc691ccb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0ebe35452f4347e5bdffe225b3c91c13', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '278c5e783388472eaa64faa606a1cdc5', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('0ed2c8ba2f344eadb048bc4f38733740', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'cc151a5f25bf4af6a47623234aa44407', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0f1b868422da4339a852c3fdf8bc14e7', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0f1ecb55f2e34325bf4bb4cd302ab68e', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'f980dbccfb284ba5b0fd02a698d4e821', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0f2b07d1d1bc4799b86b7236030333af', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '2e9fab2aa6184ac39dc5774944e76d9c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0f4b0770d43f4481a22303c288e9dced', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'acd12065f71548bd9d10b2a6186df028', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('0f4b3f89aed345ba85750f0830af0783', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '68800675a5e740ca8ef5c03bf094517e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0f51862496584903afe0eec591c9ad28', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'bf29b0931e1f4153b97838173feed788', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0f63d042b30d4ad3ab81e7feca15be6b', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '8253262e5d564b1cbc34517e194aaef5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('0fb94c124c5f4f32af4de016457e6a07', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '69f0d4a2475e44da816c11de64138493', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('0fe4b11d7c944d1b888162169e6256b3', '735ba536aaa541db9f7f2f2fb445a054', '111', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1026c19d77fb4ab79f3504b57b70f5a9', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'f980dbccfb284ba5b0fd02a698d4e821', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('104a9a9d60ed4850b2e6f2fced6e3983', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c3f8bafc39fa4f499184bd50647e7e2c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('10a4bf534a6244ccaac2bdaa9c11b866', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('10a57b9a9a364618920f6d2110586142', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '9b7a976df24a4fdd877cb9c37d95b1bf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('110016a6de4d4061b4aa754b8a363ba0', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4f5bac38ac134d3ca61dfdd3cdb45265', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('1123ea4e96b64123a98003200c11548d', '735ba536aaa541db9f7f2f2fb445a054', '111', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('117f8e34b9d64f67bea95a5e75564585', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '024606e102e74d5e9b9ac4086ec2a8da', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1184a1663fa048c88c5ffe0f858e3a3b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1278564ac80746bc8b45f392e55bc88b', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('129da0f6c33e4ca9bc47a2ca5615e6b1', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ddaaf7b2caed4a52abd1ae9c777545ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('12b388ec3a4a45dd814f10415dff14f1', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ba54812ab6574f21b6913c54b43fcf4a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('12c7babd52164a0593f807882bf5e7a6', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('12ff497a02dd4230a7ad32df4e71e155', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '8357937d22574fdfae1b8758ce698718', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('1321c3d380a64b89a24c1406ba0b653b', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c77df5723c8341fa84b6f72f41041ce6', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('13467e376bf04fdfbbd28130e3e92ceb', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'bfa741c8dcc94052a12e893afa876db7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('13a9e82fd8254b1780edec33b24a14aa', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '88d89a4597e240c3b8f17d05d996f956', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('13cd35961d72454496091d0cfe9b4310', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('14d66ec2b0114797917851071f1f9eb4', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '2e9fab2aa6184ac39dc5774944e76d9c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('14dc1326e5944d4c913b462dda571c25', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('14ea182ebff246d0a2eb9d5a06e02de3', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('15444343b1a44093bf9f6d60c843338c', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '68800675a5e740ca8ef5c03bf094517e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('161083fc5ad24e53804650fd0606e607', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('162e77bb394a4ab98fb0c4f3471daedc', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ad91fa0172f8426c8070edc26f9ec7ea', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('16aad4d49cb44fa081c948821e742ccc', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'bbe308240344402191a08c94f091d869', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('16f9241abf3347bea8eebccff39a4987', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c909f46bec3f4e4985c4096b959bfdf9', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1710ebd7408a430eb06757cd1b32331d', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '8253262e5d564b1cbc34517e194aaef5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1720c1a515094c8b83c60fca6c3a92b1', 'f977c3d92de04d8f84270a20614e3b18', '张三', '2fa5a25f4f044adaaca39b3376fae015', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1735d887b2474e5794b3d32bd4adafe6', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '0aadc19f49374982871fb57860e73d15', '21', '1');
INSERT INTO `box_content_recipient` VALUES ('1738be38fd074cfd974b10fac6467da7', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '7363fad3490d4ae18487c06ad9244fcd', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('173b288b72554495b5db3b790b90286e', '6da7a28d4d334dbe995fd157130fc766', '李珊珊', '1c4c253dba83496f9c0541f6fcceddaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('17a6852d737343d6a6e6b84366757732', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('17ec1c08d8b040a68448077944594e2c', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('17ed3619ee0c45eea66ef8eb703a320a', null, null, 'f0db06711a8f48b5a8aeffce8ebc4e3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1812587742374aae98143496f9bd29fb', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '02529acb13c04d85a69b719237a398be', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1872156b07b3486882a6185c1c940a7d', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '7d33aa2eefec48709bf0d35ae895be81', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1914d6e34dd541ba98fbebf86a7c3c3a', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('192a20d46dc34afaa648e4247fe782ab', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '9b7fd822891f4240af154bf2a2918318', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('199714e65e9a453ca01afa45c6405378', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1a096921bde341678eb2bf8a44b81b00', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '854bfe9f300447538d87357dc95299f8', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('1a4c37c26839427d98daa9a0f28fcb21', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '9b7fd822891f4240af154bf2a2918318', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1a7913349f504f85ac451985417d5888', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('1aaf0f54da2347f38d1ae4ee411d117e', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '05dc6a5e69db4487b8e038ccef01ffc4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1b0f05bda25d48fa95dc47fc950541a5', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '9fdb8f22caac4d989f80e0d9fd7a7942', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('1b14836e7aa24d6e938659cabd380d14', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1b71cd995fde47c69a4e38c60a575b2d', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '9b7a976df24a4fdd877cb9c37d95b1bf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1bfb73038ecc48fdb41e5648ecdff4c9', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '84f5a249f00e45e3bb8714e3a637c461', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1c25b3e4e1904e64a49b589af454c1cb', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1c2916a5f48341a0ac78896583b7b777', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'e3c0affca82f45ef8d58d96bc49960aa', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('1c2e527618794c82b8d02aedc8399873', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ed086f4f793a42a29e123cd44cd14b44', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1c58745dd6c24569b17a32eea92fa8be', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '2b59f373760a48cabff49734cc74bdad', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1c66cc76523b41a297daa3fc7e2ba1d5', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '77c5f43d06b947c190ef753de1671a70', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1c8ca31356b2413f86837a7b0c736dc8', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1cfb5a6324234bcebadfb650be5f8118', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '7414462812f4423686639b42fcb56396', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1d154dc7635943ad90759fc918e86703', '735ba536aaa541db9f7f2f2fb445a054', '111', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1dd268249ce74ed0af1b8ab72bae3cb5', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1e32aec2588b4919b2dee9d7c537cc56', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '0e75147b7d3d488485646b271653f3e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1ebee2756c0449a1af89dbf548a0acaf', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1f0c5bd0a7544d8c89a6b8c4e1b094a8', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5aadba772e2e45e0ad2352cb038e67dc', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('1f24c297dae8483c8eaff7c322a24d04', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1f2fe8a083244eb09926fac6211079cf', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1f499bf12c67435997d097db64718a7b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '51603e06481b46d7bbf460cb00ba6d43', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1fbdbd33e7df40489a83fdd021edb40f', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'dd67118a497b4679a09139b771b26eb8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1fe452a00fcd47189b8c52d17a742148', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1ffb9cb6a75a4901963256e70625f9f0', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('1fff5c88ed0744738845d595183bd2d1', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('204048793b5c407bad17fb8ebb43a7be', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('20da5497fce14e9f9ccc8b15d0b5dbad', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '322500f1a8984b9d80a2950ebcddb84a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('20db635c1d2644ceb1ee82ccc888530a', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '2e9671f05b9c444e825bbea55e02022e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('20e7183d4bc748798a7b772a380bace5', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '30d35f56ff5d474c96a785f908898e49', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('213c27cdc2ed482ea78cf65f0366a4b9', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('21706ec39d484b16aed82b304dd39bf7', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'e081b42935374c8e9abfbce081aa4a4c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('21aefa40cad74c02b06cd611b5a611d0', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('21deff6102da44459036a1068092ef46', '6260f2a122f14a7e8c805552ca69271c', '1234', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('22140eda462f4dd49fb20695c704706c', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '30d35f56ff5d474c96a785f908898e49', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('22170961705e4fe199dd394481f636fa', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2259f245a54246038d96b24609b0f66e', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('22867c1c470741f3b28c315372ff1a92', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '4691d19717194e6381c9c8c98179fc1e', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('234a0d2ebcaf4d91899229180d81d01f', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2389e5cf4a1349e4bb64621362c89321', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '75c0a87059ec48449159c1fbc983d64a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('23c3d0f0b6b841d7922299a61a5b441a', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '4f5bac38ac134d3ca61dfdd3cdb45265', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('23d142e2e9994f56b4dbd8d4be6913e2', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '94825402dc2e414a947d1e8b1e396374', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('23ea75496a154838b8968135ccc38061', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('243dfb035e7948a1adc5fb62f4462fc3', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '72a30e3b9e3b43a6ad21bf8b8d9a519f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('24622394127f4db5ba4dbda6071474a1', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '2175666d708b4dc9bf3a3b8526abb98b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('249e47cfb27740cfb3e569abbfc03e89', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '8357937d22574fdfae1b8758ce698718', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('24a7e1b24826447eb41b48dc71e01a97', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '77262fb3438c4caf9e27b5fe429a9e82', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('24cc963c1b904a0aa916068c8b41d9d9', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('254ceedb90ac4f74a965b7f4091b29eb', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bb54850f79824a47a04aac4f1221de41', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('2551914f7eb64818be4e9027d4db85ef', '6da7a28d4d334dbe995fd157130fc766', '李珊珊', '74e2146f25774cc096b1afa00db4c36c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('26214f99872c460c945b0768a7857f5e', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2627bea7de8149a981b63529676cc93c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c869df7ff10a4bdab25854dd1dffd9e0', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('269479bad55c49e6a97a70041dbe55b7', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('26a806bf96464f35afc5b8ca000ab5b0', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '77262fb3438c4caf9e27b5fe429a9e82', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('27403d22467f4b1d813692bc2be21ab2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c869df7ff10a4bdab25854dd1dffd9e0', '1', '3');
INSERT INTO `box_content_recipient` VALUES ('27623d0029734b82a786698fe514e0de', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('2773eb52150542c0b6a9ec6632dc221e', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2792b7968cb740e98e613a13f889f4c1', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('281ef36c27f4496db0cc357ead8010c7', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('282569e8a141450f8b47089e5e2a5df4', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '4691d19717194e6381c9c8c98179fc1e', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('2873c7fe6bf34150919addac665b9d06', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '2b59f373760a48cabff49734cc74bdad', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2884517803d0478d8b7915fe70ea4d20', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '278c5e783388472eaa64faa606a1cdc5', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('2896af26796a46868203f6924721db4e', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('28dc8e37a35f4c79909f1ff9a94b1079', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ca451ae5931b4519802045305653c5bb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('28ed47d4c4cd4678b636b21787f31907', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('2905c47daaf7490ea67070aa1406b0d6', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '0c181bd3b4de4202aa9f8d1afb5d2d36', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('290e66d12bef47ed8270b8d893953ba8', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('292d04bb13c14b29bc5f904958cafe6a', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2934bc30aa16466f8723e4f0475ea273', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '9a90c47db1fd425d8b0a3566c0fb7704', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2961a37060be4c69978eb4afaf8881b3', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '4f5bac38ac134d3ca61dfdd3cdb45265', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('297f7bc294f14260b453c59147ec46d7', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ed051c2e099741489f54a58ee69a17cf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('29981703edec4c7db10af897a48f7a70', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('29b21c93865f42ddb73e13c95d0f6458', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '8dd7f6c8aa414b5db2beac000fd1cec8', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('29bd636b51b34239894bd4a00dddc2f2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '6214b7ee04ed4c9c8ba2297498c04d28', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('29c737176d5a4187bcbcbeb19437b99d', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ed051c2e099741489f54a58ee69a17cf', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('29cc1329899f45329bde0fadb7c25e4a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'bca01d4030994a35bee0ae3b3cd68ce0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('29d715ec86f24fcd8d0d6214c4003ef4', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '3abd322d6c9e464685baab38bca28af5', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('2a0b3604010548359bf63154af6f39da', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ed051c2e099741489f54a58ee69a17cf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2aa72115cb46438b9227f661588f97c7', '9b88dfd273764f54a223434415d53c0a', 'abcd', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2ab9df97ce0a4b5dbcd9de1fba1245d5', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '278c5e783388472eaa64faa606a1cdc5', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('2b064d6888b741baa32d7e67188b4432', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2b4ecc97961148a593c08d1987ba59c0', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'bca01d4030994a35bee0ae3b3cd68ce0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2b9ba85aec8245adbde4811a2c499e3f', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'fce11e7c96f74c7e9dc3c02b545dc243', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2bebd9e1cd5741b8b6e92d9e2b7a3c50', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ba54812ab6574f21b6913c54b43fcf4a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2c30368bc15742cca407335af67d2595', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2c8901264e544f199000f73dec5500ac', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2d6100e8377646e7941a50c623463911', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('2d97b043e64b4af2a0b664688c3ed336', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '97455708691c46cba95bdb6f01309a38', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('2da6d29f39974c988c2c20cfa31a3c29', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2dbb6ce1290846afa2f9b7b6a69411d8', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '18d9b49a830c456dabde748d843ed416', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2de372cdde2f467ab5737a6cc304a76b', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('2dec4f4ebafc4ca69430e95c514cea1f', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '6c11191e3200490c84a70bd543948ea4', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('2e0ae0a72f4749619314190b8709f41e', '6a37f521cbd749de8d3fc7ce121fdd61', 'a', '72a30e3b9e3b43a6ad21bf8b8d9a519f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('2e2a6749abfc4f4290da45c9c67f20a9', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '0e75147b7d3d488485646b271653f3e4', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('2ea49f0cb19a460fa3507c216f1f964e', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '8357937d22574fdfae1b8758ce698718', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('2eb7741ff0b74e0a9a47bb8ebb4368a6', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '7d33aa2eefec48709bf0d35ae895be81', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2ebab5cebb0448c79a76176a2277b171', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2ed3e583edd24c729e91585e588663f0', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2ee479ca74a14577ac3484f2c5f2a88c', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2ef50c5e3ecf427baf1343fd77daa9bb', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '8c0f07dd06c64b5b9b677e83e317ad01', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2f2128fcbca84d138fcdfa17c1aeb1ad', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('2f2a4806521d45629c37d34f2ab3d98d', 'e526d83053294765a34c271c62212dc4', '张三的哥哥', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2f2ed0f4011e410daf0108b553fa1fdc', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'bd7a64445b344253888690f5e246b458', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2fd5acf827144f2ea4ea2a1ee6777c2f', '6f923efef2094ce6b8ae874a01e6c5bb', 'cccc', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('2ff809b3bb224d6089807e01c7ffcb24', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '2e9fab2aa6184ac39dc5774944e76d9c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('300509e1bca14c1797174481cf06cddb', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '33046447f45a44eab52fae5f8cda69ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3007d321455a4e19a5014a7a4a0a3ff8', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c77df5723c8341fa84b6f72f41041ce6', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('300b44ec41cc4edeb158ce3e72e9f139', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('30293e1f4f784a508790973597ec4db3', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('305dd302d8a144cabc94f6a8669a9c27', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('30690ed88a0640049bee7a893fe4b4e2', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('307ff7191c66430a847b78f2bbec463a', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'b573dd4c9b034f38b4a363bba6a3c671', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('308a6d29a5aa4940b25e75b24b30f611', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c089e69c9892498da56237329d2ab5f6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('30be68c66aeb4c7190df852ef7af199d', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '4466b1dbe3d1434cab6b8c3cb48b8988', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('30f683a323d84cfd8676b0bd211c7a24', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'b573dd4c9b034f38b4a363bba6a3c671', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('311daef0c92b45d99a1ece36a3ddc8a3', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'bd7a64445b344253888690f5e246b458', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('312621e7d4a04b77b8546618ae9b2c15', '735ba536aaa541db9f7f2f2fb445a054', '111', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('313751182f05442986d2b3088b365376', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'f5456442718a41d4929dc5dd4c3baa2e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('315a692707554d3889b292f855855bfb', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c089e69c9892498da56237329d2ab5f6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('31a19224fde64b7e94b7aa0dfec4b129', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('31ab771e4fd24547a9ef247ca81905e6', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '94825402dc2e414a947d1e8b1e396374', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('31be6dd6c7d948f6b12df3d384f6a462', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ca451ae5931b4519802045305653c5bb', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('31f4f9698abf4772870efa8238b22283', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '3539d2c9999b478ab672fefbd4e47381', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('31f80265f74c4e7d8e6360e4fcc4f82b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3203c161248c4176aee5209f37e3f98f', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'e92bb815bc3b4bae927f0570d9307f44', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('3273b85cee184e6e930c8f56e8bfddc7', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('32cc61d707e740848f96aa5eff2a982e', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3300c20037d5413a9a3ef7d580f07aa9', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3319dae185fb4efab96df220256c117f', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('333ecd190d4a488aa8a38fd3429cf652', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd261043725544327bb2618dbe29a96b1', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('33789fc395094e21ab3bd84451e54899', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '0aadc19f49374982871fb57860e73d15', '21', '0');
INSERT INTO `box_content_recipient` VALUES ('341eb30362e4403e80f0ac5a2af01179', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'a0d567cd90a3499aa479bae0a8b3d3d2', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('34ab0fca260b442ab334430e9fcea7fa', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('34f0d8d4f57c4b0b8b4f32bf0c71d3f2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '522837a85423435aa8b12ce9bb415d90', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('352c5057683a4e74854e8309116eae81', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'c089e69c9892498da56237329d2ab5f6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('356d0fc22502441092065e9d41c7a539', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '5cd819bc40d0494e81a06c1c291e1cd0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('36044d466d2847c3a7ea047256a4c140', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ce76ffe4893143438d30030dde81c01b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('36315c57329844599b3814e56b189aa4', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('36772b07dfc949cd8808f70631de1118', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3680ac88fe6c477ea92d0566c77c15af', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ce76ffe4893143438d30030dde81c01b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('37290e9a1cc148368a6d4829170419de', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'bd7a64445b344253888690f5e246b458', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3759291145d1452d91e53e58fc5204a9', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '104e53f6cfd54049901c91ea7705c18d', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('37cd02cb235148a4b66a9e2adbcf3918', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('382f7686d4b2487e8d626b14ceb9ab5d', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3845286f54ce48b09fe52843ace95045', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '8c0f07dd06c64b5b9b677e83e317ad01', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3855ee0d476347a4973e05729b1befc0', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bd7a64445b344253888690f5e246b458', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('38c8ad0c76604b6e829c427d7e4bd453', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('3910a80f97534040ab6910f44e36c484', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('394027e3b37842c0ad470ec964adaddc', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '6245d71bcbc04ede85d35a554bd03d29', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('39665094fccf4e7683be63ca6e19a7ff', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'c02bbbc8d7514bc89ddc18b9cdb9a681', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('39a9d1fb7d9d4015ad496cdc4a3bbeb0', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'e62be4b2f9dc49d6a98d990260f17f75', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('39ab00c882a34e909ccc0689194c58fd', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '792b853da83247ec96b2c6d1e32a8ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('39d671c7d0904694b4fdd3d88a7303e2', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'a0d567cd90a3499aa479bae0a8b3d3d2', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('3a0203c45ee2477a9a47d1fcbec91bf8', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('3a60fc427aa24b44ac87599ec48563d2', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '68800675a5e740ca8ef5c03bf094517e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3a69a27b3289450e8f05799a464d57fd', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3aa211abb66a4ae1a430c7b0447f6d92', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '40dc65d131d84e3b80219a02fe966c27', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('3ae3c493c55647229cb29bdd9616196b', 'f977c3d92de04d8f84270a20614e3b18', '张三', '4fef97409d3847beb819f2402095ff6e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3ae6d0baadc44852b3fd96b6c1395f7e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '880b685139254b558c33163f3373bbdf', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('3b3fc5485caa42bfb8ccb004737779ec', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3b5c2b42718c459190347058aa673713', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '88d89a4597e240c3b8f17d05d996f956', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3bb7bef43ca04199a3db5f10c749d453', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '40153f69dc6b44208ee54946c8e04930', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('3c49c9db168f49799b6c8ae2852c6f10', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '823998b8d54a4ec2b5e38d8804886d86', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('3c51d2da2117486abd055119fe846a78', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '322500f1a8984b9d80a2950ebcddb84a', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('3c5eda5dee0f44d98dbbc5414843be90', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '30d35f56ff5d474c96a785f908898e49', '1', '3');
INSERT INTO `box_content_recipient` VALUES ('3c921ab1682043609f9a86fb91048733', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3cc2d1257aa94910a35bfd3d550e1f14', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('3cc3ba0be5544a17ab84cea5b9b8eeb7', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3d1ffd7b65e04a27b272924e382a20e6', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4098ebf6220d4293854f527b963b7910', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('3d495a7846b04732a0ef0addf931b4a8', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ce76ffe4893143438d30030dde81c01b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3dbbeabfb294437fafbf8b29edd208d7', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'd0c2d9f3d5644de7ab32e400bb501565', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3e3feb8c480f4388832c8cd18eedf978', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5cd819bc40d0494e81a06c1c291e1cd0', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('3e78f033355541d990f4e655da5d3816', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3f1812bf6cda4dc9ad7b6dad41860a1a', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '322500f1a8984b9d80a2950ebcddb84a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('3f622936efe6482390ea59bd369e5ca7', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '285be4cdfd6c47cda043abf717913dda', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('3fedaf90d4694a5aac3eb3519f71ad1d', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '74a23b593b514d56870df8e04d61ba77', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('3ff10cd3077d4a70b30637eb23612d3e', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '75c0a87059ec48449159c1fbc983d64a', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('404d49473f934d3a885b30ab4a84e5b5', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('40967786f8274ab1b6567b2216728e24', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('409e6e12083b48648eecbd27c9ddf9d7', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '88d89a4597e240c3b8f17d05d996f956', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('40b6defdaa934bf19f50f01c695357f8', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c089e69c9892498da56237329d2ab5f6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('40dd6465551b4072ad55bb7aba187c6d', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '9fdb8f22caac4d989f80e0d9fd7a7942', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4161856d32ac4d2a802af96ca91869a5', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('41a94c52333c43b0acd2deaa526f6932', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'c869df7ff10a4bdab25854dd1dffd9e0', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('4217bff41e3b4fbb866be7c556476963', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8357937d22574fdfae1b8758ce698718', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('4267c549cf4e48c4a5f7715107c171b1', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '6bf2827fa9d74c8086609ee295ae6895', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4281abaeb2b1474193c188c1320f0b9c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '285be4cdfd6c47cda043abf717913dda', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('42b62ca83fdc40cb9fc4afa2aa7f9fd2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd0c2d9f3d5644de7ab32e400bb501565', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('43d99c0b8df14baaa7bf7f28a5cabf63', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '05dc6a5e69db4487b8e038ccef01ffc4', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('43e4d2a510974ceab171f7aaf8c5c33d', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ed3f1f05faf74d24bb7bdae361fb3494', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('444c314a23434bf487c4d92a63b89df2', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ed3f1f05faf74d24bb7bdae361fb3494', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('44c5f7eaa0f247aa80560adde18d26cd', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '84f5a249f00e45e3bb8714e3a637c461', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('44c93567e64448bc81c129051b3a8f34', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('451ae8c1af8c412894adf0bd84ec5860', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '88d89a4597e240c3b8f17d05d996f956', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4567b4f69ae049eda53001037bbd23d8', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('4593978183a9476d85db9d1df024b35f', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'acd12065f71548bd9d10b2a6186df028', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('45a9d54f5f254f2d953d09c319f2dc1a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '0e75147b7d3d488485646b271653f3e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('45b6b53f61bc4a44aa5b2085aa016b4a', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '62ed3ffd4d9b4c4d9dc3558c4a3bd4c1', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('46438882bb2743b69ac3f277d5d43027', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '9b7fd822891f4240af154bf2a2918318', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('468dea7c6aa1414db30a30bdb1d562fc', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('46abf92b787444398e08100df95c38a2', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('46d92e3246434cd5829a9089f88a9111', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c599dd673915465a8bfe8c2d33cbd866', '4', '0');
INSERT INTO `box_content_recipient` VALUES ('4711c091eb454227922a2dd656cc2518', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ad80a366bad14330885061097f4f20e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4727c559152045b6bdcd44e542a0fd0a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('47d13354b4ca40d48672dce07ebc878f', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'bf29b0931e1f4153b97838173feed788', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('47e5ec0e367d49f2bd597a33be3e7747', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '7363fad3490d4ae18487c06ad9244fcd', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('481841e1701246b0b5ef5ddbc9ec367f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '9a90c47db1fd425d8b0a3566c0fb7704', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4829283af692450fbd7169997bbeb51a', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'c3f8bafc39fa4f499184bd50647e7e2c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('48e8dff9568b458ca636a8e29619edaa', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f58b43aa66bf41ad9dee05570a72928a', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('49753cfecd9d4042810946bc6d250c9a', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '285be4cdfd6c47cda043abf717913dda', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('49a4e75add1e40c89f25daa08f95f8c3', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4623ab5935434c55b9458871a8a9181f', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('4a2d69725b5e42249e8f5d61938e2823', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a92d9a37c6784cf29a11babb1c2ff2d9', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('4a6352e1428448fc903436728d42a2a6', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'd0c2d9f3d5644de7ab32e400bb501565', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4a67cad964ab48d3a699a6ce45df3f47', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4b4bdfdf8ffd45a6b58ce9cda8efe2c4', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4bcfd4402b5b45ec917d247d10eff0fc', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '7414462812f4423686639b42fcb56396', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('4c058e543d7a44a39bff9c1a4e41abc6', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '14223a92132c4853988d48b44dff99a8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4c25db4c94604329a9d34dd3be63d3eb', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'b573dd4c9b034f38b4a363bba6a3c671', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4c47b85ac58e46f7a29cddd231a5ce8b', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '02529acb13c04d85a69b719237a398be', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4c75ac3d982448298f3c32aa5494d4da', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '9a90c47db1fd425d8b0a3566c0fb7704', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4c8fb18ec58d44268dfad28add8ceb72', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'bfa741c8dcc94052a12e893afa876db7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4cf3cb382d4145cb837b4be85afe8677', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '5b7834cb032847c48a425e2855b3e1c6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4d2b4266a07148dd9493732d8c93a270', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '0aadc19f49374982871fb57860e73d15', '21', '0');
INSERT INTO `box_content_recipient` VALUES ('4d3ec0a294e44e70abd8ad4bf19f3176', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ed3f1f05faf74d24bb7bdae361fb3494', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4dd90f7befd74c9885ef2fa35d29eb63', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4de0520a2c8b4de2a5acc806fca9b5d5', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '1010177543954128afcef296b2cb6336', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('4f37282d8b8e448881a07583a1396def', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4f40bb8591b84d0296616aaaa87a7b0c', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '2175666d708b4dc9bf3a3b8526abb98b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4f45d71601c1408290b4b930a4f43b73', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('4f71f2b0398a4684a877a8b612a5371c', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('4f75c80d59fc467c9ccb4c8c554b357a', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4b8e9f81f2dc404092cf18050655d3a2', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('4fa7e0a3f592494f9bd94098cdfae935', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('4fbcb06b40c54256b5ffe9b2eb0a27fb', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'e92bb815bc3b4bae927f0570d9307f44', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('4fe75f6f4a7f4df7bde2a23458e4e5c4', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'bbe308240344402191a08c94f091d869', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('508746f1d1da422ab860316bacfd43e8', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '5cd819bc40d0494e81a06c1c291e1cd0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('509bddf5acfe406794fcce88744eacbd', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '4466b1dbe3d1434cab6b8c3cb48b8988', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('51019d37e6d64f0dbcde7ab8950df063', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('519671acafa7471eb3e422a3fbd227f5', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '9a90c47db1fd425d8b0a3566c0fb7704', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5255ec96960b4d8d8752dd7c1ab6e6e9', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '46fd9e80456a4325b09278ac10822ce6', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('5274269af8544352a77af5aeac5bc886', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('52b5d894409a45ef880f545e5ba229b4', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bf29b0931e1f4153b97838173feed788', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('52be1fa6b39841ebb539b2684faabdf7', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('531a88479da347e2be5330af7676e86e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd89b95726acf4f57a22b16be1c3c243e', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('537abe9ae71f4fca82466ef9b70e2ae3', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '31c09a9e42634d4a8eb6bd90e721c0a2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('53a5986fbe3242d98f9b9c6b8e476eb1', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '3718ccd53786409f87917727dc691ccb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('53ace9a9c55f4c1fa1fc37aa82796cf8', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ad91fa0172f8426c8070edc26f9ec7ea', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('53ba32fa18244e6695cbc00850fadd23', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '95aa0c8f2bba4a74ab24b48d237f7ff7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('53ffec73a81c4990a934583954d3251d', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('543b7c8087434c6eb4d8e2016098e47a', '4032da429d2f44ddb4cbb308ebd591c6', '张三sss', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('547168848b58466cbeec711b64969b3e', '735ba536aaa541db9f7f2f2fb445a054', '111', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('547cc23fd63847b0a249e8b2b9d8f16e', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '5fb25edb52ee45c9bc53ebabe75d3cc3', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5484350a996348619a38ef47630a2b04', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '94825402dc2e414a947d1e8b1e396374', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('54fc82433607403b9bf9c6c8ac42e5ea', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('55b818ab967b4acbb9d849dc29dd9ab6', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('55b91f8d8ac142eebec721238d436e64', '735ba536aaa541db9f7f2f2fb445a054', '111', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5652e267af074109897b612e087d0d6f', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('56df02e66d154390ba3f90ca9919245e', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('56f60a1561774c23bdc109fcff7e9803', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '57e09261239b4cdd9815bed0aabc1f1c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('56fd80e100cf4b178fabb413a21a252c', '735ba536aaa541db9f7f2f2fb445a054', '111', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5742099e74f0467b9f4ffce95ee7b103', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5768a9a049f74e29b518eaf699581119', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('587497bb25c748e79e001127ff36be01', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('58c6fd2fe89542679864dad60d028bc8', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5956276508754488838e18549da46104', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'e081b42935374c8e9abfbce081aa4a4c', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('595a510e30894944ab33e28e1fa45312', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ad80a366bad14330885061097f4f20e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('596a25ccb13c461596060bcc58e19aa0', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '6245d71bcbc04ede85d35a554bd03d29', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('5981fb79d78f453a9199db3b91a2d8e0', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '2f0e421b5f5744afaa029cd79133086c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('59d9bdcc2b3b4463a617c91bc51e664e', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c13bb0a2ec214221ad9450b6dcc26199', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('59eea06ed5374a72b0a21af20124c908', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '0e75147b7d3d488485646b271653f3e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5a392505f6d9429a88e9664b2b1e8214', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4691d19717194e6381c9c8c98179fc1e', '1', '3');
INSERT INTO `box_content_recipient` VALUES ('5a493d71995c424e92a0c9d6433f0991', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '6bf2827fa9d74c8086609ee295ae6895', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5ad9342796704959aa993342b9886d09', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd60274f6da6c4367b49b7f8ed551a661', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('5b21e5cf09fa48e19e787655a3f2f542', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ef1f92a16a76405484457dfb9d1c2193', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('5b271422feee4738a376d3acbe0acfd6', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5b308c6ba1f9449ab2298d2265b930be', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c869df7ff10a4bdab25854dd1dffd9e0', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('5bb21f5f63ec42d7a266c5c32195339c', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5bf185e5a88e44f48b6b78ed6c730234', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '6c11191e3200490c84a70bd543948ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5c2d6439846e4e6da8e62bdc68fcd101', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'acd12065f71548bd9d10b2a6186df028', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('5ce1803e8476432e9c286427f7e4bf39', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('5d1298be89694fb9a01488556fb58a5d', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '285be4cdfd6c47cda043abf717913dda', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('5d593545e94141a1b43e34884df2e288', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'dd67118a497b4679a09139b771b26eb8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5d9815484e9942b6a56d42f5bfa85778', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '18d9b49a830c456dabde748d843ed416', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5daa10779dba4c56abcb4d6c9682a34d', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'd739ff6b114a4229bc5d0b237e41a0a0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5df2435298bb44ae98cede1f5089460b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '5cd819bc40d0494e81a06c1c291e1cd0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5e569432683348089f22475ac59bbd83', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5e755c9372e94bacaee2c9f67a33ba2f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c13bb0a2ec214221ad9450b6dcc26199', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5e7da5209b554da2a31a5548716770a2', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'dd67118a497b4679a09139b771b26eb8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5e80e020a0bc4b2da489614c801d729a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'd3974e87aa6445a1bb6f014a3a52d56e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5ec7dd7368f449feaa2dd55562324f21', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5ed9134b6a984fa29b81faf5041d1a21', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5ef06370921e40c3a57ea31be234b6ac', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '4691d19717194e6381c9c8c98179fc1e', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('5f5b21246e40410094904fdc3d5307e0', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5f75a8847c3943e4814911a6d2223ef7', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '4466b1dbe3d1434cab6b8c3cb48b8988', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5f779d41e6a5430faa1bc70078cc3ce8', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('5fc8d34b3083404da42269f5cf41f007', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '792b853da83247ec96b2c6d1e32a8ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('601511a1e34b40b6988894d45e534bdb', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2175666d708b4dc9bf3a3b8526abb98b', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('6035a20b1411413eb97c521959ba04be', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '14223a92132c4853988d48b44dff99a8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('603b78d566854959bb28939e4bcad66e', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('60722bc287c9493292e47beddb116959', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('6087a35e7a4747a6a338a31c091dfd7f', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '77262fb3438c4caf9e27b5fe429a9e82', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('60e9e44611a5455bb8c1c8e8ed3b18b4', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '285be4cdfd6c47cda043abf717913dda', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('6150113ba36f45a993a7ac62dc370f21', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '9fdb8f22caac4d989f80e0d9fd7a7942', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('61a7b84521a44215ac65b5c920a994e0', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '51603e06481b46d7bbf460cb00ba6d43', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('61b43182990a47b7aaea4565b98ad59e', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('61d9e8d8a89641cb9eed5de976ffb591', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '77c5f43d06b947c190ef753de1671a70', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('623fe0c60580476a87dc5ffd719c6338', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '8dd7f6c8aa414b5db2beac000fd1cec8', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('626dc879fe6041359ebca2c83d3a5bcd', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('629e8c8ccf114b178ef2dbbda3633041', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '7d33aa2eefec48709bf0d35ae895be81', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('63186babcc134d11a646b2178ceec422', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('636691a5129f4e38859b16e45a92a19f', 'a44844809c844c14a986063cb2ad586c', 'ddd', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6367557a152b45129f869847c0f020f0', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'f5456442718a41d4929dc5dd4c3baa2e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('637f7c1faeba4811bbd0eb620d15cbe3', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('638f3ace71824fa5b2d23d59467e82a4', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '69f0d4a2475e44da816c11de64138493', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('6396a2ba53d94ea5a9579408c4eea29a', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('63f34009-68be-40c6-b10f-736fb4420936', '36d416641436467b8d68392fb11c537d', '门诊科', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('643f9e12410748bb8e0219f4ef46bf0c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '6299bc217cd648588a34b7a1d1c7b72e', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('6512a3a667304b63a288a45b612a7a64', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '3539d2c9999b478ab672fefbd4e47381', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('656fa4579fbf4442b0763b27f64bbab0', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bfa741c8dcc94052a12e893afa876db7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('657e850ca4cd49e4a61ca394b54889bc', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('65a58f2520144542be225375a65a79d6', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('65fc94cb0c114ef6b5f4edcb07d17aee', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('66254438d6264793ba5c7b0bb0214d02', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '2f0e421b5f5744afaa029cd79133086c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('66a354b47b8a468dbefd74a27de70371', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ba54812ab6574f21b6913c54b43fcf4a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('66bc76a0ac6b49539f2782d90425b9e9', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('66f3ccfe672249ec834a7e763c82d34c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2fa5a25f4f044adaaca39b3376fae015', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('66f5b3832f27415493c450d4a24a50a5', 'a44844809c844c14a986063cb2ad586c', 'ddd', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('67036f6f1b5c4bb0855763411b856557', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('671f9df62e47468cad7006e66a20bf2a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '2c977c62ebf94c709e607e95b56f17ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('674a89b5fe90481fa6370b9ef8ea856a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c599dd673915465a8bfe8c2d33cbd866', '4', '0');
INSERT INTO `box_content_recipient` VALUES ('67886017058a488781ff8e7a9eb3035d', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '04adf1158de34b968a2dbb58246e6a03', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('67eb5e12c0aa452888c79d931034525d', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd65090d9a51e4603b32b7bddad88dada', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('681d841589e44afe855ec2fcadef5ef1', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '33046447f45a44eab52fae5f8cda69ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('681eada5caa84b9d8708d68e10b77aeb', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('68a923e93c5e401eac518a1bc4b8014b', 'bf5d5b8f9ab1461c8a1e90d608d29e90', '张三AB', '1c4c253dba83496f9c0541f6fcceddaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('68d7b3be3ada4e32918dc41bffd22bca', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('68fb1aaaee814455b4c092262b9b1f55', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '7414462812f4423686639b42fcb56396', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6901e3a9859a4428b85672193e0e2f42', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '9b7fd822891f4240af154bf2a2918318', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('69546f60b9494e9a8ceeb2455e357bfa', '6a37f521cbd749de8d3fc7ce121fdd61', 'a', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('695d889389474cc3ad54996842ab6afa', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2c977c62ebf94c709e607e95b56f17ab', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('69cee46de74f423abda71b69b726e99a', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('6a0f6cb7d47a4c9ebe6e7407a48c20ed', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6a2d8f424c564bbd883ff20e70a6b869', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '2f0e421b5f5744afaa029cd79133086c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6a35e498aa18427ab7e775edb0e63970', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '9d9a8ac5f65c409bb712a1151a04f122', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('6a735d504ab049058b5aeb8b1c580887', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'a0d567cd90a3499aa479bae0a8b3d3d2', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('6a7d7c5509fd4f63a892485c1ca6931b', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '41b5d540060a402889d86d5abee22e7e', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('6a80c5ddccaf4d8da8c4ec63ec452609', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '02529acb13c04d85a69b719237a398be', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6a9901190c0b4feea687d436ffe14ca2', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ed3f1f05faf74d24bb7bdae361fb3494', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6aa8a4408c8046a5a0df693b7a4ec768', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'dd67118a497b4679a09139b771b26eb8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6abccb5b9ce546aa9a908e6f35502523', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '18d9b49a830c456dabde748d843ed416', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('6abf0898fd2c4e3b9e58155b17a0771b', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6ac27b42fb6646bcb430d3253219b465', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6af218775a1c48ceb78e3ede5421e577', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6bcf9f23cd7e47a7a07d83b12573b048', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '1010177543954128afcef296b2cb6336', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('6c0f612f2e1347fdac9bdb0e376f501f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '77262fb3438c4caf9e27b5fe429a9e82', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6c295dffbb4348a29ea1cae96989a6e4', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '9761c56f254e4e29839b6376ab9cbcaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6c333088f9974d7a9f69caa635c8232d', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '2b59f373760a48cabff49734cc74bdad', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6cce7fd78f2d43a392f7fe466919b993', 'f977c3d92de04d8f84270a20614e3b18', '张三', '69f0d4a2475e44da816c11de64138493', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6d661eb993b946a7a3d1fb2ac2155bf3', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '6c11191e3200490c84a70bd543948ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6d9812b9949444ecafb7f5be3fd851d0', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '8357937d22574fdfae1b8758ce698718', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('6e86470e78ac4a778e0170c56bb4858a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '68800675a5e740ca8ef5c03bf094517e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6ee007f8359f47c9a31b5e87c8b09770', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c909f46bec3f4e4985c4096b959bfdf9', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('6ee6e6761df740048142e0d4e2352e6c', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6f103c0192d04ca890aa0a69ed5f4bac', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '54e3bb7621bb423ebf2be41900fd6d35', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6f3b2141e8b84c0f8079977415a5158f', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6f743a08d04b49d782fdd8a6934deab3', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'bd7a64445b344253888690f5e246b458', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6f7e370841604b7588ba5fa6d383229d', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ba54812ab6574f21b6913c54b43fcf4a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6fc597d95cd44bf580773f64a9a7713f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '75c0a87059ec48449159c1fbc983d64a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('6ff35907501e48bfb092ec709c7dc13e', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '72a30e3b9e3b43a6ad21bf8b8d9a519f', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('703b2dd76ad6493a9a012a3e42effee2', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7040242f5988429a8678e99dd877eda3', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '1b6388ab1a574474accd7a0552ddcfff', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('705880107d42411a8c87d531f412ebc6', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'bf29b0931e1f4153b97838173feed788', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7058a9ffba5546b0b7f87510061afb55', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('70e94aad9a1e424eb0eaeb48b3a66db9', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '1');
INSERT INTO `box_content_recipient` VALUES ('71735deff5874790b7001b3b5e85b34a', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '6bf2827fa9d74c8086609ee295ae6895', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('71cc9b3420694567978319333c04b837', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('721ed29f2c2747e9b480a90c0a64e813', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '5fb25edb52ee45c9bc53ebabe75d3cc3', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7274056c21ff41bbb7da05ad94b298d5', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7274ce361a8e41d881530e43ffcc1ff7', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('72d58f10c6564b7da527e346b57ad54c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '1b6388ab1a574474accd7a0552ddcfff', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7322a23a7d474e2c9d2f2661105cdf97', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'e081b42935374c8e9abfbce081aa4a4c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7326b78ea45449c5bf0093dc05dedc32', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '88d89a4597e240c3b8f17d05d996f956', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('73679ed7a6d24c10abeefa396b69ec5e', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ca451ae5931b4519802045305653c5bb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('73b8c6a9928142aaaa5da006a5e8fc51', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('73d40566201547799f7247210475df13', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '19a77c3ff2f144628dc056278d898001', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('73dd66a66f67497b9c353dc93ee142b8', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '31c09a9e42634d4a8eb6bd90e721c0a2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('73e22ce95c794f848c739f26c6d1cd5a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ed3f1f05faf74d24bb7bdae361fb3494', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('740b3ec14d19484e9376f51e9f218b27', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('747e2cfc71494bf9b4106916e3d77f5c', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '05dc6a5e69db4487b8e038ccef01ffc4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('74a1b1594bd24400b7cc9f891ce33672', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('74ae5439e48c4a60a406c7febcf3ab2e', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('74b2e397ee7b4ddcb86f582a654504e4', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('74c3fdf0d90847af9dd7de0008c59611', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '8357937d22574fdfae1b8758ce698718', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('74d8d14fe3644f08bca15e7763ac01f7', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('7539412788fb41b1abecbd420922375b', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('756c46b94d9f4f90b85c16208eb9de85', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ddaaf7b2caed4a52abd1ae9c777545ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7570e8d76f1547398d6204ce295ec605', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7653680dba77493abc5b0554a185aec5', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8a64c6a9e93f4b4e9c29d067071a9d17', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('765a84dfdb824b8699b15276cc6e2126', 'a44844809c844c14a986063cb2ad586c', 'ddd', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('76de48d7e80e4d13ab7f9272af492213', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'd3974e87aa6445a1bb6f014a3a52d56e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('76f0af524cf04df3a2c5903cab3ccd69', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'c13bb0a2ec214221ad9450b6dcc26199', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('77077c1fa99949229e7d90e4c4f3565b', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('770928836b9341d3bd3b53eabfcf385c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c089e69c9892498da56237329d2ab5f6', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('779bd348d1654eb0ae5c5577eeaf5f78', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ed086f4f793a42a29e123cd44cd14b44', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('77d31d8d75e045d38668cea00b0e3410', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7855712da99d4cb791dad373794992dd', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('786d98ce24d6498c80408f3c30938896', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '8c0f07dd06c64b5b9b677e83e317ad01', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('78b157c1f3984affa0186b44072ed0fb', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'da6f7c234d6b4f3e842ab3591dc94431', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('78cf1e6d7e284cd5a8eaf464bda011e4', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('78d0af07f4d64d3397667523784ff57e', '9b88dfd273764f54a223434415d53c0a', 'abcd', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('78ea474db9e740d8a3dbeb71defab3f5', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '6245d71bcbc04ede85d35a554bd03d29', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('78f1e537d78541748596df6b1481555a', 'dee0381ada5e400c917c9eb846241185', 'lishi', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('792adb8af1b1441fb3e47ee23504bb8b', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '4f5bac38ac134d3ca61dfdd3cdb45265', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7944c292942b4a4097b41bd45f69f898', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('7a1f9cbde93146c6bfdfb0b357bd7770', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8462d7ff9e4349f1a68ba9489548d4e5', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('7a3ca43e51414ea49a5fcd54d34ecadb', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '88d89a4597e240c3b8f17d05d996f956', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('7a4936e541ef427a9682aa02c10b3bfc', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a92c64ea98334bb9911b144e64cbdd28', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('7a58d448fd8743f69e58aba691ab8636', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('7a81fd59fd9d47d6af669f8ea78032b6', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ddb90680efb0403b884854f39ec74599', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7a8887d2f9a6465490f1b166e8028233', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '27e2b82e10b44f4cabe24f7b315b1503', '2', '1');
INSERT INTO `box_content_recipient` VALUES ('7adaf49aab1c435ea5f801a186866544', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7ade06faae774bbbbaab0d3d124c62be', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '02529acb13c04d85a69b719237a398be', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7b009cf0763f4592a5e5c4b416e4ea46', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7b04bbc9-b605-4e6d-a442-e21978c7c1c1', '36d416641436467b8d68392fb11c537d', '门诊科', '06ecfdbcb11642cd99d06d4f2ea3aee1', '7', '0');
INSERT INTO `box_content_recipient` VALUES ('7b0bd6eb40f84bd4b3ff9722b323d301', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '05dc6a5e69db4487b8e038ccef01ffc4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7b21a20794534325a06955d38327f6e0', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '4466b1dbe3d1434cab6b8c3cb48b8988', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7b2d3729ae074ecaa822029301c2ff29', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'c909f46bec3f4e4985c4096b959bfdf9', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7b645e3558ab4bb298e3e45af25d818b', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7be46894e73e4d35b09f72bea9c38d42', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c13bb0a2ec214221ad9450b6dcc26199', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7bfa380e77a14b7389facf2303e4f97a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '30d35f56ff5d474c96a785f908898e49', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('7c18ad718afa49cbb23f65f24fc403d9', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7c71cf4038794dac838cb7f963c7d527', 'a44844809c844c14a986063cb2ad586c', 'ddd', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7cacec93d9484e22bd0e711359d167f4', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7cb6c343e9e546eeb16f08deb7170691', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7cc08736bdb3420a98d6d8bfeb1fbd79', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '24439695880c44f78458c1b3dcc83978', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('7cc2aff4cba14b60a85fb6602d258795', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ddaaf7b2caed4a52abd1ae9c777545ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7d22b89a669f4686a191d4ab92e16e12', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'c4530aa18d954fbf96a74648d6a1e642', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7d6f7a2023e046ad950334d1f5a79786', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'cec7172e953345aa85925e97b5ba6955', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('7d71f3fb14674cffb48799ef3322e813', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'da6f7c234d6b4f3e842ab3591dc94431', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('7d8662c4c6ea4f4cbdce43f871c637ed', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'd739ff6b114a4229bc5d0b237e41a0a0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7db6facfeb22432ba9f821cde0ec5031', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '5b7834cb032847c48a425e2855b3e1c6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7dbfc7686ae0497bbcaba1044cd18d79', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'bd7a64445b344253888690f5e246b458', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7de6b0a0614248cb8772e0cb3d9cdf68', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ad91fa0172f8426c8070edc26f9ec7ea', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7e811ea71f6f4412acf0c605d581225f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ad80a366bad14330885061097f4f20e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7eb37f7dc8bc47009719de75118a27c3', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'bb54850f79824a47a04aac4f1221de41', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7ece4a4e647c4d8caf709995d6d7c8a2', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'bca01d4030994a35bee0ae3b3cd68ce0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7f093bb8620045539260ff97237e3922', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7fb86233a43a41b49d96da4a0152b439', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7fe80b08af7c43b2be462ee048330acb', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('7ff17c50cd0440d9942139d808262585', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ddb90680efb0403b884854f39ec74599', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8010fe712105423286541751383609de', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c3f8bafc39fa4f499184bd50647e7e2c', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('8052ca187a3643d29f2b3cd81c8999c3', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '055188e4b60e482bb06349c2e701b5a4', '8', '1');
INSERT INTO `box_content_recipient` VALUES ('807bf3d91d3f479e8c341a7814e142d4', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '94825402dc2e414a947d1e8b1e396374', '1', '1');
INSERT INTO `box_content_recipient` VALUES ('80d2fdd0f1c3448cb6e806fe0cb60e59', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('815911cfcbac4c498d38669e9aa17157', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('816896917fc2489d9a473bcffd1cf0a4', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('81719108abec4d358c01b56d340fee9b', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ddb90680efb0403b884854f39ec74599', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('81b44ce18024427190d5881f164b42e5', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('81b55c7b9cdb472a81bcbf0edbca5caf', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '1010177543954128afcef296b2cb6336', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('81c30b7d2e684cde93539386fb668ffb', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c3f8bafc39fa4f499184bd50647e7e2c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('81d550a2e3394201980bbbd1115b2c3b', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'f02ca7db15dd4896a77abbbf0cbe8628', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('822e536eb638481c8cd53fd340941046', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('82334e64165f4d5098411a7d87d65bb2', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('829ca030bfec483884ae5c5f61ae8f37', 'a44844809c844c14a986063cb2ad586c', 'ddd', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8334d11f31b046be8919a1639cedd968', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '1b6388ab1a574474accd7a0552ddcfff', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('833766529f7e442fb80bd79daa3b7dd1', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('8349aad2c3ea4535ab9ffa9e9a36cd7c', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('836e079ce2b64a189b0254dccb7b98d7', '735ba536aaa541db9f7f2f2fb445a054', '111', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('837a09b8e12346d099e75a1feb75b8a1', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('84669132f1f1458ca282b9fbfd964de0', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('84ac150d5c0a46f8935c8e6090baca42', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('854f46535e174045865acde2266222b8', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('85566f7b043b4cbabf0f123c8a4a005f', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '7363fad3490d4ae18487c06ad9244fcd', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('858203ebad2d49bcb11a944a1e47837e', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '95aa0c8f2bba4a74ab24b48d237f7ff7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8584969412774b8b96d77694b0e996a2', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('858a867c139a45ab8b0591e7a2429454', '735ba536aaa541db9f7f2f2fb445a054', '111', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('859b38d7075344a0ad5201cfce877974', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '24e3c8bdb8aa4a988f0140b3d9d60c6c', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('85cf855c5f934738a1aa3891fbc5c00e', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '02529acb13c04d85a69b719237a398be', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('85f4ccb1948f4815a5c79c2262b36602', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('8614ef6f66dd42dc94fbe25d92e7b294', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('861e0bf256b74e37b00baa93405d902f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '4466b1dbe3d1434cab6b8c3cb48b8988', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('86650808e7d8473a8b43d5ba923d4e1f', '78d5b06d83654cf8a4003b010d8574ce', 'abc', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('866f5df6c7e743f590e14b4575adea4f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '5cd819bc40d0494e81a06c1c291e1cd0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('86a8fc51e9684e25a5494b7a3444f4c5', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('86a98f8f33804708bbd8c17e6b6091ae', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'e4397c9a686148b7aa577004aebad082', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('86e8a38b8c484a07b24151e6b9df22ec', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('87080260b9bf4add97389626914397d7', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '276ff70432564aaaac683fb66f2655b5', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('879f4c76eea44efabf4d539e3344af8c', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'e62be4b2f9dc49d6a98d990260f17f75', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('87b8ad0b816a4464aec85aadcb41705e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '9761c56f254e4e29839b6376ab9cbcaf', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('87c415e3d3cd408598ac487d99982507', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'e081b42935374c8e9abfbce081aa4a4c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('87cbf9a351444bb7a0e370e27a020b19', 'fa953811bc714a90abdaabacddb01e2e', 'ddddd', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('884eb3710dfa4499badc6c0c6fa88ffc', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '2e9671f05b9c444e825bbea55e02022e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('885565cdd43b45f0806f69e609e0f97e', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '94825402dc2e414a947d1e8b1e396374', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('88592c4611e2477883fee30702d5787a', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bca01d4030994a35bee0ae3b3cd68ce0', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('88ac0620a1a54fe78aa682a04cbe2a98', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('88ae0695eabc49919538d90d61a7e6f2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ed3f1f05faf74d24bb7bdae361fb3494', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('89056b6b34b9409dadb71b5858749608', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8907e00a08b84419935fe9dd21abbd87', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '53c0f5d6b02c47c18c0b3f8114c13482', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('891441799284434ab24b0dcc358771d2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '104e53f6cfd54049901c91ea7705c18d', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('8927857ab7a34c4daa5683fb3c2a604f', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '05dc6a5e69db4487b8e038ccef01ffc4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('893251ac9d2b4113bd8f143de70f3b3d', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('899beb34b7804849872f9d94358c0518', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('89c1612f7dcf4cefb4ce494056fb4dd4', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'dd67118a497b4679a09139b771b26eb8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8a0a4453474d4530907c38a8995c56b2', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c869df7ff10a4bdab25854dd1dffd9e0', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('8a291d7894b4418a91726f3480d97a29', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8a35ca6b5d5e4125a7bff0ff9d4665ab', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8a4a736cea3a41218a0d91f98cc3e810', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8a6edc01d3604379b43ecaf958f83721', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8a7d68356d2d477db78c26da158bca69', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8aa61389c219402396e207cf99c1199c', 'a44844809c844c14a986063cb2ad586c', 'ddd', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('8ad4b233f4b0461ab31539641743cd0a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'ddb90680efb0403b884854f39ec74599', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8add13ef139c41c0b0e3def493adc0c7', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8ae42cceff144e4aa692d0ed05b12c0d', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2f0e421b5f5744afaa029cd79133086c', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('8afac85b917a4ae2ba208c57466761b4', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('8cc75c73bf424d00910832372a8f5f27', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5b7acaa6e9b9410bb1e1a5baf2afa392', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('8ce1c0e3c193418982d89f8a5f88d6cc', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'd0c2d9f3d5644de7ab32e400bb501565', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8d5345d52d084eb9821ad48415bea1bb', '735ba536aaa541db9f7f2f2fb445a054', '111', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8d595a79faa34a748e7d582fac3e8a20', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '6bf2827fa9d74c8086609ee295ae6895', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8d5ad5020eab478b980b4a7bdae4dde9', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8d63dcb05f304768985d6c8e1decd42f', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8d821dae93794ac29a1c503cfa88c335', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '9b7fd822891f4240af154bf2a2918318', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('8e8fde9236f341d1924aaded7c7383fd', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('8eb35328852a4d93a00655c59e6bd237', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ddb90680efb0403b884854f39ec74599', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8f3ec684c56241619abe55d33460538d', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '19a77c3ff2f144628dc056278d898001', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8f8163b3f7a54965be62a29e960e1998', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8f8f931b6d4e4e30a6dcf0a39beff72d', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'f0db06711a8f48b5a8aeffce8ebc4e3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('8fa522e747ca4bfc89d4746055c6075a', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('8feac3543e604881aec91edd0b0f09be', '735ba536aaa541db9f7f2f2fb445a054', '111', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('900226a7094c4ff9b1a5eaa1417a5a41', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9022239400f3497fad22663e8ac66d6c', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'da6f7c234d6b4f3e842ab3591dc94431', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('906093984ea441e89f6d0fcafae12c0d', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('90be6678e9bc4933bd53a32db472a317', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('90c62016c34440cd8a06de7265a785fd', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('90f04839df534fd688ebe81977d0b72c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '3718ccd53786409f87917727dc691ccb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('90fa0c4ff0c340a29820e5304d105749', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'bbe308240344402191a08c94f091d869', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('915a23ac96544017bfd70ea6cb11a790', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8dd7f6c8aa414b5db2beac000fd1cec8', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('91d96bc983e84c8a9a45dd5cee1b324f', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('91da2a48727f4d98825d5f54b5961858', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('91e72091cb7a49339e517a4f0092d7d4', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('91f6aabd3b6a400c8d69f4b07eac83bc', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('92e862cf0a9049a5a7ba8d4965a2b115', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ad80a366bad14330885061097f4f20e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('92f5e52776a541e9b6f4a2b5eedd6edb', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'f5456442718a41d4929dc5dd4c3baa2e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('930b5b3e0d5a42d09fedcb5ebe7477ce', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '3539d2c9999b478ab672fefbd4e47381', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('935d506be55745a0a9f129dff6953430', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('935eaca9bd674d60b99b4035bc75906a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '1b6388ab1a574474accd7a0552ddcfff', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9465ede840cc4b67af3eefdf9d3cf320', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ca451ae5931b4519802045305653c5bb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('948a7a5e7eea4bb29e5723314c5f990e', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('94de9732a6cd4524b86dedf49b7babb8', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c77df5723c8341fa84b6f72f41041ce6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('94eb8e30ff934a08a3bab790113deb09', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '2f0e421b5f5744afaa029cd79133086c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('953106ce444745f8b6c2ec2902abae5d', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('95871e837f6f4649a05beb7d095c11db', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('95de6d9fe7ce4d5d8eecba818636396b', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ad80a366bad14330885061097f4f20e4', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('96616e25651c479e8a90b7d0a07b9ebc', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'dd67118a497b4679a09139b771b26eb8', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('9686f891e6654a6db841baf3ef2a5e28', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c089e69c9892498da56237329d2ab5f6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('96afebf998e744bd82b4425fbdb5f446', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '192bdfa3b40f4d4887640948d6952b78', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('97006630064b48b49919b3244b96735e', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '823998b8d54a4ec2b5e38d8804886d86', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('971c03f575274df0ae1fe1b476fa503e', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('977e563b423f4cedae8f229863ca6bfa', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'd739ff6b114a4229bc5d0b237e41a0a0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('98071db453484cb8832f773bdcae31da', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('98a4c9a4aede487caee4a79e5dadfc63', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '84f5a249f00e45e3bb8714e3a637c461', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9945f1a57215413191a2f11e7af8a59a', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '33046447f45a44eab52fae5f8cda69ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('99db4f3f3d6242fda8a66795719e7caf', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9aa34d88f4e443448cb0d40e475c9702', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9ad3d31f066b4412ba62a1baa6afd55f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9aeec5a9041048d58e5e89980893c54d', '6da7a28d4d334dbe995fd157130fc766', '李珊珊', '941245023700467a9b59f8f49dc0fb07', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9afaa8ff6d4540108d65eec39f3519e9', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ad80a366bad14330885061097f4f20e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9b182347809a467e9890cf490d60ab20', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9b5ccc85dcc345b1801f36f5fb5461bc', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '8dd7f6c8aa414b5db2beac000fd1cec8', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('9b6871b9c1134eb39bd75f2580b7e311', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '27e2b82e10b44f4cabe24f7b315b1503', '2', '1');
INSERT INTO `box_content_recipient` VALUES ('9c0b7d02d5b845d6b274f9c007082a0c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ed086f4f793a42a29e123cd44cd14b44', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('9ccf3dea22fe4c4396767fdb0cb01e99', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '104e53f6cfd54049901c91ea7705c18d', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('9d646c87cd6d445f9061f43f72f8a982', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '31c09a9e42634d4a8eb6bd90e721c0a2', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('9d74827f825441e089136f893811683c', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'd3974e87aa6445a1bb6f014a3a52d56e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9e21faf3c5c04721a17fac0cd176e2db', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '7d33aa2eefec48709bf0d35ae895be81', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9e53958b6a8348e789ad731a91e2601c', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '2b59f373760a48cabff49734cc74bdad', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9e8c3b9cabd641468c8b6e3bf9cc156e', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '322500f1a8984b9d80a2950ebcddb84a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9ee3d637c64e4fc0b31bef6b380fa53b', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '31c09a9e42634d4a8eb6bd90e721c0a2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9f00522b4774444ca371970c6c1ec485', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '231c5bc0047044a38992bf72b8d13fb7', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('9f444b18ce85484e97caeae05811c8d2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4466b1dbe3d1434cab6b8c3cb48b8988', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('9f4501d6217147ad8e91a805eae28819', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '14223a92132c4853988d48b44dff99a8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9f61970844c2442aaa4074ada86c9d49', 'bf5d5b8f9ab1461c8a1e90d608d29e90', '张三AB', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('9f77132ac97e439980a002799ad41252', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a07dab84baf140d78eef5c8647f5f220', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'c77df5723c8341fa84b6f72f41041ce6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a089cd2671f9494d9bbde09a204d77d8', '6da7a28d4d334dbe995fd157130fc766', '李珊珊', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a0e3df0e200f46da8e1744ea265690bd', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a0f1230986ca432e95315a23eddbf12d', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ed086f4f793a42a29e123cd44cd14b44', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a127848b01dd4cd793f56c2521705947', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '2e9fab2aa6184ac39dc5774944e76d9c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a1ec726fd44a4194958c47695fa00629', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a287f7dadccc46d186ae38e384f29eca', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '33046447f45a44eab52fae5f8cda69ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a2c24cc56b3f48fea15d613be3191f20', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a2d50e1782e948228d728330664811a3', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '95aa0c8f2bba4a74ab24b48d237f7ff7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a2fb167feae24b809591521ec591e6ba', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '6245d71bcbc04ede85d35a554bd03d29', '3', '3');
INSERT INTO `box_content_recipient` VALUES ('a34a007563cb47ea8da0e3ff26ad2844', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a3b7bbf0b146403ab1afb860d22cff10', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '51603e06481b46d7bbf460cb00ba6d43', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('a3e5e7fa3533422e95cd97f1a48c23f8', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '5b7834cb032847c48a425e2855b3e1c6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a452d0e8d94447d8bc389bfc59e5d338', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '94825402dc2e414a947d1e8b1e396374', '1', '3');
INSERT INTO `box_content_recipient` VALUES ('a457608b558747cf9e5c9e0680343a9e', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('a54bd47a1cf24154bb13dde56d8076fc', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a586b764f05242d7ad82f9828bb9efc1', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '2f0e421b5f5744afaa029cd79133086c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a58d218480324b319e365abb4586e1bb', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'f980dbccfb284ba5b0fd02a698d4e821', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a5d78e05e38543ac95936cc00bff9b2f', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '75c0a87059ec48449159c1fbc983d64a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a6a896d640754d5f979cec9c668ca77b', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'bca01d4030994a35bee0ae3b3cd68ce0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a70f1225735a4a549ce645937e111b65', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f8c1d37d8ba24203b178b737bfdd122a', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('a82ff39f4c694df688c7e49294a715c8', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('a8bc485535c748dea12e88a762eb5748', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a90fe25b534249d0a036a614f40cb806', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '77262fb3438c4caf9e27b5fe429a9e82', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('a9da15c3d74d4aa2b5ea749c2a84e015', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c2fa460b62264fa98a995494d2562d1c', '1', '1');
INSERT INTO `box_content_recipient` VALUES ('a9f251acd7694979828853d2fa6dbab7', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'a0d567cd90a3499aa479bae0a8b3d3d2', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('aa68d56581b748b8ab70a7fa78ccbf71', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ab1ff7dd84074b78a765fcf177ecd092', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ab46db771445448babc73de781d7fbfb', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ab7ff948016f4a26a5cba53485fdd8fb', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'bf29b0931e1f4153b97838173feed788', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('aba545d4e71042479809ba471f843510', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ce76ffe4893143438d30030dde81c01b', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('abebaa145dac4c5b81f2b9f0b0bd3221', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '75c0a87059ec48449159c1fbc983d64a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ac1da2a879714a31982d43b1455616b4', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '4ff9d4a53203413a84eef67ca771dd28', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ac48e6b101634452acb44b446492a53a', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ac5dea42d1a8437289342f705389120f', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '322500f1a8984b9d80a2950ebcddb84a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ad01571526e8426cbdb2a2fd2386108a', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ad20c03edc5f4a0188eab47f54d2e0ba', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '0aadc19f49374982871fb57860e73d15', '21', '0');
INSERT INTO `box_content_recipient` VALUES ('ad67b95ad5464e95a3865f88e748d80a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '19a77c3ff2f144628dc056278d898001', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ae123f6aba654ed0b9b9a283f81e7e0a', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '7414462812f4423686639b42fcb56396', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ae7e36fe89c447f5ad6632db8ead7a1c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f02ca7db15dd4896a77abbbf0cbe8628', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('aed08adaf59e47afb30d09d6f1c4bb83', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '0e75147b7d3d488485646b271653f3e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('aee54679a4814225a182e720bab3a52a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '9fdb8f22caac4d989f80e0d9fd7a7942', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('af109ab647fd4901abc0eb370f3d6b6e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '52f5691102cd4a4db9a2b76989f6e51f', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('af3cfd10318a4355bb2223f805c87283', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('af496ae5b2694fe1a29eb4d0e1524674', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '77c5f43d06b947c190ef753de1671a70', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('afa5ade9116d418c97d7c62b7d9bcdc9', 'a44844809c844c14a986063cb2ad586c', 'ddd', '2d0b280b939d4a08b470619016d3cf2f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('afd861383517436a88a271913320bd9b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '2c977c62ebf94c709e607e95b56f17ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b04078384b4f4be3ad952647046464d7', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'b573dd4c9b034f38b4a363bba6a3c671', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b12edc97974c4f4dba7e1cc6c3f44b99', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'bfa741c8dcc94052a12e893afa876db7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b17451050a69426cb4fb32c0470b75e4', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '3539d2c9999b478ab672fefbd4e47381', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('b187a61faf504eb7aeb22710bf6a995b', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '53c0f5d6b02c47c18c0b3f8114c13482', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b18c132584a940ff8d427bc2691a05ae', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '9b7fd822891f4240af154bf2a2918318', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b19838db2e4c4c7c8ca72707338a57c0', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ddaaf7b2caed4a52abd1ae9c777545ab', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('b1a3bc1023754a3b86b2daf395837633', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b1a45de041fe4ed2877d72f1ead27a78', 'a44844809c844c14a986063cb2ad586c', 'ddd', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b1aa81d3d2cb481aaf52c253582cf07c', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '57e09261239b4cdd9815bed0aabc1f1c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b1c5a826bda24b5dbe5336d944499602', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '49907faae92d4d7baf9083d45f08b312', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('b1e1bbc897f24dea831e31c9fc4213b2', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '95aa0c8f2bba4a74ab24b48d237f7ff7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b1f2d14fc48f4fae97e08a8ad82e8a97', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'b573dd4c9b034f38b4a363bba6a3c671', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('b246b4999a0043b79375f69a724eb24f', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '30d35f56ff5d474c96a785f908898e49', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('b26a7936eb73468d9cd39fcc158440d3', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '14223a92132c4853988d48b44dff99a8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b2e29a307d5e4e9ca8dd2fcb62230256', '96f123b8305448259ec9d1d1a4c04228', 'abcde', '2d0b280b939d4a08b470619016d3cf2f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('b34f11f81071488492006fa108873efb', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '104e53f6cfd54049901c91ea7705c18d', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('b43a2df8b46443d6be80a5ae6ae4021c', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b463672eb1f347f596180c2a7cd21da6', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b47bf1d9af054b219954e50c9b47bc41', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b4a765fa3e2a49f8922bdc93ef56155f', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '9fdb8f22caac4d989f80e0d9fd7a7942', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b4b57517528b42ffa608caf1f48795ff', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b4e303d6d6be4a3dacc42c78f949ec36', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c77df5723c8341fa84b6f72f41041ce6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b4f8541d9862400e8bff4172d9eecf82', '4032da429d2f44ddb4cbb308ebd591c6', '张三sss', 'cabdcb2bec064d3b9704d210bbf7494c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b500373e589d402399ae3b07ddb53131', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b55291cf3c3e4412a0cd424fb652c2f5', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c599dd673915465a8bfe8c2d33cbd866', '4', '0');
INSERT INTO `box_content_recipient` VALUES ('b55a841b6a544a09968f6d5cfcd0ba4a', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '5fb25edb52ee45c9bc53ebabe75d3cc3', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b5bb97a89e85488785e968fe619ad1bc', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c869df7ff10a4bdab25854dd1dffd9e0', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('b5d150b19b8e49a19be8bd038109d4c2', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '2e9671f05b9c444e825bbea55e02022e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b5eaf4d0789943849f406679f28831d6', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '278c5e783388472eaa64faa606a1cdc5', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('b6289ca4c23048359015c1b4538e9683', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b63a945d1e5d45cfabdae9b57b72e5d6', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '585db057707c4bb0a06d450822245db1', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('b66ab75f46f447e1956220e5592e09d4', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '2fa5a25f4f044adaaca39b3376fae015', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b685d50d7f0449c19cc8852b97b24e8e', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('b6f2c97be0c54f78be798992e72ef0e5', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '77c5f43d06b947c190ef753de1671a70', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b72b8ae0711b437e9ef7c67e9153b20b', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '378a606a6cc14415a4568a9e92752497', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b7e6a944315d4c78883bf62daebdc703', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'd739ff6b114a4229bc5d0b237e41a0a0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b82cd6c862e242fb825a11ebd39d8fd3', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'd3974e87aa6445a1bb6f014a3a52d56e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b853baccb7464944b0ee1e0ccd680774', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b86f2f02ce744456aaee7156035dff0e', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ca451ae5931b4519802045305653c5bb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b8ae9afea9a649df91a4869bb0c4a2b9', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('b94df78b258c4d6eb061a44de0a3b472', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'f980dbccfb284ba5b0fd02a698d4e821', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b967416fca5041379d52d58c56d4cc90', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c77df5723c8341fa84b6f72f41041ce6', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b996d350a6034e888b117e631f1666ec', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '6c11191e3200490c84a70bd543948ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('b9b34fa93aed4f49b4ba067446fb8e5d', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('ba379b9f367a48dfa03370e46ed7addc', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '53c0f5d6b02c47c18c0b3f8114c13482', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('bae0c3fb326f42ce92aaf7b60ce8f017', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('baecc473b2434979981ac098a07a1d10', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bb0694fd843c411ea3fb728b5fd617e8', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '14223a92132c4853988d48b44dff99a8', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('bbdc776163114715a711aa4ed78dcccf', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '3a00e49ed46f42f3a2af1836ed9103d9', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('bbe1515d407644fc9ea6ceadfe7e41d3', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '51603e06481b46d7bbf460cb00ba6d43', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bbfee0f6498e4a71a2fee0efbc3aeea9', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bc415fe31de1422f84b3117681b1bb97', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bc915e6401a54f2aaefd69ed69d19cf5', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ea77b2fb4e1348a9b045d13ab6f998e9', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('bc9b148935b34345a9f4ff361019e863', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '9761c56f254e4e29839b6376ab9cbcaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bcaffdc7bf374937be442bfc55834608', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bcc8b70c7235471f9e0056a6b015a52f', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('bcd51443eaca4346872c547bae84ac99', 'bb077ba78d9f4857876a405eba6a5e66', 'ttt', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bcda8211d56a42fdb99acbd0d2616739', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bcddac79142d44dea558b57e689b57fd', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bd4f5e4491284396acc96f9c0928d0f1', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '33046447f45a44eab52fae5f8cda69ab', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('be3845df33af48db8fa0312d2eb71ece', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'f980dbccfb284ba5b0fd02a698d4e821', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('be443aae1969451497cc5cf9aa21f2d7', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bf2935812cf5470dad14c0d1642e135b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bf53d837c12d4bce90d7cd4011c06cd6', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '51603e06481b46d7bbf460cb00ba6d43', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bf70161ada9c43bc8ffafd282c085567', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bf8245b959c34d5aae76e390ac988537', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '792b853da83247ec96b2c6d1e32a8ea4', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('bf892a03ca2a4e14b3a4ccfb0065f69c', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bfdd6b16daa24abfb4d5700102552500', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '9fdb8f22caac4d989f80e0d9fd7a7942', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('bfdfc376247d4426b2957476634b90ce', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '4691d19717194e6381c9c8c98179fc1e', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('bff59282887e406b8ad23f69f9b484b1', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '4f5bac38ac134d3ca61dfdd3cdb45265', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c0d01235545d4c33bc9425a1d7196bb4', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c11666ba0884491bac1c6662fa87433e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '3718ccd53786409f87917727dc691ccb', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('c11b2512c47748bdb5b32b7b83a87d5c', '735ba536aaa541db9f7f2f2fb445a054', '111', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c11d02082d8945378112b1a00ac2e6e8', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '6245d71bcbc04ede85d35a554bd03d29', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('c177fabe0485484e9316c9c41e62d7df', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('c18ec46659db4e9e85acffe93c563020', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'b573dd4c9b034f38b4a363bba6a3c671', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c1c08833cdc14a0393acbd08ab2f6837', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '624b0f0db81d4cdaae2f4608b798d069', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('c1f0470509af4911b035e4dbdac0f6c9', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'd739ff6b114a4229bc5d0b237e41a0a0', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('c2689e8c67414eef9cc242089a553995', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'a0d567cd90a3499aa479bae0a8b3d3d2', '1', '2');
INSERT INTO `box_content_recipient` VALUES ('c26ed5a2edcb4815acf011e1eb5bf983', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c27aa2558175495cb942fb53fd508513', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'd3974e87aa6445a1bb6f014a3a52d56e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c28b8971170242ed9cc20d104ffff97e', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5b7834cb032847c48a425e2855b3e1c6', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('c298550e568a488090d5af60ed08922f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '19a77c3ff2f144628dc056278d898001', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c2b4c8634fa047bb800999ab5e110591', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '8c0f07dd06c64b5b9b677e83e317ad01', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c33287d3d78740e781657414436078f3', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c3b27c8500f94550a6d7b396cec3a5a2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2b59f373760a48cabff49734cc74bdad', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('c431b12d4fc24829aca198d622343a55', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5b5877bba7d84e7aaa4940d4e43f15d2', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('c4490bd978864651a06371142afb3225', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '9b7a976df24a4fdd877cb9c37d95b1bf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c4d0d370ae3b4533985ebb43a51c7d32', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '7363fad3490d4ae18487c06ad9244fcd', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('c4f9ffaf08c54a349912d6f8078cdadc', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c4fb6cf5248f4b60bc68d951afe621af', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '9761c56f254e4e29839b6376ab9cbcaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c4fe26bc577846c1b5696e7a3ff63197', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '5ae39c03921e4fb68ff4f02f1763e57f', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('c5182790e83c48e7a759fd2383fc51b1', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c5364c27de9b400f9b7e0659599e0ca8', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ad91fa0172f8426c8070edc26f9ec7ea', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c57d0e23a7c743b0ba1bfaa6ee3648d6', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8c0f07dd06c64b5b9b677e83e317ad01', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('c620c7671fb84a2d8410d4c4099bf13c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '5b7834cb032847c48a425e2855b3e1c6', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('c6266435b7c04d2aad97c8f1bdb81de2', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'f5456442718a41d4929dc5dd4c3baa2e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c69dccb1408a49ce9df018a091e15d6b', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '57e09261239b4cdd9815bed0aabc1f1c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c6dca3b77cc646b6bae5e539b9fdd2ec', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c7740a13be8645538d88ea7659037174', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '53c0f5d6b02c47c18c0b3f8114c13482', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c77605f3bf5346e29308ef8235fb27c8', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '57e09261239b4cdd9815bed0aabc1f1c', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('c77d769bdb75489faa2bd4a5e592ab03', '735ba536aaa541db9f7f2f2fb445a054', '111', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c7a593a0d199443391a6b06c36f881c5', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('c7bb521145f4479988ecebec543f7107', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'bfa741c8dcc94052a12e893afa876db7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c868571f9ff04b1a8733f0dc241bc6d9', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c87d18215fc24a7baf60af1bf23aa443', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '5b038fbbde2f497fb72fe500102dc292', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c88303ad5c7b420fad6e31407fe16029', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '792b853da83247ec96b2c6d1e32a8ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c894467dc058488cb0101ebf58668588', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '2c977c62ebf94c709e607e95b56f17ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c8a5c6a4dbe442259d884e9056953a3b', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('c8d027c71aad4b9aae130651edc09f37', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c8e8cc142f554dcbb99ca04901cfc0d7', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c90c879108474200852d0b1aecfa4764', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('c95f3a30929b40b8ae8d09d92ddd33f1', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ed051c2e099741489f54a58ee69a17cf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c9b9ab8747854b8c9ad7184135c7cb67', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('c9e2598d306f40059c9aae065afbb419', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ca20d0b0fc1445d8ab4262e827a06006', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5fb25edb52ee45c9bc53ebabe75d3cc3', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('ca2124dade8847daa29f77af5dff9f92', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '57e09261239b4cdd9815bed0aabc1f1c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ca7905a9ff7845bab0a9ba892fb288ed', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '14267b7a97c848f0a798df7f960d8a9f', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('ca7e44211e0d4bf49b8182ea891947cd', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '61b92a1c56e044589ab382fc0539c3b4', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('cad198e5f2664cc896b2be4f105186aa', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'bfa741c8dcc94052a12e893afa876db7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cad5d46ef7e94043a6024ebc18542980', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cb6d62c2a5794f79bc6b057ddda63c78', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c13bb0a2ec214221ad9450b6dcc26199', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('cb7767ce0ba54805b02e89782921f33c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '8253262e5d564b1cbc34517e194aaef5', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('cb85528753ed4f629ecf5b89cbe5427d', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cc7505dce417480888d2a5f84c636693', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'a4dc2c092ce44b32bab662f8302c19d2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cc80ac723758414ca5cac80f91a5bb88', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '2991b304ecca41c9bde0ceb22a2cc6fd', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ccc162ad08734430bcc10b365adad6a6', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '9a90c47db1fd425d8b0a3566c0fb7704', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('cd188d3a7aff4d0a9850007b245d50b8', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cd5b29de4e984ea69ba0726e5e9281c2', '735ba536aaa541db9f7f2f2fb445a054', '111', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cd80731ef53844d59ff4b22fd99c9a05', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '77c5f43d06b947c190ef753de1671a70', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cd8be81e84e140388bc073d40029ba0d', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'bbe308240344402191a08c94f091d869', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('cdb37e2947234b5d817fa2c0aa1c1d43', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cdf3a231b8b64c2c8292727db57ed285', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c3f8bafc39fa4f499184bd50647e7e2c', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('cdf614ffadf1479888e2bcba1ee168c4', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'bf29b0931e1f4153b97838173feed788', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ce090a5bbc9a4b829d919ec350c9c1ec', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ed051c2e099741489f54a58ee69a17cf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('cf85a288c4da425e923f8b3af024a377', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '792b853da83247ec96b2c6d1e32a8ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d034b2aad0b64f9fab49e4e92ad85b86', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'e62be4b2f9dc49d6a98d990260f17f75', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('d03d027f76db4c82b1c321f1de16a166', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '5cd819bc40d0494e81a06c1c291e1cd0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d130ce73beb44e41aefad7b36d3a2d55', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '33046447f45a44eab52fae5f8cda69ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d138d86f0c864a4382705a0d198eae98', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('d164c02b52c242d0bd62cf113007d901', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'bbe308240344402191a08c94f091d869', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d1691093648b4c5b8c9a975d2746fae1', '735ba536aaa541db9f7f2f2fb445a054', '111', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d16ef0a415104e5a9d585165484dc6a9', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '2d0b280b939d4a08b470619016d3cf2f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d1c8fe7a98e9489281c38ae68f4c3684', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '7414462812f4423686639b42fcb56396', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d1d8cbb6462c41f88990916df2e42649', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('d23a9890b82048e3bb7db9a6ff539fb3', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2e9671f05b9c444e825bbea55e02022e', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('d28739d02d874f8aa877f745e4446037', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '1b6388ab1a574474accd7a0552ddcfff', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d2acb7fe5335445d907fa919fc76ac44', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d2cc97323ff4482fb74f6c62012ffdb8', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d2d5cdb00c72462f96c0a299e98d2e25', 'f977c3d92de04d8f84270a20614e3b18', '张三', 'c4530aa18d954fbf96a74648d6a1e642', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d2e58a8e91c84d028e439a39e3e1c6c8', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '9761c56f254e4e29839b6376ab9cbcaf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d2feb6a2bd5a48a29aa1c6c63f6af4db', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'c909f46bec3f4e4985c4096b959bfdf9', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d315f4bd52e54fe7ba2374533db43f7c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '48f034b84a77439192e3d383d767767c', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('d36c4adb21ec4ca8a5c236a4a534fb26', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d3b7b9934e464c91a4574c8d7537ce25', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '322500f1a8984b9d80a2950ebcddb84a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d3dd6025d9f549a29089f8048f739c4d', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '2d0b280b939d4a08b470619016d3cf2f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d3f90a48ee4c4a1195ed3bfe415f7730', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '72a30e3b9e3b43a6ad21bf8b8d9a519f', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d41c7b4b7dd64a5e92680ded944d2319', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d44f88b657f84175bc7a33dc58f15d22', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'e62be4b2f9dc49d6a98d990260f17f75', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d468a5550f0b47ae900bf0598d7ea3cc', 'a44844809c844c14a986063cb2ad586c', 'ddd', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d49b635a8ba44b1e8e0f38617cc6b8dc', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '06ecfdbcb11642cd99d06d4f2ea3aee1', '7', '1');
INSERT INTO `box_content_recipient` VALUES ('d4b487a6190c4da19735458a86adbf51', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c3f8bafc39fa4f499184bd50647e7e2c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d4b5fde1d7594cf2b99c3d26a67be26c', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d4e46509b6a74f7e8ad90ca46f7b4016', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d4ee8b2b598940caab53a4c0a27e6929', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d585b33cedf743d980586446508709d5', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d5f34b0c3b704388a7721dde3371b956', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '2c977c62ebf94c709e607e95b56f17ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d642766605ba4f49a7129be0f3091565', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d670afcce5f245349a354aa5627f8a90', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '7d33aa2eefec48709bf0d35ae895be81', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d6b116474d1e4a3487093f6ee38b256f', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d6b6746c86f74c3bbda1406354260ec1', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d6dc0342fada4eacba1d50ebdf79d5e9', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d78703f9d071475b8d9d36db10d3dd72', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '8dd7f6c8aa414b5db2beac000fd1cec8', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('d7f38d7c370a4117a8b98b2650b32f16', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '95aa0c8f2bba4a74ab24b48d237f7ff7', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('d7fd3a9840ab43eba4cdddddb017bf78', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '8253262e5d564b1cbc34517e194aaef5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d8ad882a65ab4884b386faba6b2ea927', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '05dc6a5e69db4487b8e038ccef01ffc4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d8b6ef7665104e379dbc32bbd0f814c3', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d8f9668bda464486bb84b5fbdc885e34', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '19a77c3ff2f144628dc056278d898001', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('d96a06ea287f4a79ab35885665656f55', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d9864fb7fa734cf694e45eeae6401171', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('d9b000e4b897427fa7d18194d7fde632', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('d9d0ee708ebb4b35b93c46b81fabd0b2', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '9b7a976df24a4fdd877cb9c37d95b1bf', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('da24f94db7fd4c9892500991e3ce9aa5', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('daada691823f4b9396a63218a1d27fbe', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '68800675a5e740ca8ef5c03bf094517e', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('dafbf6df3f1143e8837ec87bbbea898a', 'a44844809c844c14a986063cb2ad586c', 'ddd', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('db652ddec2a84b26a5da9a781fb94697', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'e62be4b2f9dc49d6a98d990260f17f75', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('db6c25868cef4410a32b9f352f57bb0b', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('db8d20ff4d0749dcbe9753d40868c76c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '285be4cdfd6c47cda043abf717913dda', '1', '1');
INSERT INTO `box_content_recipient` VALUES ('dbc359e93a0d433b96f06868b532fca1', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '57e09261239b4cdd9815bed0aabc1f1c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('dbf855eaacb04461bc72b424316320b7', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '1010177543954128afcef296b2cb6336', '3', '2');
INSERT INTO `box_content_recipient` VALUES ('dcd54e36edd64b54bee30f544fd9c216', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('dd9b751c6aaf49cb951e1e5bfafd0227', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '2e9fab2aa6184ac39dc5774944e76d9c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ddc01979494d4f2fb3ab2003fb30618c', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', 'c02bbbc8d7514bc89ddc18b9cdb9a681', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('ddd00831acec42439aa7c7df08a3fea3', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '75c0a87059ec48449159c1fbc983d64a', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('ddd833daf0f04e9fb54bc5a3ce5d4f3c', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'f5456442718a41d4929dc5dd4c3baa2e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('de82887ba02f457b88904e1745944058', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '2e9fab2aa6184ac39dc5774944e76d9c', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('df1aa86ff6e3494caa2dfb742d2e2ead', '9faea581c64c413681558fbe86cd9fb7', 'hyyyy', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('df34dbef909645f08909af20b438f554', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '0e75147b7d3d488485646b271653f3e4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('df8af3312c0f4a59851af2606d02559c', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '88406a7d10694f33843ef212a20d6ba9', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('e00c8d07f52440a395ae81075c4ecfcb', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e06b35e9d4df4e409da2b3172a92ed92', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'd0c2d9f3d5644de7ab32e400bb501565', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e0c49299b7eb48b08a492492dbfb3a88', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e13f5075b78a4cacb7afd1c9e8d67535', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '6bf2827fa9d74c8086609ee295ae6895', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('e16e5608e2c2418f909fbe9d018c6728', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'acd12065f71548bd9d10b2a6186df028', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('e1bfe1abd0e34a088ced973d952eaf1c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'c802652eac504cbf889fe406a2b565c4', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('e1c02ca6-74ca-4a9d-b52a-9885f1838936', '36d416641436467b8d68392fb11c537d', '门诊科', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e1daef7f44b34b8a928265022e6d75ae', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '95aa0c8f2bba4a74ab24b48d237f7ff7', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e2591973cbe043248870703e607f3b90', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'e62be4b2f9dc49d6a98d990260f17f75', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e2aafe0be99647098b11f64a65f16e45', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ba54812ab6574f21b6913c54b43fcf4a', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e2f4bf0403aa4200a2b794b98b5a9bc7', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '3cb1c2977476478c829ac4dc9f6daaa1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e2f8a4bffda947c882c7483a26b8c7ec', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '9b7a976df24a4fdd877cb9c37d95b1bf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e32d13cd9b7d4ad69f3986ba6918a9b8', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('e3968577b81742f18a59a64eb6826441', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '02529acb13c04d85a69b719237a398be', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('e3a3250b6bf4450997827b572f9c3f15', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '4fef97409d3847beb819f2402095ff6e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e3a5e9c83bfc47df92d9bdb31ecf08af', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e3acd6a59f5145c583d345ba7b14cee4', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '7cf1c03b682248d8b892dfb1bbeda701', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('e3b2e206052c43fdae9a9b186dfe8aab', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('e3c0a3794f8643fc9f72dee351e221f6', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '0aadc19f49374982871fb57860e73d15', '21', '0');
INSERT INTO `box_content_recipient` VALUES ('e408969189994446acb180e43fca1f5c', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '3718ccd53786409f87917727dc691ccb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e4847d5cc4c941a9af17a6a84dc42c4f', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '3539d2c9999b478ab672fefbd4e47381', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e487d5175d3d4beb9862c31f49ee316c', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '84f5a249f00e45e3bb8714e3a637c461', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e4ef767f579d4ae2a0838cfe26627527', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e548c2836ad3429a8b380f393c193c1b', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('e591f0d4c2ff4cd49ce46d67a2c37fc2', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e5cd10d3e8cc49a79f74ef20d4dab36e', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'da6f7c234d6b4f3e842ab3591dc94431', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('e5d102a43e994a8383ae2fbddcd2671a', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', '823998b8d54a4ec2b5e38d8804886d86', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e63e1df399ae4202916bd8bebf77b52d', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'acd12065f71548bd9d10b2a6186df028', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('e7af8283d1054e5e9042d6b198b77be2', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e7b485fd91fd42c09b9d80f844d39f64', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e7f1578b54cf4a2ab8beb2b987f3e8e1', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '53c0f5d6b02c47c18c0b3f8114c13482', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e81426332b70477eb5cf647fb7c917eb', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e88eaadf683e4a029802f0a4f9361ad2', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '30d35f56ff5d474c96a785f908898e49', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('e8d4925318b647198302ba596e69cb94', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('e8da62581c6f4f34a24ee5ac8b3cf98d', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'bbe308240344402191a08c94f091d869', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('e9e04ae43642428dbba2327e424926ae', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '6b0bcda9892e4cadaa6fb3404a896a00', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ea0b84a7a33d4ef4b524ac8b6342d4c3', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'f980dbccfb284ba5b0fd02a698d4e821', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('ea887b8aefd9405e886fcc2cbdbf736f', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c599dd673915465a8bfe8c2d33cbd866', '4', '0');
INSERT INTO `box_content_recipient` VALUES ('eaad4f17338447d8bb62b64f5787f3a8', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '2c977c62ebf94c709e607e95b56f17ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('eb0e2e7119a340fd91305127a8d0022a', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'fef9970b5e354281b959535a1eb5ae61', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('eb1c96a9000841268f89fbc0fa7313a9', '96f123b8305448259ec9d1d1a4c04228', 'abcde', '4409579659a540a8a49629bd6c6e43fe', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('eb47446e3f1c49108de6c6017d3d73ab', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('eb947f492d464b019074e7dc8e90f275', '8549cb4b4c04415fa0d9ab6598e42c5c', '黄小明', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ebcdd38e228747deaab6f5191ded79a2', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'c13bb0a2ec214221ad9450b6dcc26199', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ebe57750aeaf4b978b4ba36d2fef3832', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '18d9b49a830c456dabde748d843ed416', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ec044e9fdb014e25bc18c75861be3b3f', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'e081b42935374c8e9abfbce081aa4a4c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ecaf790084794d8e9f6504fe00487a6c', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '68800675a5e740ca8ef5c03bf094517e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ecc04fb7e2a244abb8f17377e335a1cb', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '14223a92132c4853988d48b44dff99a8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ecf4b84f27df43afacf7ac36c1331324', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ed8c2b6d86fc446394b30d809300da67', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ed9d16f25f984479a6c012a5a3a08276', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '9b7a976df24a4fdd877cb9c37d95b1bf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('edb37f14f070452ab2a6a74d57879b58', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'ad91fa0172f8426c8070edc26f9ec7ea', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('edb4a0104ef24a6a9175ad538f424c0e', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '104e53f6cfd54049901c91ea7705c18d', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('ee3eedc71b194bda9da3d1d9e384e1da', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'f74f2827879846b7a114f84212f7037c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ef0aece8ebbc40e780fe10b20f8824c7', '9a84879cfeab4578a04b0747f189d4aa', '测试联络人', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('f007c505633742b3877fe32961099d54', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '18d9b49a830c456dabde748d843ed416', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f016c31154384b96b92b072c163cd880', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '2e9671f05b9c444e825bbea55e02022e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f05df8fe48164e01b1e77922dce70c2e', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '7414462812f4423686639b42fcb56396', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f108b62e80514808ae09b6c1c328438c', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '3718ccd53786409f87917727dc691ccb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f1745768bddf4a33b272ae59cd782db9', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'c909f46bec3f4e4985c4096b959bfdf9', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f1c30274eb324596a195b68ed65505f8', '6c0f3e926f06446781f9dc013faf75c7', 'admin', 'da6f7c234d6b4f3e842ab3591dc94431', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('f20f75f4f5314613ac7616fbb9df1c17', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '8253262e5d564b1cbc34517e194aaef5', '0', '2');
INSERT INTO `box_content_recipient` VALUES ('f213d7b336d14942ad27bc355da42d76', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f2521d1abeb54902a2d37b9bdf783ebf', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '51603e06481b46d7bbf460cb00ba6d43', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f2a6c56e93d94366a240927e693b2fa8', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f2ec16a5a327410ba28559fd2c54e8a2', '5b576ee3a25c469fa284ef44c995fd92', 'uuuu', '24439695880c44f78458c1b3dcc83978', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f308596751cb4b8899294526e8a7320b', '09cde27c56e34a5e98f1cffecb19394d', '邒肯睥', 'ab5d3e12f76d446386459ed5f56a5a3c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f41b494c1bca4730b20d90bb4e8b78d8', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('f435b16130fa4451af9c4584d233cd47', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '792b853da83247ec96b2c6d1e32a8ea4', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f45ae4f43e7f4f709fdce2457e8e3d53', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', 'f355c530cda94c9ab8e2ef2debf8f38f', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f475a660047b4bfe885620137bb9848a', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '41b5d540060a402889d86d5abee22e7e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f4b2a5b1ff714546853fbae322ec0f16', 'd95a9ad3b7ac494b846278d96f6a4912', 'yyy', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('f563c47c8f834c78a4ced0029d42a1e6', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', 'dd61359dca214824a493a9d0abfe264c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f58474396a0143f194e047932001622b', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'd739ff6b114a4229bc5d0b237e41a0a0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f5cf68d7ac0f4721ad04171b41cd7c5f', '7bfc995a6c204df4b6142db2b24e943d', '会诊领导', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('f5d7f20ee9504562b57b88349a04941c', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '4f5bac38ac134d3ca61dfdd3cdb45265', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f5dd9959d80546728624c297a32ebe4a', '735ba536aaa541db9f7f2f2fb445a054', '111', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('f62a95564f47449ca2b1a787794828fa', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f62c16c1f3744811be602ddaa6c01ccb', null, null, '0c181bd3b4de4202aa9f8d1afb5d2d36', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f6ad4e172ae14e41814fc8ced132bfa9', '5c713a04f87f4b5798003347a6c10366', '会诊医生', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f6bc5fc4eca14ed18ad6da4fc21f7b4d', 'a44844809c844c14a986063cb2ad586c', 'ddd', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('f6c1cdfdc9b1452eaae8e2f0c238d1dc', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('f72267d8aace4bcb9b47463ebb6e6678', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ed051c2e099741489f54a58ee69a17cf', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f76a6bc1175b492d8d6d2f73e48bb608', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '77262fb3438c4caf9e27b5fe429a9e82', '0', '1');
INSERT INTO `box_content_recipient` VALUES ('f79305d038a347458353ec925dc3fa63', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '7d33aa2eefec48709bf0d35ae895be81', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('f7d9babb479b4979b1c61c5defd8bbd5', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'bca01d4030994a35bee0ae3b3cd68ce0', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f863328facd44917a0e22184f9a513cb', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '6245d71bcbc04ede85d35a554bd03d29', '3', '0');
INSERT INTO `box_content_recipient` VALUES ('f87e10b8044e4eb0aff08f81d620dd3d', '5ac8e6855b534c1e939e09de6f6d720f', '宁仁佳', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('f8b79a15bd5b4a7c8c47b08c242c1e2d', 'a44844809c844c14a986063cb2ad586c', 'ddd', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('f8f2b2845b57412489b25a60d73bc408', 'ce038092a81e4ad8acdf99de8e4b50ce', 'ddd', '854bfe9f300447538d87357dc95299f8', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f95916fe25ff451f8fd438511f1528a0', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', 'e4397c9a686148b7aa577004aebad082', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f98e589c19f046e29dffbd42ff512eda', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '7363fad3490d4ae18487c06ad9244fcd', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('f99a6026b67945658c3bda37e1e1dcc6', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', '9a90c47db1fd425d8b0a3566c0fb7704', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('f9bce193e6ed418b892ae25645a65437', '3fdb747fffaf496e93d37d7810c68cb2', 'rrr', '27e2b82e10b44f4cabe24f7b315b1503', '2', '0');
INSERT INTO `box_content_recipient` VALUES ('fa025e5b561043d1b0245da520bcc0c0', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '61b92a1c56e044589ab382fc0539c3b4', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('fa1ebf3d9ece4de0ad4405b0904d0337', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('fa1fd57deeef439cac438879dd3a4d0f', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'd261043725544327bb2618dbe29a96b1', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fb3b8a07-a871-49e6-b6de-1e9c044ae678', '36d416641436467b8d68392fb11c537d', '门诊科', '285be4cdfd6c47cda043abf717913dda', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('fba55f18d1f4488e8c563335a17ae79f', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '055188e4b60e482bb06349c2e701b5a4', '8', '0');
INSERT INTO `box_content_recipient` VALUES ('fbb5d714e9e44fae88d6c170322e6091', '5c713a04f87f4b5798003347a6c10366', '会诊医生', 'eadf4ba641e14783adb3ecc72539af05', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fbc92cad54a24d8db342d4d1ad07d188', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '2e9671f05b9c444e825bbea55e02022e', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fbf67b0e820843ac838c757742d7c825', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', 'ddaaf7b2caed4a52abd1ae9c777545ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fc6ac56bed3741b2a8d5fe2279c55017', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'e92bb815bc3b4bae927f0570d9307f44', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('fce08950021745ba907d83545c9eef3e', '3fa644f4c8a04b2b8a2d014e2607dd0f', 'sssssssssssss', 'ddaaf7b2caed4a52abd1ae9c777545ab', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fd27920aeb624eba9634559c27e6fdc2', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', '6bf2827fa9d74c8086609ee295ae6895', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fd2cacbde55f49feb4cda69148a8e945', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', 'hhh', 'e18b850ac1a2403cb87cfe4c0b028eda', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fd41840cc10f4cc9b4f746bb677bf31b', '6c0f3e926f06446781f9dc013faf75c7', 'admin', '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '0', '3');
INSERT INTO `box_content_recipient` VALUES ('fd5045ba5bdc45c7871a3f69c0908d93', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '5fb25edb52ee45c9bc53ebabe75d3cc3', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fd722e1f610e4abeac9805cfdfd8723e', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '李四', '84a48e32e91340679e96a9017d0eab7c', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fd9d489e98b644faa7d8f651d0deabbe', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'bbf6f9f5d3894b91b89dad70394c74de', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fd9f1f63b8f44e1c833926ef9780713e', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '3539d2c9999b478ab672fefbd4e47381', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fde011a9fe0a4362834f26bc1d153d02', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'c909f46bec3f4e4985c4096b959bfdf9', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fe159111ef0b499f80b136295af6c983', '3231550759a74c7e87a5ba9b78fc6b0c', '阿蛤', '066bc75862be4424892a75805e85ecb4', '5', '0');
INSERT INTO `box_content_recipient` VALUES ('feac5699a27048568c8dcd3a08c0930a', '082c86c807c14aac8b7ff5aedea5cef2', 'ssss', '7363fad3490d4ae18487c06ad9244fcd', '1', '0');
INSERT INTO `box_content_recipient` VALUES ('fee860559ef04a7080835975ed6f266a', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', 'ca451ae5931b4519802045305653c5bb', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('fefba9a3f5db4f2ba5e3e8f178901cd7', '4dea9acd67954ea6a0753e339b03ba7d', '测试1', 'ad91fa0172f8426c8070edc26f9ec7ea', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ff0197bc4adb45fbb5461f63d94c07ff', '8a6fea61aee249848261dd684b7f8460', '测试1的领导', '31c09a9e42634d4a8eb6bd90e721c0a2', '0', '0');
INSERT INTO `box_content_recipient` VALUES ('ff63535aea2e46d08f58739ec9f3de4a', 'f977c3d92de04d8f84270a20614e3b18', '张三', '7cf1c03b682248d8b892dfb1bbeda701', '3', '0');

-- ----------------------------
-- Table structure for `box_d29f472e98f04628862e2dac55e04a7a`
-- ----------------------------
DROP TABLE IF EXISTS `box_d29f472e98f04628862e2dac55e04a7a`;
CREATE TABLE `box_d29f472e98f04628862e2dac55e04a7a` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_d29f472e98f04628862e2dac55e04a7a
-- ----------------------------

-- ----------------------------
-- Table structure for `box_d60274f6da6c4367b49b7f8ed551a661`
-- ----------------------------
DROP TABLE IF EXISTS `box_d60274f6da6c4367b49b7f8ed551a661`;
CREATE TABLE `box_d60274f6da6c4367b49b7f8ed551a661` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_d60274f6da6c4367b49b7f8ed551a661
-- ----------------------------
INSERT INTO `box_d60274f6da6c4367b49b7f8ed551a661` VALUES ('c6fc3d2d-2c8d-4296-929a-340b119d8eba', 'd60274f6da6c4367b49b7f8ed551a661', '张三', '1.0', '55.0', 'admin', '2');

-- ----------------------------
-- Table structure for `box_d65090d9a51e4603b32b7bddad88dada`
-- ----------------------------
DROP TABLE IF EXISTS `box_d65090d9a51e4603b32b7bddad88dada`;
CREATE TABLE `box_d65090d9a51e4603b32b7bddad88dada` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_d65090d9a51e4603b32b7bddad88dada
-- ----------------------------
INSERT INTO `box_d65090d9a51e4603b32b7bddad88dada` VALUES ('890d4c40-9a95-4524-bad0-a3988a236663', 'd65090d9a51e4603b32b7bddad88dada', '张三', '1.0', '55.0', 'admin', '3');

-- ----------------------------
-- Table structure for `box_d8ad74ee98d049e8a4502d5ecbc32747`
-- ----------------------------
DROP TABLE IF EXISTS `box_d8ad74ee98d049e8a4502d5ecbc32747`;
CREATE TABLE `box_d8ad74ee98d049e8a4502d5ecbc32747` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_d8ad74ee98d049e8a4502d5ecbc32747
-- ----------------------------

-- ----------------------------
-- Table structure for `box_data_field`
-- ----------------------------
DROP TABLE IF EXISTS `box_data_field`;
CREATE TABLE `box_data_field` (
  `id` varchar(64) NOT NULL,
  `box_id` varchar(64) DEFAULT NULL,
  `key` varchar(128) DEFAULT NULL,
  `value` varchar(128) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_data_field
-- ----------------------------
INSERT INTO `box_data_field` VALUES ('009b7906-e5c3-4046-8728-6edc59e43336', 'a92c64ea98334bb9911b144e64cbdd28', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('0345f8c4-3d2a-49c4-81a6-c5e21f763a5b', '2fa5a25f4f044adaaca39b3376fae015', 'yonghuming', '用户名', '2');
INSERT INTO `box_data_field` VALUES ('04c9e6d7-6c4d-47fb-a46b-470b6cf7a26c', 'f0db06711a8f48b5a8aeffce8ebc4e3c', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('04d56b28-17a4-4e86-b672-22102f4a741c', '0c181bd3b4de4202aa9f8d1afb5d2d36', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('0942f47b-b6e3-4b13-97d0-02b6932ee5d6', 'c4530aa18d954fbf96a74648d6a1e642', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('0b55821c-0cfc-4a08-9b41-1cabdfcec62f', '74a23b593b514d56870df8e04d61ba77', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('0ea90135-dd97-44f9-9ed1-53ece390fa61', 'a3a90bc8719345c1b192360f937e6526', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('0f0c39a8-a5e5-4fba-be55-d760f86a0c52', '7963fbfcaf2e409f9bc980ab80efc45e', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('1010a039-4dbf-4bce-892b-e42c22a9ccb7', '0c181bd3b4de4202aa9f8d1afb5d2d36', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('10892915-d6de-4fcb-a18c-330be3aebcde', '6299bc217cd648588a34b7a1d1c7b72e', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('11316c2a-b88b-4e83-b493-54bbe4d27369', 'c4530aa18d954fbf96a74648d6a1e642', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('113789b3-1fc0-45be-90f9-e58ff85e0fae', 'fce11e7c96f74c7e9dc3c02b545dc243', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('18271633-8a94-47c8-a0cb-d87406c932d6', '4b8e9f81f2dc404092cf18050655d3a2', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('1850ae3c-2823-4918-aed7-da8fc42c3cca', '585db057707c4bb0a06d450822245db1', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('1adae392-5a27-41d6-8211-e6d2ea62810e', '672f11000229409f85a2e95ecfbab441', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('1db7ab77-df90-462e-87c2-3fa4d85a34c0', '74a23b593b514d56870df8e04d61ba77', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('1e7ba2ee-055f-4bbd-a044-f6a781e5e4e1', '4b8e9f81f2dc404092cf18050655d3a2', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('2136ac46-93b8-440d-9882-3da6f5f05137', '624b0f0db81d4cdaae2f4608b798d069', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('222560da-b4fb-4d19-9a2b-b51911dd0dd7', '9d8eabbe39254f5eb4c8a9a6b97b5ed2', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('23b26f59-abcf-4b90-aa06-cd007054ddee', 'fce11e7c96f74c7e9dc3c02b545dc243', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('26745eaf-7880-49e4-a5e2-60f2ea23f50b', '2fa5a25f4f044adaaca39b3376fae015', 'number', 'number', '0');
INSERT INTO `box_data_field` VALUES ('296023e4-e834-42cc-ac59-f8c7ce359d6b', '7cf1c03b682248d8b892dfb1bbeda701', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('2b09a86e-0111-46bc-8924-64cb49789e1e', 'ff8b78f81c54471da949861b9d2fafba', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('2c94cb4f-281e-4c44-a796-6ed235056d42', 'fe2d02433add476badad87c536e0b491', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('2dd6c998-ff2b-402a-ad70-63c01c8d163e', '57950932014e4003873fc2bc8032662a', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('2e236dc0-8706-4593-832b-55416f6ee1a1', '9d9a8ac5f65c409bb712a1151a04f122', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('319f89c6-fac4-4fac-8e10-37c91043353a', '8c055a1e3da94e499d0b1f0565455b94', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('360772ef-693e-466f-bc72-351dcdf6ce71', '15ec6c44c2da4a8282206bdd69ad89bb', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('36b31a84-4868-4308-aa4d-456561ce674c', 'fe2d02433add476badad87c536e0b491', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('3bf1539b-fabb-44d3-b199-c406e4bc8770', 'd60274f6da6c4367b49b7f8ed551a661', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('3c406275-a6cb-4b51-bdf3-dc97aa9898ec', '5b7acaa6e9b9410bb1e1a5baf2afa392', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('3e89910b-fe11-45ee-9ffb-f15653418b11', '97455708691c46cba95bdb6f01309a38', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('3e9af31a-d3eb-4b65-8378-a1f1cc819da6', '57950932014e4003873fc2bc8032662a', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('3f54181e-0596-4c15-87b1-541e290ef86d', '54e3bb7621bb423ebf2be41900fd6d35', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('44e50a8a-a37c-4e6d-a19c-ada540eb2606', 'fe2d02433add476badad87c536e0b491', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('4b92964c-50e3-4191-b438-17a27ce531af', '672f11000229409f85a2e95ecfbab441', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('4f8efa1f-b20e-4401-818a-f347f98fd452', '7963fbfcaf2e409f9bc980ab80efc45e', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('500fa589-8b5b-46d2-bc72-ff7a2716c770', '378a606a6cc14415a4568a9e92752497', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('5041d034-efa6-4a24-a459-6a6d3c86ee20', '47aa7ac3db384393b16e59334d743c52', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('5246808d-f620-4ac0-83fe-32d8bce40ca3', '378a606a6cc14415a4568a9e92752497', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('5325576f-fdb3-41d6-b28a-01bfadff4812', '57950932014e4003873fc2bc8032662a', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('54a2cfaa-f4a7-4990-a84a-37e8f98eade1', '9d8eabbe39254f5eb4c8a9a6b97b5ed2', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('592fb206-416e-4582-8619-634fe8c78e48', 'bd8622d3f67e4aff9cf4d2cb658d193f', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('5baa93df-5cca-4b83-b394-84dbe3e8daaa', '624b0f0db81d4cdaae2f4608b798d069', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('5e3fe915-6865-4824-ada5-f3fae64cb2a5', 'ff8b78f81c54471da949861b9d2fafba', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('5e7fa6b9-017f-4316-88e1-efdf51743b16', '7cf1c03b682248d8b892dfb1bbeda701', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('5eda83bb-170f-4d9f-a966-1723e285a8c4', '54e3bb7621bb423ebf2be41900fd6d35', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('600c277c-85b7-48f4-b14a-44c66c2ebec3', '6299bc217cd648588a34b7a1d1c7b72e', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('6345ef77-1060-4b7a-a4bc-304ae6585078', '97455708691c46cba95bdb6f01309a38', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('647c22e0-f31d-4a66-8762-5a45dbf9a661', '8c055a1e3da94e499d0b1f0565455b94', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('66606dca-e8c9-45b6-a772-18ffd32504ab', '9761c56f254e4e29839b6376ab9cbcaf', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('6728999c-453e-49ce-a198-1229b0933d2a', 'd60274f6da6c4367b49b7f8ed551a661', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('672e03f3-8fec-48b8-becf-597811245da5', '672f11000229409f85a2e95ecfbab441', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('6868ed0b-7d21-4ccd-8ae4-5a950e177054', '54e3bb7621bb423ebf2be41900fd6d35', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('69a5d730-e347-4a7d-b2f6-3ca3f8c58f1b', '8c055a1e3da94e499d0b1f0565455b94', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('6c121ee4-bce9-4c64-bb5b-9e73dfb2929e', '74a23b593b514d56870df8e04d61ba77', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('6ca97a73-a302-4441-bc28-db54d0b3c317', '15ec6c44c2da4a8282206bdd69ad89bb', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('6f17beed-9efd-4d85-b595-d850a89b91c8', 'ff8b78f81c54471da949861b9d2fafba', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('6fc55823-ef3c-41f7-9efc-b0370f85e4ed', '4fef97409d3847beb819f2402095ff6e', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('710ad908-2601-4bdc-992a-a0dc6ffab53f', '0c181bd3b4de4202aa9f8d1afb5d2d36', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('757630d4-97c9-416f-b530-47c7620ec27e', '57950932014e4003873fc2bc8032662a', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('757811a4-be0e-456a-aa7a-0fd19f04f205', '9d9a8ac5f65c409bb712a1151a04f122', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('7641949a-75b7-481c-b8e4-3e1251af4b55', '0112ff6d801f4522ba854b2b054412fa', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('776fc334-6607-49c5-bc72-e603af1203d7', 'c4530aa18d954fbf96a74648d6a1e642', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('79a85f81-8e4b-457c-a971-64465866142d', '37d46a02466242a4adcd8cb5a260b65e', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('7abdc994-2c7e-4e46-badc-2b52bbc5a6f7', 'f0db06711a8f48b5a8aeffce8ebc4e3c', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('7af1f1c6-2ae2-4dd7-b547-7c24ef65333e', '15ec6c44c2da4a8282206bdd69ad89bb', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('7c68ed83-c154-46c1-9f19-416ce6b1e7ac', 'c4530aa18d954fbf96a74648d6a1e642', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('7cb964a6-26ab-4c67-8638-27548d854336', 'a92c64ea98334bb9911b144e64cbdd28', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('804e0f2a-ba59-4b43-802d-760639563460', '624b0f0db81d4cdaae2f4608b798d069', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('805301ed-43e2-40e2-bae9-faf661becc7c', '378a606a6cc14415a4568a9e92752497', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('80556483-3078-4d42-a678-81acf293e95a', '5b5877bba7d84e7aaa4940d4e43f15d2', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('80bdf6f4-98d5-48ca-add7-0e615d5b3aba', '54e3bb7621bb423ebf2be41900fd6d35', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('81366ce8-aba1-4130-b54c-f9150cfbf559', 'a3a90bc8719345c1b192360f937e6526', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('817f9bbd-8133-4b3e-8b86-24d03a89d175', '37d46a02466242a4adcd8cb5a260b65e', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('81d9e800-5d16-4790-a0a8-e1bfd0a7ef96', '6299bc217cd648588a34b7a1d1c7b72e', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('820efa0b-ed30-4e25-a3c9-7f2377349c5c', 'bd8622d3f67e4aff9cf4d2cb658d193f', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('82f43448-3d51-47e5-a1fc-02e80636cc06', '9d9a8ac5f65c409bb712a1151a04f122', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('85e0a9ed-bef9-4e6a-8841-45096f011b80', '9d8eabbe39254f5eb4c8a9a6b97b5ed2', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('8697f3d8-dbb1-4d7e-ba9d-0603ea3d30f1', '2fa5a25f4f044adaaca39b3376fae015', 'dengluming', '登录名', '1');
INSERT INTO `box_data_field` VALUES ('8b69e119-dc5d-43c6-be91-ab48738f46c1', '378a606a6cc14415a4568a9e92752497', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('8bebc25b-5ebe-4179-9f93-52d42292f8a1', '47aa7ac3db384393b16e59334d743c52', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('8c5f5a17-fba1-4f71-9332-23b68c171f12', '7cf1c03b682248d8b892dfb1bbeda701', 'shijian', '时间', '2');
INSERT INTO `box_data_field` VALUES ('8ca34b83-f6d6-4a65-ae52-488395d8e4d2', '5b7acaa6e9b9410bb1e1a5baf2afa392', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('8f328adb-ec7d-4dde-b1c0-45797a6c9bca', '8c055a1e3da94e499d0b1f0565455b94', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('8f8b0bc9-6906-4155-a839-cceb755c00d7', 'a92c64ea98334bb9911b144e64cbdd28', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('8fad1fbe-6541-4c45-b569-fd70e47538fa', 'd60274f6da6c4367b49b7f8ed551a661', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('9162a658-7f5b-428b-bda9-2b1b41817641', 'd65090d9a51e4603b32b7bddad88dada', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('965d7052-2f22-44e5-aaa5-51d2ddac08c1', 'a3a90bc8719345c1b192360f937e6526', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('96798157-4c42-4748-8fbe-533629cec700', '624b0f0db81d4cdaae2f4608b798d069', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('97efe1c4-d1df-4f44-b21a-9a94b6619e5a', '9d9a8ac5f65c409bb712a1151a04f122', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('98248695-d1ea-47d0-95d4-6171fdbb7133', '672f11000229409f85a2e95ecfbab441', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('985bca6d-fab5-4482-b8a3-4ad456a0b6d9', 'd65090d9a51e4603b32b7bddad88dada', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('991b6849-e240-4f27-a4a6-bb3080735b3c', '69f0d4a2475e44da816c11de64138493', 'yonghuming', '用户名', '2');
INSERT INTO `box_data_field` VALUES ('9af98ea5-cd2a-4e72-80a5-7cd9f87b9f19', '5b5877bba7d84e7aaa4940d4e43f15d2', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('9bb81c2d-d4c2-4c6e-86b6-bca8b76b430a', '5b7acaa6e9b9410bb1e1a5baf2afa392', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('a038b1d9-e67b-4987-b099-6ee656b7d2f8', '7963fbfcaf2e409f9bc980ab80efc45e', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('a28c3bba-2118-4d83-9318-4cead284603a', '9761c56f254e4e29839b6376ab9cbcaf', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('a29cc8e7-eee8-4c3b-8df1-ea04e92fce30', '2fa5a25f4f044adaaca39b3376fae015', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('a8e12eef-56ab-42f9-9a63-701f376e7d4a', 'a3a90bc8719345c1b192360f937e6526', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('aa54903b-3ac7-4d65-9e34-1ca59a43da42', 'd60274f6da6c4367b49b7f8ed551a661', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('ab05e086-e305-42e9-8665-f5d6a19978ed', '6299bc217cd648588a34b7a1d1c7b72e', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('abd81ff8-2700-4c19-8d64-232752b8b852', 'f0db06711a8f48b5a8aeffce8ebc4e3c', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('ad3ddca0-1c91-4852-aa8b-519be2785ddc', 'bd8622d3f67e4aff9cf4d2cb658d193f', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('ad668857-b100-4580-aa86-122af5e749f0', 'f0db06711a8f48b5a8aeffce8ebc4e3c', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('ada8ca5c-30b8-493f-bee2-2bef2fb1ac09', 'd65090d9a51e4603b32b7bddad88dada', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('aebfff5e-ea20-4b76-a47e-0bca953c3746', '5b5877bba7d84e7aaa4940d4e43f15d2', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('b0bbb2da-3961-492c-95a8-8f65ec3c7cdd', '0112ff6d801f4522ba854b2b054412fa', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('b3dc1830-86dc-427e-bf87-76d755d60550', '4b8e9f81f2dc404092cf18050655d3a2', 'nianling', '年龄', '1');
INSERT INTO `box_data_field` VALUES ('b917b073-6b51-4a61-9877-6916add7924a', '0112ff6d801f4522ba854b2b054412fa', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('badbc6ea-7575-4e50-aeb5-bf7ebe6877e3', '69f0d4a2475e44da816c11de64138493', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('bbea2351-d0e7-4c84-90ef-53924aea5d55', '9761c56f254e4e29839b6376ab9cbcaf', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('be8f610e-0a5e-46bf-abfa-10cc4e12da2b', '47aa7ac3db384393b16e59334d743c52', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('c3d83673-45a3-449b-85ac-d4f33eda7f1a', '9d8eabbe39254f5eb4c8a9a6b97b5ed2', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('c560f0db-523d-427a-a144-1d162aeed4c5', '69f0d4a2475e44da816c11de64138493', 'dengluming', '登录名', '1');
INSERT INTO `box_data_field` VALUES ('c630e17f-378f-419e-be5c-691dad206127', '15ec6c44c2da4a8282206bdd69ad89bb', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('c9029b74-b5d0-492a-8eb8-2d5a8d02fcc3', '37d46a02466242a4adcd8cb5a260b65e', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('c987d998-fa9f-406b-bbcc-c1cc0b464ca1', '4fef97409d3847beb819f2402095ff6e', 'bhh', 'bhh', '2');
INSERT INTO `box_data_field` VALUES ('ca891286-04da-41d0-9916-28caba6ebaf9', '37d46a02466242a4adcd8cb5a260b65e', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('ccde1c72-0497-45ad-8215-df2680c8e301', '0112ff6d801f4522ba854b2b054412fa', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('cda28313-93b3-4f47-bc41-b46d82c52c28', '47aa7ac3db384393b16e59334d743c52', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('cdb92f2a-a529-4905-ae48-378aeea59f64', '5b7acaa6e9b9410bb1e1a5baf2afa392', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('ce89fad2-06aa-4467-96ec-68b75b54d107', 'fce11e7c96f74c7e9dc3c02b545dc243', 'nianling', '年龄', '2');
INSERT INTO `box_data_field` VALUES ('d419f4dd-2a33-45b2-bdd9-13cb27b85b3d', 'a92c64ea98334bb9911b144e64cbdd28', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('d4d9e2d5-ba54-402c-a6d9-14bb107855c3', '4fef97409d3847beb819f2402095ff6e', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('d6d8d158-c616-4fde-9197-865b8e991347', '4b8e9f81f2dc404092cf18050655d3a2', 'zhanghao', '账号', '3');
INSERT INTO `box_data_field` VALUES ('d7aea1ee-c45e-412a-a483-cf6a7be3a63d', 'fce11e7c96f74c7e9dc3c02b545dc243', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('dae4bca0-25dd-44b9-ac75-205243238be8', '585db057707c4bb0a06d450822245db1', 'zhanghao', '帐号', '1');
INSERT INTO `box_data_field` VALUES ('de981f1f-3a70-4adf-b7f2-84183a0ac3cb', 'bd8622d3f67e4aff9cf4d2cb658d193f', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('def76b71-870d-4289-8a1c-525d81778ba5', '74a23b593b514d56870df8e04d61ba77', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('e48e80e6-d72a-47a9-afad-ecbc3befe637', '7963fbfcaf2e409f9bc980ab80efc45e', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('e5b1bdfb-93ea-4e36-85a3-c16842b80da4', '0c181bd3b4de4202aa9f8d1afb5d2d36', 'tizhong', '体重', '3');
INSERT INTO `box_data_field` VALUES ('e7e377d3-62ee-4dbd-a917-d70be2e842a6', '97455708691c46cba95bdb6f01309a38', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('e8a21772-08cb-4211-a640-d976f83b672e', '5b5877bba7d84e7aaa4940d4e43f15d2', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('ea2aafa5-d78b-4035-9470-57ed1808a265', 'fe2d02433add476badad87c536e0b491', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('ebfedb1f-8049-4bc1-87b8-fa00f76a1582', '97455708691c46cba95bdb6f01309a38', 'tizhong', '体重', '2');
INSERT INTO `box_data_field` VALUES ('ece1fceb-77cd-4712-8f21-8e61fa86ecb2', 'ff8b78f81c54471da949861b9d2fafba', 'zhanghao', '账号', '1');
INSERT INTO `box_data_field` VALUES ('f03d9f5d-3ce2-4efc-a97a-a5c153d9127d', 'd65090d9a51e4603b32b7bddad88dada', 'xingming', '姓名', '0');
INSERT INTO `box_data_field` VALUES ('f0b0bf33-0b01-4c04-822f-1becfb715e53', '69f0d4a2475e44da816c11de64138493', 'number', 'number', '0');

-- ----------------------------
-- Table structure for `box_dba12fb73dea4cfc8f6113a843191b84`
-- ----------------------------
DROP TABLE IF EXISTS `box_dba12fb73dea4cfc8f6113a843191b84`;
CREATE TABLE `box_dba12fb73dea4cfc8f6113a843191b84` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_dba12fb73dea4cfc8f6113a843191b84
-- ----------------------------

-- ----------------------------
-- Table structure for `box_de3ea67a110b467697ebfdf728be62f9`
-- ----------------------------
DROP TABLE IF EXISTS `box_de3ea67a110b467697ebfdf728be62f9`;
CREATE TABLE `box_de3ea67a110b467697ebfdf728be62f9` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_de3ea67a110b467697ebfdf728be62f9
-- ----------------------------

-- ----------------------------
-- Table structure for `box_draft`
-- ----------------------------
DROP TABLE IF EXISTS `box_draft`;
CREATE TABLE `box_draft` (
  `id` varchar(64) NOT NULL COMMENT '接收者信息',
  `receivers` varchar(200) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `end_date` timestamp NULL DEFAULT NULL COMMENT '截止时间',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `attachments` varchar(500) DEFAULT NULL COMMENT '附件信息',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `type` int(11) DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `number` int(11) DEFAULT NULL,
  `spread` int(11) DEFAULT NULL,
  `auto_sign` int(11) DEFAULT NULL,
  `operate` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于签收材料或收报告草稿箱';

-- ----------------------------
-- Records of box_draft
-- ----------------------------
INSERT INTO `box_draft` VALUES ('81c9a575-0e89-440a-b12f-d6157420fe8a', '[{\"id\":\"1\",\"name\":\"abc\",\"type\":2},{\"id\":\"2\",\"type\":1}]', 'dsaf dsaf二模寺', '2017-12-05 23:44:08', 'dsafdsfds', '[{\"id\":\"dsafdsafdsaf\",\"fileName\":\"图片\",\"url\":\"http://192.168.0.11:8080/group1/M00/00/00/wKgAC1oi0HyAfGrnAABLUS70a2o325.jpg\"}]', null, '1', '1', '2017-12-07 06:39:35', null, '2017-12-07 06:39:35', null, null, null, null);
INSERT INTO `box_draft` VALUES ('dsaf', '[{\"id\":\"dsafdsafdsaf\",\"type\":1},{\"id\":\"dasfeklj23\",\"type\":1}]', 'dsafdsafds', '2017-12-05 23:44:08', 'dsafdsfds', '[{\"id\":\"dsafdsafdsaf\",\"fileName\":\"图片\",\"url\":\"http://192.168.0.11:8080/group1/M00/00/00/wKgAC1oi0HyAfGrnAABLUS70a2o325.jpg\"}]', '1', '1', '1', '2017-12-06 00:13:04', null, '2017-12-06 00:13:04', null, null, null, null);

-- ----------------------------
-- Table structure for `box_e7cd6d9aff4b47ffbce37c90ed00703d`
-- ----------------------------
DROP TABLE IF EXISTS `box_e7cd6d9aff4b47ffbce37c90ed00703d`;
CREATE TABLE `box_e7cd6d9aff4b47ffbce37c90ed00703d` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_e7cd6d9aff4b47ffbce37c90ed00703d
-- ----------------------------

-- ----------------------------
-- Table structure for `box_ea520216b425466e821a9bf181dcdbcf`
-- ----------------------------
DROP TABLE IF EXISTS `box_ea520216b425466e821a9bf181dcdbcf`;
CREATE TABLE `box_ea520216b425466e821a9bf181dcdbcf` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_ea520216b425466e821a9bf181dcdbcf
-- ----------------------------

-- ----------------------------
-- Table structure for `box_f0db06711a8f48b5a8aeffce8ebc4e3c`
-- ----------------------------
DROP TABLE IF EXISTS `box_f0db06711a8f48b5a8aeffce8ebc4e3c`;
CREATE TABLE `box_f0db06711a8f48b5a8aeffce8ebc4e3c` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_f0db06711a8f48b5a8aeffce8ebc4e3c
-- ----------------------------
INSERT INTO `box_f0db06711a8f48b5a8aeffce8ebc4e3c` VALUES ('e4b1a7c2-73fd-4956-8fc7-f8d8d55d60c8', 'f0db06711a8f48b5a8aeffce8ebc4e3c', '李四', 'lisi', '2.0', '66.0', '0');
INSERT INTO `box_f0db06711a8f48b5a8aeffce8ebc4e3c` VALUES ('f5a589a6-2a08-418e-b6a6-302b99df1b9f', 'f0db06711a8f48b5a8aeffce8ebc4e3c', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_f1368e4d1ed94df0b13c856ecd6d0b0b`
-- ----------------------------
DROP TABLE IF EXISTS `box_f1368e4d1ed94df0b13c856ecd6d0b0b`;
CREATE TABLE `box_f1368e4d1ed94df0b13c856ecd6d0b0b` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_f1368e4d1ed94df0b13c856ecd6d0b0b
-- ----------------------------
INSERT INTO `box_f1368e4d1ed94df0b13c856ecd6d0b0b` VALUES ('1835d284-ade9-41cc-a4d8-762664355732', 'f1368e4d1ed94df0b13c856ecd6d0b0b', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_f50ad76f99cf4581850855ce29211bf3`
-- ----------------------------
DROP TABLE IF EXISTS `box_f50ad76f99cf4581850855ce29211bf3`;
CREATE TABLE `box_f50ad76f99cf4581850855ce29211bf3` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_f50ad76f99cf4581850855ce29211bf3
-- ----------------------------

-- ----------------------------
-- Table structure for `box_f7d4003d1b2b427c8fbf04611bbe6644`
-- ----------------------------
DROP TABLE IF EXISTS `box_f7d4003d1b2b427c8fbf04611bbe6644`;
CREATE TABLE `box_f7d4003d1b2b427c8fbf04611bbe6644` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_f7d4003d1b2b427c8fbf04611bbe6644
-- ----------------------------
INSERT INTO `box_f7d4003d1b2b427c8fbf04611bbe6644` VALUES ('5c31be42-d6f0-42b8-9e5b-aca4daa1b4e4', 'f7d4003d1b2b427c8fbf04611bbe6644', '张三', '1.0', '55.0', 'admin', '0');

-- ----------------------------
-- Table structure for `box_fce11e7c96f74c7e9dc3c02b545dc243`
-- ----------------------------
DROP TABLE IF EXISTS `box_fce11e7c96f74c7e9dc3c02b545dc243`;
CREATE TABLE `box_fce11e7c96f74c7e9dc3c02b545dc243` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_fce11e7c96f74c7e9dc3c02b545dc243
-- ----------------------------
INSERT INTO `box_fce11e7c96f74c7e9dc3c02b545dc243` VALUES ('0d9a3b25-ca91-4c1a-a500-1dd343f27497', 'fce11e7c96f74c7e9dc3c02b545dc243', '张三', 'zhangsan11', '1.0', '55.0', '0');
INSERT INTO `box_fce11e7c96f74c7e9dc3c02b545dc243` VALUES ('e65c25fb-154d-43a6-9823-6bdc78674899', 'fce11e7c96f74c7e9dc3c02b545dc243', '李四', 'lisi', '2.0', '66.0', '0');

-- ----------------------------
-- Table structure for `box_fe2d02433add476badad87c536e0b491`
-- ----------------------------
DROP TABLE IF EXISTS `box_fe2d02433add476badad87c536e0b491`;
CREATE TABLE `box_fe2d02433add476badad87c536e0b491` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_fe2d02433add476badad87c536e0b491
-- ----------------------------
INSERT INTO `box_fe2d02433add476badad87c536e0b491` VALUES ('18faf691-d32c-4809-bb31-9e6da070d399', 'fe2d02433add476badad87c536e0b491', '李四', 'lisi', '2.0', '66.0', '0');
INSERT INTO `box_fe2d02433add476badad87c536e0b491` VALUES ('1f4f9fd0-868f-4752-91df-a13e8a5a12f1', 'fe2d02433add476badad87c536e0b491', '张三', 'zhangsan11', '1.0', '55.0', '0');

-- ----------------------------
-- Table structure for `box_ff6b6d4333ad43d995e5065757ad3363`
-- ----------------------------
DROP TABLE IF EXISTS `box_ff6b6d4333ad43d995e5065757ad3363`;
CREATE TABLE `box_ff6b6d4333ad43d995e5065757ad3363` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `zhanghao` varchar(128) DEFAULT NULL,
  `nianling` varchar(128) DEFAULT NULL,
  `tizhong` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_ff6b6d4333ad43d995e5065757ad3363
-- ----------------------------

-- ----------------------------
-- Table structure for `box_file`
-- ----------------------------
DROP TABLE IF EXISTS `box_file`;
CREATE TABLE `box_file` (
  `id` varchar(100) NOT NULL,
  `file_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'url',
  `create_user` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `box_id` varchar(64) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发材料和报告表';

-- ----------------------------
-- Records of box_file
-- ----------------------------
INSERT INTO `box_file` VALUES ('007040ae-b7a9-4388-8539-97b74e07b90d', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1plsvGAGKoOAAAmWS3Woq021.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:46:26', null, null, '9b7fd822891f4240af154bf2a2918318', '9817');
INSERT INTO `box_file` VALUES ('01e429d2-b978-4b3b-937a-b8c1e0363ab4', '1.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1plscKAVmpeAAAtEPn3GTY13.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:41:22', null, null, null, '11536');
INSERT INTO `box_file` VALUES ('0765fde9-9772-4368-9a91-92bb09601f1a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psVCCAZe8wAAAmzY8cQ1M62.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:27:44', null, null, 'ed3f1f05faf74d24bb7bdae361fb3494', '9933');
INSERT INTO `box_file` VALUES ('07841029-f48d-4981-bb7e-8eae9ba63b05', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pZqi-AaI6dAAAtEPn3GTY60.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-13 14:41:54', null, null, 'da6a749935e840f4b5644f7942efa5ef', null);
INSERT INTO `box_file` VALUES ('084c4003-6d1a-43a4-85e3-90dc8503b7ef', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pltSGARccEAAAmWS3Woq094.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:55:46', null, null, 'c77df5723c8341fa84b6f72f41041ce6', '9817');
INSERT INTO `box_file` VALUES ('0966057c-853d-4b2a-a50a-4c5cc1bd83ac', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pesw-AHpjjAAAtEPn3GTY95.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 10:21:54', null, null, '18ff478c44c542e190d59ed7a1764209', null);
INSERT INTO `box_file` VALUES ('099181f0-c8d0-4d91-9d42-5f191c3409f6', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXsKABsWMAAAgS0hji1s80.xlsx', 'safd383028dfasfdsa038829083902fdsajkfd', '2018-01-31 14:14:28', null, null, 'f74f2827879846b7a114f84212f7037c', '8267');
INSERT INTO `box_file` VALUES ('0a07fe8f-ee01-49ee-8753-e4422f65aa0c', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/04/wKgAC1pf9jOAM9iRAAAmWS3Woq034.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 09:19:51', null, null, '2b59f373760a48cabff49734cc74bdad', '9817');
INSERT INTO `box_file` VALUES ('0a141372-9e8f-43b7-8aa0-8b935b05292d', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXbGAS-jKAAAgS0hji1s38.xlsx', '85df829495494a208d94cd64efe2d953', '2018-01-31 14:09:56', null, null, 'dd61359dca214824a493a9d0abfe264c', '8267');
INSERT INTO `box_file` VALUES ('0d6715ba-8631-4dc8-b1cf-3afd20847985', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pioU-AY6KfAAAtEPn3GTY44.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 09:54:26', null, null, 'c3f8bafc39fa4f499184bd50647e7e2c', '11536');
INSERT INTO `box_file` VALUES ('0f227e99-d50e-4434-b087-588267b26ee9', '工作笔记2018.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwUICAAZZvAAAsHT2Y4kQ37.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:01:24', null, null, 'ed3f1f05faf74d24bb7bdae361fb3494', '11293');
INSERT INTO `box_file` VALUES ('0f74d061-b678-4bfd-a486-b80c6926d434', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plR8KAFDW4AAAtEPn3GTY91.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:09:12', null, null, '4466b1dbe3d1434cab6b8c3cb48b8988', '11536');
INSERT INTO `box_file` VALUES ('0f74d061-b678-4bfd-a486-b86926d434', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plR8KAFDW4AAAtEPn3GTY91.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:14:34', null, null, 'f5456442718a41d4929dc5dd4c3baa2e', '11536');
INSERT INTO `box_file` VALUES ('0f74d061-tgb678-4bfd-a486-b86926d434', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plR8KAFDW4AAAtEPn3GTY91.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:29:05', null, null, '2e9671f05b9c444e825bbea55e02022e', '11536');
INSERT INTO `box_file` VALUES ('0fe270d4-c862-4e46-be29-3a3a0b42fb46', '细设计模板 .docx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1py3x-AJOruAAVqzdh0YxM62.docx', '4dea9acd67954ea6a0753e339b03ba7d', '2018-02-01 17:34:27', null, null, '5ae39c03921e4fb68ff4f02f1763e57f', '355021');
INSERT INTO `box_file` VALUES ('10d06874-295c-40a3-8e44-e8b8a4128cc5', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm5sqAM9SpAAAmWS3Woq004.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:39:54', null, null, null, '9817');
INSERT INTO `box_file` VALUES ('11ed7f71-088d-4369-a349-3629a2366e62', 'Template.xlsx', '192.168.0.11:8181/group1/M00/00/09/wKgAC1pxeu6AXNy5AAAibwQ4cwk10.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:14:41', null, null, '94825402dc2e414a947d1e8b1e396374', '8815');
INSERT INTO `box_file` VALUES ('198bfec2-62e3-4750-bdc2-8af4d923e8bb', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/07/wKgAC1psTnuAcS_NAAAmzY8cQ1M79.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:03:41', null, null, '5cd819bc40d0494e81a06c1c291e1cd0', '9933');
INSERT INTO `box_file` VALUES ('19cc0987-f01e-4c51-a6c0-3d1566d87faa', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1piplqAaDgsAAAmWS3Woq015.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 10:15:57', null, null, '53c0f5d6b02c47c18c0b3f8114c13482', '9817');
INSERT INTO `box_file` VALUES ('1ab93aef-a17b-449f-9cf8-c84b57e22d63', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plfTuAM12sAAAmWS3Woq013.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 13:57:19', null, null, '104e53f6cfd54049901c91ea7705c18d', '9817');
INSERT INTO `box_file` VALUES ('1bf86181-1943-4a06-bab1-ab7c0c5f4c3d', '1.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6QCAGWFcAAAtEPn3GTY04.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:49:20', null, null, null, '11536');
INSERT INTO `box_file` VALUES ('1d7af87d-6426-4dc7-b64e-29b08b1eb7a2', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/07/wKgAC1psQBGACniwAAAmzY8cQ1M58.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:02:09', null, null, null, '9933');
INSERT INTO `box_file` VALUES ('1e20f35d-e03a-4b12-a989-568613f5e', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phxCKAMvZkAAAtEPn3GTY76.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:14:34', null, null, 'bf29b0931e1f4153b97838173feed788', '11536');
INSERT INTO `box_file` VALUES ('1e20f35d-e03a-4b12-a989-5686213f5e', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phxCKAMvZkAAAtEPn3GTY76.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:14:15', null, null, '3539d2c9999b478ab672fefbd4e47381', '11536');
INSERT INTO `box_file` VALUES ('21b71e77-753b-48c8-8ebf-edcf5cb3e839', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pcEM2ADxbKAAAtEPn3GTY86.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-15 10:24:18', null, null, '99c1bc89245e4ba8a3c7401fec293a79', null);
INSERT INTO `box_file` VALUES ('23289635-b5ab-4b02-a21c-6db1452b3451', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plfTuAEWE4AAAtEPn3GTY24.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 13:57:19', null, null, '104e53f6cfd54049901c91ea7705c18d', '11536');
INSERT INTO `box_file` VALUES ('23d5d354-a1b5-4a45-b818-6ce6b8673b94', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1py4K6AdSekAAAmzY8cQ1M90.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 17:41:05', null, null, '84f5a249f00e45e3bb8714e3a637c461', '9933');
INSERT INTO `box_file` VALUES ('257bf388-c390-402c-a8e8-b3b653eb2ea2', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psUueAKJy0AAAmzY8cQ1M66.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:22:32', null, null, '51603e06481b46d7bbf460cb00ba6d43', '9933');
INSERT INTO `box_file` VALUES ('27305b27-cd6e-46b3-972c-2b4d41d27768', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXjqAInAVAAAgS0hji1s07.xlsx', 'f977c3d92de04d8f84270a20614e3b18', '2018-01-31 14:12:13', null, null, '2991b304ecca41c9bde0ceb22a2cc6fd', '8267');
INSERT INTO `box_file` VALUES ('2b60d171-abd0-441b-b302-b204319298fe', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1py5JKAPLUjAAAmzY8cQ1M48.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 17:58:58', null, null, 'bfa741c8dcc94052a12e893afa876db7', '9933');
INSERT INTO `box_file` VALUES ('2ea6c996-332b-4ef9-85ae-924b82aeb014', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1plsm-AOOV2AAAmWS3Woq059.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:44:16', null, null, '9b7fd822891f4240af154bf2a2918318', '9817');
INSERT INTO `box_file` VALUES ('2f2de323-2412-4f8d-9562-7a1934e6c60c', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phxgaAMzHdAAAtEPn3GTY83.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:18:52', null, null, '2f0e421b5f5744afaa029cd79133086c', '11536');
INSERT INTO `box_file` VALUES ('31bfaa74-921a-459b-928b-8e666a88e4a8', '123.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPOWAbuZTAAAgS0hji1s18.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:37:44', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '8267');
INSERT INTO `box_file` VALUES ('31d89a74-037f-4114-8f84-7c8c8cdfb573', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1phVaWAEZGqAAAmWS3Woq082.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 10:19:20', null, null, 'a0d567cd90a3499aa479bae0a8b3d3d2', '9817');
INSERT INTO `box_file` VALUES ('32338c74-a7a1-4e90-9498-6b8bf03b98d0', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxMdqAYZwQAAAmzY8cQ1M71.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:02:54', null, null, 'bbe308240344402191a08c94f091d869', '9933');
INSERT INTO `box_file` VALUES ('325728ca-0227-45d4-a402-9f6ddb2a89f3', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxenSAG8_2AAAtEPn3GTY08.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:12:39', null, null, '94825402dc2e414a947d1e8b1e396374', '11536');
INSERT INTO `box_file` VALUES ('351a9543-5226-4de3-b7a8-b1c21a785349', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgbrCAFYrzAAAtEPn3GTY76.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:53:55', null, null, 'ed086f4f793a42a29e123cd44cd14b44', '11536');
INSERT INTO `box_file` VALUES ('355851a8-8e61-4128-911c-d6539fd821c5', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdzDWANQ6PAAAtEPn3GTY26.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:56:08', null, null, 'd37dbd4f9bb24c0d99fa33aa70fbf596', null);
INSERT INTO `box_file` VALUES ('359720b2-6a9b-4a9c-86fc-9590f61851ef', '123.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6I-AcnVDAAAf47kX13A25.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:47:28', null, null, null, '8163');
INSERT INTO `box_file` VALUES ('35ae4f32-36e8-4fda-b2bd-23980b1295', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phwB2AFjE_AAAtEPn3GTY99.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:06:42', null, null, '6c11191e3200490c84a70bd543948ea4', '11536');
INSERT INTO `box_file` VALUES ('367e547d-2593-4d4e-ad6b-fc8745bd8767', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgblqAAPNQAAAmWS3Woq035.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:52:28', null, null, 'acd12065f71548bd9d10b2a6186df028', '9817');
INSERT INTO `box_file` VALUES ('386bbc70-8918-4364-b493-cc11f0d3ca1d', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6QCAKuIBAAAmWS3Woq047.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:49:20', null, null, null, '9817');
INSERT INTO `box_file` VALUES ('3b17d4ff-6cb0-4f15-a2f4-f59f78f7d583', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pcEM-Acpa1AAAmWS3Woq042.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-15 10:24:18', null, null, '99c1bc89245e4ba8a3c7401fec293a79', null);
INSERT INTO `box_file` VALUES ('3c4d3355-11a5-44b0-96c4-b64a76c46e4c', '未做功能.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwQbaAKkA9AAA0eFNOKzk74.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:58:17', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '13432');
INSERT INTO `box_file` VALUES ('3d91bf78-00d1-460c-8b48-07a96b22f584', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdzFuAbe8WAAAmWS3Woq075.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:56:46', null, null, '89ab03b5215b4921a82fc338bf8aafe5', null);
INSERT INTO `box_file` VALUES ('41a24f8a-2342-49b0-9926-f324d47772e0', '概要设计模板.docx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxaTmAKBacAAyaGgohxcA06.docx', '4dea9acd67954ea6a0753e339b03ba7d', '2018-01-31 14:59:53', null, null, '72a30e3b9e3b43a6ad21bf8b8d9a519f', '825882');
INSERT INTO `box_file` VALUES ('44f58bbd-f091-4f63-8140-4492382e18be', '工作笔记2018.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwUMiABEfuAAAsHT2Y4kQ27.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:02:35', null, null, '14267b7a97c848f0a798df7f960d8a9f', '11293');
INSERT INTO `box_file` VALUES ('4571ac20-a485-4437-b0fb-6f6572e9a03e', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1plrpCAGX68AAAmWS3Woq074.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:27:45', null, null, null, '9817');
INSERT INTO `box_file` VALUES ('49920e6d-0f53-4e26-a36c-b2e30547cf61', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pepNKAS_bCAAAtEPn3GTY26.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 09:20:23', null, null, '3bd8eeb3395d47fc8f7b441230273018', null);
INSERT INTO `box_file` VALUES ('4c7c8e6b-9c55-4beb-b71f-c6023116b223', '工作笔记2018.xlsx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1phoQiAUzJOAAAretSrUvk07.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 15:41:14', null, null, '40dc65d131d84e3b80219a02fe966c27', '0');
INSERT INTO `box_file` VALUES ('4dee44ad-b227-47f3-ae9d-4718631ab737', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxHpOATc8IAAAtEPn3GTY05.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:40:38', null, null, '19a77c3ff2f144628dc056278d898001', null);
INSERT INTO `box_file` VALUES ('4eabc7d9-322e-4782-ab93-d1c3288ed422', '新建 Microsoft Word 文档.docx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pevWyAZyH6AAAzIQGUgCc74.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 11:05:21', null, null, '4626120663234442af5332ea4aada347', '0');
INSERT INTO `box_file` VALUES ('4f8780be-1705-4875-aa22-7d1f4928d3dd', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgbCqAc6KYAAAmWS3Woq027.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:43:08', null, null, '8c0f07dd06c64b5b9b677e83e317ad01', '9817');
INSERT INTO `box_file` VALUES ('504fd442-99a0-491f-a724-04f9a4e401f4', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phxgaAJgmKAAAmWS3Woq067.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:18:52', null, null, '2f0e421b5f5744afaa029cd79133086c', '9817');
INSERT INTO `box_file` VALUES ('50cda91a-ae44-4cdd-ae6e-386d6cbe30a9', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pcEFWAes_xAAAmWS3Woq096.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-15 10:22:21', null, null, '61e35c940b7747caa2ae5566cabeba1b', null);
INSERT INTO `box_file` VALUES ('51f26eeb-3808-4284-9a9f-da46ce78cde7', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/04/wKgAC1pf9jOAMOp1AAAtEPn3GTY68.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 09:19:51', null, null, '2b59f373760a48cabff49734cc74bdad', '11536');
INSERT INTO `box_file` VALUES ('56a95422-a4a8-4164-bf1e-9e8cd7a09f95', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPF2Af98-AAAmzY8cQ1M64.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:35:28', null, null, 'ed3f1f05faf74d24bb7bdae361fb3494', '9933');
INSERT INTO `box_file` VALUES ('575d08a7-9e01-4ffb-b4de-7fb5a032131e', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pesw-ADcIXAAAmWS3Woq068.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 10:21:54', null, null, '18ff478c44c542e190d59ed7a1764209', null);
INSERT INTO `box_file` VALUES ('57c0e2dd-ecfb-439e-a601-0f588dec1e18', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/07/wKgAC1psSXmAXfhmAAAmzY8cQ1M63.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:42:17', null, null, '2c977c62ebf94c709e607e95b56f17ab', '9933');
INSERT INTO `box_file` VALUES ('57f15c15-1afa-4608-a1b6-9897ce9dc8a8', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxeqKAVp6HAAAgS0hji1s28.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:13:25', null, null, '27e2b82e10b44f4cabe24f7b315b1503', '8267');
INSERT INTO `box_file` VALUES ('5872967c-c01d-4801-a10d-67df5ff865b9', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/07/wKgAC1psLZ6AMcspAAAm27TAn1A43.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 15:43:27', null, null, null, '9947');
INSERT INTO `box_file` VALUES ('59afe2e2-8a14-40b6-a64d-9bcda67e3ff0', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1psVBKAXe-OAAAtEPn3GTY42.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:27:33', null, null, 'ed3f1f05faf74d24bb7bdae361fb3494', '11536');
INSERT INTO `box_file` VALUES ('5c491b22-fa81-49f1-9571-1fe7031140e4', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdofuAcA_sAAAtEPn3GTY55.docx ', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:04:36', null, null, '6a27276a4ac04a8198f94c91c9646323', null);
INSERT INTO `box_file` VALUES ('664174ff-7405-4f3b-839a-e88540496bc0', '1.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm5sqATy_wAAAtEPn3GTY38.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:39:54', null, null, null, '11536');
INSERT INTO `box_file` VALUES ('6655cf0d-c2de-4d8a-beb7-02d92a61797b', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6QCAGWFcAAAtEPn3GTY04.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:49:22', null, null, 'ce76ffe4893143438d30030dde81c01b', '11536');
INSERT INTO `box_file` VALUES ('670272aa-a992-4333-86de-4b31b1c35b02', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pwULiADN-aAAAgS0hji1s41.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:02:19', null, null, '14267b7a97c848f0a798df7f960d8a9f', null);
INSERT INTO `box_file` VALUES ('6a69a021-7d16-4cf8-aab7-dd4465fb193e', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1plsVKAHXnLAAAmWS3Woq031.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:39:31', null, null, null, '9817');
INSERT INTO `box_file` VALUES ('6c4eb726-14e5-4773-ac08-9870e5b8eb07', '未做功能.xlsx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1peshCAD3P5AAA0eFNOKzk86.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 10:17:03', null, null, '3ef1d7207dd84f33850b00112a9a7739', null);
INSERT INTO `box_file` VALUES ('6f88c5d7-f5b7-4f7a-a86c-2b8683a60912', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/07/wKgAC1psQBGACniwAAAmzY8cQ1M58.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:02:14', null, null, '2c977c62ebf94c709e607e95b56f17ab', '9933');
INSERT INTO `box_file` VALUES ('6fef7ded-2671-4174-9d55-775b3d7cf6f19', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pm43CAZ_q7AAAmWS3Woq087.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:28:17', null, null, '33046447f45a44eab52fae5f8cda69ab', '9817');
INSERT INTO `box_file` VALUES ('6fef7ded-2671-4174-9d55-775b3d7cf6f9', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm43CAZ_q7AAAmWS3Woq087.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:25:36', null, null, null, '9817');
INSERT INTO `box_file` VALUES ('740ffbd9-1d90-45dd-8679-af534293e751', '工作笔记2018.xlsx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pesLOADndOAAAretSrUvk52.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 10:11:05', null, null, 'f6048f1e19d94b09a57bb3999f2a1e66', '0');
INSERT INTO `box_file` VALUES ('74d9469e-310e-44b4-b4c0-c1953f133eae', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pwTBAbSWXAAAgS0hji1s99.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:00:16', null, null, 'c2fa460b62264fa98a995494d2562d1c', null);
INSERT INTO `box_file` VALUES ('7641090c-b3f8-428f-8319-e4f4ba0944c3', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/05/wKgAC1phWSKAG-FbAAAmWS3Woq062.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 10:34:14', null, null, 'a0d567cd90a3499aa479bae0a8b3d3d2', '9817');
INSERT INTO `box_file` VALUES ('78593d41-607a-489b-90aa-ade6799f509b', '1.docx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psVBKAXe-OAAAtEPn3GTY42.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:27:31', null, null, null, '11536');
INSERT INTO `box_file` VALUES ('785c70ba-9125-409d-ac5a-c0f60a55044e', '未做功能 (完成计划).xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxW-yALguwAAA9bsjLydc99.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:02:24', null, null, 'cc151a5f25bf4af6a47623234aa44407', '15726');
INSERT INTO `box_file` VALUES ('7ad05f79-7502-458f-8f03-291a83672c9a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPImAXeRpAAAmzY8cQ1M13.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:36:13', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('7ad05f79-7502-458f-8f03-291add3addas6dadf72c9a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPImAXeRpAAAmzY8cQ1M13.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 19:00:57', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('7ad05f79-7502-458f-8f03-291add83672c9a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPImAXeRpAAAmzY8cQ1M13.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 18:03:12', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('7ad05f79-7502-458f-8f03-291adddas83672c9a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPImAXeRpAAAmzY8cQ1M13.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 18:03:41', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('7ad05f79-7502-458f-8f03-291adddas836d72c9a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPImAXeRpAAAmzY8cQ1M13.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 18:10:03', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('7ad05f79-7502-458f-8f03-291adddas83addas6d72c9a', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwPImAXeRpAAAmzY8cQ1M13.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 18:15:40', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('7ad3564f-949c-4638-8378-31e7db44beca', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxYSKAIsoDAAAgS0hji1s73.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:24:41', null, null, '5b038fbbde2f497fb72fe500102dc292', '8267');
INSERT INTO `box_file` VALUES ('7ccf480f-604f-4dcd-ac83-e306b0e9cdd7', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pepCSATM_jAAAtEPn3GTY84.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 09:17:28', null, null, '1ac7d454d8bf479a96651709a34b0b7c', null);
INSERT INTO `box_file` VALUES ('7d4299c2-9fde-416f-b991-998153779392', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plSsKAcKimAAAmWS3Woq082.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:21:57', null, null, '9b7fd822891f4240af154bf2a2918318', '9817');
INSERT INTO `box_file` VALUES ('7d960a3a-59e8-4817-9709-6ee5a948be0d', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgbrCATrpWAAAmWS3Woq031.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:53:55', null, null, 'ed086f4f793a42a29e123cd44cd14b44', '9817');
INSERT INTO `box_file` VALUES ('80d6cd9a-90d0-4a58-acff-995e42d83e9b', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwOp6ARHWnAAAmzY8cQ1M93.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:28:03', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '9933');
INSERT INTO `box_file` VALUES ('81d8a704-d21e-4509-ba2a-07805adf83cd', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdwRaAb8-0AAAtEPn3GTY33.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:08:41', null, null, 'b6d690c6b60e4e65870df130a11b579e', null);
INSERT INTO `box_file` VALUES ('84596fa7-b1be-4f17-812a-d4b95e47964e', '1.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pltOKAdKJTAAAtEPn3GTY86.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:54:43', null, null, '9b7fd822891f4240af154bf2a2918318', '11536');
INSERT INTO `box_file` VALUES ('85c49e08-99ac-497d-9677-e9767b786c8a', '1.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqgreAPU_uAAAtEPn3GTY31.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 09:21:59', null, null, null, '11536');
INSERT INTO `box_file` VALUES ('863e0cd7-06d7-4180-b5ff-9d2041c834ed', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6QCAKuIBAAAmWS3Woq047.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:49:22', null, null, 'ce76ffe4893143438d30030dde81c01b', '9817');
INSERT INTO `box_file` VALUES ('86e5e7ad-3d43-45f4-ac3f-ad12e8a4119f', '新建 Microsoft Office Excel 工作表.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxUaqAUVNlAAAofQBiEk034.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:18:43', null, null, 'fef9970b5e354281b959535a1eb5ae61', '10365');
INSERT INTO `box_file` VALUES ('87a71b8d-f59c-42e5-97b6-7d0eef7ce771', '1.docx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psVCCAQTuZAAAtEPn3GTY21.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:27:44', null, null, 'ed3f1f05faf74d24bb7bdae361fb3494', '11536');
INSERT INTO `box_file` VALUES ('88d6e6bd-873d-4425-a5e6-4a4ed343b3cf', '流程中心设计.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pjCg6AaEsiAABMxrw_6Eo40.docx', '8a6fea61aee249848261dd684b7f8460', '2018-01-20 17:21:21', null, null, '53c0f5d6b02c47c18c0b3f8114c13482', '19654');
INSERT INTO `box_file` VALUES ('8b2b5480-812d-4301-82dd-b002a927ee15', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxenSAGCWgAAAmzY8cQ1M47.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:12:39', null, null, '94825402dc2e414a947d1e8b1e396374', '9933');
INSERT INTO `box_file` VALUES ('8bc58067-279a-49c9-8b7e-1703b2e00356', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pioU-AEk5GAAAmWS3Woq081.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 09:54:26', null, null, 'c3f8bafc39fa4f499184bd50647e7e2c', '9817');
INSERT INTO `box_file` VALUES ('8ced8776-2dcf-4799-9096-1a7f181403d7', '工作笔记2018.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm5NGABXUrAAAretSrUvk50.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:31:30', null, null, null, '11130');
INSERT INTO `box_file` VALUES ('8ddc1b08-a99a-4c9c-8091-a8e8e9437d62', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6KaAWQhTAAAf47kX13A39.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:48:31', null, null, '61b92a1c56e044589ab382fc0539c3b4', '8163');
INSERT INTO `box_file` VALUES ('8f03fec3-adb3-48d3-8ba9-28302a4b351c', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdwRaAWMDaAAAmWS3Woq091.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:08:41', null, null, 'b6d690c6b60e4e65870df130a11b579e', null);
INSERT INTO `box_file` VALUES ('8fc8fc35-5e34-4bcd-8808-8950fc2ad50b', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psUmyAVXlwAAAmzY8cQ1M31.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:20:29', null, null, null, '9933');
INSERT INTO `box_file` VALUES ('9156f03c-07cd-455f-b15d-b53532b5f690', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdwF2AWtg5AAAtEPn3GTY96.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:05:36', null, null, '84d1c0bc8d9e4559bf3ae9ff6617faa6', null);
INSERT INTO `box_file` VALUES ('928ee643-e881-4bba-90f3-d57c7fd59df8', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxH_6AFz_KAAAtEPn3GTY72.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:46:40', null, null, 'ad80a366bad14330885061097f4f20e4', null);
INSERT INTO `box_file` VALUES ('942d5744-b5e9-4768-a4f2-0399aa006dc7', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdzDWATqIxAAAmWS3Woq047.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:56:08', null, null, 'd37dbd4f9bb24c0d99fa33aa70fbf596', null);
INSERT INTO `box_file` VALUES ('966e0c31-4a58-4b0f-8938-fd58dbff7c4d', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxHpOAY2JeAAAmzY8cQ1M07.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:40:38', null, null, '19a77c3ff2f144628dc056278d898001', null);
INSERT INTO `box_file` VALUES ('971ec5d3-b6ed-4b3e-80c9-81fc302acc6a', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1phVaWAG187AAAtEPn3GTY77.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 10:19:20', null, null, 'a0d567cd90a3499aa479bae0a8b3d3d2', '11536');
INSERT INTO `box_file` VALUES ('979c90ad-4f24-49f8-a123-734932ede71a', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plR8KACOLzAAAmWS3Woq093.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:09:12', null, null, '4466b1dbe3d1434cab6b8c3cb48b8988', '9817');
INSERT INTO `box_file` VALUES ('979c90ad-4f249f8-a123-734932ede71a', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plR8KACOLzAAAmWS3Woq093.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:14:34', null, null, 'f5456442718a41d4929dc5dd4c3baa2e', '9817');
INSERT INTO `box_file` VALUES ('979c90ad-4f2gf49f8-a123-734932ede71a', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plR8KACOLzAAAmWS3Woq093.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:29:05', null, null, '2e9671f05b9c444e825bbea55e02022e', '9817');
INSERT INTO `box_file` VALUES ('9b7f1479-f339-4a19-adde-244cb30cf3e8', '1.docx', '192.168.0.11:8181/group1/M00/00/07/wKgAC1psQCGAH92MAAAtEPn3GTY51.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:02:26', null, null, '2c977c62ebf94c709e607e95b56f17ab', '11536');
INSERT INTO `box_file` VALUES ('9d082b97-3bff-488f-9bed-fdfa23c43646', '流程中心设计.docx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pZ2TqAQb6VAABMxrw_6Eo37.docx', '8a6fea61aee249848261dd684b7f8460', '2018-01-13 18:02:41', null, null, '9ea74f1e536547a88e396441114d1a3a', null);
INSERT INTO `box_file` VALUES ('a0795cb5-71a6-4844-bfd4-0b3a58a0ea3', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phxCKADBoeAAAmWS3Woq097.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:14:34', null, null, 'bf29b0931e1f4153b97838173feed788', '9817');
INSERT INTO `box_file` VALUES ('a0795cb5-71a6-4844-bfd4-0b3a58fa0ea3', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phxCKADBoeAAAmWS3Woq097.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:14:15', null, null, '3539d2c9999b478ab672fefbd4e47381', '9817');
INSERT INTO `box_file` VALUES ('a12a9a10-21e8-4c62-b879-702919604a42', '1.docx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pirzWAaeeNAAAtEPn3GTY44.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 10:53:44', null, null, 'c77df5723c8341fa84b6f72f41041ce6', '11536');
INSERT INTO `box_file` VALUES ('a1559e91-774e-427f-8802-b12ccb6ac30a', '1.docx', '192.168.0.11:8181/group1/M00/00/09/wKgAC1pxMeeAZ1hHAAAtEPn3GTY17.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:03:08', null, null, 'bbe308240344402191a08c94f091d869', '11536');
INSERT INTO `box_file` VALUES ('a2adc519-f0fc-41fc-ba2c-9e0671459449', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pevcKAZR8gAAAtEPn3GTY86.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 11:06:44', null, null, 'a5c6bb2950504b1ab279617703ef7454', '11536');
INSERT INTO `box_file` VALUES ('a31e55a9-668c-4269-8c94-1977142800ac', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pltQeACdpvAAAmWS3Woq095.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:55:19', null, null, 'c77df5723c8341fa84b6f72f41041ce6', '9817');
INSERT INTO `box_file` VALUES ('a34b7dfa-5bb8-480f-a849-d690016ba8b3', '1.docx', '192.168.0.11:8181/group1/M00/00/05/wKgAC1phVvKAZIKPAAAtEPn3GTY59.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 10:38:43', null, null, 'a0d567cd90a3499aa479bae0a8b3d3d2', '11536');
INSERT INTO `box_file` VALUES ('a5b7ce2e-681f-4762-98b9-43b5f6b3a48b', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1plsoiAWQ0RAAAmWS3Woq037.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:44:41', null, null, '9b7fd822891f4240af154bf2a2918318', '9817');
INSERT INTO `box_file` VALUES ('aa426d67-5609-43ab-b06b-95ba2c4f3335', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psU9GAX8TOAAAmzY8cQ1M01.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:26:26', null, null, '51603e06481b46d7bbf460cb00ba6d43', '9933');
INSERT INTO `box_file` VALUES ('ae1318e9-7f76-434e-a47d-239586b9dc61', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxMXiALqOGAAAmzY8cQ1M94.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 11:01:14', null, null, '278c5e783388472eaa64faa606a1cdc5', '9933');
INSERT INTO `box_file` VALUES ('b06be013-035f-47ce-adb2-f6b65fbb4554', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxH_6AKatXAAAmzY8cQ1M59.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:46:40', null, null, 'ad80a366bad14330885061097f4f20e4', null);
INSERT INTO `box_file` VALUES ('b0936948-bb9b-487f-aee3-6867fb3919f3', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgbCqAdYSdAAAtEPn3GTY25.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:43:08', null, null, '8c0f07dd06c64b5b9b677e83e317ad01', '11536');
INSERT INTO `box_file` VALUES ('b1a1a6cd-5e9b-4f52-8fa2-cd5d0d519987', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pqgrCACx4HAAAm0XIJAlQ32.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-26 09:21:53', null, null, null, '9937');
INSERT INTO `box_file` VALUES ('b27dd8ee-26dd-4ea3-9472-195c5cfae43d', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxegiALFi6AAAmzY8cQ1M11.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 16:11:10', null, null, '75c0a87059ec48449159c1fbc983d64a', '9933');
INSERT INTO `box_file` VALUES ('b3c1dc6b-d146-44fa-b3a6-f72811cd2164', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/05/wKgAC1phXy-ADrlbAAAmWS3Woq078.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 11:00:01', null, null, 'a0d567cd90a3499aa479bae0a8b3d3d2', '9817');
INSERT INTO `box_file` VALUES ('b5a52860-90d7-43bb-ab34-a17ebc4a8946', 'wKgAC1pgblqAAPNQAAAmWS3Woq035.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxHXmAUY46AAAmWS3Woq004.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:36:44', null, null, '05dc6a5e69db4487b8e038ccef01ffc4', null);
INSERT INTO `box_file` VALUES ('b76f9308-f155-45bd-8f82-4eb031ca78b6', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXF-Aci_XAAAgS0hji1s50.xlsx', '85df829495494a208d94cd64efe2d953', '2018-01-31 14:04:18', null, null, 'eadf4ba641e14783adb3ecc72539af05', '8267');
INSERT INTO `box_file` VALUES ('b7ddda37-1f57-40ad-a683-c516656d977e', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXcyAJGFlAAAgS0hji1s17.xlsx', '85df829495494a208d94cd64efe2d953', '2018-01-31 14:10:23', null, null, '276ff70432564aaaac683fb66f2655b5', '8267');
INSERT INTO `box_file` VALUES ('b88915a5-9fcc-4494-b225-6c9c2b188e5b', '1.docx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psUnaABaZgAAAtEPn3GTY66.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:20:39', null, null, '51603e06481b46d7bbf460cb00ba6d43', '11536');
INSERT INTO `box_file` VALUES ('ba68385f-8649-4820-acbc-a44334e411d5', '新建 Microsoft Office Excel 工作表.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxUfOAZ-6MAAAofQBiEk038.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:19:51', null, null, '3abd322d6c9e464685baab38bca28af5', '10365');
INSERT INTO `box_file` VALUES ('bad74794-103c-4995-bf61-c0587f722240', '123.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6KaAWQhTAAAf47kX13A39.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:47:50', null, null, null, '8163');
INSERT INTO `box_file` VALUES ('bdd81382-38a4-4255-84b3-043df5f85dc8', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdzFyAD6u0AAAtEPn3GTY69.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:56:46', null, null, '89ab03b5215b4921a82fc338bf8aafe5', null);
INSERT INTO `box_file` VALUES ('c2a29fbe-41f4-4789-88b4-e44644632702', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1py5XCASgqyAAAmzY8cQ1M17.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-02-01 18:02:39', null, null, '3718ccd53786409f87917727dc691ccb', '9933');
INSERT INTO `box_file` VALUES ('c31f96ad-6730-4ec4-a036-d859f3795c85', '1.docx', '192.168.0.11:8181/group1/M00/00/05/wKgAC1phWSKABNRrAAAtEPn3GTY15.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 10:34:14', null, null, 'a0d567cd90a3499aa479bae0a8b3d3d2', '11536');
INSERT INTO `box_file` VALUES ('c3e2d511-1dfb-4241-b9c4-188487bca836', '未做功能.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6MuAD2MKAAA0eFNOKzk70.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:48:27', null, null, null, '13432');
INSERT INTO `box_file` VALUES ('c4fde6b7-fff6-4a68-9600-b31e81f66979', 'api文档.docx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxaPOAW5MFAADSMtKaYeg20.docx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:57:58', null, null, '49907faae92d4d7baf9083d45f08b312', '53810');
INSERT INTO `box_file` VALUES ('c6458bf0-36b0-46cb-8ef6-b90090cb4e4d', '工作笔记2018.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6LqAISBtAAAretSrUvk06.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:48:31', null, null, '61b92a1c56e044589ab382fc0539c3b4', '11130');
INSERT INTO `box_file` VALUES ('c931f50c-7b5c-4ad3-8350-e2126029bd62', '服务器账号密码.docx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXZeAakfBAAAzm7vmdLI89.docx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:09:33', null, null, '88406a7d10694f33843ef212a20d6ba9', '13211');
INSERT INTO `box_file` VALUES ('c97b811d-6d52-456a-b960-fc7a51d6f75e', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1plSsKAXF6lAAAtEPn3GTY87.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 10:21:57', null, null, '9b7fd822891f4240af154bf2a2918318', '11536');
INSERT INTO `box_file` VALUES ('c98fa95c-a722-4e6e-bf3d-5e50153247fb', '123.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm5u-AIlDRAAAf47kX13A40.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:40:31', null, null, null, '8163');
INSERT INTO `box_file` VALUES ('c9ff2fb4-a590-4b10-856a-4d0aa04e27eb', '工作笔记2018.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6LqAISBtAAAretSrUvk06.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:48:11', null, null, null, '11130');
INSERT INTO `box_file` VALUES ('cca7bd11-6f07-4324-ab9e-7cea786787f0', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pZqi2AJjbOAAAmWS3Woq017.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-13 14:41:54', null, null, 'da6a749935e840f4b5644f7942efa5ef', null);
INSERT INTO `box_file` VALUES ('d15ee807-e138-4c1c-b98b-935f20c539bf', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1psUmyAVXlwAAAmzY8cQ1M31.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:20:31', null, null, '51603e06481b46d7bbf460cb00ba6d43', '9933');
INSERT INTO `box_file` VALUES ('d1b2b30f-ee10-4aaa-996a-634c345efd2d', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1psU46AY3vDAAAmzY8cQ1M02.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:25:19', null, null, '51603e06481b46d7bbf460cb00ba6d43', '9933');
INSERT INTO `box_file` VALUES ('d1ece0b6-d63a-4bbc-85a7-98c87095bc4b', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pepCSAFOsvAAAmWS3Woq027.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 09:17:28', null, null, '1ac7d454d8bf479a96651709a34b0b7c', null);
INSERT INTO `box_file` VALUES ('d2221571-a7a2-430f-8481-2d3cc225bdb5', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/07/wKgAC1psTnuAcS_NAAAmzY8cQ1M79.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 18:03:39', null, null, null, '9933');
INSERT INTO `box_file` VALUES ('d368e757-ae6a-4a2a-83cd-6b2d0f044c79', '工作笔记2018.xlsx', 'http://192.168.0.11:8181/group1/M00/00/04/wKgAC1pfISSAZeH_AAAretSrUvk65.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 18:10:47', null, null, 'ea77b2fb4e1348a9b045d13ab6f998e9', '0');
INSERT INTO `box_file` VALUES ('d639fdec-3202-4580-82d5-4db1c7aa6dff', '未做功能.xlsx', '192.168.0.11:8181/group1/M00/00/07/wKgAC1psSEmACJKtAAA0eFNOKzk96.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 17:37:14', null, null, 'f8c1d37d8ba24203b178b737bfdd122a', '13432');
INSERT INTO `box_file` VALUES ('da09af81-989b-4dd8-bc30-58943661061d', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1pepNKATH2bAAAmWS3Woq045.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 09:20:23', null, null, '3bd8eeb3395d47fc8f7b441230273018', null);
INSERT INTO `box_file` VALUES ('db505ea5-3ebe-4f43-97db-180dbdbd7205', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdwF2ATorSAAAmWS3Woq074.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:05:36', null, null, '84d1c0bc8d9e4559bf3ae9ff6617faa6', null);
INSERT INTO `box_file` VALUES ('dbb5437d-e127-4f5b-b131-cc0ad63fd8b3', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/07/wKgAC1psLZ6AMcspAAAm27TAn1A43.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-27 15:43:29', null, null, 'ba54812ab6574f21b6913c54b43fcf4a', '9947');
INSERT INTO `box_file` VALUES ('dc8676cf-ec72-4c9e-aa0e-bdecc2dad555', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgblqAH7AoAAAtEPn3GTY86.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:52:28', null, null, 'acd12065f71548bd9d10b2a6186df028', '11536');
INSERT INTO `box_file` VALUES ('e01bc95a-a227-4567-a8f0-f9c3292fbdd8', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/05/wKgAC1pgbgCAHscIAAAtEPn3GTY09.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-18 17:50:58', null, null, '18d9b49a830c456dabde748d843ed416', '11536');
INSERT INTO `box_file` VALUES ('e49550f7-b988-4287-8048-e5d760bede1a', '未做功能.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1pm6MuAD2MKAAA0eFNOKzk70.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-23 15:48:31', null, null, '61b92a1c56e044589ab382fc0539c3b4', '13432');
INSERT INTO `box_file` VALUES ('e4a8d280-932a-4af8-8cb6-b0b08e60e675', '工作笔记2018.xlsx', '192.168.0.11:8181/group1/M00/00/08/wKgAC1pwQICAVWIeAAAr2bY6c7074.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-30 17:53:08', null, null, '04ee8cb7890c4a4c9b6ca5a5d23b1d08', '11225');
INSERT INTO `box_file` VALUES ('e659a52e-af47-45f9-b93f-003070682b27', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/02/wKgAC1pdofuAXTASAAAmWS3Woq047.xlsx ', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-16 17:04:36', null, null, '6a27276a4ac04a8198f94c91c9646323', null);
INSERT INTO `box_file` VALUES ('e74ccc3b-7a53-473b-ad38-ce3f144e09dd', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1phwB2AGJU7AAAmWS3Woq086.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-19 18:06:42', null, null, '6c11191e3200490c84a70bd543948ea4', '9817');
INSERT INTO `box_file` VALUES ('ed0feb38-854e-482c-b622-16969c69839a', '1.docx', 'http://192.168.0.11:8181/group1/M00/00/01/wKgAC1pcEFaACfEtAAAtEPn3GTY61.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-15 10:22:21', null, null, '61e35c940b7747caa2ae5566cabeba1b', null);
INSERT INTO `box_file` VALUES ('ef30438b-54d1-415f-a96a-a15587f8a08b', '未做功能.xlsx', 'http://192.168.0.11:8181/group1/M00/00/03/wKgAC1perOqANqlwAAA0eFNOKzk60.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-17 09:55:21', null, null, 'ed3872fdbbb448afa999bc43d16589d2', null);
INSERT INTO `box_file` VALUES ('f62d44c8-adbc-4cf4-8aad-dc8f7a633ad9', 'sendTest.xlsx', '192.168.0.11:8181/group1/M00/00/06/wKgAC1pltRKAOou1AAAmWS3Woq054.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-22 17:55:31', null, null, '104e53f6cfd54049901c91ea7705c18d', '9817');
INSERT INTO `box_file` VALUES ('fa0ea092-5d96-465c-a136-5f31a371ee8d', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxX3KAHdQgAAAgS0hji1s49.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:17:24', null, null, '1c4c253dba83496f9c0541f6fcceddaf', '8267');
INSERT INTO `box_file` VALUES ('fb88ddac-9646-466c-9d12-5857c7f1b1df', 'sendTest.xlsx', 'http://192.168.0.11:8181/group1/M00/00/06/wKgAC1piraSAVtElAAAmWS3Woq071.xlsx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-20 10:47:03', null, null, 'c77df5723c8341fa84b6f72f41041ce6', '9817');
INSERT INTO `box_file` VALUES ('fc86b5e1-d37a-4d0d-847c-46b963c40598', '新建 Microsoft Office Excel 工作表.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxUS6Aa1P1AAAofQBiEk016.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 13:16:48', null, null, '46fd9e80456a4325b09278ac10822ce6', '10365');
INSERT INTO `box_file` VALUES ('ff16cda2-7225-428c-99f8-0dd3761f2199', 'wKgAC1pgbgCAHscIAAAtEPn3GTY09.docx', 'http://192.168.0.11:8181/group1/M00/00/08/wKgAC1pxHYOAACBOAAAtEPn3GTY65.docx', '6c0f3e926f06446781f9dc013faf75c7', '2018-01-31 09:36:44', null, null, '05dc6a5e69db4487b8e038ccef01ffc4', null);
INSERT INTO `box_file` VALUES ('ff53f4bb-ca21-473f-ae33-85146d23bab0', '123.xlsx', 'http://192.168.0.11:8181/group1/M00/00/09/wKgAC1pxXf-ASxAoAAAgS0hji1s83.xlsx', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '2018-01-31 14:11:14', null, null, '84a48e32e91340679e96a9017d0eab7c', '8267');

-- ----------------------------
-- Table structure for `box_file_record`
-- ----------------------------
DROP TABLE IF EXISTS `box_file_record`;
CREATE TABLE `box_file_record` (
  `id` varchar(64) NOT NULL,
  `recipient_id` varchar(64) DEFAULT NULL,
  `file_id` varchar(64) DEFAULT NULL,
  `download_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_file_record
-- ----------------------------

-- ----------------------------
-- Table structure for `box_information`
-- ----------------------------
DROP TABLE IF EXISTS `box_information`;
CREATE TABLE `box_information` (
  `id` varchar(64) NOT NULL,
  `key_name` varchar(500) DEFAULT NULL COMMENT '字段名称',
  `key_value` varchar(500) DEFAULT NULL COMMENT '字段值',
  `key_type` varchar(60) DEFAULT NULL COMMENT '类型',
  `default_value` varchar(100) DEFAULT NULL COMMENT '默认值',
  `is_required` varchar(10) DEFAULT NULL COMMENT '是否必填',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `key_length` int(11) DEFAULT NULL COMMENT '长度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='汇总、下发数据表';

-- ----------------------------
-- Records of box_information
-- ----------------------------

-- ----------------------------
-- Table structure for `box_null`
-- ----------------------------
DROP TABLE IF EXISTS `box_null`;
CREATE TABLE `box_null` (
  `id` varchar(128) NOT NULL,
  `boxId` varchar(128) DEFAULT NULL,
  `xingming` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_null
-- ----------------------------
INSERT INTO `box_null` VALUES ('bdf06ade-7641-40dd-9706-a6397f563743', 'null', '张三', '0');

-- ----------------------------
-- Table structure for `box_test_zy`
-- ----------------------------
DROP TABLE IF EXISTS `box_test_zy`;
CREATE TABLE `box_test_zy` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_test_zy
-- ----------------------------

-- ----------------------------
-- Table structure for `box_topic_answer`
-- ----------------------------
DROP TABLE IF EXISTS `box_topic_answer`;
CREATE TABLE `box_topic_answer` (
  `id` varchar(64) NOT NULL,
  `option_answer` varchar(500) DEFAULT NULL,
  `qid` varchar(64) DEFAULT NULL,
  `serial_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_topic_answer
-- ----------------------------
INSERT INTO `box_topic_answer` VALUES ('00a771c8-0ba3-4fdf-87ed-a1aa24b48e15', '晴朗', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', '1');
INSERT INTO `box_topic_answer` VALUES ('01d0a8dd-cba5-492c-b0f7-934bd507e43b', '22', '92b72949-66bc-4ad7-b1f5-03dd1344a087', '1');
INSERT INTO `box_topic_answer` VALUES ('01f8965e-b7dc-4703-a9cc-14ed12955426', '55', '92b72949-66bc-4ad7-b1f5-03dd1344a087', '4');
INSERT INTO `box_topic_answer` VALUES ('03099956-047f-46b9-a4f4-d4d78031389b', '有雨', '8e9ebd61-645f-4872-bd29-55ce21e10d61', '3');
INSERT INTO `box_topic_answer` VALUES ('042b7de5-bc28-4c96-bcfc-badd5f057e22', '选项三', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', '3');
INSERT INTO `box_topic_answer` VALUES ('0484ba69-a8dd-4502-bd06-13995b89673e', '选项三', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', '3');
INSERT INTO `box_topic_answer` VALUES ('04e64117-bb29-4b6a-b244-871efbe411b0', '选项四', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', '4');
INSERT INTO `box_topic_answer` VALUES ('06bf019c-3f78-4424-a923-ecae8331fa5e', '88', 'd99a15f2-0492-4554-95d3-5579a1f81760', '4');
INSERT INTO `box_topic_answer` VALUES ('07a91602-a9b7-4544-972b-d3f59af1aee5', '转晴', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', '3');
INSERT INTO `box_topic_answer` VALUES ('0a1b6f24-895e-48b7-a524-17663bbc65fa', '有雨', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', '4');
INSERT INTO `box_topic_answer` VALUES ('0bfb9946-030a-41c6-940c-df1682c33b4c', '有雨', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', '4');
INSERT INTO `box_topic_answer` VALUES ('0c441191-dc97-4fc0-909f-764f0636f6cd', '', '7ef33265-e95f-4a14-a048-258c42096bd8', null);
INSERT INTO `box_topic_answer` VALUES ('0d264ebc-aac0-4b2a-9514-3974691381b1', '多云', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', '2');
INSERT INTO `box_topic_answer` VALUES ('0d6e56fa-1cb3-4e0f-9836-144a91480139', '转晴', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', '3');
INSERT INTO `box_topic_answer` VALUES ('0e3e85d7-3f0b-4974-bf8d-d6875872e0f4', '选项二', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', '2');
INSERT INTO `box_topic_answer` VALUES ('0e42b7e7-72bc-49c6-833a-80c0336c9531', '55', '4e6868db-4f58-4d97-bfc3-9a634f5be742', '4');
INSERT INTO `box_topic_answer` VALUES ('106198ce-1561-49c1-9a31-831b9fc0f950', '特别好', 'a0b72eee-6b80-4189-874c-f3dbe9cb76c3', '4');
INSERT INTO `box_topic_answer` VALUES ('113b96db-a6d5-4e2f-8bc8-9bcd761ffc1a', '转晴', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', '3');
INSERT INTO `box_topic_answer` VALUES ('120638b8-94fb-4af6-8ff2-456850468771', '选项三', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', '3');
INSERT INTO `box_topic_answer` VALUES ('15315c9b-0176-4506-8f04-7748d05ce287', '晴朗', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', '1');
INSERT INTO `box_topic_answer` VALUES ('16828286-8b3d-49ed-9624-77b9f477c5ab', '选项三', '189409ec-3107-479b-ab4b-51c6c98a7879', '3');
INSERT INTO `box_topic_answer` VALUES ('183e11ab-8501-49b0-9faf-0fea6fc8db94', '55', '3b26a007-aa30-4860-9b29-088af793d531', '4');
INSERT INTO `box_topic_answer` VALUES ('1a12d4a9-2122-4f9a-8749-976badc22537', '多云', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', '2');
INSERT INTO `box_topic_answer` VALUES ('1b64a827-15ea-4e66-b593-41bcd341fd0c', '33', '92b72949-66bc-4ad7-b1f5-03dd1344a087', '2');
INSERT INTO `box_topic_answer` VALUES ('20dfa6d0-8055-4d81-bea9-0a4e69e153dc', '有雨', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', '4');
INSERT INTO `box_topic_answer` VALUES ('2125caa2-bde7-4e0d-bdab-871acaa19634', '选项三', '7dd3d268-8049-4bf8-8fa8-612a6baf16db', '3');
INSERT INTO `box_topic_answer` VALUES ('21fce0e9-1307-49be-9b48-7d709879ae17', '有雨', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', '4');
INSERT INTO `box_topic_answer` VALUES ('24d67254-3f8e-48bd-bf31-819d30cf0bfe', '晴朗', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', '1');
INSERT INTO `box_topic_answer` VALUES ('252cebb7-bfea-4f4d-9af7-9146034a13ff', '晴朗', 'a69677ef-e383-4d4a-ae16-8805792cc338', '1');
INSERT INTO `box_topic_answer` VALUES ('25ae2636-d71d-4b24-b8f3-df97c1fc03c5', '晴朗', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', '1');
INSERT INTO `box_topic_answer` VALUES ('26d73e1f-10ba-4f63-98b1-e8c3da64ccc0', '有雨', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', '4');
INSERT INTO `box_topic_answer` VALUES ('271e1248-3897-43dd-a4a4-38538ab44561', '', '01923737-c520-4c99-b192-45af379ea72c', null);
INSERT INTO `box_topic_answer` VALUES ('283f21f6-f447-41ac-8132-ba6fee845e22', '晴朗', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', '1');
INSERT INTO `box_topic_answer` VALUES ('286db96a-0c6a-4805-bf9b-df8de4ab2411', '晴朗', '51347224-b5c6-4711-ad71-1b55e6e47456', '1');
INSERT INTO `box_topic_answer` VALUES ('29a390af-8516-476b-81fe-d91266848f18', '选项三', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', '3');
INSERT INTO `box_topic_answer` VALUES ('29d794f1-368c-4c71-a6c0-64219130297e', '晴朗', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', '1');
INSERT INTO `box_topic_answer` VALUES ('2b7baaa4-7220-42b3-b70d-66692bce6a29', '', '7f997763-e438-4212-8430-9cdd2bcc7fd6', null);
INSERT INTO `box_topic_answer` VALUES ('2ea6d516-fed6-496a-b2a3-6c0ab34c09dd', '选项四', 'c989ebd3-7752-4124-9107-30024c793d3e', '4');
INSERT INTO `box_topic_answer` VALUES ('2fa0b831-c86b-42ac-bdba-3b1545bc85d7', '选项三', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', '3');
INSERT INTO `box_topic_answer` VALUES ('319b0085-7d29-42be-8781-9cd41ae9aae6', '', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', null);
INSERT INTO `box_topic_answer` VALUES ('320d3773-4590-4de0-89f1-ebfa59283437', '有雨', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', '4');
INSERT INTO `box_topic_answer` VALUES ('32422169-9f45-4a9c-acb2-56da83178dd5', '有雨', '970e81b1-dd46-4eb3-a377-218cfc33323f', '4');
INSERT INTO `box_topic_answer` VALUES ('32f75097-fae8-46e6-9923-6c8b87e335e8', '打雷', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', '2');
INSERT INTO `box_topic_answer` VALUES ('3324ec03-faaa-4982-ad5f-5343ba8c30b4', '有雨', '90371bdc-e533-466e-8630-1c272612da18', '4');
INSERT INTO `box_topic_answer` VALUES ('34c93401-17d0-434a-8c45-7e19747f47ab', '选项二', '46e62574-3ed3-4e7e-8f5f-94ab96989d2d', '2');
INSERT INTO `box_topic_answer` VALUES ('34ed24d9-26e0-471a-b74c-4372c7be4f50', '选项四', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', '4');
INSERT INTO `box_topic_answer` VALUES ('3604bd0a-3c51-4e72-acca-8cffc45fcb1f', 'b', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', '2');
INSERT INTO `box_topic_answer` VALUES ('36cc28be-6efa-4129-a9cd-6514e52387bf', '', '0e68b138-5324-482c-a4b8-1fb26527e378', null);
INSERT INTO `box_topic_answer` VALUES ('37e9ec9f-e432-4d61-8e8d-c96cd7fc4448', '', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', null);
INSERT INTO `box_topic_answer` VALUES ('3985888c-e7ad-4012-a1fd-f825804788bf', '选项一', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', '1');
INSERT INTO `box_topic_answer` VALUES ('3a55ee5c-0e38-4d98-b1b9-da1334412d53', '晴朗', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', '1');
INSERT INTO `box_topic_answer` VALUES ('3a9b50af-96b5-4679-8b16-98c404853324', '选项二', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', '2');
INSERT INTO `box_topic_answer` VALUES ('3aa51911-5725-4d54-89af-9b6c47febba8', '55', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', '4');
INSERT INTO `box_topic_answer` VALUES ('3ba4f0c8-a09d-4a99-8e44-59e1afec7559', '多云', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', '2');
INSERT INTO `box_topic_answer` VALUES ('3e53f8a8-e131-40c9-aedf-6ca32d17edbd', '转晴', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', '3');
INSERT INTO `box_topic_answer` VALUES ('3f444d5b-c356-4c3e-9473-e7a738d5bb15', '吃什么都行', 'b72e83e1-27e6-44b4-96cc-657efdc69717', null);
INSERT INTO `box_topic_answer` VALUES ('3fb93b68-d0ab-47ed-a555-9ff68eb431f9', '选项四', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', '4');
INSERT INTO `box_topic_answer` VALUES ('4033d3b8-2897-4346-902c-ab846e59a927', '有雨', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', '4');
INSERT INTO `box_topic_answer` VALUES ('41a1ffd8-c335-4e92-b8f3-5cc302445271', '晴朗', '85338c9b-204a-4fdc-865f-d0f462ab0456', '1');
INSERT INTO `box_topic_answer` VALUES ('44903a8e-47c6-498a-b40d-fd81c47755b1', '转晴', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', '3');
INSERT INTO `box_topic_answer` VALUES ('456cd1e0-14d9-41e3-bc70-8489dc907d19', '选项一', 'c03be955-3532-4f78-acb6-50690604035f', '1');
INSERT INTO `box_topic_answer` VALUES ('457e239e-8ab2-4fa8-834d-76a4249ebc2a', '44', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', '3');
INSERT INTO `box_topic_answer` VALUES ('460dc24d-74ea-4284-8a91-83f85a5f72b6', '33', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', '2');
INSERT INTO `box_topic_answer` VALUES ('4cf280ef-1e98-431f-978d-97eae4706c19', '22', 'c989ebd3-7752-4124-9107-30024c793d3e', '1');
INSERT INTO `box_topic_answer` VALUES ('4df619ce-3cb0-40d4-83bd-83229a2ea863', 'C', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', '3');
INSERT INTO `box_topic_answer` VALUES ('4e86bd27-98f0-4624-97e3-0ca4b3914be8', '转晴', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', '3');
INSERT INTO `box_topic_answer` VALUES ('4ff530de-5cfa-44cf-9847-1d717db75c73', '多云', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', '2');
INSERT INTO `box_topic_answer` VALUES ('50d266ab-7cd8-4dfb-baf0-7b6ce74c27ed', '选项四', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', '4');
INSERT INTO `box_topic_answer` VALUES ('527e50c4-fdab-4209-bbcf-9cfd02261ce2', '很好', 'a0b72eee-6b80-4189-874c-f3dbe9cb76c3', '2');
INSERT INTO `box_topic_answer` VALUES ('53cad439-58ea-48f0-9824-b040f2a162bd', '吃什么都行', 'd8df43ec-0694-47c6-b0e6-d8fb882f16cb', null);
INSERT INTO `box_topic_answer` VALUES ('555a354b-67b8-4d04-89c9-a67a3d7edf73', '选项四', '7dd3d268-8049-4bf8-8fa8-612a6baf16db', '4');
INSERT INTO `box_topic_answer` VALUES ('557ec3b3-fd32-425a-b82b-06ec1cff7422', '', '97a8a053-4095-4550-813a-07bd29ea700a', null);
INSERT INTO `box_topic_answer` VALUES ('55a06edc-25f8-4cab-bcd8-5c54d0d35cea', '33', '879efb1e-46a6-4801-9557-ee746a24cc31', '2');
INSERT INTO `box_topic_answer` VALUES ('5a421fb9-0f9c-4e47-9e8f-4d7412395a09', '选项四', '67f67190-6bd8-40f5-a8f8-341960c00406', '4');
INSERT INTO `box_topic_answer` VALUES ('5a4563da-5ccb-4ed7-b280-a83be5d74e96', '44', '3b26a007-aa30-4860-9b29-088af793d531', '3');
INSERT INTO `box_topic_answer` VALUES ('5b953174-9a69-48e1-bb54-e03c6b5df4c6', '多云', 'a69677ef-e383-4d4a-ae16-8805792cc338', '2');
INSERT INTO `box_topic_answer` VALUES ('5eebec7c-5187-4a57-bd2d-136e50513266', '晴朗', '8e9ebd61-645f-4872-bd29-55ce21e10d61', '1');
INSERT INTO `box_topic_answer` VALUES ('5f42d7ba-1567-4d77-baa6-0630b48de304', '选项四', '9097de93-5dcf-4938-8bdb-2407234d8dcd', '4');
INSERT INTO `box_topic_answer` VALUES ('6023eafd-f802-4be7-ab9e-f0457afcddd3', '转晴', 'a69677ef-e383-4d4a-ae16-8805792cc338', '3');
INSERT INTO `box_topic_answer` VALUES ('61c3f4d4-0bca-4da3-8b62-b544e07935a6', '选项一', '67f67190-6bd8-40f5-a8f8-341960c00406', '1');
INSERT INTO `box_topic_answer` VALUES ('6392984e-4137-4642-9aab-31dcb343a6bf', '多云', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', '2');
INSERT INTO `box_topic_answer` VALUES ('63a463a3-4c72-4535-a694-86e58fa53ebe', '22', '9706debe-56ef-4707-a5f6-f20be51aecce', '1');
INSERT INTO `box_topic_answer` VALUES ('64e83f34-cc8e-4e62-943b-e8ea4e2be473', '选项四', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', '4');
INSERT INTO `box_topic_answer` VALUES ('65368e58-089e-4087-9d19-03fe7a00c01b', '选项三', '9097de93-5dcf-4938-8bdb-2407234d8dcd', '3');
INSERT INTO `box_topic_answer` VALUES ('653b8176-f5ee-4bce-8267-b96ba77431d6', '多云', '90371bdc-e533-466e-8630-1c272612da18', '2');
INSERT INTO `box_topic_answer` VALUES ('668d34c6-6373-495f-984b-02b39b9311b0', '选项二', '7983599c-ca87-4363-8863-175a684a511a', '2');
INSERT INTO `box_topic_answer` VALUES ('690b0eba-acda-4309-963e-16e3c83e5516', '22', '4e6868db-4f58-4d97-bfc3-9a634f5be742', '1');
INSERT INTO `box_topic_answer` VALUES ('696b8c9c-fb79-4193-a504-d75c4bb2fe43', '暴雪', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', '3');
INSERT INTO `box_topic_answer` VALUES ('6a956454-d65c-4a1d-88b3-698d9e2a4e41', '有雨', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', '4');
INSERT INTO `box_topic_answer` VALUES ('6ab0463d-3607-4b67-bdaf-978177d0b592', '选项三', '46e62574-3ed3-4e7e-8f5f-94ab96989d2d', '3');
INSERT INTO `box_topic_answer` VALUES ('6bbd7566-26b8-4f71-9300-daa18c928c49', '选项一', '189409ec-3107-479b-ab4b-51c6c98a7879', '1');
INSERT INTO `box_topic_answer` VALUES ('6c99e75f-2e79-4226-bbcd-ffe15a93c255', '', '1c4280dd-9a49-4e70-8e6c-138e6964099e', null);
INSERT INTO `box_topic_answer` VALUES ('6e8aad2d-891f-4d7a-b58c-c5dce56b213d', '多云', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', '2');
INSERT INTO `box_topic_answer` VALUES ('6e9dda78-1b57-438a-b571-adfa808b408e', '选项三', 'c03be955-3532-4f78-acb6-50690604035f', '3');
INSERT INTO `box_topic_answer` VALUES ('6f09e12a-cc15-4a35-a383-f710c978a40c', '66', 'd99a15f2-0492-4554-95d3-5579a1f81760', '2');
INSERT INTO `box_topic_answer` VALUES ('705fc8c6-4d7d-429e-9153-7b03e14cbcaa', '', '73f84166-6bfc-4701-bd42-dbc77b0d066c', null);
INSERT INTO `box_topic_answer` VALUES ('70e04365-2a05-4c4d-9127-64ad1a6c33da', '暴雨', '218af481-6e53-4269-be9c-792c866fa187', '4');
INSERT INTO `box_topic_answer` VALUES ('70e91d9e-8b20-41db-b87d-18706ade4b60', '多云', '52293643-1206-4cc1-828f-f4dffb775a85', '2');
INSERT INTO `box_topic_answer` VALUES ('70eab16b-c852-46fa-8482-157224d02476', '33', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', '2');
INSERT INTO `box_topic_answer` VALUES ('71229397-8082-4df7-9c43-3d015481abfd', '33', '9706debe-56ef-4707-a5f6-f20be51aecce', '2');
INSERT INTO `box_topic_answer` VALUES ('72c4d903-7033-4952-b910-43f52b47b2d7', '打雷', '8e9ebd61-645f-4872-bd29-55ce21e10d61', '4');
INSERT INTO `box_topic_answer` VALUES ('74d9c0e6-23ac-40bc-92ce-d884ba7e867e', '选项一', 'cf6a693e-95b9-4125-9d05-bd8307750183', '1');
INSERT INTO `box_topic_answer` VALUES ('76c032a0-53da-47d5-8b0b-f92b22e85a93', '转晴', '90371bdc-e533-466e-8630-1c272612da18', '3');
INSERT INTO `box_topic_answer` VALUES ('781dd671-5aa8-4696-85e4-b4e5d28381d1', '多云', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', '2');
INSERT INTO `box_topic_answer` VALUES ('791c369d-6a27-474d-b521-79a5ac6e0f32', '44', '92b72949-66bc-4ad7-b1f5-03dd1344a087', '3');
INSERT INTO `box_topic_answer` VALUES ('79de1133-5957-4813-a368-c3e95c2d5420', '选项三', '7983599c-ca87-4363-8863-175a684a511a', '3');
INSERT INTO `box_topic_answer` VALUES ('7ae9fc4d-9a6a-443e-b252-f6a976673f33', '22', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', '1');
INSERT INTO `box_topic_answer` VALUES ('7b1c9bc6-d6a4-46eb-96d0-e71392a419dc', '55', '879efb1e-46a6-4801-9557-ee746a24cc31', '4');
INSERT INTO `box_topic_answer` VALUES ('7c6d80b9-b57f-483d-a4de-2faa1fe99019', '吃什么都行', 'd2ca8c8c-5b05-40bf-81e9-d576275da8cf', null);
INSERT INTO `box_topic_answer` VALUES ('7d4b8199-a861-4aa2-b529-d526c686e547', '选项一', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', '1');
INSERT INTO `box_topic_answer` VALUES ('81772ea8-f5e1-4290-9954-59097344cc60', '选项二', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', '2');
INSERT INTO `box_topic_answer` VALUES ('821d7c09-8828-4cf1-bced-0dd3028466b9', '多云', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', '2');
INSERT INTO `box_topic_answer` VALUES ('8b01372d-8ff1-4698-97e7-8fec4c552ca0', '多云', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', '2');
INSERT INTO `box_topic_answer` VALUES ('8ba73701-3510-4ec4-ac12-b27024f1b1c6', '龙卷风', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', '4');
INSERT INTO `box_topic_answer` VALUES ('8d04d85a-eb39-4988-b8f1-a06c3e98dc81', '', '188eefeb-27eb-4cac-81fd-92fde96f498d', null);
INSERT INTO `box_topic_answer` VALUES ('8d0cdf45-d6f2-4dbf-bdb0-77a2df4a84cf', '55', '9706debe-56ef-4707-a5f6-f20be51aecce', '4');
INSERT INTO `box_topic_answer` VALUES ('8d1d3ca0-ec2b-4fae-a04d-500bb01c5695', '有雨', '52293643-1206-4cc1-828f-f4dffb775a85', '4');
INSERT INTO `box_topic_answer` VALUES ('90b460f0-e6a4-4091-8367-6b82d46ff142', '转晴', '85338c9b-204a-4fdc-865f-d0f462ab0456', '3');
INSERT INTO `box_topic_answer` VALUES ('9421e5d3-7086-4137-a915-9d519309b692', '', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', null);
INSERT INTO `box_topic_answer` VALUES ('94ca37af-6754-483e-91ff-f01be176e9fc', '选项二', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', '2');
INSERT INTO `box_topic_answer` VALUES ('9569092b-6847-4831-ae33-d26ebbfc8f9c', '晴朗', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', '1');
INSERT INTO `box_topic_answer` VALUES ('972149fc-7981-4056-b3f9-58e7fc74145d', '44', '879efb1e-46a6-4801-9557-ee746a24cc31', '3');
INSERT INTO `box_topic_answer` VALUES ('984c3dd4-8812-46c0-b954-6636b68e0583', '转晴', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', '3');
INSERT INTO `box_topic_answer` VALUES ('985c1688-7b0d-4f32-910a-33b9e2f420ad', '转晴', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', '3');
INSERT INTO `box_topic_answer` VALUES ('98b83e25-4d5e-495b-a482-a29853496c68', '选项四', '7983599c-ca87-4363-8863-175a684a511a', '4');
INSERT INTO `box_topic_answer` VALUES ('9921a49a-0209-4a8a-bb7f-8d2c3f4c5bd0', '转晴', '51347224-b5c6-4711-ad71-1b55e6e47456', '3');
INSERT INTO `box_topic_answer` VALUES ('9bf57914-caf5-4a1a-8496-d17048293dec', '22', '879efb1e-46a6-4801-9557-ee746a24cc31', '1');
INSERT INTO `box_topic_answer` VALUES ('9c3748c7-2c52-414f-ae98-7e49ca12295f', '选项四', '189409ec-3107-479b-ab4b-51c6c98a7879', '4');
INSERT INTO `box_topic_answer` VALUES ('9d17902d-4146-4055-8246-21b216108f0c', '', 'fced936a-675e-4abb-8150-09540bbf5943', null);
INSERT INTO `box_topic_answer` VALUES ('a05411f5-0c2c-4a51-bf81-397139745b74', '选项一', '46e62574-3ed3-4e7e-8f5f-94ab96989d2d', '1');
INSERT INTO `box_topic_answer` VALUES ('a10b770f-5330-4413-a3f4-692a9b2a9083', '', '4439e069-ff3d-4c1a-8be7-90b5f2132984', null);
INSERT INTO `box_topic_answer` VALUES ('a183759c-4428-4aba-a0c5-aded79a337f0', '选项二', '9097de93-5dcf-4938-8bdb-2407234d8dcd', '2');
INSERT INTO `box_topic_answer` VALUES ('a2031c35-ff01-406c-a0a9-fa589084e8bc', '多云', '85338c9b-204a-4fdc-865f-d0f462ab0456', '2');
INSERT INTO `box_topic_answer` VALUES ('a330df3c-e43f-4f7f-9fab-4f455b9a34bd', '晴朗', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', '1');
INSERT INTO `box_topic_answer` VALUES ('a5ca6b25-3635-4848-83cb-90b9224008f9', '55', 'd99a15f2-0492-4554-95d3-5579a1f81760', '1');
INSERT INTO `box_topic_answer` VALUES ('a64bbcf8-ab5e-4518-8004-21edc50f257d', '选项三', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', '3');
INSERT INTO `box_topic_answer` VALUES ('a6b7f13e-f99b-44f1-b32c-ae6c0851c878', '转晴', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', '3');
INSERT INTO `box_topic_answer` VALUES ('a9362070-ffba-4903-9a08-97fcecb928f0', '多云', '970e81b1-dd46-4eb3-a377-218cfc33323f', '2');
INSERT INTO `box_topic_answer` VALUES ('a989429e-2575-4d02-9b6f-479fd535f0e4', '选项四', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', '4');
INSERT INTO `box_topic_answer` VALUES ('aafca0d9-2159-479f-ac49-82aa2c42c3aa', '44', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', '3');
INSERT INTO `box_topic_answer` VALUES ('ad97f21b-9585-4db8-b684-9e618c3e946e', '', '62a9f60d-8cbd-4015-9e5c-8927014226c4', null);
INSERT INTO `box_topic_answer` VALUES ('aeb7addd-183b-4989-94f5-5e5a60773726', '选项二', '67f67190-6bd8-40f5-a8f8-341960c00406', '2');
INSERT INTO `box_topic_answer` VALUES ('b0d0750d-2fc0-4bba-ba26-1aa598bd7964', '', '1bd100cd-d4d4-4882-9616-ae195301c0dc', null);
INSERT INTO `box_topic_answer` VALUES ('b0d71d42-c960-47db-9f09-3529ad0b74f7', '选项一', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', '1');
INSERT INTO `box_topic_answer` VALUES ('b0e3432f-1469-454b-a1a9-6853b6bb2254', '选项一', '7983599c-ca87-4363-8863-175a684a511a', '1');
INSERT INTO `box_topic_answer` VALUES ('b0fcee3c-c229-4cdc-9f3a-4c2bf90fa5f5', '有雨', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', '4');
INSERT INTO `box_topic_answer` VALUES ('b1b68d16-0d92-4746-848e-6fdfe4e458d5', '多云', '218af481-6e53-4269-be9c-792c866fa187', '2');
INSERT INTO `box_topic_answer` VALUES ('b28a233a-d55b-4668-8d40-9e1eb614716b', '22', '3b26a007-aa30-4860-9b29-088af793d531', '1');
INSERT INTO `box_topic_answer` VALUES ('b311d916-2abf-4217-8991-d83012292bd9', '打雷', '218af481-6e53-4269-be9c-792c866fa187', '3');
INSERT INTO `box_topic_answer` VALUES ('b3615291-6dd1-4b15-85d3-9a680b799b72', '33', '3b26a007-aa30-4860-9b29-088af793d531', '2');
INSERT INTO `box_topic_answer` VALUES ('b3ae3640-f7d1-40ad-97ac-420c6d934671', '选项一', '7dd3d268-8049-4bf8-8fa8-612a6baf16db', '1');
INSERT INTO `box_topic_answer` VALUES ('b3de8add-036a-41a3-ac21-2553bb9f0198', '22', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', '1');
INSERT INTO `box_topic_answer` VALUES ('b498b079-31ea-4370-8038-7bb8d72d8e3e', '晴朗', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', '1');
INSERT INTO `box_topic_answer` VALUES ('b54bf323-976b-4be0-9e13-89721046dfa4', '晴朗', '52293643-1206-4cc1-828f-f4dffb775a85', '1');
INSERT INTO `box_topic_answer` VALUES ('b6868a62-8bfc-408b-8964-6a8f2d81b21b', '选项一', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', '1');
INSERT INTO `box_topic_answer` VALUES ('b6938c81-95ef-4365-83ae-951bbbf63157', '55', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', '4');
INSERT INTO `box_topic_answer` VALUES ('b7b58be9-8d2d-4da3-a89c-ad2f1fbb3b4e', '转晴', '52293643-1206-4cc1-828f-f4dffb775a85', '3');
INSERT INTO `box_topic_answer` VALUES ('b891f62e-c4ba-4319-b986-92947df8c717', '晴朗', '970e81b1-dd46-4eb3-a377-218cfc33323f', '1');
INSERT INTO `box_topic_answer` VALUES ('b938e314-6e0a-491d-91c3-fca6834965ce', '选项一', '9097de93-5dcf-4938-8bdb-2407234d8dcd', '1');
INSERT INTO `box_topic_answer` VALUES ('b942494c-ae28-4ce9-a45f-a29e6daf2afc', '选项三', '67f67190-6bd8-40f5-a8f8-341960c00406', '3');
INSERT INTO `box_topic_answer` VALUES ('ba2f047b-df42-42fd-af06-673643dfd498', '22', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', '1');
INSERT INTO `box_topic_answer` VALUES ('be68f4fd-93c8-4118-ab76-b65080e4c986', '有雨', '85338c9b-204a-4fdc-865f-d0f462ab0456', '4');
INSERT INTO `box_topic_answer` VALUES ('be8e5c34-732f-4e11-9e84-8481a9cc4e14', '44', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', '3');
INSERT INTO `box_topic_answer` VALUES ('bef01226-2aeb-4d1a-8bad-cd7e3c07578c', '多云', '938b5448-1584-4400-9f29-1173515f5608', '2');
INSERT INTO `box_topic_answer` VALUES ('bfa31d3e-1cc7-41d6-bdda-e9e348750780', '选项二', 'c989ebd3-7752-4124-9107-30024c793d3e', '2');
INSERT INTO `box_topic_answer` VALUES ('c0786891-a847-420d-a899-581d04713bff', '选项四', 'cf6a693e-95b9-4125-9d05-bd8307750183', '4');
INSERT INTO `box_topic_answer` VALUES ('c169355d-a158-44a5-b6d8-6138c9af62a0', '33', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', '2');
INSERT INTO `box_topic_answer` VALUES ('c2a4bec3-936e-47ea-9653-2035c2f1608e', '', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', null);
INSERT INTO `box_topic_answer` VALUES ('c6abe7bd-67db-456f-a2c4-f365d3c48326', '选项二', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', '2');
INSERT INTO `box_topic_answer` VALUES ('c701eadd-5749-4176-b046-85b6f34178da', '晴朗', '90371bdc-e533-466e-8630-1c272612da18', '1');
INSERT INTO `box_topic_answer` VALUES ('c88a6afe-1e66-4929-90db-316112e25af6', '33', '4e6868db-4f58-4d97-bfc3-9a634f5be742', '2');
INSERT INTO `box_topic_answer` VALUES ('c97b50c5-0910-4e49-9e12-9532ac0d0c09', '吃什么都行', 'efa34ff2-fbf6-4ccf-8c0e-261382d2bc7f', null);
INSERT INTO `box_topic_answer` VALUES ('c99cfeeb-9a94-4185-ab97-ae67747386fd', '', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', null);
INSERT INTO `box_topic_answer` VALUES ('c9d77cb4-af05-49ce-a8f6-2fd8d3788a25', '有雨', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', '4');
INSERT INTO `box_topic_answer` VALUES ('ca3aae4a-6bdf-442c-8c80-0de8fe375164', '多云', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', '2');
INSERT INTO `box_topic_answer` VALUES ('ca8ddc77-c145-46d1-a57c-d5f5fe52acd2', '打雷', '970e81b1-dd46-4eb3-a377-218cfc33323f', '3');
INSERT INTO `box_topic_answer` VALUES ('cac148d8-cbc1-49ca-b86f-42a09cb61715', '22', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', '1');
INSERT INTO `box_topic_answer` VALUES ('cd0bdcfc-b985-48af-84d7-c91481e55b32', '晴朗', '218af481-6e53-4269-be9c-792c866fa187', '1');
INSERT INTO `box_topic_answer` VALUES ('ce219e55-b626-48dd-88e4-e516496938b8', '选项四', 'c03be955-3532-4f78-acb6-50690604035f', '4');
INSERT INTO `box_topic_answer` VALUES ('cece91ef-dd7a-482e-9a3c-f8d76a0f7a16', '选项二', 'c03be955-3532-4f78-acb6-50690604035f', '2');
INSERT INTO `box_topic_answer` VALUES ('cf0ba88d-87ce-4552-a0d6-d211a50a8bfe', '选项二', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', '2');
INSERT INTO `box_topic_answer` VALUES ('cfaf3634-d512-4744-b5da-da5eae10f6b1', '77', 'd99a15f2-0492-4554-95d3-5579a1f81760', '3');
INSERT INTO `box_topic_answer` VALUES ('cfbaf14a-721e-48e3-b29e-9b9d0cf59798', '晴朗', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', '1');
INSERT INTO `box_topic_answer` VALUES ('cfd60613-ff09-4131-88e3-3d42d0ce0ae6', '多云', '51347224-b5c6-4711-ad71-1b55e6e47456', '2');
INSERT INTO `box_topic_answer` VALUES ('d149b673-498b-4074-b7fe-a8baef08c395', '', 'dffa1a84-1131-4092-9a21-4e5bb6530189', null);
INSERT INTO `box_topic_answer` VALUES ('d280528b-9d21-4bae-bf78-9302e630294d', '选项一', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', '1');
INSERT INTO `box_topic_answer` VALUES ('d31d218f-e3ff-4649-8369-78ae6f79fbd4', '有雨', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', '4');
INSERT INTO `box_topic_answer` VALUES ('d3dd2f4f-5de1-4cd3-9c70-8fe2fdec053d', '55', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', '4');
INSERT INTO `box_topic_answer` VALUES ('d3ebc84c-80a0-43dd-9eaf-5d5e70946700', '非常好', 'a0b72eee-6b80-4189-874c-f3dbe9cb76c3', '3');
INSERT INTO `box_topic_answer` VALUES ('d65efb9c-7c76-423f-b4d8-ab498be316a3', '转晴', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', '3');
INSERT INTO `box_topic_answer` VALUES ('d83ff234-e788-4789-93c8-81c0374f144e', 'D', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', '4');
INSERT INTO `box_topic_answer` VALUES ('d8b47733-a6b3-47e3-8065-8b446dfa12d2', '多云', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', '2');
INSERT INTO `box_topic_answer` VALUES ('da27cff8-f36e-4f59-ad18-bfa8f4b9acc6', '33', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', '2');
INSERT INTO `box_topic_answer` VALUES ('db7f1adf-f452-4cb0-b0ba-5088d63f2d5c', '晴朗', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', '1');
INSERT INTO `box_topic_answer` VALUES ('e0233e26-49de-4e2e-8cc0-56c8505ccc09', '55', '4e6868db-4f58-4d97-bfc3-9a634f5be742', '3');
INSERT INTO `box_topic_answer` VALUES ('e0dc5489-ebbe-4106-8a5e-339bf7bcea8b', '选项二', '7dd3d268-8049-4bf8-8fa8-612a6baf16db', '2');
INSERT INTO `box_topic_answer` VALUES ('e1a0073d-ffbb-4158-8446-c4432ff9ad03', '有雨', '938b5448-1584-4400-9f29-1173515f5608', '4');
INSERT INTO `box_topic_answer` VALUES ('e313f2f6-0fe5-43c7-a080-4f259d1f8c5c', '选项四', '46e62574-3ed3-4e7e-8f5f-94ab96989d2d', '4');
INSERT INTO `box_topic_answer` VALUES ('e4b9347a-7bf6-482b-ac49-cb090f97c48f', '转晴', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', '3');
INSERT INTO `box_topic_answer` VALUES ('e85ed433-5494-45ac-8191-bf5524caf5f8', '多云', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', '2');
INSERT INTO `box_topic_answer` VALUES ('e9daf48c-3d61-4cfa-a219-cb5f84d886e1', '多云', '8e9ebd61-645f-4872-bd29-55ce21e10d61', '2');
INSERT INTO `box_topic_answer` VALUES ('eb9cfb86-8e02-4e13-915f-fe76f37d8e22', '选项四', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', '4');
INSERT INTO `box_topic_answer` VALUES ('ec3b73f8-a203-4646-a245-99a83e7fc5b9', '55', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', '4');
INSERT INTO `box_topic_answer` VALUES ('ed58fcc7-f1fa-4c76-9cff-892332ffc054', '选项三', 'c989ebd3-7752-4124-9107-30024c793d3e', '3');
INSERT INTO `box_topic_answer` VALUES ('edad1491-c0c3-4cd1-a15d-1661d06bf1bd', '选项二', '189409ec-3107-479b-ab4b-51c6c98a7879', '2');
INSERT INTO `box_topic_answer` VALUES ('ef114704-971f-4a2e-8810-2daa995e4f39', '晴朗', '938b5448-1584-4400-9f29-1173515f5608', '1');
INSERT INTO `box_topic_answer` VALUES ('f119d7d0-31a5-4ce3-9386-a666b08f623c', '选项二', 'cf6a693e-95b9-4125-9d05-bd8307750183', '2');
INSERT INTO `box_topic_answer` VALUES ('f1c210fb-7841-4c81-9f9b-022074f3dc37', '晴朗', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', '1');
INSERT INTO `box_topic_answer` VALUES ('f2d3c9a1-a4bd-4d85-b7d3-58758593b301', '选项二', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', '2');
INSERT INTO `box_topic_answer` VALUES ('f41cb0e6-08e0-4805-8adf-cc62911c426e', '转晴', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', '3');
INSERT INTO `box_topic_answer` VALUES ('f5fe4899-ebda-441b-8015-4b6438140ad6', '选项三', 'cf6a693e-95b9-4125-9d05-bd8307750183', '3');
INSERT INTO `box_topic_answer` VALUES ('f64ea15a-dc7b-41d8-8d08-c8d4408e1d82', '选项三', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', '3');
INSERT INTO `box_topic_answer` VALUES ('f65c9137-d244-4fa1-a7d9-34f751ac7612', '有雨', 'a69677ef-e383-4d4a-ae16-8805792cc338', '4');
INSERT INTO `box_topic_answer` VALUES ('f6fab2b2-a1f8-4f94-ac49-71329c2aac74', '44', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', '3');
INSERT INTO `box_topic_answer` VALUES ('f724669f-75da-4b98-a628-2eb1ee35d62d', '有雨', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', '3');
INSERT INTO `box_topic_answer` VALUES ('f794723f-9618-4b90-96a7-ea9d2a54edf5', '好', 'a0b72eee-6b80-4189-874c-f3dbe9cb76c3', '1');
INSERT INTO `box_topic_answer` VALUES ('f7f655c7-35af-4807-acd2-6099bbf1caf9', 'a', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', '1');
INSERT INTO `box_topic_answer` VALUES ('f90fc006-fcf5-4c14-b44d-5b889bbd01c1', '选项四', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', '4');
INSERT INTO `box_topic_answer` VALUES ('fa165659-8583-4602-be7f-702001b7d27c', '晴朗', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', '1');
INSERT INTO `box_topic_answer` VALUES ('fa97af25-8a72-4d67-bb18-fb5b0e82e29e', '晴朗', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', '1');
INSERT INTO `box_topic_answer` VALUES ('fab98dfc-4833-4184-b494-ea96d14bbb29', '44', '9706debe-56ef-4707-a5f6-f20be51aecce', '3');
INSERT INTO `box_topic_answer` VALUES ('fbaf5179-0f24-4a48-9ca4-92c720644b86', '转晴', '938b5448-1584-4400-9f29-1173515f5608', '3');
INSERT INTO `box_topic_answer` VALUES ('fd64868e-7467-4338-bbf6-9ee3925ebd7c', '有雨', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', '4');
INSERT INTO `box_topic_answer` VALUES ('fed55b8a-a704-4a49-8f5c-14d89074e099', '多云', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', '2');
INSERT INTO `box_topic_answer` VALUES ('feebfdb9-6d0f-465d-8072-6d2907127da2', '有雨', '51347224-b5c6-4711-ad71-1b55e6e47456', '4');
INSERT INTO `box_topic_answer` VALUES ('ffb910c0-0c5f-4f5f-9834-e5255c4ef7b1', '晴朗', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', '1');

-- ----------------------------
-- Table structure for `box_topic_answer_tpl`
-- ----------------------------
DROP TABLE IF EXISTS `box_topic_answer_tpl`;
CREATE TABLE `box_topic_answer_tpl` (
  `id` varchar(64) NOT NULL,
  `option_answer` varchar(500) DEFAULT NULL,
  `qid` varchar(64) DEFAULT NULL,
  `serial_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_topic_answer_tpl
-- ----------------------------

-- ----------------------------
-- Table structure for `box_topic_question`
-- ----------------------------
DROP TABLE IF EXISTS `box_topic_question`;
CREATE TABLE `box_topic_question` (
  `id` varchar(64) NOT NULL,
  `box_id` varchar(64) DEFAULT NULL,
  `question` varchar(500) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `serial_number` int(11) DEFAULT NULL,
  `is_required` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_topic_question
-- ----------------------------
INSERT INTO `box_topic_question` VALUES ('01923737-c520-4c99-b192-45af379ea72c', '9b7a976df24a4fdd877cb9c37d95b1bf', '吃什么', '5', '3', '2', '1');
INSERT INTO `box_topic_question` VALUES ('0e68b138-5324-482c-a4b8-1fb26527e378', 'bd7a64445b344253888690f5e246b458', '多行文本', '5', '3', '2', null);
INSERT INTO `box_topic_question` VALUES ('1508db10-ac12-42a2-966e-6d5e6ad9bfd8', '14223a92132c4853988d48b44dff99a8', '吃什么', '5', '3', '1', '1');
INSERT INTO `box_topic_question` VALUES ('188eefeb-27eb-4cac-81fd-92fde96f498d', 'd3974e87aa6445a1bb6f014a3a52d56e', '地址', '5', '3', '1', '1');
INSERT INTO `box_topic_question` VALUES ('189409ec-3107-479b-ab4b-51c6c98a7879', 'f980dbccfb284ba5b0fd02a698d4e821', '多选', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', 'd0c2d9f3d5644de7ab32e400bb501565', '备注', '5', '3', '1', '0');
INSERT INTO `box_topic_question` VALUES ('1a8bf981-1310-4a29-9cc5-bdaf69b6387d', '53077aceb36e4c5bbcec164b3fe9a45a', '年龄', '5', '2', '2', null);
INSERT INTO `box_topic_question` VALUES ('1bd100cd-d4d4-4882-9616-ae195301c0dc', '1010177543954128afcef296b2cb6336', '吃什么', '5', '3', '2', null);
INSERT INTO `box_topic_question` VALUES ('1bebfd26-d923-4e81-b441-8fd4c82e14c6', 'c089e69c9892498da56237329d2ab5f6', '地址', '5', '3', '1', '1');
INSERT INTO `box_topic_question` VALUES ('1c4280dd-9a49-4e70-8e6c-138e6964099e', '4691d19717194e6381c9c8c98179fc1e', '备注', '5', '3', '1', '0');
INSERT INTO `box_topic_question` VALUES ('218af481-6e53-4269-be9c-792c866fa187', '2e9fab2aa6184ac39dc5774944e76d9c', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('21ef6195-900b-4ddc-9a27-101a3f9d48aa', '9fdb8f22caac4d989f80e0d9fd7a7942', '吃什么', '5', '3', '2', '1');
INSERT INTO `box_topic_question` VALUES ('2f217012-d6f7-4911-8183-cf5c8c61ef0d', 'd3974e87aa6445a1bb6f014a3a52d56e', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('3b26a007-aa30-4860-9b29-088af793d531', '1010177543954128afcef296b2cb6336', '年龄', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('4439e069-ff3d-4c1a-8be7-90b5f2132984', '7414462812f4423686639b42fcb56396', '吃什么', '5', '3', '2', '1');
INSERT INTO `box_topic_question` VALUES ('46e62574-3ed3-4e7e-8f5f-94ab96989d2d', 'cabdcb2bec064d3b9704d210bbf7494c', '多选', '5', '2', '1', '0');
INSERT INTO `box_topic_question` VALUES ('4e6868db-4f58-4d97-bfc3-9a634f5be742', '12fe8b43404948ebb5f9fe1822020cc0', '年龄', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('4e6f7f01-eb27-4013-82f3-375c8f50b03d', 'bd7a64445b344253888690f5e246b458', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('51347224-b5c6-4711-ad71-1b55e6e47456', '14223a92132c4853988d48b44dff99a8', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('52293643-1206-4cc1-828f-f4dffb775a85', '8eda3e286b604c6cb9cfe65086e595c3', '天气', '5', '1', null, null);
INSERT INTO `box_topic_question` VALUES ('57f76c79-5a75-42b5-a7ff-db5b6655e9b7', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '测试天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('5a941d04-f9d0-4b03-b6a8-f8106b997fa0', '9b7a976df24a4fdd877cb9c37d95b1bf', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', 'ca3a59f57a234408aef47b86d1124163', '年龄', '5', '2', null, null);
INSERT INTO `box_topic_question` VALUES ('61c1d3fd-3e43-4334-b1ce-2817cc195a13', 'd04caaedcc0f4a7bb29f527cc918618f', '天气', '5', '1', null, null);
INSERT INTO `box_topic_question` VALUES ('62a9f60d-8cbd-4015-9e5c-8927014226c4', 'd739ff6b114a4229bc5d0b237e41a0a0', '地址', '5', '3', '2', '0');
INSERT INTO `box_topic_question` VALUES ('67f67190-6bd8-40f5-a8f8-341960c00406', '3a00e49ed46f42f3a2af1836ed9103d9', '单选', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', '7363fad3490d4ae18487c06ad9244fcd', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('73f84166-6bfc-4701-bd42-dbc77b0d066c', 'f980dbccfb284ba5b0fd02a698d4e821', '多行文本', '5', '3', '2', null);
INSERT INTO `box_topic_question` VALUES ('7697dcea-4e09-4dbf-b5a1-dbace008f13b', 'd04caaedcc0f4a7bb29f527cc918618f', '年龄', '5', '2', null, null);
INSERT INTO `box_topic_question` VALUES ('7941c9b0-ba03-4a44-ae15-1a6238a2c354', 'e92bb815bc3b4bae927f0570d9307f44', '二二二二热', '5', '1', '0', '0');
INSERT INTO `box_topic_question` VALUES ('7983599c-ca87-4363-8863-175a684a511a', 'bd7a64445b344253888690f5e246b458', '多选', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('7dd3d268-8049-4bf8-8fa8-612a6baf16db', 'cabdcb2bec064d3b9704d210bbf7494c', '单选', '5', '1', '0', '0');
INSERT INTO `box_topic_question` VALUES ('7ef33265-e95f-4a14-a048-258c42096bd8', '30d35f56ff5d474c96a785f908898e49', '多行文本', '5', '3', '2', null);
INSERT INTO `box_topic_question` VALUES ('7f997763-e438-4212-8430-9cdd2bcc7fd6', '0e75147b7d3d488485646b271653f3e4', '地址', '5', '3', '2', '0');
INSERT INTO `box_topic_question` VALUES ('85338c9b-204a-4fdc-865f-d0f462ab0456', '53077aceb36e4c5bbcec164b3fe9a45a', '天气', '5', '1', '1', null);
INSERT INTO `box_topic_question` VALUES ('879efb1e-46a6-4801-9557-ee746a24cc31', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '年龄', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('8c0af577-bcc3-41ca-9e8c-59dc4777e068', '7414462812f4423686639b42fcb56396', '多选', '5', '2', '1', '0');
INSERT INTO `box_topic_question` VALUES ('8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', 'ca3a59f57a234408aef47b86d1124163', '天气', '5', '1', null, null);
INSERT INTO `box_topic_question` VALUES ('8e9ebd61-645f-4872-bd29-55ce21e10d61', '4691d19717194e6381c9c8c98179fc1e', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('90371bdc-e533-466e-8630-1c272612da18', '8253262e5d564b1cbc34517e194aaef5', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('9097de93-5dcf-4938-8bdb-2407234d8dcd', '0e75147b7d3d488485646b271653f3e4', '年龄', '5', '2', '1', '0');
INSERT INTO `box_topic_question` VALUES ('92b72949-66bc-4ad7-b1f5-03dd1344a087', '9fdb8f22caac4d989f80e0d9fd7a7942', '年龄', '5', '2', '1', '1');
INSERT INTO `box_topic_question` VALUES ('938b5448-1584-4400-9f29-1173515f5608', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('9706debe-56ef-4707-a5f6-f20be51aecce', '9b7a976df24a4fdd877cb9c37d95b1bf', '年龄', '5', '2', '1', '1');
INSERT INTO `box_topic_question` VALUES ('970e81b1-dd46-4eb3-a377-218cfc33323f', 'c089e69c9892498da56237329d2ab5f6', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('97a8a053-4095-4550-813a-07bd29ea700a', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '吃什么', '5', '3', '2', null);
INSERT INTO `box_topic_question` VALUES ('9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', '30d35f56ff5d474c96a785f908898e49', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', '9fdb8f22caac4d989f80e0d9fd7a7942', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('a0b72eee-6b80-4189-874c-f3dbe9cb76c3', '522837a85423435aa8b12ce9bb415d90', '服务好吗', '5', '1', '0', '0');
INSERT INTO `box_topic_question` VALUES ('a69677ef-e383-4d4a-ae16-8805792cc338', '8357937d22574fdfae1b8758ce698718', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('a712b9e8-3f3c-437b-b12e-cca8c82366dc', 'ed051c2e099741489f54a58ee69a17cf', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', '5b7834cb032847c48a425e2855b3e1c6', '地址', '5', '3', '1', '1');
INSERT INTO `box_topic_question` VALUES ('b72e83e1-27e6-44b4-96cc-657efdc69717', 'd04caaedcc0f4a7bb29f527cc918618f', '吃什么', '5', '3', null, null);
INSERT INTO `box_topic_question` VALUES ('b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', '0e75147b7d3d488485646b271653f3e4', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('bb97f324-b26c-441f-95be-8aec3f9fcfca', '8eda3e286b604c6cb9cfe65086e595c3', '年龄', '5', '2', null, null);
INSERT INTO `box_topic_question` VALUES ('bdfec078-7bb2-4c2a-9941-ebd106d08aaf', 'a4dc2c092ce44b32bab662f8302c19d2', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('c03be955-3532-4f78-acb6-50690604035f', '30d35f56ff5d474c96a785f908898e49', '多选', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', '12fe8b43404948ebb5f9fe1822020cc0', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('c130f9b3-fa90-4d9a-b0dc-be84a5934818', '4409579659a540a8a49629bd6c6e43fe', '单选', '5', '1', '0', '0');
INSERT INTO `box_topic_question` VALUES ('c202c472-9ecb-4af0-a1e1-5418482cf6a2', 'f980dbccfb284ba5b0fd02a698d4e821', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('c989ebd3-7752-4124-9107-30024c793d3e', 'd739ff6b114a4229bc5d0b237e41a0a0', '身高', '5', '2', '1', '0');
INSERT INTO `box_topic_question` VALUES ('ce8f1c86-9e09-48f8-8e3f-b731740d9abf', '7414462812f4423686639b42fcb56396', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('cf6a693e-95b9-4125-9d05-bd8307750183', '5b7834cb032847c48a425e2855b3e1c6', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('d2ca8c8c-5b05-40bf-81e9-d576275da8cf', 'ca3a59f57a234408aef47b86d1124163', '吃什么', '5', '3', null, null);
INSERT INTO `box_topic_question` VALUES ('d3fa18b4-bee0-4d62-9fcf-b235cac56b07', '1010177543954128afcef296b2cb6336', '天气', '5', '1', '0', null);
INSERT INTO `box_topic_question` VALUES ('d476d65a-1fb3-471b-98f5-4006e7c5eabf', '8dd7f6c8aa414b5db2beac000fd1cec8', '天气', '5', '1', '0', '1');
INSERT INTO `box_topic_question` VALUES ('d8573e98-77d7-4e3b-aad5-41d66b33fe8f', 'd739ff6b114a4229bc5d0b237e41a0a0', '天气', '5', '1', '0', '0');
INSERT INTO `box_topic_question` VALUES ('d8d4f42e-7185-45a9-9e94-5403ac61a18c', 'd0c2d9f3d5644de7ab32e400bb501565', '天气', '5', '1', '0', '0');
INSERT INTO `box_topic_question` VALUES ('d8df43ec-0694-47c6-b0e6-d8fb882f16cb', '8eda3e286b604c6cb9cfe65086e595c3', '吃什么', '5', '3', null, null);
INSERT INTO `box_topic_question` VALUES ('d99a15f2-0492-4554-95d3-5579a1f81760', 'ed051c2e099741489f54a58ee69a17cf', '体重', '5', '2', '1', null);
INSERT INTO `box_topic_question` VALUES ('dffa1a84-1131-4092-9a21-4e5bb6530189', 'ed051c2e099741489f54a58ee69a17cf', '吃什么', '5', '3', '2', null);
INSERT INTO `box_topic_question` VALUES ('efa34ff2-fbf6-4ccf-8c0e-261382d2bc7f', '53077aceb36e4c5bbcec164b3fe9a45a', '吃什么', '5', '3', '0', null);
INSERT INTO `box_topic_question` VALUES ('fced936a-675e-4abb-8150-09540bbf5943', '12fe8b43404948ebb5f9fe1822020cc0', '吃什么', '5', '3', '2', null);

-- ----------------------------
-- Table structure for `box_topic_question_tpl`
-- ----------------------------
DROP TABLE IF EXISTS `box_topic_question_tpl`;
CREATE TABLE `box_topic_question_tpl` (
  `id` varchar(64) NOT NULL,
  `question` varchar(500) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `serial_number` int(11) DEFAULT NULL,
  `is_required` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_topic_question_tpl
-- ----------------------------

-- ----------------------------
-- Table structure for `box_topic_recipient`
-- ----------------------------
DROP TABLE IF EXISTS `box_topic_recipient`;
CREATE TABLE `box_topic_recipient` (
  `id` varchar(64) NOT NULL,
  `qid` varchar(64) DEFAULT NULL,
  `aid` varchar(500) DEFAULT NULL,
  `question` varchar(500) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  `box_id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_topic_recipient
-- ----------------------------
INSERT INTO `box_topic_recipient` VALUES ('003515db-224d-434a-859e-5109fd79760a', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '735ba536aaa541db9f7f2f2fb445a054', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('008fab1c-afc0-4578-a71c-b1593b29e041', '73f84166-6bfc-4701-bd42-dbc77b0d066c', null, '多行文本', null, 'f980dbccfb284ba5b0fd02a698d4e821', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('00f4ba2a-fbc9-42e7-b1f6-d7b683b6cf27', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', null, '吃什么', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('01d8a878-fd68-45b4-9f5e-6a44eefa024a', '7ef33265-e95f-4a14-a048-258c42096bd8', null, '多行文本', null, '30d35f56ff5d474c96a785f908898e49', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('01e8626b-51cb-440a-a0a5-b392e635f791', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', null, '天气', null, '12fe8b43404948ebb5f9fe1822020cc0', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('02309c07-d5e8-431e-9159-dc3681e895a3', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', null, '年龄', null, 'ca3a59f57a234408aef47b86d1124163', '6c0f3e926f06446781f9dc013faf75c7', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('032b3670-bb79-452d-a321-98e214662214', '879efb1e-46a6-4801-9557-ee746a24cc31', '55a06edc-25f8-4cab-bcd8-5c54d0d35cea', '年龄', '33', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('047dc27f-049a-4a89-b07b-c6c62d73e175', '218af481-6e53-4269-be9c-792c866fa187', null, '天气', null, '2e9fab2aa6184ac39dc5774944e76d9c', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0480ac64-b2f8-4612-ad93-e00a23f7656d', '97a8a053-4095-4550-813a-07bd29ea700a', null, '吃什么', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('0541b864-6c80-4b16-93e3-344d3d564168', 'd8df43ec-0694-47c6-b0e6-d8fb882f16cb', null, '吃什么', null, '8eda3e286b604c6cb9cfe65086e595c3', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('0566c8ed-c8fc-499a-9927-73f00f63fd51', 'a69677ef-e383-4d4a-ae16-8805792cc338', null, '天气', null, '8357937d22574fdfae1b8758ce698718', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0574b80d-89e8-480f-8169-debebabdca76', '90371bdc-e533-466e-8630-1c272612da18', null, '天气', null, '8253262e5d564b1cbc34517e194aaef5', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('059511ab-051d-4b9a-be1a-e90dcec65a76', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', null, '年龄', null, 'ca3a59f57a234408aef47b86d1124163', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('061c3f26-57b6-4a6d-8b1c-ab7bcdbc3c72', '46e62574-3ed3-4e7e-8f5f-94ab96989d2d', null, '多选', null, 'cabdcb2bec064d3b9704d210bbf7494c', '4032da429d2f44ddb4cbb308ebd591c6', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('064c4d8b-424b-4ea9-9ada-d0d2b491ca09', '51347224-b5c6-4711-ad71-1b55e6e47456', null, '天气', null, '14223a92132c4853988d48b44dff99a8', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('07fd59f2-4d49-4a9b-81d9-9f783e80b3e9', '97a8a053-4095-4550-813a-07bd29ea700a', null, '吃什么', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('0836d5d6-5b64-4c93-a1b3-5e8991b3b166', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', null, '二二二二热', null, 'e92bb815bc3b4bae927f0570d9307f44', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('097293ef-7443-4a08-bb95-02b854f3e341', 'fced936a-675e-4abb-8150-09540bbf5943', null, '吃什么', null, '12fe8b43404948ebb5f9fe1822020cc0', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('09cfa6e6-356c-4952-8006-5de410514319', '189409ec-3107-479b-ab4b-51c6c98a7879', null, '多选', null, 'f980dbccfb284ba5b0fd02a698d4e821', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('09e7b328-234a-43be-beb6-e235735902c2', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', 'd95a9ad3b7ac494b846278d96f6a4912', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0a599bb9-db50-44ae-be73-ce4cac2d5f8a', '4439e069-ff3d-4c1a-8be7-90b5f2132984', null, '吃什么', null, '7414462812f4423686639b42fcb56396', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('0af27bd7-bb39-4a12-a661-fb8083500917', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', null, '年龄', null, 'd04caaedcc0f4a7bb29f527cc918618f', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('0b56b506-c814-4c47-a0fb-3b44354e4bf6', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '5b576ee3a25c469fa284ef44c995fd92', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0b61fd39-6452-4e1b-bc10-58235fe5c4ec', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '6a37f521cbd749de8d3fc7ce121fdd61', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0bc4fe4d-f752-4f60-ae39-63489edc85d0', 'cf6a693e-95b9-4125-9d05-bd8307750183', '74d9c0e6-23ac-40bc-92ce-d884ba7e867e', '天气', '选项一', '5b7834cb032847c48a425e2855b3e1c6', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('0d80939e-11dc-4262-906a-eee517a3643c', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', null, '天气', null, '8dd7f6c8aa414b5db2beac000fd1cec8', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0da379d3-933a-4581-9dc3-fb788bc82128', '90371bdc-e533-466e-8630-1c272612da18', null, '天气', null, '8253262e5d564b1cbc34517e194aaef5', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0e422773-2a7c-48ab-9e9d-227261cb72d3', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', 'c2a4bec3-936e-47ea-9653-2035c2f1608e', '吃什么', '随便', '9fdb8f22caac4d989f80e0d9fd7a7942', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('0e796cb2-60af-4126-9016-d4155197e2ce', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0ea18233-3608-4d08-82fc-4a93bdaf3f9d', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '5c713a04f87f4b5798003347a6c10366', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0eac4e48-2252-496a-9b53-7016cb5334c4', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', null, '天气', null, '12fe8b43404948ebb5f9fe1822020cc0', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('0f016685-0fe4-4685-8900-f2ed8c327e58', 'dffa1a84-1131-4092-9a21-4e5bb6530189', null, '吃什么', null, 'ed051c2e099741489f54a58ee69a17cf', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('0f46480d-67d6-477c-8ccf-90ee267ff20e', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', null, '吃什么', null, '14223a92132c4853988d48b44dff99a8', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('0f6de580-b5e6-4e66-8fc0-bc1cf31b5c53', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', null, '天气', null, '8dd7f6c8aa414b5db2beac000fd1cec8', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1032d127-2e3a-4993-89dd-f3d25b700432', '92b72949-66bc-4ad7-b1f5-03dd1344a087', '1b64a827-15ea-4e66-b593-41bcd341fd0c,791c369d-6a27-474d-b521-79a5ac6e0f32', '年龄', '33,44', '9fdb8f22caac4d989f80e0d9fd7a7942', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('10a2e535-bba6-40b6-be5b-7479d2e23c5c', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', null, '备注', null, 'd0c2d9f3d5644de7ab32e400bb501565', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('115981ce-ed0c-45ab-bf9d-074de27d0e20', 'a69677ef-e383-4d4a-ae16-8805792cc338', null, '天气', null, '8357937d22574fdfae1b8758ce698718', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('12255acc-d3ae-401f-8d85-1186d7f41c38', '188eefeb-27eb-4cac-81fd-92fde96f498d', null, '地址', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('125923ff-85ee-4478-81c7-b8c04abbd71e', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', null, '天气', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('127cb6fe-e6d4-492a-b324-8d38c338d0db', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '9b88dfd273764f54a223434415d53c0a', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('134e7bc8-4391-455f-97f6-c5a068f1ed88', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '09cde27c56e34a5e98f1cffecb19394d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('140e6859-6ad4-4c9a-b850-34d6dda5641a', 'efa34ff2-fbf6-4ccf-8c0e-261382d2bc7f', null, '吃什么', null, '53077aceb36e4c5bbcec164b3fe9a45a', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('1448775f-a601-4c76-9f7e-b9dc6ef3fb37', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', 'cfbaf14a-721e-48e3-b29e-9b9d0cf59798', '天气', '晴朗', '8dd7f6c8aa414b5db2beac000fd1cec8', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('1519174e-e209-40ba-9bb6-f709121132cd', '85338c9b-204a-4fdc-865f-d0f462ab0456', null, '天气', null, '53077aceb36e4c5bbcec164b3fe9a45a', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('15221b25-5465-47d9-af8f-dbaa2d843023', 'cf6a693e-95b9-4125-9d05-bd8307750183', null, '天气', null, '5b7834cb032847c48a425e2855b3e1c6', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('158ce5e8-1171-4af8-8b3c-c173f8d5eb69', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', null, '天气', null, 'a4dc2c092ce44b32bab662f8302c19d2', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('15dadaff-ffa5-4179-a875-3d0de593d451', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', null, '天气', null, 'ed051c2e099741489f54a58ee69a17cf', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('169b99f3-380f-4c8a-a187-6a6c225b0a9e', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', null, '天气', null, '8dd7f6c8aa414b5db2beac000fd1cec8', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1744aa8e-df6a-4563-a220-e11aff76c5ac', '7f997763-e438-4212-8430-9cdd2bcc7fd6', '2b7baaa4-7220-42b3-b70d-66692bce6a29', '地址', '广州', '0e75147b7d3d488485646b271653f3e4', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('17c2f5ea-001c-4cfd-bcd7-f39b5d69c471', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', '25ae2636-d71d-4b24-b8f3-df97c1fc03c5', '天气', '晴朗', 'd739ff6b114a4229bc5d0b237e41a0a0', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('17ceabf8-1234-4666-819b-3e6ce1b450ca', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', '3985888c-e7ad-4012-a1fd-f825804788bf', '天气', '选项一', '7414462812f4423686639b42fcb56396', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('17f71058-4fec-44ba-b1f4-d3042ee9e85b', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', '984c3dd4-8812-46c0-b954-6636b68e0583', '天气', '转晴', '7363fad3490d4ae18487c06ad9244fcd', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('1866cd9e-d74e-47c5-bb55-cfb046b27b16', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', null, '天气', null, '0e75147b7d3d488485646b271653f3e4', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1a541c68-af02-484b-aba8-abe6f6967c4e', 'd99a15f2-0492-4554-95d3-5579a1f81760', null, '体重', null, 'ed051c2e099741489f54a58ee69a17cf', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('1a5934e8-de73-447a-bdf3-f00b0a56d4b9', '1c4280dd-9a49-4e70-8e6c-138e6964099e', null, '备注', null, '4691d19717194e6381c9c8c98179fc1e', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('1a6aefaa-b948-476f-bef2-1c0766b263c0', '938b5448-1584-4400-9f29-1173515f5608', null, '天气', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1b640ac4-b8db-4f8b-93f2-fe128f663bf3', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', null, '天气', null, 'a4dc2c092ce44b32bab662f8302c19d2', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1b7be385-cfb9-4a42-a855-d15ab2500f99', '879efb1e-46a6-4801-9557-ee746a24cc31', null, '年龄', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('1c70ee41-cc8c-4e98-9a31-4d222c972419', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', null, '天气', null, '30d35f56ff5d474c96a785f908898e49', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1d4623f3-ff54-4ce4-a19f-72bad2ae95f8', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '5b576ee3a25c469fa284ef44c995fd92', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1d758ea2-1f0a-4cf5-9de2-17b427e52f2b', '218af481-6e53-4269-be9c-792c866fa187', null, '天气', null, '2e9fab2aa6184ac39dc5774944e76d9c', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1de49847-a8b7-4a99-9d34-3d2f314e2725', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('1eeb03d1-92d4-4cfd-94fd-a3c41bf85587', '9097de93-5dcf-4938-8bdb-2407234d8dcd', null, '年龄', null, '0e75147b7d3d488485646b271653f3e4', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('1fa66411-5f7d-4b3f-9da4-af8309f0cd73', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', null, '天气', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('2001c218-1210-403a-a1d8-5432c2cea970', '1bd100cd-d4d4-4882-9616-ae195301c0dc', null, '吃什么', null, '1010177543954128afcef296b2cb6336', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('20284031-f2a3-451b-9b2c-553c94a4834b', 'fced936a-675e-4abb-8150-09540bbf5943', null, '吃什么', null, '12fe8b43404948ebb5f9fe1822020cc0', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('20ce5351-f6be-47e3-a173-c2899614dee2', '7ef33265-e95f-4a14-a048-258c42096bd8', null, '多行文本', null, '30d35f56ff5d474c96a785f908898e49', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('20d2fc35-b9bb-4033-8728-afc6ca07e200', 'c989ebd3-7752-4124-9107-30024c793d3e', null, '身高', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('238063d8-2eb4-476d-841e-8fddeb68c8db', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('242e0662-10a1-4d57-a1fe-b83bdfe6c8e5', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('254bf217-bb00-4889-920a-3ffd0550f51e', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', 'fa97af25-8a72-4d67-bb18-fb5b0e82e29e', '天气', '晴朗', 'ed051c2e099741489f54a58ee69a17cf', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('255f0de8-3c0a-4064-901e-3093e6534809', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', null, '天气', null, '7363fad3490d4ae18487c06ad9244fcd', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('260b8581-512f-456d-9135-4bd2cac5c4a1', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', null, '年龄', null, 'ca3a59f57a234408aef47b86d1124163', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('26e1be3a-84ee-423c-9d7f-7aadf180f23b', 'd99a15f2-0492-4554-95d3-5579a1f81760', null, '体重', null, 'ed051c2e099741489f54a58ee69a17cf', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('276f95cf-a6c3-4244-8cc3-5960f5861381', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', null, '年龄', null, 'd04caaedcc0f4a7bb29f527cc918618f', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('277c2d13-91b6-4081-8a73-25a52616358c', '85338c9b-204a-4fdc-865f-d0f462ab0456', null, '天气', null, '53077aceb36e4c5bbcec164b3fe9a45a', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('284dd324-fc6d-45b9-b892-4469f13a203d', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', null, '地址', null, 'c089e69c9892498da56237329d2ab5f6', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('285783a7-8538-4a5c-b4cd-dbb4ff31f999', '7983599c-ca87-4363-8863-175a684a511a', null, '多选', null, 'bd7a64445b344253888690f5e246b458', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('28d64ffa-62d4-46d0-bd84-2cba9e5235c9', '01923737-c520-4c99-b192-45af379ea72c', null, '吃什么', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('29bff9dc-3a42-4c3f-8cbc-9fda341e7071', '9097de93-5dcf-4938-8bdb-2407234d8dcd', null, '年龄', null, '0e75147b7d3d488485646b271653f3e4', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('2bc68152-e4f8-414d-901a-4449dbdd3d29', '73f84166-6bfc-4701-bd42-dbc77b0d066c', null, '多行文本', null, 'f980dbccfb284ba5b0fd02a698d4e821', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('2bd10487-bc79-4b3c-ae78-35c342ec9cf2', '188eefeb-27eb-4cac-81fd-92fde96f498d', null, '地址', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('2c051695-3602-475a-bfd5-1574d2aaefa8', 'cf6a693e-95b9-4125-9d05-bd8307750183', null, '天气', null, '5b7834cb032847c48a425e2855b3e1c6', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('2cc528aa-dbbe-4152-a6ac-ca869e50a50e', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', null, '天气', null, '30d35f56ff5d474c96a785f908898e49', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('2da61e67-2224-43cd-8029-37b10a741683', '8e9ebd61-645f-4872-bd29-55ce21e10d61', '72c4d903-7033-4952-b910-43f52b47b2d7', '天气', '打雷', '4691d19717194e6381c9c8c98179fc1e', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('2dbaf79f-5bfc-48d3-9d94-3b2e944264b0', 'd2ca8c8c-5b05-40bf-81e9-d576275da8cf', null, '吃什么', null, 'ca3a59f57a234408aef47b86d1124163', '6c0f3e926f06446781f9dc013faf75c7', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('2de4179d-74e1-4f80-a16f-b8adb51873f2', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', null, '天气', null, 'bd7a64445b344253888690f5e246b458', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('2e1451b1-faf0-463c-a044-697a9e8999fc', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', null, '年龄', null, '8eda3e286b604c6cb9cfe65086e595c3', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('2ee68ee6-7470-4975-ac1c-a2d4ad2c9667', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', 'c99cfeeb-9a94-4185-ab97-ae67747386fd', '地址', '阿尔卑斯', 'c089e69c9892498da56237329d2ab5f6', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('2f5b95b7-f025-42d0-9997-43e9dc04b020', 'c03be955-3532-4f78-acb6-50690604035f', null, '多选', null, '30d35f56ff5d474c96a785f908898e49', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('2f6b39d1-11a7-48c9-90e4-f0d2f9d453a4', '92b72949-66bc-4ad7-b1f5-03dd1344a087', null, '年龄', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('2fbc990a-fd4d-4a8a-bf15-deb649f9b6b2', '4e6868db-4f58-4d97-bfc3-9a634f5be742', null, '年龄', null, '12fe8b43404948ebb5f9fe1822020cc0', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('30b3c97a-b7fe-4514-8ec7-47be8e258aca', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', null, '天气', null, 'd0c2d9f3d5644de7ab32e400bb501565', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('313aa080-6da5-48e4-b5da-c51f3413ca00', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', null, '年龄', null, '8eda3e286b604c6cb9cfe65086e595c3', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('3168d745-a53e-4095-b280-a6a9f824d53a', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', null, '多选', null, '7414462812f4423686639b42fcb56396', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('319ec7ac-c05c-4092-b904-3a68a298e4b1', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('3240bf08-cc1d-4453-8e30-8ff90d1dee63', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', null, '天气', null, 'ed051c2e099741489f54a58ee69a17cf', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('32471462-c268-4a38-84dc-7d7053032d30', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', null, '天气', null, 'd0c2d9f3d5644de7ab32e400bb501565', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('339a3212-aeeb-403c-93ee-c4872a65f919', '62a9f60d-8cbd-4015-9e5c-8927014226c4', 'ad97f21b-9585-4db8-b684-9e618c3e946e', '地址', '我', 'd739ff6b114a4229bc5d0b237e41a0a0', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('33ae8692-c0c2-4bf4-8ee2-5db0c29e32d7', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', null, '天气', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('357fec83-ad2c-4c8d-8755-9a64345b3354', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', null, '吃什么', null, '14223a92132c4853988d48b44dff99a8', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('35ab5fa3-3d7e-4aec-a758-50718629a4b5', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', null, '天气', null, 'bd7a64445b344253888690f5e246b458', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('35b91769-dd2e-436b-922d-46e31218c67f', '9706debe-56ef-4707-a5f6-f20be51aecce', null, '年龄', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('35dd19ca-ac45-4282-8991-303c361c9e55', '51347224-b5c6-4711-ad71-1b55e6e47456', null, '天气', null, '14223a92132c4853988d48b44dff99a8', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('365d59d0-ab3c-45a8-9f9e-703f2ff362c3', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', 'f41cb0e6-08e0-4805-8adf-cc62911c426e', '天气', '转晴', '1010177543954128afcef296b2cb6336', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('36b29573-6421-4f16-8fc8-10d68ef1ef10', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', '8ba73701-3510-4ec4-ac12-b27024f1b1c6', '天气', '龙卷风', 'a4dc2c092ce44b32bab662f8302c19d2', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('36b94ae4-fe3b-4ae3-93c8-fc3c9c49a633', 'a69677ef-e383-4d4a-ae16-8805792cc338', null, '天气', null, '8357937d22574fdfae1b8758ce698718', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('36d60297-7305-40f8-ade0-4f80120b4169', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', null, '吃什么', null, '14223a92132c4853988d48b44dff99a8', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('36eb6450-1937-4dbd-9c56-17c204188731', 'dffa1a84-1131-4092-9a21-4e5bb6530189', '', '吃什么', null, 'ed051c2e099741489f54a58ee69a17cf', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('377e78d0-d5f3-42ef-8050-8da4645eba66', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', null, '天气', null, 'ca3a59f57a234408aef47b86d1124163', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('390d8515-848e-45c7-8e4c-72f2312b31ba', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', null, '吃什么', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('392252c7-7994-4258-9b54-9f48e38e5c0d', 'c03be955-3532-4f78-acb6-50690604035f', null, '多选', null, '30d35f56ff5d474c96a785f908898e49', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('39a2e6ed-a46a-4ec6-86c6-54e603deea8c', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', null, '地址', null, '5b7834cb032847c48a425e2855b3e1c6', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('39a85f60-d1d3-4e1b-82c8-2db1249bc0a5', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', '0e3e85d7-3f0b-4974-bf8d-d6875872e0f4,2fa0b831-c86b-42ac-bdba-3b1545bc85d7', '多选', '选项二,选项三', '7414462812f4423686639b42fcb56396', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('3b3e7c4e-fc16-40f9-be31-43c839c3a55d', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '735ba536aaa541db9f7f2f2fb445a054', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('3bc08bb9-22cf-407b-b7a5-70ceec216654', '1bd100cd-d4d4-4882-9616-ae195301c0dc', null, '吃什么', null, '1010177543954128afcef296b2cb6336', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('3c670d8f-39a8-4c45-b89d-63d7b384a5bd', '01923737-c520-4c99-b192-45af379ea72c', null, '吃什么', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('3cd199d3-51e7-4d53-a740-80ef36d47855', '3b26a007-aa30-4860-9b29-088af793d531', null, '年龄', null, '1010177543954128afcef296b2cb6336', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('3dd47bb5-1927-4433-8635-a6bbf698c948', '4e6868db-4f58-4d97-bfc3-9a634f5be742', null, '年龄', null, '12fe8b43404948ebb5f9fe1822020cc0', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('3dd63963-51b3-4133-88a6-f9e25fc2c1a6', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', '37e9ec9f-e432-4d61-8e8d-c96cd7fc4448', '吃什么', '都行', '14223a92132c4853988d48b44dff99a8', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('3deed5b0-9a9a-4b5a-a80a-68a027c1d57f', '9706debe-56ef-4707-a5f6-f20be51aecce', null, '年龄', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('3df4789b-413e-4cbb-8531-1d61c74900cf', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', '94ca37af-6754-483e-91ff-f01be176e9fc', '天气', '选项二', '0e75147b7d3d488485646b271653f3e4', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('3e557367-9320-4833-a95f-03ff7f0ced7c', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', null, '天气', null, '0e75147b7d3d488485646b271653f3e4', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('3ea3be9b-8532-4a96-9074-fc5e05fe34ee', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '9a84879cfeab4578a04b0747f189d4aa', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('3ecff270-e5f1-4163-a5d9-92e0b24cc40a', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', null, '备注', null, 'd0c2d9f3d5644de7ab32e400bb501565', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('3f130d88-1789-44ad-af43-a203bbf36e58', '188eefeb-27eb-4cac-81fd-92fde96f498d', null, '地址', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('3f32e755-9fc4-4a95-82ee-e27bb7cba986', '73f84166-6bfc-4701-bd42-dbc77b0d066c', null, '多行文本', null, 'f980dbccfb284ba5b0fd02a698d4e821', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('3f456a5a-7c98-4878-a7fe-ba4811f6faae', '52293643-1206-4cc1-828f-f4dffb775a85', null, '天气', null, '8eda3e286b604c6cb9cfe65086e595c3', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('40aaefad-3aa9-466e-9e70-cc31c7bc2079', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', '319b0085-7d29-42be-8781-9cd41ae9aae6', '备注', '', 'd0c2d9f3d5644de7ab32e400bb501565', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('41db33c6-b3ee-4aa9-abeb-74de25e9078f', '189409ec-3107-479b-ab4b-51c6c98a7879', null, '多选', null, 'f980dbccfb284ba5b0fd02a698d4e821', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('41e09669-affe-4ac0-ad4d-1e443c12bbff', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', null, '年龄', null, '53077aceb36e4c5bbcec164b3fe9a45a', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('422de1c2-2db3-40dc-8704-611a6a391558', 'b72e83e1-27e6-44b4-96cc-657efdc69717', null, '吃什么', null, 'd04caaedcc0f4a7bb29f527cc918618f', '6c0f3e926f06446781f9dc013faf75c7', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('445be2d7-1c64-4e0c-9c26-507615332d20', '1c4280dd-9a49-4e70-8e6c-138e6964099e', null, '备注', null, '4691d19717194e6381c9c8c98179fc1e', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('45ab346d-9dce-4d8d-b685-2619b9a064a7', '9706debe-56ef-4707-a5f6-f20be51aecce', null, '年龄', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('45d03e48-049b-47e3-a077-21f1030440c0', '51347224-b5c6-4711-ad71-1b55e6e47456', 'cfd60613-ff09-4131-88e3-3d42d0ce0ae6', '天气', '多云', '14223a92132c4853988d48b44dff99a8', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('45d7bfb0-039e-45d6-992e-46632b0c769c', '3b26a007-aa30-4860-9b29-088af793d531', null, '年龄', null, '1010177543954128afcef296b2cb6336', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('45fa943c-0120-4063-8ca6-225f8e25defc', '73f84166-6bfc-4701-bd42-dbc77b0d066c', null, '多行文本', null, 'f980dbccfb284ba5b0fd02a698d4e821', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('479f3674-b0fd-476f-a62a-02a13048d9d7', '9097de93-5dcf-4938-8bdb-2407234d8dcd', null, '年龄', null, '0e75147b7d3d488485646b271653f3e4', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('4882b4d6-732e-400f-bf9a-2e2851947141', 'c03be955-3532-4f78-acb6-50690604035f', null, '多选', null, '30d35f56ff5d474c96a785f908898e49', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('4891133d-ced3-49b7-8fdf-7e879c2d80cd', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', null, '天气', null, 'a4dc2c092ce44b32bab662f8302c19d2', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4ac6ad79-5938-4f2f-bac0-ee32b7740ada', 'd99a15f2-0492-4554-95d3-5579a1f81760', '6f09e12a-cc15-4a35-a383-f710c978a40c,cfaf3634-d512-4744-b5da-da5eae10f6b1', '体重', '66,77', 'ed051c2e099741489f54a58ee69a17cf', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('4cad27dd-74c9-4008-9984-d17ab0671ce1', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', null, '吃什么', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('4d0ce596-cc87-4bfd-a9c7-785b047546d1', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', null, '天气', null, '12fe8b43404948ebb5f9fe1822020cc0', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4db2e7be-f630-4997-bc7f-3c0cbb4caf7b', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', null, '天气', null, 'bd7a64445b344253888690f5e246b458', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4e184adb-729c-4855-b7f4-52428387f4a9', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', null, '天气', null, '1010177543954128afcef296b2cb6336', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4e7f14c6-2675-4726-ab76-db0d6bd8d474', '52293643-1206-4cc1-828f-f4dffb775a85', null, '天气', null, '8eda3e286b604c6cb9cfe65086e595c3', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4eee5364-7a58-4c12-ba8a-cff50c5e18ed', '90371bdc-e533-466e-8630-1c272612da18', null, '天气', null, '8253262e5d564b1cbc34517e194aaef5', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4f4bb44e-8dfb-4c7f-b5bf-60b2092188dd', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', 'a44844809c844c14a986063cb2ad586c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('4f6eeb77-b551-4e92-8487-a1fbddf9a2c7', '9706debe-56ef-4707-a5f6-f20be51aecce', null, '年龄', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('5096c5b3-b4dc-4c4d-93a9-d2319deff750', '7ef33265-e95f-4a14-a048-258c42096bd8', '0c441191-dc97-4fc0-909f-764f0636f6cd', '多行文本', '12345', '30d35f56ff5d474c96a785f908898e49', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('522f9fb6-0439-4896-be68-ffe8df43c8a2', '4439e069-ff3d-4c1a-8be7-90b5f2132984', null, '吃什么', null, '7414462812f4423686639b42fcb56396', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('52d28f1d-a195-4455-ad89-1960a56ddaf1', '85338c9b-204a-4fdc-865f-d0f462ab0456', null, '天气', null, '53077aceb36e4c5bbcec164b3fe9a45a', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('541646d4-7a83-4e98-83bb-74f35be965ce', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', 'ce038092a81e4ad8acdf99de8e4b50ce', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5454892a-312a-45ce-a0b1-589884d67abd', '970e81b1-dd46-4eb3-a377-218cfc33323f', null, '天气', null, 'c089e69c9892498da56237329d2ab5f6', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('54673bc5-476c-42d2-8c38-7210b0eeaa2b', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', null, '备注', null, 'd0c2d9f3d5644de7ab32e400bb501565', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('549985b8-d9da-46a4-a8a8-e7b037be2b88', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '5ac8e6855b534c1e939e09de6f6d720f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('550e3e53-8b7c-4b48-a97b-7dd9f63b5fb2', '938b5448-1584-4400-9f29-1173515f5608', null, '天气', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('55a0fe78-e7f6-4934-9aeb-734d327f6465', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', null, '天气', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('56456b9e-645e-4ccc-878e-2cebf155ea05', '5ee9d4e3-c6dc-42b7-8578-b51e4ac18002', null, '年龄', null, 'ca3a59f57a234408aef47b86d1124163', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('56b61912-169b-4539-b883-972041a034ad', '73f84166-6bfc-4701-bd42-dbc77b0d066c', '705fc8c6-4d7d-429e-9153-7b03e14cbcaa', '多行文本', '1', 'f980dbccfb284ba5b0fd02a698d4e821', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('56e8e027-9c37-4303-8737-bb18e9d705b0', '879efb1e-46a6-4801-9557-ee746a24cc31', null, '年龄', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('577c6de7-2020-4dd0-b744-814041b8d55b', 'd8df43ec-0694-47c6-b0e6-d8fb882f16cb', null, '吃什么', null, '8eda3e286b604c6cb9cfe65086e595c3', '6c0f3e926f06446781f9dc013faf75c7', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('58256799-68c6-4161-859b-37601f7f343a', '7f997763-e438-4212-8430-9cdd2bcc7fd6', null, '地址', null, '0e75147b7d3d488485646b271653f3e4', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('5874ad75-1ebc-4b79-9106-b0412fc4c007', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', null, '天气', null, 'a4dc2c092ce44b32bab662f8302c19d2', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('58e9fa93-bbd9-42dc-b367-7cf64e389ea5', '1c4280dd-9a49-4e70-8e6c-138e6964099e', null, '备注', null, '4691d19717194e6381c9c8c98179fc1e', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('599513df-43c6-4059-8ee5-baca3f2a4055', '01923737-c520-4c99-b192-45af379ea72c', '271e1248-3897-43dd-a4a4-38538ab44561', '吃什么', '都行', '9b7a976df24a4fdd877cb9c37d95b1bf', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('5a95a245-fbe0-4f23-952d-23522deb87ca', '218af481-6e53-4269-be9c-792c866fa187', null, '天气', null, '2e9fab2aa6184ac39dc5774944e76d9c', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5ba50357-8d90-4be0-9dc2-233f9c8b241b', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', null, '天气', null, 'bd7a64445b344253888690f5e246b458', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5bda6a6a-82bd-4428-b18c-cd8d6e865fd9', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', null, '多选', null, '7414462812f4423686639b42fcb56396', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('5c51bec8-b00a-4aeb-9abc-d7710c12aa3e', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', null, '天气', null, '0e75147b7d3d488485646b271653f3e4', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5d12fa59-e250-4d20-b2b6-5ba1b7039c99', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5d81dedc-ed43-4d8f-8952-55d50adbf6a9', '85338c9b-204a-4fdc-865f-d0f462ab0456', null, '天气', null, '53077aceb36e4c5bbcec164b3fe9a45a', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5dbb3faa-eabd-4d63-b58e-30bdcdd03660', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5e173640-e94a-4f1c-8eea-0553c3c2949f', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', null, '天气', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('5f063911-3adb-4771-bc18-139bad29bf0a', '189409ec-3107-479b-ab4b-51c6c98a7879', null, '多选', null, 'f980dbccfb284ba5b0fd02a698d4e821', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('5f50f0c9-4295-4bc2-b310-1ff40cb4eaf7', 'efa34ff2-fbf6-4ccf-8c0e-261382d2bc7f', null, '吃什么', null, '53077aceb36e4c5bbcec164b3fe9a45a', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('5fdfc10d-b178-4391-a255-0426cb01bbd5', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', null, '多选', null, '7414462812f4423686639b42fcb56396', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('6036d288-44ac-4517-b467-297ae1d091fa', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', 'd65efb9c-7c76-423f-b4d8-ab498be316a3', '天气', '转晴', 'bd7a64445b344253888690f5e246b458', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('60af1570-2abe-4b75-b84c-dbb54073f9dd', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '7bfc995a6c204df4b6142db2b24e943d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('60b8d078-592f-449e-9126-b553f26125f1', '189409ec-3107-479b-ab4b-51c6c98a7879', null, '多选', null, 'f980dbccfb284ba5b0fd02a698d4e821', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('61493150-45f9-47c4-98b0-07eb07f2da19', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', null, '多选', null, '7414462812f4423686639b42fcb56396', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('6183151d-e682-4f5d-85ac-c401dfe97c0d', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', 'c68e8e337c7d4b9d9e27b2b2b40f9fd6', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('61c47807-ec9f-457f-8c62-f271914b9131', '97a8a053-4095-4550-813a-07bd29ea700a', null, '吃什么', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('61d2bb46-0590-4e03-8e3d-2da5b3b5c64f', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', null, '天气', null, 'f980dbccfb284ba5b0fd02a698d4e821', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('62da0690-e9a6-4294-b0b3-03cf279a9667', '62a9f60d-8cbd-4015-9e5c-8927014226c4', null, '地址', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('631b0594-ab50-47a7-9e7a-e8dfc3aacf88', '938b5448-1584-4400-9f29-1173515f5608', null, '天气', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('63434a09-9015-4efe-9c49-63086b785a5d', '8e9ebd61-645f-4872-bd29-55ce21e10d61', null, '天气', null, '4691d19717194e6381c9c8c98179fc1e', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('65f4d021-d000-4f7d-9a3f-7d80e4bce44f', '9097de93-5dcf-4938-8bdb-2407234d8dcd', null, '年龄', null, '0e75147b7d3d488485646b271653f3e4', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('668c32bb-e0da-4cb5-9726-e8ec7cbe3125', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '9faea581c64c413681558fbe86cd9fb7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('67931d92-44e9-411d-93fc-76c5c5781062', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', null, '天气', null, '7363fad3490d4ae18487c06ad9244fcd', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('67e2f8ab-e0bb-4d38-aacf-8a311868b48d', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', '', '天气', null, '30d35f56ff5d474c96a785f908898e49', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('68027fc3-0fd9-4c87-8b2c-c13ab46911a5', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', 'f7f655c7-35af-4807-acd2-6099bbf1caf9', '测试天气', 'a', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('68466db6-4836-4c09-9fda-96a8b1377df2', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', null, '年龄', null, '8eda3e286b604c6cb9cfe65086e595c3', '6c0f3e926f06446781f9dc013faf75c7', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('68c0af59-426a-48f6-b80b-988852efd01b', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', null, '天气', null, 'd04caaedcc0f4a7bb29f527cc918618f', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('68f850ca-6ccb-4095-8560-856fc26eb1ba', '01923737-c520-4c99-b192-45af379ea72c', null, '吃什么', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('692023dd-de15-4730-b13f-d173352df9a3', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('69f5159e-090b-4153-8ce8-3ec65c431766', '7dd3d268-8049-4bf8-8fa8-612a6baf16db', null, '单选', null, 'cabdcb2bec064d3b9704d210bbf7494c', '4032da429d2f44ddb4cbb308ebd591c6', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('6aa93d39-ff0a-4699-b0e7-bec726f917d1', '51347224-b5c6-4711-ad71-1b55e6e47456', null, '天气', null, '14223a92132c4853988d48b44dff99a8', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('6c4b30c8-2436-43a1-a18e-c2cac6b0c525', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', null, '吃什么', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('6cb3ef32-c7da-46d8-a8b4-a6727f31cab9', '938b5448-1584-4400-9f29-1173515f5608', null, '天气', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('6d9e3850-ae68-4be4-9366-b1146494acd7', '7983599c-ca87-4363-8863-175a684a511a', null, '多选', null, 'bd7a64445b344253888690f5e246b458', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('6e17f0ae-2b73-401f-8fd3-7e7cbcf92c06', '62a9f60d-8cbd-4015-9e5c-8927014226c4', null, '地址', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('6ec68a42-90e2-4b78-b4c9-3d7e252a9336', 'dffa1a84-1131-4092-9a21-4e5bb6530189', null, '吃什么', null, 'ed051c2e099741489f54a58ee69a17cf', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('709efc97-688d-4ed8-aec3-11889ece05f4', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', null, '天气', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('70d443fb-7fd0-4040-ae49-43fc7259eba6', '188eefeb-27eb-4cac-81fd-92fde96f498d', null, '地址', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('72640295-aa1c-4866-883d-2c8c35ecdd78', '7ef33265-e95f-4a14-a048-258c42096bd8', null, '多行文本', null, '30d35f56ff5d474c96a785f908898e49', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('72c7d464-8bc9-4898-97b7-57739dc79ded', 'c989ebd3-7752-4124-9107-30024c793d3e', 'ed58fcc7-f1fa-4c76-9cff-892332ffc054', '身高', '选项三', 'd739ff6b114a4229bc5d0b237e41a0a0', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('736198c3-2e25-49d4-b77a-22b2e0fd98d6', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', null, '天气', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('739c322a-962b-4787-98b3-13d40212650b', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '8549cb4b4c04415fa0d9ab6598e42c5c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('7407e0d3-54c7-4454-a745-4ab7a3c7e021', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', null, '天气', null, '30d35f56ff5d474c96a785f908898e49', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('7559d461-3197-4242-a8f9-05875572d4d9', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', '24d67254-3f8e-48bd-bf31-819d30cf0bfe', '天气', '晴朗', '1010177543954128afcef296b2cb6336', '8a6fea61aee249848261dd684b7f8460', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('76377a9b-9556-429a-862e-607fc89a702f', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', null, '天气', null, 'f980dbccfb284ba5b0fd02a698d4e821', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('77f134fb-7e4b-4fed-84f6-7499b6e70edf', '1bd100cd-d4d4-4882-9616-ae195301c0dc', '', '吃什么', '都行', '1010177543954128afcef296b2cb6336', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('7854faaa-62a2-4046-9182-b834a83d8ac3', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', 'ce038092a81e4ad8acdf99de8e4b50ce', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('78db8a2c-4de1-4174-8eeb-368e6b05bb71', '8c0af577-bcc3-41ca-9e8c-59dc4777e068', null, '多选', null, '7414462812f4423686639b42fcb56396', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('78df38be-2f14-460a-8746-35a1ed7ab9b7', '0e68b138-5324-482c-a4b8-1fb26527e378', null, '多行文本', null, 'bd7a64445b344253888690f5e246b458', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('78eb1ecb-34a4-44f8-b6c4-fe780a9dd51a', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', null, '地址', null, 'c089e69c9892498da56237329d2ab5f6', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('79467219-41f0-4b46-be6f-c26a603656d8', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', null, '年龄', null, '53077aceb36e4c5bbcec164b3fe9a45a', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('7a4f8170-1299-4884-9977-d47915e6a675', '218af481-6e53-4269-be9c-792c866fa187', null, '天气', null, '2e9fab2aa6184ac39dc5774944e76d9c', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('7a7b6c95-15b6-425b-828a-109c2d67e5b7', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', 'd95a9ad3b7ac494b846278d96f6a4912', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('7bc88b6c-a4de-44cc-82df-bfba45415b9d', 'd2ca8c8c-5b05-40bf-81e9-d576275da8cf', null, '吃什么', null, 'ca3a59f57a234408aef47b86d1124163', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('7d6f5346-8ad3-4cf1-87ee-78ceddf13d94', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', null, '天气', null, '7414462812f4423686639b42fcb56396', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('7d817ca7-5093-40d1-878d-18ff20b722ab', 'fced936a-675e-4abb-8150-09540bbf5943', null, '吃什么', null, '12fe8b43404948ebb5f9fe1822020cc0', '6c0f3e926f06446781f9dc013faf75c7', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('7e05d2f8-b06c-4922-a636-63b23cfad729', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', null, '天气', null, '7414462812f4423686639b42fcb56396', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('7e18d954-d605-4c7c-bdf9-d3488077eb8d', '62a9f60d-8cbd-4015-9e5c-8927014226c4', null, '地址', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('7eb98374-0154-42a4-98f2-50f089d8ccc7', '3b26a007-aa30-4860-9b29-088af793d531', 'b3615291-6dd1-4b15-85d3-9a680b799b72,5a4563da-5ccb-4ed7-b280-a83be5d74e96', '年龄', '33,44', '1010177543954128afcef296b2cb6336', '8a6fea61aee249848261dd684b7f8460', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('7eeea4b5-22bc-41a2-848b-05b8c24a7183', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', null, '地址', null, '5b7834cb032847c48a425e2855b3e1c6', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('7f237f9e-d60c-4e1e-abb0-af82fa77b866', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', null, '年龄', null, '53077aceb36e4c5bbcec164b3fe9a45a', '6c0f3e926f06446781f9dc013faf75c7', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('7ff688b7-8847-43ce-98e1-86ea275920b1', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '9faea581c64c413681558fbe86cd9fb7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('803b8bfd-7e31-4945-82e9-097e43e9e3a4', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', null, '天气', null, 'f980dbccfb284ba5b0fd02a698d4e821', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('8111b162-79c0-475f-8ac1-8a225ef2f407', '0e68b138-5324-482c-a4b8-1fb26527e378', null, '多行文本', null, 'bd7a64445b344253888690f5e246b458', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('82404312-e4dc-46cb-b315-813618d0323f', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', null, '天气', null, 'f980dbccfb284ba5b0fd02a698d4e821', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('82685a13-872f-4eea-a396-627c932d8709', '92b72949-66bc-4ad7-b1f5-03dd1344a087', null, '年龄', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('8296d3a5-ac3c-4f4f-ace7-4f889b3c6a4d', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', null, '天气', null, 'd0c2d9f3d5644de7ab32e400bb501565', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('83059476-8ee0-4897-9b6e-5d50c52d19ca', '0e68b138-5324-482c-a4b8-1fb26527e378', null, '多行文本', null, 'bd7a64445b344253888690f5e246b458', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('83943d0c-e8da-4a52-b728-fea6b32cded8', 'dffa1a84-1131-4092-9a21-4e5bb6530189', null, '吃什么', null, 'ed051c2e099741489f54a58ee69a17cf', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('841a14a9-8fbf-4322-bede-8f3d9f06b097', 'c989ebd3-7752-4124-9107-30024c793d3e', null, '身高', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('8506dae1-8d94-4190-b4b5-eecb90c4f53c', '62a9f60d-8cbd-4015-9e5c-8927014226c4', null, '地址', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('850716fd-e77e-4676-a66a-f7ba988e30b4', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', null, '天气', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('85952b4e-ee4e-4e93-aad3-2dcc6ac23ea0', '4e6868db-4f58-4d97-bfc3-9a634f5be742', null, '年龄', null, '12fe8b43404948ebb5f9fe1822020cc0', '6c0f3e926f06446781f9dc013faf75c7', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('8621513d-7026-4d1a-af82-2851d6da57e2', '188eefeb-27eb-4cac-81fd-92fde96f498d', '8d04d85a-eb39-4988-b8f1-a06c3e98dc81', '地址', '喜马拉雅山', 'd3974e87aa6445a1bb6f014a3a52d56e', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('8981d509-8188-4127-a204-dd03fa6b0c6c', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', null, '天气', null, 'a4dc2c092ce44b32bab662f8302c19d2', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('8c65f659-d000-4383-b3e7-7f010c2dcc3b', '1bd100cd-d4d4-4882-9616-ae195301c0dc', '', '吃什么', 'pp[p', '1010177543954128afcef296b2cb6336', '8a6fea61aee249848261dd684b7f8460', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('8d68a5b9-c6f2-45d7-9859-332e99c7f705', 'c989ebd3-7752-4124-9107-30024c793d3e', null, '身高', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('8e0bffe4-21b4-48b1-9977-b73d39ff387d', '73f84166-6bfc-4701-bd42-dbc77b0d066c', null, '多行文本', null, 'f980dbccfb284ba5b0fd02a698d4e821', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('8e37d8af-9e48-4701-997f-93c58459c67e', '90371bdc-e533-466e-8630-1c272612da18', null, '天气', null, '8253262e5d564b1cbc34517e194aaef5', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('8f8e2528-3ed7-4da3-8522-9d662c3491c7', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', null, '备注', null, 'd0c2d9f3d5644de7ab32e400bb501565', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('90132d27-b887-440d-ac52-08a4b1848f2d', '188eefeb-27eb-4cac-81fd-92fde96f498d', null, '地址', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('91ba3381-0445-498b-810b-5c5c92be8e00', 'd99a15f2-0492-4554-95d3-5579a1f81760', null, '体重', null, 'ed051c2e099741489f54a58ee69a17cf', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('923f0cbb-1e39-46aa-9551-866ee792b183', 'd8df43ec-0694-47c6-b0e6-d8fb882f16cb', null, '吃什么', null, '8eda3e286b604c6cb9cfe65086e595c3', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('92e74c41-0fcc-4b98-a8e7-9d2437db9bda', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', null, '天气', null, 'ed051c2e099741489f54a58ee69a17cf', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('93243105-e852-4d3e-9967-bb44b45ac685', '3b26a007-aa30-4860-9b29-088af793d531', '5a4563da-5ccb-4ed7-b280-a83be5d74e96,183e11ab-8501-49b0-9faf-0fea6fc8db94', '年龄', '55,44', '1010177543954128afcef296b2cb6336', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('9396f5fb-55dc-4a5d-8ffc-0e5053a387c3', 'cf6a693e-95b9-4125-9d05-bd8307750183', null, '天气', null, '5b7834cb032847c48a425e2855b3e1c6', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('940ef15e-e3f0-40ac-8024-30ac25823c63', '879efb1e-46a6-4801-9557-ee746a24cc31', null, '年龄', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('94466486-0648-48d6-9717-5cd51dcb5a84', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', null, '天气', null, '30d35f56ff5d474c96a785f908898e49', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('96041316-bd12-4fe8-8302-fc1f0d918a73', '7983599c-ca87-4363-8863-175a684a511a', null, '多选', null, 'bd7a64445b344253888690f5e246b458', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('966a6974-4bcc-4c78-91be-24d18e6fbf77', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', null, '天气', null, '1010177543954128afcef296b2cb6336', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('967dcb29-494e-4d37-9c8b-e96432b91c3a', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', null, '天气', null, '0e75147b7d3d488485646b271653f3e4', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('96cd8643-7be9-495a-b528-38f74041370d', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', null, '天气', null, '7414462812f4423686639b42fcb56396', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('97ddddc0-2d3b-4b25-83ac-2a47d64b6090', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '5c713a04f87f4b5798003347a6c10366', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('981f1675-49ce-4e74-86e6-de69b7b657f3', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', null, '地址', null, '5b7834cb032847c48a425e2855b3e1c6', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('9a6c22f5-a0c2-4212-b687-95acf0fcbb0a', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', '3a55ee5c-0e38-4d98-b1b9-da1334412d53', '天气', '晴朗', '9b7a976df24a4fdd877cb9c37d95b1bf', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('9b6deae7-7ce5-424a-aea0-aa336c53c26e', '9097de93-5dcf-4938-8bdb-2407234d8dcd', null, '年龄', null, '0e75147b7d3d488485646b271653f3e4', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('9bd3de3a-d448-4e7a-9fb5-a2b6fd940f4a', '8e9ebd61-645f-4872-bd29-55ce21e10d61', null, '天气', null, '4691d19717194e6381c9c8c98179fc1e', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('9c16dfb4-372f-4507-a1bf-f991fb6ee26d', '97a8a053-4095-4550-813a-07bd29ea700a', '', '吃什么', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('9c2f8f10-3f8c-4061-9431-6cb1dd0be37e', '9706debe-56ef-4707-a5f6-f20be51aecce', null, '年龄', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('9e34daae-1ed7-4c55-938d-462cbdd562c7', '7983599c-ca87-4363-8863-175a684a511a', null, '多选', null, 'bd7a64445b344253888690f5e246b458', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('9fd5b6ea-fe98-42a8-8d77-31658e6ca905', 'b72e83e1-27e6-44b4-96cc-657efdc69717', null, '吃什么', null, 'd04caaedcc0f4a7bb29f527cc918618f', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('a01603e3-6bb9-46f7-87a0-19fa05af0dbe', '97a8a053-4095-4550-813a-07bd29ea700a', null, '吃什么', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('a2e9e08f-99a7-4d81-8aa7-57ce7999e7c4', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', null, '天气', null, 'd04caaedcc0f4a7bb29f527cc918618f', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('a34e1c81-dd29-40c4-b56c-a7928071d0e7', 'b72e83e1-27e6-44b4-96cc-657efdc69717', null, '吃什么', null, 'd04caaedcc0f4a7bb29f527cc918618f', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('a3e79d1c-ee6e-429a-8031-ada64500bb26', '970e81b1-dd46-4eb3-a377-218cfc33323f', 'ca8ddc77-c145-46d1-a57c-d5f5fe52acd2', '天气', '打雷', 'c089e69c9892498da56237329d2ab5f6', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('a405f139-6d03-4255-a500-2f64633eee76', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', null, '地址', null, 'c089e69c9892498da56237329d2ab5f6', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('a4d06349-b73c-49e1-ab95-bfe332b8c285', '7f997763-e438-4212-8430-9cdd2bcc7fd6', null, '地址', null, '0e75147b7d3d488485646b271653f3e4', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('a565c004-f2e8-44ac-bde0-47cfa2768017', '4439e069-ff3d-4c1a-8be7-90b5f2132984', 'a10b770f-5330-4413-a3f4-692a9b2a9083', '吃什么', '都行', '7414462812f4423686639b42fcb56396', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('a5f487b2-4c01-4eae-afbf-357bb2c439f1', '3b26a007-aa30-4860-9b29-088af793d531', null, '年龄', null, '1010177543954128afcef296b2cb6336', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('a6990d96-8e13-4e31-87fb-b5796e3a2da5', 'bdfec078-7bb2-4c2a-9941-ebd106d08aaf', null, '天气', null, 'a4dc2c092ce44b32bab662f8302c19d2', '9b88dfd273764f54a223434415d53c0a', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('a73a9eed-8371-42c8-b435-d51a11ca33d0', 'a69677ef-e383-4d4a-ae16-8805792cc338', null, '天气', null, '8357937d22574fdfae1b8758ce698718', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('a7bbaab0-a211-4899-9f7f-7e537da9d5da', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('a9c13943-99f0-4cf7-b77a-7d7545120e36', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', null, '天气', null, '7414462812f4423686639b42fcb56396', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('aa04e572-4e82-4904-89da-e596bbad955f', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '09cde27c56e34a5e98f1cffecb19394d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('aa9a40fb-17f7-4e17-a14a-2f4f9e116450', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('ab380c92-9999-4a47-9a40-c6d44a0f6581', 'd2ca8c8c-5b05-40bf-81e9-d576275da8cf', null, '吃什么', null, 'ca3a59f57a234408aef47b86d1124163', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('ac836dd7-0c64-4d68-94d5-b380cf01eff3', 'd99a15f2-0492-4554-95d3-5579a1f81760', null, '体重', null, 'ed051c2e099741489f54a58ee69a17cf', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('adbae9c4-cd65-4a38-bb14-98d80cf01dee', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', '4df619ce-3cb0-40d4-83bd-83229a2ea863', '测试天气', 'C', '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('ae03ae7b-2a76-4bbe-a887-129a8633cbd5', '7983599c-ca87-4363-8863-175a684a511a', null, '多选', null, 'bd7a64445b344253888690f5e246b458', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('ae9ab419-6fa5-4612-8e97-4bc913879658', 'cf6a693e-95b9-4125-9d05-bd8307750183', null, '天气', null, '5b7834cb032847c48a425e2855b3e1c6', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('aefb23e7-9df7-4650-ac01-01a814e1d5cf', '189409ec-3107-479b-ab4b-51c6c98a7879', null, '多选', null, 'f980dbccfb284ba5b0fd02a698d4e821', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('afc1aa84-cada-4c41-b8f4-1ae633270370', 'c03be955-3532-4f78-acb6-50690604035f', null, '多选', null, '30d35f56ff5d474c96a785f908898e49', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('b086c85a-ac70-4438-9e51-3b5206879837', '8e9ebd61-645f-4872-bd29-55ce21e10d61', null, '天气', null, '4691d19717194e6381c9c8c98179fc1e', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('b26b6e3c-c2a4-48a9-abc8-6d7e6174eb52', '938b5448-1584-4400-9f29-1173515f5608', null, '天气', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('b29f7c71-6140-4460-aa3b-522e6f900198', '879efb1e-46a6-4801-9557-ee746a24cc31', null, '年龄', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('b3098ccf-f3f9-4971-81ea-1b9c1557af27', '1c4280dd-9a49-4e70-8e6c-138e6964099e', null, '备注', null, '4691d19717194e6381c9c8c98179fc1e', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('b4749f65-40c8-4dcc-83a4-429d477afc20', '8e9ebd61-645f-4872-bd29-55ce21e10d61', null, '天气', null, '4691d19717194e6381c9c8c98179fc1e', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('b5221fab-08c5-4ab6-a9d1-6793e90ba27f', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', null, '年龄', null, 'd04caaedcc0f4a7bb29f527cc918618f', '6c0f3e926f06446781f9dc013faf75c7', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('b553bb9c-b496-4c58-b6e1-5a839a0d44e7', 'c085b17e-6bd1-48e0-9cf1-4b15aef3cc4a', null, '天气', null, '12fe8b43404948ebb5f9fe1822020cc0', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('b5d8aff2-f36b-4744-ae7f-e48dabdef93b', 'a69677ef-e383-4d4a-ae16-8805792cc338', '252cebb7-bfea-4f4d-9af7-9146034a13ff', '天气', '晴朗', '8357937d22574fdfae1b8758ce698718', '4dea9acd67954ea6a0753e339b03ba7d', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('b6d3749d-61a1-45ed-84e3-26a811eed3a6', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', null, '天气', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('b7b74e76-83ab-4957-9a23-e5b2e75e88ff', '7f997763-e438-4212-8430-9cdd2bcc7fd6', null, '地址', null, '0e75147b7d3d488485646b271653f3e4', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('b8253e71-178a-4c0c-9a31-1c339338c243', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', null, '天气', null, 'ca3a59f57a234408aef47b86d1124163', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('b8630163-edcc-4708-914c-de5fb9764038', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', '6392984e-4137-4642-9aab-31dcb343a6bf', '天气', '多云', 'd0c2d9f3d5644de7ab32e400bb501565', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('b9aa947b-9f94-448d-98e2-432e3068569d', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', null, '吃什么', null, '14223a92132c4853988d48b44dff99a8', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('b9d85f27-1792-4219-9556-89f0ccf9f64b', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', '29d794f1-368c-4c71-a6c0-64219130297e', '天气', '晴朗', 'f980dbccfb284ba5b0fd02a698d4e821', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('b9e6a29c-2326-4ce5-9839-c28e3bc78218', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', null, '天气', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('baa52e2a-564f-43a3-a089-072934eb7c59', '52293643-1206-4cc1-828f-f4dffb775a85', null, '天气', null, '8eda3e286b604c6cb9cfe65086e595c3', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('bc578082-c119-4315-b68d-3f7368a42084', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '7bfc995a6c204df4b6142db2b24e943d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('bce6f10d-2fdf-4d96-861a-20a052a27ee3', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', null, '天气', null, '7363fad3490d4ae18487c06ad9244fcd', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('bd4499e6-fb45-49a0-af54-effcd99e1230', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', null, '天气', null, 'd04caaedcc0f4a7bb29f527cc918618f', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('bd9103c6-6ef3-4f74-a611-5fe4c98e044b', 'efa34ff2-fbf6-4ccf-8c0e-261382d2bc7f', null, '吃什么', null, '53077aceb36e4c5bbcec164b3fe9a45a', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('be9c386e-83c9-4d73-b134-ff8893dd43d7', 'cf6a693e-95b9-4125-9d05-bd8307750183', null, '天气', null, '5b7834cb032847c48a425e2855b3e1c6', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('bfb9aeff-96bf-439e-9e20-c57cb1233b9e', '90371bdc-e533-466e-8630-1c272612da18', null, '天气', null, '8253262e5d564b1cbc34517e194aaef5', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('c02acff4-7309-497b-ad2c-61a8b8b8f751', '97a8a053-4095-4550-813a-07bd29ea700a', null, '吃什么', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('c070841c-131e-417a-9b5c-a594a807b0a2', '8e9ebd61-645f-4872-bd29-55ce21e10d61', null, '天气', null, '4691d19717194e6381c9c8c98179fc1e', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('c12e946c-9776-4671-9bde-e39511610460', '92b72949-66bc-4ad7-b1f5-03dd1344a087', null, '年龄', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('c1a9282d-d3dd-466f-8624-3f27596cc5e8', '938b5448-1584-4400-9f29-1173515f5608', 'ef114704-971f-4a2e-8810-2daa995e4f39', '天气', '晴朗', 'b6b1b896136f47a6b5e2dd3a3275f4e5', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('c27eea7f-902c-4cc8-8c70-e370f1779cd3', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', null, '天气', null, '7363fad3490d4ae18487c06ad9244fcd', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('c30b5d8f-d3c2-4ae5-9469-7c7716b5190e', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', null, '天气', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('c62b3576-c3fa-4c72-9cdf-4dd84656c8b3', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', '15315c9b-0176-4506-8f04-7748d05ce287', '天气', '晴朗', '9fdb8f22caac4d989f80e0d9fd7a7942', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('c687baf3-856b-4a26-ae02-7e493385d154', '970e81b1-dd46-4eb3-a377-218cfc33323f', null, '天气', null, 'c089e69c9892498da56237329d2ab5f6', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('c6e58a58-53f8-4ac8-940e-0391fceef34c', '61c1d3fd-3e43-4334-b1ce-2817cc195a13', null, '天气', null, 'd04caaedcc0f4a7bb29f527cc918618f', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('c709f6db-3127-4b5c-973e-9f7e47f905c8', 'd2ca8c8c-5b05-40bf-81e9-d576275da8cf', null, '吃什么', null, 'ca3a59f57a234408aef47b86d1124163', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('c7d60f51-02d6-40ee-9d3a-2e2e371591c5', '879efb1e-46a6-4801-9557-ee746a24cc31', null, '年龄', null, 'b6b1b896136f47a6b5e2dd3a3275f4e5', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('c827a5ba-281d-4857-8d33-9cf612229e8f', '62a9f60d-8cbd-4015-9e5c-8927014226c4', null, '地址', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('c8d9c07e-e054-452e-8327-a20ad0499291', 'a69677ef-e383-4d4a-ae16-8805792cc338', '252cebb7-bfea-4f4d-9af7-9146034a13ff', '天气', '晴朗', '8357937d22574fdfae1b8758ce698718', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('ca9a8763-7df3-4b2c-8697-395047d3c13f', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', null, '天气', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('cb517481-dd65-4c04-a700-25bc3ba462e3', '1a2f78e6-0edc-40dd-bda4-4c5ab4e24852', null, '备注', null, 'd0c2d9f3d5644de7ab32e400bb501565', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('cbde3830-a2dd-4fe1-a977-55a8211d8cca', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', '81772ea8-f5e1-4290-9954-59097344cc60', '天气', '选项二', 'd3974e87aa6445a1bb6f014a3a52d56e', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('cd46f793-a31b-482d-91eb-8afbae11881a', '0e68b138-5324-482c-a4b8-1fb26527e378', null, '多行文本', null, 'bd7a64445b344253888690f5e246b458', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('ce1ae6fd-bc83-43de-ae93-dce055ac1e7a', '7f997763-e438-4212-8430-9cdd2bcc7fd6', null, '地址', null, '0e75147b7d3d488485646b271653f3e4', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('cf515199-1942-4e02-b66d-08194a112bbd', 'c989ebd3-7752-4124-9107-30024c793d3e', null, '身高', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '3fa644f4c8a04b2b8a2d014e2607dd0f', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('d014828d-171e-4296-87e5-74ba30db1491', 'a0b72eee-6b80-4189-874c-f3dbe9cb76c3', 'f794723f-9618-4b90-96a7-ea9d2a54edf5', '服务好吗', '好', '522837a85423435aa8b12ce9bb415d90', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('d2ed759f-ce42-446b-98d2-0ab053d7b398', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '8549cb4b4c04415fa0d9ab6598e42c5c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('d4bdb916-e53c-44be-920a-b63b4146fdd6', '01923737-c520-4c99-b192-45af379ea72c', null, '吃什么', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('d4f0ce60-6fd0-4b25-ab6e-0ace93e38b1b', 'fced936a-675e-4abb-8150-09540bbf5943', null, '吃什么', null, '12fe8b43404948ebb5f9fe1822020cc0', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('d562a9d4-86fa-4445-8657-bb069ea697b1', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('d5ef8057-db1f-45b3-b0f8-88c3b5d7012b', 'c989ebd3-7752-4124-9107-30024c793d3e', null, '身高', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('d6071c98-89c2-4797-88a0-4c07e5a85826', 'dffa1a84-1131-4092-9a21-4e5bb6530189', null, '吃什么', null, 'ed051c2e099741489f54a58ee69a17cf', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('d74ce41c-3b7b-4ae5-8039-bed5b5fd6878', '1508db10-ac12-42a2-966e-6d5e6ad9bfd8', null, '吃什么', null, '14223a92132c4853988d48b44dff99a8', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('d77c06fc-3696-4e1a-8280-5d0c0905ed02', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', null, '天气', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('d7d77b23-cfc9-47d1-ae28-4dd18ef2750a', '9706debe-56ef-4707-a5f6-f20be51aecce', '71229397-8082-4df7-9c43-3d015481abfd,fab98dfc-4833-4184-b494-ea96d14bbb29', '年龄', '33,44', '9b7a976df24a4fdd877cb9c37d95b1bf', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('d82070eb-765d-4473-a47a-0bdcae28bbf3', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '3fdb747fffaf496e93d37d7810c68cb2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('d8bf11fc-1ec2-413c-8523-a12a799d9852', '67f67190-6bd8-40f5-a8f8-341960c00406', null, '单选', null, '3a00e49ed46f42f3a2af1836ed9103d9', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('d9341c45-272d-44b4-a115-a2f9b39438e3', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', '9421e5d3-7086-4137-a915-9d519309b692', '地址', '广州', '5b7834cb032847c48a425e2855b3e1c6', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('d984c80f-9a1f-48b1-80ce-d18b6c875c7c', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('d9e4037b-1bd9-4346-81c2-24487f0668ef', '218af481-6e53-4269-be9c-792c866fa187', 'b311d916-2abf-4217-8991-d83012292bd9', '天气', '打雷', '2e9fab2aa6184ac39dc5774944e76d9c', '6c0f3e926f06446781f9dc013faf75c7', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('da0a57f7-6c40-4fea-baea-13c737ec11b7', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '5ac8e6855b534c1e939e09de6f6d720f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('da101b74-cf83-449c-a6ae-5ab15b4d6675', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', null, '地址', null, '5b7834cb032847c48a425e2855b3e1c6', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('da4058fe-5f3c-4521-8030-76b6e5f7fb22', '01923737-c520-4c99-b192-45af379ea72c', null, '吃什么', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('daab324a-07b8-47f0-a8cd-b7dc77b8bc4b', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', null, '天气', null, 'd0c2d9f3d5644de7ab32e400bb501565', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('db71f00a-3116-44d6-aad5-e543ae0ea79b', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', null, '二二二二热', null, 'e92bb815bc3b4bae927f0570d9307f44', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('dbabcd22-daaa-4fc2-88ff-a5a1730e3290', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', null, '天气', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('dc895491-6ef8-4d77-83b8-8ce204b8bc43', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', null, '天气', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('dd67bf05-4c64-4583-b86a-3a204b86a287', '7941c9b0-ba03-4a44-ae15-1a6238a2c354', 'b6868a62-8bfc-408b-8964-6a8f2d81b21b', '二二二二热', '选项一', 'e92bb815bc3b4bae927f0570d9307f44', '4dea9acd67954ea6a0753e339b03ba7d', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('dd6d4c4a-1afc-44bc-b1f1-ab5671ba9aac', '6cc5286d-9b5a-4106-b7cb-1eb78cc0cfee', null, '天气', null, '7363fad3490d4ae18487c06ad9244fcd', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('de307855-9d29-4bfc-95c7-642748e59af7', 'bb97f324-b26c-441f-95be-8aec3f9fcfca', null, '年龄', null, '8eda3e286b604c6cb9cfe65086e595c3', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('de8eb7de-ee27-4715-8ae0-13f531ec4676', '5a941d04-f9d0-4b03-b6a8-f8106b997fa0', null, '天气', null, '9b7a976df24a4fdd877cb9c37d95b1bf', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('de9a3d6c-7e88-4c1c-9f5f-139c0719abd8', 'c03be955-3532-4f78-acb6-50690604035f', null, '多选', null, '30d35f56ff5d474c96a785f908898e49', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('def37570-14f9-4669-8134-ebd9deac26ee', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '96f123b8305448259ec9d1d1a4c04228', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('df71c86a-53ca-495c-ba69-ceb98de81301', 'c202c472-9ecb-4af0-a1e1-5418482cf6a2', null, '天气', null, 'f980dbccfb284ba5b0fd02a698d4e821', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('dfb17604-7f9f-4da2-b474-4331db81dea7', '0e68b138-5324-482c-a4b8-1fb26527e378', '', '多行文本', null, 'bd7a64445b344253888690f5e246b458', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('e2325281-e2ed-4d18-9348-4b81588aa2aa', '21ef6195-900b-4ddc-9a27-101a3f9d48aa', null, '吃什么', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('e2777bcd-cd0c-4d9a-ae6f-88748a4a2fbc', '970e81b1-dd46-4eb3-a377-218cfc33323f', null, '天气', null, 'c089e69c9892498da56237329d2ab5f6', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('e2cd4ce2-a434-4472-8a9f-9c68bed18493', 'b8643dc2-bbfe-46b9-bce9-0f545c89b1ad', null, '天气', null, '0e75147b7d3d488485646b271653f3e4', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('e3080151-6af9-4aa4-a7f2-ffd39e769f4c', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', null, '天气', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('e41f2784-b6d7-4b8e-ae6b-af6f709c6aa0', '1a8bf981-1310-4a29-9cc5-bdaf69b6387d', null, '年龄', null, '53077aceb36e4c5bbcec164b3fe9a45a', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('e5cf7243-4dd8-47d8-8420-746c25fd0fd5', '7ef33265-e95f-4a14-a048-258c42096bd8', null, '多行文本', null, '30d35f56ff5d474c96a785f908898e49', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('e6030b3c-7305-45af-bb95-e33885772854', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', null, '地址', null, 'c089e69c9892498da56237329d2ab5f6', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('e6fe9969-f479-4e3f-be72-352e52729384', '1c4280dd-9a49-4e70-8e6c-138e6964099e', '6c99e75f-2e79-4226-bbcd-ffe15a93c255', '备注', '备注一下', '4691d19717194e6381c9c8c98179fc1e', '6c0f3e926f06446781f9dc013faf75c7', '3', '1');
INSERT INTO `box_topic_recipient` VALUES ('e742e65d-dd82-462e-b91b-56973bd4ced5', 'c03be955-3532-4f78-acb6-50690604035f', '', '多选', null, '30d35f56ff5d474c96a785f908898e49', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('e743fe82-22b0-4990-93e7-2111b2a5a31a', '92b72949-66bc-4ad7-b1f5-03dd1344a087', null, '年龄', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('e7e6e4ad-a05e-4c5d-91f3-e7b48d02357c', '7ef33265-e95f-4a14-a048-258c42096bd8', null, '多行文本', null, '30d35f56ff5d474c96a785f908898e49', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('e9399e64-ed20-4128-8115-6831e31e2a98', '1bebfd26-d923-4e81-b441-8fd4c82e14c6', null, '地址', null, 'c089e69c9892498da56237329d2ab5f6', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('e9977fd7-2f6a-418e-afe6-203d4557c473', '90371bdc-e533-466e-8630-1c272612da18', null, '天气', null, '8253262e5d564b1cbc34517e194aaef5', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('e9c15d97-f2a5-439b-b4a2-e4d66ddc6f53', '92b72949-66bc-4ad7-b1f5-03dd1344a087', null, '年龄', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '4dea9acd67954ea6a0753e339b03ba7d', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('eb341427-f614-4edc-a0ab-971cfae661f1', '970e81b1-dd46-4eb3-a377-218cfc33323f', null, '天气', null, 'c089e69c9892498da56237329d2ab5f6', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('eb551a59-b626-4aed-ace6-d4ac6dc4876f', 'a078cfdc-3802-4897-a1f8-9c8a10c5ff5c', null, '天气', null, '9fdb8f22caac4d989f80e0d9fd7a7942', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('ec1f9fbf-40c8-4282-a7df-0c048bb72743', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '1f20b622fa6f459eac5ec26f3d5d8e31', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('ecd86f84-1230-4768-975b-fb1697eb7173', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', null, '天气', null, 'ca3a59f57a234408aef47b86d1124163', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('ed31442b-affb-4167-a01c-9579470a30c3', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', 'cfbaf14a-721e-48e3-b29e-9b9d0cf59798', '天气', '晴朗', '8dd7f6c8aa414b5db2beac000fd1cec8', '4dea9acd67954ea6a0753e339b03ba7d', '1', '1');
INSERT INTO `box_topic_recipient` VALUES ('ed50ea60-6e0e-4df5-9caa-5d9bb6c30bf3', '9097de93-5dcf-4938-8bdb-2407234d8dcd', 'a183759c-4428-4aba-a0c5-aded79a337f0,65368e58-089e-4087-9d19-03fe7a00c01b', '年龄', '选项二,选项三', '0e75147b7d3d488485646b271653f3e4', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('ee0df104-3416-4ee2-90ed-85a8b496dcd2', '8e92226c-fc3e-4d25-9a5e-acabc79f4cc3', null, '天气', null, 'ca3a59f57a234408aef47b86d1124163', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('ee89191a-e781-4997-ad8c-97e70f0f30c6', '7f997763-e438-4212-8430-9cdd2bcc7fd6', null, '地址', null, '0e75147b7d3d488485646b271653f3e4', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('eea932e4-c3df-45fe-a949-67fb5be49291', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('ef981c17-31be-424d-93bb-2114ecc8d6ad', 'b72e83e1-27e6-44b4-96cc-657efdc69717', null, '吃什么', null, 'd04caaedcc0f4a7bb29f527cc918618f', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('f082d475-16ec-42de-8db9-3ffa837df2d5', 'ce8f1c86-9e09-48f8-8e3f-b731740d9abf', null, '天气', null, '7414462812f4423686639b42fcb56396', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f085374b-6cc8-47ea-af88-7f4d0b3cfb5d', 'efa34ff2-fbf6-4ccf-8c0e-261382d2bc7f', null, '吃什么', null, '53077aceb36e4c5bbcec164b3fe9a45a', '6c0f3e926f06446781f9dc013faf75c7', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('f178eb9e-5ce7-4432-b35e-11a57a5ae5b0', 'd3fa18b4-bee0-4d62-9fcf-b235cac56b07', null, '天气', null, '1010177543954128afcef296b2cb6336', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f20445f3-46f7-4627-b635-cf5eabf74b02', '51347224-b5c6-4711-ad71-1b55e6e47456', null, '天气', null, '14223a92132c4853988d48b44dff99a8', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f23753c5-957f-4748-b9e3-e4545e7f16b1', '970e81b1-dd46-4eb3-a377-218cfc33323f', null, '天气', null, 'c089e69c9892498da56237329d2ab5f6', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f31245ef-1dab-4208-b161-88f2e73dffa2', '1c4280dd-9a49-4e70-8e6c-138e6964099e', null, '备注', null, '4691d19717194e6381c9c8c98179fc1e', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('f420cbf7-9499-4c74-95a8-613164d3fe70', '9d9fee30-0b3e-4cfb-9e32-30fdebdc98a0', null, '天气', null, '30d35f56ff5d474c96a785f908898e49', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f48a1339-50ae-46af-b407-85b71f16ba9b', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', null, '天气', null, 'ed051c2e099741489f54a58ee69a17cf', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f4f252c4-b1dd-449c-bead-64ba593aac20', '189409ec-3107-479b-ab4b-51c6c98a7879', '9c3748c7-2c52-414f-ae98-7e49ca12295f', '多选', '选项四', 'f980dbccfb284ba5b0fd02a698d4e821', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('f508a495-7568-44ae-a6fb-e9270bd4b18e', '4e6868db-4f58-4d97-bfc3-9a634f5be742', null, '年龄', null, '12fe8b43404948ebb5f9fe1822020cc0', '8a6fea61aee249848261dd684b7f8460', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('f5e93871-5c1b-4163-b45c-8cd209cde056', 'd8d4f42e-7185-45a9-9e94-5403ac61a18c', null, '天气', null, 'd0c2d9f3d5644de7ab32e400bb501565', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f5e9f094-34e8-4150-80ef-65a72818b81b', 'dffa1a84-1131-4092-9a21-4e5bb6530189', null, '吃什么', null, 'ed051c2e099741489f54a58ee69a17cf', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('f60a5a47-7e9b-4e96-a16e-bd35501d3110', '4439e069-ff3d-4c1a-8be7-90b5f2132984', null, '吃什么', null, '7414462812f4423686639b42fcb56396', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('f653d1a5-66a1-4a3a-aba9-c41365d341f1', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', '9a84879cfeab4578a04b0747f189d4aa', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f65fd28e-1f88-4398-9ebc-c9b3cdb2cdbb', '4e6f7f01-eb27-4013-82f3-375c8f50b03d', null, '天气', null, 'bd7a64445b344253888690f5e246b458', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f834fda4-33ef-464e-876d-48a0945e0792', 'd8573e98-77d7-4e3b-aad5-41d66b33fe8f', null, '天气', null, 'd739ff6b114a4229bc5d0b237e41a0a0', '3fa644f4c8a04b2b8a2d014e2607dd0f', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f88b0b08-2851-4e7b-addb-93b4665a6778', '218af481-6e53-4269-be9c-792c866fa187', null, '天气', null, '2e9fab2aa6184ac39dc5774944e76d9c', '3231550759a74c7e87a5ba9b78fc6b0c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('f9576b16-bef0-4481-a50e-d0af80039243', 'ad653bc1-9710-40c1-ae7c-dc9b61bb2e72', null, '地址', null, '5b7834cb032847c48a425e2855b3e1c6', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('f9ee81f6-2d42-4b78-8b0c-8aca2c8b46e9', 'd8df43ec-0694-47c6-b0e6-d8fb882f16cb', null, '吃什么', null, '8eda3e286b604c6cb9cfe65086e595c3', '8a6fea61aee249848261dd684b7f8460', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('fa3da435-170d-40b8-802e-bc122e3b9abe', 'c130f9b3-fa90-4d9a-b0dc-be84a5934818', null, '单选', null, '4409579659a540a8a49629bd6c6e43fe', 'a44844809c844c14a986063cb2ad586c', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('fa6a4d0b-ca67-40ad-a735-540a8bcd1ca0', '2f217012-d6f7-4911-8183-cf5c8c61ef0d', null, '天气', null, 'd3974e87aa6445a1bb6f014a3a52d56e', '4dea9acd67954ea6a0753e339b03ba7d', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('fa71a2b9-42cb-4656-a3ee-62a4faab479e', '1bd100cd-d4d4-4882-9616-ae195301c0dc', null, '吃什么', null, '1010177543954128afcef296b2cb6336', '3231550759a74c7e87a5ba9b78fc6b0c', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('fa92d1f5-b82f-47d6-9215-6c08effcd121', '4439e069-ff3d-4c1a-8be7-90b5f2132984', null, '吃什么', null, '7414462812f4423686639b42fcb56396', '4dea9acd67954ea6a0753e339b03ba7d', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('fbdbf475-9c87-445b-94d0-3fca41f78172', 'a712b9e8-3f3c-437b-b12e-cca8c82366dc', null, '天气', null, 'ed051c2e099741489f54a58ee69a17cf', '082c86c807c14aac8b7ff5aedea5cef2', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('fc33a491-0f38-45a4-9110-6e59eb8cbc03', '0e68b138-5324-482c-a4b8-1fb26527e378', null, '多行文本', null, 'bd7a64445b344253888690f5e246b458', '082c86c807c14aac8b7ff5aedea5cef2', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('fc7e815d-ce19-4ffc-babd-7ad27910a5d6', '7983599c-ca87-4363-8863-175a684a511a', '', '多选', null, 'bd7a64445b344253888690f5e246b458', '6c0f3e926f06446781f9dc013faf75c7', '2', '1');
INSERT INTO `box_topic_recipient` VALUES ('fd8bc376-353e-407e-9d18-c2726f495898', '7697dcea-4e09-4dbf-b5a1-dbace008f13b', null, '年龄', null, 'd04caaedcc0f4a7bb29f527cc918618f', '3231550759a74c7e87a5ba9b78fc6b0c', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('fde7beb1-707c-4a7f-8496-9245b49e971a', '51347224-b5c6-4711-ad71-1b55e6e47456', null, '天气', null, '14223a92132c4853988d48b44dff99a8', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('fdf8ef91-7fc0-4d02-98db-48d461ae490c', 'd99a15f2-0492-4554-95d3-5579a1f81760', null, '体重', null, 'ed051c2e099741489f54a58ee69a17cf', '082c86c807c14aac8b7ff5aedea5cef2', '2', '0');
INSERT INTO `box_topic_recipient` VALUES ('fe7ec41b-5912-49bb-be93-aa68028d9aef', 'd476d65a-1fb3-471b-98f5-4006e7c5eabf', null, '天气', null, '8dd7f6c8aa414b5db2beac000fd1cec8', '8a6fea61aee249848261dd684b7f8460', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('fe937d55-cdd3-4163-aa42-d960922c740e', '52293643-1206-4cc1-828f-f4dffb775a85', null, '天气', null, '8eda3e286b604c6cb9cfe65086e595c3', '6c0f3e926f06446781f9dc013faf75c7', '1', '0');
INSERT INTO `box_topic_recipient` VALUES ('fecfc7b8-ac1f-43e6-b6f2-48d91295b673', '4439e069-ff3d-4c1a-8be7-90b5f2132984', null, '吃什么', null, '7414462812f4423686639b42fcb56396', '3fa644f4c8a04b2b8a2d014e2607dd0f', '3', '0');
INSERT INTO `box_topic_recipient` VALUES ('ff7f64a8-b9e4-4035-9727-3ac93d81b1b0', '57f76c79-5a75-42b5-a7ff-db5b6655e9b7', null, '测试天气', null, '5ad9edd1f2cb4f0ab6f3df885e0a79ed', '3fdb747fffaf496e93d37d7810c68cb2', '1', '0');

-- ----------------------------
-- Table structure for `box_topic_version`
-- ----------------------------
DROP TABLE IF EXISTS `box_topic_version`;
CREATE TABLE `box_topic_version` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of box_topic_version
-- ----------------------------
INSERT INTO `box_topic_version` VALUES ('369e7e92-57a1-469e-b775-0d314a6f37b4', '测试1的领导用户具体发送问卷', '5', '2', '8a6fea61aee249848261dd684b7f8460');
INSERT INTO `box_topic_version` VALUES ('42e99a92-96ba-4cf0-8f32-d8b02efdd483', '测试1用户具体发送问卷', '5', '2', '4dea9acd67954ea6a0753e339b03ba7d');
INSERT INTO `box_topic_version` VALUES ('4ad4b99b-eb92-4b45-955b-626d57683ece', '张三用户具体发送问卷', '5', '2', 'f977c3d92de04d8f84270a20614e3b18');
INSERT INTO `box_topic_version` VALUES ('b9913f61-9899-471f-94a5-8a1237c9d513', '李四用户具体发送问卷', '5', '2', 'f779eff45ccb4f61a26ea7d7d89fa2a0');
INSERT INTO `box_topic_version` VALUES ('e0449afe-84cb-4686-8528-2383667ad4c0', 'admin用户具体发送问卷', '5', '2', '6c0f3e926f06446781f9dc013faf75c7');

-- ----------------------------
-- Table structure for `custom_filed`
-- ----------------------------
DROP TABLE IF EXISTS `custom_filed`;
CREATE TABLE `custom_filed` (
  `id` varchar(255) NOT NULL,
  `key` varchar(255) DEFAULT NULL COMMENT '健',
  `label` varchar(255) DEFAULT NULL COMMENT '字段名，如姓名',
  `value` varchar(255) DEFAULT NULL COMMENT '值',
  `default_value` varchar(255) DEFAULT NULL COMMENT '默认值',
  `length` int(11) DEFAULT NULL COMMENT '长度',
  `is_required` int(10) unsigned zerofill DEFAULT '0000000000' COMMENT '是否必填（0 非必填 1必填）',
  `type` varchar(255) DEFAULT NULL COMMENT '字段类型',
  `sort` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '排序号',
  `row` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '第几行',
  `col` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '第几列',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `tid` varchar(255) DEFAULT '' COMMENT '自定义表单关联ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_filed
-- ----------------------------
INSERT INTO `custom_filed` VALUES ('00a63ad3-13c2-4050-8cb7-5ebde37a928a', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'ee0502b6-3706-412e-b2d7-0830350d56d3');
INSERT INTO `custom_filed` VALUES ('00ffeb4f-eb3e-437a-9218-7450f9ca7714', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, '761b4e0d-c9a8-430d-8d29-f115e0aa1c1b');
INSERT INTO `custom_filed` VALUES ('0174586e-ab53-4825-a9bc-c531946d12b8', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('028520d2-0585-49f2-9e08-9d3591bed798', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('02be90a1-1c8a-4946-ab02-fa408923b057', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', 'c60e31ec-0e1e-434e-969f-4e182a4ac225');
INSERT INTO `custom_filed` VALUES ('0348ec3f-d335-4e6c-92df-f0957b345257', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, null, '6dbd56c4-d72e-4b47-a645-99fae4fca425');
INSERT INTO `custom_filed` VALUES ('03757f34-904b-4c5d-9718-a2e292397aab', '3bf42dc35ecf3', '性别', null, '', '0', '0000000000', '1', '00000000005', null, null, null, '1d06f7f1-7998-4a3c-899c-fdf454d9ab68');
INSERT INTO `custom_filed` VALUES ('03da2ea5-d4e7-40bf-a154-aac5d8c9c3eb', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '48ae9b90-ce40-467c-8d08-bef32b78185e');
INSERT INTO `custom_filed` VALUES ('0405aa58-5bff-4791-b70c-2091bdb0a92b', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('06b302ab-2b79-4895-affa-b9ef5e403573', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '2465014f-2658-4aa2-80cd-e4ba36e3ef8b');
INSERT INTO `custom_filed` VALUES ('098eaa76-05c5-40c5-bee5-195ab7d89e8c', 'username', '姓名', null, '', '0', '0000000000', '1', '00000000003', null, null, null, '1d06f7f1-7998-4a3c-899c-fdf454d9ab68');
INSERT INTO `custom_filed` VALUES ('09f9434e-339e-4a71-ac02-d2e220c1142b', 'accountId', '账号', null, null, '0', '0000000001', '1', '00000000001', null, null, '1', 'ca5968a5-784f-4d4c-8773-edc35017a886');
INSERT INTO `custom_filed` VALUES ('0a2b717a-2077-423c-96fc-5b7b5818fc84', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '54afd6c6-bc96-4e73-b426-babc3e9e06d7');
INSERT INTO `custom_filed` VALUES ('0ab5d9f7-54f6-4c4b-b7f0-5163b5b8b6c0', 'ac19acb2708a7', '微信', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'cd5559b4-1646-440f-a1a8-6feef9a5f892');
INSERT INTO `custom_filed` VALUES ('0ac93cdf-297d-4b6a-a3c0-09175b74826d', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'a1458707-79a1-4368-aa22-f1f2581926a2');
INSERT INTO `custom_filed` VALUES ('0cd3cda2-9399-48f6-8aab-228d6dae0855', 'ba6f26933f7e', '体重', null, '', '0', '0000000001', '1', '00000000004', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('0d3f26d8-b1e1-448d-a3aa-be9efce50ecc', 'accountId', '账号', null, '', '0', '0000000000', '1', '00000000001', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('0ed09e6a-4197-4320-9eda-cc8aef598d88', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('0fb6f154-7fb6-4c8b-8b5b-c8a628cc8025', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, null, '3d603ce1-9c5c-4e57-a129-6ee063d93fb2');
INSERT INTO `custom_filed` VALUES ('10897bdd-dc60-4799-8d0e-78e901223e98', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, '54afd6c6-bc96-4e73-b426-babc3e9e06d7');
INSERT INTO `custom_filed` VALUES ('11411d89-9795-4731-aae6-be3984576204', '3bf42dc35ecf3', '性别', null, '', '0', '0000000000', '1', '00000000005', null, null, null, 'ccd92700-9174-4652-89b3-914fa4b271e8');
INSERT INTO `custom_filed` VALUES ('14ae58f1-bb8e-4638-9d42-40859fb7e1a3', 'ac19acb2708a7', '微信', null, '', '0', '0000000000', '1', '00000000003', null, null, null, '54afd6c6-bc96-4e73-b426-babc3e9e06d7');
INSERT INTO `custom_filed` VALUES ('15155502-8667-4fb3-94e4-4f83bf131fcf', 'bcd9e3897be54', '成绩', null, '99', '0', '0000000000', '1', '00000000002', null, null, null, '3ed58e2b-4892-43d8-afe2-ebdb067004be');
INSERT INTO `custom_filed` VALUES ('15b35537-9814-401c-9b83-073c3bb9e6ad', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, 'dd58f34f-8171-494a-b0ae-f653b1891d67');
INSERT INTO `custom_filed` VALUES ('16911cfd-de84-4fa3-a3bd-45292c2f0247', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('171d4aef-540f-4881-bf33-468690abab9d', '3bf42dc35ecf3', '性别', null, '', '0', '0000000000', '1', '00000000005', null, null, null, 'e3585e91-4f3e-46d8-9147-fe51c318aade');
INSERT INTO `custom_filed` VALUES ('18fdbbf1-a3f0-4b2a-9a19-7394de23bc3a', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('1951d8ff-0253-4d93-86d9-e5082e40d969', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '33f37c9e-4010-49b9-ad78-d6e9b9710f78');
INSERT INTO `custom_filed` VALUES ('1967fe44-5622-4020-8deb-03ca032e5395', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '33f37c9e-4010-49b9-ad78-d6e9b9710f78');
INSERT INTO `custom_filed` VALUES ('1975d851-f4e5-4a4d-8f99-cf3fb7740736', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('19a55de9-2de1-4818-ab5c-6a46138ac032', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, '48ae9b90-ce40-467c-8d08-bef32b78185e');
INSERT INTO `custom_filed` VALUES ('19c0a856-d295-42b8-9e5d-9de3126abd76', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', 'd0a0f298-0e6b-4fea-821f-c4358bb01c64');
INSERT INTO `custom_filed` VALUES ('1a3af883-a0e7-4d9e-a82c-3e3beacd54f8', '44b1788d5b277', '000', null, '', '0', '0000000000', '1', '00000000006', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('1ad9c8e5-f5d5-43c0-9cd9-4fa4761bb3d2', 'ba6f26933f7e', '体重', null, '', '0', '0000000001', '1', '00000000004', null, null, null, '247b6328-41cc-47b7-bfa2-f6112b61fdf2');
INSERT INTO `custom_filed` VALUES ('1d46b2e0-6659-4a7c-ac4b-e5d06eb05911', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '6dcbcd4f-f10c-4821-a5f8-977ced74d4f6');
INSERT INTO `custom_filed` VALUES ('20e54183-d970-4e66-9c4c-8160cc7b328d', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '54afd6c6-bc96-4e73-b426-babc3e9e06d7');
INSERT INTO `custom_filed` VALUES ('22235b30-0789-455c-bbb6-9bfd56fc4143', 'f3ce48efe7c7c', '成绩', null, '99', '0', '0000000000', '1', '00000000002', null, null, null, 'ee0502b6-3706-412e-b2d7-0830350d56d3');
INSERT INTO `custom_filed` VALUES ('223ce59a-ab42-4fd2-a11b-d4044b235437', 'd1ae93f9964ba', 'QQ', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'e3585e91-4f3e-46d8-9147-fe51c318aade');
INSERT INTO `custom_filed` VALUES ('24ab5aa2-9701-4182-b79e-31cf00685022', '6927afbe71493', '地址', null, '', '0', '0000000000', '3', '00000000005', null, null, null, '2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57');
INSERT INTO `custom_filed` VALUES ('24f19dea-6859-49dd-9da5-835aa5ad50e1', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '11387200-a85a-43ee-a261-b6f59afb2070');
INSERT INTO `custom_filed` VALUES ('2526c328-003d-47e5-a2e1-c95ed99b5ab1', 'd9a1cd0e3a57', '地址', null, '', '0', '0000000000', '3', '00000000004', null, null, null, 'd687c806-b9bf-4552-b0cc-0d1309b43246');
INSERT INTO `custom_filed` VALUES ('261c15be-fe15-4fb0-b993-11f32c15e155', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', 'fbc0a998-3765-495d-be0f-6cb8565fcebe');
INSERT INTO `custom_filed` VALUES ('273c8a44-cfa7-4879-bc5f-801e39e72e9c', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('283feb2f-0580-4238-b15a-ae6ea0b0844a', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', 'c60e31ec-0e1e-434e-969f-4e182a4ac225');
INSERT INTO `custom_filed` VALUES ('28ecc7d4-2ac5-43bc-8f66-dd3aa50d2510', 'accountId', '账号', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '1d06f7f1-7998-4a3c-899c-fdf454d9ab68');
INSERT INTO `custom_filed` VALUES ('2c10011a-799e-4103-a0cd-ad841dee38ce', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '0785cae2-c0b9-4218-84de-7cfc055e4ba2');
INSERT INTO `custom_filed` VALUES ('2d716390-529a-43b6-9550-3f054588bb93', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000001', '3', '00000000002', null, null, null, '247b6328-41cc-47b7-bfa2-f6112b61fdf2');
INSERT INTO `custom_filed` VALUES ('2d7e96b8-47b3-44da-a7cf-50195ac3d86c', 'accountId', '身份证号', null, '4452424325325666', null, '0000000000', '1', '00000000001', null, null, null, '3ed58e2b-4892-43d8-afe2-ebdb067004be');
INSERT INTO `custom_filed` VALUES ('2d96853a-bca7-48d3-8491-d14fb7446cf2', '19b6b94dab1ca', '手机号', null, '', '0', '0000000001', '1', '00000000005', null, null, null, '7cc0659b-ee60-451a-b7c4-3fb4794bfd22');
INSERT INTO `custom_filed` VALUES ('2f1f6c55-d5dc-49f6-982d-c48d34a21cda', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('30e087fa-eb99-45e5-b769-4a3daafdd557', 'accountId', '账号', null, null, '0', '0000000001', '1', '00000000001', null, null, '1', '28e50ed1-5eec-42b7-a95e-cc2733ab11eb');
INSERT INTO `custom_filed` VALUES ('3176c827-c19f-432d-82d2-4edcfd2d1624', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, '761b4e0d-c9a8-430d-8d29-f115e0aa1c1b');
INSERT INTO `custom_filed` VALUES ('321231f3-451f-4118-9b2f-29beda23dcd4', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'a79d3e0f-698b-4589-88a9-d068b05ac13d');
INSERT INTO `custom_filed` VALUES ('33171e43-d04d-4dcc-9e13-b3823451ceb5', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'e7d3f576-fcb3-4453-ae81-31e863e3e607');
INSERT INTO `custom_filed` VALUES ('334f2361-9dd4-44a3-b2f4-9366c303c4fa', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57');
INSERT INTO `custom_filed` VALUES ('34542b1f-151f-44b2-8052-f654d8beccec', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, null, 'c118dfd7-a543-47e5-89cc-7938dcf03873');
INSERT INTO `custom_filed` VALUES ('3866de0c-5866-4545-8d7a-e43ac0d8cbdb', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '598c1aeb-aceb-4b20-af02-98506f929af1');
INSERT INTO `custom_filed` VALUES ('39303f96-d8b7-41fa-bc02-4cdb746175e8', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'f77ae053-06de-4e51-8b96-addc37569945');
INSERT INTO `custom_filed` VALUES ('3a701af7-784e-4e96-9811-9893759d25df', 'bcd9e3897be54', '成绩', null, '99', '0', '0000000000', '1', '00000000002', null, null, null, 'c118dfd7-a543-47e5-89cc-7938dcf03873');
INSERT INTO `custom_filed` VALUES ('3ad76da6-7fc0-45b6-9449-683032ea673d', 'd9a1cd0e3a57', '地址', null, '', '0', '0000000000', '3', '00000000004', null, null, null, 'a0f8f569-d23b-42bf-a76e-d3f5c2ae3327');
INSERT INTO `custom_filed` VALUES ('3bfb5284-85d2-42a0-9240-00c56e1b8ce0', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '5c158361-8f71-4a5a-8013-7a1ff08ef110');
INSERT INTO `custom_filed` VALUES ('3c68f532-4d29-409b-ace9-0fdf99184d04', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '7cc0659b-ee60-451a-b7c4-3fb4794bfd22');
INSERT INTO `custom_filed` VALUES ('3cfb321b-3dda-46e9-acb0-410b3be60104', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'eff3eae6-de3b-4651-ac8d-f10840097e0d');
INSERT INTO `custom_filed` VALUES ('3d39d98c-4aca-49c2-a768-6a565e733406', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, '1', 'f1a5d39e-1db7-4f13-9bc3-23f3a33da601');
INSERT INTO `custom_filed` VALUES ('3d5b5a1f-9cec-4dc4-89b3-74a337a5404a', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'f77ae053-06de-4e51-8b96-addc37569945');
INSERT INTO `custom_filed` VALUES ('3f145f0c-c47c-4388-b648-5dc3bb4a9d3f', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('40cb374f-790f-401a-b3ec-8a5963416213', 'da3f736844bfd', '体重', null, '', '0', '0000000000', '1', '00000000007', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('41ce043b-9070-4c2c-8e33-943907355ab8', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('434b2b28-380a-4f7d-b688-1d84d6aef3ba', '81651c3d4a505', '三围', null, '', '0', '0000000000', '1', '00000000006', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('43ecc8c6-6fb5-4c22-ad03-e088cb4ac385', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', 'c6a91807-32fd-498b-9d51-b0109f2a6a16');
INSERT INTO `custom_filed` VALUES ('44676ca4-038f-43f1-be86-926a99e3e243', 'ba6f26933f7e', '体重', null, '', '0', '0000000001', '1', '00000000004', null, null, null, '7cc0659b-ee60-451a-b7c4-3fb4794bfd22');
INSERT INTO `custom_filed` VALUES ('4611e585-5903-4220-a060-14c23b89e579', 'wechat', '微信', null, null, '0', '0000000000', '1', '00000000001', null, null, '1', 'f1a5d39e-1db7-4f13-9bc3-23f3a33da601');
INSERT INTO `custom_filed` VALUES ('46fb7412-4ad7-4d3a-ac8f-5b49d20a7837', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('48809161-26c0-4238-bfce-be2f463eea6e', '4a9d47c4b3898', '平均成绩', null, '88', '0', '0000000000', '1', '00000000003', null, null, null, '3ed58e2b-4892-43d8-afe2-ebdb067004be');
INSERT INTO `custom_filed` VALUES ('49373296-ad28-4e2f-b55c-5234a41d7916', '3f413fa94e77', '身高', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '24bd4b9c-bf6f-4232-923c-42340b689c5a');
INSERT INTO `custom_filed` VALUES ('4afe2d7a-fede-4f32-823c-256c2b25d3f0', 'eb9194501d4d2', '备注', null, '', '0', '0000000000', '3', '00000000005', null, null, null, '247b6328-41cc-47b7-bfa2-f6112b61fdf2');
INSERT INTO `custom_filed` VALUES ('52f4f31d-7f63-4aed-b1aa-9a294676b966', 'username', '年龄', null, '22', null, '0000000000', '1', '00000000000', null, null, null, '3ed58e2b-4892-43d8-afe2-ebdb067004be');
INSERT INTO `custom_filed` VALUES ('53490bb8-35de-4baf-8686-1fc20287c894', 'ac19acb2708a7', '微信', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'a79d3e0f-698b-4589-88a9-d068b05ac13d');
INSERT INTO `custom_filed` VALUES ('5366bdfb-67d6-4cf3-b63a-007b43f42021', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000001', '3', '00000000002', null, null, null, '7cc0659b-ee60-451a-b7c4-3fb4794bfd22');
INSERT INTO `custom_filed` VALUES ('540d0c1d-9895-42fd-b9fb-e5e0c7bc3e0a', 'ae864509e96c2', 'QQ', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'eff3eae6-de3b-4651-ac8d-f10840097e0d');
INSERT INTO `custom_filed` VALUES ('57689c11-30bd-4a5d-ad3f-787ba1aeb7f2', 'accountId', '账号', null, '', '0', '0000000000', '1', '00000000004', null, null, null, 'ccd92700-9174-4652-89b3-914fa4b271e8');
INSERT INTO `custom_filed` VALUES ('57b5c578-1ca5-4c60-b1ea-f523ad1082b0', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000000', '1', '00000000006', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('5cb0d167-9b62-46ca-8453-04f62808edfb', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000001', '1', '00000000003', null, null, null, '7cc0659b-ee60-451a-b7c4-3fb4794bfd22');
INSERT INTO `custom_filed` VALUES ('5cf0b847-2859-4dae-9e9f-bb24229f9b47', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('5d36e828-19a0-4ba9-b91e-ef4bd9d318d7', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '247b6328-41cc-47b7-bfa2-f6112b61fdf2');
INSERT INTO `custom_filed` VALUES ('5d55f823-7480-4862-b45e-735d5d8f7583', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, '29a22e63-145b-4cbc-9250-59bc06fca4df');
INSERT INTO `custom_filed` VALUES ('5d5c84be-78fd-4d4a-acc9-fff57f2a3fc5', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'f77ae053-06de-4e51-8b96-addc37569945');
INSERT INTO `custom_filed` VALUES ('5e8b2242-a94c-4ecf-8bd6-9b13e1861542', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'a79d3e0f-698b-4589-88a9-d068b05ac13d');
INSERT INTO `custom_filed` VALUES ('5ec0531c-3a48-4865-8b45-1fdb39f6703d', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('5f0ea1c5-7f80-47ac-ac88-4eed46999e8b', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '0785cae2-c0b9-4218-84de-7cfc055e4ba2');
INSERT INTO `custom_filed` VALUES ('5f1a4b78-96ea-49cd-96dc-d59c8e0046dd', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('61fc6209-1f97-4888-bd4a-d214297df5fe', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '04eae2af-8bbd-4e0b-b4be-c4ae22007312');
INSERT INTO `custom_filed` VALUES ('6376de1b-3632-4920-8491-b6a3287bfdb8', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '76f121c7-ebb9-4d7b-8724-45a785169e35');
INSERT INTO `custom_filed` VALUES ('63d84dbb-04b9-46a7-8808-7269ad85d11d', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('66b296a6-80e6-4c2d-86cb-8d484eefe1a4', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000001', '1', '00000000006', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('68679a43-3e9d-404f-9524-9640ab2479e8', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000005', null, null, null, '29a22e63-145b-4cbc-9250-59bc06fca4df');
INSERT INTO `custom_filed` VALUES ('686ec89e-fe15-489f-936b-b5c74b8b63cd', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('68b601e7-af10-4735-819f-3dc5bf7371d9', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('6a6685e2-1bbe-4286-bb6b-61474460328a', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '48ae9b90-ce40-467c-8d08-bef32b78185e');
INSERT INTO `custom_filed` VALUES ('6a9b352f-209e-46ce-8ec7-ee2f597b7742', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000001', '1', '00000000003', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('6aca43e5-f575-438c-9cf4-fe7db68cd404', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', 'a898c933-126b-4c59-95ec-081380728b24');
INSERT INTO `custom_filed` VALUES ('6d107a86-2332-47c2-8a54-3733e65fab05', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'd687c806-b9bf-4552-b0cc-0d1309b43246');
INSERT INTO `custom_filed` VALUES ('6e6c6829-a0c2-483f-b1a4-118174bde981', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '04eae2af-8bbd-4e0b-b4be-c4ae22007312');
INSERT INTO `custom_filed` VALUES ('6ed53d68-6d4f-46c8-9fe6-e87c03a366df', 'd1ae93f9964ba', 'QQ', null, '', '0', '0000000000', '1', '00000000003', null, null, null, '24bd4b9c-bf6f-4232-923c-42340b689c5a');
INSERT INTO `custom_filed` VALUES ('6f272092-bca1-42d4-a594-a1cdf6223bab', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'ee0502b6-3706-412e-b2d7-0830350d56d3');
INSERT INTO `custom_filed` VALUES ('70ad047c-f2ba-40ac-a88d-e30b29f1d065', '4a9d47c4b3898', '平均成绩', null, '88', '0', '0000000000', '1', '00000000003', null, null, null, 'c118dfd7-a543-47e5-89cc-7938dcf03873');
INSERT INTO `custom_filed` VALUES ('717c38dd-a2c4-48ec-b44a-2bacec17637f', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'eff3eae6-de3b-4651-ac8d-f10840097e0d');
INSERT INTO `custom_filed` VALUES ('718d4569-43d5-48ed-bcff-ff52af89e8de', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'e7d3f576-fcb3-4453-ae81-31e863e3e607');
INSERT INTO `custom_filed` VALUES ('7351f7d9-6eb6-4dc3-9121-6d5d823e3e9c', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('73ff0394-83e8-446d-a38b-72ca8ea692ca', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '3ca441a6-dff9-4e8b-9987-ec832740ab2d');
INSERT INTO `custom_filed` VALUES ('7433dbc8-422b-4248-ac00-18deb3e9f530', 'ba6f26933f7e', '体重', null, '', '0', '0000000001', '1', '00000000007', null, null, null, '37b86536-fe47-495d-a36a-866b4f70ad74');
INSERT INTO `custom_filed` VALUES ('7458b446-a787-4577-9b79-30da033c8187', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('7633bfce-0c85-42a4-a00b-db9de2a2f8c0', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('76dc0bb8-9167-40d3-a038-a52378f9ba30', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'cd5559b4-1646-440f-a1a8-6feef9a5f892');
INSERT INTO `custom_filed` VALUES ('771ffbbb-d77f-4bac-b4f4-5619a18e3a23', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'd687c806-b9bf-4552-b0cc-0d1309b43246');
INSERT INTO `custom_filed` VALUES ('77331639-cdda-48f7-bdf3-9092584cb32b', 'a129c1c43d2b1', '电话', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57');
INSERT INTO `custom_filed` VALUES ('779a8995-fb6d-471f-8906-34ab971dd472', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '2dc07a5e-0522-4b45-8e82-478289dabe5c');
INSERT INTO `custom_filed` VALUES ('787952a3-dab1-46a7-938b-6c41732a608e', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '2dc07a5e-0522-4b45-8e82-478289dabe5c');
INSERT INTO `custom_filed` VALUES ('79912661-1534-483d-97e1-6904b7d80f31', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '29a22e63-145b-4cbc-9250-59bc06fca4df');
INSERT INTO `custom_filed` VALUES ('79b4b2f3-2d56-4eea-9c9c-027cbdcabb46', 'd9a1cd0e3a57', '地址', null, '', '0', '0000000000', '3', '00000000004', null, null, null, '29a22e63-145b-4cbc-9250-59bc06fca4df');
INSERT INTO `custom_filed` VALUES ('79e3b373-4c97-4b52-99bf-75c8578a6d2a', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('7b18573c-19df-4e89-af8a-1df0002c056e', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', 'a898c933-126b-4c59-95ec-081380728b24');
INSERT INTO `custom_filed` VALUES ('7b1dc5b8-b37f-443e-8f2c-ef6a6935656d', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, 'd7cc3e71-d42d-4071-8c46-d62a545cad12');
INSERT INTO `custom_filed` VALUES ('7c486d7e-129e-4c9a-9de2-856f31f0dc96', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, 'd7cc3e71-d42d-4071-8c46-d62a545cad12');
INSERT INTO `custom_filed` VALUES ('7c97849d-1c06-41b9-bf7a-f175b16110e5', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '6dcbcd4f-f10c-4821-a5f8-977ced74d4f6');
INSERT INTO `custom_filed` VALUES ('7e18d2fe-f654-4ab9-be06-f4d34b011c46', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '761b4e0d-c9a8-430d-8d29-f115e0aa1c1b');
INSERT INTO `custom_filed` VALUES ('7e760772-34a7-4309-913a-9b16a7ba0d3c', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'a79d3e0f-698b-4589-88a9-d068b05ac13d');
INSERT INTO `custom_filed` VALUES ('7eee4a1b-c662-47d6-8480-3db975667cf3', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', 'd0a0f298-0e6b-4fea-821f-c4358bb01c64');
INSERT INTO `custom_filed` VALUES ('7fecec86-02c7-433a-8248-55f8e9b10a5d', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('80d80ab2-3215-4396-bc1f-72ce5199679b', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, '1', 'f1a5d39e-1db7-4f13-9bc3-23f3a33da601');
INSERT INTO `custom_filed` VALUES ('8154de24-77a2-4b23-80fb-a87a0f487e1b', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000001', '1', '00000000006', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('832bcac9-6bc2-4caa-bbf0-193cce0f1936', '44b1788d5b277', '身高', null, '', '0', '0000000000', '1', '00000000006', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('836ec406-4a9e-494a-a03d-91bb53b5363f', 'ac19acb2708a7', '微信', null, '', '0', '0000000000', '1', '00000000003', null, null, null, '2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57');
INSERT INTO `custom_filed` VALUES ('83910fc1-145e-4fbc-bb57-db226e724cde', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', 'fbc0a998-3765-495d-be0f-6cb8565fcebe');
INSERT INTO `custom_filed` VALUES ('854ef5c2-6a81-4c65-934a-2c9818b9f78d', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('86e7b9e2-18cc-442e-af06-7e3c107670d5', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, null, '6dbd56c4-d72e-4b47-a645-99fae4fca425');
INSERT INTO `custom_filed` VALUES ('8a6ff5ef-0123-48bb-961e-b03267dbeb99', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '3ca441a6-dff9-4e8b-9987-ec832740ab2d');
INSERT INTO `custom_filed` VALUES ('8a8bbdfe-d000-4411-9f88-7a5a1ec88b82', '19b6b94dab1ca', '手机号', null, '', '0', '0000000001', '1', '00000000005', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('8c145738-dfea-40bf-ac67-5baa88e04a6d', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, '761b4e0d-c9a8-430d-8d29-f115e0aa1c1b');
INSERT INTO `custom_filed` VALUES ('8c4db4ae-2d52-4cd4-9cc0-abd016a84a02', '44b1788d5b277', '身高', null, '', '0', '0000000000', '1', '00000000006', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('8c78ac5f-826f-40f5-9ac7-95ae3fde4a82', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, 'ccd92700-9174-4652-89b3-914fa4b271e8');
INSERT INTO `custom_filed` VALUES ('8d2e14e5-01ca-45cc-8fa4-78d0d27919fa', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000005', null, null, null, '1d06f7f1-7998-4a3c-899c-fdf454d9ab68');
INSERT INTO `custom_filed` VALUES ('8e0a0b1a-4318-4f50-b603-55b51036268f', 'cf7fe4ec2b09f', '小名', null, '', '0', '0000000000', '1', '00000000006', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('8f36870c-4dff-48c0-8bc5-65151e4532fc', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000005', null, null, null, 'e3585e91-4f3e-46d8-9147-fe51c318aade');
INSERT INTO `custom_filed` VALUES ('8f6e63c1-4a7f-4bc0-a72f-7c76450509e6', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', 'df90b93d-4343-4f67-977d-8aa75b838306');
INSERT INTO `custom_filed` VALUES ('90b695cb-1d4d-4504-bb0d-b9af784110b1', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000001', '3', '00000000002', null, null, null, 'd7cc3e71-d42d-4071-8c46-d62a545cad12');
INSERT INTO `custom_filed` VALUES ('92c9f6e0-9bf5-46d5-9a9a-618ac579ccb1', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '33f37c9e-4010-49b9-ad78-d6e9b9710f78');
INSERT INTO `custom_filed` VALUES ('930d931f-0436-492a-82b7-ef89d80c0593', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '8e97da16-2fcd-4e6c-b1a4-4ed0f7403fa5');
INSERT INTO `custom_filed` VALUES ('9399e5cb-aaa5-4cd8-85bb-8204ee9abba1', 'a129c1c43d2b1', '电话', null, '', '0', '0000000000', '1', '00000000004', null, null, null, 'a1458707-79a1-4368-aa22-f1f2581926a2');
INSERT INTO `custom_filed` VALUES ('940cec70-dfac-415b-9655-0d07444b9895', 'd9a1cd0e3a57', '地址', null, '', '0', '0000000000', '3', '00000000004', null, null, null, '33f37c9e-4010-49b9-ad78-d6e9b9710f78');
INSERT INTO `custom_filed` VALUES ('95c721bc-69a2-4c5d-af47-b74bc1af1e28', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, 'dd58f34f-8171-494a-b0ae-f653b1891d67');
INSERT INTO `custom_filed` VALUES ('99016b6f-4b59-4b73-93ff-01a026ad0565', 'abbe67ffa6cf6', '地址', null, '', '0', '0000000000', '3', '00000000005', null, null, null, '1d06f7f1-7998-4a3c-899c-fdf454d9ab68');
INSERT INTO `custom_filed` VALUES ('99a1aae6-cf7e-4ae4-a099-c95b145ea6c4', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '598c1aeb-aceb-4b20-af02-98506f929af1');
INSERT INTO `custom_filed` VALUES ('99b54637-ad82-4f98-87df-44f60eb8566f', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'cd5559b4-1646-440f-a1a8-6feef9a5f892');
INSERT INTO `custom_filed` VALUES ('9c082fd4-8312-4723-b248-ebbf488429a9', 'ac19acb2708a7', '微信', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'f77ae053-06de-4e51-8b96-addc37569945');
INSERT INTO `custom_filed` VALUES ('9c1fd0c4-1358-4adc-aac0-47598e1000ed', 'username', '姓名', null, null, '0', '0000000001', '1', '00000000000', null, null, '1', '28e50ed1-5eec-42b7-a95e-cc2733ab11eb');
INSERT INTO `custom_filed` VALUES ('9de0bc59-8d7f-4dda-9427-9974da5cd0ff', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, '761b4e0d-c9a8-430d-8d29-f115e0aa1c1b');
INSERT INTO `custom_filed` VALUES ('9e7c7a87-65a9-48f1-a2a1-2d3e920e07ac', 'abbe67ffa6cf6', '地址', null, '', '0', '0000000000', '3', '00000000005', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('9e9dab0c-179d-492b-9999-84d98632306c', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('9ea56d40-e64a-44da-81d9-2e143239ca09', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '110ba1e9-cf36-4209-a357-23691c4f8d98');
INSERT INTO `custom_filed` VALUES ('9fe81f1b-3b77-4322-a345-f5babceadc0a', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000001', '1', '00000000003', null, null, null, '247b6328-41cc-47b7-bfa2-f6112b61fdf2');
INSERT INTO `custom_filed` VALUES ('a19f5dd3-e658-4ccc-a3bf-3105c75e3d45', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('a30b2901-0dd4-4e53-9049-09f0450302ca', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'a1458707-79a1-4368-aa22-f1f2581926a2');
INSERT INTO `custom_filed` VALUES ('a3ed027f-bdf2-47d5-9af5-598be3ec8975', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '11387200-a85a-43ee-a261-b6f59afb2070');
INSERT INTO `custom_filed` VALUES ('a48be399-d72e-46b4-bd62-c9b2757d4cfc', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('a58dc243-e074-4c61-a328-1befc27c8666', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, 'bff8c685-f678-4e96-bf38-05196ae0b4b5');
INSERT INTO `custom_filed` VALUES ('a6546fa4-9ef4-4f26-a662-959d9ecd448a', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, 'dd58f34f-8171-494a-b0ae-f653b1891d67');
INSERT INTO `custom_filed` VALUES ('a7321de8-bbfb-4e24-916f-3de1dd8f5d87', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000001', '3', '00000000002', null, null, null, 'bcb53e6a-fe12-4db9-8867-d6366e65c36a');
INSERT INTO `custom_filed` VALUES ('a8d7f0d2-3400-4df3-a570-7798b22b83a1', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('aa48873b-7897-4db5-9de2-cd4178ab35ea', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '7fcc15ce-d191-448f-8f4e-bdcf7f22cc63');
INSERT INTO `custom_filed` VALUES ('aa4a721e-601e-4999-b47a-18753268ccbf', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000001', '3', '00000000005', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('aa5e16ce-7bf3-473c-8161-bc3b8b0f4d90', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, 'dd58f34f-8171-494a-b0ae-f653b1891d67');
INSERT INTO `custom_filed` VALUES ('aaf1cdc2-c19d-40f8-a771-ef60313e5362', 'ba6f26933f7e', '体重', null, '', '0', '0000000001', '1', '00000000007', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('abfa54a0-ca1e-4bcc-87f5-0ba3819e20a1', 'username', '姓名', null, '', '0', '0000000000', '1', '00000000000', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('ac65dd32-c572-4f3c-8748-713f73f08c57', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '76f121c7-ebb9-4d7b-8724-45a785169e35');
INSERT INTO `custom_filed` VALUES ('ad50401b-fa10-4fb1-9c1f-8fab6393e6ff', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('ad768b34-340e-4d18-94e6-c4aadad95a6b', '3bf42dc35ecf3', '性别', null, '', '0', '0000000000', '1', '00000000005', null, null, null, 'a0f8f569-d23b-42bf-a76e-d3f5c2ae3327');
INSERT INTO `custom_filed` VALUES ('b1b3ba0c-8cff-4690-8ee2-970c46b60d8f', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '761b4e0d-c9a8-430d-8d29-f115e0aa1c1b');
INSERT INTO `custom_filed` VALUES ('b2874d3e-e298-4353-8236-d08bfdba173b', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', 'df90b93d-4343-4f67-977d-8aa75b838306');
INSERT INTO `custom_filed` VALUES ('b4252ceb-08df-42f3-863a-a3dfdbac2030', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '90197cee-a34e-4476-bf64-6af530f61a44');
INSERT INTO `custom_filed` VALUES ('b6066bda-d774-4b31-aba7-0071b78a0183', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('b7326ff9-7eea-4b2a-945b-28f2519af893', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '1d06f7f1-7998-4a3c-899c-fdf454d9ab68');
INSERT INTO `custom_filed` VALUES ('b85233f2-6572-4bf3-90a7-74b8c7455d9d', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '2465014f-2658-4aa2-80cd-e4ba36e3ef8b');
INSERT INTO `custom_filed` VALUES ('b862aa2d-6709-4889-9e61-a443731803f1', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '247b6328-41cc-47b7-bfa2-f6112b61fdf2');
INSERT INTO `custom_filed` VALUES ('b97c563b-46e3-4e32-bbc4-8001e8059a41', 'username', '用户名', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'ccd92700-9174-4652-89b3-914fa4b271e8');
INSERT INTO `custom_filed` VALUES ('b9a80474-2dbd-4571-a6be-bbd0116a3294', 'username', '姓名', '12', '', '0', '0000000000', '1', '00000000000', null, null, null, '7cc0659b-ee60-451a-b7c4-3fb4794bfd22');
INSERT INTO `custom_filed` VALUES ('ba4a075b-3441-4811-9f69-150f6e4ff915', 'bcd9e3897be54', '成绩', null, '99', '0', '0000000000', '1', '00000000002', null, null, null, '6dbd56c4-d72e-4b47-a645-99fae4fca425');
INSERT INTO `custom_filed` VALUES ('badd221e-fd82-42a6-86c6-4e0589045a4f', 'f4dec5d3ccca5', '身高', null, '', '0', '0000000001', '1', '00000000003', null, null, null, 'd7cc3e71-d42d-4071-8c46-d62a545cad12');
INSERT INTO `custom_filed` VALUES ('bc6af9d1-feca-4476-8143-7197e1dc5622', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '04ea1dc8-321d-4f1c-b139-7fb2b3ee211e');
INSERT INTO `custom_filed` VALUES ('c563083e-7fa8-4d75-af1f-cab9bb92e735', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('c78b758c-773f-4748-abc7-1112e0d21541', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '90197cee-a34e-4476-bf64-6af530f61a44');
INSERT INTO `custom_filed` VALUES ('c7b1e523-fd54-46bf-aad4-23248841720f', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('c90f10a2-097f-44c1-a0c3-75abf9eb48de', 'username', '姓名', null, null, '0', '0000000001', '1', '00000000000', null, null, '1', 'ca5968a5-784f-4d4c-8773-edc35017a886');
INSERT INTO `custom_filed` VALUES ('cc3b02dc-ea42-4497-8635-b772203d3d26', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '24bd4b9c-bf6f-4232-923c-42340b689c5a');
INSERT INTO `custom_filed` VALUES ('cd30809c-3060-499c-a5a6-289a1c3cbc83', 'fd1e796240fbb', '微信', '12', '', '0', '0000000000', '1', '00000000002', null, null, null, 'dd58f34f-8171-494a-b0ae-f653b1891d67');
INSERT INTO `custom_filed` VALUES ('ce666adc-f283-4d3a-8afe-1144acb26ac0', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57');
INSERT INTO `custom_filed` VALUES ('cfc8154d-6dc9-4c22-8d92-29e73a450fbe', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '110ba1e9-cf36-4209-a357-23691c4f8d98');
INSERT INTO `custom_filed` VALUES ('cfdb551c-777e-44e2-b42e-a3c82af2b2af', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', '5c158361-8f71-4a5a-8013-7a1ff08ef110');
INSERT INTO `custom_filed` VALUES ('d1cac950-b4fc-4b03-9299-dced373c1186', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, '7fcc15ce-d191-448f-8f4e-bdcf7f22cc63');
INSERT INTO `custom_filed` VALUES ('d1ceae71-2f22-4fe2-aebf-f7ad1159347e', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('d272d4f3-c7c3-495f-a019-5df99bd7b4d3', '3bf42dc35ecf3', '性别', '12', '', '0', '0000000000', '1', '00000000003', null, null, null, '3b82849c-3b71-4c5c-a795-2841149e0c17');
INSERT INTO `custom_filed` VALUES ('d75875e6-010d-40e2-b369-f151483c4f6b', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '04ea1dc8-321d-4f1c-b139-7fb2b3ee211e');
INSERT INTO `custom_filed` VALUES ('d97b37cf-a407-4126-8bd6-a01f4a030136', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, 'e3585e91-4f3e-46d8-9147-fe51c318aade');
INSERT INTO `custom_filed` VALUES ('da3901e5-1ff7-42d6-94e9-b4d937f8b295', '3bf42dc35ecf3', '性别', null, '', '0', '0000000000', '1', '00000000003', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('db04b078-effc-45be-ad95-aff7ed080b47', 'wechat', '微信', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'eff3eae6-de3b-4651-ac8d-f10840097e0d');
INSERT INTO `custom_filed` VALUES ('db66227d-eb2a-4972-9200-2b4c458022c8', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000002', null, null, null, '44ee5cc6-21d7-45b9-bd6c-5ee551a1757a');
INSERT INTO `custom_filed` VALUES ('db997a72-cd9a-4b24-bfb2-20d3c29bf184', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'a0f8f569-d23b-42bf-a76e-d3f5c2ae3327');
INSERT INTO `custom_filed` VALUES ('dbb1de85-9463-44cf-a3fb-61272d546b92', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, 'a0f8f569-d23b-42bf-a76e-d3f5c2ae3327');
INSERT INTO `custom_filed` VALUES ('dce4566d-bd07-4106-8e7a-4216943dacd3', 'username', '姓名', null, null, '0', '0000000000', '1', '00000000000', null, null, null, 'a1458707-79a1-4368-aa22-f1f2581926a2');
INSERT INTO `custom_filed` VALUES ('dcfe61ec-8a7d-4e86-9d18-344317bad453', 'fd1e796240fbb', '微信', null, '', '0', '0000000000', '1', '00000000004', null, null, null, '29a22e63-145b-4cbc-9250-59bc06fca4df');
INSERT INTO `custom_filed` VALUES ('e00d5454-4d17-4dd0-8f6e-45eb33610e88', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, '1', '8e97da16-2fcd-4e6c-b1a4-4ed0f7403fa5');
INSERT INTO `custom_filed` VALUES ('e09bd3fa-0c0e-4233-a133-f81944f0a0e1', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, '3513d8d1-457f-4b83-b154-f69605f578bf');
INSERT INTO `custom_filed` VALUES ('e0b00d0a-8f94-4bff-aec1-2084a80c6d3b', '3bf42dc35ecf3', '性别', null, '', '0', '0000000000', '1', '00000000005', null, null, null, '24bd4b9c-bf6f-4232-923c-42340b689c5a');
INSERT INTO `custom_filed` VALUES ('e2b24506-7d2f-4101-94ad-827a5c48390f', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000005', null, null, null, '24bd4b9c-bf6f-4232-923c-42340b689c5a');
INSERT INTO `custom_filed` VALUES ('e2cc8a55-97dd-4ae3-acd8-84980b88fa19', 'ac19acb2708a7', '微信', null, '', '0', '0000000000', '1', '00000000003', null, null, null, 'a1458707-79a1-4368-aa22-f1f2581926a2');
INSERT INTO `custom_filed` VALUES ('e6b531b7-612e-4cc2-bb24-1839c6ce08a0', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000005', null, null, null, 'a0f8f569-d23b-42bf-a76e-d3f5c2ae3327');
INSERT INTO `custom_filed` VALUES ('e6da436d-084d-4c5f-94a2-e21becd49b06', '368d805085db4', '备注', null, '', '0', '0000000000', '3', '00000000004', null, null, null, 'a0f8f569-d23b-42bf-a76e-d3f5c2ae3327');
INSERT INTO `custom_filed` VALUES ('e72fff3d-f422-43ef-a06c-5992c26335cf', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, null, 'c118dfd7-a543-47e5-89cc-7938dcf03873');
INSERT INTO `custom_filed` VALUES ('e73dafc5-8bd7-45f9-9dd6-b4a62eb69eef', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, 'e7d3f576-fcb3-4453-ae81-31e863e3e607');
INSERT INTO `custom_filed` VALUES ('e80af72c-ebfd-4451-b365-1acd66f1f579', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'd687c806-b9bf-4552-b0cc-0d1309b43246');
INSERT INTO `custom_filed` VALUES ('ec3743f0-92b1-4fb2-94e7-a4d38d3af847', 'accountId', '账号', null, null, '0', '0000000000', '1', '00000000001', null, null, null, '29a22e63-145b-4cbc-9250-59bc06fca4df');
INSERT INTO `custom_filed` VALUES ('ec43b945-9777-4743-80d1-78ac50f21ae5', 'accountId', '账号', null, null, null, '0000000000', '1', '00000000001', null, null, '1', 'c6a91807-32fd-498b-9d51-b0109f2a6a16');
INSERT INTO `custom_filed` VALUES ('ed965b2e-a2fb-4a7b-8798-114ebba275c8', 'abbe67ffa6cf6', '地址', '21', '', '0', '0000000000', '3', '00000000005', null, null, null, 'caa00e9b-29f8-4137-83f8-f22d001e17b6');
INSERT INTO `custom_filed` VALUES ('edbb7458-0d79-4565-9334-5e9521eaa777', 'ce34b2ca0bffb', '年龄', null, '', '0', '0000000000', '1', '00000000005', null, null, null, 'ccd92700-9174-4652-89b3-914fa4b271e8');
INSERT INTO `custom_filed` VALUES ('efa43ccf-7523-4d71-8cb5-e1554c38c51f', 'ba6f26933f7e', '体重', null, '', '0', '0000000001', '1', '00000000004', null, null, null, 'd7cc3e71-d42d-4071-8c46-d62a545cad12');
INSERT INTO `custom_filed` VALUES ('f0f593ac-d201-4002-a5f5-daa0b949d223', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, '33f37c9e-4010-49b9-ad78-d6e9b9710f78');
INSERT INTO `custom_filed` VALUES ('f5770d1c-f43d-4f6e-8895-5f868a18187c', 'username', '姓名', null, null, null, '0000000000', '1', '00000000000', null, null, null, '3d603ce1-9c5c-4e57-a129-6ee063d93fb2');
INSERT INTO `custom_filed` VALUES ('f63c1745-e8a3-400c-8e81-54a52b58978f', '7be2befe9ea1d', '地址', null, '', '0', '0000000000', '3', '00000000004', null, null, null, '54afd6c6-bc96-4e73-b426-babc3e9e06d7');
INSERT INTO `custom_filed` VALUES ('f8d2b27e-1165-4791-8520-d99ff88fa985', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, 'cd5559b4-1646-440f-a1a8-6feef9a5f892');
INSERT INTO `custom_filed` VALUES ('fb6b95b1-7b25-4362-892d-62d03a03cb0e', 'accountId', '账号', '12', '', '0', '0000000000', '1', '00000000001', null, null, null, 'dd58f34f-8171-494a-b0ae-f653b1891d67');
INSERT INTO `custom_filed` VALUES ('fc16feb6-f996-4e43-a351-80a72b184308', 'ce34b2ca0bffb', '年龄', '12', '', '0', '0000000000', '1', '00000000004', null, null, null, '2c4af432-ec84-49be-9168-6a59d0dafe69');
INSERT INTO `custom_filed` VALUES ('fd9f0e73-d23d-41cd-98f1-7f59bf71d3e9', '68abada506f47', 'QQ', null, '', '0', '0000000000', '1', '00000000002', null, null, null, '2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57');

-- ----------------------------
-- Table structure for `custom_table`
-- ----------------------------
DROP TABLE IF EXISTS `custom_table`;
CREATE TABLE `custom_table` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '自定义表单名称',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `pid` varchar(64) DEFAULT NULL COMMENT '归属ID（流程或者其它表单关联）',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `userid` varchar(64) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_table
-- ----------------------------
INSERT INTO `custom_table` VALUES ('5e5c7f47-c10f-44a9-9c06-886aa12e3a7d', '填表汇总表单模板', '1', '3', '1', '85df829495494a208d94cd64efe2d953', '3', '2018-01-31 14:08:20');
INSERT INTO `custom_table` VALUES ('8d46a18a-a912-4652-b391-de73ae394f0c', '填表汇总表单模板', '1', '3', '1', 'f779eff45ccb4f61a26ea7d7d89fa2a0', '3', '2018-01-31 13:20:38');
INSERT INTO `custom_table` VALUES ('aff7726d-0a1f-4d5e-b4f5-178d750e1a40', '填表汇总表单模板', '1', '3', '1', '8a6fea61aee249848261dd684b7f8460', '3', '2018-01-20 17:20:05');
INSERT INTO `custom_table` VALUES ('dcd6e110-47fa-479c-9243-3deb4473ac85', '下发数据表单模板', '1', '4', '6', '6c0f3e926f06446781f9dc013faf75c7', '4', '2018-01-16 11:43:24');
INSERT INTO `custom_table` VALUES ('e24558c2-c1b4-4c53-8222-b27d3f4f881e', '填表汇总表单模板', '1', '3', '1', '4dea9acd67954ea6a0753e339b03ba7d', '3', '2018-01-13 18:08:10');
INSERT INTO `custom_table` VALUES ('edf4734f-aec3-4164-b26b-4f3b6fcc5740', '填表汇总表单模板', '1', '3', '33', '6c0f3e926f06446781f9dc013faf75c7', '3', '2018-01-13 16:43:42');

-- ----------------------------
-- Table structure for `custom_tpl`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl`;
CREATE TABLE `custom_tpl` (
  `id` varchar(64) NOT NULL COMMENT 'ID',
  `name` varchar(128) DEFAULT NULL COMMENT '模板名称',
  `template` text COMMENT '内容',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `pid` varchar(64) DEFAULT NULL COMMENT 'custom_table id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl
-- ----------------------------
INSERT INTO `custom_tpl` VALUES ('04ea1dc8-321d-4f1c-b139-7fb2b3ee211e', '填表汇总表单模板', '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'e24558c2-c1b4-4c53-8222-b27d3f4f881e');
INSERT INTO `custom_tpl` VALUES ('04eae2af-8bbd-4e0b-b4be-c4ae22007312', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '6850e6ac-6a80-4d31-bf8f-0436a565db85');
INSERT INTO `custom_tpl` VALUES ('0785cae2-c0b9-4218-84de-7cfc055e4ba2', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'd3bf48e0-db27-4a93-83eb-c047cd4900fa');
INSERT INTO `custom_tpl` VALUES ('110ba1e9-cf36-4209-a357-23691c4f8d98', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '6d56b44b-9972-429b-a697-fc69aa8e9109');
INSERT INTO `custom_tpl` VALUES ('11387200-a85a-43ee-a261-b6f59afb2070', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '7cd320e4-be46-4607-8de9-2682a7916482');
INSERT INTO `custom_tpl` VALUES ('1d06f7f1-7998-4a3c-899c-fdf454d9ab68', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":20}', '20', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('2465014f-2658-4aa2-80cd-e4ba36e3ef8b', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'dc378a95-6eaf-46f0-a9d0-42f710801ce0');
INSERT INTO `custom_tpl` VALUES ('247b6328-41cc-47b7-bfa2-f6112b61fdf2', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":2,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"ba6f26933f7e\",\"label\":\"体重\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"eb9194501d4d2\",\"label\":\"备注\",\"length\":0,\"sort\":5,\"type\":\"3\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":33}', '33', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('24bd4b9c-bf6f-4232-923c-42340b689c5a', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"d1ae93f9964ba\",\"label\":\"QQ\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3f413fa94e77\",\"label\":\"身高\",\"length\":0,\"sort\":4,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":18}', '18', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('28e50ed1-5eec-42b7-a95e-cc2733ab11eb', '填表汇总表单模板', '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '8d46a18a-a912-4652-b391-de73ae394f0c');
INSERT INTO `custom_tpl` VALUES ('29a22e63-145b-4cbc-9250-59bc06fca4df', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"d9a1cd0e3a57\",\"label\":\"地址\",\"length\":0,\"sort\":4,\"type\":\"3\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":5,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":15}', '15', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('2c4af432-ec84-49be-9168-6a59d0dafe69', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":6,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"ba6f26933f7e\",\"label\":\"体重\",\"length\":0,\"sort\":7,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":29}', '29', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('2d663bfa-2f4e-45ac-ac6b-ae8cfec98c57', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ac19acb2708a7\",\"label\":\"微信\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"a129c1c43d2b1\",\"label\":\"电话\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"6927afbe71493\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":9}', '9', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('2dc07a5e-0522-4b45-8e82-478289dabe5c', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '64e876b5-7622-479b-8d40-184c820be6b0');
INSERT INTO `custom_tpl` VALUES ('33f37c9e-4010-49b9-ad78-d6e9b9710f78', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"d9a1cd0e3a57\",\"label\":\"地址\",\"length\":0,\"sort\":4,\"type\":\"3\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":14}', '14', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('3513d8d1-457f-4b83-b154-f69605f578bf', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"key\":\"44b1788d5b277\",\"label\":\"000\",\"length\":0,\"sort\":6,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":23}', '23', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('37b86536-fe47-495d-a36a-866b4f70ad74', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":6,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"ba6f26933f7e\",\"label\":\"体重\",\"length\":0,\"sort\":7,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":28}', '28', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('3b82849c-3b71-4c5c-a795-2841149e0c17', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"44b1788d5b277\",\"label\":\"身高\",\"length\":0,\"sort\":6,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"da3f736844bfd\",\"label\":\"体重\",\"length\":0,\"sort\":7,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":25}', '25', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('3ca441a6-dff9-4e8b-9987-ec832740ab2d', '填表汇总表单模板', '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'aff7726d-0a1f-4d5e-b4f5-178d750e1a40');
INSERT INTO `custom_tpl` VALUES ('3d603ce1-9c5c-4e57-a129-6ee063d93fb2', '下发数据表单模板', '{\"createDate\":1516074204000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"sort\":1,\"type\":\"1\"}],\"id\":\"dcd6e110-47fa-479c-9243-3deb4473ac85\",\"name\":\"下发数据表单模板\",\"pid\":\"4\",\"status\":1,\"type\":4,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":3}', '3', 'dcd6e110-47fa-479c-9243-3deb4473ac85');
INSERT INTO `custom_tpl` VALUES ('3ed58e2b-4892-43d8-afe2-ebdb067004be', '下发数据表单模板', '{\"createDate\":1516074204000,\"customFileds\":[{\"defaultValue\":\"22\",\"key\":\"username\",\"label\":\"年龄\",\"sort\":0,\"type\":\"1\"},{\"defaultValue\":\"4452424325325666\",\"key\":\"accountId\",\"label\":\"身份证号\",\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"99\",\"key\":\"bcd9e3897be54\",\"label\":\"成绩\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"88\",\"key\":\"4a9d47c4b3898\",\"label\":\"平均成绩\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"dcd6e110-47fa-479c-9243-3deb4473ac85\",\"name\":\"下发数据表单模板\",\"pid\":\"4\",\"status\":1,\"type\":4,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":6}', '6', 'dcd6e110-47fa-479c-9243-3deb4473ac85');
INSERT INTO `custom_tpl` VALUES ('44ee5cc6-21d7-45b9-bd6c-5ee551a1757a', '填表汇总表单模板', '{\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\"},{\"defaultValue\":\"\",\"key\":\"cf7fe4ec2b09f\",\"label\":\"小名\",\"length\":0,\"sort\":6,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":21}', '21', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('48ae9b90-ce40-467c-8d08-bef32b78185e', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":5}', '5', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('54afd6c6-bc96-4e73-b426-babc3e9e06d7', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ac19acb2708a7\",\"label\":\"微信\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"7be2befe9ea1d\",\"label\":\"地址\",\"length\":0,\"sort\":4,\"type\":\"3\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":11}', '11', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('598c1aeb-aceb-4b20-af02-98506f929af1', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '4f881237-d055-4ba2-a580-b3026cdcf74b');
INSERT INTO `custom_tpl` VALUES ('5c158361-8f71-4a5a-8013-7a1ff08ef110', '填表汇总表单模板', '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('6dbd56c4-d72e-4b47-a645-99fae4fca425', '下发数据表单模板', '{\"createDate\":1516074204000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"99\",\"key\":\"bcd9e3897be54\",\"label\":\"成绩\",\"length\":0,\"sort\":2,\"type\":\"1\"}],\"id\":\"dcd6e110-47fa-479c-9243-3deb4473ac85\",\"name\":\"下发数据表单模板\",\"pid\":\"4\",\"status\":1,\"type\":4,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":4}', '4', 'dcd6e110-47fa-479c-9243-3deb4473ac85');
INSERT INTO `custom_tpl` VALUES ('6dcbcd4f-f10c-4821-a5f8-977ced74d4f6', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '3fa5bd99-c3ea-48c4-bccd-2412ab6c6467');
INSERT INTO `custom_tpl` VALUES ('761b4e0d-c9a8-430d-8d29-f115e0aa1c1b', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":22}', '22', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('7cc0659b-ee60-451a-b7c4-3fb4794bfd22', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":2,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"ba6f26933f7e\",\"label\":\"体重\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"19b6b94dab1ca\",\"label\":\"手机号\",\"length\":0,\"sort\":5,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":31}', '31', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('7fcc15ce-d191-448f-8f4e-bdcf7f22cc63', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":4}', '4', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('8e97da16-2fcd-4e6c-b1a4-4ed0f7403fa5', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '34c9047b-d07c-441d-86bd-b10308fa77f3');
INSERT INTO `custom_tpl` VALUES ('90197cee-a34e-4476-bf64-6af530f61a44', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'b21d056d-6593-4f43-b2cc-c3e5dd126949');
INSERT INTO `custom_tpl` VALUES ('a0f8f569-d23b-42bf-a76e-d3f5c2ae3327', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"d9a1cd0e3a57\",\"label\":\"地址\",\"length\":0,\"sort\":4,\"type\":\"3\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"368d805085db4\",\"label\":\"备注\",\"length\":0,\"sort\":4,\"type\":\"3\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":5,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":16}', '16', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('a1458707-79a1-4368-aa22-f1f2581926a2', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ac19acb2708a7\",\"label\":\"微信\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"a129c1c43d2b1\",\"label\":\"电话\",\"length\":0,\"sort\":4,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":8}', '8', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('a79d3e0f-698b-4589-88a9-d068b05ac13d', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ac19acb2708a7\",\"label\":\"微信\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":12}', '12', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('a898c933-126b-4c59-95ec-081380728b24', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '7d009d33-63e8-479e-8895-d046dae92b7e');
INSERT INTO `custom_tpl` VALUES ('bcb53e6a-fe12-4db9-8867-d6366e65c36a', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":2,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"ba6f26933f7e\",\"label\":\"体重\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"19b6b94dab1ca\",\"label\":\"手机号\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"81651c3d4a505\",\"label\":\"三围\",\"length\":0,\"sort\":6,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":32}', '32', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('bff8c685-f678-4e96-bf38-05196ae0b4b5', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"44b1788d5b277\",\"label\":\"身高\",\"length\":0,\"sort\":6,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":24}', '24', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('c118dfd7-a543-47e5-89cc-7938dcf03873', '下发数据表单模板', '{\"createDate\":1516074204000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"99\",\"key\":\"bcd9e3897be54\",\"label\":\"成绩\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"88\",\"key\":\"4a9d47c4b3898\",\"label\":\"平均成绩\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"dcd6e110-47fa-479c-9243-3deb4473ac85\",\"name\":\"下发数据表单模板\",\"pid\":\"4\",\"status\":1,\"type\":4,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":5}', '5', 'dcd6e110-47fa-479c-9243-3deb4473ac85');
INSERT INTO `custom_tpl` VALUES ('c60e31ec-0e1e-434e-969f-4e182a4ac225', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '26255450-4d9a-498a-bdfd-28c992b43791');
INSERT INTO `custom_tpl` VALUES ('c6a91807-32fd-498b-9d51-b0109f2a6a16', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'aecce536-984d-46d0-b80c-bdace14650cc');
INSERT INTO `custom_tpl` VALUES ('ca5968a5-784f-4d4c-8773-edc35017a886', '填表汇总表单模板', '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '5e5c7f47-c10f-44a9-9c06-886aa12e3a7d');
INSERT INTO `custom_tpl` VALUES ('caa00e9b-29f8-4137-83f8-f22d001e17b6', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":6,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":27}', '27', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('ccd92700-9174-4652-89b3-914fa4b271e8', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"username\",\"label\":\"用户名\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":5,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":19}', '19', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('cd5559b4-1646-440f-a1a8-6feef9a5f892', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ac19acb2708a7\",\"label\":\"微信\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":7}', '7', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('d0a0f298-0e6b-4fea-821f-c4358bb01c64', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '45ac3810-fcf9-4830-95a7-b7b536414f70');
INSERT INTO `custom_tpl` VALUES ('d687c806-b9bf-4552-b0cc-0d1309b43246', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"d9a1cd0e3a57\",\"label\":\"地址\",\"length\":0,\"sort\":4,\"type\":\"3\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":13}', '13', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('d7cc3e71-d42d-4071-8c46-d62a545cad12', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":2,\"type\":\"3\",\"value\":\"21\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"f4dec5d3ccca5\",\"label\":\"身高\",\"length\":0,\"sort\":3,\"type\":\"1\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"ba6f26933f7e\",\"label\":\"体重\",\"length\":0,\"sort\":4,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":30}', '30', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('dd58f34f-8171-494a-b0ae-f653b1891d67', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":2,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":3,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":0,\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":4,\"type\":\"1\",\"value\":\"12\"},{\"defaultValue\":\"\",\"isRequired\":1,\"key\":\"abbe67ffa6cf6\",\"label\":\"地址\",\"length\":0,\"sort\":5,\"type\":\"3\",\"value\":\"21\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":26}', '26', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('df90b93d-4343-4f67-977d-8aa75b838306', null, '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', '589274a0-93c3-4f23-9f8e-e20942e50c38');
INSERT INTO `custom_tpl` VALUES ('e3585e91-4f3e-46d8-9147-fe51c318aade', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"defaultValue\":\"\",\"key\":\"fd1e796240fbb\",\"label\":\"微信\",\"length\":0,\"sort\":4,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"3bf42dc35ecf3\",\"label\":\"性别\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ce34b2ca0bffb\",\"label\":\"年龄\",\"length\":0,\"sort\":5,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"d1ae93f9964ba\",\"label\":\"QQ\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":17}', '17', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('e7d3f576-fcb3-4453-ae81-31e863e3e607', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":6}', '6', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('ee0502b6-3706-412e-b2d7-0830350d56d3', '下发数据表单模板', '{\"createDate\":1516074204000,\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"99\",\"key\":\"f3ce48efe7c7c\",\"label\":\"成绩\",\"length\":0,\"sort\":2,\"type\":\"1\"}],\"id\":\"dcd6e110-47fa-479c-9243-3deb4473ac85\",\"name\":\"下发数据表单模板\",\"pid\":\"4\",\"status\":1,\"type\":4,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":2}', '2', 'dcd6e110-47fa-479c-9243-3deb4473ac85');
INSERT INTO `custom_tpl` VALUES ('eff3eae6-de3b-4651-ac8d-f10840097e0d', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"key\":\"wechat\",\"label\":\"微信\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ae864509e96c2\",\"label\":\"QQ\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":3}', '3', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('f1a5d39e-1db7-4f13-9bc3-23f3a33da601', '填表汇总表单模板', '{\"createDate\":1515833022000,\"customFileds\":[{\"id\":\"22cb1a9e-5d12-4a0f-a667-2e1800ff8b6a\",\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"status\":1,\"tid\":\"84448774-28c6-4944-bd37-71bc61f6b9d0\",\"type\":\"1\"},{\"id\":\"ccd8aeb0-2876-4f07-b9cc-e9ba2ba4d1c4\",\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"status\":1,\"tid\":\"84448774-28c6-4944-bd37-71bc61f6b9d0\",\"type\":\"1\"},{\"id\":\"ccd8aeb0-2876-4f07-b9cc-e9ba2ba4d1c4\",\"key\":\"wechat\",\"label\":\"微信\",\"length\":0,\"sort\":1,\"status\":1,\"tid\":\"84448774-28c6-4944-bd37-71bc61f6b9d0\",\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"pid\":\"3\",\"status\":1,\"type\":3,\"userid\":\"6c0f3e926f06446781f9dc013faf75c7\",\"version\":2}', '2', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('f77ae053-06de-4e51-8b96-addc37569945', '填表汇总表单模板', '{\"customFileds\":[{\"key\":\"username\",\"label\":\"姓名\",\"length\":0,\"sort\":0,\"type\":\"1\"},{\"key\":\"accountId\",\"label\":\"账号\",\"length\":0,\"sort\":1,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"68abada506f47\",\"label\":\"QQ\",\"length\":0,\"sort\":2,\"type\":\"1\"},{\"defaultValue\":\"\",\"key\":\"ac19acb2708a7\",\"label\":\"微信\",\"length\":0,\"sort\":3,\"type\":\"1\"}],\"id\":\"edf4734f-aec3-4164-b26b-4f3b6fcc5740\",\"name\":\"填表汇总表单模板\",\"type\":3,\"version\":10}', '10', 'edf4734f-aec3-4164-b26b-4f3b6fcc5740');
INSERT INTO `custom_tpl` VALUES ('fbc0a998-3765-495d-be0f-6cb8565fcebe', '下发数据表单模板', '{\"customFileds\":[{\"isRequired\":1,\"key\":\"username\",\"label\":\"姓名\",\"length\":50,\"type\":\"1\",\"sort\":\"0\"},{\"isRequired\":1,\"key\":\"accountId\",\"label\":\"账号\",\"length\":50,\"type\":\"1\",\"sort\":\"1\"}],\"id\":\"3\",\"status\":0,\"version\":1}', '1', 'dcd6e110-47fa-479c-9243-3deb4473ac85');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_10`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_10`;
CREATE TABLE `custom_tpl_grid_summary_10` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `ac19acb2708a7` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_10
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_10` VALUES ('5740f219-cae6-49e6-8114-eaed05b55b66', 'bd856ba574f74a469a1bb579cd6456a8', 'admin', null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_11`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_11`;
CREATE TABLE `custom_tpl_grid_summary_11` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `ac19acb2708a7` varchar(64) DEFAULT NULL,
  `7be2befe9ea1d` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_11
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('06888d59-3b88-4a0b-9b13-5ce7e0278198', 'fbc4fbf22d0041d1a8cd523b73478952', '测试1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('141b119a-c82a-4ad0-aa35-0feb72d054d7', 'fbc4fbf22d0041d1a8cd523b73478952', 'admin', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('3561f5c3-3b03-474c-8e6e-9caea4701a3f', 'fbc4fbf22d0041d1a8cd523b73478952', '阿蛤', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('5b821ac2-3b97-4573-88ee-27274044dc22', 'fa87036a53a54f11ad8993b325946836', '测试1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('737b0a6a-c508-41a0-a1ef-2fee3f168ee4', 'fa87036a53a54f11ad8993b325946836', '测试1的领导', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('746f4e1b-3b4b-46cf-8b03-89fe2db24cab', 'fa87036a53a54f11ad8993b325946836', '阿蛤', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('79e21312-2731-4c47-a9e8-70d091d60232', 'fbc4fbf22d0041d1a8cd523b73478952', '测试1的领导', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_11` VALUES ('c19e672c-cf6b-409c-b321-919c785aada3', 'fa87036a53a54f11ad8993b325946836', 'admin', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_12`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_12`;
CREATE TABLE `custom_tpl_grid_summary_12` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `ac19acb2708a7` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_12
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('38879109-d783-479c-bdca-dda46d7305d6', 'd243f7efe1ee4d81bff4c769aeafc4ca', '宁仁佳', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('588098d4-537c-4083-b5f7-4243d1f3fc68', 'd243f7efe1ee4d81bff4c769aeafc4ca', '会诊领导', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('59b00252-82fc-4134-ad42-b32f2a566ec4', 'd243f7efe1ee4d81bff4c769aeafc4ca', '测试1', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('6e37045e-e300-4455-ba03-b4fd65be92e5', 'd243f7efe1ee4d81bff4c769aeafc4ca', '测试1的领导', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('802beb09-d0ca-44b4-a1ee-5e0cfea799f8', '20b96e72a35b486e87392b50917a0066', '测试1的领导', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('87fa678c-96f1-4587-856c-bfe9e9e5e52a', 'd243f7efe1ee4d81bff4c769aeafc4ca', 'admin', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('9401d730-e378-45bd-b3a2-b5ec6fe7fc16', 'd243f7efe1ee4d81bff4c769aeafc4ca', '测试联络人', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('96b68c4a-0a85-477b-b570-a2256b291329', '20b96e72a35b486e87392b50917a0066', 'admin', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('a355847b-c941-49b5-9b2b-a560422f78ff', 'd243f7efe1ee4d81bff4c769aeafc4ca', '阿蛤', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('d75a3016-6c5a-4af5-9cd1-195338fd16e3', '20b96e72a35b486e87392b50917a0066', '阿蛤', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('dfc2b712-443d-4853-99ca-620127ed2ba5', 'd243f7efe1ee4d81bff4c769aeafc4ca', '会诊医生', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('f15df159-8866-427e-961c-abf40625b625', 'd243f7efe1ee4d81bff4c769aeafc4ca', '邒肯睥', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_12` VALUES ('fd5bf2f8-58a0-4d1e-a90e-6ed6aefe3e00', '20b96e72a35b486e87392b50917a0066', '测试1', null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_13`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_13`;
CREATE TABLE `custom_tpl_grid_summary_13` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `d9a1cd0e3a57` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_13
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_13` VALUES ('3fdad82e-5c99-4380-af5c-c1b509d5bd16', '1b48972089064f23981657062806c4d4', '测试1', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_13` VALUES ('6f73ab42-f675-4b78-b638-dd7f30595ca2', '1b48972089064f23981657062806c4d4', 'admin', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_13` VALUES ('b932f536-b7b3-4c78-967f-a79ff262db02', '1b48972089064f23981657062806c4d4', '阿蛤', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_13` VALUES ('ddfe6e1d-db80-4b85-a50e-3984a910d8e0', '1b48972089064f23981657062806c4d4', '测试1的领导', null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_14`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_14`;
CREATE TABLE `custom_tpl_grid_summary_14` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `d9a1cd0e3a57` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_14
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_14` VALUES ('01b1ef71-2fb5-40f7-92bb-a6c3663860ac', '1ee727cb581a4152a9e629e8ffd9b6cc', '测试1的领导', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_14` VALUES ('56f19c89-0c6e-4bf4-94c3-10cbdbcd4110', '1ee727cb581a4152a9e629e8ffd9b6cc', '阿蛤', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_14` VALUES ('7ef80666-4303-4af0-ac99-c076bd8422c0', '1ee727cb581a4152a9e629e8ffd9b6cc', 'admin', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_14` VALUES ('bf5ceb85-6eb9-493a-b95c-a461156dcb08', '1ee727cb581a4152a9e629e8ffd9b6cc', '测试1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_15`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_15`;
CREATE TABLE `custom_tpl_grid_summary_15` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `d9a1cd0e3a57` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_15
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_15` VALUES ('75d18793-aa6f-4328-990c-f2ba837ade09', 'cf6b2e68884d4c959d3be7453e68364e', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_15` VALUES ('a9e811c5-7908-42b7-8fd0-0b4c2616c9de', 'cf6b2e68884d4c959d3be7453e68364e', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_15` VALUES ('d993c384-4ccf-4cd2-addc-be6188032ac7', 'cf6b2e68884d4c959d3be7453e68364e', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_15` VALUES ('ebf5af53-165f-43f2-9316-44b3ac564b0a', 'cf6b2e68884d4c959d3be7453e68364e', 'admin', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_16`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_16`;
CREATE TABLE `custom_tpl_grid_summary_16` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `d9a1cd0e3a57` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `368d805085db4` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_16
-- ----------------------------

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_17`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_17`;
CREATE TABLE `custom_tpl_grid_summary_17` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `d1ae93f9964ba` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_17
-- ----------------------------

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_18`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_18`;
CREATE TABLE `custom_tpl_grid_summary_18` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `d1ae93f9964ba` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `3f413fa94e77` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_18
-- ----------------------------

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_19`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_19`;
CREATE TABLE `custom_tpl_grid_summary_19` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_19
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_19` VALUES ('213292df-07e5-4edf-a198-1d26a579a87f', 'a68dc6054ce04cdbadb7d02eabf9944b', '阿蛤', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_19` VALUES ('2835d65a-f0f7-451e-87a2-9932f36ea70a', 'a68dc6054ce04cdbadb7d02eabf9944b', '测试1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_19` VALUES ('af100e1f-e155-499c-822e-b5d1653edae2', 'a68dc6054ce04cdbadb7d02eabf9944b', 'admin', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_19` VALUES ('b7f364f5-e685-4a8d-af71-4bd044721ff3', 'a68dc6054ce04cdbadb7d02eabf9944b', '测试1的领导', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_2`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_2`;
CREATE TABLE `custom_tpl_grid_summary_2` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `wechat` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_2
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('00f74d44-1db7-4b31-9eb6-caba06cb246c', '238b6f7974c040c698d585f4900f6333', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('04beb1f9-40f5-4c25-a735-c4fa3ca68439', '1161299d282941b6a83ba2f1edf0dc1e', '邒肯睥', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('0709773c-0e71-4944-bc23-e81deb8703aa', '57e9a93cf7da42d48479f9daa9c433d8', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('127977ef-31bf-4c46-ad6c-a6cffc627c9a', '19264e125b3241ccb2accec0385c7af2', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('1d69cb9d-ccb5-45ee-be8b-0a16fb6403a8', '3ce7dd487568458f944aa4283a0f35f4', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('23ff2ac4-4d3e-4cec-9db3-54c98eca7697', '1161299d282941b6a83ba2f1edf0dc1e', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('2dd0c477-c6c8-4f8e-a33c-04bbb09eecac', 'a5b14d56f8c34c8985b6de8c15a2966d', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('2eec87a2-ecc0-4019-8806-e13adb839f1e', '3ce7dd487568458f944aa4283a0f35f4', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('2f00f500-14e7-4d16-a3f0-2c87b353ca25', '1161299d282941b6a83ba2f1edf0dc1e', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('326d7aed-714f-4d3f-a15d-dacee9567f01', '423faee5b90d42b5a799870509ea9610', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('344165f5-e5fc-45f8-9fbd-2a000a0df7ba', '423faee5b90d42b5a799870509ea9610', '会诊领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('35e42524-95b9-4204-95ae-e2c143b893e7', '50def0e5e811443eb1523d25af81da62', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('3ac9dd3c-6d3a-4cdc-a89d-23492612d3ff', '423faee5b90d42b5a799870509ea9610', '会诊医生', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('44b3f3ec-039e-4c2e-b7be-a45b2313a074', 'a5b14d56f8c34c8985b6de8c15a2966d', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('49e7b6d5-56b8-4e57-9911-efbbc98fc640', '19264e125b3241ccb2accec0385c7af2', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('4da418f7-8220-4066-9128-c70c1bd63294', '423faee5b90d42b5a799870509ea9610', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('57968c93-9dc7-4a78-b1ce-7a327fc1156d', '8e269a3618c04f4491efcfba20be1e2c', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('5c82533b-5ac1-4b76-88b0-1a95ce0ec81c', '1161299d282941b6a83ba2f1edf0dc1e', '会诊医生', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('5ea761ba-a9f3-44e1-be71-2fa67a312cb4', '423faee5b90d42b5a799870509ea9610', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('5eb11330-4bd7-46c8-84fa-d3dfe0a02a07', '1161299d282941b6a83ba2f1edf0dc1e', '会诊领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('6c74a9e7-302d-4ad5-ae2a-b3e5abb03a38', '128799c0ccfa4354ace7dd0448bd654a', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('6ec53a87-85ca-4ef6-b536-221acc9f8e81', '57e9a93cf7da42d48479f9daa9c433d8', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('772611ab-db1b-46cf-9023-60db77cc3ec6', '3ce7dd487568458f944aa4283a0f35f4', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('7828eb1d-03cd-4fea-837a-3f314aeb73fc', '8e269a3618c04f4491efcfba20be1e2c', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('88168958-d13a-408a-906f-2fac718d478e', '128799c0ccfa4354ace7dd0448bd654a', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('8f6f9035-fb5d-4ac3-8218-e781e522d834', 'd0a55bf6d7bf4405a50b61cd156db740', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('906a940f-3f51-4581-9cb2-950d3a9ee0fb', 'f4f03c05947e45b59be544160c087382', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('92d5dd60-f950-4289-b22e-c10237c281e8', '423faee5b90d42b5a799870509ea9610', '邒肯睥', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('96eef64e-261b-4fc5-9fd4-fbd6e6591c28', '50def0e5e811443eb1523d25af81da62', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('9a76ba17-6ee2-4ce8-a85c-67050d38088f', '57e9a93cf7da42d48479f9daa9c433d8', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('9f8749d6-b4f7-4733-a283-2f4dd35a794f', '238b6f7974c040c698d585f4900f6333', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('a46e2473-e643-4cc9-89a8-373a2bd0bf84', 'f4f03c05947e45b59be544160c087382', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('a9b47d14-42ac-4405-92a0-0f2a1618f65b', '423faee5b90d42b5a799870509ea9610', '宁仁佳', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('ab51cfab-0b90-4bfb-9ca8-c1817ae1b85e', '128799c0ccfa4354ace7dd0448bd654a', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('b39cdd72-fcab-4bbf-ab45-cf01119b337d', '423faee5b90d42b5a799870509ea9610', '测试联络人', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('b5d0a0e7-cae6-4df9-b556-c92aac178f15', '8e269a3618c04f4491efcfba20be1e2c', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('cf79eff9-08b9-4a88-9b19-74590678f669', '1161299d282941b6a83ba2f1edf0dc1e', '测试联络人', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('d10abe40-1b3e-455f-8f43-e19ffb5d5cbd', 'f4f03c05947e45b59be544160c087382', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('d4df2972-47b7-402f-9ab4-99561c37480e', '1161299d282941b6a83ba2f1edf0dc1e', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('d62239d8-9289-4bb4-a9cd-e0c18a4971e0', 'a5b14d56f8c34c8985b6de8c15a2966d', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('d6a34ce9-36f4-4122-b388-394ce52430c6', '19264e125b3241ccb2accec0385c7af2', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('d9cdf343-3914-482b-b5c5-95b7ea105ac5', '1161299d282941b6a83ba2f1edf0dc1e', '宁仁佳', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('e1582b31-62aa-4a81-8d1a-21d702963fe0', '238b6f7974c040c698d585f4900f6333', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('effd717b-8a5b-44ab-890e-dd163dbb76d6', 'd0a55bf6d7bf4405a50b61cd156db740', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('f2a50991-e6e2-4c76-942f-a459c495f485', '50def0e5e811443eb1523d25af81da62', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_2` VALUES ('f4aecc98-4cd2-45d9-864b-87066685069e', 'd0a55bf6d7bf4405a50b61cd156db740', 'admin', null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_20`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_20`;
CREATE TABLE `custom_tpl_grid_summary_20` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_20
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('0d4b508c-5e4c-48f5-b294-cb7c04b24352', 'c72c149a3dc74ae0ab29ad189600952f', '阿蛤', '1', '1', '122', '12', '12', '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('0dc38d0c-d098-40d6-8ac3-f4cb1d88d905', '0aadc19f49374982871fb57860e73d15', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('398c9272-6ae0-4336-a22a-88aba3b8a040', 'c72c149a3dc74ae0ab29ad189600952f', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('44e56c9b-2f7a-41f2-8412-c74ebac8d03b', '0aadc19f49374982871fb57860e73d15', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('49102e9f-269d-4753-b0e9-26b0b4a01db7', '60716a5b8b7044a1b8f9ddfa5b2eb366', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('89b13423-c0cd-4e3a-b201-751091b79bf1', '0aadc19f49374982871fb57860e73d15', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('9397157d-7b61-4a64-b6ab-06c0ad97efd7', '60716a5b8b7044a1b8f9ddfa5b2eb366', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('9a4e86d1-3d25-4a8e-9a77-069d8e6945d5', 'c72c149a3dc74ae0ab29ad189600952f', '邒肯睥', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('a135ec62-688a-4cda-90ac-6f3a0ce0a2d7', 'c72c149a3dc74ae0ab29ad189600952f', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('a1685506-df96-4fc0-9530-226d12fd59fa', '60716a5b8b7044a1b8f9ddfa5b2eb366', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('a4a1a685-7530-43ac-a49b-84fde8cf57da', 'c72c149a3dc74ae0ab29ad189600952f', '宁仁佳', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('a8865979-2f76-4bf0-b252-9fc9f037ee34', 'c72c149a3dc74ae0ab29ad189600952f', '会诊领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('c777bbf8-ecb2-45ed-9662-10679293dfd8', 'c72c149a3dc74ae0ab29ad189600952f', '测试联络人', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('d0659ce9-56fc-4ecd-9974-de1d7f2ca427', '60716a5b8b7044a1b8f9ddfa5b2eb366', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('d4da1e89-397d-46e1-a9c5-f81d366510b1', '0aadc19f49374982871fb57860e73d15', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('d699730f-a9b4-452b-96d1-7b62b5f57c74', 'c72c149a3dc74ae0ab29ad189600952f', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('dc8a0995-a9f5-4fd0-a585-8249f58bd760', '8462d7ff9e4349f1a68ba9489548d4e5', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('e79c58d2-fb6c-43a2-9365-eea09b0d1048', 'c72c149a3dc74ae0ab29ad189600952f', '会诊医生', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_20` VALUES ('fa25335a-481f-4869-b3a1-28c687f49929', '0aadc19f49374982871fb57860e73d15', 'admin', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_21`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_21`;
CREATE TABLE `custom_tpl_grid_summary_21` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `cf7fe4ec2b09f` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_21
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_21` VALUES ('694d61cf-730c-46a2-a8e8-9ef97aff0360', 'a92d9a37c6784cf29a11babb1c2ff2d9', '我', 'wo', '1111', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_21` VALUES ('90b708ab-9027-4dec-a093-b3904e3f0cd7', '06ecfdbcb11642cd99d06d4f2ea3aee1', 'admin', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_22`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_22`;
CREATE TABLE `custom_tpl_grid_summary_22` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_22
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('0070a141-39b4-4b00-aa5b-fbeafb70558a', '285be4cdfd6c47cda043abf717913dda', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('0354d14e-3aaf-4d31-90f0-9963c21b22f7', 'ad91fa0172f8426c8070edc26f9ec7ea', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('03e3cf71-acf9-4df2-a690-87a6f96866bb', 'e18b850ac1a2403cb87cfe4c0b028eda', 'ddd', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('06647265-1466-4385-a774-ce4bbd62da22', 'e18b850ac1a2403cb87cfe4c0b028eda', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('09af2231-ed3e-4d91-b8c2-53fb42b34be0', 'e4397c9a686148b7aa577004aebad082', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('0e8de4bb-3ed4-479f-b848-6fd093fbd562', 'ad91fa0172f8426c8070edc26f9ec7ea', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('0f53119e-7e27-4941-8244-feb5c5588019', '285be4cdfd6c47cda043abf717913dda', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('0f76448c-cc15-4c51-8feb-4ad7a5d6bc33', '24439695880c44f78458c1b3dcc83978', '测试联络人', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('1124e3f9-3f24-4a62-914c-105c56607629', '24439695880c44f78458c1b3dcc83978', '黄小明', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('115e1726-32c9-4d2f-9a3e-dcb4e2640eb3', '31c09a9e42634d4a8eb6bd90e721c0a2', 'admin', 'asd ', 'adf', 'asdf', 'sadf', 'asdf', '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('11c7e4dd-79f5-46c2-abfd-aae2027e4bd3', 'ad91fa0172f8426c8070edc26f9ec7ea', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('15320b85-222f-4071-ac7c-dbcaff24da20', 'e4397c9a686148b7aa577004aebad082', '邒肯睥', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('1b436603-c1dd-44ef-bf97-0373772d9ba9', 'e4397c9a686148b7aa577004aebad082', 'uuuu', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('1ed4243d-9714-4ce6-97c6-d02f2a4c60d8', 'e4397c9a686148b7aa577004aebad082', 'rrr', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('21966009-68eb-486f-b3ab-8219463637da', 'e18b850ac1a2403cb87cfe4c0b028eda', 'yyy', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('224942b3-2edc-4790-bd2c-985d6827af60', '24439695880c44f78458c1b3dcc83978', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('24b99df4-1bf1-40ab-980c-58cb807404c8', 'ad91fa0172f8426c8070edc26f9ec7ea', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('29fdbf7a-c6c6-46cc-babe-816311e087a6', '24439695880c44f78458c1b3dcc83978', 'yyy', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('2b6092b3-697e-482c-839f-585f9a932c7d', 'e4397c9a686148b7aa577004aebad082', 'yyy', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('2e14a401-0821-4876-a26d-7121bcc5e5f8', 'e4397c9a686148b7aa577004aebad082', 'hyyyy', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('3149df4d-c885-4b50-8620-885f7c28873f', 'e4397c9a686148b7aa577004aebad082', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('31cde41e-c1d8-4810-96b3-3190030d25a8', '24439695880c44f78458c1b3dcc83978', 'ddd', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('342ece94-d830-4cda-89b6-5c6ee945f1aa', '31c09a9e42634d4a8eb6bd90e721c0a2', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('3cd9093d-d3a8-4c06-92c8-b1382079fd4b', 'e4397c9a686148b7aa577004aebad082', 'hhh', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('3dd6eb9f-c941-44c2-b152-118e48c72a5f', 'e18b850ac1a2403cb87cfe4c0b028eda', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('447b049e-690b-4464-8bec-91f3d06d7089', '24439695880c44f78458c1b3dcc83978', 'hhh', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('480cc7b3-94e6-4b41-90c4-a0da986654c6', 'e4397c9a686148b7aa577004aebad082', 'ddd', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('4f3ffaaf-be03-4049-b967-2799d9333c98', 'e18b850ac1a2403cb87cfe4c0b028eda', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('500aa613-d5e0-4b46-b10e-0b6fedb560db', '24439695880c44f78458c1b3dcc83978', '111', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('5318dc39-d9a3-47c7-bc3a-6b71fefd7a5f', 'e18b850ac1a2403cb87cfe4c0b028eda', '会诊医生', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('593ceb7b-e1a8-413d-ab0a-0ffb36ce6a4b', '31c09a9e42634d4a8eb6bd90e721c0a2', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('5cd236a6-c148-476e-980a-3408afa3c786', '24439695880c44f78458c1b3dcc83978', '宁仁佳', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('5cdd4e84-b1c7-49b3-91a7-7680e8e41ac1', 'e18b850ac1a2403cb87cfe4c0b028eda', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('5ed94a41-159a-4ae6-9efa-cdaf478fae93', 'e18b850ac1a2403cb87cfe4c0b028eda', '黄小明', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('6b1868cb-b1e1-4b45-91bb-7fe029e3ee25', 'e4397c9a686148b7aa577004aebad082', '会诊医生', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('6e98a407-6474-427b-814f-58c9e20b1fe4', '31c09a9e42634d4a8eb6bd90e721c0a2', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('716be036-173b-4d41-99c7-dccec3c4c568', 'e4397c9a686148b7aa577004aebad082', '黄小明', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('765566b2-b793-4680-9924-5e97f66dc001', 'e18b850ac1a2403cb87cfe4c0b028eda', 'hyyyy', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('77068a72-0c71-4a3d-9ae2-ccc2faa94fca', '24439695880c44f78458c1b3dcc83978', 'rrr', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('79d098a4-10a5-4d7b-a4f6-a1f20081d2c0', 'e18b850ac1a2403cb87cfe4c0b028eda', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('7b575039-8324-4bfc-9de1-a40a2207bba5', 'e18b850ac1a2403cb87cfe4c0b028eda', 'xxxx', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('7f72922c-cb56-4885-9468-2c4adbc0b0b1', 'e18b850ac1a2403cb87cfe4c0b028eda', 'rrr', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('82755b04-35b4-4b9a-8cd5-036b904fc3bb', '285be4cdfd6c47cda043abf717913dda', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('88189415-2fcd-4c14-ae55-dba14f3d6d39', 'e4397c9a686148b7aa577004aebad082', '会诊领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('88c5af49-a786-4761-a277-ddc520b5057a', '24439695880c44f78458c1b3dcc83978', 'hyyyy', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('89223ca0-1638-4b45-8930-7bc328670643', '24439695880c44f78458c1b3dcc83978', '邒肯睥', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('89b04b71-8976-4113-a2c8-6144c155a673', 'e18b850ac1a2403cb87cfe4c0b028eda', '测试联络人', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('928ff0a1-cc53-4dd3-a7f0-5dda1bec57d2', 'e18b850ac1a2403cb87cfe4c0b028eda', '111', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('933ed6e4-89ce-4e0d-b902-30ad4db98e64', 'e4397c9a686148b7aa577004aebad082', '测试联络人', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('9a9b5fe4-3b29-4d66-8a0b-125facaad802', '285be4cdfd6c47cda043abf717913dda', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('9d87f8f3-7bd9-426a-9262-e46991ed69f0', '24439695880c44f78458c1b3dcc83978', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('a205c5b0-f69b-4267-9d6c-d2437924368d', '24439695880c44f78458c1b3dcc83978', 'xxxx', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('abceac4a-8256-49bf-a8d3-57b98dd5e3e7', 'e4397c9a686148b7aa577004aebad082', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('aef2aa88-87cc-4c93-bef2-4f42ceebb87e', 'e18b850ac1a2403cb87cfe4c0b028eda', '邒肯睥', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('b2e5a417-4a72-4edd-b274-5b14ce725c63', 'ad91fa0172f8426c8070edc26f9ec7ea', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('ba6a4c42-8908-496c-9860-be5de80509cb', '31c09a9e42634d4a8eb6bd90e721c0a2', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('bc116c80-01e8-4136-ab55-924e884e5e0e', '24439695880c44f78458c1b3dcc83978', 'ddd', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('bdbe152a-ee58-4952-9f25-b6ac8cdefa16', '24439695880c44f78458c1b3dcc83978', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('c62c59e1-5e5a-42bc-8409-177aa293d0fa', 'ad91fa0172f8426c8070edc26f9ec7ea', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('c753a9fb-dddd-4422-9913-501becd63be4', 'e18b850ac1a2403cb87cfe4c0b028eda', 'admin', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('c7a5ab46-7b33-42d3-aae6-57229a113018', 'e4397c9a686148b7aa577004aebad082', '宁仁佳', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('c7a731c8-719c-4626-b10b-3843d76ffa4a', '24439695880c44f78458c1b3dcc83978', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('cbe86c79-24ca-4e1b-8322-374a6b25cf85', 'e18b850ac1a2403cb87cfe4c0b028eda', '会诊领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('cec4c4a3-ad32-4352-ae04-ce5704d28f35', '285be4cdfd6c47cda043abf717913dda', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('cee9065e-4b4e-4ffb-a700-812cb76ece64', '285be4cdfd6c47cda043abf717913dda', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('d4837f53-71da-4268-9fb5-1e1d4d47c182', '24439695880c44f78458c1b3dcc83978', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('d754b77f-d8e9-4c1b-9451-353f013cc505', 'e4397c9a686148b7aa577004aebad082', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('d84cd7b2-7271-4fe8-86f2-fa391f4c4085', 'e18b850ac1a2403cb87cfe4c0b028eda', 'hhh', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('d9f8c541-e7a0-473b-b860-99ae984297c0', '24439695880c44f78458c1b3dcc83978', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('db0f7f1a-77ef-4e08-96c2-9b7cf6cbd556', '24439695880c44f78458c1b3dcc83978', 'uuuu', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('dcf23e6a-d943-4f44-ace2-67f20f8337f9', 'e4397c9a686148b7aa577004aebad082', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('df4578a2-4582-4043-bf27-e2675783c7b2', 'e4397c9a686148b7aa577004aebad082', 'xxxx', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('e707849e-6a20-409f-b6bb-b9348b171c2d', 'e18b850ac1a2403cb87cfe4c0b028eda', 'ddd', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('e9f21bf6-dd1d-495a-83ac-d74a47df66ba', 'e18b850ac1a2403cb87cfe4c0b028eda', '宁仁佳', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('eb3d61ab-24ce-44e7-8d72-316f9066daa1', '31c09a9e42634d4a8eb6bd90e721c0a2', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('f10a4473-95d8-4c90-a807-d0376afdc08b', 'e18b850ac1a2403cb87cfe4c0b028eda', 'uuuu', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('f2cf3a0f-4fa5-40d1-9ef5-f87169e4e311', '24439695880c44f78458c1b3dcc83978', '会诊领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('f38c9088-ae69-476b-b26b-77486d5de433', '24439695880c44f78458c1b3dcc83978', '会诊医生', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('f5931a83-8624-423c-a9a6-1f30501f2bf1', 'e4397c9a686148b7aa577004aebad082', 'ddd', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('f7b7ae29-aa5b-40ae-b225-a9c91febee8d', 'e4397c9a686148b7aa577004aebad082', '111', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('fa86c86e-9447-4ef3-8479-8f063e86ce83', 'e4397c9a686148b7aa577004aebad082', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_22` VALUES ('fcd0a088-9d5a-439c-a0eb-2debc774b478', '6214b7ee04ed4c9c8ba2297498c04d28', 'admin', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_23`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_23`;
CREATE TABLE `custom_tpl_grid_summary_23` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `44b1788d5b277` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_23
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('0198e926-5c6d-42c8-b4fd-2b1dc69986bc', '854bfe9f300447538d87357dc95299f8', 'ddd', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('0b65d3bf-8cea-4909-b8df-4f24fd841f2c', '854bfe9f300447538d87357dc95299f8', 'xxxx', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('1341ced4-b3e2-4877-8b18-09ae3a001789', 'ab5d3e12f76d446386459ed5f56a5a3c', '测试1', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('1bbf2e55-aaca-41b9-982e-bf70561cbe4b', 'ab5d3e12f76d446386459ed5f56a5a3c', 'rrr', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('288c9e2d-8511-4824-88d3-cbc7dbb8084a', 'ab5d3e12f76d446386459ed5f56a5a3c', '测试联络人', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('3367587a-3f9c-4562-ac6a-91fd8244b35f', '854bfe9f300447538d87357dc95299f8', '宁仁佳', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('34f9f4c1-903b-40aa-9bc6-9fd84298ca77', '854bfe9f300447538d87357dc95299f8', '阿蛤', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('35cf375c-3265-42fb-b928-18f10c555397', '854bfe9f300447538d87357dc95299f8', 'ddd', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('383fd7b2-a103-4e7c-b0bc-ad269b6dd710', '854bfe9f300447538d87357dc95299f8', 'ssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('3a099331-5b41-484b-bd22-7e2b12581a7d', '854bfe9f300447538d87357dc95299f8', 'yyy', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('3bb3e309-6167-4905-8154-455f7214dd90', 'ab5d3e12f76d446386459ed5f56a5a3c', 'xxxx', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('42b43a88-19e1-45f6-85ff-f76d407f3413', 'ab5d3e12f76d446386459ed5f56a5a3c', 'ddd', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('558fad16-f5e1-4390-bc3d-a3f8adebc331', 'ab5d3e12f76d446386459ed5f56a5a3c', 'ssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('579a7cea-38c6-4e9f-b4fd-d1f27143ef7c', '854bfe9f300447538d87357dc95299f8', '邒肯睥', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('5ef9c12b-cddb-44bb-9eae-91edc7f1b3eb', 'ab5d3e12f76d446386459ed5f56a5a3c', 'ddd', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('6059dbb8-0346-4da2-b43a-8952c541b8c9', 'ab5d3e12f76d446386459ed5f56a5a3c', 'yyy', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('664d1870-c6a4-4c59-a7d5-d99e0c4486fc', '854bfe9f300447538d87357dc95299f8', '测试1的领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('74e5514d-d5de-4cb5-a4b7-b429ad8e1133', 'ab5d3e12f76d446386459ed5f56a5a3c', 'sssssssssssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('774bc6ed-e843-4dc7-8242-13251982e75e', '854bfe9f300447538d87357dc95299f8', '测试1', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('80c5214d-2f34-44cc-a6c6-df69795bcea2', '854bfe9f300447538d87357dc95299f8', '会诊医生', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('8202ff9e-3c8e-49f9-a173-e66e0f43d1db', 'ab5d3e12f76d446386459ed5f56a5a3c', 'hhh', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('914746b0-684c-42dc-87f2-ae208c76f6a7', 'ab5d3e12f76d446386459ed5f56a5a3c', 'uuuu', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('92a4ee12-fc3b-4193-b347-a8545f716222', '854bfe9f300447538d87357dc95299f8', '111', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('94f083e4-b519-4eda-9f4e-b9b591bd1e3d', 'ab5d3e12f76d446386459ed5f56a5a3c', '测试1的领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('9560c23f-aca2-4059-a00e-3f4766801a15', '854bfe9f300447538d87357dc95299f8', 'admin', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('96861868-d20b-4dc0-a434-725e1765dd3d', 'ab5d3e12f76d446386459ed5f56a5a3c', 'admin', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('9d8d4d9e-7c27-4821-89ec-a128790b31e8', 'ab5d3e12f76d446386459ed5f56a5a3c', '会诊医生', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('a2809a97-6dca-4014-af4e-4c0f2cd3b447', 'ab5d3e12f76d446386459ed5f56a5a3c', '邒肯睥', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('a8afeb20-3b2b-43df-9194-21d3c1cec462', 'ab5d3e12f76d446386459ed5f56a5a3c', '阿蛤', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('afab6520-5bcb-4c75-821a-c993f243114d', '854bfe9f300447538d87357dc95299f8', 'sssssssssssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('b17c9009-c41b-463e-86d9-4a8c419eac66', '854bfe9f300447538d87357dc95299f8', '会诊领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('b462d98e-b557-4450-a25e-1de7a1bfbc05', '854bfe9f300447538d87357dc95299f8', 'hyyyy', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('c20bd4bc-3ed0-49da-a22a-a0d591362bb3', '854bfe9f300447538d87357dc95299f8', 'uuuu', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('d404a8d2-1947-44f7-85ec-51c77f953aaf', 'ab5d3e12f76d446386459ed5f56a5a3c', '宁仁佳', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('d4fc82b3-630d-4b0c-8ec3-df59da22b3a8', 'ab5d3e12f76d446386459ed5f56a5a3c', '黄小明', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('db522eac-0bc4-4d78-ad4e-ffc29f32d7c1', 'ab5d3e12f76d446386459ed5f56a5a3c', '会诊领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('dc1b62ed-17c5-4782-b60d-edd03e3329de', '854bfe9f300447538d87357dc95299f8', 'hhh', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('e2f9f684-7804-4814-976f-db6f8e814945', '854bfe9f300447538d87357dc95299f8', '测试联络人', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('e7c24833-6ce6-4176-a12b-36858679e91f', 'ab5d3e12f76d446386459ed5f56a5a3c', '111', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('ec6a4116-e689-4746-a948-728dc5a8422a', '854bfe9f300447538d87357dc95299f8', '黄小明', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('fd545e91-b0ef-402c-8dd1-c947a0c64724', '854bfe9f300447538d87357dc95299f8', 'rrr', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_23` VALUES ('ff94420d-f31a-4ace-9d74-287bf2d9ac86', 'ab5d3e12f76d446386459ed5f56a5a3c', 'hyyyy', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_24`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_24`;
CREATE TABLE `custom_tpl_grid_summary_24` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `44b1788d5b277` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_24
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_24` VALUES ('30c495b3-e50b-4b79-9282-84065986c8ab', 'bbf6f9f5d3894b91b89dad70394c74de', '测试1', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_24` VALUES ('42b00413-4641-48b2-973d-0f3dc0493523', 'bbf6f9f5d3894b91b89dad70394c74de', '测试1的领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_24` VALUES ('432349fa-78bc-4558-a92e-2ea8bb4f8f87', 'bbf6f9f5d3894b91b89dad70394c74de', '阿蛤', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_24` VALUES ('b2deee65-edb1-4266-8e03-ed9ad7371859', 'bbf6f9f5d3894b91b89dad70394c74de', 'admin', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_24` VALUES ('c2fe51b6-380c-4941-9cb8-3310c77176f0', 'bbf6f9f5d3894b91b89dad70394c74de', 'ssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_24` VALUES ('dce9c232-c9ca-4bb9-9a75-226261bb79ea', 'bbf6f9f5d3894b91b89dad70394c74de', 'sssssssssssss', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_25`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_25`;
CREATE TABLE `custom_tpl_grid_summary_25` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `44b1788d5b277` varchar(64) DEFAULT NULL,
  `da3f736844bfd` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_25
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_25` VALUES ('377537f5-7179-4e6a-b790-4a7d84e7509d', '77262fb3438c4caf9e27b5fe429a9e82', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_25` VALUES ('47258bfa-d9b8-4a51-b272-1461d5996e6a', '77262fb3438c4caf9e27b5fe429a9e82', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_25` VALUES ('7f44c63d-800e-4c71-a318-2a2348a57a16', '77262fb3438c4caf9e27b5fe429a9e82', '测试1', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_25` VALUES ('9063bd77-500e-45bc-b76d-5aa39bdf89bc', '77262fb3438c4caf9e27b5fe429a9e82', 'sssssssssssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_25` VALUES ('bbc1ed64-2b64-4d94-9655-7aa82c717f8d', '77262fb3438c4caf9e27b5fe429a9e82', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_25` VALUES ('dc985605-25df-4751-b69a-cd01a84f21b4', '77262fb3438c4caf9e27b5fe429a9e82', 'admin', null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_26`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_26`;
CREATE TABLE `custom_tpl_grid_summary_26` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_26
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_26` VALUES ('309c6bb2-487a-4163-aee8-3624b5747673', '95aa0c8f2bba4a74ab24b48d237f7ff7', 'sssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_26` VALUES ('37fd50fd-aac6-46a7-862b-3d56a9d6cce0', '95aa0c8f2bba4a74ab24b48d237f7ff7', '测试1', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_26` VALUES ('7b0429ae-8e2a-4d35-99dd-11df25e334dd', '95aa0c8f2bba4a74ab24b48d237f7ff7', '测试1的领导', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_26` VALUES ('babbfcf7-d921-4327-a084-ebf07c0bb2b7', '95aa0c8f2bba4a74ab24b48d237f7ff7', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_26` VALUES ('d950e243-914a-4f65-b170-b4b939d16f56', '95aa0c8f2bba4a74ab24b48d237f7ff7', '阿蛤', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_26` VALUES ('fd584c73-c6af-4b41-9cd7-f051f56c778f', '95aa0c8f2bba4a74ab24b48d237f7ff7', 'admin', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_27`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_27`;
CREATE TABLE `custom_tpl_grid_summary_27` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_27
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('0c0b230f-b236-4d2f-a907-177e25923828', '066bc75862be4424892a75805e85ecb4', 'rrr', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('12373a9e-8484-4be6-9978-8c8011ea5f39', '066bc75862be4424892a75805e85ecb4', 'admin', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('40ef7c91-7755-4883-bffe-5c96fb251746', '066bc75862be4424892a75805e85ecb4', '111', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('49abb604-8d17-4696-ac2e-4e1acb055b16', '77c5f43d06b947c190ef753de1671a70', '阿蛤', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('4e77c180-ae72-46f8-8f84-ad2934cee479', '066bc75862be4424892a75805e85ecb4', '邒肯睥', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('54cd965c-ae47-40e8-9885-7c3323606044', '066bc75862be4424892a75805e85ecb4', 'yyy', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('593d1ad9-b5d0-487f-a9a8-324bbcfd0674', '066bc75862be4424892a75805e85ecb4', 'sssssssssssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('5d0aea5b-fd08-4bea-9042-81f28f67e05c', '77c5f43d06b947c190ef753de1671a70', '测试1', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('6b95b7d4-465c-47c0-8e8b-e676b72f8c5f', '066bc75862be4424892a75805e85ecb4', 'uuuu', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('6bc5999c-bfbd-4620-a6eb-b0bf1c3c300d', '066bc75862be4424892a75805e85ecb4', 'ddd', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('6d0d0d35-4339-4369-ab36-b45e53c11eaa', '066bc75862be4424892a75805e85ecb4', '测试联络人', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('71d13ae3-7a23-4351-b0b3-140deef0f140', '066bc75862be4424892a75805e85ecb4', 'xxxx', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('72809f9c-cc4a-4954-98fc-83603b5a8837', '066bc75862be4424892a75805e85ecb4', '宁仁佳', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('7701a16d-bdd4-4a6a-84f0-a2473bc615a8', '066bc75862be4424892a75805e85ecb4', '阿蛤', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('7735ab5c-76a2-4f03-9869-9ba8e3ed8d51', '066bc75862be4424892a75805e85ecb4', '测试1的领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('80b3a6bb-07e3-455e-88d5-7c2fc3de6938', '77c5f43d06b947c190ef753de1671a70', 'sssssssssssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('81e2a77f-4b10-4c96-b974-7f21a660d4c2', '066bc75862be4424892a75805e85ecb4', 'hyyyy', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('8217beff-916e-49fb-ad64-8686da91a49a', '066bc75862be4424892a75805e85ecb4', '会诊领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('946883e7-2910-4b31-b92d-db99097016c6', '066bc75862be4424892a75805e85ecb4', 'hhh', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('a0e6386f-1b05-445e-ac8d-0542e268e8c1', '066bc75862be4424892a75805e85ecb4', '测试1', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('a32f12c7-2fe8-41c6-a91a-59dd29d43581', '066bc75862be4424892a75805e85ecb4', '会诊医生', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('a92623d8-44cf-4bb0-b748-87c62d091920', '77c5f43d06b947c190ef753de1671a70', '测试1的领导', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('cc6eb0cd-d63c-4a42-81d5-962a1c7547f1', '066bc75862be4424892a75805e85ecb4', 'ssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('d8304481-ded6-4c84-a6c8-618361d0ba36', '066bc75862be4424892a75805e85ecb4', '黄小明', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('e6765128-0cfd-4f20-8c54-9601041ee5a7', '066bc75862be4424892a75805e85ecb4', 'ddd', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('e70d0012-e4b2-4f67-8b27-e31513e5c140', '77c5f43d06b947c190ef753de1671a70', 'ssss', null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_27` VALUES ('fe0eaf9e-c636-4d29-8372-bc649fb1453d', '77c5f43d06b947c190ef753de1671a70', 'admin', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_28`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_28`;
CREATE TABLE `custom_tpl_grid_summary_28` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `ba6f26933f7e` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_28
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('097628d7-7346-4c14-bcf2-701178d81514', 'ddaaf7b2caed4a52abd1ae9c777545ab', 'sssssssssssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('0bae9150-cdd1-476f-8bb0-3e71a4ac864a', '6245d71bcbc04ede85d35a554bd03d29', '测试1', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('1198ddf0-ffa6-4d36-a6d6-e0d97be70521', '6245d71bcbc04ede85d35a554bd03d29', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('4bad289b-781b-439b-afc2-de0a6f1ef223', '6245d71bcbc04ede85d35a554bd03d29', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('586231e4-84b4-4237-ba9d-963841a96bf4', '6245d71bcbc04ede85d35a554bd03d29', 'sssssssssssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('626ada31-442b-4d3c-82d2-3b279ed2afb7', '6245d71bcbc04ede85d35a554bd03d29', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('6aea2090-4eeb-4f1b-84c6-68755312e8e6', 'ddaaf7b2caed4a52abd1ae9c777545ab', 'admin', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('6cc50e52-73c8-4b19-817f-fa26081e9b2e', 'ddaaf7b2caed4a52abd1ae9c777545ab', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('aeb059c3-79e7-4b15-a10d-b36005ed730c', 'ddaaf7b2caed4a52abd1ae9c777545ab', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('c5e749af-5f17-45e4-abc2-72ee4d11cbb6', '6245d71bcbc04ede85d35a554bd03d29', 'admin', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('c76ec9f4-d017-48bf-9c50-34d01e5925b6', 'ddaaf7b2caed4a52abd1ae9c777545ab', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_28` VALUES ('eff5366f-5580-4e39-b7c5-0559267857e0', 'ddaaf7b2caed4a52abd1ae9c777545ab', '测试1', null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_29`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_29`;
CREATE TABLE `custom_tpl_grid_summary_29` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `fd1e796240fbb` varchar(64) DEFAULT NULL,
  `3bf42dc35ecf3` varchar(64) DEFAULT NULL,
  `ce34b2ca0bffb` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `ba6f26933f7e` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_29
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('27d4d04f-8d38-4adb-852d-2ac55288bfed', '6bf2827fa9d74c8086609ee295ae6895', '测试1', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('45747b3b-4b5f-4b15-8fd0-359b9dc744a6', '6bf2827fa9d74c8086609ee295ae6895', 'sssssssssssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('4b88dd9f-1efc-492c-83a7-78ded360d07b', '6bf2827fa9d74c8086609ee295ae6895', 'admin', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('4fd0c9a3-970a-440d-b70c-20fd79fd2570', '1b6388ab1a574474accd7a0552ddcfff', '测试1', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('5ec47b31-e2f4-45d3-9262-de80adc738bd', '7d33aa2eefec48709bf0d35ae895be81', 'admin', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('6b2a9d88-828f-477e-bcf5-97881e8558d3', '1b6388ab1a574474accd7a0552ddcfff', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('6d47e894-1b2e-4dd4-a92d-6bdc96f8b977', '1b6388ab1a574474accd7a0552ddcfff', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('74106fcc-6e71-4d72-8521-3945c22569ff', '7d33aa2eefec48709bf0d35ae895be81', '测试1', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('750697f9-7394-4b2b-9735-3a5320f09280', '192bdfa3b40f4d4887640948d6952b78', 'admin', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('7c204973-6cc3-4513-9771-5e17f487afd7', '7d33aa2eefec48709bf0d35ae895be81', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('802136db-5af8-465a-b4e8-830382f3e43d', '40153f69dc6b44208ee54946c8e04930', '测试1', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('91ed4ab1-8bf4-4c54-8586-58be113bafc4', '6bf2827fa9d74c8086609ee295ae6895', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('9c3129b4-f1d1-4b4d-bd31-94381c6b28f6', '1b6388ab1a574474accd7a0552ddcfff', 'sssssssssssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('a3d17d05-5fcd-4d0c-acc5-7ea1577b8c56', '7d33aa2eefec48709bf0d35ae895be81', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('a64f54a5-f24b-409b-ad86-9075e660a572', '40153f69dc6b44208ee54946c8e04930', 'ssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('a99ea110-41d1-493a-af12-ab074d6e9f60', '1b6388ab1a574474accd7a0552ddcfff', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('b58d32c3-9dbe-430f-9d82-c8c610e84903', '6bf2827fa9d74c8086609ee295ae6895', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('bf461f16-d825-4c73-83d8-8cf8a9967119', '6bf2827fa9d74c8086609ee295ae6895', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('d693a75e-7f5e-4df4-af69-df00e5ff9ca4', '40153f69dc6b44208ee54946c8e04930', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('e55a47c9-aa21-4489-ad61-b91c899c0275', '40153f69dc6b44208ee54946c8e04930', '阿蛤', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('e6a46683-8535-411e-8a25-da76ba708851', '40153f69dc6b44208ee54946c8e04930', 'admin', 'admin', null, null, null, '喜马拉雅', '170', '88', '3');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('f402a76b-3fb0-4071-a785-d8a720b051a5', '7d33aa2eefec48709bf0d35ae895be81', 'sssssssssssss', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('f7c8883a-07f5-401e-921b-464c8f509012', '1b6388ab1a574474accd7a0552ddcfff', 'admin', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('fa189fb6-a50e-4069-9287-39a268e5b9b0', '7d33aa2eefec48709bf0d35ae895be81', '测试1的领导', null, null, null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_29` VALUES ('fbe85c95-748c-46c4-9219-9163f4f4ee84', '40153f69dc6b44208ee54946c8e04930', 'sssssssssssss', null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_3`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_3`;
CREATE TABLE `custom_tpl_grid_summary_3` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `wechat` varchar(64) DEFAULT NULL,
  `ae864509e96c2` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_3
-- ----------------------------

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_30`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_30`;
CREATE TABLE `custom_tpl_grid_summary_30` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `ba6f26933f7e` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_30
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_30` VALUES ('332e05ed-aabd-4000-af28-ba5aeea72610', 'c13bb0a2ec214221ad9450b6dcc26199', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_30` VALUES ('3373f5c5-01c2-494f-b2cd-697892a0db2d', 'c13bb0a2ec214221ad9450b6dcc26199', '阿蛤', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_30` VALUES ('579fd0a0-5e31-4f11-88b7-33a88fc8f494', 'c13bb0a2ec214221ad9450b6dcc26199', 'admin', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_30` VALUES ('84d4ed48-1c17-4d06-8421-512c86422cae', 'c13bb0a2ec214221ad9450b6dcc26199', 'sssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_30` VALUES ('eb8d22db-b600-4f4d-8e08-b30e8bc2bb3b', 'c13bb0a2ec214221ad9450b6dcc26199', '测试1的领导', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_30` VALUES ('fbe04e77-5107-423c-82a9-445627c2f6f2', 'c13bb0a2ec214221ad9450b6dcc26199', '测试1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_31`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_31`;
CREATE TABLE `custom_tpl_grid_summary_31` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `ba6f26933f7e` varchar(64) DEFAULT NULL,
  `19b6b94dab1ca` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_31
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('18fc5034-c318-43e8-bb43-2c4b75c6cb7b', '4f5bac38ac134d3ca61dfdd3cdb45265', '测试1的领导', 'test1delingdao', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('44996527-8734-4273-94df-2f6586452b3b', '4f5bac38ac134d3ca61dfdd3cdb45265', 'admin', 'admin', null, null, null, null, '2');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('4caac82d-1b0d-4246-8a37-f1023ba2889e', '4f5bac38ac134d3ca61dfdd3cdb45265', '测试1', 'ceshi1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('5ed436b7-8eab-46bb-840a-13899d754370', '008c09b2db7b48169f8e84239d9e6ba8', 'admin', 'admin', 'ad', 'asd', 'asd', 'asd', '3');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('601cf2bc-a7ab-4c16-bf1a-df3cfb57d542', '4098ebf6220d4293854f527b963b7910', 'admin', 'admin', 'asd ', 'a sdf', ' asd', ' asdf', '3');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('73ef5e76-c804-4572-bba1-df89ddc70bd5', 'bb54850f79824a47a04aac4f1221de41', '测试联络人', 'ceshilianluoren', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('834339be-b008-448e-a931-14615e7e8aac', 'e3c0affca82f45ef8d58d96bc49960aa', 'admin', 'admin', null, null, null, null, '1');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('8687f3b9-0eb5-4679-9d5d-95b00bdcc48f', '4f5bac38ac134d3ca61dfdd3cdb45265', 'ssss', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('8f800e4a-3164-4712-9516-d3e4edd965a0', 'bb54850f79824a47a04aac4f1221de41', 'admin', 'admin', '阿斯蒂芬', 'a\'d', '阿道夫', '的', '3');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('95dc3b93-92d3-4242-9edc-60b59d3f737a', 'bb54850f79824a47a04aac4f1221de41', '邒肯睥', 'tingkenpi', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('9b6bb7cf-e51d-49c4-b169-90b94b8d7f70', 'ef1f92a16a76405484457dfb9d1c2193', 'admin', 'admin', '阿斯蒂芬', '阿斯顿', '阿斯顿', ' 啊的', '3');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('be3df17a-9348-41eb-a7a1-fc3b2bb0253f', '4f5bac38ac134d3ca61dfdd3cdb45265', '阿蛤', 'aha', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('c622697c-8b43-46f8-aac5-574c708177c7', '4f5bac38ac134d3ca61dfdd3cdb45265', 'sssssssssssss', 'ssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('dd4f73ea-4a1d-49a3-82f4-cd6113e6f1b7', '48f034b84a77439192e3d383d767767c', 'admin', 'admin', '阿德', '啊', '啊d', ' 阿三', '3');
INSERT INTO `custom_tpl_grid_summary_31` VALUES ('f5f94beb-1ebd-4e96-8454-4e54612c5f87', '8a64c6a9e93f4b4e9c29d067071a9d17', 'admin', 'admin', '的', '啊', '阿德', ' 阿德', '3');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_32`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_32`;
CREATE TABLE `custom_tpl_grid_summary_32` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `ba6f26933f7e` varchar(64) DEFAULT NULL,
  `19b6b94dab1ca` varchar(64) DEFAULT NULL,
  `81651c3d4a505` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_32
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('1aa04dcf-1887-4b03-bb8e-82de3d9b2f95', 'ca451ae5931b4519802045305653c5bb', 'admin', 'admin', '喜马拉雅', '170', '88', '13566754456', null, '3');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('24fdab1e-0049-48c8-8229-e6a5956b1952', 'ca451ae5931b4519802045305653c5bb', '测试1的领导', 'test1delingdao', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('259bb5a2-72be-4cc5-a814-528c1e58574a', 'ca451ae5931b4519802045305653c5bb', 'sssssssssssss', 'ssssssssssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('3c86a347-6ea7-4183-91b4-4a33ac143b7f', 'ca451ae5931b4519802045305653c5bb', '阿蛤', 'aha', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('50841b4e-23e3-4548-a98e-c9f45fbca85f', 'f02ca7db15dd4896a77abbbf0cbe8628', 'admin', 'admin', 'gghh', 'hhh', 'hh', 'hh', 'hh', '3');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('604c0167-e095-4b09-b1bd-fdcd50428b4c', 'ca451ae5931b4519802045305653c5bb', 'ssss', 'ssss', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('88b905b2-8887-43cc-93f6-ed143201d1cb', '04adf1158de34b968a2dbb58246e6a03', '李四', 'lisi', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('d3127b7c-8bda-4e11-82d0-f04412394cc0', '024606e102e74d5e9b9ac4086ec2a8da', 'rrr', 'rrr', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('eae476f5-e981-4e3f-8936-5f18ff620800', 'f02ca7db15dd4896a77abbbf0cbe8628', '宁仁佳', 'ningrenjia', null, null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_32` VALUES ('fd468b8d-8b56-40f4-bfe4-6dd799c9374b', 'ca451ae5931b4519802045305653c5bb', '测试1', 'ceshi1', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_33`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_33`;
CREATE TABLE `custom_tpl_grid_summary_33` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `abbe67ffa6cf6` varchar(64) DEFAULT NULL,
  `f4dec5d3ccca5` varchar(64) DEFAULT NULL,
  `ba6f26933f7e` varchar(64) DEFAULT NULL,
  `eb9194501d4d2` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_33
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('00cd39fa-059b-49bc-99c4-b6936a973a13', 'b573dd4c9b034f38b4a363bba6a3c671', 'sssssssssssss', 'ssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('119080b4-88f7-4bc5-966b-467c844c9f62', 'e081b42935374c8e9abfbce081aa4a4c', '阿蛤', 'aha', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('11fef9f7-ffb5-421a-bcad-0ecac35fca4f', '9a90c47db1fd425d8b0a3566c0fb7704', '测试1的领导', 'test1delingdao', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('1580f242-aa98-4f9b-9d15-a8b7675274e8', '02529acb13c04d85a69b719237a398be', '测试1', 'ceshi1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('1f6de4ac-b815-4b97-b0f0-dda48d1f7291', '02529acb13c04d85a69b719237a398be', 'admin', 'admin', '喜马拉雅', '170', '88', null, '3');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('2ae69a10-93d2-44bf-9204-ebe14388c690', '9a90c47db1fd425d8b0a3566c0fb7704', 'ssss', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('2efd68f9-6386-4d95-9c04-678383256894', 'b573dd4c9b034f38b4a363bba6a3c671', 'ssss', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('36cf0fb6-3f6c-4fb0-8f54-b65022101e93', 'e081b42935374c8e9abfbce081aa4a4c', 'ssss', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('42c49dd7-13f9-4d32-9c9b-0264509f77a6', 'e62be4b2f9dc49d6a98d990260f17f75', 'sssssssssssss', 'ssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('4e3bed45-bff9-470f-b9f8-2a943e2ef8af', 'b573dd4c9b034f38b4a363bba6a3c671', '阿蛤', 'aha', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('51fea9b4-391f-4e82-a968-ef05b47c37bf', 'b573dd4c9b034f38b4a363bba6a3c671', 'admin', 'admin', '喜马拉雅', '170', '88', '', '3');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('52b3d94f-a550-48c6-b7f7-23665a885d06', 'e081b42935374c8e9abfbce081aa4a4c', 'admin', 'admin', '珠穆朗玛峰', '170', '88', null, '3');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('59eb1d2b-2493-46bd-aa65-9bc70139f414', 'e081b42935374c8e9abfbce081aa4a4c', '测试1的领导', 'test1delingdao', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('5e224622-d548-4acb-8e89-b1889f9187c1', '9a90c47db1fd425d8b0a3566c0fb7704', '测试1', 'ceshi1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('5fde5a51-fc3b-4a2a-a602-4036f6b6d1e9', 'b573dd4c9b034f38b4a363bba6a3c671', '测试1的领导', 'test1delingdao', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('61871003-e784-490d-a5f2-46cd51f3ce63', 'e62be4b2f9dc49d6a98d990260f17f75', '测试1的领导', 'test1delingdao', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('731e0149-058a-41d4-affe-9af337c97c63', '02529acb13c04d85a69b719237a398be', '测试1的领导', 'test1delingdao', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('87764fcc-21d1-431b-a667-c3627002ac90', '9a90c47db1fd425d8b0a3566c0fb7704', 'admin', 'admin', '喜马拉雅', '170', '88', '无', '3');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('96532bcb-482a-47a6-addc-e262c12a4c3d', 'e62be4b2f9dc49d6a98d990260f17f75', 'ssss', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('97bc939b-2eb9-4a66-854d-33d7d0260bb7', 'e081b42935374c8e9abfbce081aa4a4c', 'sssssssssssss', 'ssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('97f841ea-dd8c-4f02-886a-d307c31e8652', '9a90c47db1fd425d8b0a3566c0fb7704', '阿蛤', 'aha', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('a5eeaa5a-ee8b-4522-8f1a-834efec15071', '9a90c47db1fd425d8b0a3566c0fb7704', 'sssssssssssss', 'ssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('bbd99233-f4e8-46fa-b15c-0e4313cf48df', '02529acb13c04d85a69b719237a398be', 'sssssssssssss', 'ssssssssssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('c07f82e8-ac47-47e9-a60a-0a023f6bcef1', 'e62be4b2f9dc49d6a98d990260f17f75', '阿蛤', 'aha', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('d0afb2dc-cf9c-43cf-9177-bdd7b57dd9e9', 'b573dd4c9b034f38b4a363bba6a3c671', '测试1', 'ceshi1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('e18aad0d-10a1-4d2d-996c-da0714b0a4ab', 'e62be4b2f9dc49d6a98d990260f17f75', '测试1', 'ceshi1', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('e5c77306-1507-4183-a463-50081672ad4c', '02529acb13c04d85a69b719237a398be', 'ssss', 'ssss', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('f44b2670-ffdf-4310-8af9-ad08f274e2d5', '02529acb13c04d85a69b719237a398be', '阿蛤', 'aha', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('f741e570-dccd-4c00-92db-40cc23532b4a', 'e62be4b2f9dc49d6a98d990260f17f75', 'admin', 'admin', null, null, null, null, '1');
INSERT INTO `custom_tpl_grid_summary_33` VALUES ('fd860481-7c67-4680-ac38-483de1fc97de', 'e081b42935374c8e9abfbce081aa4a4c', '测试1', 'ceshi1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_4`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_4`;
CREATE TABLE `custom_tpl_grid_summary_4` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_4
-- ----------------------------

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_5`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_5`;
CREATE TABLE `custom_tpl_grid_summary_5` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_5
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('3afbdaa4-fd49-4eb1-947b-4e746ab9aacc', 'ad2b7c20930e4f29a11116e94acdab0f', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('528a8f2c-7d73-4862-9ff7-251f043367db', 'ad2b7c20930e4f29a11116e94acdab0f', '阿蛤', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('6d746bb2-bb58-4c36-beee-75fdfb8c253e', 'ad2b7c20930e4f29a11116e94acdab0f', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('7bb2121e-638d-4785-9680-c9f4705dc498', 'f454e470b7a04bb7b0757afed4c67e6e', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('86417faa-0865-49bb-bdbc-eb14b815dffa', 'ad2b7c20930e4f29a11116e94acdab0f', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('c7462bbd-5f21-4028-92c2-9f2b45d15df2', 'f454e470b7a04bb7b0757afed4c67e6e', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_5` VALUES ('e461f164-777f-46f1-be93-9e5b1883d871', 'f454e470b7a04bb7b0757afed4c67e6e', '测试1', null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_6`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_6`;
CREATE TABLE `custom_tpl_grid_summary_6` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_6
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('163ffacf-8100-435f-a5f3-28b214abf6c8', 'c1d22f128df144d4847fd5b3d397cb95', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('1d52391f-8e1d-43b7-bd8f-442ed67057ce', 'c1d22f128df144d4847fd5b3d397cb95', '阿蛤', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('21f788f1-b71e-4560-a6d1-67532fced9d4', '13520902257f49148f7cd67fed40abab', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('279c08af-1b18-4e8b-8691-80cf70730046', 'a6cbaa082cd942a99c969b1354c19076', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('307171de-f7a8-46f1-baae-0e202bcbcd98', '63f9d80a21f34f8aaa54806bf950aa20', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('511de37f-1da1-4012-bc28-b6e07ffcf93f', '63f9d80a21f34f8aaa54806bf950aa20', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('6f27a9a8-32dd-4af7-a5b6-df4040e3cf11', '63f9d80a21f34f8aaa54806bf950aa20', '阿蛤', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('75eeb5fd-8450-447e-97a4-c9407e21af22', 'a6cbaa082cd942a99c969b1354c19076', '阿蛤', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('8b7e19cf-7071-4053-8d8e-b0437f8b6cf3', '13520902257f49148f7cd67fed40abab', '测试1', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('8bf918c8-d312-495c-b55e-3ba9012315ec', '13520902257f49148f7cd67fed40abab', '阿蛤', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('9136a824-4029-42b7-a288-ce2338abc18f', '63f9d80a21f34f8aaa54806bf950aa20', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('a46ef6e0-c2cb-4b01-8fee-37024b7210f9', 'c1d22f128df144d4847fd5b3d397cb95', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('ac32ab76-0b29-4078-a9ff-05cf60f8bd50', '13520902257f49148f7cd67fed40abab', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('ba14fe99-1765-453f-8281-22adc7ae0150', 'c1d22f128df144d4847fd5b3d397cb95', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('bf4873a5-a4f0-460d-8989-b99be0ff476f', 'a6cbaa082cd942a99c969b1354c19076', '测试1的领导', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('c1d61836-acb7-4dbe-9edb-9f0a9b09f7a9', 'a6cbaa082cd942a99c969b1354c19076', 'admin', null, null, '0');
INSERT INTO `custom_tpl_grid_summary_6` VALUES ('fb544b57-417a-4a97-8545-d4120a3c1138', 'c50109410aac4490b4d1261a5cb95aee', 'admin', null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_7`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_7`;
CREATE TABLE `custom_tpl_grid_summary_7` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `ac19acb2708a7` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_7
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('03c82d91-a7df-4895-85fb-e629528e8605', 'c923fbcf32414ca0a093e3d09721fc1d', '测试1的领导', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('23e9df44-68ec-4702-828e-e20c86127dde', 'd36f9ac06a2144b9a9871da19b69cd59', '阿蛤', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('306a55e2-1e26-41a1-aaf1-d3b1b55959d0', 'd36f9ac06a2144b9a9871da19b69cd59', '测试1', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('63c50be0-2b8b-42dc-a993-81a65265c413', 'c923fbcf32414ca0a093e3d09721fc1d', 'admin', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('66e87ad1-b32d-4aa9-8ce5-e5d8a5e23951', 'd36f9ac06a2144b9a9871da19b69cd59', '测试1的领导', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('b244fd0c-4979-4714-b6c9-12c06d80db0c', 'a20ee99962ae46b9bd5a6fbe423f58ca', 'admin', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('cdb67ddf-4004-434f-a8bd-3ed2c7d307cc', 'c923fbcf32414ca0a093e3d09721fc1d', '测试1', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('d3940932-7f0a-4d5d-bda0-5eeeec05237b', 'c923fbcf32414ca0a093e3d09721fc1d', '阿蛤', null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_7` VALUES ('e3f69aec-7b14-4899-8ed0-22f085e5539f', 'd36f9ac06a2144b9a9871da19b69cd59', 'admin', null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_8`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_8`;
CREATE TABLE `custom_tpl_grid_summary_8` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `ac19acb2708a7` varchar(64) DEFAULT NULL,
  `a129c1c43d2b1` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_8
-- ----------------------------
INSERT INTO `custom_tpl_grid_summary_8` VALUES ('18a35bc0-3d12-46ff-be19-098d4f4a3075', '355262245e994856bd40e22b0491855b', 'admin', null, null, null, null, '0');
INSERT INTO `custom_tpl_grid_summary_8` VALUES ('b65f7aa9-06a5-4d10-95b3-655a5064913e', '4bd8718191cf40e591de053c77255b86', 'admin', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_grid_summary_9`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_grid_summary_9`;
CREATE TABLE `custom_tpl_grid_summary_9` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `68abada506f47` varchar(64) DEFAULT NULL,
  `ac19acb2708a7` varchar(64) DEFAULT NULL,
  `a129c1c43d2b1` varchar(64) DEFAULT NULL,
  `6927afbe71493` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_grid_summary_9
-- ----------------------------

-- ----------------------------
-- Table structure for `custom_tpl_send_data_1`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_send_data_1`;
CREATE TABLE `custom_tpl_send_data_1` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_send_data_1
-- ----------------------------
INSERT INTO `custom_tpl_send_data_1` VALUES ('22658b61-f483-4829-82b9-41027529172a', '14f59b94cd454b379609467e70d73501', '阿蛤', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('48473c96-1ec6-4ead-a1d4-d795dce27a25', '03a1ec1a37c347cb8a5ccf003e008620', 'admin', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('48e16e1f-7920-4fb3-9b11-e04a93345f71', '03a1ec1a37c347cb8a5ccf003e008620', '测试1的领导', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('5075f005-b8e5-4e46-b551-55d5978cf892', '14f59b94cd454b379609467e70d73501', '测试1', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('61e06acc-ed7a-4a29-87de-435554c61b1b', '14f59b94cd454b379609467e70d73501', 'admin', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('64f01deb-19fb-40af-9cb8-7ee111db20c0', '03a1ec1a37c347cb8a5ccf003e008620', '阿蛤', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('a8cf0077-7a4a-461e-9076-522bfca8a450', '03a1ec1a37c347cb8a5ccf003e008620', '测试1', null, '0');
INSERT INTO `custom_tpl_send_data_1` VALUES ('f8ad2ada-c613-46df-a4f3-292354b2de50', '14f59b94cd454b379609467e70d73501', '测试1的领导', null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_send_data_2`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_send_data_2`;
CREATE TABLE `custom_tpl_send_data_2` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `accountId` varchar(64) DEFAULT NULL,
  `f3ce48efe7c7c` varchar(64) DEFAULT '99',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_send_data_2
-- ----------------------------
INSERT INTO `custom_tpl_send_data_2` VALUES ('1ecf0416-91fc-4aea-82d6-ba4b4420b706', '6c4e21e17455406b87778f3c6dc2d34b', '测试1的领导', null, '99', '0');
INSERT INTO `custom_tpl_send_data_2` VALUES ('62636990-257b-4a38-b8da-e81bda7dec26', '6c4e21e17455406b87778f3c6dc2d34b', '阿蛤', null, '99', '0');
INSERT INTO `custom_tpl_send_data_2` VALUES ('c1b0a098-719f-4c14-8b8f-ab80a235dfc6', '6c4e21e17455406b87778f3c6dc2d34b', 'admin', null, '99', '0');
INSERT INTO `custom_tpl_send_data_2` VALUES ('d5be3f4f-5072-40a0-983b-1102db56e729', '6c4e21e17455406b87778f3c6dc2d34b', '测试1', null, '99', '0');

-- ----------------------------
-- Table structure for `custom_tpl_send_data_3`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_send_data_3`;
CREATE TABLE `custom_tpl_send_data_3` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `accountId` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_send_data_3
-- ----------------------------
INSERT INTO `custom_tpl_send_data_3` VALUES ('1d7e0a45-f9db-4464-a8e7-e24b4464779b', 'e9e82897df0f4853828116e488d41a49', '测试1的领导', null, '0');
INSERT INTO `custom_tpl_send_data_3` VALUES ('40f490b1-f3bc-48c5-971e-15a4a81e07cc', 'e9e82897df0f4853828116e488d41a49', '测试1', null, '0');
INSERT INTO `custom_tpl_send_data_3` VALUES ('69c64ce6-7d33-47a1-bac7-b377f7e7a19f', 'e9e82897df0f4853828116e488d41a49', '阿蛤', null, '0');
INSERT INTO `custom_tpl_send_data_3` VALUES ('f894543a-3d83-4a9e-a89e-905f1c2969aa', 'e9e82897df0f4853828116e488d41a49', 'admin', null, '0');

-- ----------------------------
-- Table structure for `custom_tpl_send_data_4`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_send_data_4`;
CREATE TABLE `custom_tpl_send_data_4` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `accountId` varchar(128) DEFAULT NULL,
  `bcd9e3897be54` varchar(64) DEFAULT '99',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_send_data_4
-- ----------------------------
INSERT INTO `custom_tpl_send_data_4` VALUES ('22f18f7c-c9e5-4a20-bd86-a1eca7c2c294', 'f08da66b01ef4f7b86cbf8a9c75954fe', 'admin', null, '99', '0');
INSERT INTO `custom_tpl_send_data_4` VALUES ('7bf058d7-0e6f-496b-810f-662e23da5757', 'f08da66b01ef4f7b86cbf8a9c75954fe', '阿蛤', null, '99', '0');
INSERT INTO `custom_tpl_send_data_4` VALUES ('ac1ddec6-2d41-4015-9aa4-ad225a9a0c98', 'f08da66b01ef4f7b86cbf8a9c75954fe', '测试1的领导', null, '99', '0');
INSERT INTO `custom_tpl_send_data_4` VALUES ('e7c67031-73c0-4820-9997-39851197b31f', 'f08da66b01ef4f7b86cbf8a9c75954fe', '测试1', null, '99', '0');

-- ----------------------------
-- Table structure for `custom_tpl_send_data_5`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_send_data_5`;
CREATE TABLE `custom_tpl_send_data_5` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `accountId` varchar(128) DEFAULT NULL,
  `bcd9e3897be54` varchar(64) DEFAULT '99',
  `4a9d47c4b3898` varchar(64) DEFAULT '88',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_send_data_5
-- ----------------------------
INSERT INTO `custom_tpl_send_data_5` VALUES ('16a85a26-9a6c-441a-8b1e-b151fd770615', '501e34ae884247beaf6513a22d5b9eb4', 'admin', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_5` VALUES ('720fc7cc-26fe-460b-a30e-0efdb9e8a77b', '501e34ae884247beaf6513a22d5b9eb4', '测试1的领导', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_5` VALUES ('a5f8ecb4-d980-4f81-b65d-b81f63df09ea', '501e34ae884247beaf6513a22d5b9eb4', '测试1', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_5` VALUES ('fe308ed8-6472-4889-a265-1c975678ab13', '501e34ae884247beaf6513a22d5b9eb4', '阿蛤', null, '99', '88', '0');

-- ----------------------------
-- Table structure for `custom_tpl_send_data_6`
-- ----------------------------
DROP TABLE IF EXISTS `custom_tpl_send_data_6`;
CREATE TABLE `custom_tpl_send_data_6` (
  `id` varchar(64) NOT NULL,
  `boxId` varchar(64) DEFAULT NULL,
  `username` varchar(128) DEFAULT '22',
  `accountId` varchar(128) DEFAULT '4452424325325666',
  `bcd9e3897be54` varchar(64) DEFAULT '99',
  `4a9d47c4b3898` varchar(64) DEFAULT '88',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_tpl_send_data_6
-- ----------------------------
INSERT INTO `custom_tpl_send_data_6` VALUES ('1884c7ed-194e-46bb-b040-5a7fe9c3972a', '0f8cdfab4f5d42ef9542057884dea0e6', '测试1的领导', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('38741490-3387-4901-96df-fb9706dbded8', '4dd80cb00d904f039d3cd909b67535a8', '测试1', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('39ce60a9-1d91-4562-a9c4-7a5985f45405', '1dae0a47168a4a88bd9248b984e460a1', '测试1的领导', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('73e7f246-39a2-4994-9332-c7ff3d62e3be', '1dae0a47168a4a88bd9248b984e460a1', '阿蛤', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('7c1fd3a1-313a-433c-86c4-ffe91a5c1052', 'c599dd673915465a8bfe8c2d33cbd866', '测试1', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('83986fb4-c9f5-4f8b-89ac-da59b1e9d837', '0f8cdfab4f5d42ef9542057884dea0e6', '阿蛤', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('8d47467f-447e-4fe2-973d-c0b247b21f03', '1dae0a47168a4a88bd9248b984e460a1', '测试1', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('ba53adc7-e6fd-42af-ac17-7003816e9df7', '0f8cdfab4f5d42ef9542057884dea0e6', '测试1', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('bd07da04-de73-4a97-bf78-ca62f2b70c19', 'c599dd673915465a8bfe8c2d33cbd866', 'ssss', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('c1f1130b-40f5-486f-a69b-961f695797fa', '1dae0a47168a4a88bd9248b984e460a1', 'admin', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('c3f60fde-1d6f-4214-8f13-f171375a67d8', 'c599dd673915465a8bfe8c2d33cbd866', '测试1的领导', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('d6a64724-2d77-4b67-bee1-138e82760fe2', 'c599dd673915465a8bfe8c2d33cbd866', 'admin', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('d91adcc9-7e3f-49ee-93f9-c5085c80173b', '0f8cdfab4f5d42ef9542057884dea0e6', 'admin', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('dbe263e7-21fc-47fb-ae77-91fc351852c3', 'c599dd673915465a8bfe8c2d33cbd866', '阿蛤', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('de258f08-e8ca-45c0-9fe7-a1ffa63e5fe3', '4dd80cb00d904f039d3cd909b67535a8', '测试1的领导', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('e93a5c9a-9a27-40db-b37b-2cb2e4996465', '4dd80cb00d904f039d3cd909b67535a8', '阿蛤', null, '99', '88', '0');
INSERT INTO `custom_tpl_send_data_6` VALUES ('f5fdddd4-33f5-4c52-a3d7-923c5c404721', '4dd80cb00d904f039d3cd909b67535a8', 'admin', null, '99', '88', '0');

-- ----------------------------
-- Table structure for `custom_type`
-- ----------------------------
DROP TABLE IF EXISTS `custom_type`;
CREATE TABLE `custom_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `status` int(11) DEFAULT NULL COMMENT '类型状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_type
-- ----------------------------
INSERT INTO `custom_type` VALUES ('1', '布尔', '1');
INSERT INTO `custom_type` VALUES ('2', '文本', '1');
INSERT INTO `custom_type` VALUES ('3', '文本域', '1');
INSERT INTO `custom_type` VALUES ('4', '副文本', '1');
INSERT INTO `custom_type` VALUES ('5', '日期', '1');
INSERT INTO `custom_type` VALUES ('6', '下拉选项', '1');
INSERT INTO `custom_type` VALUES ('7', '数字', '1');
INSERT INTO `custom_type` VALUES ('8', '多选框', '1');
INSERT INTO `custom_type` VALUES ('9', '单选框', '1');

-- ----------------------------
-- Table structure for `lcn_tx_his_box`
-- ----------------------------
DROP TABLE IF EXISTS `lcn_tx_his_box`;
CREATE TABLE `lcn_tx_his_box` (
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
-- Records of lcn_tx_his_box
-- ----------------------------

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
