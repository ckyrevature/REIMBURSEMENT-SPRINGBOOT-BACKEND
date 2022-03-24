package com.reimbursement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.reimbursement.entities.ImageEntity;
import com.reimbursement.entities.ReimbursementEntity;
import com.reimbursement.models.Reimbursement;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long>{
	//SELECT * FROM image WHERE reimbursement_id = ? 
	ImageEntity findByReim(ReimbursementEntity reimbursement);

}