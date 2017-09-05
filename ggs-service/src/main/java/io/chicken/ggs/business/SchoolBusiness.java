package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;

import java.util.Map;

/**
 * Created by mengxiangxiang on 2017/8/25.
 */
public interface SchoolBusiness {
    public Result getSchoolList(Map<String, Object> params);
    public Result getSchoolByCondition(Map<String, Object> params);
    public Result getAllSchool(Map<String, Object> params);
}
