package com.jkd.demomptest;

import com.jkd.demomptest.entity.User;
import com.jkd.demomptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemomptestApplicationTests {

	@Autowired
	private UserMapper userMapper;

	// 修改操作

	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(1390947950678175746L);
		user.setName("lucymaryupup");
		int i = userMapper.updateById(user);
		System.out.println(i);
	}

	// 添加操作

	@Test
	public void testAdd() {
		User user = new User();
		user.setName("lucy");
		user.setAge(20);
		user.setEmail("1234@qq.com");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}

	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

}
