package com.jkd1.service.impl;


import com.jkd.service.AccountService;

import java.util.Date;

/**
 * @projectName: springdemo
 * @package: com.jkd.service.impl
 * @className: AccountServiceImpl
 * @author: JKD
 * @description:
 * @date: 2020/5/29 14:12
 * @version: 1.0
 */
public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date birthDay;

    public AccountServiceImpl(String name, Integer age, Date birthDay) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
    }
}
