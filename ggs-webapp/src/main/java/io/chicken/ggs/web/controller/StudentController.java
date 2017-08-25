package io.chicken.ggs.web.controller;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.dal.model.Student;
import io.chicken.ggs.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/ggs/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestParam Map<String, Object> params){
        logger.info(params.toString());
        //查询列表数据
        Query query = new Query(params);
        List<Student> listStudent = studentService.queryList(query);
        long total = studentService.queryTotal(query);
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal(total);
        result.setData(listStudent);
        return  result;

    }
}
