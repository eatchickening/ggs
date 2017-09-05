/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.ActivityFileBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
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
public class ActivityFileBusinessImpl implements ActivityFileBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityFileBusinessImpl.class);

    @Autowired
    private ActivityFileService activityFileService;

    @Override
    public Result save(ActivityFile activityFile) {
        try {
            activityFileService.save(activityFile);
            return new Result(ResultCode.SUCCESS);
        } catch (Exception e) {
            LOGGER.error(activityFile.getOrigFileName() + ", save() 异常： " + e.getMessage());
            return new Result(ResultCode.UPLOAD_EXCEPTION);
        }
    }
}
