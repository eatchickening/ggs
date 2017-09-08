package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.impl.DictionaryBusinessImpl;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.AreaDetailVO;
import io.chicken.ggs.dal.model.Dictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *mengxiangxiang
 */

@Api(description = "字典表相关操作")
@Controller
@RequestMapping("/ggs/dictionary")
public class DictionaryController {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);
    @Autowired
    private DictionaryBusinessImpl dictionaryBusiness;

    @ApiOperation(value = "根据类型获取字典表该类型数据接口")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiImplicitParam(name = "biztype", value = "业务类型", required = true, paramType = "form")
    public Result list(String biztype){
        if(biztype==null)
        {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        Map<String, Object> params=new HashMap<String, Object>();
        params.put("biztype",biztype);
        logger.info(params.toString());
        return dictionaryBusiness.getDictionaryList(params);
    }
    @ApiOperation(value = "根据类型和业务编码获取字典表数据")
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
    @ApiOperation(value = "根据区域编码查询其下面的机构、部门、岗位的信息,为空的话返回所有")
    @ResponseBody
    @RequestMapping(value = "/areaDetail", method = RequestMethod.POST)
    public Result<List<AreaDetailVO>> areaDetail(@RequestBody Dictionary dictionary) {
        logger.info("areaDetail() " + dictionary);
        return dictionaryBusiness.queryAreaDetail(dictionary.getBizcode());
    }



}
