package com.sjy.springboot;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sjy
 * @Title: SimpleAnnotationApplication
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/10/11-16:28
 */
@SpringBootApplication
public class SimpleAnnotationApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SimpleAnnotationApplication.class, args);
    }
//    final private CityMapper cityMapper;
//    public SimpleAnnotationApplication(CityMapper cityMapper) {
//        this.cityMapper = cityMapper;
//    }
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(this.cityMapper.findByState("CA"));
//    }
//    }
}
