/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.AppraiseBusiness;
import io.chicken.ggs.business.AppraisedActivityBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.PropertiesUtils;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.common.vo.AppraisedActivityVO;
import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AppraisedActivity;
import io.chicken.ggs.service.AppraisedActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author wung 2017/9/5.
 */
@Service
public class AppraisedActivityBusinessImpl implements AppraisedActivityBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppraisedActivityBusinessImpl.class);

    @Autowired
    private AppraisedActivityService appraisedActivityService;
    @Autowired
    private AppraiseBusiness appraiseBusiness;

    @Override
    public Result<List<AppraisedActivityVO>> queryList(AppraisedActivityQueryParam param) {
        Result<List<AppraisedActivityVO>> result;

        // 查询总条数
        Result<Long> countResult = queryTotal(param);
        if (!countResult.isSuccess()) {
            result = new Result<>(countResult.getCode(), countResult.getMessage());
            return result;
        }
        Long count = countResult.getData();
        if (count == 0L) {
            result = new Result<>(Collections.<AppraisedActivityVO>emptyList());
            result.setTotal(0L);
            return result;
        }

        try {
            // 查询活动列表
            List<AppraisedActivity> appraisedActivityList = appraisedActivityService.queryList(param);
            if (appraisedActivityList.isEmpty()) {
                result = new Result<>(Collections.<AppraisedActivityVO>emptyList());
                result.setTotal(0L);
                return result;
            }
            List<Long> appraiseIdList = PropertiesUtils.getPropertyList(appraisedActivityList, "appraiseId");
            // 查询评优数据
            Map<Long, Appraise> appraiseMap;
            Result<List<Appraise>> appraiseListResult = appraiseBusiness.queryListByIds(appraiseIdList);
            if (!appraiseListResult.isSuccess()) {
                appraiseMap = Collections.emptyMap();
            }
            else {
                appraiseMap = PropertiesUtils.convertList2Map(appraiseListResult.getData(), "id");
            }

            // 组装成VO数据
            List<AppraisedActivityVO> appraisedActivityVOList = new ArrayList<>(appraisedActivityList.size());
            for (AppraisedActivity appraisedActivity : appraisedActivityList) {
                AppraisedActivityVO appraisedActivityVO = new AppraisedActivityVO();
                Appraise appraise = appraiseMap.get(appraisedActivity.getAppraiseId());
                if (appraise != null) {
                    BeanUtils.copyProperties(appraise, appraisedActivityVO);
                }
                BeanUtils.copyProperties(appraisedActivity, appraisedActivityVO);
                appraisedActivityVOList.add(appraisedActivityVO);
            }

            result =  new Result<>(appraisedActivityVOList);
            result.setTotal(count);
            return result;
        } catch (Exception e) {
            LOGGER.error("queryList(), 异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }

    @Override
    public Result<Long> queryTotal(AppraisedActivityQueryParam param) {
        try {
            Long count = appraisedActivityService.queryTotal(param);
            return new Result<>(count);
        } catch (Exception e) {
            LOGGER.error(param + " 查询活动数量异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }

    @Override
    public Result<Long> save(AppraisedActivity appraisedActivity) {
        try {
            Long id = appraisedActivityService.save(appraisedActivity);
            return new Result<>(id);
        } catch (Exception e) {
            LOGGER.error(appraisedActivity.getActivityName() + " save() 异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_ADD_FAIL);
        }
    }
}
