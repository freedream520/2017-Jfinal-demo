/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : jfinal

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-05-02 11:32:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_contact`
-- ----------------------------
DROP TABLE IF EXISTS `tb_contact`;
CREATE TABLE `tb_contact` (
  `openid` varchar(64) NOT NULL DEFAULT '',
  `tel` varchar(16) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_contact
-- ----------------------------
INSERT INTO `tb_contact` VALUES ('1', '13794498220', '广东.深圳');
INSERT INTO `tb_contact` VALUES ('2', '135', '重庆');

-- ----------------------------
-- Table structure for `tb_shopper`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shopper`;
CREATE TABLE `tb_shopper` (
  `openid` varchar(64) NOT NULL,
  `parentopenid` varchar(64) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(32) DEFAULT NULL,
  `updator` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shopper
-- ----------------------------
INSERT INTO `tb_shopper` VALUES ('1', null, '2016-06-06', '2016-06-06', 'admin', 'admin');
INSERT INTO `tb_shopper` VALUES ('2', '1', '2016-06-06', '2016-06-06', 'admin', 'admin');

-- ----------------------------
-- Table structure for `tzy_temp2`
-- ----------------------------
DROP TABLE IF EXISTS `tzy_temp2`;
CREATE TABLE `tzy_temp2` (
  `id` varchar(36) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `pwd` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tzy_temp2
-- ----------------------------
INSERT INTO `tzy_temp2` VALUES ('07ea74a7-59dd-4c3b-abd6-b279acd72bab', '张三', 'sdfsdfs');
INSERT INTO `tzy_temp2` VALUES ('17a4393f-2d2c-45da-ab17-d6e35945d769', '张三', 'sdfsdfs');
INSERT INTO `tzy_temp2` VALUES ('937f8c8a-0175-46a3-befd-44507a7230b0', '张三2222', 'sdfsdfs');
INSERT INTO `tzy_temp2` VALUES ('edd51c7f-bf24-4a2e-9917-194e88467c45', '张三', 'sdfsdfs');
INSERT INTO `tzy_temp2` VALUES ('f82f563d-82e5-4f3a-be88-d44af0d8059a', '张三', 'sdfsdfs');

-- ----------------------------
-- Table structure for `tzy_temp3`
-- ----------------------------
DROP TABLE IF EXISTS `tzy_temp3`;
CREATE TABLE `tzy_temp3` (
  `id` varchar(36) NOT NULL,
  `name` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tzy_temp3
-- ----------------------------
INSERT INTO `tzy_temp3` VALUES ('f82f563d-82e5-4f3a-be88-d44af0d8059a', 'FDDDDD');
