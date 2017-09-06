package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AwardSchool;

import java.util.List;

public interface AwardSchoolMapper {
    int deleteByPrimaryKey(Long id);

    int  deleteByAppraisecode(String appraiseid);

    int insert(AwardSchool record);

    int insertSelective(AwardSchool record);
    int insertCollection(List<AwardSchool> record);
    AwardSchool selectByPrimaryKey(Long id);

    List<AwardSchool> selectByAppraisId(String id);

    int updateByPrimaryKeySelective(AwardSchool record);

    int updateByPrimaryKey(AwardSchool record);
}