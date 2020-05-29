package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @projectName: springdemo
 * @package: jdbc
 * @className: JdbcDemo1
 * @author: JKD
 * @description: 程序耦合
 *  耦合： 程序间的依赖关系
 *      包括：
 *          类之间的依赖
 *          方法之间的依赖
*       解耦：
 *        降低程序间的依赖关系
*        实际开发中：
 *          应该做到：编译期不依赖，运行时才依赖。
*        解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字
 *          第二部： 通过读取配置文明间来获取要创建的对象全限定类名。
 *
 * @description
 *
 * @method
 * @author JKD
 * @return
 * @Exception
 * @date 2020/5/29 10:19
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        // 1. 注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 2. 获取连接
        // 3. 获取操作数据库的预处理对象

    }
}
