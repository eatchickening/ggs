/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.Post;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
public interface PostService {

    List<Post> queryByDepartcode(String departcode);


    Long save(Post post);

    void delete(Long id);
}
