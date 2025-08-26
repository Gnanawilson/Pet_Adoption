package com.examly.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class AdoptionRequest {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull(message = "Pet ID is required")
private Long petId;

@NotBlank(message = "Applicant name is required")
@Size(min = 2, message = "Applicant name must be at least 2 characters")
private String applicantName;

@NotBlank(message = "Email is required")
@Email(message = "Email format is invalid")
private String applicantEmail;

@NotBlank(message = "Phone number is required")
private String applicantPhone;

private String status;
private LocalDateTime submissionDate;

public Long getId() {
  return id;
}
public void setId(Long id) {
  this.id = id;
}
public Long getPetId() {
  return petId;
}
public void setPetId(Long petId) {
  this.petId = petId;
}
public String getApplicantName() {
  return applicantName;
}
public void setApplicantName(String applicantName) {
  this.applicantName = applicantName;
}
public String getApplicantEmail() {
  return applicantEmail;
}
public void setApplicantEmail(String applicantEmail) {
  this.applicantEmail = applicantEmail;
}
public String getApplicantPhone() {
  return applicantPhone;
}
public void setApplicantPhone(String applicantPhone) {
  this.applicantPhone = applicantPhone;
}
public String getStatus() {
  return status;
}
public void setStatus(String status) {
  this.status = status;
}
public LocalDateTime getSubmissionDate() {
  return submissionDate;
}
public void setSubmissionDate(LocalDateTime submissionDate) {
  this.submissionDate = submissionDate;
}
public AdoptionRequest() {
}


}

