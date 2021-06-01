package com.jkd.demomptest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jkd.demomptest.entity.User;
import com.jkd.demomptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemomptestApplicationTests {

	@Autowired
	private UserMapper userMapper;

	// mp复杂查询操作
	@Test
	public void testSelect() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		// ge、gt、le、lt
//		queryWrapper.ge("age", 21);
		// eq、ne
		queryWrapper.eq("name", "Tom");
		List<User> users = userMapper.selectList(queryWrapper);
		System.out.println(users);
	}

	// 逻辑删除
	@Test
	public void testLogicDelete() {
		int result = userMapper.deleteById(1399564754661023745L);
		System.out.println(result);
	}

	// 根据id删除
	@Test
	public void testDeleteId() {
		int i = userMapper.deleteById(1l);
		System.out.println(i);
	}

	// 分页查询
	@Test
	public void testSelectPage(){
		Page<User> page = new Page(1, 3);
		Page<User> userPage = userMapper.selectPage(page, null);
		//返回对象得到分页所有数据
		long pages = userPage.getPages(); //总页数
		long current = userPage.getCurrent(); //当前页
		List<User> records = userPage.getRecords(); //查询数据集合
		long total = userPage.getTotal(); //总记录数
		boolean hasNext = userPage.hasNext();  //下一页
		boolean hasPrevious = userPage.hasPrevious(); //上一页
		System.out.println(pages);
		System.out.println(current);
		System.out.println(records);
		System.out.println(total);
		System.out.println(hasNext);
		System.out.println(hasPrevious);

	}

	// 简单条件查询
	@Test
	public void testSelect2(){
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("name", "Jack");
		columnMap.put("age", 20);
		List<User> users = userMapper.selectByMap(columnMap);
		System.out.println(users);
	}

	// 多个id批量查询
	@Test
	public void testSelect1() {
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
		System.out.println(users);
	}


	// 测试乐观锁
	@Test
	public void testOptimisticLocker() {
		// 根据id查询
		User user = userMapper.selectById(1396753819697295362L);
		// 修改
		user.setName("张三");
		userMapper.updateById(user);
	}

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
		user.setName("李四yi");
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
