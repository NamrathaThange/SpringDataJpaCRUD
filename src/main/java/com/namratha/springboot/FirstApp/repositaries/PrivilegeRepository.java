package com.namratha.springboot.FirstApp.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namratha.springboot.FirstApp.domain.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege , Long> {

	Privilege findByPrivilegeName(String privilegeName);

}
