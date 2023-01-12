package com.newcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration  //表示这个一个配置类
public class AlphaConfig {
    @Bean //加上这个注解，表示这是一个Bean   方法名 simpleDateFormat 就是Bean的名字
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
