package com.sjy.springboot.java;


/**
 * @author sjy on 2019/1/18
 * @version 1.0
 */
public class CommonDataReq {
    private String reqJson ;//请求参数
    private String  funcName ;//方法名称

    public CommonDataReq() {
    }


    public String getReqJson() {
        return reqJson;
    }

    public void setReqJson(String reqJson) {
        this.reqJson = reqJson;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
}