package com.barclays.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.payments.dto.AccountTransaction;

@Repository
public interface PaymentRepository extends JpaRepository<AccountTransaction, Integer>{

}
