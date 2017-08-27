/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.PostBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.Post;
import io.chicken.ggs.service.PostService;
import io.chicken.ggs.service.impl.DepartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class PostBusinessImpl implements PostBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Autowired
    private PostService postService;

    @Override
    public Result<List<Post>> queryByDepartcode(String departcode) {
        LOGGER.info(departcode + ",queryByDepartcode(), departcode = " + departcode);
        if (StringUtils.isEmpty(departcode)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<Post> list = postService.queryByDepartcode(departcode);
            return new Result<>(list);
        } catch (Exception e) {
            LOGGER.error(departcode + ",queryByDepartcode() 异常：" + e.getMessage());
            return  new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }
}
