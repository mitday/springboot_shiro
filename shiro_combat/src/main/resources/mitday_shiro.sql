/*
Navicat MySQL Data Transfer

Source Server         : mitday
Source Server Version : 50718
Source Host           : 192.168.137.1:3306
Source Database       : mitday_shiro

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-05-11 16:56:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `url` varchar(128) DEFAULT NULL COMMENT '接口路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'video_update', '/api/video/update');
INSERT INTO `permission` VALUES ('2', 'video_delete', '/api/video/delete');
INSERT INTO `permission` VALUES ('3', 'video_add', '/api/video/add');
INSERT INTO `permission` VALUES ('4', 'order_list', '/api/order/list');
INSERT INTO `permission` VALUES ('5', 'user_list', '/api/user/list');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `description` varchar(64) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '普通管理员');
INSERT INTO `role` VALUES ('2', 'root', '超级管理员');
INSERT INTO `role` VALUES ('3', 'editor', '审核人员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '3', '1');
INSERT INTO `role_permission` VALUES ('2', '3', '2');
INSERT INTO `role_permission` VALUES ('3', '3', '3');
INSERT INTO `role_permission` VALUES ('4', '2', '1');
INSERT INTO `role_permission` VALUES ('5', '2', '2');
INSERT INTO `role_permission` VALUES ('6', '2', '3');
INSERT INTO `role_permission` VALUES ('7', '2', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '二当家小D', '4280d89a5a03f812751f504cc10ee8a5', null, null);
INSERT INTO `user` VALUES ('2', '大当家', '5927c5d64d94a5786f90003aa26d0159', null, null);
INSERT INTO `user` VALUES ('3', 'jack', 'd022646351048ac0ba397d12dfafa304', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `remarks` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '3', '1', '二当家小D是editor');
INSERT INTO `user_role` VALUES ('2', '1', '3', 'jack是admin');
INSERT INTO `user_role` VALUES ('3', '2', '3', 'jack是root');
INSERT INTO `user_role` VALUES ('4', '3', '3', 'jack是editor');
INSERT INTO `user_role` VALUES ('5', '1', '2', '大当家是admin');
INSERT INTO `user_role` VALUES ('6', '1', '1', null);
INSERT INTO `user_role` VALUES ('7', '2', '1', null);
