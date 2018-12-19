/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : vim

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-19 20:12:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for im_chat_group
-- ----------------------------
DROP TABLE IF EXISTS `im_chat_group`;
CREATE TABLE `im_chat_group` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '群名称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '群头像',
  `master` varchar(64) DEFAULT NULL COMMENT '群主',
  `remarks` varchar(600) DEFAULT NULL COMMENT '说明',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群';

-- ----------------------------
-- Records of im_chat_group
-- ----------------------------
INSERT INTO `im_chat_group` VALUES ('b0a0b152e202498781d5efedfb742a11', '幸福一家', null, null, null, null, null, null, null, null);
INSERT INTO `im_chat_group` VALUES ('e83018ca92cb441aa93484af2deb8456', 'V-IM 讨论', '/img/group-img.png', null, null, null, null, null, null, null);
INSERT INTO `im_chat_group` VALUES ('f1bf3b60caca4569a45a3c5d19cccdec', '幸福一家', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for im_chat_group_user
-- ----------------------------
DROP TABLE IF EXISTS `im_chat_group_user`;
CREATE TABLE `im_chat_group_user` (
  `chat_group_id` varchar(64) NOT NULL COMMENT '群id',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `create_date` datetime DEFAULT NULL COMMENT '入群时间',
  PRIMARY KEY (`chat_group_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群';

-- ----------------------------
-- Records of im_chat_group_user
-- ----------------------------
INSERT INTO `im_chat_group_user` VALUES ('e83018ca92cb441aa93484af2deb8456', '0f38e2b3dcee4cfc8abd30fb23f3c947', '2018-12-09 16:33:24');
INSERT INTO `im_chat_group_user` VALUES ('e83018ca92cb441aa93484af2deb8456', '2e5b625817244a0d94c67e8f64aff7f7', '2018-12-09 22:17:32');
INSERT INTO `im_chat_group_user` VALUES ('e83018ca92cb441aa93484af2deb8456', 'c69787c134b04d6f8127d512c269360f', '2018-10-28 15:53:14');
INSERT INTO `im_chat_group_user` VALUES ('e83018ca92cb441aa93484af2deb8456', 'cb0c145a6c104497942525f8c984f9d9', '2018-10-28 15:53:14');

-- ----------------------------
-- Table structure for im_group
-- ----------------------------
DROP TABLE IF EXISTS `im_group`;
CREATE TABLE `im_group` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of im_group
-- ----------------------------
INSERT INTO `im_group` VALUES ('1048889640612864002', 'cb0c145a6c104497942525f8c984f9d9', '好基友', null, null, null, null, null, null);
INSERT INTO `im_group` VALUES ('1048889640612864003', 'cb0c145a6c104497942525f8c984f9d9', '同事', null, null, null, null, null, null);
INSERT INTO `im_group` VALUES ('1048889640612864005', 'c69787c134b04d6f8127d512c269360f', '同学', null, null, null, null, null, null);
INSERT INTO `im_group` VALUES ('53e81af2c5394bfda364dfa22b694cc8', '2e5b625817244a0d94c67e8f64aff7f7', '我的好友', '2018-12-09 22:17:32', null, '2018-12-09 22:17:32', null, '0', null);
INSERT INTO `im_group` VALUES ('daef1c04d8cd4937b2d0e1a18b8a0525', '0f38e2b3dcee4cfc8abd30fb23f3c947', '我的好友', '2018-12-09 16:33:24', null, '2018-12-09 16:33:24', null, '0', null);

-- ----------------------------
-- Table structure for im_group_user
-- ----------------------------
DROP TABLE IF EXISTS `im_group_user`;
CREATE TABLE `im_group_user` (
  `user_id` varchar(64) NOT NULL,
  `group_id` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of im_group_user
-- ----------------------------
INSERT INTO `im_group_user` VALUES ('c69787c134b04d6f8127d512c269360f', '1048889640612864002');
INSERT INTO `im_group_user` VALUES ('c69787c134b04d6f8127d512c269360f', '1048889640612864004');
INSERT INTO `im_group_user` VALUES ('cb0c145a6c104497942525f8c984f9d9', '1048889640612864005');
INSERT INTO `im_group_user` VALUES ('cb0c145a6c104497942525f8c984f9d9', '53e81af2c5394bfda364dfa22b694cc8');
INSERT INTO `im_group_user` VALUES ('cb0c145a6c104497942525f8c984f9d9', 'daef1c04d8cd4937b2d0e1a18b8a0525');
INSERT INTO `im_group_user` VALUES ('ea26903beb164011975a949553033364', '1048889640612864002');
INSERT INTO `im_group_user` VALUES ('ea26903beb164011975a949553033364', '1048889640612864004');
INSERT INTO `im_group_user` VALUES ('ea26903beb164011975a949553033364', '1048889640612864005');

-- ----------------------------
-- Table structure for im_message
-- ----------------------------
DROP TABLE IF EXISTS `im_message`;
CREATE TABLE `im_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `to_id` varchar(64) DEFAULT NULL COMMENT '接收人',
  `from_id` varchar(64) DEFAULT NULL COMMENT '发送人id',
  `send_time` bigint(20) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '类型 0单聊 1 群聊',
  `read_status` char(1) DEFAULT NULL COMMENT '1 已读 0 未读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=626 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of im_message
-- ----------------------------
INSERT INTO `im_message` VALUES ('625', 'e83018ca92cb441aa93484af2deb8456', '2e5b625817244a0d94c67e8f64aff7f7', '1544365108653', '2222222', '1', '0');

-- ----------------------------
-- Table structure for im_user
-- ----------------------------
DROP TABLE IF EXISTS `im_user`;
CREATE TABLE `im_user` (
  `id` varchar(32) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of im_user
-- ----------------------------
INSERT INTO `im_user` VALUES ('09fe0deb150b4201b7874e46eee949e6', '/img/default-user.png', 'lidamao', null, 'lidamao', null, '{bcrypt}$2a$10$W1HYNkAqdY4qYZrd3gNfY.RXA6C/fnBNnT9jZLFAHMv4LtGB43FZm', 'lidamao', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('0f38e2b3dcee4cfc8abd30fb23f3c947', '/img/default-user.png', '13610959722', null, '13610959722', null, '{bcrypt}$2a$10$kOenu401WdjPxaALCAS4m.ibJdbGQTVKxwi1iExM/H3bpTkhpNJAu', '13610959722', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('181d77486b584779b2314ce381af171e', '/img/default-user.png', '测试大侠', null, '13610959733', null, '{bcrypt}$2a$10$HF3ID2enQGGDe22cARMsj.gefIV9f7g61nPn9zwQeUaW3HZNJWO3W', '13610959733', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('2a55a9a5359e46a4908a89ac92842854', '/img/default-user.png', 'liuliu', null, 'liuliu', null, '{bcrypt}$2a$10$tFa/.qQzo2hTqKzKhRX0MO9X.sVf0m9ew6cNZONl.bb6Zx2xkFV9.', 'liuliu', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('2e5b625817244a0d94c67e8f64aff7f7', '/img/default-user.png', '阿萨德', null, '13610959766', null, '{bcrypt}$2a$10$Yfkr4GDNjiEMeQiyK1kmIe6edyZfahnnRr.lQ6v0DeoBCPLvr1UBa', '13610959766', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('2ef26d75d8b14f0ebbbbab4ccccf4062', '/img/default-user.png', 'RegisterResult', null, 'RegisterResult', null, '{bcrypt}$2a$10$yQkbazoMU/YmXq1KZMwQDeW5KupnjUraIviyjebvDJjMJZTZcrG2W', 'RegisterResult', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('329f9173ca614a35b98d740adfa857d0', '/img/user (2).png', 'liuliu1', 'liuliu1', '13699988999', 'liuliu1@163.com', '{bcrypt}$2a$10$FwocqJq0BZNdNhoLB/JtcuEZRrJEiNl/slU8UltiIiDqNzn2MAe1W', 'liuliu1', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('3d82704de6c541a19fc3f0538d9f3e42', '/img/default-user.png', 'wangba', null, 'wangba', null, '{bcrypt}$2a$10$BmrEgT3.QwDvtTPcztJyTeN03UT07h8ctiPFwUekLvZ0j8iTSECgW', 'wangba', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('4152f0fcbcf44599b716595ef859ecaf', '/img/user (2).png', 'liuliu1', 'liuliu1', '13699988999', 'liuliu1@163.com', '{bcrypt}$2a$10$OBrRPHprQnVYYTnSGPrkKeQsawrsIFtT7gVcl8N7K/xOS8iAsZM4K', 'liuliu1', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('61ded80059884a00b327a9ce2775898e', '/img/default-user.png', '赵柳', null, '111222333', null, '{bcrypt}$2a$10$mTVLqIYHuulkMy9602ZbSOs06GhGH4C1AENRxFywizwIzPnOC8e02', '111222333', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('67ded2698aee46af8254a266ea800722', '/img/default-user.png', '13610959731', null, '13610959731', null, '{bcrypt}$2a$10$jewDENgic/vPRGmksqd1wujMl5zXcFMmJKIqKWHnlRpT0gphOwsJa', '13610959731', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('7412e86ba5834ed496e82f56f2e8eaec', '/img/default-user.png', '孙子', null, 'sunba', null, '{bcrypt}$2a$10$njJg0h.cHcTsfibHCw35Me/i0gWHpPDz.50T2PqtDwOfa5sI.5n.W', 'sunba', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('89662536da7548ddb2de8e3d91317180', '/img/default-user.png', 'asdasd', null, '1895553554', null, '{bcrypt}$2a$10$wWzMef/Wv/.jSdIDKWdQB.QMZ51zowCCMDNyWUM1FjbKVbVPZWFXi', '1895553554', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('8cb63bfd67b4484cbb36d91a04baf5c7', '/img/default-user.png', 'xxxxx', null, 'xxxxx', null, '{bcrypt}$2a$10$71ADe3gnhMlCUVcu7bTqDu9gMd/oFHiwQwkEL5FmUoxoo3OczqWG.', 'xxxxx', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('97e71a05d5d2498694429bb9053e1a6e', '/img/default-user.png', '1895553551', null, '1895553551', null, '{bcrypt}$2a$10$9JbwGkNXAPDlxHUASGtygeCuBwYcTz1jir3pYqgbZgurep9.Ynb2O', '1895553551', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('c69787c134b04d6f8127d512c269360f', '/img/user (3).png', '王五', '我爱吃菜', '13699988999', 'wangwu@163.com', '{bcrypt}$2a$10$iq7DxG5KmyfaT9lLrwQcMuYm9r0AwZ9J6wdB1u4jIY2Gw8T0RKyzS', 'wangwu', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('ca0b676588d044d2839be037fcde42aa', '/img/user (2).png', 'liuliu1', 'liuliu1', '13699988999', 'liuliu1@163.com', '{bcrypt}$2a$10$beVhzB3cqb1/LvjCT4loYOgCa1iQP/DFUsKYCIfj2F8XaQPE8u2tO', 'liuliu1', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('cb0c145a6c104497942525f8c984f9d9', '/img/user (2).png', '管理员', '我爱吃肉', '13699988999', 'zhangsan@163.com', '{bcrypt}$2a$10$tcoeSq.LUagBuj6WalYUaeJjvXEI86YBDS6LVCQUfYtjoUvhHaUWC', 'zhangsan', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('d0ace68d87b94f7d815a2dec97f5ef44', '/img/user (2).png', 'zhaoliu', '我爱吃菜', '13699988999', 'wangwu@163.com', '{bcrypt}$2a$10$2QG/q6lrS1TWjjFAE2m5xeaQNpiqERytByAzE6o9s2q27D10bNqH2', 'zhaoliu', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('ea26903beb164011975a949553033364', '/img/user (1).png', '李四', '我爱吃鱼', '13699988999', 'xxx@163.com', '{bcrypt}$2a$10$SciCZuLe7JFiX5P3xhK6xey1nn.ZoVVDrAoEXZLYTkPgV25fDnoe6', 'lisi', null, null, null, null, null, null);
INSERT INTO `im_user` VALUES ('f6fbe363100942eab18f07305c8675a1', '/img/default-user.png', '13610959730', null, '13610959730', null, '{bcrypt}$2a$10$b.A/Y9r4K.52Dj9mSB0tjeTiTzT2Pw./rEH0Y5FtlhcidlxLr5CQi', '13610959730', null, null, null, null, null, null);
