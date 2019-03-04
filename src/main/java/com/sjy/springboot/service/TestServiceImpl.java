package com.sjy.springboot.service;

import com.sjy.springboot.dao.TestDao;
import com.sjy.springboot.model.TestBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author sjy on 2018/12/5
 * @version 1.0
 */
@Service
@Component
public class TestServiceImpl implements TestService {

    private TestDao testDao;

    @Override
    public void addBean(TestBean t) {
        testDao.addBean(t);
    }
}