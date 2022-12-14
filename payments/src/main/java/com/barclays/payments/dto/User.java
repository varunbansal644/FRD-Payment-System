package com.barclays.payments.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	@Id
	private String loginId;
	@Column(unique=true)
	private int consumerNumber;
	private String password;
	@Nullable
	private int sequenceId;
	@OneToOne
	private Role role;
}
