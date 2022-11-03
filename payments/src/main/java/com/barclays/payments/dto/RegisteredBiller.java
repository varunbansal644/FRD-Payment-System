package com.barclays.payments.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="registeredBiller")
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
