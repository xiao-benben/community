package com.newcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring boot";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response)  {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }

        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }

    }

    //GET请求
    //  对于请求 /students?current=1&limit=20
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false ,defaultValue = "1") int current,
                              @RequestParam(name = "limit",required = false, defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }


    //对于请求 /student/123   获取请求参数中 123
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){  //获取请求参数路径中的id，
        System.out.println(id);
        return "a student";
    }

    //处理 post 请求标签
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name , int age){ //表单中的请求参数，会映射到参数列表
        System.out.println(name);
        System.out.println(age);
        return "提交一个学生 success";
    }

    //响应html数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        //先设置好Model 数据
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age","30");
        //设置 View路径 ， 也就是用Thymeleaf
        modelAndView.setViewName("/demo/view");
        return modelAndView;

    }
    //响应html数据的第二种方式
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){ //参数中Model是前端控制器自动创建的，会自动操作
        model.addAttribute("name","北京大学");
        model.addAttribute("age","100");
        return "/demo/view";  //返回对应的模板引擎
    }

    //响应JSON数据(异步请求)
    //Java对象 -> JSON格式  -> JS对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody  //不加这个注解， 会认为是一个html模板
    public Map<String,Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary","8000.00");
        return emp;  //会自动转为json格式
    }

    //假设我们需要返回一组员工
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary","8000.00");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","张");
        emp.put("age",24);
        emp.put("salary","9000.00");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","王奔");
        emp.put("age",25);
        emp.put("salary","5000.00");
        list.add(emp);
        return  list;
    }

}

