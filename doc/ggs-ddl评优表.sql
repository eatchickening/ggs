
--  评优表
DROP  TABLE  IF EXISTS appraise;
CREATE TABLE appraise (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisedate varchar(20)  COMMENT '评优日期',
    appraisename varchar(200)  COMMENT '评优名称',
    appraisecode varchar(40)  COMMENT '评优编码',
    appraiselevel varchar(20)  COMMENT '评优级别',
    appraisenumber int  COMMENT '评优奖项',
    appraiseschool int  COMMENT '评优学校数量',
    appraisequota int  COMMENT '评优指标',
    operator varchar(40) COMMENT '操作人',
    organcode varchar(40) COMMENT '操作机构',
    remark varchar(500) COMMENT '备注',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评优表';


--  奖项表
DROP  TABLE  IF EXISTS awardinfo;
CREATE TABLE awardinfo (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(40)  COMMENT '所属评优编码',
    awardname varchar(200)  COMMENT '奖项名称',
    awardcode varchar(40)  COMMENT '奖项编码',
    awardlevel  varchar(20)  COMMENT '奖项级别',
    remark varchar(500) COMMENT '备注',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项表';

--  奖项学校表
DROP  TABLE  IF EXISTS award_school;
CREATE TABLE award_school (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(40)  COMMENT '所属评优编码',
    awardcode varchar(40)  COMMENT '奖项编码',
    schoolcode varchar(20)  COMMENT '学校代码',
    schoolquota int  COMMENT '学校指标',
    remark varchar(500) COMMENT '备注',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项学校表';


--  奖项班级表
DROP  TABLE  IF EXISTS award_class;
CREATE TABLE award_class (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(40)  COMMENT '所属评优编码',
    awardcode varchar(40)  COMMENT '奖项编码',
    classcode varchar(20)  COMMENT '班级代码',
    schoolcode varchar(20)  COMMENT '学校代码',
    classquota int  COMMENT '班级指标',
    remark varchar(500) COMMENT '备注',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项班级表';

--  奖项指标表
DROP  TABLE  IF EXISTS award_quota;
CREATE TABLE award_quota (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(40)  COMMENT '所属评优编码',
    awardcode varchar(40)  COMMENT '奖项编码',
    awardquota varchar(200)  COMMENT '奖项指标',
    quotacontent  varchar(200)  COMMENT '指标标准',
    remark varchar(500) COMMENT '备注',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项指标表';

--  奖项材料
DROP  TABLE  IF EXISTS award_file;
CREATE TABLE award_file (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(40)  COMMENT '所属评优编码',
    awardcode varchar(40)  COMMENT '奖项编码',
    filename varchar(200)  COMMENT '材料名称',
    filetype varchar(200)  COMMENT '材料类型',
    filepath  varchar(300)  COMMENT '材料路径',
    filedetail  varchar(300)  COMMENT '材料说明',
    remark varchar(500) COMMENT '备注',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项材料表';


--  评优活动表
DROP  TABLE  IF EXISTS Appraised_Activity;
CREATE TABLE `Appraised_Activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `activity_name` varchar(200) DEFAULT NULL COMMENT '活动名称',
    `appraise_id` bigint(20) DEFAULT NULL COMMENT '评优id',
    `begin_date` timestamp NULL DEFAULT NULL COMMENT '活动开始日期',
    `end_date` timestamp NULL DEFAULT NULL COMMENT '活动结束日期',
    `sign_End_date` timestamp NULL DEFAULT NULL COMMENT '活动报名截止日期',
    `remark` text COMMENT '活动说明',
    `activity_status` int(11) DEFAULT NULL COMMENT '活动状态 1：未开始(保留) 2进行中 3已结束',
    `creator` varchar(40) DEFAULT NULL COMMENT '创建人',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评优活动表';

--  评优活动材料
DROP  TABLE  IF EXISTS activity_file;
CREATE TABLE `activity_file` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `activity_id` bigint(20) DEFAULT NULL COMMENT '所属评优活动id',
    `orig_file_name` varchar(200) DEFAULT NULL COMMENT '原材料名称',
    `sys_file_name` varchar(50) DEFAULT NULL COMMENT '系统材料名称（唯一）',
    `file_type` varchar(200) DEFAULT NULL COMMENT '材料类型(扩展名)',
    `file_path` varchar(300) DEFAULT NULL COMMENT '材料路径',
    `file_detail` varchar(300) DEFAULT NULL COMMENT '材料说明',
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_activity_id` (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评优活动材料表';