/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : guodong

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2014-12-20 19:30:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `acti_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `acti_user_id` bigint(18) NOT NULL,
  `acti_fath_id` bigint(18) DEFAULT NULL,
  `acti_name` varchar(50) DEFAULT NULL,
  `acti_starttime` datetime DEFAULT NULL,
  `acti_endtime` datetime DEFAULT NULL,
  `acti_summary` varchar(400) DEFAULT NULL,
  `acti_content` varchar(2000) DEFAULT NULL,
  `acti_newtime` datetime DEFAULT NULL,
  `acti_address` varchar(50) DEFAULT NULL,
  `acti_poster` varchar(80) DEFAULT NULL,
  `acti_type` varchar(30) DEFAULT NULL,
  `acti_otherpic1` varchar(30) DEFAULT NULL,
  `acti_otherpic2` varchar(30) DEFAULT NULL,
  `acti_otherpic3` varchar(30) DEFAULT NULL,
  `acti_twocode` varchar(50) DEFAULT NULL,
  `acti_support` int(9) DEFAULT NULL COMMENT '点赞数',
  `acti_join` int(6) DEFAULT NULL COMMENT '参与人数',
  PRIMARY KEY (`acti_id`),
  KEY `acti_user_id` (`acti_user_id`),
  KEY `acti_fath_id` (`acti_fath_id`),
  CONSTRAINT `acti_fath_id` FOREIGN KEY (`acti_fath_id`) REFERENCES `activity` (`acti_id`),
  CONSTRAINT `acti_user_id` FOREIGN KEY (`acti_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '1', null, '都市神经喜剧《怀孩不遇》 ', '2014-12-19 00:09:59', '2014-12-26 00:10:12', '这样的故事可能发生在远在大洋彼岸的纽约，也可能发生在直抵非洲南端的好望角；这样的故事在繁华的上海每天都在上演，这样的故事在各角落的乡村也一直回荡。张小娴说过，“爱从来就是一件百转千回的事情”，其实，遇见宝宝，才是件千回百转的事。', '这里是活动内容', '2014-12-09 00:11:00', '长沙理工大学报告厅', 'http://img3.douban.com/view/event_poster/raw/public/dc652fcc0e0351c.jpg', '辩论', null, null, null, 'dsfsf234sdfsgr', '10', '1');
