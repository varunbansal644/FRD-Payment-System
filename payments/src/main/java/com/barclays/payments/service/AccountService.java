package com.barclays.payments.service;

import java.util.Optional;

import com.barclays.payments.dto.Account;

public interface AccountService {

	public String addNewAccount(Account account);
	public String deleteAccount(String sequenceId);
	public Optional<Account> getAccountById(String sequenceId);
}
