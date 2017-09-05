/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.dal.dao.AppraisedActivityMapper;
import io.chicken.ggs.dal.model.AppraisedActivity;
import io.chicken.ggs.service.AppraisedActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wung 2017/9/5.
 */
@Service
public class AppraisedActivityServiceImpl implements AppraisedActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppraisedActivityServiceImpl.class);

    @Autowired
    private AppraisedActivityMapper appraisedActivityMapper;

    @Override
    public List<AppraisedActivity> queryList(AppraisedActivityQueryParam param) {
        LOGGER.info("查询活动列表, param  = " + param);
        if (param.getPageNum() == null) {
            param.setPageNum(CommonConstant.PAGE_NUM);
        }
        if (param.getPageSize() == null) {
            param.setPageSize(CommonConstant.PAGE_SIZE);
        }
        Integer start = (param.getPageNum() - 1) * param.getPageSize();
        return appraisedActivityMapper.queryList(param, start, param.getPageSize() * CommonConstant.PAGE_PRE);
    }

    @Override
    public Long queryTotal(AppraisedActivityQueryParam param) {
        LOGGER.info("查询活动的数量, param  = " + param);
        return appraisedActivityMapper.queryTotal(param);
    }

    @Override
    public Long save(AppraisedActivity appraisedActivity) {
        LOGGER.info("save(), param = " + appraisedActivity);
        appraisedActivityMapper.insertSelective(appraisedActivity);
        return appraisedActivity.getId();
    }
}
