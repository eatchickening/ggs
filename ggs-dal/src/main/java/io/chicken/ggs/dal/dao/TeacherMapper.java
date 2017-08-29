package io.chicken.ggs.dal.dao;

import io.chicken.ggs.common.vo.TeacherList;
import io.chicken.ggs.common.vo.TeacherQueryParam;
import io.chicken.ggs.dal.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<TeacherList> queryList(@Param("teaMap") TeacherQueryParam teaParam,
                                @Param("start") Integer start,
                                @Param("last") Integer lst);

    long queryTotal(@Param("teaMap") TeacherQueryParam teaParam,
                    @Param("start") Integer start,
                    @Param("last") Integer lst);
}