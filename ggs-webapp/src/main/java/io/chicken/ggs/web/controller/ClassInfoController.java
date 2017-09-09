package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.ClassInfoBusiness;
import io.chicken.ggs.business.impl.SchoolBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.util.BeanUtilTest;
import io.chicken.ggs.common.vo.ClassInfoVo;
import io.chicken.ggs.common.vo.SchoolVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Api(description = "班级信息相关操作")
@Controller
@RequestMapping("/ggs/classinfo")
public class ClassInfoController {

    private static final Logger logger = LoggerFactory.getLogger(ClassInfoController.class);
    @Autowired
    private ClassInfoBusiness classInfoBusiness;
    @ApiOperation(value = "班级信息查询接口")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody ClassInfoVo classInfoVo){
        Map<String, Object> params= BeanUtilTest.transBean2Map(classInfoVo);
        logger.info(params.toString());
        return classInfoBusiness.getClassInfoList(params);
    }

}
