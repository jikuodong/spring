package com.jkd.ticket.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * @projectName: springboot-06-dubbo
 * @package: com.jkd.ticket.service
 * @className: Test
 * @author: JKD
 * @description:
 * @date: 2021/3/17 15:20
 * @version: 1.0
 */
public class Test {

    public static void getP(){

        //1.创建 HttpClient
        HttpClient client = new HttpClient();

        String url = "https://baike.baidu.com/item/302/878045?fr=aladdin";
        //2.构造PostMethod 的实例
        PostMethod postMethod = new PostMethod(url);

        postMethod.addRequestHeader("Content-Type", "application/x-www-urlencoded; charset=UTF-8");

        //3.请求参数,方式一(简单)
//        postMethod.addParameter("customer_name","xxxxx");
        /*
        //请求参数方式二
        NameValuePair[] data = {
                new NameValuePair("customer_name","xxxx"),
                new NameValuePair("customer_name2","yyy")
        };
        postMethod.setRequestBody(data);
        */
        try {
            int i = client.executeMethod(postMethod);
            System.out.println(i+","+postMethod.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        getP();
    }
}
