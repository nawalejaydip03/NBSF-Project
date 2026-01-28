package com.jaydip.backends.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "courses")

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	private String sector; // IT, Healthcare, Retail, etc.

	@Column(nullable = false)
	private String duration;

	@Column(columnDefinition = "TEXT")
	private String eligibility;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String syllabus;

	private BigDecimal fee;

	@Column(name = "government_subsidy")
	private BigDecimal governmentSubsidy;

	private String certification;

	@Column(name = "placement_assistance")
	private Boolean placementAssistance = true;

	@Column(name = "batch_size")
	private Integer batchSize;

	private Boolean active = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getGovernmentSubsidy() {
		return governmentSubsidy;
	}

	public void setGovernmentSubsidy(BigDecimal governmentSubsidy) {
		this.governmentSubsidy = governmentSubsidy;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public Boolean getPlacementAssistance() {
		return placementAssistance;
	}

	public void setPlacementAssistance(Boolean placementAssistance) {
		this.placementAssistance = placementAssistance;
	}

	public Integer getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(Integer batchSize) {
		this.batchSize = batchSize;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public java.time.LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.time.LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_at")
	private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now();
}