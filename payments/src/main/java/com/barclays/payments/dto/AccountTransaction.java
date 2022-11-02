package com.barclays.payments.dto;


import java.sql.Time;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class AccountTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String transactionReference;
	private Date date;
	private float amount;
	private boolean debit; // 1 for debit 0 for credit
	private String description;
}
