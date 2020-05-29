package com.jkd1.ui;

import com.jkd.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: springdemo
 * @package: com.jkd.ui
 * @className: Client
 * @author: JKD
 * @description:
 * @date: 2020/5/29 14:11
 * @version: 1.0
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        // 1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
