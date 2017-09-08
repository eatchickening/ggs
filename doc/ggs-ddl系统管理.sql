-- 通知表


-- 已读通知表
DROP  TABLE  IF EXISTS notice_readed;
CREATE TABLE `notice_readed` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `account` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户账号',
    `notice_id` int(11) DEFAULT NULL COMMENT '通知id',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已读通知表';