package com.reimbursement.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.reimbursement.entities.ReimbursementEntity;

public class Image {
	
	private Long imageId;

	private String imagePath;
	
	private int imageReimId;

	public Image() {
		super();
	}

	public Image(Long imageId, String imagePath, int imageReimId) {
		super();
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.imageReimId = imageReimId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getImageReimId() {
		return imageReimId;
	}

	public void setImageReimId(int imageReimId) {
		this.imageReimId = imageReimId;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imagePath=" + imagePath + ", imageReimId=" + imageReimId + "]";
	}
	
	
	
}
