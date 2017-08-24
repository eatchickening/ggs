/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.UserInfoVO;

/**
 * 登录业务层接口
 *
 * @author wung 2017/8/24.
 */
public interface LoginBusiness {

    Result<UserInfoVO> login(String account, String pwd);

    Result<Boolean> updatePwd(String account, String oldPwd, String newPwd);

}
