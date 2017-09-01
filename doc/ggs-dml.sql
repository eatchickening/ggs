
insert into `dictionary` ( `bizcode`, `status`, `remark`, `biztype`, `datavalue`) values ( 'QY001', '0', null, 'areacode', '祖庙街道');
insert into `dictionary` ( `bizcode`, `status`, `remark`, `biztype`, `datavalue`) values ( 'QY002', '0', null, 'areacode', '夫子庙');
insert into `dictionary` ( `bizcode`, `status`, `remark`, `biztype`, `datavalue`) values ( 'gaozhi', '0', null, 'schootype', '高职');
insert into `dictionary` ( `bizcode`, `status`, `remark`, `biztype`, `datavalue`) values ( 'zhongzhuan', '0', null, 'schootype', '中专');
insert into `dictionary` ( `bizcode`, `status`, `remark`, `biztype`, `datavalue`) values ( 'xiaoxue', '0', null, 'schootype', '小学');


INSERT INTO `student` (`id`, `studentid`, `name`, `sex`, `award`, `score`, `moral`, `intellectual`, `physical`, `schoolcode`, `remark`) VALUES ('1', '12354562', '孟祥祥', '男', NULL, NULL, NULL, NULL, NULL, 'jialidun', NULL);

INSERT INTO `school` VALUES ('1', 'jialidun', '家里蹲大学', '2', 'zhongzhuan');
INSERT INTO `school` VALUES ('2', 'shannongnongda', '山东农大', '1', 'gaozhi');

INSERT INTO `teacher` VALUES ('1', 'a1', ' 宋', '男', '1年级1班', 'shannongnongda', 'wwwwwwwwwwwwwwwww');
INSERT INTO `teacher` VALUES ('2', 'a2', 'xiaofeng', '女', '1年级2班', 'shannongnongda', 'dfasdfasfsdf');

insert into `organization` ( `organcode`, `areacode`, `name`, `remark`) values ( 'JG001', 'QY001', '机构1', null);
insert into `organization` ( `organcode`, `areacode`, `name`, `remark`) values ( 'JG002', 'QY002', '机构2', null);
insert into `organization` ( `organcode`, `areacode`, `name`, `remark`) values ( 'JG003', 'QY001', '机构3', null);


insert into `depart` ( `organcode`, `departcode`, `name`, `remark`) values ( 'JG001', 'BM001', '部门1', null);
insert into `depart` ( `organcode`, `departcode`, `name`, `remark`) values ( 'JG001', 'BM002', '部门2', null);


insert into `post` ( `departcode`, `postcode`, `name`, `remark`) values ( 'BM001', 'GW001', '岗位1', null);
insert into `post` ( `departcode`, `postcode`, `name`, `remark`) values ( 'BM001', 'GW002', '岗位2', null);


-- 基础设置
insert into `sysmenu` ( `order_num`, `remark`, `perms`, `parent_id`, `angular_state`, `name`, `url`)
values ( null, null, null, '0', 'root.basic', '基础设置', null);

insert into `sysmenu` ( `order_num`, `remark`, `perms`, `parent_id`, `angular_state`, `name`, `url`)
select null, null, '', (select id from `sysmenu` where angular_state = 'root.basic'),'root.basic.department', '部门与岗位设置', null from dual
union all
select null, null, '', (select id from `sysmenu` where angular_state = 'root.basic'),'root.basic.user', '用户管理', null from dual;

-- 信息查询
insert into `sysmenu` ( `order_num`, `remark`, `perms`, `parent_id`, `angular_state`, `name`, `url`)
values ( null, null, null, '0', 'root.info', '信息查询', null);

insert into `sysmenu` ( `order_num`, `remark`, `perms`, `parent_id`, `angular_state`, `name`, `url`)
select null, null, '', (select id from `sysmenu` where angular_state = 'root.info'),'root.info.student', '学生信息查询', null from dual
union all
select null, null, '', (select id from `sysmenu` where angular_state = 'root.info'),'root.info.teacher', '教师信息查询', null from dual
union all
select null, null, '', (select id from `sysmenu` where angular_state = 'root.info'),'root.info.school', '学校信息查询', null from dual;

-- 评优表信息
INSERT INTO `appraise` VALUES ('1', '20171005', '装逼大会', '1', '群级', null, null, null, null, '2017-08-31 20:07:44');

INSERT INTO `award_quota` VALUES ('1', '1', '1', '1', null, null, '2017-08-31 20:23:07');

INSERT INTO `award_school` VALUES ('1', '1', '1', 'jialidun', '1', null, '2017-08-31 20:30:10');
INSERT INTO `award_school` VALUES ('2', '1', '1', 'shannongnongda', '1', null, '2017-08-31 20:30:10');
INSERT INTO `award_school` VALUES ('3', '1', '2', 'jialidun', '1', null, '2017-08-31 20:30:12');
INSERT INTO `award_school` VALUES ('4', '1', '2', 'shannongnongda', '1', null, '2017-08-31 20:30:30');
INSERT INTO `award_school` VALUES ('5', '1', '3', 'jialidun', '1', null, '2017-08-31 20:30:30');
INSERT INTO `award_school` VALUES ('6', '1', '3', 'shannongnongda', '2', null, '2017-08-31 20:30:30');
INSERT INTO `award_school` VALUES ('7', '1', '4', 'jialidun', '1', null, '2017-08-31 20:30:32');

INSERT INTO `awardinfo` VALUES ('1', '1', '晒车', '1', '群级', null, '2017-08-31 20:24:01');
INSERT INTO `awardinfo` VALUES ('2', '2', '晒房', '2', '群级', null, '2017-08-31 20:24:01');
INSERT INTO `awardinfo` VALUES ('3', '3', '晒户口', '3', '群级', null, '2017-08-31 20:24:01');
INSERT INTO `awardinfo` VALUES ('4', '4', '晒娃', '4', '群级', null, '2017-08-31 20:24:01');
INSERT INTO `awardinfo` VALUES ('5', '5', '晒钱', '5', '群级', null, '2017-08-31 20:24:02');
INSERT INTO `awardinfo` VALUES ('6', '6', '晒老婆', '6', '群级', null, '2017-08-31 20:24:02');
INSERT INTO `awardinfo` VALUES ('7', '7', '晒装备', '7', '群级', null, '2017-08-31 20:24:06');
