package io.chicken.ggs.dal.dao;

import io.chicken.ggs.common.vo.TeacherList;
import io.chicken.ggs.dal.model.Teacher;

public interface TeacherMapper extends BaseDao<TeacherList>{
    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}