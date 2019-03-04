package com.sjy.springboot.utils;

/**
 * @author sjy on 2019/2/27
 * @version 1.0
 */


public class Test_Test {
    public static void main(String[] args) {
//        System.out.println(Test1());
//如果try块中所有语句正常执行完毕，那么finally块就会被执行。
//如果try语句在执行过程中碰到异常，无论这种异常能否被catch块捕获到，都将执行finally块中的代码。
//try-catch-finally结构中try块是必须有的，catch和finally块为可选，但两者至少必须出现其中之一。
//Exception                                          异常层次结构的根类
//
//ArithmeticException                            算数错误情形
//
//ArrayIndexOutOfBoundsException       数组下标越界
//
//NullPointerException                           尝试访问null对象成员
//
//ClassNotFoundException                     不能加载所需的类
//
//InputMismatchException                     欲得到的数据类型与实际输入的类型不匹配
//
//IllegalArgumentException                    方法接受到非法参数
//
//ClassCastException                            对象强制类型转换出错
//
//NumberFormatException                     数字格式转换异常

//        异常的定义是可自己进行处理后，程序依然可以正常运行下去！错误是Java虚拟机抛出的，终止程序的运行，这就是程序和异常的区别。

//        下面是try-catch-finally中包含return的情况：
//       1 try{}catch(){return;}finally{} return;
//        System.out.println(Test2());

//       2  try{ return; }catch(){} finally{} return;
        System.out.println(Test3());

//        任何执行try 或者catch中的return语句之前，都会先执行finally语句，如果finally存在的话。
//        如果finally中有return语句，那么程序就return了，所以finally中的return是一定会被return的，
//        编译器把finally中的return实现为一个warning。
    }
//程序执行try块中return之前（包括return语句中的表达式运算）代码；
//         再执行finally块，最后执行try中return;
//         finally块之后的语句return，因为程序在try中已经return所以不再执行。
    private static int Test3() {
        int x = 1;
        try
        {
            x++;
            System.out.println("我有用！");
            return 6;
        }
        catch (Exception e) {
            System.out.println("我没用！");
        }
        finally
        {
            ++x;
            System.out.println("我也有用！");
        }
        return 2;
    }


    //有异常，先执行catch力的return之前的，再执行finally里，最后执行catch里的return
    private static int Test2() {
        int x = 5;
        try
        {
            int num=x / 0;
            System.out.println(num);
        }
        catch (ArithmeticException e) {
            System.err.println("除数不能为0！");
            return 7;
        }
        finally
        {
            ++x;
            System.out.println("finally");
        }
        return 2;
    }



    public static int Test1(){
        int x = 1;
        try
        {
            x++;
            System.out.println("我有用！");
            return 6;
        }
        catch (Exception e) {
            System.out.println("我没用！");
        }
        finally
        {
            ++x;
            System.out.println(x+"我也有用！");
        }
        return 2;
    }
}