/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 127.0.0.1:3306
 Source Schema         : springboot02

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 16/11/2020 15:00:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `filePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2020-09-24/1133b5fe0cb14bc0bc83a0ef01faf147.jpg', 1, '李明', 25, '北京市', 1, '2020-09-22 08:54:34');
INSERT INTO `user` VALUES ('2020-09-24/9ca93b67179e4e80b1e5f9893070f341.jpg', 3, '花花', 28, '北京市', 1, '2020-09-22 09:46:00');
INSERT INTO `user` VALUES ('2020-09-24/8eff304e8a0b4f71ba441f45a2458e64.jpg', 8, '李晓', 22, '上海市', 2, '2020-09-23 01:39:14');
INSERT INTO `user` VALUES ('2020-09-24/5c0411802d3d4e6fb02bf64326e2ee59.jpg', 10, '漏扫', 28, '上海市', 1, '2020-09-23 08:49:19');
INSERT INTO `user` VALUES ('2020-09-24/cb527f792b21405bba3ab4f5bfb6f55f.png', 11, '阿黄', 16, '成都', 1, '2020-09-24 06:49:26');
INSERT INTO `user` VALUES (NULL, 12, '立马', 33, '南京', 1, '2020-11-16 06:58:47');

SET FOREIGN_KEY_CHECKS = 1;
