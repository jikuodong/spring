package com.jkd.task.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * second（秒）, minute（分）,hour（时）,day of month（日）,month（月）,day of week(周几)
     * 0 * * * * MON-FRI
     */
//    @Scheduled(cron = "0 * * * * MON-SAT")
    @Scheduled(cron = "0/4 * * * * MON-SAT") // 每4秒执行一次
    public void hello(){
        System.out.println("hello....");
    }
}
