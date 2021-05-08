package com.jkd.demomptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jkd.demomptest.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @projectName: demomptest
 * @package: com.jkd.demomptest.mapper
 * @className: UserMapper
 * @author: JKD
 * @description:
 * @version: 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
