package com.sjy.springboot.myListener;

import com.sjy.springboot.server.TcpNettyServer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author sjy on 2019/3/11
 * @version 1.0
 * 监听器
 */
@Slf4j
@WebListener

//开启需要扫描的listener类文件
public class StartServerListener implements ServletContextListener {
    private final static Logger logger = LoggerFactory.getLogger(StartServerListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
		Thread tcp = new Thread((new TcpNettyServer()));
		tcp.start();
        logger.info("TCP服务器开始服务初始化");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    logger.info("销毁");
    }
}