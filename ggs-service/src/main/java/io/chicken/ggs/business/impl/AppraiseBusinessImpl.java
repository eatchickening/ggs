package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.AppraiseBussiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.service.AppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
public class AppraiseBusinessImpl implements AppraiseBussiness {

    private static final Logger logger = LoggerFactory.getLogger(AppraiseBusinessImpl.class);

    @Autowired
    private AppraiseService appraiseService;

    public Result<List<Appraise>> queryList(String appraiseName, Integer pageNum, Integer pageSize) {
        //查询列表数据
        List<Appraise> appraiseList = null;
        long total=0;
        try {
            appraiseList = appraiseService.queryList(appraiseName, pageNum, pageSize);
            total = appraiseService.queryTotal(appraiseName, pageNum, pageSize);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal(total);
        if (total == 0) {
            result.setData(Collections.EMPTY_LIST);
        }
        else {
            result.setData(appraiseList);
        }
        return result;

    }
}
