package com.sjy.springboot.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author sjy on 2018/11/20
 * @version 1.0
 */
public class MyBatisUtils {
    private static SqlSessionFactory factory;

    /**
     * 在静态代码块下，factory只会被创建一次
     */

    static{

        try{

            factory =

                    new SqlSessionFactoryBuilder()

                            .build(

                                    Resources.getResourceAsStream("mybatis-cfg.xml")

                            );

        }catch(Exception e){

            e.printStackTrace();

            // 静态初始化代码块异常错误

            throw new ExceptionInInitializerError(e);

        }

    }



    /**

     * @Description 工具方法,创建会话对象使用.

     * @return 创建的会话对象.

     */

    public static SqlSession openSession(){

        return factory.openSession();

    }



}