package com.skillTracker.profile.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "non_technical_skills")
public class NonTechnicalSkills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;

  public int spoken;

  public int communication;

  public int aptitude;

  public NonTechnicalSkills() {
  }

  public NonTechnicalSkills(long id, int spoken, int communication, int aptitude) {
    this.id = id;
    this.spoken = spoken;
    this.communication = communication;
    this.aptitude = aptitude;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getSpoken() {
    return spoken;
  }

  public void setSpoken(int spoken) {
    this.spoken = spoken;
  }

  public int getCommunication() {
    return communication;
  }

  public void setCommunication(int communication) {
    this.communication = communication;
  }

  public int getAptitude() {
    return aptitude;
  }

  public void setAptitude(int aptitude) {
    this.aptitude = aptitude;
  }
}
