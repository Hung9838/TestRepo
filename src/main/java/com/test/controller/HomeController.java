package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dao.DepartmentDao;
import com.test.dao.TicketDao;
import com.test.dao.UserDao;

@Controller
public class HomeController {
	@Autowired
	DepartmentDao deDao;
	
	@Autowired
	TicketDao tickDao;
	
	@Autowired 
	UserDao userDao;
	
	@ResponseBody
	@RequestMapping("/abc")
	public String test() {
		deDao.findAll();
		tickDao.findAll();
		userDao.findAll();
		return "ok";
	}
}
