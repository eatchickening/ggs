/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.ActivityFileBusiness;
import io.chicken.ggs.business.AppraisedActivityBusiness;
import io.chicken.ggs.common.AppraisedActivityStatusEnum;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.ValidateErrorResult;
import io.chicken.ggs.common.util.ValidatorUtils;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.common.vo.AppraisedActivityVO;
import io.chicken.ggs.dal.model.ActivityFile;
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
import java.util.UUID;

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
    @Autowired
    private ActivityFileBusiness activityFileBusiness;

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

    @ApiOperation(value = "评优活动的材料上传")
    @ApiImplicitParam(value = "评优活动id", name = "id", dataType = "Long", paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam Long id, MultipartFile file) {
        logger.info("upload() id = " + id);
        if (id == null || file == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        System.out.println(file.getOriginalFilename());

        // 处理文件 todo

        // 保存路径信息
        String origFileName = file.getOriginalFilename();
        String fileType = origFileName.substring(origFileName.lastIndexOf(".")).toLowerCase();
        String sysFileName = UUID.randomUUID().toString() + fileType;

        ActivityFile activityFile = new ActivityFile();
        activityFile.setOrigFileName(origFileName);
        activityFile.setSysFileName(sysFileName);
        activityFile.setFileType(fileType);
        activityFile.setActivityId(id);
        return activityFileBusiness.save(activityFile);
    }


    @ApiOperation(value = "更新评优活动")
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody AppraisedActivity appraisedActivity) {
        logger.info("update() params = " + appraisedActivity);
        if (appraisedActivity == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        ValidateErrorResult errorResult = ValidatorUtils.validateEntityLazy(appraisedActivity);
        if (errorResult != null) {
            return new Result<>(errorResult);
        }

        return appraisedActivityBusiness.update(appraisedActivity);
    }


    @ApiOperation(value = "删除评优活动")
    @ApiImplicitParam(value = "评优活动id", name = "id", dataType = "Long", paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(Long id) {
        logger.info("delete() id = " + id);
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        return appraisedActivityBusiness.delete(id);
    }

    @ApiOperation(value = "删除评优活动的材料")
    @ApiImplicitParam(value = "材料id", name = "id", dataType = "Long", paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    public Result deleteFile(Long id) {
        logger.info("deleteFile() id = " + id);
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        return activityFileBusiness.delete(id);
    }

    @ApiOperation(value = "结束评优活动")
    @ApiImplicitParam(value = "评优活动id", name = "id", dataType = "Long", paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public Result end(Long id) {
        logger.info("end() id = " + id);
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        AppraisedActivity appraisedActivity = new AppraisedActivity();
        appraisedActivity.setId(id);
        appraisedActivity.setActivityStatus(AppraisedActivityStatusEnum.END.getCode());

        return appraisedActivityBusiness.update(appraisedActivity);
    }

}
