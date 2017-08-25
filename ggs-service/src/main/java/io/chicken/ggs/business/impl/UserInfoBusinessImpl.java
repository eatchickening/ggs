/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/25.
 */
@Service
public class UserInfoBusinessImpl implements UserInfoBusiness {

    @Override
    public Result<List<UserInfoVO>> queryList(UserInfoQueryParam param) {
        return null;
    }

    @Override
    public Result<Long> queryCount(UserInfoQueryParam param) {
        return null;
    }
}
