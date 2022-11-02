package com.barclays.payments.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="masterBiller")
public class MasterBiller {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String billerCode;
	private String billerName;
}
