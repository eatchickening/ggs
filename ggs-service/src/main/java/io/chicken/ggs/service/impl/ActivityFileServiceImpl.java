/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.dao.ActivityFileMapper;
import io.chicken.ggs.dal.model.ActivityFile;
import io.chicken.ggs.service.ActivityFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wung 2017/9/5.
 */
@Service
public class ActivityFileServiceImpl implements ActivityFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityFileServiceImpl.class);

    @Autowired
    private ActivityFileMapper activityFileMapper;

    @Override
    public void save(ActivityFile activityFile) {
        LOGGER.info("save(), param = " + activityFile);
        if (activityFile == null) {
            throw new GGSException(ResultCode.PARAMETER_EMPTY);
        }
        activityFileMapper.insert(activityFile);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete(), id = " + id);
        if (id == null) {
            throw new GGSException(ResultCode.PARAMETER_EMPTY);
        }
        activityFileMapper.deleteByPrimaryKey(id);
    }
}
