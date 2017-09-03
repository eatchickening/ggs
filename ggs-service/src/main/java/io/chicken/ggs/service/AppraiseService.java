package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AwardInfo;
import io.chicken.ggs.dal.model.AwardQuota;
import io.chicken.ggs.dal.model.AwardSchool;

import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
public interface AppraiseService {

    List<Appraise> queryList(String appraiseName, Integer pageNum, Integer pageSize);

    long queryTotal(String appraiseName, Integer pageNum, Integer pageSize);

    void save(Appraise appraise);
    void saveAwardInfo(List<AwardInfo> awardInfolist);

    void saveAwardSchoolInfo(List<AwardSchool> awardSchoollist);

    void saveAwardQuotoInfo(List<AwardQuota> awardQuotalist);
}
