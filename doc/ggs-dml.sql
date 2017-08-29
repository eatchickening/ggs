
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

