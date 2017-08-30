package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.StudentBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.BeanUtilTest;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.common.vo.StudentVo;
import io.chicken.ggs.dal.model.Student;
import io.chicken.ggs.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Api(description = "学生表相关操作")
@Controller
@RequestMapping("/ggs/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentBusinessImpl studentBusiness;
    @ApiOperation(value = "学生信息查询接口")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody StudentVo studentVo){
        Map<String, Object> params= BeanUtilTest.transBean2Map(studentVo);
        logger.info(params.toString());
        return studentBusiness.getStudentList(params);
    }
}
