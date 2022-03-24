package com.reimbursement.models;

import java.util.Date;

public class Reimbursement {

	private Long reimbursementID;
	private Double reimbursementAmount;
	//Date() : This constructor initializes the object with the current date and time.
	private Date reimbursementSubmitTime;
	private Date reimbursementResolvedTime;
	private String reimbursementDescription;
	private Long reimbursementApplicantID;
	private Long reimbursementStatusID;
	private Long imageId;


	public Reimbursement() {
		super();
	}


	public Reimbursement(Long reimbursementID, Double reimbursementAmount, Date reimbursementSubmitTime,
			Date reimbursementResolvedTime, String reimbursementDescription, Long reimbursementApplicantID,
			Long reimbursementStatusID, Long imageId) {
		super();
		this.reimbursementID = reimbursementID;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmitTime = reimbursementSubmitTime;
		this.reimbursementResolvedTime = reimbursementResolvedTime;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementApplicantID = reimbursementApplicantID;
		this.reimbursementStatusID = reimbursementStatusID;
		this.imageId = imageId;
	}


	public Long getReimbursementID() {
		return reimbursementID;
	}


	public void setReimbursementID(Long reimbursementID) {
		this.reimbursementID = reimbursementID;
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

	public Long getImageId() {
		return imageId;
	}


	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementSubmitTime=" + reimbursementSubmitTime + ", reimbursementResolvedTime="
				+ reimbursementResolvedTime + ", reimbursementDescription=" + reimbursementDescription
				+ ", reimbursementApplicantID=" + reimbursementApplicantID + ", reimbursementStatusID="
				+ reimbursementStatusID + ", imageId=" + imageId + "]";
	}
	
}

