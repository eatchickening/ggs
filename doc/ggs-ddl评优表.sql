
--  评优表
DROP  TABLE  IF EXISTS appraise;
CREATE TABLE appraise (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisedate varchar(20)  COMMENT '评优日期',
    appraisename varchar(200)  COMMENT '评优名称',
    appraisecode varchar(200)  COMMENT '评优编码',
    appraiselevel varchar(20)  COMMENT '评优级别',
    appraisenumber int  COMMENT '评优奖项',
    appraiseschool int  COMMENT '评优学校数量',
    appraisequota int  COMMENT '评优指标',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评优表';


--  奖项表
DROP  TABLE  IF EXISTS awardinfo;
CREATE TABLE awardinfo (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(20)  COMMENT '所属评优编码',
    awardname varchar(200)  COMMENT '奖项名称',
    awardcode varchar(200)  COMMENT '奖项编码',
    awardlevel varchar(20)  COMMENT '奖项级别',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项表';

--  奖项学校表
DROP  TABLE  IF EXISTS award_school;
CREATE TABLE award_school (
    id bigint NOT NULL AUTO_INCREMENT,
    appraisecode varchar(20)  COMMENT '所属评优编码',
    awardcode varchar(200)  COMMENT '奖项编码',
    schoolcode varchar(20)  COMMENT '学校代码',
    schoolquota varchar(20)  COMMENT '学校指标',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项学校表';

