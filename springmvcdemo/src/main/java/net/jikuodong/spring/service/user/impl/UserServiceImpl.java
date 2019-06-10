package net.jikuodong.spring.service.user.impl;

import net.jikuodong.spring.dao.UserMapper;
import net.jikuodong.spring.po.User;
import net.jikuodong.spring.service.user.UserService;
import org.springframework.stereotype.Service;

/**
 * describe 用户service实现
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @createTime 2019年06月05日 15:24:00
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getResult() {
        User user = userMapper.selectByPrimaryKey("048d38b39e75441e8fb80eae75f24af4");
        return user;
    }
}
