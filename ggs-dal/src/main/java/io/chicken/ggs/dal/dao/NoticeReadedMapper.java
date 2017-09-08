package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.NoticeReaded;

public interface NoticeReadedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoticeReaded record);

    int insertSelective(NoticeReaded record);

    NoticeReaded selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoticeReaded record);

    int updateByPrimaryKey(NoticeReaded record);
}