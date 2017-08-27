/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.OrganizationBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.Organization;
import io.chicken.ggs.service.OrganizationService;
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
public class OrganizationBusinessImpl implements OrganizationBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationBusinessImpl.class);

    @Autowired
    private OrganizationService organizationService;

    @Override
    public Result<List<Organization>> queryByAreacode(String areacode) {
        if (StringUtils.isEmpty(areacode)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<Organization> list = organizationService.queryByAreacode(areacode);
            return new Result<>(list);
        } catch (Exception e) {
            LOGGER.error(areacode + ",queryByAreacode() 异常：" + e.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }
}
