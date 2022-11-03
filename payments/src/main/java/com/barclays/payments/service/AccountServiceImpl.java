package com.barclays.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.payments.dto.Account;
import com.barclays.payments.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public String addNewAccount(Account account) {
		// TODO Auto-generated method stub
		Account act = null;
		try {
			act = accountRepository.save(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		if(act!=null)
			return "success";
		else
			return "fail";
	}
	

	@Override
	public String deleteAccount(int sequenceId) {
		// TODO Auto-generated method stub
		try {
			Optional<Account> optional = accountRepository.findById(sequenceId);
			
			if(optional.isPresent()) {
				accountRepository.deleteById(sequenceId);
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
	

	@Override
	public Optional<Account> getAccountById(int sequenceId) {
		// TODO Auto-generated method stub
		return accountRepository.findById(sequenceId);
	}

}
