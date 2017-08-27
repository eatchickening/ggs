package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.Post;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);


    List<Post> queryByDepartcode(String departcode);

}