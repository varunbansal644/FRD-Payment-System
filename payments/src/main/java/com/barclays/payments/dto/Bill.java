package com.barclays.payments.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billSequenceId;
	
	private String billerCode;
	
	private int consumerNumber;
	private float amount;
    private Date dueDate;
    private String status;

}
