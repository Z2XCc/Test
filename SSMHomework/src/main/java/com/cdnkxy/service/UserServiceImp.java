package com.cdnkxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdnkxy.dao.UserMapper;
import com.cdnkxy.entity.PageResult;
import com.cdnkxy.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserMapper usermapper;
	
	@Override
	public User Login(String name) {
		// TODO Auto-generated method stub
		return usermapper.Login(name);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		usermapper.addUser(user);
	}

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
		usermapper.delUser(id);
	}

	@Override
	public void altUser(User user) {
		// TODO Auto-generated method stub
		usermapper.altUser(user);
	}

	@Override
	public PageResult findAll(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		Page<User> page=usermapper.findAll();
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public User FindUserById(int id) {
		return usermapper.FindUserById(id);
	}

}
