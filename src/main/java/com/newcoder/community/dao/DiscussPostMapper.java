package com.newcoder.community.dao;

import com.newcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public
interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //查询一共多少行数据
    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用（动态sql）,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);
}
