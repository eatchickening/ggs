/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/25.
 */
@Service
public class UserInfoBusinessImpl implements UserInfoBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoBusinessImpl.class);

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public Result<List<UserInfoVO>> queryList(UserInfoQueryParam param) {
        try {
            List<UserInfoVO> userInfoVOS = userInfoService.queryList(param);
            return new Result<>(userInfoVOS);
        } catch (Exception e) {
            LOGGER.error("queryList() execption : " + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }

    @Override
    public Result<Long> queryCount(UserInfoQueryParam param) {
        try {
            Long count = userInfoService.queryCount(param);
            return new Result<>(count);
        } catch (Exception e) {
            LOGGER.error("queryCount() exception : " + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }
}
