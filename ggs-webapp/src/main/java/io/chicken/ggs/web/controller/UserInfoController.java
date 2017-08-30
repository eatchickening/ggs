/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.ValidateErrorResult;
import io.chicken.ggs.common.util.ValidatorUtils;
import io.chicken.ggs.common.validator.groups.UserInfoControllerSave;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

/**
 * 用户操作
 *
 * @author wung 2017/8/25.
 */
@Api(description = "用户操作相关：CRUD")
@Controller
@RequestMapping("/ggs/userInfo")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Value(value = "${password.default}")
    private String passwordDefault;

    @Autowired
    private UserInfoBusiness userInfoBusiness;

    @ApiOperation(value = "用户列表")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<UserInfoVO>> querylist(@RequestBody UserInfoQueryParam params) {
        logger.info("querylist() params = " + params);
        if (params == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        //查询总条数
        Result<Long> countResult = userInfoBusiness.queryCount(params);
        if (!countResult.isSuccess()) {
            return new Result<>(countResult.getCode(), countResult.getMessage());
        }
        Result<List<UserInfoVO>> userInfoVOResult = new Result<>();
        if (countResult.getData() == 0) {
            userInfoVOResult.setData(Collections.<UserInfoVO>emptyList());
            userInfoVOResult.setTotal(0L);
            return userInfoVOResult;
        }

        // 查询用户列表
        Result<List<UserInfoVO>> listResult = userInfoBusiness.queryList(params);
        if (!listResult.isSuccess()) {
            return new Result<>(listResult.getCode(), listResult.getMessage());
        }
        listResult.setTotal(countResult.getData());
        return listResult;
    }

    @ApiOperation(value = "保存用户")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody UserInfoVO userInfoVO) {
        logger.info("save(), param = " + userInfoVO);
        if (userInfoVO == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        if (StringUtils.isEmpty(userInfoVO.getPassword())) {
            userInfoVO.setPassword(passwordDefault);
        }

        ValidateErrorResult errorResult = ValidatorUtils.validateEntityLazy(userInfoVO, UserInfoControllerSave.class);
        if (errorResult != null) {
            return new Result<>(errorResult);
        }

        return userInfoBusiness.save(userInfoVO);
    }

    @ApiOperation(value = "查询用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "string", paramType = "path")
    @ResponseBody
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Result<UserInfoVO> detail(@PathVariable(value = "id") Integer id) {
        UserInfoQueryParam param = new UserInfoQueryParam();
        param.setId(id);
        Result<List<UserInfoVO>> listResult = userInfoBusiness.queryList(param);
        if (!listResult.isSuccess()) {
            return new Result<>(listResult.getCode(), listResult.getMessage());
        }
        if (listResult.getData().isEmpty()) {
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }

        return new Result<>(listResult.getData().get(0));
    }

    @ApiOperation(value = "更新用户信息, id 必须传")
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody UserInfoVO userInfoVO) {
        logger.info("update(), param = " + userInfoVO);
        if (userInfoVO == null || userInfoVO.getId() == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        if (userInfoVO.getId() == null) {
            logger.error("update(), id is null!");
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        return userInfoBusiness.update(userInfoVO);
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(Integer id) {
        logger.info("delete(), param = " + id);
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        return userInfoBusiness.delete(id);
    }
}
