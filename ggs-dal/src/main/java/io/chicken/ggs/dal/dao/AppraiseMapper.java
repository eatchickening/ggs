package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AppraiseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppraiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Appraise record);

    long insertSelective(Appraise record);

    AppraiseDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);


    List<Appraise> queryList(@Param("appraiseName") String appraiseName,
                             @Param("start") Integer start,
                             @Param("last") Integer last);

    Long queryTotal(@Param("appraiseName") String appraiseName,
                    @Param("start") Integer start,
                    @Param("last") Integer last);

    List<Appraise> queryListByIds(List<Long> ids);
}