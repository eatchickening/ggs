/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.DepartBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Depart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
@Api(description = "部门操作接口")
@Controller
@RequestMapping("/ggs/depart")
public class DepartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartController.class);

    @Autowired
    private DepartBusiness departBusiness;


    @ApiOperation(value = "获取机构下的部门")
    @ApiImplicitParam(name = "organcode", value = "机构编码", required = true, dataType = "string", paramType = "path")
    @ResponseBody
    @RequestMapping(value = "/get/{organcode}", method = RequestMethod.GET)
    public Result<List<Depart>> get(@PathVariable(value = "organcode") String organcode) {
        LOGGER.info("get() " + organcode);

        return departBusiness.queryByOrgancode(organcode);
    }

    @ApiOperation(value = "添加部门")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Long> save(@RequestBody Depart depart) {
        LOGGER.info("save() " + depart);

        // 机构编码从登录用户获取

        // 校验 todo
        return departBusiness.save(depart);
    }

    @ApiOperation(value = "删除部门")
    @ApiImplicitParam(name = "id", value = "部门id", required = true, dataType = "long", paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(Long id) {
        LOGGER.info("delete() " + id);

        return departBusiness.delete(id);
    }

}
