package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.TeacherBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.dal.model.Student;
import io.chicken.ggs.dal.model.Teacher;
import io.chicken.ggs.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/24/17.
 */
@Controller
@RequestMapping("/ggs/teacher")
public class TeacherController {
  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
  @Autowired
  private TeacherBusiness teacherBusiness;

  @RequestMapping(value="/list", method = RequestMethod.POST)
  public Result teacherList(@RequestParam Map<String,Object> teaMap){
    return teacherBusiness.queryTeacherList(teaMap);
  }
}
