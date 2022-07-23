package com.keplux.resume_builder_api.resume;

import com.keplux.resume_builder_api.personal_info.PersonalInfo;
import com.keplux.resume_builder_api.personal_info.PersonalInfoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

  @Autowired
  private ResumeRepository resumeRepository;

  @Autowired
  private PersonalInfoRepository personalInfoRepository;

  public Resume getById(Long id) {
    return resumeRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource with id " + id + " not found."));
  }

  public List<Resume> getAll() {
    return resumeRepository.findAll();
  }

  public Resume create(Resume resume) {
    return resumeRepository.save(resume);
  }

  public Resume update(Resume newResume, Long id) {
    // Create alias for new personal info
    PersonalInfo newPersonalInfo = newResume.getPersonalInfo();

    // Find existing resume to update
    Resume existingResume = resumeRepository.findById(id).map(resume -> {

      // Create alias for existing personal info
      PersonalInfo existingPersonalInfo = resume.getPersonalInfo();

      // Update the existing personal info data
      if (existingPersonalInfo != null) {
        existingPersonalInfo.setFirstName(
            (newPersonalInfo.getFirstName() != null ? newPersonalInfo.getFirstName() : ""));
        existingPersonalInfo.setLastName(
            (newPersonalInfo.getLastName() != null ? newPersonalInfo.getLastName() : ""));
        existingPersonalInfo.setJobTitle(
            (newPersonalInfo.getJobTitle() != null ? newPersonalInfo.getJobTitle() : ""));
        existingPersonalInfo.setPhoneNumber(
            (newPersonalInfo.getPhoneNumber() != null ? newPersonalInfo.getPhoneNumber() : ""));
        existingPersonalInfo.setEmail(
            (newPersonalInfo.getEmail() != null ? newPersonalInfo.getEmail() : ""));

        // Set the resume's existing personal info data to the updated data.
        resume.setPersonalInfo(existingPersonalInfo);
      }

      return resume;
    }).orElseGet(() -> {
      // If the resume doesn't already exist, give it an id and save it to the database.
      newResume.setId(id);
      return resumeRepository.save(newResume);
    });
    return resumeRepository.save(existingResume);
  }


  public void delete(Long id) {
    resumeRepository.deleteById(id);
  }
}
