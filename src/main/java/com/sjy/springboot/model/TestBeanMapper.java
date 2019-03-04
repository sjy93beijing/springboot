package com.sjy.springboot.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sjy on 2018/12/5
 * @version 1.0
 */
public class TestBeanMapper implements RowMapper<TestBean> {

    @Override
    public TestBean mapRow(ResultSet rs, int i) throws SQLException {
       TestBean testBean = new TestBean();
       testBean.setId(rs.getInt(1));
       testBean.setName(rs.getString(2));
        return testBean;
    }
}