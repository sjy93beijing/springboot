package com.sjy.springboot.mysql;

import org.junit.Test;

/**
 * @author sjy on 2018/12/28
 * @version 1.0
 */
public class CharTest {

    /**
     * char(n) 若存入字符数小于n，则以空格补于其后，查询之时再将空格去掉。所以char类型存储的字符串末尾不能有空格，varchar不限于此。
     * char(n) 固定长度，char(4)不管是存入几个字符，都将占用4个字节，varchar是存入的实际字符数+1个字节（n<=255）或2个字节(n>255)，所以varchar(4),存入3个字符将占用4个字节
     *char类型的字符串检索速度要比varchar类型的快
     */

    @Test
    public void test1(){



    }

    /**
     * tinyint 一个字节（8位）  无符号(0，255)
     * int 4个字节 (0，4 294 967 295)
     * 一个汉字utf8占3个字节
     */
    @Test
    public void test2(){

    }
}