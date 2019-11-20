

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `age` int(11) NOT NULL COMMENT '年龄',
  `ctm` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '大王', '18', '2019-07-06 17:46:51');
INSERT INTO `user` VALUES ('2', '二狗', '19', '2019-07-07 17:46:57');
INSERT INTO `user` VALUES ('3', '张三', '20', '2019-07-08 17:46:59');
INSERT INTO `user` VALUES ('4', '李四', '21', '2019-07-09 17:47:04');
INSERT INTO `user` VALUES ('5', '王五', '22', '2019-07-16 17:47:06');
INSERT INTO `user` VALUES ('6', '陆六', '23', '2019-07-26 17:47:08');
