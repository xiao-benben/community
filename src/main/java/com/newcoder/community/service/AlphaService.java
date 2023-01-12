package com.newcoder.community.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

//    @PostConstruct //会在构造函数之后执行这个方法
//    public void init(){
//        System.out.println("初始化AlphaService");
//    }

//    @PreDestroy //会在销毁对象之前，执行这个方法
//    public void destroy(){
//        System.out.println("销毁AlphaService");
//    }
}
