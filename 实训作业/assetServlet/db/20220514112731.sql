/*
MySQL Backup
Database: asset2
Backup Time: 2022-05-14 11:27:31
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `asset2`.`device`;
DROP TABLE IF EXISTS `asset2`.`devicerepair`;
DROP TABLE IF EXISTS `asset2`.`devicesout`;
DROP TABLE IF EXISTS `asset2`.`devicetype`;
DROP TABLE IF EXISTS `asset2`.`organization`;
DROP TABLE IF EXISTS `asset2`.`role`;
DROP TABLE IF EXISTS `asset2`.`user`;
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
CREATE TABLE `devicetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌',
  `intlcode` varchar(100) DEFAULT NULL COMMENT '国际编号',
  `model` varchar(100) DEFAULT NULL COMMENT '型号',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `asl` double(3,0) DEFAULT NULL COMMENT '使用年限',
  `anrv` double(8,2) DEFAULT NULL COMMENT '预计净残值',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备类型';
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构';
CREATE TABLE `role` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户';
BEGIN;
LOCK TABLES `asset2`.`device` WRITE;
DELETE FROM `asset2`.`device`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `asset2`.`devicerepair` WRITE;
DELETE FROM `asset2`.`devicerepair`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `asset2`.`devicesout` WRITE;
DELETE FROM `asset2`.`devicesout`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `asset2`.`devicetype` WRITE;
DELETE FROM `asset2`.`devicetype`;
INSERT INTO `asset2`.`devicetype` (`id`,`name`,`brand`,`intlcode`,`model`,`remarks`,`asl`,`anrv`,`crtm`,`mdtm`) VALUES (1, '手机', '小米', '21212121', 'Might2', '感豆腐干豆腐干大概豆腐干豆腐干地方', 4, 2888.00, NULL, '2022-05-14 11:26:19');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `asset2`.`organization` WRITE;
DELETE FROM `asset2`.`organization`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `asset2`.`role` WRITE;
DELETE FROM `asset2`.`role`;
INSERT INTO `asset2`.`role` (`id`,`name`,`remarks`,`crtm`,`mdtm`) VALUES (NULL, 'admin', '管理员', '2022-05-14 09:27:00', '2022-05-14 09:27:00');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `asset2`.`user` WRITE;
DELETE FROM `asset2`.`user`;
INSERT INTO `asset2`.`user` (`id`,`rid`,`ogid`,`name`,`pwd`,`sex`,`birth`,`phone`,`email`,`logintime`,`loginip`,`crtm`,`mdtm`) VALUES (1, NULL, NULL, 'admin', '123456', 2, '2018-09-17', '15813342257', '332039038@qq.com', '2022-05-14 11:26:09', '0:0:0:0:0:0:0:1', '2018-09-17 00:30:12', '2018-09-17 00:36:53'),(2, NULL, NULL, 'tom', '123456', 1, '2023-05-01', '13312345014', 'admin@ossjk.cn', NULL, NULL, '2022-05-14 09:26:45', '2022-05-14 09:26:45');
UNLOCK TABLES;
COMMIT;
