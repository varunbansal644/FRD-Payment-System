package com.barclays.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.payments.dto.User;
import com.barclays.payments.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserServiceImpl() {
		
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String addNewUser(User user) {
		// TODO Auto-generated method stub
		User usr = null;
		try {
			usr = userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		if(usr != null) {
			return "Success";
		}
		else {
			return "Failure";
		}
	}

	@Override
	public boolean authenticateUser(String loginId, String password) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(loginId);
		if(optional.isPresent()) {
			System.out.println(password);
			System.out.println(optional.get().getPassword());
			return password.equals(optional.get().getPassword());
		}
		return false;
	}

	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

}
