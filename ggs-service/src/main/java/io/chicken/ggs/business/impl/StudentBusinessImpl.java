package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.StudentBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.dal.model.Student;
import io.chicken.ggs.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by mengxiangxiang on 2017/8/25.
 */
@Component("studentBusiness")
public class StudentBusinessImpl implements StudentBusiness{
    private static final Logger logger = LoggerFactory.getLogger(StudentBusinessImpl.class);

    @Autowired
    private StudentService studentService;
    @Override
    public Result getStudentList(Map<String, Object> params) {
        //查询列表数据
        Query query=null;
        try{
            query = new Query(params);
        }catch(Exception e)
        {
            logger.error("参数异常",e);
            return new Result<>(ResultCode.PARAMETER_INVALID);
        }
        List<Student> listStudent=null;
        long total=0;
        try
        {
            listStudent = studentService.queryList(query);
            total = studentService.queryTotal(query);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal(total);
        result.setData(listStudent);
        return result;
    }
}
