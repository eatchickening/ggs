package io.chicken.ggs.dal.dao;

import io.chicken.ggs.dal.model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);


    UserInfo login(@Param("account") String account, @Param("password") String password);
    Boolean resetPwdByAccount(@Param("account") String account, @Param("newPwd") String newPwd);

}