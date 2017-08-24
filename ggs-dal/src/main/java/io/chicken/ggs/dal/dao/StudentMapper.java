package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Student;

public interface StudentMapper extends BaseDao<Student>{
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}