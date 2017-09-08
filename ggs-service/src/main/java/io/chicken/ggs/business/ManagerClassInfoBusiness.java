/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.ManagerClassInfo;

import java.util.List;

/**
 * @author wung 2017/9/8.
 */
public interface ManagerClassInfoBusiness {

    Result<List<ManagerClassInfo>> queryByTeacherid(String teacherid);

}
