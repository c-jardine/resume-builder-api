package com.keplux.resume_builder_api.personal_info;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PersonalInfoController {

  @Autowired
  private PersonalInfoService personalInfoService;

  @GetMapping("/personal-info/{id}")
  public PersonalInfo getById(@PathVariable Long id) {
    return personalInfoService.getById(id);
  }

  @GetMapping("/personal-info")
  public List<PersonalInfo> getAll() {
    return personalInfoService.getAll();
  }

  @PostMapping("/personal-info")
  public PersonalInfo create(@RequestBody PersonalInfo personalInfo) {
    return personalInfoService.create(personalInfo);
  }

  @PutMapping("/personal-info/{id}")
  public PersonalInfo update(@RequestBody PersonalInfo personalInfo, @PathVariable Long id) {
    return personalInfoService.update(personalInfo, id);
  }

  @DeleteMapping("/personal-info/{id}")
  public void delete(@PathVariable Long id) {
    personalInfoService.delete(id);
  }
}
