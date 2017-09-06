/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.common.vo.AppraisedActivityVO;
import io.chicken.ggs.dal.model.AppraisedActivity;

import java.util.List;

/**
 * @author wung 2017/9/5.
 */
public interface AppraisedActivityBusiness {

    Result<List<AppraisedActivityVO>> queryList(AppraisedActivityQueryParam param);

    Result<Long> queryTotal(AppraisedActivityQueryParam param);

    Result<Long> save(AppraisedActivity appraisedActivity);

    Result update(AppraisedActivity appraisedActivity);

    Result delete(Long id);
}
