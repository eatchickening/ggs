package io.chicken.ggs.dal.dao;

import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.dal.model.AppraisedActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppraisedActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppraisedActivity record);

    int insertSelective(AppraisedActivity record);

    AppraisedActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppraisedActivity record);

    int updateByPrimaryKeyWithBLOBs(AppraisedActivity record);

    int updateByPrimaryKey(AppraisedActivity record);

    List<AppraisedActivity> queryList(@Param("param") AppraisedActivityQueryParam param, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    Long queryTotal(@Param("param") AppraisedActivityQueryParam param);

}