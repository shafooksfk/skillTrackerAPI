package com.skillTracker.profile.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "technical_skills")
public class TechnicalSkills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  public long id;

  public int htmlCssJavascript;

  public int angular;

  public int react;

  public int spring;

  public int restful;

  public int hibernate;

  public int git;

  public int docker;

  public int jenkins;

  public int aws;

  public TechnicalSkills() {}

  public TechnicalSkills(
      long id,
      int htmlCssJavascript,
      int angular,
      int react,
      int spring,
      int restful,
      int hibernate,
      int git,
      int docker,
      int jenkins,
      int aws) {
    this.id = id;
    this.htmlCssJavascript = htmlCssJavascript;
    this.angular = angular;
    this.react = react;
    this.spring = spring;
    this.restful = restful;
    this.hibernate = hibernate;
    this.git = git;
    this.docker = docker;
    this.jenkins = jenkins;
    this.aws = aws;
  }


}
