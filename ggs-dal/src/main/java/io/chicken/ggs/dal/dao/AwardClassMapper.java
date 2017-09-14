package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AwardClass;

import java.util.List;

public interface AwardClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AwardClass record);

    int insertSelective(AwardClass record);

    int insertCollection(List<AwardClass> record);

    int deleteByAppraisecode(String appraiseid);

    List<AwardClass> selectByAwardInfoId(String id);


    AwardClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AwardClass record);

    int updateByPrimaryKey(AwardClass record);
}