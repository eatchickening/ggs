package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.SchoolBusinessImpl;
import io.chicken.ggs.business.impl.StudentBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.util.BeanUtilTest;
import io.chicken.ggs.common.vo.SchoolVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Api(description = "学校表相关操作")
@Controller
@RequestMapping("/ggs/school")
public class SchoolController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    @Autowired
    private SchoolBusinessImpl schoolBusiness;
    @ApiOperation(value = "学校信息查询接口")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody SchoolVo schoolVo){
        Map<String, Object> params= BeanUtilTest.transBean2Map(schoolVo);
        logger.info(params.toString());
        return schoolBusiness.getSchoolList(params);
    }
    @ApiOperation(value = "根据地区和学校类型获取学校接口")
    @ResponseBody
    @RequestMapping(value = "/listbyCondition", method = RequestMethod.POST)
    public Result listbyCondition(@RequestBody SchoolVo schoolVo){
        Map<String, Object> params= BeanUtilTest.transBean2Map(schoolVo);
        logger.info(params.toString());
        return schoolBusiness.getSchoolByCondition(params);
    }


    @ApiOperation(value = "根据地区和学校类型获取学校接口")
    @ResponseBody
    @RequestMapping(value = "/getAllSchool", method = RequestMethod.GET)
    public Result getAllSchool(){
        Map<String, Object> params= new HashMap<String, Object>();
        return schoolBusiness.getAllSchool(params);
    }
}
