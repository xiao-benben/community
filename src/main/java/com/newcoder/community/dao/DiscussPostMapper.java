package com.newcoder.community.dao;

import com.newcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public
interface DiscussPostMapper {
    /*查询帖子列表  支持分页  offset 起始行行号， limit  一页多少行数据
    1. 首页的帖子列表是不用传入userID的
    2. 后期开发我的帖子列表，需要传入userid， 所以这里加上
     */

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //查询帖子总共多少行数据   为了支持分页功能设计
    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用（动态sql）,则必须加别名. 否则报错
    int selectDiscussPostRows(@Param("userId") int userId);
}
