package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Dictionary;

import java.util.List;
import java.util.Map;

/**
 * Created by mengxiangxiang on 2017/8/25.
 */
public interface DictionaryBusiness {
    public Result getDictionaryList(Map<String, Object> params);

    Result<List<Dictionary>> queryList(Map<String, Object> params);
}
