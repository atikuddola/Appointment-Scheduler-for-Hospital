package com.hms.registration;

import com.hms.registration.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository <PatientModel, String>{
    boolean existsByName(String name);

    PatientModel findByUsername(String username);
    PatientModel findByPassword(String password);
}

