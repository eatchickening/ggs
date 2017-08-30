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

    /**
     * 查询指定 id 的菜单
     * @param ids
     * @return
     */
    List<SysMenu> queryList(List<Integer> ids);

    /**
     * 查询所有的菜单
     * @return
     */
    List<SysMenu> queryAllList();

}
