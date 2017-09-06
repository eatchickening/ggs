/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.ActivityFile;

/**
 *
 * @author wung 2017/9/5.
 */
public interface ActivityFileService {

    void save(ActivityFile activityFile);

    void delete(Long id);
}
