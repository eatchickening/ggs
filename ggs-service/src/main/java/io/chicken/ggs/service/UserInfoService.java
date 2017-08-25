/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.UserInfo;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author wung 2017/8/23.
 */
public interface UserInfoService {

    void save(UserInfo userInfo);

    void update(UserInfo userInfo);

    UserInfo query(Integer id);

    UserInfo login(String account, String pwd) throws DataAccessException;

    Boolean updatePwd(String account, String newPwd) throws DataAccessException;

}
