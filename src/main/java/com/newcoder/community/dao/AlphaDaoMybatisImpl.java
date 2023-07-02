package com.newcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
//当一个接口有两个实现bean的时候，使用@Primary  注解，可以指定优先使用这个bean
public class AlphaDaoMybatisImpl implements AlphaDao {

    @Override
    public String select() {
        return "Mybaitis";
    }
}
