package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.Appraise;

import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
public interface AppraiseService {

    List<Appraise> queryList(String appraiseName, Integer pageNum, Integer pageSize);

    long queryTotal(String appraiseName, Integer pageNum, Integer pageSize);
}
