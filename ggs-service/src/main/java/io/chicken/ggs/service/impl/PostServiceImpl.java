/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.PostMapper;
import io.chicken.ggs.dal.model.Post;
import io.chicken.ggs.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostMapper postMapper;

    /**
     * 根据部门编码查询其下面的岗位
     *
     * @param departcode
     * @return
     */
    @Override
    public List<Post> queryByDepartcode(String departcode) {
        return postMapper.queryByDepartcode(departcode);
    }
}
