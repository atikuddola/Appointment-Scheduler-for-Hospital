package com.hms.patientdashboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table (name = "appointment")
public class patientdashboardmodel {
    @Id
    private String patientName;
    private String doctorName;
    private String departmentName;
    private String phoneNumber;
    private String symptoms;
    private String chosenDate;
    private int treatment = 0;

    private String medicine;
    private int days;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getChosenDate() {
        return chosenDate;
    }

    public void setChosenDate(String chosendate) {
        this.chosenDate = chosendate;
    }

    public int getTreatment() {
        return treatment;
    }

    public void setTreatment(int treatment) {
        this.treatment = treatment;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "patientdashboardmodel{" +
                "patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", chosenDate='" + chosenDate + '\'' +
                ", treatment=" + treatment +
                ", medicine='" + medicine + '\'' +
                ", days=" + days +
                '}';
    }
}
