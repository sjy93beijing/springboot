package com.sjy.springboot;

import com.sjy.springboot.dao.UserDao;
import com.sjy.springboot.model.UserDomin;
import com.sjy.springboot.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class SpringbootApplicationTests {

    //通过Spring容器注入Dao实现类
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
    }
    //有条件的查询所有
    @Test
    public void testqueryUser(){
        List<UserDomin> userDomins = userDao.selectlike();
//        assertEquals(2, userDomins.size());
    }
    @Test
    public void testInsert()throws Exception{
//        UserDomin userDomin = new UserDomin();
        userDao.dynaInsert(new UserDomin(1,"sjy","1234","130"));


    }


    //查询所有的
    @Test
    public void testqueryAllUser(){

        List<UserDomin> userDomins = userDao.selectUsers();
            for(UserDomin u:userDomins){
                System.out.println(u.toString());
            }
    }

}
