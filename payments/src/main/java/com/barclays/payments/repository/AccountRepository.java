package com.barclays.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.payments.dto.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}
