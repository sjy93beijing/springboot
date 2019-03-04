package com.sjy.springboot;

import com.sjy.springboot.model.GirlProperties;
import com.sjy.springboot.model.UserDomin;
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

//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;
    @Autowired
    private GirlProperties girlProperties;
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

        return "拜拜：";
    }
}
