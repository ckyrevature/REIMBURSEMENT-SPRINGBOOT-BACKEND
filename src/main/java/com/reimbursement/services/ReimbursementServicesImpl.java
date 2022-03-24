package com.reimbursement.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.reimbursement.entities.ImageEntity;
import com.reimbursement.entities.ReimbursementEntity;
import com.reimbursement.models.GenericResponse;
import com.reimbursement.models.Reimbursement;
import com.reimbursement.repositories.ImageRepository;
import com.reimbursement.repositories.ReimbursementRepository;

@Service
public class ReimbursementServicesImpl implements ReimbursementServices {

//	@Value("${aws.bucket-name}")
//	private String bucketName;

	@Autowired
	private ReimbursementRepository reimbursementRepo;
	
	@Autowired
	private ImageRepository imageRepo;

//	@Autowired
//	private AmazonS3 amazonS3;

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> allReimbursement = new ArrayList<Reimbursement>();
		List<ReimbursementEntity> allReimbursementEntity = reimbursementRepo.findAll();
		for (ReimbursementEntity reimbursementEntity : allReimbursementEntity) {
			Reimbursement reimbursement = new Reimbursement(reimbursementEntity.getReimbursementId(),
					reimbursementEntity.getReimbursementAmount(), reimbursementEntity.getReimbursementSubmitTime(),
					reimbursementEntity.getReimbursementResolvedTime(),
					reimbursementEntity.getReimbursementDescription(),
					reimbursementEntity.getReimbursementApplicantID(), reimbursementEntity.getReimbursementStatusID(),
					//if reimbursementEntity.getImage() != null , print reimbursementEntity.getImage().getImageId()
					//else , print 0
					reimbursementEntity.getImage() != null ? reimbursementEntity.getImage().getImageId() : 0);
			allReimbursement.add(reimbursement);
		}
		return allReimbursement;
	}

	@Override
	public List<Reimbursement> searchReimbursements(Long empId) {
		List<Reimbursement> allReimbursement = new ArrayList<Reimbursement>();
		List<ReimbursementEntity> entities = reimbursementRepo.findByReimbursementApplicantID(empId);
		for (ReimbursementEntity reimEntity : entities) {
			Reimbursement reim = new Reimbursement();
			reim.setReimbursementID(reimEntity.getReimbursementId());
			reim.setReimbursementAmount(reimEntity.getReimbursementAmount());
			reim.setReimbursementDescription(reimEntity.getReimbursementDescription());
			reim.setReimbursementSubmitTime(reimEntity.getReimbursementSubmitTime());
			reim.setReimbursementResolvedTime(reimEntity.getReimbursementResolvedTime());
			reim.setReimbursementApplicantID(reimEntity.getReimbursementApplicantID());

			if(reimEntity.getImage() != null) {
				reim.setImageId(reimEntity.getImage().getImageId());
			}
			allReimbursement.add(reim);
		}
		return allReimbursement;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		if (reimbursement.getReimbursementID() != null
				&& reimbursementRepo.existsById(reimbursement.getReimbursementID())) {
			ReimbursementEntity entity = reimbursementRepo.getById(reimbursement.getReimbursementID());
			entity.setReimbursementStatusID(reimbursement.getReimbursementStatusID());
			entity.setReimbursementResolvedTime(new Date());
			reimbursementRepo.save(entity);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public GenericResponse addReimbursement(Reimbursement reimbursement, MultipartFile file) throws IOException {

//		Map<String, String> metadata = new HashMap<>();
//		metadata.put("Content-Type", file.getContentType());
//		metadata.put("Content-Length", String.valueOf(file.getSize()));
//		Optional<Map<String, String>> opt = Optional.of(metadata);
//		String filename = new Date().getTime() + "_" + file.getOriginalFilename();
//		upload(filename, opt, file.getInputStream());

		ReimbursementEntity entity = new ReimbursementEntity();
		entity.setReimbursementAmount(reimbursement.getReimbursementAmount());
		entity.setReimbursementApplicantID(reimbursement.getReimbursementApplicantID());
		entity.setReimbursementDescription(reimbursement.getReimbursementDescription());
		entity.setReimbursementSubmitTime(new Date());
		entity.setReimbursementStatusID(2L);

		ImageEntity imgEntity = new ImageEntity();
		imgEntity.setImageName(file.getOriginalFilename());
		imgEntity.setReim(entity);
		imgEntity.setData(file.getBytes());
		imgEntity.setContentType(file.getContentType());

		imgEntity = imageRepo.save(imgEntity);
		return new GenericResponse("success");
	}

//	public void upload(String fileName, Optional<Map<String, String>> optionalMetaData, InputStream inputStream) {
//		ObjectMetadata objectMetadata = new ObjectMetadata();
//		optionalMetaData.ifPresent(map -> {
//			if (!map.isEmpty()) {
//				map.forEach(objectMetadata::addUserMetadata);
//			}
//		});
//		try {
//			amazonS3.putObject(bucketName, fileName, inputStream, objectMetadata);
//		} catch (AmazonServiceException e) {
//			throw new IllegalStateException("Failed to upload the file", e);
//		}
//	}

//	@Override
//	public S3Object download(String key) throws IOException {
//		try {
//			return amazonS3.getObject(bucketName, key);
//		} catch (AmazonServiceException e) {
//			throw new IllegalStateException("Failed to download the file", e);
//		}
//	}

	public ImageEntity download(Long id) {
		return imageRepo.getById(id);
	}

}