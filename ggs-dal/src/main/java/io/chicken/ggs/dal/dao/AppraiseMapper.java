package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AppraiseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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


    List<Appraise> queryList(Map<String, Object> params);

    Long queryTotal(Map<String, Object> params);

    List<Appraise> queryListByIds(List<Long> ids);
}