/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.LoginBusiness;
import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.LoginUtil;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.Organization;
import io.chicken.ggs.dal.model.SysMenu;
import io.chicken.ggs.dal.model.UserInfo;
import io.chicken.ggs.service.SysMenuService;
import io.chicken.ggs.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wung 2017/8/24.
 */
@Service
public class LoginBusinessImpl implements LoginBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginBusinessImpl.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public Result<UserInfoVO> login(String account, String pwd) {
        LOGGER.info("account=" + account + ", pwd=" + pwd);
        if (StringUtils.isBlank(account) || StringUtils.isBlank(pwd)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            // pwd = LoginUtil.md5(LoginUtil.decryptByPrivateKeyForPC(pwd));
            UserInfoVO user = userInfoService.login(account, pwd);
            if (user == null) {
                return new Result<>(ResultCode.LOGIN_FAIL);
            }



            // Organization organization = organizationService.query(user.getOrgaAccount());
            // if (organization == null) {
            //     LOGGER.error("login(), 机构不存在!");
            //     return new Result<>(ResultCode.LOGIN_FAIL);
            // }
            // userVO.setOrgaAccount(organization.getAccount());
            // userVO.setOrgaName(organization.getName());
            //
            // UserRole userRole = userRoleService.query(user.getAccount());
            // if (userRole == null || RoleEnum.getDescByCode(userRole.getRoleCode()) == null) {
            //     LOGGER.error("login(), 角色不存在或错误！");
            //     return new Result<>(ResultCode.LOGIN_FAIL);
            // }
            // userVO.setRoleCode(userRole.getRoleCode());
            // userVO.setRoleName(RoleEnum.getDescByCode(userRole.getRoleCode()));
            //
            // userVO.setPassword(null);
            return new Result<>(user);
        }catch (GGSException e) {
            LOGGER.error(account + " : " + e.getMessage());
            return new Result<>(e.getCode(), e.getMessage());
        }
        catch (Exception e) {
            LOGGER.error(account + " : " + e.getMessage());
            return new Result<>(ResultCode.LOGIN_EXCEPTION);
        }
    }

    @Override
    public Result<Boolean> updatePwd(String account, String oldPwd, String newPwd) {
        LOGGER.info("updatePwd(): account=" + account + ", oldPwd=" + oldPwd + ", newPwd=" + newPwd);
        if (StringUtils.isBlank(account) ||
                StringUtils.isBlank(oldPwd) ||
                StringUtils.isBlank(newPwd)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            // oldPwd = LoginUtil.md5(LoginUtil.decryptByPrivateKeyForPC(oldPwd));
            UserInfoVO user = userInfoService.login(account, oldPwd);
            if (user == null) {
                return new Result<>(ResultCode.LOGIN_OLDPWD_ERROR);
            }
            return updatePwd(account, newPwd);
        } catch (DataAccessException e) {
            LOGGER.error(account + " updatePwd() fail: " + e.getMessage());
            return new Result<>(ResultCode.DB_UPDATE_FAIL);
        }

    }

    /**
     * 重置密码
     * @param account
     * @param newPwd
     * @return
     */
    public Result<Boolean> updatePwd(String account, String newPwd) {
        LOGGER.info("updatePwd: account=" + account + ", newPwd=" + newPwd);
        if (StringUtils.isBlank(account) || StringUtils.isBlank(newPwd)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        try {
            // newPwd = LoginUtil.md5(LoginUtil.decryptByPrivateKeyForPC(newPwd));
            Boolean bool = userInfoService.updatePwd(account, newPwd);
            if (bool) {
                // redisCacheCleanServiceImpl.cleanUserInfoCache(account); //todo
                return new Result<>(ResultCode.SUCCESS);
            }
        } catch (DataAccessException e) {
            LOGGER.error(account + " updatePwd() fail: " + e.getMessage());
        }
        return new Result<>(ResultCode.DB_UPDATE_FAIL);
    }
}
