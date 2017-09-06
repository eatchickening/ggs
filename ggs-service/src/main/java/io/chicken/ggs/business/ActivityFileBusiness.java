/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.ActivityFile;

/**
 * @author wung 2017/9/5.
 */
public interface ActivityFileBusiness {

    Result save(ActivityFile activityFile);

    Result delete(Long id);
}
