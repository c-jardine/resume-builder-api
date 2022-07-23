package com.keplux.resume_builder_api.resume;

import com.keplux.resume_builder_api.personal_info.PersonalInfo;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resume")
public class Resume {

  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  @Getter
  @Setter
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personal_info_id")
  private PersonalInfo personalInfo;

  @Getter
  @Setter
  @OneToMany(mappedBy = "resume")
  private Set<WorkExperience> workExperience;
}
