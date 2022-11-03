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

import com.barclays.payments.dto.Account;
import com.barclays.payments.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/addAccount")
	public ResponseEntity<?> addAccount(@Valid @RequestBody Account account) {
		System.out.println(account);
		String result;
		try {
			result = accountService.addNewAccount(account);
			Map<String, Object> map= new HashMap<>();
			map.put("status", "success");
			map.put("statusCode", 201+"");
			map.put("data",account);
			return ResponseEntity.status(HttpStatus.CREATED).body(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Map<String, Object> map= new HashMap<>();
			map.put("status", "failed");
			map.put("statusCode", 500+"");
			map.put("data",account);
			map.put("errorMessage", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String sequenceId)
	{
		String result=accountService.deleteAccount(sequenceId);
		
		if("fail".equals(result)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record doesn't exist");
		}
		else
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("record deleted successfully");
	}

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") String sequenceId)
	{
		Optional<Account> optional=accountService.getAccountById(sequenceId);
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		else
			return ResponseEntity.ok(optional.get());
		
	}

}
