package com.sjy.springboot.mysql;

import com.sjy.springboot.model.StudentBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sjy on 2019/1/17
 * @version 1.0
 * 测试jdbc查询情况
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:client.xml"})
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties =
        "application.properties")
public class TestJdbcTemplate {
    static BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
    static JdbcTemplate jdbcTemplate  =  (JdbcTemplate) beanFactory.getBean("jdbclocal");
    static JdbcTemplate jdbcTemplate2  =  (JdbcTemplate) beanFactory.getBean("jdbcTemplate");//远程movieTest测试库


    public static void main(String[] args) {
//        query1();
        insert_test1();
    }

    /**
     * 测试test库的单行查询性能
     */
    private static void query1() {
        String sql9 = "select count(id) from test";
        long count  = jdbcTemplate.queryForObject(sql9,Long.class);
        System.out.println(count);
    }

    /**
     * 测试插入如果bean对象有为null可不可以完成插入
     */

    private static int insert_test1() {
        String sql2 = "insert into StudentScores values(?,?,?)";
        List<StudentBean> lists = new ArrayList<>();
        StudentBean studentBean = new StudentBean();
        studentBean.setScore(1.f);
        studentBean.setSubject("数学");
        studentBean.setUserName("盛俊阳");

        lists.add(studentBean);
        jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, lists.get(i).getUserName());
                ps.setString(2, lists.get(i).getSubject());
                ps.setFloat(3, lists.get(i).getScore());
            }

            @Override
            public int getBatchSize() {
                return lists.size();
            }
        });

        return lists.size();
    }

    /**
     * 查询
     */
    private static void query3() {
        String sql9 = "select * from test";
        long count  = jdbcTemplate.queryForObject(sql9,Long.class);
        System.out.println(count);
    }


}