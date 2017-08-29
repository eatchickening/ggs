package io.chicken.ggs.service.impl;

import io.chicken.ggs.common.vo.AreaDetailVO;
import io.chicken.ggs.dal.dao.DictionaryMapper;
import io.chicken.ggs.dal.model.Dictionary;
import io.chicken.ggs.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    public List<Dictionary> queryList(Map<String, Object> map) {
        return dictionaryMapper.queryList(map);
    }


    public long queryTotal(Map<String, Object> map) {
        return dictionaryMapper.queryTotal(map);
    }

    @Override
    public List<AreaDetailVO> queryAreaDetail(Map<String, Object> map) {
        return dictionaryMapper.queryAreaDetail(map);
    }
}
