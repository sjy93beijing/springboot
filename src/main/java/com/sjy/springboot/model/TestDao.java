package com.sjy.springboot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjy on 2019/1/17
 * @version 1.0
 */
public class TestDao {
    //Map里放的是list数组
    //String HashMap<String,String>从
    //commonData里有两个kv，一个reqJson 多个kv，一个funcNmae kv
    private Map<String,String> commonData = new HashMap(); //变量
    private Map<String,String> reqJson = new HashMap();//请求参数
    private Map<String,String> funcName = new HashMap();//方法名称

    @Override
    public String toString() {
        return "TestDao{" +
                "commonData=" + commonData +
                ", reqJson=" + reqJson +
                ", funcName=" + funcName +
                '}';
    }

    public Map<String, String> getCommonData() {
        return commonData;
    }

    public void setCommonData(Map<String, String> commonData) {
        this.commonData = commonData;
    }

    public Map<String, String> getReqJson() {
        return reqJson;
    }

    public void setReqJson(Map<String, String> reqJson) {
        this.reqJson = reqJson;
    }

    public Map<String, String> getFuncName() {
        return funcName;
    }

    public void setFuncName(Map<String, String> funcName) {
        this.funcName = funcName;
    }
}
