package com.sjy.springboot.service;

import com.github.pagehelper.PageInfo;
import com.sjy.springboot.model.UserDomin;

/**
 * @author sjy
 * @Title: UserService
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-17:04
 */
public interface UserService {
    int addUser(UserDomin user);

    PageInfo<UserDomin> findAllUser(int pageNum, int pageSize);
}
