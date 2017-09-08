/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.ManagerClassInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.ManagerClassInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author wung 2017/9/8.
 */
@Api(description = "班主任接口")
@Controller
@RequestMapping("/ggs/mci")
public class ManagerClassInfoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ManagerClassInfoController.class);

    @Autowired
    private ManagerClassInfoBusiness managerClassInfoBusiness;

    @ApiOperation(value = "根据班主任编码查询其负责的班级信息")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<ManagerClassInfo>> list() {
        String teacherid = "JS1";
        return managerClassInfoBusiness.queryByTeacherid(teacherid);
    }

}
