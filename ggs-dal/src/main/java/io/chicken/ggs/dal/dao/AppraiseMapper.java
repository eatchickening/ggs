package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Appraise;

public interface AppraiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}