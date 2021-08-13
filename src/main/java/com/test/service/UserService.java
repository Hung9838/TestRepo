package com.test.service;

import java.util.List;
import java.util.Optional;

import com.test.entity.User;

public interface UserService {
		// Lay tat ca
		List<User> findAll();
		// Them
		User createUser(User user);
		// Sua
		User updateUser(User user);
		// Xoa
		void deleteUser(String username);
		Optional<User> findById(String username);
		// Tim kiem theo username
		List<User> findByEmail(String email);
}
