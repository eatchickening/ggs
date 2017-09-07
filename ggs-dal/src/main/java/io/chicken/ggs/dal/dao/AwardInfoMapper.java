package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AwardInfo;
import io.chicken.ggs.dal.model.AwardInfoDetail;

import java.util.List;

public interface AwardInfoMapper {
    int deleteByPrimaryKey(Long id);

    int  deleteByAppraisecode(String appraiseid);


    int insert(AwardInfo record);

    int insertCollection(List<AwardInfo> record);

    int insertSelective(AwardInfo record);

    List<AwardInfoDetail> selectByAppraisId(String id);

    AwardInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AwardInfo record);

    int updateByPrimaryKey(AwardInfo record);
}