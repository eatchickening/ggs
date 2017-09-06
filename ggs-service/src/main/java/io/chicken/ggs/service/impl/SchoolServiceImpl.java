package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.SchoolMapper;
import io.chicken.ggs.dal.model.School;
import io.chicken.ggs.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    public List<School> queryList(Map<String, Object> map) {
        return schoolMapper.queryList(map);
    }


    public Long queryTotal(Map<String, Object> map) {
        return schoolMapper.queryTotal(map);
    }

    @Override
    public List<School> getSchoolByCondition(Map<String, Object> map)
    {
        return schoolMapper.queryListByCondition(map);
     }
}
