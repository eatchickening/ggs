package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.AppraisedActivity;

public interface AppraisedActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppraisedActivity record);

    int insertSelective(AppraisedActivity record);

    AppraisedActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppraisedActivity record);

    int updateByPrimaryKeyWithBLOBs(AppraisedActivity record);

    int updateByPrimaryKey(AppraisedActivity record);
}