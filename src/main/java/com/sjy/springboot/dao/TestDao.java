package com.sjy.springboot.dao;

import com.sjy.springboot.model.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sjy on 2018/12/5
 * @version 1.0
 */
@ImportResource(locations = {"classpath:client.xml"})
public class TestDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate TestDao() {
       return jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 增加bean
     * @param t
     */
    public void addBean(TestBean t){
        String sql1 = "insert into test(id,name) values(?,?)";
        jdbcTemplate.update(sql1,t.getId(),t.getName());
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //遍历map
        map.put("qq",1);
        map.put("iqiyi",2);
        map.put("letv",1);

        System.out.println("qq:"+map.getOrDefault("qq",0));
        int qq = map.get("qq")!=null ? map.get("qq"):0;
        int mgtv = map.get("mgtv")!=null ? map.get("mgtv"):0;
        int iqiyi = map.get("iqiyi")!=null ? map.get("iqiyi"):0;
        System.out.println(qq+":"+mgtv+":"+iqiyi);
    }

}