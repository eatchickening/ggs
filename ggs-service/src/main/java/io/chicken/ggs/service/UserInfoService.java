/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 *
 * @author wung 2017/8/23.
 */
public interface UserInfoService {

    Integer save(UserInfo userInfo);

    void update(UserInfo userInfo);

    UserInfo query(Integer id);

    UserInfo login(String account, String pwd) throws DataAccessException;

    Boolean updatePwd(String account, String newPwd) throws DataAccessException;

    List<UserInfoVO> queryList(UserInfoQueryParam param);

    Long queryCount(UserInfoQueryParam param);

}
