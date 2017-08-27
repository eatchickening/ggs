/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Organization;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
public interface OrganizationBusiness {

    Result<List<Organization>> queryByAreacode(String areacode);
}
