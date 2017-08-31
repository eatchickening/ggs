/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Depart;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
public interface DepartBusiness {

    Result<List<Depart>> queryByOrgancode(String organcode);

    Result<Long> save(Depart depart);

    Result<Boolean> delete(Long id);

}
