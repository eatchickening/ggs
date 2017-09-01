package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Appraise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppraiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);

    List<Appraise> queryList(@Param("appraiseName") String appraiseName,
                             @Param("start") Integer start,
                             @Param("last") Integer last);

    long queryTotal(@Param("appraiseName") String appraiseName,
                    @Param("start") Integer start,
                    @Param("last") Integer last);

}