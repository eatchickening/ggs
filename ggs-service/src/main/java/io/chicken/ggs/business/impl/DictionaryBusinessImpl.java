package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.DictionaryBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.Query;
import io.chicken.ggs.dal.model.Dictionary;
import io.chicken.ggs.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
