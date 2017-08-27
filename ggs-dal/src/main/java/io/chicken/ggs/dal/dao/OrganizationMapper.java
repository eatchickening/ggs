package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Organization;

import java.util.List;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    List<Organization> queryByAreacode(String areacode);
}