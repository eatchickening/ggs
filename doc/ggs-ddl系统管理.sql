-- 系统用户通知表

DROP  TABLE  IF EXISTS user_notice;
CREATE TABLE `user_notice` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `account` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户账号',
    `notice_id` int(11) DEFAULT NULL COMMENT '通知id',
    `status` int(1) DEFAULT NULL COMMENT '0未读 1已读',
    PRIMARY KEY (`id`),
    KEY `idx_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户通知表';

-- 通知信息表
DROP  TABLE  IF EXISTS notice;
CREATE TABLE `notice` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知id',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `range` varchar(50) DEFAULT NULL COMMENT '范围',
    `comment` varchar(50) DEFAULT NULL COMMENT '内容',
    PRIMARY KEY (`id`),
    KEY `idx_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知信息表';