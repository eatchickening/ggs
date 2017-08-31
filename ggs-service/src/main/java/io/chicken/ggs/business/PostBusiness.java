/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Post;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
public interface PostBusiness {

    Result<List<Post>> queryByDepartcode(String departcode);


    Result<Long> save(Post post);

    Result<Boolean> delete(Long id);
}
