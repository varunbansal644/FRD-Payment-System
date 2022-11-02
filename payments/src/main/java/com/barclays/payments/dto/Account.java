package com.barclays.payments.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String sequenceId;
	@Column(unique = true)
	private int accountNumber;
	private String name;
	private String email;
	private float currentBalance;
	
	
	
}
