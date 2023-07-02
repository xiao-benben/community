package com.newcoder.community.service;

import com.newcoder.community.dao.AlphaDao;
import com.newcoder.community.dao.AlphaDaoMybatisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    @Autowired
    @Qualifier("alphaMybatisImpl")
    private AlphaDao alphaDao;
//    public AlphaService(){
//        System.out.println("实例化AlphaService");
//    }
//
//    @PostConstruct //会在构造函数之后执行这个方法
//    public void init(){
//        System.out.println("初始化AlphaService，加载一些数据...");
//    }
//
//    @PreDestroy //会在销毁对象之前，执行这个方法
//    public void destroy(){
//        System.out.println("销毁AlphaService,销毁一些资源...");
//    }
    public String find(){
        return alphaDao.find();
    }

}