INSERT INTO `activity` VALUES ('2', '1', null, '《爱情是一盘自制卡带》星乐原短剧展演第一辑', '2014-12-11 00:45:19', '2014-12-13 00:45:23', '带你回到最初在电脑下MP3的日子，回到因为CD上被打掉了两首歌忧伤不已的日子，回到黑胶在唱机唱针下嘶嘶作响的日子，回到费尽周折才录好一盘自制卡带的日子。每个人的自制卡带都不会重复。听到这首歌，我们却都想找出自己最初的那台录音机和随身听。 ', '这里是朝闻道演讲比赛内容2', '2014-12-11 00:45:43', '这里朝闻道演讲比赛地址', 'http://img3.douban.com/view/event_poster/raw/public/ec4fa1b472aae85.jpg', '演讲', null, null, null, 'as345atrtet', '45', '12');
INSERT INTO `activity` VALUES ('3', '1', '1', '琴意浓浓——德尼•成浩情人节吉他独奏音乐会 ', '2014-12-19 00:09:59', '2014-12-26 00:10:12', '德尼•成浩于2005年以欧洲音乐厅组织“明日之星”的身份在纽约卡内基音乐厅初次登台演出。自14岁在比利时国家“青年人才”竞赛中获得一等奖之后，丹尼斯•成浩的足迹遍布了世界上最主要的舞台，包括阿姆斯特丹音乐厅，维也纳金色大厅，萨尔斯堡莫扎特音乐厅，伯明翰交响乐大厅，斯德哥尔摩音乐厅，雅典中央大厅，布鲁塞尔美术宫，巴黎高等音乐学院，科隆爱乐厅，柏林爱乐厅等。', '这里是思齐杯活动内容', '2014-12-09 00:11:00', '长沙理工大学报告厅', 'http://img3.douban.com/view/event_poster/raw/public/b6d8d72e4348c0b.jpg', '辩论', null, null, null, 'dsfsf234sdfsgr', '1', null);
INSERT INTO `activity` VALUES ('4', '1', null, '爱情喜剧《超完美情人》 ', '2014-12-20 00:45:19', '2014-12-24 00:45:23', '你想象中的完美情人什么样子？蝙蝠侠？蜘蛛侠，还是吸血鬼？他们都弱爆了！今年圣诞前夕，快来收获属于你的圣诞礼物－超完美情人，让我们为爱疯癫一次！ ', '这里是演讲比赛内容2', '2014-12-12 00:45:43', '这里是演讲比赛地址', 'http://img3.douban.com/view/event_poster/raw/public/12051df39095492.jpg', '演讲', null, null, null, 'tdsgsdgsdge', '12', '10');
INSERT INTO `activity` VALUES ('5', '2', null, '骆以军、梁文道：给下一轮太平盛世的女儿（需报名）', '2014-12-18 00:45:19', '2014-12-19 00:45:23', '女儿，人类最美好的身份，爱、文明、救赎的原型，文学史上经久不衰的亘古主题——红楼梦的十二金钗，雷峰塔下的张.....', '这里是四星大赛内容2', '2014-12-13 00:45:43', '这里是四星大赛地址', 'http://img3.douban.com/view/event_poster/raw/public/be948c05926ebef.jpg', '歌唱', null, null, null, 'afgssd345dgfat', '1', '1');
INSERT INTO `activity` VALUES ('6', '2', null, '「今夜我在德令哈」杭盖乐队2015新年音乐会 ', '2014-12-18 00:45:19', '2014-12-23 00:45:23', '很多人都是通过海子的诗认识“德令哈”的，“今夜我在德令哈，姐姐，今夜我不关心人类，我只想你”。“德令哈”既是一个城市，也像是坐落在远方充满诗意的孤独边境，远离人类，神秘而且荒芜。“德令哈”本为蒙语，意为“世界”，包罗世间万物，海子纯粹的情感在德令哈化作一支深深的思念。 ', '这里是侦探寻宝大赛内容2', '2014-12-16 00:45:43', '侦探寻宝大赛地址', 'http://img3.douban.com/view/event_poster/raw/public/0ddb86c0be6508d.jpg', '寻宝', null, null, null, 'gsdfgas345', '2', '2');
INSERT INTO `activity` VALUES ('7', '1', null, '日本传统乐器组合WASABI新年音乐公演【北京站】', '2014-12-16 00:00:00', '2014-12-26 00:00:00', '2015年新年伊始，新•纯邦乐组合WASABI将来到中国北京及上海两个城市，为大家带来东瀛古韵与现代旋律的完美共鸣。除了演出之外还会为大家带来近距离感受和乐器魅力的工作坊（需报名）', '这里是活动内容', '2014-12-16 16:56:41', '这里是地址', 'http://img3.douban.com/view/event_poster/raw/public/31b7a750952ed2e.jpg', '这里是类型', null, null, null, null, null, '1');
INSERT INTO `activity` VALUES ('8', '1', null, '2014Nunki圣诞联名全国大串联之北京站-❉❉❉', '2014-12-16 00:00:00', '2014-12-26 00:00:00', ':*:’☆.:*:’★圣’:* .:*:’☆.:*:’★’:* .:*:’☆.诞:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:快’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’乐★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:大*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆家.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* .:*:’☆.:*:’★’:* ', '这里是活动内容', '2014-12-20 19:04:01', '这里是地址', 'http://img3.douban.com/view/event_poster/raw/public/ed3c6fa7ed0b438.jpg', '这里是类型', null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admi_id` int(11) NOT NULL AUTO_INCREMENT,
  `admi_name` varchar(20) DEFAULT NULL,
  `admi_pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `announce`
-- ----------------------------
DROP TABLE IF EXISTS `announce`;
CREATE TABLE `announce` (
  `anno_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `anno_content` varchar(2000) DEFAULT NULL,
  `anno_property` int(1) DEFAULT NULL,
  `anno_time` datetime DEFAULT NULL,
  PRIMARY KEY (`anno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announce
-- ----------------------------

-- ----------------------------
-- Table structure for `au`
-- ----------------------------
DROP TABLE IF EXISTS `au`;
CREATE TABLE `au` (
  `au_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `au_acti_id` bigint(18) NOT NULL,
  `au_user_id` bigint(18) NOT NULL,
  `au_eval_score` double DEFAULT NULL,
  `au_eval_content` varchar(2000) DEFAULT NULL,
  `au_eval_time` datetime DEFAULT NULL,
  `au_eval_support` int(1) DEFAULT NULL,
  `au_arrive` int(1) DEFAULT NULL,
  `au_read` int(1) DEFAULT NULL,
  `au_comment` int(1) DEFAULT NULL COMMENT '是否评价',
  PRIMARY KEY (`au_id`),
  KEY `au_acti_id` (`au_acti_id`),
  KEY `au_user_id` (`au_user_id`),
  CONSTRAINT `au_acti_id` FOREIGN KEY (`au_acti_id`) REFERENCES `activity` (`acti_id`),
  CONSTRAINT `au_user_id` FOREIGN KEY (`au_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of au
-- ----------------------------
INSERT INTO `au` VALUES ('1', '5', '1', null, null, null, '1', null, null, '0');
INSERT INTO `au` VALUES ('2', '6', '1', '3.5', '勉勉强强还行', '2014-12-25 15:04:58', '1', '1', null, '1');
INSERT INTO `au` VALUES ('3', '6', '3', '4.5', '很好哦', '2014-12-24 15:06:24', '1', '1', null, '1');

-- ----------------------------
-- Table structure for `discuss`
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `disc_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `disc_acti_id` bigint(18) NOT NULL,
  `disc_user_send_id` bigint(18) NOT NULL,
  `disc_user_rece_id` bigint(18) NOT NULL,
  `disc_user_area_id` bigint(18) NOT NULL COMMENT '对应一块评论信息的标志id',
  `disc_content` varchar(1000) DEFAULT NULL,
  `disc_time` datetime DEFAULT NULL,
  `disc_rece_read` int(1) DEFAULT NULL,
  PRIMARY KEY (`disc_id`),
  KEY `disc_acti_id` (`disc_acti_id`),
  KEY `disc_user_send_id` (`disc_user_send_id`),
  KEY `disc_user_rece_id` (`disc_user_rece_id`),
  CONSTRAINT `disc_acti_id` FOREIGN KEY (`disc_acti_id`) REFERENCES `activity` (`acti_id`),
  CONSTRAINT `disc_user_rece_id` FOREIGN KEY (`disc_user_rece_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `disc_user_send_id` FOREIGN KEY (`disc_user_send_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discuss
-- ----------------------------

-- ----------------------------
-- Table structure for `idea`
-- ----------------------------
DROP TABLE IF EXISTS `idea`;
CREATE TABLE `idea` (
  `idea_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `idea_user_id` bigint(18) NOT NULL,
  `idea_title` varchar(50) DEFAULT NULL,
  `idea_content` varchar(1000) DEFAULT NULL,
  `idea_time` datetime DEFAULT NULL,
  `idea_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`idea_id`),
  KEY `idea_user_id` (`idea_user_id`),
  CONSTRAINT `idea_user_id` FOREIGN KEY (`idea_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idea
-- ----------------------------
INSERT INTO `idea` VALUES ('1', '2', '合作举办辩论赛', '这里是合作举办辩论赛的内容', '2014-12-11 22:51:25', '0');

-- ----------------------------
-- Table structure for `letter`
-- ----------------------------
DROP TABLE IF EXISTS `letter`;
CREATE TABLE `letter` (
  `lett_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `lett_user_send_id` bigint(18) NOT NULL,
  `lett_user_rece_id` bigint(18) NOT NULL,
  `lett_content` varchar(1000) DEFAULT NULL,
  `lett_time` datetime DEFAULT NULL,
  `lett_rece_read` int(1) DEFAULT NULL,
  PRIMARY KEY (`lett_id`),
  KEY `lett_user_send_id` (`lett_user_send_id`),
  KEY `lett_user_rece_id` (`lett_user_rece_id`),
  CONSTRAINT `lett_user_rece_id` FOREIGN KEY (`lett_user_rece_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `lett_user_send_id` FOREIGN KEY (`lett_user_send_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of letter
-- ----------------------------

-- ----------------------------
-- Table structure for `partner`
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
  `part_id` bigint(18) NOT NULL,
  `part_idea_id` bigint(18) DEFAULT NULL,
  `part_user_id` bigint(18) DEFAULT NULL,
  `part_user_success` int(1) DEFAULT NULL,
  PRIMARY KEY (`part_id`),
  KEY `part_idea_id` (`part_idea_id`),
  KEY `part_user_id` (`part_user_id`),
  CONSTRAINT `part_idea_id` FOREIGN KEY (`part_idea_id`) REFERENCES `idea` (`idea_id`),
  CONSTRAINT `part_user_id` FOREIGN KEY (`part_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of partner
-- ----------------------------

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `ques_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `ques_user_send_id` bigint(18) NOT NULL,
  `ques_user_rece_id` bigint(18) NOT NULL,
  `ques_idea_id` bigint(18) NOT NULL,
  `ques_content` varchar(1000) DEFAULT NULL,
  `ques_time` datetime DEFAULT NULL,
  `ques_rece_read` int(1) DEFAULT NULL,
  PRIMARY KEY (`ques_id`),
  KEY `ques_user_send_id` (`ques_user_send_id`),
  KEY `ques_user_rece_id` (`ques_user_rece_id`),
  KEY `ques_idea_id` (`ques_idea_id`),
  CONSTRAINT `ques_idea_id` FOREIGN KEY (`ques_idea_id`) REFERENCES `idea` (`idea_id`),
  CONSTRAINT `ques_user_rece_id` FOREIGN KEY (`ques_user_rece_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `ques_user_send_id` FOREIGN KEY (`ques_user_send_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(18) NOT NULL AUTO_INCREMENT,
  `user_university` varchar(30) DEFAULT NULL,
  `user_academy` varchar(30) DEFAULT NULL,
  `user_cardid` varchar(20) DEFAULT NULL,
  `user_password` varchar(16) DEFAULT NULL,
  `user_startyear` varchar(4) DEFAULT NULL,
  `user_nickname` varchar(20) DEFAULT NULL,
  `user_truename` varchar(20) DEFAULT NULL,
  `user_identitycard` varchar(18) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_picture` varchar(30) DEFAULT NULL,
  `user_property` int(1) DEFAULT NULL COMMENT '是学生还是组织',
  `user_anno_unread` varchar(100) DEFAULT NULL COMMENT '未读的公告',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, null, '2012500080423', '123456', null, '潘海南', null, null, null, null, '1', null);
INSERT INTO `user` VALUES ('2', null, null, '2012500080425', '123456', null, '彭jilin', null, null, null, null, '0', null);
INSERT INTO `user` VALUES ('3', null, null, '201250080428', '123456', null, 'geenli', null, null, null, null, '1', null);
