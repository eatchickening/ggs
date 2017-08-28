package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.TeacherBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.common.vo.TeacherList;
import io.chicken.ggs.dal.model.Teacher;
import io.chicken.ggs.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/24/17.
 */
@Component("teacherBusiness")
public class TeacherBusinessImpl implements TeacherBusiness{
    private static final Logger logger = LoggerFactory.getLogger(LoginBusinessImpl.class);

    @Autowired
    private TeacherService teacherService;

    @Override
    public Result queryTeacherList(Map<String, Object> teaMap) {
        //查询列表数据
        Query query=null;
        try {
            query = new Query(teaMap);
        } catch(Exception e) {
            logger.error("参数异常",e);
            return new Result<>(ResultCode.PARAMETER_INVALID);
        }
        List<TeacherList> teacherList=null;
        long total=0;
        try {
            teacherList = teacherService.queryTeacherList(query);
            total = teacherService.queryTotal(query);
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
            result.setData(teacherList);
        }
        return result;
    }
}
