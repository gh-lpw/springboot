package com.lpw.springboot02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/user")
public class InterceptorTest {

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/update")
    public String update(){
        return "update";
    }

    @RequestMapping("/del")
    public String del(){
        return "del";
    }
}
