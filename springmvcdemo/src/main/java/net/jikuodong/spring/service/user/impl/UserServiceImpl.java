package net.jikuodong.spring.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.jikuodong.spring.dao.UserMapper;
import net.jikuodong.spring.po.User;
import net.jikuodong.spring.service.user.UserService;
import net.jikuodong.spring.utils.PageData;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * describe
     *
     * @method getResult
     * @author JKD
     * @param offset 页码
     * @param limit 显示列数
     * @return com.github.pagehelper.PageInfo
     * @data 2019/6/12 16:37
     * @throws
     */
    @Override
    public PageInfo getResult(int offset, int limit) {
        PageHelper.startPage(offset, limit, true);
        List<PageData> list = userMapper.getUser();
        return new PageInfo<>(list);
    }
}
