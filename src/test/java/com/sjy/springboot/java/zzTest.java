package com.sjy.springboot.java;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sjy on 2018/12/29
 * @version 1.0
 * 正则表达式
 */
public class zzTest {

    /*
    1.字符集合。匹配所包含的任意一个字符。例如，“[abc]”可以匹配“plain”中的“a”。
    2.[0-9]+匹配多个数字,[0-9]匹配单个数字
    3.abc$ 匹配字母abc 并以abc结尾，$为匹配输入字符的结束位置 ，^开始位置
    4.*	匹配前面的子表达式零次或多次。例如，zo*能匹配“z”以及“zoo”。*等价于{0,}。
     */
    /**
     * 案例1：判断一个字符串由3个字母组成
     */
    @Test
    public void test1(){
        String str = "agx";
        //指定判断规则
        Pattern p = Pattern.compile("[abc][edfg][xzy]");
        Matcher m = p.matcher(str);
        //进行判断
        boolean b = m.matches();
        System.out.println(b);
    }
    /**
     * 案例1：判断一个字符串由3个字母组成
     */
    @Test
    public void test2(){
        //   \d:匹配一个数字字符。等价于[0-9]。
        //   \D:匹配一个非数字字符，等价于[^0-9];+匹配前面的子表达式一次或多次。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。
        Pattern p=Pattern.compile("\\d+");
        //? 匹配前面的表达式0次或一次
        Pattern p1 = Pattern.compile("zo？");//*是匹配前面的表达式任意次,碰到一个zo就换行，算下一个。
        String[] str=p1.split("szossszoo:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (int i=0;i<str.length;i++) {
            System.out.println(str[i].toString());
        }

    }
    @Test
    public void testNN() throws Exception{

    //
       String name = null;
        try {
            if (name.equals(null)){
                System.out.println("sss");
            }
        } catch (Exception e) {

        }

        String searchKeyword;
        String keyword = "知否？知否？应是绿肥红瘦";
        String newKeyword = keyword.split(" ")[0];
        if (newKeyword.contains("：")) {
            if (Character.isDigit(keyword.charAt(newKeyword.indexOf('：') - 1))) {
                newKeyword = keyword.substring(0, newKeyword.indexOf("："));
            }
        }
        searchKeyword = newKeyword.replaceAll("[\\pP\\p{Punct}]", StringUtils.EMPTY);

        System.out.println(searchKeyword);
    }

}