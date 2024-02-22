package com.hms.registration;

import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import org.springframework.web.multipart.MultipartFile;

@MappedSuperclass
public class UserModel {
    @Id
    private String name;
    private String username;
    private String email;
    private String password;
    private String phonenumber;
    private String address;
    private String medicalhistory;
    private String identifier;
    private String bloodgroup;
    private String specialization;



    public String getSpecialization() {
        return specialization;
    }

    public String getName() {

        return name;
    }

    public String getUsername() {

        return username;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }

    public String getPhonenumber() {

        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMedicalhistory(String medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", medicalhistory='" + medicalhistory + '\'' +
                ", identifier='" + identifier + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
