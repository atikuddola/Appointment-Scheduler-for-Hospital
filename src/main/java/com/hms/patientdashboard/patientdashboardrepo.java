package com.hms.patientdashboard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface patientdashboardrepo extends JpaRepository<patientdashboardmodel, String> {
    List<patientdashboardmodel> findByDoctorNameAndChosenDate(String doctorName, String chosenDate);
}
