package com.hms.registration;

import com.hms.registration.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository <DoctorModel, String> {
    boolean existsByName(String name);
    DoctorModel findByUsername(String username);
    DoctorModel findByPassword(String password);

}
