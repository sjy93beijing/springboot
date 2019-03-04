package com.sjy.springboot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: shengjunyang created on 2018/11/6 下午3:17
 * @Version:
 *
 * 测试aop的代码
 */
@RestController
public class TestController {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public String getResult(@RequestParam String name){
        if(true){
            return  "Hello"+name;
        }
        return name;
    }

    public static void main(String[] args) {
        System.out.println("ssj");
    }
}
