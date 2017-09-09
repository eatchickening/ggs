package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AwardSchool;
import io.chicken.ggs.dal.model.AwardSchoolDetail;

import java.util.List;

public interface AwardSchoolMapper {
    int deleteByPrimaryKey(Long id);

    int  deleteByAppraisecode(String appraiseid);

    int insert(AwardSchool record);

    int insertSelective(AwardSchool record);
    int insertCollection(List<AwardSchool> record);
    AwardSchool selectByPrimaryKey(Long id);

    List<AwardSchool> selectByAwardInfoId(String id);

    int updateByPrimaryKeySelective(AwardSchool record);

    int updateByPrimaryKey(AwardSchool record);

    List<AwardSchoolDetail> selectDetailByAppraiseId(String id);
}