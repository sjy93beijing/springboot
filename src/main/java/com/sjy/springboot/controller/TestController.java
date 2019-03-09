package com.sjy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sjy on 2019/3/9
 * @version 1.0
 */
@Controller
public class TestController {
    @GetMapping("/")
    String test(HttpServletRequest request){
        request.setAttribute("key","hello");
    return "/views/index";
    }
    @GetMapping("/welcome")
    String welcome(HttpServletRequest request) {
        request.setAttribute("key", "hello");
        return "/views/welcome";

    }
}