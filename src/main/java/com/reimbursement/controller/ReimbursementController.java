package com.reimbursement.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;
import com.reimbursement.entities.ImageEntity;
import com.reimbursement.models.GenericResponse;
import com.reimbursement.models.Reimbursement;
import com.reimbursement.services.ReimbursementServices;

@RestController
@RequestMapping
@CrossOrigin
public class ReimbursementController {

	@Autowired
	private ReimbursementServices reimbursementServices;

	// getAllReimbursements
	@GetMapping("/api/reimbursements")
	public List<Reimbursement> getAllReimbursements() {
		return reimbursementServices.getAllReimbursements();
	}

	@PostMapping(path = "/api/reimbursements/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public GenericResponse saveTestReimbursement(@RequestParam MultipartFile file, @RequestParam Double amount,
			@RequestParam Long userId, @RequestParam String description) throws IOException {
		Reimbursement reim = new Reimbursement();
		reim.setReimbursementAmount(amount);
		reim.setReimbursementDescription(description);
		reim.setReimbursementApplicantID(userId);
		return reimbursementServices.addReimbursement(reim, file);
	}
	
	@GetMapping("api/reimbursements/search")
	public List<Reimbursement> searchReimbursements(Long empId) {
		return reimbursementServices.searchReimbursements(empId);
	}
	

	@PutMapping("/api/reimbursements/update")
	public ResponseEntity<GenericResponse> updateReimbursement(@RequestBody Reimbursement reim) {
		if(reimbursementServices.updateReimbursement(reim)) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Success"), HttpStatus.OK);
		} else {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/api/reimbursements/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable("id") Long id) throws IOException {
//		S3Object s3object = reimbursementServices.download(id);
//		InputStream is = s3object.getObjectContent();
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		int len;
//		byte[] buffer = new byte[4096];
//		while ((len = is.read(buffer, 0, buffer.length)) != -1) {
//			baos.write(buffer, 0, len);
//		}
//		return ResponseEntity.ok().header("Content-Type", s3object.getObjectMetadata().getContentType())
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + id + "\"")
//				.body(baos.toByteArray());
		ImageEntity entity = reimbursementServices.download(id);
		return ResponseEntity.ok().header("Content-Type", entity.getContentType())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + entity.getImageName() + "\"")
				.body(entity.getData());
	}
}





//@PostMapping("/api/reimbursements/add")
//public GenericResponse saveReimbursement(@RequestBody Reimbursement reim) {
//	return reimbursementServices.addReimbursement(reim);
//}
//@PostMapping(path = "/api/reimbursements/addtest", consumes= { MediaType.MULTIPART_FORM_DATA_VALUE})
//
//public GenericResponse saveTestReimbursement(@RequestBody Reimbursement reim,  @RequestParam  MultipartFile file) throws IOException {
//	System.out.println(reim.getReimbursementApplicantID());
//	System.out.println(file.getOriginalFilename());
//	System.out.println(file.getInputStream());
//	return null;
//}
//