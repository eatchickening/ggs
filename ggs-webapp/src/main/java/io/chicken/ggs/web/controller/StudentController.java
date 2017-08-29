package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.StudentBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.dal.model.Student;
import io.chicken.ggs.service.StudentService;
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
@Controller
@RequestMapping("/ggs/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentBusinessImpl studentBusiness;
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody Map<String, Object> params){
        logger.info(params.toString());
        return studentBusiness.getStudentList(params);
    }
}
