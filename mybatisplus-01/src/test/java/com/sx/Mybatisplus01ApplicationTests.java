package com.sx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sx.mapper.UserMapper;
import com.sx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
class Mybatisplus01ApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	void testSave(){
		User user = new User();
		user.setName("sxxx");
		user.setPassword("312132");
		user.setAge(22);
		user.setTel("3214512414");
		userMapper.insert(user);
	}
	@Test
	void testDelete(){
		userMapper.deleteById(1625744258143109121L);
	}
	@Test
	void testupdate(){
		User user = new User();
		user.setId(1L);
		user.setName("tom");
		userMapper.updateById(user);
	}
	@Test
	void testGetById(){
		User user = userMapper.selectById(1l);
		System.out.println(user);
	}
	@Test
	void testGetAll(){
		List<User> userList = userMapper.selectList(null);
		System.out.println(userList);
	}
	@Test
	void testGetByPage(){
		IPage iPage = new Page(2,2);
		userMapper.selectPage(iPage,null);
		System.out.println("当前页码" + iPage.getCurrent());
		System.out.println("每页显示数" + iPage.getSize());
		System.out.println("一共多少页" + iPage.getPages());
		System.out.println("一共多少条数据" + iPage.getTotal());
		System.out.println("数据" + iPage.getRecords());

	}

}
