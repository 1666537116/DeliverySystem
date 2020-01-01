/*
 Navicat Premium Data Transfer

 Source Server         : mybatis
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : deliverysystem

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 30/12/2019 09:05:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, '梁虔硕', '96E79218965', '1666537116@qq.com', '17673370595');
INSERT INTO `user` VALUES (5, '李祥', '96E79218965', '1666537116@qq.com', '1767777777');
INSERT INTO `user` VALUES (6, '李翔', '96E79218965', '1746493811@qq.com', '1767777777');
INSERT INTO `user` VALUES (7, 'wangli', '96E79218965', '1746493811@qq.com', '1767777777');

SET FOREIGN_KEY_CHECKS = 1;
