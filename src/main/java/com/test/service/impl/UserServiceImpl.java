package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User createUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}



	@Override
	public Optional<User> findById(String username) {
		return userDao.findById(username);
	}


	@Override
	public List<User> findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void deleteUser(String username) {
		userDao.deleteById(username);
	}

}
