package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.AppraiseBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.DateUtil;
import io.chicken.ggs.common.vo.AppraiseVo;
import io.chicken.ggs.common.vo.AwardInfoVo;
import io.chicken.ggs.common.vo.AwardQuotaVo;
import io.chicken.ggs.common.vo.AwardSchoolVo;
import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AwardInfo;
import io.chicken.ggs.dal.model.AwardQuota;
import io.chicken.ggs.dal.model.AwardSchool;
import io.chicken.ggs.service.AppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Result<List<Appraise>> queryList(String appraiseName, Integer pageNum, Integer pageSize) {
        if (appraiseName == null) {
            appraiseName = "";
        }
        //查询列表数据
        List<Appraise> appraiseList = null;
        long total=0;
        try {
            appraiseList = appraiseService.queryList(appraiseName, pageNum, pageSize);
            total = appraiseService.queryTotal(appraiseName, pageNum, pageSize);
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
    public Result save(AppraiseVo appraiseVo) {
        //保存评优表
        Appraise appraise=new Appraise();
        appraise.setAppraisedate(DateUtil.getCurrentTime("yyyy-MM-dd"));
        appraise.setAppraisecode(appraiseVo.getAppraisecode());
        appraise.setAppraisename(appraiseVo.getAppraisename());
        appraise.setAppraiselevel(appraiseVo.getAppraiselevel());
        appraise.setCreateTime(new Date());
        appraiseService.save(appraise);
        //保存奖项信息表
        List<AwardInfo> awardInfolist=new ArrayList<AwardInfo>();

        //保存奖项学校列表
        List<AwardSchool> awardSchoollist=new ArrayList<AwardSchool>();

        List<AwardQuota> awardQuotalist=new ArrayList<AwardQuota>();


        //循环接收到的奖项信息
        List<AwardInfoVo> awardInfoVoList = appraiseVo.getAwardInfoList();
        for(AwardInfoVo awardInfoVo:awardInfoVoList)
        {
            AwardInfo awardInfo=new AwardInfo();
            awardInfo.setAppraisecode(appraiseVo.getAppraisecode());
            awardInfo.setAwardcode(awardInfoVo.getAwardcode());
            awardInfo.setAwardname(awardInfoVo.getAwardname());
            awardInfo.setAwardlevel( awardInfoVo.getAwardlevel());
            awardInfo.setCreateTime(new Date());
            awardInfo.setRemark(awardInfoVo.getRemark());
            awardInfolist.add(awardInfo);
            List<AwardSchoolVo> awardSchoolList = awardInfoVo.getAwardSchoolList();
            for(AwardSchoolVo awardSchoolVo:awardSchoolList)
            {
                AwardSchool awardSchool=new AwardSchool();
                awardSchool.setAppraisecode(appraiseVo.getAppraisecode());
                awardSchool.setAwardcode(awardInfo.getAwardcode());
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
                awardQuota.setAppraisecode(appraiseVo.getAppraisecode());
                awardQuota.setAwardcode(awardInfo.getAwardcode());
                awardQuota.setCreateTime(new Date());
                awardQuota.setAwardquota(awardQuotaVo.getAwardquota());
                awardQuota.setQuotacontent(awardQuotaVo.getQuotacontent());
                awardQuota.setRemark(awardQuotaVo.getRemark());
                awardQuotalist.add(awardQuota);
            }
        }
        appraiseService.saveAwardInfo(awardInfolist);
        appraiseService.saveAwardQuotoInfo(awardQuotalist);
        appraiseService.saveAwardSchoolInfo(awardSchoollist);
        return null;
    }
}
