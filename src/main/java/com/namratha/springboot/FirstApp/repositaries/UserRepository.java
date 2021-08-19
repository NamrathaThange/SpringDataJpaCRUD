package com.namratha.springboot.FirstApp.repositaries;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.namratha.springboot.FirstApp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

	User findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update User u set u.validEmail = ?2 where u.email = ?1")
	int updateValidEmail(String email, int status);
	
	

}
