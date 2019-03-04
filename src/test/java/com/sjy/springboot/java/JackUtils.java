package com.sjy.springboot.java;

import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sjy on 2019/1/18
 * @version 1.0
 */
public class JackUtils {
    public static void main(String[] args) {
        //commonData里有两个kv，一个reqJson里面存储的是参数 多个kv，一个kv funcNmae
        CommonDataReq commonDataReq = new CommonDataReq();
        Map<String,String> funcName = new HashMap(); //放在外面
        String ag="{\"maoyanId\": 368262}";
        commonDataReq.setReqJson(ag);
        commonDataReq.setFuncName("getPlatformIndexMaoyanKeyWord");
       String nam[] ={};


       for(String name:nam){

       }

        //需要传入参数的时候，需要在json里进行变化

//        funcName.put("funcName","getPlatformIndexMaoyanKeyWord");
//        //传的是参数 内层map
//        Map<String,String> paras = new HashMap<>();
//            paras.put("reqJson","");
//            commonDataReq.setFuncName(funcName.toString());
//            commonDataReq.setReqJson(paras.toString());
//            commonDataReq.setCommonData();


        // 调用JacksonUtils.serialize()序列化
//        System.out.println(JacksonUtils.serialize(list));
//        System.out.println(JacksonUtils.serialize(set));
        System.out.println(JacksonUtils.serialize(commonDataReq));

    }

}