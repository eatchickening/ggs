/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.ManagerClassInfoBusiness;
import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.ManagerClassInfo;
import io.chicken.ggs.service.ManagerClassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/9/8.
 */
@Service
public class ManagerClassInfoBusinessIml implements ManagerClassInfoBusiness {

    public static final Logger LOGGER = LoggerFactory.getLogger(ManagerClassInfoBusinessIml.class);

    @Autowired
    private ManagerClassInfoService managerClassInfoService;

    @Override
    public Result<List<ManagerClassInfo>> queryByTeacherid(String teacherid) {
        try {
            List<ManagerClassInfo> managerClassInfoList = managerClassInfoService.queryByTeacherid(teacherid);
            return new Result<>(managerClassInfoList);
        } catch (GGSException e) {
            return new Result<>(e.getCode(), e.getMessage());
        }
    }
}
