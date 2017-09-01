/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.business.impl;

import io.chicken.ggs.business.DepartBusiness;
import io.chicken.ggs.business.PostBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.dal.model.Depart;
import io.chicken.ggs.dal.model.Post;
import io.chicken.ggs.service.DepartService;
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
public class DepartBusinessImpl implements DepartBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Autowired
    private DepartService departService;
    @Autowired
    private PostBusiness postBusiness;

    @Override
    public Result<List<Depart>> queryByOrgancode(String organcode) {
        LOGGER.info(organcode + ",queryByOrgancode(), organcode = " + organcode);
        if (StringUtils.isEmpty(organcode)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            List<Depart> list = departService.queryByOrgancode(organcode);
            return new Result<>(list);
        } catch (Exception e) {
            LOGGER.error(organcode + ",queryByOrgancode() 异常：" + e.getMessage());
            return  new Result<>(ResultCode.SYS_EXCEPTION);
        }
    }

    @Override
    public Result<Long> save(Depart depart) {
        try {
            return new Result<>(departService.save(depart));
        } catch (Exception e) {
            LOGGER.error(depart.getName() + ", 保存部门异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_ADD_FAIL);
        }
    }

    @Override
    public Result<Boolean> delete(Depart depart) {
        if (depart == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            departService.delete(depart.getId());

            // 需要删除其下的岗位
            Result<List<Post>> postResult = postBusiness.queryByDepartcode(depart.getDepartcode());
            if (!postResult.isSuccess()) {
                return new Result<>(postResult.getCode(), postResult.getMessage());
            }
            List<Post> postList = postResult.getData();
            for (Post post : postList) {
                Result<Boolean> postDeleteResult = postBusiness.delete(post);
                LOGGER.info(post.getPostcode() + ", 岗位删除结果：" + postDeleteResult.getData());
            }

            return new Result<>(true);
        } catch (Exception e) {
            LOGGER.error(depart.getDepartcode() + "，删除部门异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_DELETE_FAIL);
        }
    }

    @Override
    public Result<Depart> query(Long id) {
        if (id == null) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        try {
            return new Result<>(departService.query(id));
        } catch (Exception e) {
            LOGGER.error(id + ", 查询部门异常：" + e.getMessage());
            return new Result<>(ResultCode.DB_QUERY_FAIL);
        }
    }
}
