package com.namratha.springboot.FirstApp.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namratha.springboot.FirstApp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

	User findByEmail(String email);

}
