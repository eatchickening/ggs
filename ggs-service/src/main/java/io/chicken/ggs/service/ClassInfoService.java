/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.ClassInfo;
import io.chicken.ggs.dal.model.School;

import java.util.List;
import java.util.Map;

/**
 *
 *mengxiangxiang
 */
public interface ClassInfoService {
    List<ClassInfo> queryList(Map<String, Object> map);


}
