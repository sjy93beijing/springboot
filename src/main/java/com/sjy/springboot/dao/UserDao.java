package com.sjy.springboot.dao;

import com.sjy.springboot.model.UserDomin;

import java.util.List;

/**
 * @author sjy
 * @Title: UserDao
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-16:58
 */
public interface UserDao {
    int insert(UserDomin record);



    List<UserDomin> selectUsers();
}
