package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.AwardLevelEnum;
import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.dal.dao.*;
import io.chicken.ggs.dal.model.*;
import io.chicken.ggs.service.AppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/31/17.
 */
@Service("appraiseService")
public class AppraiseServiceImpl implements AppraiseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppraiseServiceImpl.class);

    @Autowired
    private AppraiseMapper appraiseMapper;

    @Autowired
    private AwardInfoMapper awardInfoMapper;
    @Autowired
    private AwardSchoolMapper awardSchoolMapper;
    @Autowired
    private AwardQuotaMapper awardQuotaMapper;

    @Autowired
    private AwardClassMapper awardClassMapper;

    @Autowired
    private AwardFileMapper awardFileMapper;


    @Override
    public List<Appraise> queryList(Map<String, Object> params) {
        return appraiseMapper.queryList(params);

    }

    @Override
    public Long queryTotal(Map<String, Object> params) {
       return appraiseMapper.queryTotal(params);
    }



    @Override
    public long save(Appraise appraise) {
        return appraiseMapper.insertSelective(appraise);
    }

    @Override
    public long update(Appraise appraise) {
       return appraiseMapper.updateByPrimaryKeySelective(appraise);
    }

    @Override
    public void saveAwardInfo(List<AwardInfo> awardInfolist) {
        awardInfoMapper.insertCollection(awardInfolist);
    }

    @Override
    public void saveAwardInfo(AwardInfo awardInfo) {
        awardInfoMapper.insertSelective(awardInfo);
    }

    @Override
    public void saveAwardSchoolInfo(List<AwardSchool> awardSchoollist) {
        awardSchoolMapper.insertCollection(awardSchoollist);
    }

    @Override
    public void saveAwardQuotoInfo(List<AwardQuota> awardQuotalist) {
        awardQuotaMapper.insertCollection(awardQuotalist);
    }

    @Override
    public void saveAwardClassInfo(List<AwardClass> awardClasslist) {
        awardClassMapper.insertCollection(awardClasslist);
    }



    @Override
    public void saveAwardFileInfo(List<AwardFile> awardFilelist) {
        awardFileMapper.insertCollection(awardFilelist);
    }

    @Override
    public List<Appraise> queryListByIds(List<Long> ids) {
        LOGGER.info("queryListByIds(), ids = " + ids);
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        return appraiseMapper.queryListByIds(ids);
    }

    @Override
    public void delete(Long id) {
        awardFileMapper.deleteByAppraisecode(id+"");
        awardQuotaMapper.deleteByAppraisecode(id+"");
        awardSchoolMapper.deleteByAppraisecode(id+"");
        awardInfoMapper.deleteByAppraisecode(id+"");
        appraiseMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void deleteSchoolAppraise(Long id){
        awardFileMapper.deleteByAppraisecode(id+"");
        awardQuotaMapper.deleteByAppraisecode(id+"");
        awardClassMapper.deleteByAppraisecode(id+"");
        awardInfoMapper.deleteByAppraisecode(id+"");
        appraiseMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void deleteAwardInfo(Long id) {
        awardFileMapper.deleteByAppraisecode(id+"");
        awardQuotaMapper.deleteByAppraisecode(id+"");
        awardSchoolMapper.deleteByAppraisecode(id+"");
        awardInfoMapper.deleteByAppraisecode(id+"");
    }

    @Override
    public void deleteAwardInfoSchool(Long id) {
        awardFileMapper.deleteByAppraisecode(id+"");
        awardQuotaMapper.deleteByAppraisecode(id+"");
        awardClassMapper.deleteByAppraisecode(id+"");
        awardInfoMapper.deleteByAppraisecode(id+"");
    }


    @Override
    public AppraiseDetail selectByAppraisId(long id) {

        AppraiseDetail appraise= appraiseMapper.selectByPrimaryKey(id);

        List<AwardInfoDetail> awardInfos = awardInfoMapper.selectByAppraisId(id + "");

        List<AwardInfoDetail> awardInfoDetails=new ArrayList<AwardInfoDetail>();

        for(AwardInfo awardInfo:awardInfos){
            AwardInfoDetail awardInfoDetail=(AwardInfoDetail)awardInfo;
            List<AwardFile> awardFiles = awardFileMapper.selectByAwardInfoId(awardInfo.getId() + "");

            List<AwardQuota> awardQuotas = awardQuotaMapper.selectByAwardInfoId(awardInfo.getId() + "");


            if(AwardLevelEnum.getByCode(appraise.getAppraiselevel())==AwardLevelEnum.SCHOOLLEVEL)
            {
                List<AwardClass> awardClasses = awardClassMapper.selectByAwardInfoId(awardInfo.getId() + "");
                awardInfoDetail.setAwardClass(awardClasses);
            }else
            {
                List<AwardSchool> awardSchools = awardSchoolMapper.selectByAwardInfoId(awardInfo.getId() + "");
                awardInfoDetail.setAwardSchools(awardSchools);
            }

            awardInfoDetail.setAwardFiles(awardFiles);
            awardInfoDetail.setAwardQuotas(awardQuotas);


            awardInfoDetails.add(awardInfoDetail);
        }
        appraise.setAwardInfoList(awardInfoDetails);
        return appraise;
    }

    @Override
    public AppraiseDetail selectByAppraisInfo(long id) {
        AppraiseDetail appraise= appraiseMapper.selectByPrimaryKey(id);

        List<AwardInfoDetail> awardInfos = awardInfoMapper.selectByAppraisId(id + "");

        List<AwardInfoDetail> awardInfoDetails=new ArrayList<AwardInfoDetail>();
        List<AwardSchoolDetail> awardSchoolDetail = awardSchoolMapper.selectDetailByAppraiseId(id + "");

        appraise.setAwardSchoolDetailList(awardSchoolDetail);

        for(AwardInfo awardInfo:awardInfos){
            List<AwardFile> awardFiles = awardFileMapper.selectByAwardInfoId(awardInfo.getId() + "");

            List<AwardQuota> awardQuotas = awardQuotaMapper.selectByAwardInfoId(awardInfo.getId() + "");

            AwardInfoDetail awardInfoDetail=(AwardInfoDetail)awardInfo;
            awardInfoDetail.setAwardFiles(awardFiles);
            awardInfoDetail.setAwardQuotas(awardQuotas);

            awardInfoDetails.add(awardInfoDetail);
        }
        appraise.setAwardInfoList(awardInfoDetails);
        return appraise;
    }
}
