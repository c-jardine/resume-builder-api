package com.keplux.resume_builder_api.personal_info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.keplux.resume_builder_api.resume.Resume;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personal_info")
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;

  @Column(name = "first_name")
  @Getter
  @Setter
  private String firstName;

  @Column(name = "last_name")
  @Getter
  @Setter
  private String lastName;

  @Column(name = "job_title")
  @Getter
  @Setter
  private String jobTitle;

  @Column(name = "phone_number")
  @Getter
  @Setter
  private String phoneNumber;

  @Column(name = "email")
  @Getter
  @Setter
  private String email;

  @Getter
  @Setter
  @OneToOne(mappedBy = "personalInfo")
  @JsonIgnore
  private Resume resume;
}
