/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.DepartBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.Depart;
import io.chicken.ggs.service.DepartService;
import io.chicken.ggs.service.impl.DepartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class DepartBusinessImpl implements DepartBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Autowired
    private DepartService departService;

    @Override
    public Result<List<Depart>> queryByOrgancode(String organcode) {
        LOGGER.info(organcode + ",queryByOrgancode(), organcode = " + organcode);
        if (StringUtils.isEmpty(organcode)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<Depart> list = departService.queryByOrgancode(organcode);
            return new Result<>(list);
        } catch (Exception e) {
            LOGGER.error(organcode + ",queryByOrgancode() 异常：" + e.getMessage());
            return  new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }
}
