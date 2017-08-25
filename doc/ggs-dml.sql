INSERT INTO `dictionary` (`id`, `biztype`, `bizcode`, `datavalue`, `status`, `remark`) VALUES ('1', 'areacode', '1', '祖庙街道', '0', NULL);
INSERT INTO `dictionary` (`id`, `biztype`, `bizcode`, `datavalue`, `status`, `remark`) VALUES ('2', 'areacode', '2', '夫子庙', '0', NULL);
INSERT INTO `dictionary` (`id`, `biztype`, `bizcode`, `datavalue`, `status`, `remark`) VALUES ('3', 'schootype', 'gaozhi', '高职', '0', NULL);
INSERT INTO `dictionary` (`id`, `biztype`, `bizcode`, `datavalue`, `status`, `remark`) VALUES ('4', 'schootype', 'zhongzhuan', '中专', '0', NULL);
INSERT INTO `dictionary` (`id`, `biztype`, `bizcode`, `datavalue`, `status`, `remark`) VALUES ('5', 'schootype', 'xiaoxue', '小学', '0', NULL);


INSERT INTO `student` (`id`, `studentid`, `name`, `sex`, `award`, `score`, `moral`, `intellectual`, `physical`, `schoolcode`, `remark`) VALUES ('1', '12354562', '孟祥祥', '男', NULL, NULL, NULL, NULL, NULL, 'jialidun', NULL);
INSERT INTO `school` (`id`, `schoolcode`, `name`, `areacode`, `schooltype`) VALUES ('1', 'jialidun', '家里蹲大学', '2', 'zhongzhuan');
INSERT INTO  `school` (`id`, `schoolcode`, `name`, `areacode`, `schooltype`) VALUES ('2', 'shannongnongda', '山东农大', '1', 'gaozhi');
