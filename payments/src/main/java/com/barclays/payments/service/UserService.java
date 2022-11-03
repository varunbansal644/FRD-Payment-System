package com.barclays.payments.service;

import java.util.Optional;

import com.barclays.payments.dto.User;

public interface UserService {
	public String addNewUser(User user);
	public boolean authenticateUser(String loginId, String password);
	public Optional<User> getUserById(String userId);
}
