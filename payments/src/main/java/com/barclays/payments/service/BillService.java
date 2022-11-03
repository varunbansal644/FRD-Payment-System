package com.barclays.payments.service;

import java.util.List;
import java.util.Optional;

import com.barclays.payments.dto.Bill;

public interface BillService {
	public String addNewBill(Bill bill);
	public Optional<Bill> getBillById(int id);
	public Optional<List<Bill>> getBillsByConsumerNumber(int consumerNumber);
}
