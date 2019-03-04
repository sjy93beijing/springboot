package com.sjy.springboot.controller;

import com.sjy.springboot.model.TestBean;
import com.sjy.springboot.model.UserDomin;
import com.sjy.springboot.service.TestService;
import com.sjy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author sjy
 * @Title: UserController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-17:05
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
//    @Autowired
//    TestService testService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(@RequestParam("userId") int userid,@RequestParam("userName") String userName,
                       @RequestParam("password") String password,@RequestParam("phone") String phone){
      UserDomin userDomin = new UserDomin();
      userDomin.setUserId(userid);
      userDomin.setUserName(userName);
      userDomin.setPassword(password);
      userDomin.setPhone(phone);
        return userService.addUser(userDomin);
    }


    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name="pageNum",required = false,defaultValue = "1")int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize)
    {

        return userService.findAllUser(pageNum,pageSize);
    }
    @RequestMapping("/test")
    public String getMap(){

        return "成功";

    }



}
