package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.vo.TeacherList;
import io.chicken.ggs.common.vo.TeacherQueryParam;
import io.chicken.ggs.dal.dao.TeacherMapper;
import io.chicken.ggs.dal.model.Teacher;
import io.chicken.ggs.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/24/17.
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public List<TeacherList> queryTeacherList(TeacherQueryParam teaParam) {
        Integer start = (teaParam.getPageNum() - 1) * teaParam.getPageSize();
        return teacherMapper.queryList(teaParam, start, teaParam.getPageSize() * CommonConstant.PAGE_PRE);
    }

    public long queryTotal(TeacherQueryParam teaParam) {
        Integer start = (teaParam.getPageNum() - 1) * teaParam.getPageSize();
        return teacherMapper.queryTotal(teaParam, start, teaParam.getPageSize() * CommonConstant.PAGE_PRE);
    }
}
