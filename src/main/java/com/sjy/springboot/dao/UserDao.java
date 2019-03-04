package com.sjy.springboot.dao;

import com.sjy.springboot.model.UserDomin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sjy
 * @Title: UserDao
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-16:58
 */
public interface UserDao {
    int insert(UserDomin record);
    //查询所有的用户
    List<UserDomin> selectUsers();
    //动态插入
    void dynaInsert(UserDomin userDomin);
    //动态查询 传入的是map
    List<UserDomin> selectlike();
    //动态更新
    void dynaUpdate(UserDomin userDomin);
    //动态删除
    void dynaDeleteArray();

}
