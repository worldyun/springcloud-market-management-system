/*
 Navicat Premium Data Transfer

 Source Server         : Market
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : worldyun.xyz:3306
 Source Schema         : market

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/07/2020 10:41:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for market_user
-- ----------------------------
DROP TABLE IF EXISTS `market_user`;
CREATE TABLE `market_user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别(1为男，2为女)',
  `birth` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `user_type` int(11) NULL DEFAULT NULL COMMENT '用户类型（1 系统管理员 2 经理 3 普通员工 ）',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除（0为保留，1为删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of market_user
-- ----------------------------
INSERT INTO `market_user` VALUES ('1277441137753186306', 'WorldYun', '123123', '王玉玺', 1, '2020-01-01 00:00:00', 1, '2020-06-29 11:17:56', '2020-06-29 11:17:56', 0);
INSERT INTO `market_user` VALUES ('1277443735189069825', 'zhangsan', '123123', '张三', 1, '2020-01-01 00:00:00', 2, '2020-06-29 11:28:15', '2020-06-29 11:28:15', 0);
INSERT INTO `market_user` VALUES ('1277445006881157122', 'zhangsan', '123123', '张三', 1, '2020-01-01 00:00:00', 2, '2020-06-29 11:33:18', '2020-06-29 11:33:18', 0);
INSERT INTO `market_user` VALUES ('1277445038636232705', 'lisi', '******', '李四', 2, '2020-01-01 00:00:00', 1, '2020-06-29 11:33:26', '2020-06-29 15:08:49', 0);
INSERT INTO `market_user` VALUES ('1277445042071367682', 'zhangsan', '123123', '张三', 1, '2020-01-01 00:00:00', 1, '2020-06-29 11:33:26', '2020-06-29 11:33:26', 0);
INSERT INTO `market_user` VALUES ('1277445044562784258', 'zhangsan', '123123', '张三', 2, '2020-01-01 00:00:00', 3, '2020-06-29 11:33:27', '2020-06-29 11:33:27', 0);
INSERT INTO `market_user` VALUES ('1277478778531999745', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:30', '2020-06-29 13:47:30', 0);
INSERT INTO `market_user` VALUES ('1277478785955917825', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:32', '2020-06-29 13:47:32', 0);
INSERT INTO `market_user` VALUES ('1277478787759468545', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:32', '2020-06-29 13:47:32', 0);
INSERT INTO `market_user` VALUES ('1277478788891930625', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:32', '2020-06-29 13:47:32', 0);
INSERT INTO `market_user` VALUES ('1277478789600768002', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:33', '2020-06-29 13:47:33', 0);
INSERT INTO `market_user` VALUES ('1277478790393491457', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:33', '2020-06-29 13:47:33', 0);
INSERT INTO `market_user` VALUES ('1277478791093940225', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:33', '2020-06-29 13:47:33', 0);
INSERT INTO `market_user` VALUES ('1277478791794388994', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:33', '2020-06-29 13:47:33', 0);
INSERT INTO `market_user` VALUES ('1277478792536780801', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:33', '2020-06-29 13:47:33', 0);
INSERT INTO `market_user` VALUES ('1277478793262395394', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:33', '2020-06-29 13:47:33', 0);
INSERT INTO `market_user` VALUES ('1277478793950261249', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:34', '2020-06-29 13:47:34', 0);
INSERT INTO `market_user` VALUES ('1277478794684264449', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:34', '2020-06-29 13:47:34', 0);
INSERT INTO `market_user` VALUES ('1277478795393101825', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:34', '2020-06-29 13:47:34', 0);
INSERT INTO `market_user` VALUES ('1277478796059996162', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:34', '2020-06-29 13:47:34', 0);
INSERT INTO `market_user` VALUES ('1277478796689141761', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:34', '2020-06-29 13:47:34', 0);
INSERT INTO `market_user` VALUES ('1277478797385396226', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:34', '2020-06-29 13:47:34', 0);
INSERT INTO `market_user` VALUES ('1277478798094233602', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:35', '2020-06-29 13:47:35', 0);
INSERT INTO `market_user` VALUES ('1277478798811459586', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:35', '2020-06-29 13:47:35', 0);
INSERT INTO `market_user` VALUES ('1277478799520296961', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:35', '2020-06-29 13:47:35', 0);
INSERT INTO `market_user` VALUES ('1277478800216551426', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:35', '2020-06-29 13:47:35', 0);
INSERT INTO `market_user` VALUES ('1277478800904417281', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:35', '2020-06-29 13:47:35', 0);
INSERT INTO `market_user` VALUES ('1277478801613254658', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:35', '2020-06-29 13:47:35', 0);
INSERT INTO `market_user` VALUES ('1277478802301120513', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478802959626241', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478803655880705', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478804339552257', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478805069361154', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478805740449794', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478806352818177', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:36', '2020-06-29 13:47:36', 0);
INSERT INTO `market_user` VALUES ('1277478807065849858', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:37', '2020-06-29 13:47:37', 0);
INSERT INTO `market_user` VALUES ('1277478807736938497', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:37', '2020-06-29 13:47:37', 0);
INSERT INTO `market_user` VALUES ('1277478808454164482', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:37', '2020-06-29 13:47:37', 0);
INSERT INTO `market_user` VALUES ('1277478809104281601', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:37', '2020-06-29 13:47:37', 0);
INSERT INTO `market_user` VALUES ('1277478809800536065', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:37', '2020-06-29 13:47:37', 0);
INSERT INTO `market_user` VALUES ('1277478810563899394', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:38', '2020-06-29 13:47:38', 0);
INSERT INTO `market_user` VALUES ('1277478811432120321', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:38', '2020-06-29 13:47:38', 0);
INSERT INTO `market_user` VALUES ('1277478812082237441', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:38', '2020-06-29 13:47:38', 0);
INSERT INTO `market_user` VALUES ('1277478812736548865', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:38', '2020-06-29 13:47:38', 0);
INSERT INTO `market_user` VALUES ('1277478813424414721', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:38', '2020-06-29 13:47:38', 0);
INSERT INTO `market_user` VALUES ('1277478814112280578', 'string', '******', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:38', '2020-06-29 17:53:21', 0);
INSERT INTO `market_user` VALUES ('1277478814800146434', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:39', '2020-06-29 13:47:39', 0);
INSERT INTO `market_user` VALUES ('1277478815467040770', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:39', '2020-06-29 13:47:39', 1);
INSERT INTO `market_user` VALUES ('1277478816050049026', 'string', 'string', 'HAHA', 1, '2020-01-01 00:00:00', 2, '2020-06-29 13:47:39', '2020-06-29 13:47:39', 1);
INSERT INTO `market_user` VALUES ('1277494804950777857', 'wangwu', '1221212', '王五', 2, '2020-06-01 00:00:00', 2, '2020-06-29 14:51:11', '2020-06-29 14:51:11', 0);
INSERT INTO `market_user` VALUES ('1277498442226053122', 'zhaoliu', '******', '赵六', 2, '2019-06-03 00:00:00', 2, '2020-06-29 15:05:38', '2020-06-29 15:05:52', 0);
INSERT INTO `market_user` VALUES ('1277499571169112066', NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-29 15:10:07', '2020-06-29 15:10:07', 1);
INSERT INTO `market_user` VALUES ('1277503068933423106', 'sasal', '******', '沙拉', 2, '2020-06-01 00:00:00', 1, '2020-06-29 15:24:01', '2020-07-02 10:28:31', 0);

SET FOREIGN_KEY_CHECKS = 1;
