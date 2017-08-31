/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.PostBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Post;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wung 2017/8/27.
 */
@Api(description = "岗位操作接口")
@Controller
@RequestMapping("/ggs/post")
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostBusiness postBusiness;


    @ApiOperation(value = "获取部门下的岗位")
    @ApiImplicitParam(name = "departcode", value = "部门编码", required = true, dataType = "string", paramType = "path")
    @ResponseBody
    @RequestMapping(value = "/get/{departcode}", method = RequestMethod.POST)
    public Result get(@PathVariable(value = "departcode") String departcode) {
        LOGGER.info("get() " + departcode);

        return postBusiness.queryByDepartcode(departcode);
    }


    @ApiOperation(value = "添加岗位")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Long> save(@RequestBody Post post) {
        LOGGER.info("save() " + post);

        // 机构编码从登录用户获取

        // 校验 todo
        return postBusiness.save(post);
    }

    @ApiOperation(value = "删除岗位")
    @ApiImplicitParam(name = "id", value = "岗位id", required = true, dataType = "long", paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(Long id) {
        LOGGER.info("delete() " + id);

        return postBusiness.delete(id);
    }

}
