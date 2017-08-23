-- 用户表
CREATE TABLE `user_info` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `account` varchar(30) NOT NULL COMMENT '登录账户	',
    `username` varchar(30) NOT NULL COMMENT '用户名',
    `password` varchar(32) DEFAULT NULL COMMENT '密码',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
    `areacode` varchar(50) DEFAULT NULL COMMENT '区域编码',
    `departcode` varchar(50) DEFAULT NULL COMMENT '部门编码',
    `postcode` varchar(50) DEFAULT NULL COMMENT '岗位编码',
    `organcode` varchar(50) DEFAULT NULL COMMENT '机构编码',
    `create_account` varchar(30) DEFAULT NULL COMMENT '创建人账号',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '数据更新时间',
    `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除：0-未删除；1-已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户'
;