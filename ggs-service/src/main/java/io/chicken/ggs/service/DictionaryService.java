/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.common.vo.AreaDetailVO;
import io.chicken.ggs.dal.model.Dictionary;
import io.chicken.ggs.dal.model.School;

import java.util.List;
import java.util.Map;

/**
 *
 *mengxiangxiang
 */
public interface DictionaryService {
    List<Dictionary> queryList(Map<String, Object> map);

    long queryTotal(Map<String, Object> map);

    List<AreaDetailVO> queryAreaDetail(String bizcode);
}
