/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.SysMenuBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.SysMenu;
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
