/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.UserInfo;
import io.chicken.ggs.dal.model.UserMenu;
import io.chicken.ggs.service.UserInfoService;
import io.chicken.ggs.service.UserMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wung 2017/8/25.
 */
@Service
public class UserInfoBusinessImpl implements UserInfoBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoBusinessImpl.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserMenuService userMenuService;

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

    @Override
    public Result<List<UserInfo>> queryListByUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<UserInfo> userInfoList = userInfoService.queryListByUserInfo(userInfo);
            return new Result<>(userInfoList);
        } catch (Exception e) {
            LOGGER.error("queryListByUserInfo(),查询用户异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }

    @Override
    public Result<Boolean> save(UserInfoVO userInfoVO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoVO, userInfo);

        try {
            userInfoService.save(userInfo);

            // 权限处理
            UserMenu userMenu = new UserMenu();
            userMenu.setUserAccount(userInfoVO.getAccount());
            userMenu.setMenuId(userInfoVO.getMenuId());
            userMenuService.save(userMenu);

            return new Result<>(ResultCode.SUCCESS);
        } catch (GGSException e) {
            return new Result<>(e.getCode(), e.getMessage());
        } catch (Exception e1) {
            LOGGER.error(userInfo.getAccount() + ", save() 异常：" + e1.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }

    @Override
    public Result<Boolean> update(UserInfoVO userInfoVO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoVO, userInfo);

        try {
            userInfoService.update(userInfo);

            // 权限更新
            if (!StringUtils.isEmpty(userInfoVO.getAccount()) && !StringUtils.isEmpty(userInfoVO.getMenuId())) {
                UserMenu userMenu = new UserMenu();
                userMenu.setUserAccount(userInfoVO.getAccount());
                userMenu.setMenuId(userInfoVO.getMenuId());
                userMenuService.update(userMenu);
            }

            return new Result<>(ResultCode.SUCCESS);
        } catch (GGSException e) {
            return new Result<>(e.getCode(), e.getMessage());
        } catch (Exception e1) {
            LOGGER.error(userInfo.getAccount() + ", update() 异常：" + e1.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }

    @Override
    public Result<Boolean> delete(Integer userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setIsDelete(CommonConstant.USER_STATUS_DELETE);
        try {
            userInfoService.update(userInfo);
            return new Result<>(ResultCode.SUCCESS);
        } catch (GGSException e) {
            return new Result<>(e.getCode(), e.getMessage());
        } catch (Exception e1) {
            LOGGER.error(userInfo.getAccount() + ", delete() 异常：" + e1.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }
}
