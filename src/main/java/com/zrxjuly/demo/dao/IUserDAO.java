package com.zrxjuly.demo.dao;

import java.util.List;

import com.zrxjuly.demo.model.User;

public interface IUserDAO {
	public void addUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public User selectUserById(int id);
	public List<User> selectAllUser();
}
