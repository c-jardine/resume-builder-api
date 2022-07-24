package com.keplux.resume_builder_api.resume;

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
public class ResumeController {

  @Autowired
  private ResumeService resumeService;

  @GetMapping("/resumes/{id}")
  public Resume getById(@PathVariable Long id) {
    return resumeService.getById(id);
  }

  @GetMapping("/resumes")
  public List<Resume> getAll() {
    return resumeService.getAll();
  }

  @PostMapping("/resumes")
  public Resume create(@RequestBody Resume resume) {
    return resumeService.create(resume);
  }

  @PutMapping("/resumes/{id}")
  public Resume update(@RequestBody Resume resume, @PathVariable Long id) {
    return resumeService.update(resume, id);
  }

  @DeleteMapping("/resumes/{id}")
  public void delete(@PathVariable Long id) {
    resumeService.delete(id);
  }
}
