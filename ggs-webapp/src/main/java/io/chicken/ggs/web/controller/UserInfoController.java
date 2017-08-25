/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * 用户操作
 *
 * @author wung 2017/8/25.
 */
@Controller
@RequestMapping("/ggs/userInfo")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserInfoBusiness userInfoBusiness;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<UserInfoVO>> querylist(@RequestBody UserInfoQueryParam params) {
        logger.info("querylist() params = " + params);
        if (params == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        if (params.getPageNum() == null || params.getPageNum() == 0) {
            params.setPageNum(CommonConstant.PAGE_NUM);
        }
        if (params.getPageSize() == null || params.getPageSize() == 0) {
            params.setPageSize(CommonConstant.PAGE_SIZE);
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
}
