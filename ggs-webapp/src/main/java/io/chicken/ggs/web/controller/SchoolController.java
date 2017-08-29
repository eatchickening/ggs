package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.SchoolBusinessImpl;
import io.chicken.ggs.business.impl.StudentBusinessImpl;
import io.chicken.ggs.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/ggs/school")
public class SchoolController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    @Autowired
    private SchoolBusinessImpl schoolBusiness;
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody Map<String, Object> params){
        logger.info(params.toString());
        return schoolBusiness.getSchoolList(params);
    }
    @ResponseBody
    @RequestMapping(value = "/listbyCondition", method = RequestMethod.POST)
    public Result listbyCondition(@RequestBody Map<String, Object> params){
        logger.info(params.toString());
        return schoolBusiness.getSchoolByCondition(params);
    }
}
