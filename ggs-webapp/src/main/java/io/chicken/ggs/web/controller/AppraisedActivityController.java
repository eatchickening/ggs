/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.AppraisedActivityBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.ValidateErrorResult;
import io.chicken.ggs.common.util.ValidatorUtils;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.common.vo.AppraisedActivityVO;
import io.chicken.ggs.dal.model.AppraisedActivity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "建立评优活动")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Long> save(@RequestBody AppraisedActivity appraisedActivity) {
        logger.info("save() params = " + appraisedActivity);
        if (appraisedActivity == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        ValidateErrorResult errorResult = ValidatorUtils.validateEntityLazy(appraisedActivity);
        if (errorResult != null) {
            return new Result<>(errorResult);
        }

        return appraisedActivityBusiness.save(appraisedActivity);
    }

}
