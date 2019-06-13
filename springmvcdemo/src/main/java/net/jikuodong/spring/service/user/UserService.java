package net.jikuodong.spring.service.user;

import com.github.pagehelper.PageInfo;
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

    /**
     * describe
     *
     * @method getResult
     * @author JKD
     * @param limit 显示列数
     * @param offset 页码
     * @return com.github.pagehelper.PageInfo
     * @data 2019/6/12 16:19
     * @throws
     */
    public PageInfo getResult(int offset, int limit);
}
