package com.jaydip.backends.model;

import lombok.Data;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "enquiries")
@Data
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(name = "enquiry_type")
	private EnquiryType enquiryType = EnquiryType.GENERAL;

	private String subject;

	@NotBlank(message = "Message is required")
	@Column(length = 2000)
	private String message;

	@Enumerated(EnumType.STRING)
	private EnquiryStatus status = EnquiryStatus.NEW;

	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "contacted_at")
	private LocalDateTime contactedAt;

	public enum EnquiryType {
		STUDENT, EMPLOYER, PARTNER, GENERAL, COURSE
	}

	public enum EnquiryStatus {
		NEW, CONTACTED, RESOLVED, CLOSED
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public EnquiryType getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(EnquiryType enquiryType) {
		this.enquiryType = enquiryType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EnquiryStatus getStatus() {
		return status;
	}

	public void setStatus(EnquiryStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getContactedAt() {
		return contactedAt;
	}

	public void setContactedAt(LocalDateTime contactedAt) {
		this.contactedAt = contactedAt;
	}

}