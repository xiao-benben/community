package com.newcoder.community.dao;

import com.newcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 我们在这个接口中定义好查询需求， 然后在配置xml中具体实现
 */
@Mapper
public interface UserMapper {
    //1.根据id查询用户信息
    User selectById(int id);
    //2根据用户名查询用户信息
    User selectByName(String username);
    //3根据邮箱查询用户信息
    User selectByEmail(String email);



    //4. 插入一条用户信息， 返回插入几条
    int insertUser(User user);

    //5. 更新用户的状态，返回更新了几个
    int updateStatus(int id, int status);
    //6.
    int updateHeader(int id, String headerUrl);
    //7.
    int updatePassword(int id,String password );



}
