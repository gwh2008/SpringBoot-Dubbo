/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : tcc

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 30/11/2019 17:39:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hmily_account_service
-- ----------------------------
DROP TABLE IF EXISTS `hmily_account_service`;
CREATE TABLE `hmily_account_service`  (
  `trans_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `target_class` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `target_method` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `confirm_method` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cancel_method` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `retried_count` tinyint(4) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `last_time` datetime(0) NOT NULL,
  `version` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `invocation` longblob NULL,
  `role` tinyint(4) NOT NULL,
  `pattern` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`trans_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hmily_order_service
-- ----------------------------
DROP TABLE IF EXISTS `hmily_order_service`;
CREATE TABLE `hmily_order_service`  (
  `trans_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `target_class` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `target_method` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `confirm_method` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cancel_method` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `retried_count` tinyint(4) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `last_time` datetime(0) NOT NULL,
  `version` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `invocation` longblob NULL,
  `role` tinyint(4) NOT NULL,
  `pattern` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`trans_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
