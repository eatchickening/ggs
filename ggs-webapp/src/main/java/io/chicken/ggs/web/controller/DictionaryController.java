package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.DictionaryBusinessImpl;
import io.chicken.ggs.business.impl.SchoolBusinessImpl;
import io.chicken.ggs.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/ggs/dictionary")
public class DictionaryController {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);
    @Autowired
    private DictionaryBusinessImpl dictionaryBusiness;
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestParam Map<String, Object> params){
        logger.info(params.toString());
        return dictionaryBusiness.getDictionaryList(params);
    }
}
