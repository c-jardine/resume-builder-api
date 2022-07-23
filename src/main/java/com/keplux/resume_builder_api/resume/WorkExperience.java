package com.keplux.resume_builder_api.resume;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keplux.resume_builder_api.resume.Resume;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "work_experience")
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Setter
  @Column(name = "job_title")
  private String jobTitle;

  @Getter
  @Setter
  @Column(name = "company")
  private String company;

  @Getter
  @Setter
  @Column(name = "description")
  private String description;

  @Getter
  @Setter
  @Column(name = "current_employer")
  private Boolean currentEmployer;

  @Getter
  @Setter
  @Column(name = "from_date")
  private Date fromDate;

  @Getter
  @Setter
  @Column(name = "to_date")
  private Date toDate;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "resume_id", nullable = false)
  @JsonIgnore
  private Resume resume;
}
