/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.PostBusiness;
import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.Post;
import io.chicken.ggs.dal.model.UserInfo;
import io.chicken.ggs.service.PostService;
import io.chicken.ggs.service.impl.DepartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wung 2017/8/27.
 */
@Service
public class PostBusinessImpl implements PostBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Autowired
    private PostService postService;

    @Autowired
    private UserInfoBusiness userInfoBusiness;

    @Override
    public Result<List<Post>> queryByDepartcode(String departcode) {
        LOGGER.info(departcode + ",queryByDepartcode(), departcode = " + departcode);
        if (StringUtils.isEmpty(departcode)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<Post> list = postService.queryByDepartcode(departcode);
            return new Result<>(list);
        } catch (Exception e) {
            LOGGER.error(departcode + ",queryByDepartcode() 异常：" + e.getMessage());
            return  new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }

    @Override
    public Result<Post> query(Long id) {
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            return new Result<>(postService.query(id));
        } catch (Exception e) {
            LOGGER.error(id + ", 查询岗位异常：" + e.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }

    @Override
    public Result<Long> save(Post post) {
        try {
            return new Result<>(postService.save(post));
        } catch (Exception e) {
            LOGGER.error(post + ", 保存岗位异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_ADD_FAIL);
        }
    }

    @Override
    public Result<Boolean> delete(Post post) {
        if (post == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            postService.delete(post.getId());

            // 需要删除其下的用户
            UserInfo userInfo = new UserInfo();
            userInfo.setDepartcode(post.getDepartcode());
            userInfo.setPostcode(post.getPostcode());
            Result<List<UserInfo>> listResult = userInfoBusiness.queryListByUserInfo(userInfo);
            if (!listResult.isSuccess()) {
                LOGGER.error("删除岗位时，查询该岗位用户失败：" + listResult.getMessage());
                return new Result<>(ResultCode.DB_DELETE_FAIL);
            }
            List<UserInfo> userInfoList = listResult.getData();
            for (UserInfo user : userInfoList) {
                Result<Boolean> userDeleteResult = userInfoBusiness.delete(user.getId());
                LOGGER.info(user.getAccount() + ", 用户删除结果：" + userDeleteResult.getData());
            }

            return new Result<>(true);
        } catch (Exception e) {
            LOGGER.error(post.getId() + "，删除岗位异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_DELETE_FAIL);
        }
    }
}
