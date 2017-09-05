/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.dal.model.AppraisedActivity;

import java.util.List;

/**
 *
 * @author wung 2017/9/5.
 */
public interface AppraisedActivityService {

    List<AppraisedActivity> queryList(AppraisedActivityQueryParam param);

    Long queryTotal(AppraisedActivityQueryParam param);

    Long save(AppraisedActivity appraisedActivity);

    void update(AppraisedActivity appraisedActivity);

    void delete(Long id);

}
