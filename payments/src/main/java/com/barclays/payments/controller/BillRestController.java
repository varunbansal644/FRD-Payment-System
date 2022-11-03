package com.barclays.payments.controller;

import java.util.HashMap;
import java.util.List;
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

import com.barclays.payments.dto.Bill;
import com.barclays.payments.dto.User;
import com.barclays.payments.service.BillService;


@RestController
@RequestMapping("/api/bill")
public class BillRestController {
	
	@Autowired
	private BillService billService;
	
	@PostMapping("/addBill")
	public ResponseEntity<?> addNewBill(@Valid @RequestBody Bill bill) {
		System.out.println(bill);
		String result = null;
		try {
			result = billService.addNewBill(bill);
			Map<String, Object> map = new HashMap<>();
			map.put("status", "success");
			map.put("statusCode", HttpStatus.CREATED);
			map.put("data", bill);
			return ResponseEntity.status(HttpStatus.CREATED).body(map);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, Object> map = new HashMap<>();
			map.put("status", "failed");
			map.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);
			map.put("data", bill);
			map.put("errorMessage", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		
	}
	
	@GetMapping("/getBillById/{id}")
	public ResponseEntity<?> getBillById(@PathVariable("id") int id){
		Optional<Bill> optional = billService.getBillById(id);
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		}
		else return ResponseEntity.ok(optional.get());
	}
	
	@GetMapping("/getBillsByConsumerNumber/{cNum}")
	public ResponseEntity<?> getBillsByConsumerNumber(@PathVariable("cNum") int cNum){
		Optional<List<Bill>> optional = billService.getBillsByConsumerNumber(cNum);
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		}
		else return ResponseEntity.ok(optional.get());
	}
}
