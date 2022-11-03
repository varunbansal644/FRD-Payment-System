package com.barclays.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.barclays.payments.dto.AccountTransaction;
import com.barclays.payments.repository.PaymentRepository;

public class PaymentServiceImpl implements PaymentService {
	
	private PaymentServiceImpl() {
		
	}

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public String addNewPayment(AccountTransaction accountTransaction) {
		// TODO Auto-generated method stub
		AccountTransaction acctTran =null;
		
		try {
			acctTran = paymentRepository.save(accountTransaction);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		if(acctTran != null) {
			return "Success";
		}
		else {
			return "Failure";
		}
	}

	@Override
	public Optional<AccountTransaction> getAccountTransactionById(int transactionReference) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(transactionReference);
	}

}
