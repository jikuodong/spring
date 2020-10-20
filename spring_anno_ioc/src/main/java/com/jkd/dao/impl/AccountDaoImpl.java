package com.jkd.dao.impl;

import com.jkd.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @projectName: springdemo
 * @package: com.jkd.dao.impl
 * @className: AccountDaoImpl
 * @author: JKD
 * @description:
 * @date: 2020/5/29 14:13
 * @version: 1.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    public void  saveAccount(){
        System.out.println("daoImpl");
    }
}
