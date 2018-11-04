package com.sjy.springboot.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjy.springboot.dao.UserDao;
import com.sjy.springboot.model.UserDomin;
import com.sjy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sjy
 * @Title: UserServiceImpl
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-17:11
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响
    @Override
    public int addUser(UserDomin user) {
        return userDao.insert(user);
    }

    @Override
    public PageInfo<UserDomin> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDomin> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
        }
}
