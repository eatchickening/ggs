package io.chicken.ggs.dal.dao;

import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);


    UserInfoVO login(@Param("account") String account, @Param("pwd") String password);
    Boolean resetPwdByAccount(@Param("account") String account, @Param("newPwd") String newPwd);


    List<UserInfoVO> queryList(@Param("param") UserInfoQueryParam param, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    Long queryCount(@Param("param") UserInfoQueryParam param);
}