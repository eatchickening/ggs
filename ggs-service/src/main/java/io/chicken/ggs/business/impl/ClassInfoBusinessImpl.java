package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.ClassInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.ClassInfo;
import io.chicken.ggs.service.ClassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ClassInfoBusinessImpl implements ClassInfoBusiness {

    private static final Logger logger = LoggerFactory.getLogger(ClassInfoBusinessImpl.class);

    @Autowired
    private ClassInfoService classInfoService;

    @Override
    public Result getClassInfoList(Map<String, Object> params) {
        //查询列表数据
        List<ClassInfo> classInfos=null;
        long total=0;
        try
        {
           classInfos = classInfoService.queryList(params);
        }catch(Exception e)
        {
            logger.error("数据库操作异常",e);
            return new Result<>(ResultCode.DB_EXCEPTION);
        }
        Result result=  new Result<>(ResultCode.SUCCESS);
        result.setTotal((long)classInfos.size());
        result.setData(classInfos);
        return result;
    }
}
