/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.School;
import io.chicken.ggs.dal.model.Student;

import java.util.List;
import java.util.Map;

/**
 *
 *mengxiangxiang
 */
public interface SchoolService {
    List<School> queryList(Map<String, Object> map);

    long queryTotal(Map<String, Object> map);

}
