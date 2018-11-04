package com.sjy.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sjy
 * @Title: GirlProperties
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-11:54
 */
@Component
//获取前缀是girl的配置，把对应的所有girl的下面的属性映射过来
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cupSize;
    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
