/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.AppraisedActivityBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.common.vo.AppraisedActivityVO;
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

import java.util.List;

/**
 * 评优活动接口
 *
 * @author wung 2017/9/4.
 */
@Api(description = "评优活动相关接口")
@Controller
@RequestMapping("/ggs/activity")
public class AppraisedActivityController {

    private static final Logger logger = LoggerFactory.getLogger(AppraisedActivityController.class);

    @Autowired
    private AppraisedActivityBusiness appraisedActivityBusiness;

    @ApiOperation(value = "活动列表")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<AppraisedActivityVO>> querylist(@RequestBody AppraisedActivityQueryParam params) {
        logger.info("querylist() params = " + params);
        if (params == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        return appraisedActivityBusiness.queryList(params);
    }

}
