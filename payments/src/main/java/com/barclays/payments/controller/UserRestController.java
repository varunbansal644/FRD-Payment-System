package com.barclays.payments.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.payments.dto.User;
import com.barclays.payments.dto.UserLoginObject;
import com.barclays.payments.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addNewUser(@Valid @RequestBody User user) {
		System.out.println(user);
		String result = null;
		try {
			result = userService.addNewUser(user);
			Map<String, Object> map = new HashMap<>();
			map.put("status", "success");
			map.put("statusCode", HttpStatus.CREATED);
			map.put("data", user);
			return ResponseEntity.status(HttpStatus.CREATED).body(map);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, Object> map = new HashMap<>();
			map.put("status", "failed");
			map.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);
			map.put("data", user);
			map.put("errorMessage", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		
	}
	
//	@DeleteMapping("/deleteEmployee/{id}")
//	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
//		String result = employeeService.deleteEmployee(id);
//		if("Failure".equals(result)) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record does not exist");
//			
//		}
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Record deleted successfully!");
//	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id){
		Optional<User> optional = userService.getUserById(id);
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		}
		else return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginObject userLogin) {
		System.out.println(userLogin);
		boolean result = false;
			System.out.println(userLogin.getLoginId());
			System.out.println(userLogin.getPassword());
			result = userService.authenticateUser(userLogin.getLoginId(), userLogin.getPassword());		
			Map<String, Object> map = new HashMap<>();
			if(result == true) {
				map.put("status", "success");
				map.put("loggedIn", result);
				return ResponseEntity.status(HttpStatus.OK).body(map);
			}
			map.put("status", "failure");
			map.put("loggedIn", result);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		
		
	}
	
}

