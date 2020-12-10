package com.jkd.springboot.controller;


import com.jkd.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/", "login.html"})
//    public String index() {
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if ("aaa".equals(user)){
            throw  new UserNotExistException();
        }
        return  "Hello World";
    }

    // 查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        // classpath:/templates/success.html
        return "success";
    }
}
