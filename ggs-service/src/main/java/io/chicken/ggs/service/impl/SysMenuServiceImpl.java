/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.SysMenuMapper;
import io.chicken.ggs.dal.model.SysMenu;
import io.chicken.ggs.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wung 2017/8/29.
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> queryList(List<Integer> ids) {
        return sysMenuMapper.queryList(ids);
    }

    @Override
    public List<SysMenu> queryAllList() {
        return sysMenuMapper.queryAllList();
    }
}
