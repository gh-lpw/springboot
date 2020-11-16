package com.lpw.springboot02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTest {

    @RequestMapping("/ajaxexception")
    public boolean testAjax(){
        int a = 10/0;
        return true;
    }
}
