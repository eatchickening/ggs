package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.User_menu;

public interface User_menuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User_menu record);

    int insertSelective(User_menu record);

    User_menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User_menu record);

    int updateByPrimaryKey(User_menu record);
}