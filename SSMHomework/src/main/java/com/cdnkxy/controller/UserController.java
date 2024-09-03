package com.cdnkxy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdnkxy.entity.PageResult;
import com.cdnkxy.entity.User;
import com.cdnkxy.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;

	@RequestMapping("/login")
	public ModelAndView Login(User user, HttpSession session) {
		User user2 = userservice.Login(user.getName());
		ModelAndView mv = new ModelAndView();
		if (user.getName().equals("ZXC") && user.getPwd().equals("123")) {
			session.setAttribute("u", user2);
			mv.addObject("u", user2);
			mv.setViewName("main");
		} else {
			mv.addObject("msg", "用户名或密码错误");
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping("/userList")
	public ModelAndView selectAll(Integer pageNum, Integer pageSize, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageResult prt = userservice.findAll(pageNum, pageSize);
		mv.addObject("pageResult", prt);
		mv.addObject("pageNum", pageNum);
		mv.addObject("gour1", request);
		mv.setViewName("user");
		return mv;
	}

	// 查找用户信息
	@RequestMapping("/FindUserById")
	public ModelAndView FindUserById(Integer id, User user) {
		ModelAndView mv = new ModelAndView();
		user = userservice.FindUserById(id);
		mv.addObject("user", user);
		if (user != null) {
			mv.setViewName("findResult");
		} else {
			mv.addObject("msg", "未找到该用户信息");
			mv.setViewName("findResult");
		}
		return mv;
	}

	// 跳转到添加信息页面
	@RequestMapping("/addPage")
	public ModelAndView addPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addInfo");
		return mv;
	}

	// 添加用户信息
	@RequestMapping("/addInfo")
	public ModelAndView addInfo(User user, String name, String tel, String role, Integer pageNum, Integer pageSize,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		user.setName(name);
		user.setRole(role);
		user.setTel(tel);
		userservice.addUser(user);
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageResult prt = userservice.findAll(pageNum, pageSize);
		mv.addObject("pageResult", prt);
		mv.addObject("pageNum", pageNum);
		mv.addObject("gour1", request);
		mv.setViewName("user");
		return mv;
	}

	// 删除用户信息
	@RequestMapping("/delInfo")
	public ModelAndView delInfo(Integer id, Integer pageNum, Integer pageSize, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		userservice.delUser(id);
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageResult prt = userservice.findAll(pageNum, pageSize);
		mv.addObject("pageResult", prt);
		mv.addObject("pageNum", pageNum);
		mv.addObject("gour1", request);
		mv.setViewName("user");
		return mv;
	}

	// 跳转更改页面
	@RequestMapping("/altPage")
	public ModelAndView altPage(Integer id, User user) {
		ModelAndView mv = new ModelAndView();
		user = userservice.FindUserById(id);
		mv.addObject("user", user);
		mv.setViewName("altUser");
		return mv;
	}

	// 更改用户信息
	@RequestMapping("/altUser")
	public ModelAndView altUser(Integer pageNum, Integer pageSize, HttpServletRequest request,User user, String name, String tel, String role,Integer id) {
		ModelAndView mv = new ModelAndView();
		user.setId(id);
		user.setName(name);
		user.setRole(role);
		user.setTel(tel);
		userservice.altUser(user);
		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageResult prt = userservice.findAll(pageNum, pageSize);
		mv.addObject("pageResult", prt);
		mv.addObject("pageNum", pageNum);
		mv.addObject("gour1", request);
		mv.setViewName("user");
		return mv;
	}

}
