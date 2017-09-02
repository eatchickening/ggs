
--  学生评优信息表
DROP  TABLE  IF EXISTS candidatestudent;
CREATE TABLE candidatestudent (
    id bigint NOT NULL AUTO_INCREMENT,
    activitycode varchar(40)  COMMENT '所属评优活动编码',
    awardcode varchar(40)  COMMENT '奖项编码',
    studentid varchar(50) COMMENT '学籍号',
    remark varchar(500) COMMENT '备注',
	  status  varchar(2)  COMMENT '状态 0未提交 1提交到学校 2学校退回 3提交到教育局 4教育局退回 5评定完成',
	  cmanageroption TEXT COMMENT '班主任评语',
	  schooloption TEXT COMMENT '学校评语',
	  returnreson varchar(500)  COMMENT '退回原因',
	  isreview varchar(2)  COMMENT '是否评审',
	  reviewlevel varchar(10)  COMMENT '评审等级',
	  isaward varchar(2)  COMMENT '是否获奖',
    operator varchar(40)  COMMENT '操作人',
    operator_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
    schoolauditor varchar(40)  COMMENT '审批人',
    schoolauditor_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '学校审批时间',
	  eduauditor varchar(40)  COMMENT '教育局审批人',
    eduauditor_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '教育局审批时间',
    create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生评优信息表';

--  学生评优资料
DROP  TABLE  IF EXISTS candidatestudentfile;
CREATE TABLE candidatestudentfille (
    id bigint NOT NULL AUTO_INCREMENT,
    activitycode varchar(40)  COMMENT '所属评优活动编码',
    awardcode varchar(40)  COMMENT '奖项编码',
    studentid varchar(50) COMMENT '学籍号',
    remark varchar(500) COMMENT '备注',
    filename varchar(200)  COMMENT '材料名称',
    filetype varchar(200)  COMMENT '材料类型',
    filepath  varchar(300)  COMMENT '材料路径',
    filedetail  varchar(300)  COMMENT '材料说明',
	  operator varchar(40)  COMMENT '操作人',
    operator_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
    create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评优表';
