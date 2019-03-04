package com.sjy.springboot.utils;

/**
 * @author sjy on 2019/2/26
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int i;
        try{
         i = 1/0;
            System.out.println(i);
        }catch(Exception e){
            i =2;
        }
        System.out.println(i);
    }
}