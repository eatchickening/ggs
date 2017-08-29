package io.chicken.ggs.web.controller;

import com.alibaba.fastjson.JSON;
import io.chicken.ggs.business.impl.DictionaryBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.AreaDetailVO;
import io.chicken.ggs.dal.model.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    public Result list(@RequestBody Map<String, Object> params){
        logger.info(params.toString());
        return dictionaryBusiness.getDictionaryList(params);
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Result<List<Dictionary>> get(@RequestBody Dictionary dictionary) {
        logger.info("get() " + dictionary);
        if (StringUtils.isEmpty(dictionary.getBiztype())) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        Map<String, Object>  params = new HashMap<>(2);
        params.put("biztype", dictionary.getBiztype());
        if (dictionary.getBizcode() != null) {
            params.put("bizcode", dictionary.getBizcode());
        }
        return dictionaryBusiness.queryList(params);
    }


    /**
     * 根据区域编码查询其下面的机构、部门、岗位的信息
     *
     * @param dictionary
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/areaDetail", method = RequestMethod.POST)
    public Result<List<AreaDetailVO>> areaDetail(@RequestBody Dictionary dictionary) {
        logger.info("areaDetail() " + dictionary);
       /* if (StringUtils.isEmpty(dictionary.getBizcode())) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }*/

        return dictionaryBusiness.queryAreaDetail(dictionary.getBizcode());
    }



}
