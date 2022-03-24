package com.reimbursement.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "image")
public class ImageEntity {
	
	@Id
	@Column(name="image_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	
	@Column(name = "image_name")
	private String imageName;
	
	//https://stackoverflow.com/questions/59484373/wrong-column-type-encountered-in-column-image-in-tableproductlines-foundme
	@Column
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] data;
	
	@Column(name = "content_type")
	private String contentType;
//	
//	@Column(name = "reimbursement_id")
//	private Date reimbursementId;
	
	//https://www.baeldung.com/jpa-cascade-types
	//Reimbursement-Image table relationship
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reimbursement_id", referencedColumnName = "reimbursement_id")
	private ReimbursementEntity reim;

	public ImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageEntity(Long imageId, String imageName) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		// this.reimbursementId = reimbursementId;
	}
	
	public ImageEntity(String imageName) {
		super();
		this.imageName = imageName;
		// this.reimbursementId = reimbursementId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
//	public Date getReimbursementId() {
//		return reimbursementId;
//	}
//
//	public void setReimbursementId(Date reimbursementId) {
//		this.reimbursementId = reimbursementId;
//	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public ReimbursementEntity getReim() {
		return reim;
	}

	public void setReim(ReimbursementEntity reim) {
		this.reim = reim;
	}

	@Override
	public String toString() {
		return "ImageEntity [imageId=" + imageId + ", imageName=" + imageName + ", reimbursementId=" + reim.getReimbursementId()
				+ "]";
	}
	
	

}