package com.sjy.springboot.model;

import org.springframework.stereotype.Component;

/**
 * @author sjy
 * @Title: UserDomin
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-16:58
 */
@Component
public class UserDomin {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
