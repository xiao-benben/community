package com.newcoder.community;

import com.newcoder.community.config.AlphaConfig;
import com.newcoder.community.dao.AlphaDao;
import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//专门测试mapper sql
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //以CommunityApplication为配置类启动
public class MapperTests {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private DiscussPostMapper discussPostMapper;

    @Test  //测试插入用户
    public void testSelectUser(){
        User user = userMapper.selectById(101000);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("wang");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }

    @Test
    public void updateUser(){
        int rows = userMapper.updatePassword(150,"11111111");
        System.out.println(rows);
    }

    //修改用户名
    @Test
    public void updateUserByUsername(){
        int rows = userMapper.updateUsername(173,"zhang");
        System.out.println(rows);
    }

    @Test
    public  void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost post: list)
            System.out.println(post);

        System.out.println("------------------------------------------------------");
    List<DiscussPost> list1 = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post: list1)
            System.out.println(post);
    }
}
