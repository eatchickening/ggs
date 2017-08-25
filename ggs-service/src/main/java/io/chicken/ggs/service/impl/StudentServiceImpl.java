package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.StudentMapper;
import io.chicken.ggs.dal.model.Student;
import io.chicken.ggs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> queryList(Map<String, Object> map) {
        return studentMapper.queryList(map);
    }


    public long queryTotal(Map<String, Object> map) {
        return studentMapper.queryTotal(map);
    }


}
