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

--   字典表(存储类型和固定的数据)
CREATE TABLE dictionary (
    id bigint NOT NULL AUTO_INCREMENT,
    biztype varchar(50) COMMENT '业务类型',
    bizcode varchar(50) COMMENT '数据编码',
    datavalue varchar(200) COMMENT '数据值',
    status tinyint DEFAULT 0 COMMENT '状态0：有效 1：无效',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id),
    UNIQUE INDEX (biztype,bizcode)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='字典表';


--   机构表
CREATE TABLE organization (
    id bigint NOT NULL AUTO_INCREMENT,
    organcode varchar(50) COMMENT '机构编码',
    name varchar(2000) COMMENT '机构名称',
    areacode  varchar(50) COMMENT '区域编码',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id),
    UNIQUE INDEX (organcode)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='机构表';


--   部门表
CREATE TABLE depart (
    id bigint NOT NULL AUTO_INCREMENT,
    departcode varchar(50) COMMENT '部门编码',
    name varchar(2000) COMMENT '部门名称',
    organcode varchar(50) COMMENT '所属机构编码',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id),
    UNIQUE INDEX (departcode)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='部门表';


--   岗位表
CREATE TABLE post (
    id bigint NOT NULL AUTO_INCREMENT,
    postcode varchar(50) COMMENT '岗位编码',
    name varchar(2000) COMMENT '岗位名称',
    departcode varchar(50) COMMENT '部门编码',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id),
    UNIQUE INDEX (postcode)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='岗位表';



--  菜单表
CREATE TABLE sysmenu (
    id bigint NOT NULL AUTO_INCREMENT,
    parent_id bigint COMMENT '父菜单ID，一级菜单为0',
    name varchar(50) COMMENT '菜单名称',
    url varchar(200) COMMENT '菜单URL',
    order_num int COMMENT '排序号',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';




--  用户菜单表
CREATE TABLE user_menu (
    id bigint NOT NULL AUTO_INCREMENT,
    user_id bigint COMMENT '用户ID',
    menu_id bigint COMMENT '角色ID',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与菜单对应关系';


--  教师表
CREATE TABLE teacher (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) COMMENT '教师姓名',
    sex  varchar(2) COMMENT '教师姓别',
    classname varchar(100) COMMENT '任课班级',
    school_id bigint COMMENT '所属学校',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';



--  学校表
CREATE TABLE school (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) COMMENT '学校名',
    areacode varchar(50) COMMENT '所属地区',
    schooltype varchar(50) COMMENT '学校类型',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';



--  学生表
CREATE TABLE student (
    id bigint NOT NULL AUTO_INCREMENT,
    studentid varchar(50) COMMENT '学籍号',
    name varchar(50) COMMENT '学生姓名',
    sex  varchar(2) COMMENT '教师姓别',
    award varchar(50) COMMENT '表彰信息',
    score varchar(50) COMMENT '成绩评估',
    moral varchar(50) COMMENT '德育评估',
    intellectual varchar(50) COMMENT '智育评估',
    physical varchar(50) COMMENT '体育评估',
    schoolid varchar(50) COMMENT '学校ID',
    remark varchar(500) COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';
