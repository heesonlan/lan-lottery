
--  奖项和奖品表
CREATE TABLE `t_lottery_awards` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `topic` varchar(255) DEFAULT NULL,
    `awards` varchar(1000) DEFAULT NULL,
    `prize` varchar(1000) DEFAULT NULL,
    `quantity` int(11) DEFAULT NULL,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `creator` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 参与抽奖人员表
CREATE TABLE `t_lottery_user` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `user_name` varchar(255) DEFAULT NULL,
      `real_name` varchar(255) DEFAULT NULL,
      `work_no` varchar(255) DEFAULT NULL,
      `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
      `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
      `topic` varchar(255) DEFAULT NULL,
      `o3` varchar(100) DEFAULT NULL,
      `o4` varchar(100) DEFAULT NULL,
      `o5` varchar(100) DEFAULT NULL,
      `city` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 抽奖结果表
CREATE TABLE `t_lottery_rel` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `user_id` int(11) DEFAULT NULL,
     `user_name` varchar(255) DEFAULT NULL,
     `awards_id` int(11) DEFAULT NULL,
     `awards` varchar(1000) DEFAULT NULL,
     `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
     `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
     `topic` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 插入人员
INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user01', '张三', 'L1001', '总部', '科技部', '安可佳信息部', '黄山');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user02', '李四', 'L1002', '总部', '科技部', '安可佳信息部', '黄山');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user03', '胡可林', 'L1003', '总部', '科技部', '安可佳信息部','黄山');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user04', '张飞', 'L1004', '琳琅支部', '管理服务', '多店管理部', '黑龙江');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user05', '张翼德', 'L1005', '琳琅支部', '管理服务', '多店管理部', '黑龙江');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user06', '赵云', 'L1006', '琳琅支部', '管理服务', '多店管理部', '黑龙江');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user07', '马汉', 'L1007', '琳琅支部', '管理服务', '多店管理部', '黑龙江');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user08', '展昭', 'L1008', '甘南销售部', '安可欣销售', '', '潮江');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user9', '司马蒙戈', 'L1009', '甘南销售部', '安可欣销售', '', '潮江');

INSERT INTO t_lottery_user (user_name, real_name, work_no, o3, o4, o5, city)
VALUES('user10', '悍将彪蛮', 'L1010', '甘南销售部', '安可欣销售', '', '潮江');
