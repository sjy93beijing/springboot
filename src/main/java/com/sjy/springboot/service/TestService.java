package com.sjy.springboot.service;

import com.sjy.springboot.dao.TestDao;
import com.sjy.springboot.model.TestBean;

/**
 * @author sjy on 2018/12/5
 * @version 1.0
 */
public interface TestService {

    void addBean(TestBean t);

}