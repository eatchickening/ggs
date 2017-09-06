package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.*;

import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
public interface AppraiseService {

    List<Appraise> queryList(String appraiseName, Integer pageNum, Integer pageSize);

    Long queryTotal(String appraiseName, Integer pageNum, Integer pageSize);

    long save(Appraise appraise);

    void saveAwardInfo(List<AwardInfo> awardInfolist);

    void saveAwardInfo(AwardInfo awardInfo);

    void saveAwardSchoolInfo(List<AwardSchool> awardSchoollist);

    void saveAwardQuotoInfo(List<AwardQuota> awardQuotalist);

    void saveAwardFileInfo(List<AwardFile> awardFilelist);

    List<Appraise> queryListByIds(List<Long> ids);
}
