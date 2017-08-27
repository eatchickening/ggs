package io.chicken.ggs.dal.dao;

import io.chicken.ggs.common.vo.AreaDetailVO;
import io.chicken.ggs.dal.model.Dictionary;

import java.util.List;

public interface DictionaryMapper  extends BaseDao<Dictionary>{
    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    List<AreaDetailVO> queryAreaDetail(String bizcode);
}