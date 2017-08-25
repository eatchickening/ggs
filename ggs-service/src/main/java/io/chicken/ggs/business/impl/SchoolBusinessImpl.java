package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.SchoolBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.dal.model.School;
import io.chicken.ggs.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by mengxiangxiang on 2017/8/25.
 */
@Component("schoolBusiness")
public class SchoolBusinessImpl implements SchoolBusiness {
    private static final Logger logger = LoggerFactory.getLogger(SchoolBusinessImpl.class);

    @Autowired
    private SchoolService schoolService;
    @Override
    public Result getSchoolList(Map<String, Object> params) {
        //查询列表数据
        Query query=null;
        try{
            query = new Query(params);
        }catch(Exception e)
        {
            logger.error("参数异常",e);
            return new Result<>(ResultCode.PARAMETER_INVALID);
        }
        List<School> listSchool=null;
        long total=0;
        try
        {
            listSchool = schoolService.queryList(query);
            total = schoolService.queryTotal(query);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal(total);
        result.setData(listSchool);
        return result;
    }
    @Override
    public Result getSchoolByCondition(Map<String, Object> params) {
        //查询列表数据
        List<School> listSchool=null;
        long total=0;
        try
        {
            listSchool = schoolService.queryList(params);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal((long)listSchool.size());
        result.setData(listSchool);
        return result;
    }

}
