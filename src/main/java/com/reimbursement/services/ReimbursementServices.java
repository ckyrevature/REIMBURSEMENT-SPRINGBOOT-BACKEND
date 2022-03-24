package com.reimbursement.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;
import com.reimbursement.entities.ImageEntity;
import com.reimbursement.models.GenericResponse;
import com.reimbursement.models.Reimbursement;

public interface ReimbursementServices {

	//public GenericResponse addReimbursement(Reimbursement reimbursement);
	public GenericResponse addReimbursement(Reimbursement reimbursement, MultipartFile file) throws IOException;
	
	public List<Reimbursement> searchReimbursements(Long empId);

	public boolean updateReimbursement(Reimbursement reimbursement);

	public List<Reimbursement> getAllReimbursements();
	
	//public S3Object download(String key) throws IOException;
	
	public ImageEntity download(Long id);

}