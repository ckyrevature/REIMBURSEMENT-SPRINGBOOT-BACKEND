package com.reimbursement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.reimbursement.entities.ReimbursementEntity;
import com.reimbursement.entities.UserEntity;
import com.reimbursement.models.Reimbursement;
import com.reimbursement.models.User;
import com.reimbursement.repositories.ReimbursementRepository;
import com.reimbursement.repositories.UserRepository;

@SpringBootTest
public class ReimbursementServicesTest {
	@Autowired
	private ReimbursementServicesImpl rServicesImpl;
	
	//Dummy service : don't create a actually bean
	@MockBean
	private ReimbursementRepository repo;
	
	@InjectMocks
	private ReimbursementServices reimbursementServices = new ReimbursementServicesImpl();
	
	
@BeforeEach
void setUp() throws Exception {
}

//@Test
//public void test_getAllReimbursements() {
//	when(repo.findAll()).thenReturn(Stream.of(new ReimbursementEntity(
//			(long)1, (double) 7.5, null, null, "for bus", (long)1, (long)2 , null)).collect(Collectors.toList()));
//	
//	List<Reimbursement> reimbursementResolve = reimbursementServices.getAllReimbursements();
//
//	Assertions.assertNull(reimbursementResolve);
	
//	ReimbursementEntity entity = new ReimbursementEntity();
//	entity.setReimbursementAmount(77.8);
//	entity.setReimbursementDescription("for travel fee");
//	
//	List<Reimbursement> eimbursementResolve = reimbursementServices.getAllReimbursements();
//	
//	assertNotNull(eimbursementResolve);  




@Test
public void test_searchReimbursents() {
	ReimbursementEntity entity = new ReimbursementEntity();
	entity.setReimbursementAmount(2.5);
	entity.setReimbursementDescription("for hotel");
	List<ReimbursementEntity> entityList = new ArrayList<ReimbursementEntity>(); entityList.add(entity);
	when(repo.findByReimbursementApplicantID(1L)).thenReturn(entityList);
	
//	reim.setReimbursementID(reimEntity.getReimbursementId());
//	reim.setReimbursementAmount(reimEntity.getReimbursementAmount());
//	reim.setReimbursementDescription(reimEntity.getReimbursementDescription());
//	reim.setReimbursementSubmitTime(reimEntity.getReimbursementSubmitTime());
//	reim.setReimbursementResolvedTime(reimEntity.getReimbursementResolvedTime());
//	reim.setReimbursementApplicantID(reimEntity.getReimbursementApplicantID());
//	reim.setImagePath(reimEntity.getImagePath());
	
	Reimbursement reimbursement = new Reimbursement();
	reimbursement.setReimbursementID(1L);
	reimbursement.setReimbursementAmount(20.89);
	reimbursement.setReimbursementDescription("for bus");
//	reimbursement.setReimbursementSubmitTime(null);
//	reimbursement.setReimbursementResolvedTime(null);
	reimbursement.setReimbursementApplicantID(2L);
//	reimbursement.setImagePath(null);
	
	List<Reimbursement> reimbursementResolve = reimbursementServices.searchReimbursements(reimbursement.getReimbursementApplicantID());
	assertNotNull(reimbursementResolve);

 
} 


}
;