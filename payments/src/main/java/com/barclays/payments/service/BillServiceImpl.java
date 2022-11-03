package com.barclays.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.payments.dto.Bill;
import com.barclays.payments.repository.BillRepository;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
	private BillServiceImpl() {
		
	}
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public String addNewBill(Bill newBill) {
		// TODO Auto-generated method stub
		Bill bill = null;
		try {
			bill = billRepository.save(newBill);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		if(bill != null) {
			return "Success";
		}
		else {
			return "Failure";
		}
	}

	@Override
	public Optional<Bill> getBillById(int id) {
		// TODO Auto-generated method stub
		return billRepository.findById(id);
	}

	@Override
	public Optional<List<Bill>> getBillsByConsumerNumber(int consumerNumber) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(billRepository.findByConsumerNumber(consumerNumber));
	}

}
