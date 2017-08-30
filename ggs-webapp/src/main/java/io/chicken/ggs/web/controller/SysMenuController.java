/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.SysMenuBusiness;
import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.ValidateErrorResult;
import io.chicken.ggs.common.util.ValidatorUtils;
import io.chicken.ggs.common.validator.groups.UserInfoControllerSave;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.SysMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 用户操作
 *
 * @author wung 2017/8/25.
 */
@Api(description = "菜单（权限）操作相关")
@Controller
@RequestMapping("/ggs/sysMenu")
public class SysMenuController {

    private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    private SysMenuBusiness sysMenuBusiness;

    @ApiOperation(value = "获取所有菜单列表")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<SysMenu>> queryAllList() {
        Result<List<SysMenu>> menuResult = sysMenuBusiness.queryAllList();
        if (!menuResult.isSuccess()) {
            return new Result<>(menuResult.getCode(), menuResult.getMessage());
        }

        return menuResult;
    }

}
