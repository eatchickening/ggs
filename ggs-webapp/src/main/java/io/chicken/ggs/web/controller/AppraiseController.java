package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.AppraiseBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.AppraiseVo;
import io.chicken.ggs.common.vo.AreaDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
            @ApiImplicitParam(name = "pageNum", value = "每页显示个数", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "显示页数", required = true, dataType = "String", paramType = "form")
    })
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result appraiseList(String name,
                              String pageNum,
                              String pageSize){
        return appraiseBusiness.queryList(name, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

    @ApiOperation(value = "评优奖项信息保存")
    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
    @ResponseBody
    public String save(AppraiseVo appraiseVo, MultipartFile[] files ) {

        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.length; ++i) {
            file = files[i];
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }

    @ApiOperation(value = "评优奖项信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody AppraiseVo appraiseVo) {
        logger.info("评优奖项信息:"+appraiseVo.toString());
        return appraiseBusiness.save(appraiseVo);
    }

}
