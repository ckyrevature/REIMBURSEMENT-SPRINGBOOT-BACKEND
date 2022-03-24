package com.reimbursement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursement.entities.ReimbursementEntity;
import com.reimbursement.entities.UserEntity;


@Repository
public interface ReimbursementRepository extends JpaRepository<ReimbursementEntity, Long> {
	
	public List<ReimbursementEntity> findByReimbursementApplicantID(Long empId);

}