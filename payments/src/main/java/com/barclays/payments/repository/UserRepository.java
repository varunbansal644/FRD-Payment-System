package com.barclays.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.payments.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
