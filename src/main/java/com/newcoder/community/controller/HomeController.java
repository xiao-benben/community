package com.newcoder.community.controller;

import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.Page;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.DiscussPostService;
import com.newcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;


    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){ //Model用来封装数据  Page用来封装分页信息， 前端控制器会自动将page放到model中

        //服务器也需要做一些配置
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        //前端将offset, limit 封装在了page中

        List<DiscussPost> list =  discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        //定义一个元素是map的list，将DiscussPost和对应的User都装进来
        List<Map<String,Object>> discussPosts = new ArrayList<>();

        if(list!=null){
            for(DiscussPost post : list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";  //将数据交给index这个模板

    }

}
