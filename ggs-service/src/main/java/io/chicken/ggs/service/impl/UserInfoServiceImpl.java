/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.dao.UserInfoMapper;
import io.chicken.ggs.dal.model.UserInfo;
import io.chicken.ggs.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户操作接口
 *
 * @author wung 2017/8/23.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void save(UserInfo userInfo) {
        if (userInfo == null) {
            LOGGER.error("userInfo 参数为空");
            throw new GGSException(ResultCode.PARAMETER_EMPTY);
        }
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        if (userInfo == null || userInfo.getId() == null) {
            LOGGER.error("update() 参数为空");
            throw new GGSException(ResultCode.PARAMETER_EMPTY);
        }
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public UserInfo query(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
