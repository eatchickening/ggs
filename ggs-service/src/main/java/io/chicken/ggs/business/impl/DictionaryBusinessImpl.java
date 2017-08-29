package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.DictionaryBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.common.vo.AreaDetailVO;
import io.chicken.ggs.dal.model.Dictionary;
import io.chicken.ggs.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component("dictionaryBusiness")
public class DictionaryBusinessImpl implements DictionaryBusiness {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryBusinessImpl.class);
    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public Result getDictionaryList(Map<String, Object> params) {

        List<Dictionary> listDictionary=null;
        long total=0;
        try
        {
            listDictionary = dictionaryService.queryList(params);
            total = dictionaryService.queryTotal(params);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal(total);
        result.setData(listDictionary);
        return result;
    }

    @Override
    public Result<List<Dictionary>> queryList(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<Dictionary> list = dictionaryService.queryList(params);
            return new Result<>(list);
        } catch (Exception e) {
            logger.error("queryList() 异常：" + e.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }

    @Override
    public Result<List<AreaDetailVO>> queryAreaDetail(String bizcode) {

        try {
            Map<String, Object> params=new HashMap<String, Object>();
            params.put("bizcode",bizcode);
            List<AreaDetailVO> list = dictionaryService.queryAreaDetail(params);
            return new Result<>(list);
        } catch (Exception e) {
            logger.error(bizcode + ", queryAreaDetail() 异常：" + e.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }
}
