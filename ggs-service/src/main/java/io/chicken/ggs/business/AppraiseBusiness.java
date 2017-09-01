package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Appraise;

import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
public interface AppraiseBusiness {

    Result<List<Appraise>> queryList(String appraiseName, Integer pageNum, Integer pageSize);
}
