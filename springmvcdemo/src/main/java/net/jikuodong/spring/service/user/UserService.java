package net.jikuodong.spring.service.user;

import net.jikuodong.spring.po.User;
import org.springframework.stereotype.Service;

/**
 * describe 用户service层
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName UserService.java
 * @createTime 2019年06月05日 15:23:00
 */
@Service("userService")
public interface UserService {

    public User getResult();
}