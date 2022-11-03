package com.barclays.payments.service;

import java.util.Optional;


import com.barclays.payments.dto.AccountTransaction;

public interface PaymentService {
	
	public String addNewPayment(AccountTransaction accountTransaction);
	public Optional<AccountTransaction> getAccountTransactionById(int transactionReference);

}
