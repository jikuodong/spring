package com.jkd.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");
        message.setTo("xxxxxxxx@163.com");
        message.setFrom("xxxxxxxxx@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws MessagingException {
        // 1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今晚7:30开会<b>", true);

        helper.setTo("xxxxxxxx@163.com");
        helper.setFrom("xxxxxxxxx@qq.com");

        // 上传文件
        helper.addAttachment("logo2-01.png",new File("C:\\Users\\Administrator\\Desktop\\logo2-01.png"));
        helper.addAttachment("logo2.png",new File("C:\\Users\\Administrator\\Desktop\\logo2.png"));
        mailSender.send(mimeMessage);
    }

}
