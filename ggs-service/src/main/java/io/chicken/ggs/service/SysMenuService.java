/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.SysMenu;

import java.util.List;

/**
 * @author wung 2017/8/29.
 */
public interface SysMenuService {

    List<SysMenu> queryList(List<Integer> ids);
}
