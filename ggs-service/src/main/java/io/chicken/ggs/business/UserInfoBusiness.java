/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;

import java.util.List;

/**
 * 用户操作业务层接口
 *
 * @author wung 2017/8/25.
 */
public interface UserInfoBusiness {

    /**
     * 更加条件查询用户
     *
     * @param param
     * @return
     */
    Result<List<UserInfoVO>> queryList(UserInfoQueryParam param);

    /**
     * 更加条件查询符合条件的总条数
     *
     * @param param
     * @return
     */
    Result<Long> queryCount(UserInfoQueryParam param);
}
