package com.hms.login;

import java.util.List;
import com.hms.registration.DoctorModel;
import com.hms.registration.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private static DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo){

        this.doctorRepo = doctorRepo;
    }

    public static DoctorModel findByUsername(String username){
        return doctorRepo.findByUsername(username);
    }

    public DoctorModel findByPassword(String password){
        return doctorRepo.findByPassword(password);
    }

    public List<DoctorModel> getAllDoctors() {
        return doctorRepo.findAll();
    }
}

