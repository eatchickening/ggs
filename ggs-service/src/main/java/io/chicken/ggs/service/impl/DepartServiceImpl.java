/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.DepartMapper;
import io.chicken.ggs.dal.model.Depart;
import io.chicken.ggs.service.DepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class DepartServiceImpl implements DepartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Autowired
    private DepartMapper departMapper;

    /**
     * 根据机构编码查询其下面的部门
     *
     * @param organcode
     * @return
     */
    @Override
    public List<Depart> queryByOrgancode(String organcode) {
        return departMapper.queryByOrgancode(organcode);
    }
}
