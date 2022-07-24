package com.keplux.resume_builder_api.personal_info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {

}
