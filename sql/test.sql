CREATE DATABASE IF NOT EXISTS wotss /*生成数据库*/
DROP DATABASE IF EXISTS wotss /*删除数据库*/ 
USE `school` /*使用（切换）数据库，当名字是某个关键字时使用`` */
SHOW DATABASES;/*查看所有的数据库*/

USE school;
-- 一般表的名称 和字段尽量使用``括起来，避免和关键字冲突
-- AUTO_INCREMENT 表示自增
-- 在创建表的语句块内，所有的语句后面加上,最后一条可以不加
-- 在创建表的最后设置主键PRIMARY KEY(`id`)
-- 在括号后加上表的属性设置（引擎，默认编码，校对可选）
CREATE TABLE IF NOT EXISTS `studentdd` (
	`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学员id',
	`name` VARCHAR(20) NOT NULL DEFAULT '匿名' COMMENT '姓名',
	`age` INT(3) NOT NULL COMMENT '年龄',
	`password` VARCHAR(20) NOT NULL DEFAULT '123' COMMENT '密码',
	`sex` VARCHAR(2) NOT NULL COMMENT '性别',
	`birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
	`address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
	`email` VARCHAR(50) DEFAULT NULL COMMENT '电子邮箱',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

SHOW CREATE DATABASE `school` -- 查看创建数据库的语句
SHOW CREATE TABLE studentdd -- 查看表的定义语句
DESC studentdd -- 显示表的结构

-- 修改表名
ALTER TABLE `studentdd` RENAME AS `student1`
-- 增加表的字段，后面可跟列属性
ALTER TABLE `student1` ADD ages INT(22) COMMENT'修改后的年龄'
-- 修改表的字段（change更名，更名的同时可以修改约束）
ALTER TABLE `student1` CHANGE ages age1 VARCHAR(3)
-- 修改表的字段（modify 修改约束）
ALTER TABLE `student1` MODIFY age1 INT(1)
-- 删除表的字段
ALTER TABLE `student1` DROP age1
-- 删除表
DROP TABLE IF EXISTS `student1`


-- 测试jdbc

CREATE DATABASE jdbcStudy CHARACTER SET utf8 COLLATE utf8_general_ci;

USE jdbcStudy;

CREATE TABLE users(
	id INT PRIMARY KEY,
	`name` VARCHAR(40),
	`password` VARCHAR(40),
	email VARCHAR(60),
	birthday DATE
);

INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(1,'zhangshan','123456','zs@sinal.com','1980-12-04'),
	(2,'lisi','123456','lisi@sinal.com','1981-12-04'),
	(3,'wangwu','123456','wangwu@sinal.com','1979-12-04');
