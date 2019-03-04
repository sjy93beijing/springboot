package com.sjy.springboot;

import com.meituan.service.mobile.movie.thrift.movie.MmdbMovieService;
import com.meituan.service.mobile.movie.thrift.movie.TMovie;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sjy on 2018/12/26
 * @version 1.0
 */
public class TestThrift {
    @Resource
    private static MmdbMovieService.Iface client;

//    @Resource
//    private static DataThriftService.Iface dataService;



    @Test
    public void test() throws TException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
        client = (MmdbMovieService.Iface) beanFactory.getBean("movie_data_getHotPmyHourlyStat");
        TMovie tMovie;
        List<Integer> list =new ArrayList<>();
        list.add(1208381);
        list.add(1206143);
        List<TMovie> ll =  client.getMovies(list);
        //测试Tmovie方法
        TMovie tMovie2 = client.getMovie(1206143);
        System.out.println("打印:"+ll.toString()+"----------");
        System.out.println("tMovie"+tMovie2.getName());

    }
    public static void main(String[] args) throws TException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
        client = (MmdbMovieService.Iface) beanFactory.getBean("movie_data_getHotPmyHourlyStat");
        TMovie tMovie;
        List<Integer> list =new ArrayList<>();
        list.add(1208381);
        list.add(1206143);
        List<TMovie> ll =  client.getMovies(list);
        System.out.println(ll);
        //测试Tmovie方法
        TMovie tMovie2 = client.getMovie(1206143);
        System.out.println("tMovie"+tMovie2.getName());

    }
    public static String getIndexSearchKeyword( String keyword) {
        String searchKeyword;
        if (keyword == null) {
        }
        String newKeyword = keyword.split(" ")[0];
        if (newKeyword.contains("：")) {
            if (Character.isDigit(keyword.charAt(newKeyword.indexOf('：') - 1))) {
                newKeyword = keyword.substring(0, newKeyword.indexOf("："));
            }
        }
        searchKeyword = newKeyword.replaceAll("[\\pP\\p{Punct}]", StringUtils.EMPTY);
        return searchKeyword;
    }

}