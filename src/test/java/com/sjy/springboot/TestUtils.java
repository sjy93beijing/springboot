package com.sjy.springboot;

import com.meituan.service.mobile.movie.thrift.movie.MmdbMovieService;
import com.meituan.service.mobile.movie.thrift.movie.TMovie;
import com.sjy.springboot.model.TestBean;
import com.sjy.springboot.utils.CustomDateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


/**
 * @author sjy on 2018/12/4
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:client.xml"})
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties =
        "application.properties")
public class TestUtils {
    @Autowired
    private static MmdbMovieService.Iface client;


    static BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
    static JdbcTemplate jdbcTemplate  =  (JdbcTemplate) beanFactory.getBean("jdbcTemplate");

    /**
     *CREATE TABLE `test` (
     *   `id` int(10) NOT NULL,
     *   `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
     * @param args
     */

    public static void main(String[] args) throws TException {

        //验证下如果是月末，会不会返回到上个月  在main函数里测试
        Date Olddate = new Date();
        //获取前一天的时间
        System.out.println(Olddate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Olddate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Olddate = calendar.getTime();
        String date = CustomDateUtils.format(Olddate, "yyyyMMdd");

//
//        //插入测试 1单行数据
//        String sql1 = "insert into test(id,name,col3) values(?,?,?)";
//        jdbcTemplate.update(sql1,12,"lsx","null");

//        //插入测试 2List数组
//        String sql2 = "insert into test(id,name) values(?,?)";
//        List<TestBean> lists = new ArrayList<>();
//        lists.add(new TestBean(10,"mmm"));
//        lists.add(new TestBean(11,"nnn"));
//        jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setInt(1,lists.get(i).getId());
//                ps.setString(2,lists.get(i).getName());
//            }
//            @Override
//            public int getBatchSize() {
//                return lists.size();
//            }
//        });

//        //删除数据 1
//        String sql3= "delete from test where name=?";
//        jdbcTemplate.update(sql3,"sjy");
//       //修改操作
//        String sql4 = "update test set name=? where name=?";
//        jdbcTemplate.update(sql4,"sjy","nnn");
//        System.out.println(sql4);
        //测试查询数据 1.返回对象
//        //测试返回的是Map
//        String sql7 = "select distinct id as count, name as type  from test ";
//        List<Map<String,Object>> list;
//            list    = jdbcTemplate.queryForList(sql7);
//        System.out.println(list.toString());
//    Map<String ,Integer> map = new HashMap<>();
//        for (int i= 0;i<list.size();i++) {
//            map.put(list.get(i).get("type").toString(),Integer.parseInt(list.get(i).get("count").toString()));
//            System.out.println("key:"+list.get(i).get("type")+"value:"+list.get(i).get("count"));
//        }
//        System.out.println(map.size());
//
//        //测试返回的是Map
//        String sql8 = "select distinct maoyan_id from test ";
//        System.out.println(list.toString());
//        Map<String ,Integer> map2 = new HashMap<>();
//        for (int i= 0;i<list.size();i++) {
//            map.put(list.get(i).get("type").toString(),Integer.parseInt(list.get(i).get("count").toString()));
//            System.out.println("key:"+list.get(i).get("type")+"value:"+list.get(i).get("count"));
//        }
//        System.out.println(map.size());

//        System.out.println("map"+map);


//        String sql5 = "select id ,name from test";
//        Object[] object = {"lsx"};
//      TestBean testBean = jdbcTemplate.queryForObject(sql5,object,new TestBeanMapper());
//
//
//        System.out.println(testBean);
//        测试查询数据 2.返回List集合  需要创建自己的BeanMapper 继承RowMapper
//        String sql6 = "select * from test";
//        List<TestBean> list = jdbcTemplate.query(sql6, new TestBeanMapper());
//        System.out.println(list);
//        //测试查询数据
        String sql9 = "select count(id) from test";
        long count  = jdbcTemplate.queryForObject(sql9,Long.class);
        System.out.println(count);
        // 测试
        String name = null;
        System.out.println("***"+getResult());
//        if (getResult()==null){
//            System.out.println("对");
//        }
//        String sql = "select name  from test where id= ? limit 1";
//        try {
//            name = jdbcTemplate.queryForObject(sql, java.lang.String.class, new Object[]{111});
//        } catch (EmptyResultDataAccessException e) {
//            System.out.println(name);
//            return ;
//
//
//        }
        
    }
    public  static  String getResult(){
        String name = null;
        String sql = "select name  from test where id= ? limit 1";
        try {
            name = jdbcTemplate.queryForObject(sql, java.lang.String.class, new Object[]{122});
            System.out.println("*****");
        } catch (EmptyResultDataAccessException e) {
//            e.printStackTrace();
            System.out.println("catch");
            name="121";

        }
        System.out.println("end");
        return name;
    }
    @Test
    public void testTime(){
        //验证下如果是月末，会不会返回到上个月
        Date Olddate = new Date();
        //获取前一天的时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Olddate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Olddate = calendar.getTime();
        String date = CustomDateUtils.format(Olddate,"yyyyMMdd");
        System.out.println(date);
    }


    /**
     * 测试jdbcTmeplate
     */
    @Test
    public void testJDBCTemplate()throws Exception{
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
       JdbcTemplate jdbcTemplate  =  (JdbcTemplate) beanFactory.getBean("jdbcTemplate");


        //插入测试2
        String sql2 = "insert into test(id,name) values(?,?)";
        List<TestBean> lists = new ArrayList<>();
        lists.add(new TestBean(10,"mmm"));
        lists.add(new TestBean(11,"nnn"));

//        jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setInt(1,lists.get(i).getId());
//                ps.setString(2,lists.get(i).getName());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return lists.size();
//            }
//        });

        //测试查询数据3
        String sql3 = "select count(id) from test";
        long count  = jdbcTemplate.queryForObject(sql3,Long.class);
        System.out.println(count);

    }
    //    mmdb-movie-thrift
    @Test
    public void testname() throws Exception {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
        client = (MmdbMovieService.Iface) beanFactory.getBean("movie_data_getHotPmyHourlyStat");
        TMovie tMovie;
        tMovie =  client.getMovie(1229753);
        System.out.println(tMovie.toString());


    }

}