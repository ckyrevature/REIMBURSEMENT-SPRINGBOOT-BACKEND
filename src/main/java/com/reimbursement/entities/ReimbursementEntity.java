package com.reimbursement.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class ReimbursementEntity {
	
	@Id
	@Column(name="reimbursement_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reimbursementId;
	
	@Column(name = "reimbursement_amount")
	private Double reimbursementAmount;
	
	@Column(name = "reimbursement_submit_time")
	private Date reimbursementSubmitTime;
	
	@Column(name = "reimbursement_resolved_time")
	private Date reimbursementResolvedTime;

	@Column(name ="reimbursement_description")
	private String reimbursementDescription;
	
	
	@Column(name = "reimbursement_applicant_id")
	private Long reimbursementApplicantID;
	
	@Column(name = "reimbursement_status_id")
	private Long reimbursementStatusID;
	
	//Map to image table at image entity
	@OneToOne(mappedBy = "reim")
	private ImageEntity image;
	
	
	public ReimbursementEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementEntity(Long reimbursementId, Double reimbursementAmount, Date reimbursementSubmitTime,
			Date reimbursementResolvedTime, String reimbursementDescription, Long reimbursementApplicantID,
			Long reimbursementStatusID) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmitTime = reimbursementSubmitTime;
		this.reimbursementResolvedTime = reimbursementResolvedTime;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementApplicantID = reimbursementApplicantID;
		this.reimbursementStatusID = reimbursementStatusID;
		
	}

	public Long getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(Long reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public Double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(Double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public Date getReimbursementSubmitTime() {
		return reimbursementSubmitTime;
	}

	public void setReimbursementSubmitTime(Date reimbursementSubmitTime) {
		this.reimbursementSubmitTime = reimbursementSubmitTime;
	}

	public Date getReimbursementResolvedTime() {
		return reimbursementResolvedTime;
	}

	public void setReimbursementResolvedTime(Date reimbursementResolvedTime) {
		this.reimbursementResolvedTime = reimbursementResolvedTime;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public Long getReimbursementApplicantID() {
		return reimbursementApplicantID;
	}

	public void setReimbursementApplicantID(Long reimbursementApplicantID) {
		this.reimbursementApplicantID = reimbursementApplicantID;
	}

	public Long getReimbursementStatusID() {
		return reimbursementStatusID;
	}

	public void setReimbursementStatusID(Long reimbursementStatusID) {
		this.reimbursementStatusID = reimbursementStatusID;
	}

	public ImageEntity getImage() {
		return image;
	}

	public void setImage(ImageEntity image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ReimbursementEntity [reimbursementId=" + reimbursementId + ", reimbursementAmount="
				+ reimbursementAmount + ", reimbursementSubmitTime=" + reimbursementSubmitTime
				+ ", reimbursementResolvedTime=" + reimbursementResolvedTime + ", reimbursementDescription="
				+ reimbursementDescription + ", reimbursementApplicantID=" + reimbursementApplicantID
				+ ", reimbursementStatusID=" + reimbursementStatusID + "]";
	}


	
}