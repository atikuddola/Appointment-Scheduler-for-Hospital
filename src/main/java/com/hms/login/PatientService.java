package com.hms.login;

import com.hms.registration.DoctorModel;
import com.hms.registration.PatientModel;
import com.hms.registration.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PatientService {
    private static PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo){

        this.patientRepo = patientRepo;
    }

    public static PatientModel findByUsername(String username) {

        return patientRepo.findByUsername(username);
    }

    public PatientModel findByPassword(String password){

        return patientRepo.findByPassword(password);
    }

}
