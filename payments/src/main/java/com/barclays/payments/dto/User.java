package com.barclays.payments.dto;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String loginId;
	@Column(unique=true)
	private int consumerNumber;
	private String password;
	// private String sequenceId;
	@Column(table="role")
	private int roleId;
}
