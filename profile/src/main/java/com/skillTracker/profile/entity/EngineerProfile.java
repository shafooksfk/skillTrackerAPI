package com.skillTracker.profile.entity;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "engineer_profile")
public class EngineerProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long id;

  @NotBlank(message = "Name is mandatory")
  @Size(min = 5, max = 30)
  @Column(name = "name")
  public String name;

  @NotBlank(message = "Associate id is mandatory")
  @Size(min = 5, max = 30)
  @Pattern(regexp = "^CTS[0-9]{1,29}$")
  @Column(name = "associate_id")
  public String associateId;

  @NotBlank(message = "Email is mandatory")
  @Email
  @Column(name = "email")
  public String email;

  @NotNull
  @Pattern(regexp = "^[0-9]{10}$")
  public String phoneNumber;

  public Date createdDate;

  public Date modifiedDate;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "technical_skills", referencedColumnName = "id")
  public TechnicalSkills technicalSkills;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "non_technical_skills", referencedColumnName = "id")
  public NonTechnicalSkills nonTechnicalSkills;

  public EngineerProfile() {}

  public EngineerProfile(
      long id,
      String name,
      String associateId,
      String email,
      String phoneNumber,
      Date createdDate,
      Date modifiedDate,
      TechnicalSkills technicalSkills,
      NonTechnicalSkills nonTechnicalSkills) {
    this.id = id;
    this.name = name;
    this.associateId = associateId;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
    this.technicalSkills = technicalSkills;
    this.nonTechnicalSkills = nonTechnicalSkills;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAssociateId() {
    return associateId;
  }

  public void setAssociateId(String associateId) {
    this.associateId = associateId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public TechnicalSkills getTechnicalSkills() {
    return technicalSkills;
  }

  public void setTechnicalSkills(TechnicalSkills technicalSkills) {
    this.technicalSkills = technicalSkills;
  }

  public NonTechnicalSkills getNonTechnicalSkills() {
    return nonTechnicalSkills;
  }

  public void setNonTechnicalSkills(NonTechnicalSkills nonTechnicalSkills) {
    this.nonTechnicalSkills = nonTechnicalSkills;
  }
}
