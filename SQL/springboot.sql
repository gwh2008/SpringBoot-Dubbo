/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 28/11/2019 11:51:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `ctm` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '大王', 18, '2019-07-06 17:46:51', '1');
INSERT INTO `user` VALUES (2, '二狗', 19, '2019-07-07 17:46:57', '1');
INSERT INTO `user` VALUES (3, '张三', 20, '2019-07-08 17:46:59', '1');
INSERT INTO `user` VALUES (4, '李四', 21, '2019-07-09 17:47:04', '1');
INSERT INTO `user` VALUES (5, '王五', 22, '2019-07-16 17:47:06', '1');
INSERT INTO `user` VALUES (6, '陆六', 23, '2019-07-26 17:47:08', '1');

SET FOREIGN_KEY_CHECKS = 1;
