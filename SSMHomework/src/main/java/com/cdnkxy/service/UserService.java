package com.cdnkxy.service;
import com.cdnkxy.entity.PageResult;
import com.cdnkxy.entity.User;

public interface UserService {
	
	public User Login(String name);
	
	public void addUser(User user);

	public void delUser(int id);

	public void altUser(User user);
	
	public PageResult findAll(Integer pageNum,Integer pageSize);
	
	public User FindUserById(int id);
}
