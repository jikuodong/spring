package com.jkd.springboot01helloworldquick.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 这个类的所有方法返回的数据直接写给浏览器，（如果是对象转为json数据）
//@ResponseBody
//@RequestMapping
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world quick";
    }
    // RESTAPI的方式
}
