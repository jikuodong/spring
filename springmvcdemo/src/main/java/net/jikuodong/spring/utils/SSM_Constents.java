package net.jikuodong.spring.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * describe 系统初始化数据
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName SSM_Constents.java
 * @createTime 2019年06月11日 13:22:00
 */
public class SSM_Constents {

    /**
     * 数据库配置文件
     */
    private static String dbFileUri = "/etc/tomcat/ssm/db.properties";

    /******** db.properties配置文件 start *************/
    public static String url;
    public static String driverClassName;
    public static String username;
    public static String password;
    public static String filters;
    public static String maxActive;
    public static String initialSize;
    public static String maxWait;
    public static String minIdle;
    public static String maxIdle;
    public static String timeBetweenEvictionRunsMillis;
    public static String minEvictableIdleTimeMillis;
    public static String validationQuery;
    public static String testWhileIdle;
    public static String testOnBorrow;
    public static String testOnReturn;
    public static String maxOpenPreparedStatements;
    public static String removeAbandoned;
    public static String removeAbandonedTimeout;
    public static String logAbandoned;
    public static String versionType;
    /******** db.properties配置文件 end *************/

    /**
     * 初始化配置文件
     */
    public static void initProperties()
    {
        Properties properties = new Properties();
        try
        {
            initDbProperties(properties);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 读取数据库配置文件
     */
    private static void initDbProperties(Properties properties)
    {
        try
        {
            File file = new File(dbFileUri);
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            url = properties.getProperty("url");
            driverClassName = properties.getProperty("driverClassName");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            filters = properties.getProperty("filters");
            maxActive = properties.getProperty("maxActive");
            initialSize = properties.getProperty("initialSize");
            maxWait = properties.getProperty("maxWait");
            minIdle = properties.getProperty("minIdle");
            maxIdle = properties.getProperty("maxIdle");
            timeBetweenEvictionRunsMillis = properties.getProperty("timeBetweenEvictionRunsMillis");
            minEvictableIdleTimeMillis = properties.getProperty("minEvictableIdleTimeMillis");
            validationQuery = properties.getProperty("validationQuery");
            testWhileIdle = properties.getProperty("testWhileIdle");
            testOnBorrow = properties.getProperty("testOnBorrow");
            testOnReturn = properties.getProperty("testOnReturn");
            maxOpenPreparedStatements = properties.getProperty("maxOpenPreparedStatements");
            removeAbandoned = properties.getProperty("removeAbandoned");
            removeAbandonedTimeout = properties.getProperty("removeAbandonedTimeout");
            logAbandoned = properties.getProperty("logAbandoned");
            versionType = properties.getProperty("versionType");
            System.out.println(url);
            inputStream.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
