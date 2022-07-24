package com.keplux.resume_builder_api.user;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource with id " + id + " not found."));
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User create(User user) {
    return userRepository.save(user);
  }

  public User update(User newUser, Long id) {
    return userRepository.findById(id)
        .map(user -> {
          user.setFirstName(newUser.getFirstName());
          user.setLastName(newUser.getLastName());
          user.setEmail(newUser.getEmail());
          return userRepository.save(user);
        })
        .orElseGet(() -> {
          newUser.setId(id);
          return userRepository.save(newUser);
        });
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
