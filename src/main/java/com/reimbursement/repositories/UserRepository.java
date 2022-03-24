package com.reimbursement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursement.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public List<UserEntity> findByRoleID(Long roleId);
	
	public UserEntity findByUsernameAndUserPassword(String username, String password);
	

}