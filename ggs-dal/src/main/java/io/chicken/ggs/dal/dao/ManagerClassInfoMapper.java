package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.ManagerClassInfo;

import java.util.List;

public interface ManagerClassInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManagerClassInfo record);

    int insertSelective(ManagerClassInfo record);

    ManagerClassInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManagerClassInfo record);

    int updateByPrimaryKey(ManagerClassInfo record);

    List<ManagerClassInfo> queryByTeacherid(String teacherid);

}