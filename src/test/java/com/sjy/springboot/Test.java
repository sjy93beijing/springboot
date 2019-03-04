package com.sjy.springboot;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.*;

/**
 * @author sjy on 2018/12/24
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String l = "-1";
        String l2 = "0";
        Map m = new HashMap<>();
        m.put("sjy","");
        m.put("s",1);
        int[] data = new int[2];
        System.out.println("使用 foreach 循环数组");
        for (int a  : data) {
            System.out.print(a+ " ");
        }
        System.out.println(l.length());
        System.out.println(l2.length());
        int s = Integer.MAX_VALUE;
        System.out.println(s);

        double total = 0.2;
        for (int i = 0; i < 100; i++) {
            total+=0.2;
        }

        long l23 = System.currentTimeMillis();
        Date time=new Date(l23);
        System.out.println("total="+l23);
//        1545824326794
        String js ="{军旅=24, 喜剧=104, 青春=4, 脱口秀=1, 科幻=15, 少儿=2, 运动=3, 晚会=1, 罪案=1, 偶像=25, 言情=17, 犯罪=1, 警匪=1, 商战=2, 动画=76, 传记=3, 纪录片=68, 惊悚=3, 冒险=2, 电视剧=21, 奇幻=14, 年代=9, 穿越=2, 历史=5, 悬疑=84, 古装=117, 真人秀=1, 音乐=1, 神话=1, 综艺=3, 剧情=399, 都市=19, 短片=7, 魔幻=1, 武侠=10, 芒果出品=1, 2018年=2, 网剧=1, 爱情=173, 纪实=1, 家庭=67, 战争=18, 动作=31, 农村=1, 刑侦=1}";
        System.out.println(js.toString());


    }
    @org.junit.Test
    public void test22(){
String[] list = {"电视剧","电视剧","电视剧","战争"};
        Map map = new HashMap<String,Object>();
        for (int i = 0; i < list.length; i++) {
            if(map.containsKey(list[i]))
                map.put(list[i],Integer.parseInt(String.valueOf(map.get(list[i])))+1);
            else map.put(list[i],1);
            if (!isExist(list[i])){
                System.out.println("盛俊阳");
            }
        }
    }

    //判断是否存在字符串,存在即返回true
    //判断如果第一个是电视剧或者剧情，并且>2 ,则看第二个

    //合，如果在这个里面包括这些，则取它，如果不包括则取其他
    //如果只有一个且是电视剧，则取其他
    //如果只有第一个且是剧情，则取剧情
    private static Boolean isExist(String st) {
        String temptype="剧情 古装 武侠 家庭 爱情 喜剧 战争 惊悚 悬疑 科幻 奇幻 历史 动画 动作 真人秀 传记 犯罪 运动 纪录片 偶像 都市 言情 青春 宫廷 年代 伦理 罪案 警匪 军旅 神话 穿越 农村 谍战 商战 权谋 玄幻 情景 少儿";
        Boolean flag = false;
        if(st==null)
            return flag;
        if(temptype.contains(st)){
            flag = true;
        }
        return flag;
    }
    @org.junit.Test
    public void te()
    {
        int [] a = {1,2};
        int [] b = new int[]{1,3};
        System.out.println(a[0]+a[1]);
    }




}