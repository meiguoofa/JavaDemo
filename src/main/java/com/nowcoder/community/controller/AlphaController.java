package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private AlphaService alphaService;
    private int current;
    private int limit;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request , HttpServletResponse response) throws IOException {
        System.out.println("request.getMethod()" + request.getMethod());
        System.out.println("request.getServletPath() " + request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name +":  " + value);


        }
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.write("<h1>Hello World<h1>");

    }


    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current" , required = false , defaultValue="1") int current,
            @RequestParam(name= "limit" , required = false , defaultValue="10" ) int limit ) {
        this.current = current;
        this.limit = limit;
        System.out.println("current  " + current);
        System.out.println("limit  " + limit);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        System.out.println("id  " + id);

        return "a student";

    }


    @RequestMapping(path = "/student" , method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name , int age){
        System.out.println("name:  " + name + "  age:  " + age);
        return "name:  " + name + "  age:  " + age;

    }

    @RequestMapping(path = "/teacher" , method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",17);
        mav.setViewName("/demo/view");

        return mav;
    }

    @RequestMapping(path = "/emp" , method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList();
        Map<String,Object> emp = new HashMap();
        emp.put("name","zhangSan");
        emp.put("age",23);
        emp.put("salary",2000);
        list.add(emp);
        return list;


    }


}






