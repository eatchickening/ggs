package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Depart;

public interface DepartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Depart record);

    int insertSelective(Depart record);

    Depart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);
}