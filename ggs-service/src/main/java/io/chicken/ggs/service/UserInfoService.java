/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.UserInfo;

/**
 *
 * @author wung 2017/8/23.
 */
public interface UserInfoService {

    void save(UserInfo userInfo);

    void update(UserInfo userInfo);

    UserInfo query(Integer id);

}
