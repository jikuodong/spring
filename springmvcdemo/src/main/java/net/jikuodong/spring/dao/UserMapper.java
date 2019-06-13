package net.jikuodong.spring.dao;

import net.jikuodong.spring.po.User;
import net.jikuodong.spring.utils.PageData;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<PageData> getUser();
}
