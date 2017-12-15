package com.zrxjuly.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zrxjuly.demo.dao.IUserDAO;
import com.zrxjuly.demo.model.User;

public class UserTest {

	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	IUserDAO iUserDAO = (IUserDAO) applicationContext.getBean("userDAO");
	
	@Test
	public void addUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("zrx");
		user.setPassword("aaa");
		iUserDAO.addUser(user);
	}
	
	@Test
	public void deleteUser() {
		int id = 1;
		iUserDAO.deleteUser(id);
	}
	
	@Test
	public void selectUserById() {
		int id = 1;
		User user = iUserDAO.selectUserById(id);
		System.out.println(user.toString());
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setId(1);
		iUserDAO.updateUser(user);
	}
	
	@Test
	public void selectAllUser() {
		List<User> user = iUserDAO.selectAllUser();
		for (User user2 : user) {
			System.out.println(user2.toString());
		}
	}
}
