package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.dal.dao.AppraiseMapper;
import io.chicken.ggs.dal.dao.AwardInfoMapper;
import io.chicken.ggs.dal.dao.AwardQuotaMapper;
import io.chicken.ggs.dal.dao.AwardSchoolMapper;
import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AwardInfo;
import io.chicken.ggs.dal.model.AwardQuota;
import io.chicken.ggs.dal.model.AwardSchool;
import io.chicken.ggs.service.AppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
    public List<Appraise> queryList(String appraiseName,
                                    Integer pageNum,
                                    Integer pageSize) {
        Integer start = (pageNum - 1) * pageSize;
        return appraiseMapper.queryList(appraiseName, start, pageSize * CommonConstant.PAGE_PRE);
    }

    public long queryTotal(String appraiseName,
                           Integer pageNum,
                           Integer pageSize) {
        Integer start = (pageNum - 1) * pageSize;
        return appraiseMapper.queryTotal(appraiseName, start, pageSize * CommonConstant.PAGE_PRE);
    }

    @Override
    public long save(Appraise appraise) {
        return appraiseMapper.insertSelective(appraise);
    }

    @Override
    public void saveAwardInfo(List<AwardInfo> awardInfolist) {
        awardInfoMapper.insertCollection(awardInfolist);
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
    public List<Appraise> queryListByIds(List<Long> ids) {
        LOGGER.info("queryListByIds(), ids = " + ids);
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        return appraiseMapper.queryListByIds(ids);
    }
}
