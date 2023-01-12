package com.newcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaDaoHibernateImpl")  //可以指定Bean的名字 ， 后面使用@Qualifier("alphaDaoHibernate")可以指定使用哪个bean
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
