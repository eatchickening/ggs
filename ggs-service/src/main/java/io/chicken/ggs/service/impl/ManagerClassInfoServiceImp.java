/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.dao.ManagerClassInfoMapper;
import io.chicken.ggs.dal.model.ManagerClassInfo;
import io.chicken.ggs.service.ManagerClassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wung 2017/9/8.
 */
@Service
public class ManagerClassInfoServiceImp implements ManagerClassInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerClassInfoServiceImp.class);

    @Autowired
    private ManagerClassInfoMapper managerClassInfoMapper;

    @Override
    public List<ManagerClassInfo> queryByTeacherid(String teacherid) {
        LOGGER.info("queryByTeacherid(), teacherid = " + teacherid);
        if (StringUtils.isEmpty(teacherid)) {
            throw new GGSException(ResultCode.PARAMETER_EMPTY);
        }

        return managerClassInfoMapper.queryByTeacherid(teacherid);
    }
}
