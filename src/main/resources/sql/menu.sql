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

 Date: 30/12/2019 09:05:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `me_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品表id',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_estonian_ci NULL DEFAULT NULL COMMENT '菜名',
  `menu_price` int(11) NULL DEFAULT NULL COMMENT '价格',
  `menu_num` int(11) NULL DEFAULT NULL COMMENT '销售量',
  `comment` int(11) NULL DEFAULT NULL COMMENT '累计评论数',
  `merchants_id` int(11) NULL DEFAULT NULL COMMENT '商家id',
  `pictureurl` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品图片路径',
  PRIMARY KEY (`me_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (6, '鹌鹑蛋', 6, 0, 0, 9, 't1.jpg');
INSERT INTO `menu` VALUES (7, '火腿', 4, 0, 0, 9, 't2.jpg');
INSERT INTO `menu` VALUES (8, '毛肚', 8, 0, 0, 9, 't3.jpg');
INSERT INTO `menu` VALUES (9, '牛肉', 10, 0, 0, 9, 't4.jpg');
INSERT INTO `menu` VALUES (10, '猪肉', 8, 0, 0, 9, 't5.jpg');
INSERT INTO `menu` VALUES (11, '羊肉', 9, 0, 0, 9, 't6.jpg');

SET FOREIGN_KEY_CHECKS = 1;
