package com.sjy.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 注册器，拦截的url为所有的url
 * @author sjy on 2019/3/11
 * @version 1.0
 */
@WebFilter(filterName = "customFilter",urlPatterns = {"/hello/**"})
@Slf4j
public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //对request进行处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        log.info("粗粒度的Filter过滤器*****");
        //链路直接传给下一个过滤器
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("filter销毁");
    }
}