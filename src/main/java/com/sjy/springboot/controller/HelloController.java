package com.sjy.springboot.controller;

import com.sjy.springboot.model.UserDomin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sjy
 * @Title: HelloController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/910:17
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    private static final String INDEX="index";

    //    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;
    @Autowired
    private UserDomin userDomin;
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(@RequestParam("id") Integer id){

        return "id:"+id;
    }
    @RequestMapping(value="/say2/{id}",method = RequestMethod.GET)
    public String save(@PathVariable("id") Integer id){
        return  "id:"+id;

    }
    @GetMapping(value = "/bye")
    public String byby(){
    logger.info("巴巴爸爸");
        return "拜拜：";
    }
    @RequestMapping("/index")
    public String  getIndex(){
        return INDEX;
    }

}
