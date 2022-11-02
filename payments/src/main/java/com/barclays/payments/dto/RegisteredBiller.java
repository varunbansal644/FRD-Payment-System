package com.barclays.payments.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Data
public class RegisteredBiller {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billerSequenceId;
	private String billerCode;
	private int consumerNumber;
	private int accountNumber;
	private boolean autoPay; // 1 for autopay enabled 0 for disabled
	private float autoPayLimit = (float) 0.0;
	
}
