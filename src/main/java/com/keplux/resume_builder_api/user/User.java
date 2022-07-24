package com.keplux.resume_builder_api.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  @Column(name = "first_name")
  private String firstName;

  @Getter
  @Setter
  @Column(name = "last_name")
  private String lastName;

  @Getter
  @Setter
  @Column(name = "email")
  private String email;

  @Getter
  @Setter
  @Column(name = "password")
  private String password;
}
