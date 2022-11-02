package com.barclays.payments.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class MasterBiller {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String billerCode;
	private String billerName;
}
