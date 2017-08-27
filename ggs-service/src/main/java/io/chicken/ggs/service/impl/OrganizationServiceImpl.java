/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.OrganizationMapper;
import io.chicken.ggs.dal.model.Organization;
import io.chicken.ggs.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Autowired
    private OrganizationMapper organizationMapper;

    /**
     * 通过区域编码查询其下面的机构
     *
     * @param areacode
     * @return
     */
    @Override
    public List<Organization> queryByAreacode(String areacode) {
        return organizationMapper.queryByAreacode(areacode);
    }
}
