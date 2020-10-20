package com.jkd.ui;

import com.jkd.dao.AccountDao;
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

    public static void main(String[] args) {
        // 1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountServiceImpl");
        AccountDao aso = (AccountDao) ac.getBean("accountDaoImpl");
        System.out.println(as);
        System.out.println(aso);
        as.saveAccount();
    }
}
