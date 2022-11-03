package com.barclays.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.payments.dto.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	List<Bill> findByConsumerNumber(int consumerNumber);
}
