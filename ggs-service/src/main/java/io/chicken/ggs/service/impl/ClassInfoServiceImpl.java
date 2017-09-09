package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.ClassInfoMapper;
import io.chicken.ggs.dal.model.ClassInfo;
import io.chicken.ggs.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;
    @Override
    public List<ClassInfo> queryList(Map<String, Object> map) {
        List<ClassInfo> classInfos = classInfoMapper.queryList(map);
        return classInfos;
    }
}
