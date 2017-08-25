package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;

import java.util.Map;

/**
 * Created by mengxiangxiang on 2017/8/25.
 */
public interface SchoolBusiness {
    public Result getSchoolList(Map<String, Object> params);

}
