package com.sjy.springboot.controller;

import com.sjy.springboot.model.UserDomin;
import com.sjy.springboot.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/user")
public class UserController {
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home(){
        return "views/welcome";
    }

    @GetMapping("/register")
    public String userHome(){
        return "views/user/userhome";
    }


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
    public Object findAllUser()
    {

        return userService.findUsers();
    }

}
