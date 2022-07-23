package com.keplux.resume_builder_api.personal_info;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoService {

  @Autowired
  private PersonalInfoRepository personalInfoRepository;

  public PersonalInfo getById(Long id) {
    return personalInfoRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource with id " + id + " not found."));
  }

  public List<PersonalInfo> getAll() {
    return personalInfoRepository.findAll();
  }

  public PersonalInfo create(PersonalInfo personalInfo) {
    return personalInfoRepository.save(personalInfo);
  }

  public PersonalInfo update(PersonalInfo newPersonalInfo, Long id) {
    return personalInfoRepository.findById(id)
        .map(personalInfo -> {
          personalInfo.setFirstName(newPersonalInfo.getFirstName());
          personalInfo.setLastName(newPersonalInfo.getLastName());
          personalInfo.setJobTitle(newPersonalInfo.getJobTitle());
          personalInfo.setPhoneNumber(newPersonalInfo.getPhoneNumber());
          personalInfo.setEmail(newPersonalInfo.getEmail());
          return personalInfoRepository.save(personalInfo);
        })
        .orElseGet(() -> {
          newPersonalInfo.setId(id);
          return personalInfoRepository.save(newPersonalInfo);
        });
  }

  public void delete(Long id) {
    personalInfoRepository.deleteById(id);
  }
}
