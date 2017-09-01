package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.dal.dao.AppraiseMapper;
import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.service.AppraiseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
@Service
public class AppraiseServiceImpl implements AppraiseService {

    private AppraiseMapper appraiseMapper;

    public List<Appraise> queryList(String appraiseName,
                                    Integer pageNum,
                                    Integer pageSize) {
        Integer start = (pageNum - 1) * pageSize;
        return appraiseMapper.queryList(appraiseName, start, CommonConstant.PAGE_PRE);
    }

    public long queryTotal(String appraiseName,
                           Integer pageNum,
                           Integer pageSize) {
        Integer start = (pageNum - 1) * pageSize;
        return appraiseMapper.queryTotal(appraiseName, start, CommonConstant.PAGE_PRE);
    }
}
