package com.barclays.payments.dto;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="accountTransaction")
public class AccountTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String transactionReference;
	private LocalDateTime dateTime;
	private float amount;
	private boolean debit; // 1 for debit 0 for credit
	private String description;
}
