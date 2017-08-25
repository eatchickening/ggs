package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;

import java.util.Map;

/**
 * Created by mengxiangxiang on 2017/8/25.
 */
public interface StudentBusiness {
    public Result getStudentList( Map<String, Object> params);

}
