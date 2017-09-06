package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.AppraiseBusiness;
import io.chicken.ggs.common.AwardLevelEnum;
import io.chicken.ggs.common.GGSException;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.DateUtil;
import io.chicken.ggs.common.vo.*;
import io.chicken.ggs.dal.model.*;
import io.chicken.ggs.service.AppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
@Component("appraiseBusiness")
public class AppraiseBusinessImpl implements AppraiseBusiness {

    private static final Logger logger = LoggerFactory.getLogger(AppraiseBusinessImpl.class);

    @Autowired
    private AppraiseService appraiseService;

    @Value("${file.basepath}")
    private String storefile;
    public Result<List<Appraise>> queryList(String appraiseName, Integer pageNum, Integer pageSize) {

        //查询列表数据
        List<Appraise> appraiseList = null;
        Long total=new Long(0);
        try {
            appraiseList = appraiseService.queryList(appraiseName, pageNum, pageSize);
            for(Appraise appraise:appraiseList)
            {
                AwardLevelEnum byCode = AwardLevelEnum.getByCode(appraise.getAppraiselevel());
                appraise.setAppraiselevel(byCode==null?null:byCode.getMessage());
            }
            total = appraiseService.queryTotal(appraiseName, pageNum, pageSize);
            logger.info("查询总数："+total);
            if(total==null)total=new Long(0);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal(total);
        if (total == 0) {
            result.setData(Collections.EMPTY_LIST);
        }
        else {
            result.setData(appraiseList);
        }
        return result;

    }

    @Override
    public Result save(AppraiseVo appraiseVo)  throws  RuntimeException{
        //保存评优表
        Appraise appraise=new Appraise();
        appraise.setAppraisedate(DateUtil.getCurrentTime("yyyy-MM-dd"));
        appraise.setAppraisename(appraiseVo.getAppraisename());
        appraise.setAppraiselevel(appraiseVo.getAppraiselevel());
        appraise.setCreateTime(new Date());
        appraiseService.save(appraise);
        long appraiseid =appraise.getId();
        //保存奖项信息表
        List<AwardInfo> awardInfolist=new ArrayList<AwardInfo>();

        //保存奖项学校列表
        List<AwardSchool> awardSchoollist=new ArrayList<AwardSchool>();

        //保存指标列表
        List<AwardQuota> awardQuotalist=new ArrayList<AwardQuota>();
        //保存文件列表
        List<AwardFile> awardFilelist=new ArrayList<AwardFile>();

        //循环接收到的奖项信息
        List<AwardInfoVo> awardInfoVoList = appraiseVo.getAwardInfoList();
        for(AwardInfoVo awardInfoVo:awardInfoVoList)
        {
            AwardInfo awardInfo=new AwardInfo();
            awardInfo.setAppraisecode(""+appraiseid);
            awardInfo.setAwardname(awardInfoVo.getAwardname());
            awardInfo.setAwardlevel( awardInfoVo.getAwardlevel());
            awardInfo.setCreateTime(new Date());
            awardInfo.setRemark(awardInfoVo.getRemark());
            appraiseService.saveAwardInfo(awardInfo);
            Long awardInfoId = awardInfo.getId();
            List<AwardSchoolVo> awardSchoolList = awardInfoVo.getAwardSchoolList();
            for(AwardSchoolVo awardSchoolVo:awardSchoolList)
            {
                AwardSchool awardSchool=new AwardSchool();
                awardSchool.setAwardcode(""+awardInfoId);
                awardSchool.setAppraisecode(""+appraiseid);
                awardSchool.setCreateTime(new Date());
                awardSchool.setSchoolcode(awardSchoolVo.getSchoolcode());
                awardSchool.setSchoolquota(awardSchoolVo.getSchoolquota());
                awardSchool.setRemark(awardSchoolVo.getRemark());
                awardSchoollist.add(awardSchool);
            }
            List<AwardQuotaVo> awardQuotaVoList = awardInfoVo.getAwardQuotaList();
            for(AwardQuotaVo awardQuotaVo:awardQuotaVoList)
            {
                AwardQuota awardQuota=new AwardQuota();
                awardQuota.setAwardcode(""+awardInfoId);
                awardQuota.setAppraisecode(""+appraiseid);
                awardQuota.setCreateTime(new Date());
                awardQuota.setAwardquota(awardQuotaVo.getAwardquota());
                awardQuota.setQuotacontent(awardQuotaVo.getQuotacontent());
                awardQuota.setRemark(awardQuotaVo.getRemark());
                awardQuotalist.add(awardQuota);
            }
            List<AwardFileVo> awardFileList = awardInfoVo.getAwardFileList();
            for(AwardFileVo awardFileVo:awardFileList)
            {
                AwardFile awardFile=new AwardFile();
                awardFile.setAppraisecode(""+appraiseid);
                awardFile.setAwardcode(""+awardInfoId);
                awardFile.setFilename(awardFileVo.getFilename());
                awardFile.setFiletype(awardFileVo.getFiletype());
                awardFile.setCreateTime(new Date());
                awardFile.setFiledetail(awardFileVo.getFiledetail());
                awardFile.setRemark(awardFileVo.getRemark());
                String path=storefile+appraiseVo.getAppraisename()+"/"+awardInfoVo.getAwardname()+"/"+awardFileVo.getFiletargetname();
                awardFile.setFilepath(path);
                awardFilelist.add(awardFile);
            }
        }
        appraiseService.saveAwardFileInfo(awardFilelist);
        appraiseService.saveAwardQuotoInfo(awardQuotalist);
        appraiseService.saveAwardSchoolInfo(awardSchoollist);
        Result result=  new Result<>(ResultCode.SUCCESS);
        return result;
    }

    @Override
    public Result savefile(String appraisecode, String awardcode, MultipartFile file) {
        if (awardcode == null || awardcode.isEmpty()||appraisecode == null || appraisecode.isEmpty()||file == null ) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        logger.info("storefilebasepath"+storefile);
        logger.info("origin:"+file.getOriginalFilename());
        String parentfile=storefile+appraisecode+"/"+awardcode+"/";
        File targetFile = new File(parentfile, System.currentTimeMillis()+"_"+file.getOriginalFilename());
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            logger.error("保存出错",e);
            Result result=  new Result<>(ResultCode.SYS_EXCEPTION);
            return result;
        }
        logger.info("targetFile:"+targetFile.getName());
        Result result=  new Result<>(ResultCode.SUCCESS);
        AwardFileVo awardFileVo=new AwardFileVo();
        awardFileVo.setFilename(file.getOriginalFilename());
        awardFileVo.setFiletargetname(targetFile.getName());
        String fileTyle=targetFile.getName().substring(targetFile.getName().lastIndexOf(".")+1,targetFile.getName().length());
        awardFileVo.setFiletype(fileTyle);
        result.setData(awardFileVo);
        return result;
    }

    @Override
    public Result<List<Appraise>> queryListByIds(List<Long> ids) {
        try {
            List<Appraise> appraises = appraiseService.queryListByIds(ids);
            for(Appraise appraise:appraises)
            {
                AwardLevelEnum byCode = AwardLevelEnum.getByCode(appraise.getAppraiselevel());
                appraise.setAppraiselevel(byCode==null?null:byCode.getMessage());
            }
            return new Result<>(appraises);
        } catch (Exception e) {
            logger.error("queryListByIds() 异常： " + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }

    @Override
    public Result delete(Long id) {
        try {
            appraiseService.delete(id);
            return new Result(ResultCode.SUCCESS);
        } catch (GGSException e) {
            return new Result(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(id + ", delete() 异常： " + e.getMessage());
            return new Result(ResultCode.DB_DELETE_FAIL);
        }


    }

    @Override
    public Result getDetail(Long id) {
        return null;
    }
}
