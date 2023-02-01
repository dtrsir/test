/*
Navicat MySQL Data Transfer

Source Server         : 192.168.128.11
Source Server Version : 50636
Source Host           : 192.168.128.11:3306
Source Database       : asset2

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-09-19 16:06:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ogid` int(11) DEFAULT NULL COMMENT '组织机构id',
  `dtid` int(11) DEFAULT NULL COMMENT '设备类型id',
  `code` varchar(7) DEFAULT NULL COMMENT '设备流水号',
  `residual` decimal(16,2) DEFAULT NULL COMMENT '净残值',
  `original` decimal(16,2) DEFAULT NULL COMMENT '原值',
  `status` decimal(2,0) DEFAULT NULL COMMENT '状态 1-入库、2-出库中、3-出库、4-领用、5-报修',
  `proddate` date DEFAULT NULL COMMENT '生产日期',
  `creator` int(11) DEFAULT NULL COMMENT '登记人',
  `createtime` datetime DEFAULT NULL COMMENT '登记时间',
  `buyer` int(11) DEFAULT NULL COMMENT '购买人',
  `bugdate` date DEFAULT NULL COMMENT '购买日期',
  `sno` varchar(32) DEFAULT NULL COMMENT '序列号',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备明细';

-- ----------------------------
-- Records of device
-- ----------------------------

-- ----------------------------
-- Table structure for devicereceive
-- ----------------------------
DROP TABLE IF EXISTS `devicereceive`;
CREATE TABLE `devicereceive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '设备id',
  `code` varchar(9) DEFAULT NULL COMMENT '单据号',
  `recipients` varchar(32) DEFAULT NULL COMMENT '领用人',
  `receivedate` datetime DEFAULT NULL COMMENT '领取时间',
  `returndate` datetime DEFAULT NULL COMMENT '归还日期',
  `status` decimal(2,0) DEFAULT NULL COMMENT '状态 1-领用、2-归还',
  `rcremarks` varchar(200) DEFAULT NULL COMMENT '领用备注',
  `rtremarks` varchar(200) DEFAULT NULL COMMENT '归还备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备领用表';

-- ----------------------------
-- Records of devicereceive
-- ----------------------------

-- ----------------------------
-- Table structure for devicerepair
-- ----------------------------
DROP TABLE IF EXISTS `devicerepair`;
CREATE TABLE `devicerepair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '设备id',
  `damager` int(11) DEFAULT NULL COMMENT '报修人',
  `damagedate` datetime DEFAULT NULL COMMENT '报修时间',
  `damageremarks` varchar(200) DEFAULT NULL COMMENT '报修备注',
  `repairdate` datetime DEFAULT NULL COMMENT '维修时间',
  `repairer` int(11) DEFAULT NULL COMMENT '维修人',
  `repairremarks` varchar(200) DEFAULT NULL COMMENT '维修备注',
  `status` decimal(1,0) DEFAULT NULL COMMENT '状态 1-报修、2-维修',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备维修表';

-- ----------------------------
-- Records of devicerepair
-- ----------------------------

-- ----------------------------
-- Table structure for devicesout
-- ----------------------------
DROP TABLE IF EXISTS `devicesout`;
CREATE TABLE `devicesout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '设备id',
  `outter` int(11) DEFAULT NULL COMMENT '报废人',
  `outdate` datetime DEFAULT NULL COMMENT '报废日期',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` decimal(1,0) DEFAULT NULL COMMENT '状态 1-申请、2-准许、3-拒绝',
  `approver` int(11) DEFAULT NULL COMMENT '审批人',
  `approvalremarks` varchar(200) DEFAULT NULL COMMENT '审批意见',
  `approvaldate` datetime DEFAULT NULL COMMENT '申请日期',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备出库';

-- ----------------------------
-- Records of devicesout
-- ----------------------------

-- ----------------------------
-- Table structure for devicetype
-- ----------------------------
DROP TABLE IF EXISTS `devicetype`;
CREATE TABLE `devicetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌',
  `intlcode` varchar(100) DEFAULT NULL COMMENT '国际编号',
  `model` varchar(100) DEFAULT NULL COMMENT '型号',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `asl` decimal(3,0) DEFAULT NULL COMMENT '使用年限',
  `anrv` decimal(5,3) DEFAULT NULL COMMENT '预计净残值',
  `crtm` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `mdtm` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备类型';

-- ----------------------------
-- Records of devicetype
-- ----------------------------

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构';

-- ----------------------------
-- Records of organization
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `ogid` int(11) DEFAULT NULL COMMENT '组织机构id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` decimal(1,0) DEFAULT NULL COMMENT '性别 1-男、2-女',
  `birth` varchar(20) DEFAULT NULL COMMENT '生日',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(500) DEFAULT NULL COMMENT '邮件',
  `logintime` varchar(20) DEFAULT NULL COMMENT '登录时间',
  `loginip` varchar(500) DEFAULT NULL COMMENT '登录ip',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, 'admin', '123456', '2', '2018-09-17', '15813342257', '332039038@qq.com', '2018-09-19 14:44:15', '127.0.0.1', '2018-09-17 00:30:12', '2018-09-17 00:36:53');
