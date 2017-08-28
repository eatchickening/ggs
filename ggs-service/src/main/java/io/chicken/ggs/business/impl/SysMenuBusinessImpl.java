/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.SysMenuBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.SysMenu;
import io.chicken.ggs.service.SysMenuService;
import io.chicken.ggs.service.impl.DepartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class SysMenuBusinessImpl implements SysMenuBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public Result<List<SysMenu>> queryList(List<Integer> ids) {
        LOGGER.info("queryList(), ids = " + ids);
        if (ids == null || ids.isEmpty()) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<SysMenu> list = sysMenuService.queryList(ids);
            return new Result<>(list);
        } catch (Exception e) {
            LOGGER.error("查询菜单 queryList() 异常：" + e.getMessage());
            return  new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }
}
