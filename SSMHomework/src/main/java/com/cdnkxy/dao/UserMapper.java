package com.cdnkxy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cdnkxy.entity.User;
import com.github.pagehelper.Page;

public interface UserMapper {
	@Select(value="select * from t_user where id=#{id}")
	public User Login(String name);
	@Insert(value="insert into t_user (name,tel,role) values (#{name},#{tel},#{role})")
	public void addUser(User user);
	@Delete(value="delete from t_user where id=#{id}")
	public void delUser(Integer id);
	@Update(value="update t_user set name=#{name},tel=#{tel},role=#{role} where id=#{id}")
	public void altUser(User user);
	@Select(value="select * from t_user")
	public Page<User> findAll();
	@Select(value="select * from t_user where id=#{id}")
	public User FindUserById(int id);
}
