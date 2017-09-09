package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.ClassInfo;
import io.chicken.ggs.dal.model.School;

public interface ClassInfoMapper extends BaseDao<ClassInfo>{
    int deleteByPrimaryKey(Long id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}