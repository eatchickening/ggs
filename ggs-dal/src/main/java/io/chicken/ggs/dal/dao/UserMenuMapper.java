package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.UserMenu;

public interface UserMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserMenu record);

    int insertSelective(UserMenu record);

    UserMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);
}