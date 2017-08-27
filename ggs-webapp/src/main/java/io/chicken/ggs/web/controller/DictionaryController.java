package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.DictionaryBusinessImpl;
import io.chicken.ggs.business.impl.SchoolBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Dictionary;
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


    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Result get(Dictionary dictionary) {
        logger.info("get() " + dictionary);

        Map<String, Object>  params = new HashMap<>(2);
        params.put("biztype", dictionary.getBiztype());
        params.put("bizcode", dictionary.getBizcode());
        return dictionaryBusiness.queryList(params);
    }


}
