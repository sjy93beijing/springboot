package com.sjy.springboot.interceptors;

import com.sjy.springboot.myListener.StartServerListener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sjy on 2019/3/11
 * @version 1.0
 * 拦截器
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    log.info("preHandle：请求前调用");
//    返回false则中断
        logger.info("在处理之前，Controller调用");
        return true;
    }

    //请求后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("postHadnler请求后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("在处理之后，执行清理工作");
        log.info("afterComplication");
    }



}