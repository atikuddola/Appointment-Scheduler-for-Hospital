package com.hms.patientdashboard;


import com.hms.registration.DoctorModel;
import com.hms.registration.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private patientdashboardrepo dn;

    @Autowired
    private DoctorRepo doctorRepository;

    public List<patientdashboardmodel> getTodaysAppointments(String loggedInDoctorUsername) {
        DoctorModel doctor = doctorRepository.findByUsername(loggedInDoctorUsername);

        if (doctor != null) {
            String doctorName = doctor.getName();
            String today = LocalDate.now().toString();

            System.out.println("Doctor Name: " + doctorName);
            System.out.println("Today's Date: " + today);

            List<patientdashboardmodel> appointments = dn.findByDoctorNameAndChosenDate(doctorName, today);

            System.out.println("Appointments: " + appointments);

            return appointments;
        }

        return Collections.emptyList(); // Handle case where doctor is not found
    }
}
