package com.sjy.springboot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sjy on 2019/2/21
 * @version 1.0
 */
public class Mythread extends Thread {
    static long ling;

    List<String> mlist = new ArrayList<>();


    public int a;
    public void setA(Integer a){
        this.a = a;
    }
    private transient int b;
    public void setB(int b){
        this.b = b;
    }
    protected  int c;

    public void setC(int c){

    }
    @Override
    public void run() {
        super.run();
    }
}