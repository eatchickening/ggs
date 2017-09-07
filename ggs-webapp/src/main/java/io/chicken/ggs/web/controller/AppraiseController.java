package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.AppraiseBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.AppraiseVo;
import io.chicken.ggs.common.vo.AreaDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nyh on 8/31/17.
 *
 * 评优奖项管理
 */
@Api(description = "评优奖项管理")
@RestController
@RequestMapping("/ggs/appr")
public class AppraiseController {
    public static final Logger logger = LoggerFactory.getLogger(AppraiseController.class);

    @Autowired
    private AppraiseBusiness appraiseBusiness;

    @ApiOperation(value = "获取评优奖项列表", notes="默认name参数为空, pageSize pageNum不能为空")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "评优名称", required = false, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "String", paramType = "form")
    })
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result appraiseList(String name,
                              String pageNum,
                              String pageSize){
        return appraiseBusiness.queryList(name, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

    @ApiOperation(value = "评优奖项文件保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appraisename", value = "评优名称", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "awardname", value = "奖项名称", required = true, dataType = "String", paramType = "form"),
    })
    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
    @ResponseBody
    public Result save(String appraisename,String awardname, MultipartFile file ) {
        logger.info("评优奖项信息:"+appraisename+"awardcode"+awardname);
        return appraiseBusiness.savefile(appraisename,awardname,file);
    }

    @ApiOperation(value = "评优奖项信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result save(@RequestBody AppraiseVo appraiseVo) throws Exception{
        logger.info("评优奖项信息:"+appraiseVo.toString());
        return appraiseBusiness.save(appraiseVo);
    }

    @ApiOperation(value = "评优奖项信息修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result update(@RequestBody AppraiseVo appraiseVo) throws Exception{
        logger.info("评优奖项信息:"+appraiseVo.toString());
        return appraiseBusiness.update(appraiseVo);
    }

    @ApiOperation(value = "删除评优奖项")
    @ApiImplicitParam(value = "评优奖项id", name = "id", dataType = "Long", paramType = "form")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(Long id) {
        logger.info("delete() id = " + id);
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        return appraiseBusiness.delete(id);
    }

    @ApiOperation(value = "查看评优奖项详情")
    @ApiImplicitParam(value = "评优奖项id", name = "id", dataType = "Long", paramType = "form")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result getDetail(Long id) {
        logger.info("getDetail() id = " + id);
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        return appraiseBusiness.getDetail(id);
    }




}
