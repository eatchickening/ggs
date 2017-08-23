package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Sysmenu;

public interface SysmenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sysmenu record);

    int insertSelective(Sysmenu record);

    Sysmenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sysmenu record);

    int updateByPrimaryKey(Sysmenu record);
}