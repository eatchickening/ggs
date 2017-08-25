package io.chicken.ggs.service.impl;

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

    public List<Teacher> queryTeacherList(Map<String, Object> teaMap) {
        return teacherMapper.queryList(teaMap);
    }

    public long queryTotal(Map<String, Object> teaMap) {
        return teacherMapper.queryTotal(teaMap);
    }
}
