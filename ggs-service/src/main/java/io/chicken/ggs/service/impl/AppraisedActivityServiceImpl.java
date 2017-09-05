/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.AppraisedActivityStatusEnum;
import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.dal.dao.AppraisedActivityMapper;
import io.chicken.ggs.dal.model.AppraisedActivity;
import io.chicken.ggs.service.AppraisedActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        appraisedActivity.setActivityStatus(AppraisedActivityStatusEnum.STARTING.getCode());
        appraisedActivityMapper.insertSelective(appraisedActivity);
        return appraisedActivity.getId();
    }

    @Override
    public void update(AppraisedActivity appraisedActivity) {
        LOGGER.info("update(), param = " + appraisedActivity);
        if (appraisedActivity.getId() == null) {
            throw new GGSException(ResultCode.PARAMETER_INVALID);
        }
        appraisedActivity.setUpdateTime(new Date());
        appraisedActivityMapper.updateByPrimaryKeySelective(appraisedActivity);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete(), id = " + id);
        if (id == null) {
            throw new GGSException(ResultCode.PARAMETER_EMPTY);
        }
        appraisedActivityMapper.deleteByPrimaryKey(id);
    }
}
