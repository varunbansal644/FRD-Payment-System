package com.barclays.payments.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barclays.payments.dto.AccountTransaction;
import com.barclays.payments.service.PaymentService;


@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayment(@Valid @RequestBody AccountTransaction accountTransaction) {
		System.out.println(accountTransaction);
		String result;
		try {
			result = paymentService.addNewPayment(accountTransaction);
			Map<String, Object> map= new HashMap<>();
			map.put("status", "success");
			map.put("statusCode", 201+"");
			map.put("data",accountTransaction);
			return ResponseEntity.status(HttpStatus.CREATED).body(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Map<String, Object> map= new HashMap<>();
			map.put("status", "failed");
			map.put("statusCode", 500+"");
			map.put("data",accountTransaction);
			map.put("errorMessage", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping("/getAccountTransaction/{id}")
	public ResponseEntity<?> getAccountTransactionById(@PathVariable("id") int transactionReference)
	{
		Optional<AccountTransaction> optional=paymentService.getAccountTransactionById(transactionReference);
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		else
			return ResponseEntity.ok(optional.get());
		
	}
}
