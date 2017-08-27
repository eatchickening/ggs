/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.dal.dao.UserMenuMapper;
import io.chicken.ggs.dal.model.UserMenu;
import io.chicken.ggs.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wung 2017/8/26.
 */
@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Autowired
    private UserMenuMapper userMenuMapper;

    @Override
    public Integer save(UserMenu userMenu) {
        return userMenuMapper.insert(userMenu);
    }

    @Override
    public void update(UserMenu userMenu) {
        userMenuMapper.updateByPrimaryKeySelective(userMenu);
    }
}
