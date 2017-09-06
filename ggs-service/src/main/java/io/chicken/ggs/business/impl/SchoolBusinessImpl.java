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

import java.util.ArrayList;
import java.util.HashMap;
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
        Long total=null;
        try
        {
            listSchool = schoolService.queryList(query);
            total = schoolService.queryTotal(query);
            if(total==null)total=new Long(0);
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
            listSchool = schoolService.getSchoolByCondition(params);
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

    @Override
    public Result getAllSchool(Map<String, Object> params) {
        //查询列表数据
        List<School> listSchool=null;
        Map<String,List<School>> returnmap=new HashMap<String,List<School>>();
        long total=0;
        try
        {
            listSchool = schoolService.getSchoolByCondition(params);
            for(School school:listSchool) {
                if (returnmap.get(school.getSchooltype()) == null)
                {
                    List<School> list=new ArrayList<School>();
                    list.add(school);
                    returnmap.put(school.getSchooltype(),list);
                }else
                {
                    returnmap.get(school.getSchooltype()).add(school);
                }
            }


        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal((long)listSchool.size());
        result.setData(returnmap);
        return result;
    }

}
