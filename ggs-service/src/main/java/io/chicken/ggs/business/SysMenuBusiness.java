/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.SysMenu;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
public interface SysMenuBusiness {

    Result<List<SysMenu>> queryList(List<Integer> ids);

    Result<List<SysMenu>> queryAllList();
}
