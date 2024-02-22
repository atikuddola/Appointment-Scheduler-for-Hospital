package com.hms;

import java.util.List;
import com.hms.login.DoctorService;
import com.hms.login.PatientService;
import com.hms.login.UserLogin;
import com.hms.patientdashboard.AppointmentService;
import com.hms.patientdashboard.patientdashboardmodel;
import com.hms.patientdashboard.patientdashboardrepo;
import com.hms.registration.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.hms.servicebooking.servicemodel;
import com.hms.servicebooking.servicerepo;



@Controller
public class MainController {

    @Autowired
    private AppointmentService appointmentservice;

    @GetMapping(value = {"/", "/home"})
    public String showHomePage() {

        return "index";
    }

    @GetMapping(value = {"/login"})
    public String showLoginPage() {

        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {

        return "registration";
    }

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public String showDoctorslist(Model model) {
        List<DoctorModel> doctors = doctorService.getAllDoctors();
        System.out.println("Doctors: " + doctors);
        model.addAttribute("doctors", doctors);
        return "doctors";

    }

    @GetMapping("services")
    public String showServices(Model model2) {
        List<DoctorModel> doctors = doctorService.getAllDoctors();
        model2.addAttribute("doctors", doctors);

        return "services";
    }


    @Autowired
    private PatientRepo pRepo;

    @Autowired
    private DoctorRepo dRepo;

    @PostMapping("/register2")
    public String userRegistrated(@ModelAttribute UserModel user, HttpSession session) {

        if (pRepo.existsByName(user.getName()) || dRepo.existsByName(user.getName())) {
            System.out.println("User Already Registered: " + user.getName());
            session.setAttribute("text", "User Already Registered. Please Login.");

        } else {
            System.out.println("User Registered Successfully: " + user.getName());
            System.out.println(user.toString());

            String x = user.getIdentifier();

            if ("patient".equals(x)) {
                PatientModel patient = new PatientModel();
                patient.setName(user.getName());
                patient.setUsername(user.getUsername());
                patient.setEmail(user.getEmail());
                patient.setPassword(user.getPassword());
                patient.setPhonenumber(user.getPhonenumber());
                patient.setAddress(user.getAddress());
                patient.setMedicalhistory(user.getMedicalhistory());
                patient.setIdentifier(user.getIdentifier());
                patient.setBloodgroup(user.getBloodgroup());
                pRepo.save(patient);
                System.out.println("Patient");

            } else if ("doctor".equals(x)) {
                DoctorModel doctor = new DoctorModel();
                doctor.setName(user.getName());
                doctor.setUsername(user.getUsername());
                doctor.setEmail(user.getEmail());
                doctor.setPassword(user.getPassword());
                doctor.setPhonenumber(user.getPhonenumber());
                doctor.setAddress(user.getAddress());
                doctor.setMedicalhistory(user.getMedicalhistory());
                doctor.setIdentifier(user.getIdentifier());
                doctor.setBloodgroup(user.getBloodgroup());
                doctor.setSpecialization(user.getSpecialization());

                dRepo.save(doctor);
                System.out.println("Doctor");
            }

            session.setAttribute("text", "User Registered Successfully");
            return "login";
        }

        return "registration";
    }



    @PostMapping("/dashboard")
    public String userLoggedIn(@ModelAttribute UserLogin user2, Model model2, HttpSession session) {
        System.out.println(user2.toString());

        String username = user2.getUsername();
        String password = user2.getPassword();
        String identifier = user2.getIdentifier();

        if ("patient".equals(identifier)) {

            PatientModel patient = PatientService.findByUsername(username);

            if (patient != null && patient.getPassword().equals(password)) {

                System.out.println(patient.getPassword());
                System.out.println("successfully logged in");

//
                List<DoctorModel> doctors = doctorService.getAllDoctors();
                model2.addAttribute("doctors", doctors);


                return "patientdashboard";

            } else if ("".equals(username) || "".equals(password)) {
                session.setAttribute("logintext", "Fill Out the Information Please");
                return "login";

            } else {
                session.setAttribute("logintext", "Username or Password Is Invalid");
                return "login";

            }

        } else {
            DoctorModel doctor = DoctorService.findByUsername(username);

            if (doctor != null && doctor.getPassword().equals(password)) {

                List<patientdashboardmodel> appointments = appointmentservice.getTodaysAppointments(username);
                model2.addAttribute("appointments", appointments);

                System.out.println(appointments);
                System.out.println("successfully logged in");
                return "doctordashboard";

            } else if ("".equals(username) || "".equals(password)) {
                session.setAttribute("logintext", "Fill Out the Information Please");
                return "login";

            } else {
                session.setAttribute("logintext", "Username or Password Is Invalid");
                return "login";

            }
        }
    }



    @Autowired
    private patientdashboardrepo appoint;

    @PostMapping("/appointment")
    public String appoinmentRegister(@ModelAttribute patientdashboardmodel user3, Model model3, HttpSession session) {

        List<DoctorModel> doctors = doctorService.getAllDoctors();
        model3.addAttribute("doctors", doctors);

        if ("".equals(user3.getPatientName()) || "".equals(user3.getSymptoms()) || "".equals(user3.getPhoneNumber()) || "".equals(user3.getChosenDate())) {

            session.setAttribute("apoointmenttext", "Fill Out the Information Please");

        }else{
            patientdashboardmodel ap1 = new patientdashboardmodel();
            ap1.setPatientName(user3.getPatientName());
            ap1.setDoctorName(user3.getDoctorName());
            ap1.setDepartmentName(user3.getDepartmentName());
            ap1.setPhoneNumber(user3.getPhoneNumber());
            ap1.setSymptoms(user3.getSymptoms());
            ap1.setChosenDate(user3.getChosenDate());

            appoint.save(ap1);
            System.out.println("Appointment");
            System.out.println(user3.toString());

        }
        return "patientdashboard";

    }

    @GetMapping("/bookservice")
    public String serviceBooking(){

        return "servicebooking";

    }




    @Autowired
    private servicerepo serviceUser;

    @PostMapping("/servicebook")
    public String bookingConfirm(@ModelAttribute servicemodel user4, HttpSession session){
        System.out.println("Mapping Working");
        servicemodel staker = new servicemodel();
        staker.setPatientName(user4.getPatientName());
        staker.setDoctorName(user4.getDoctorName());
        staker.setService(user4.getService());
        staker.setPhoneNumber(user4.getPhoneNumber());
        staker.setPaymentMethod(user4.getPaymentMethod());
        serviceUser.save(staker);
        System.out.println(user4.toString());

        return "servicebooking";
    }

    @Autowired
    private patientdashboardrepo prescription;

    @PostMapping("/prescribe")
    public String prescribedMedicine(@ModelAttribute patientdashboardmodel user5, HttpSession session){
        patientdashboardmodel med = new patientdashboardmodel();
        med.setPatientName(user5.getPatientName());
        med.setMedicine(user5.getMedicine());
        med.setDays(user5.getDays());
        med.setTreatment(1);
        prescription.save(med);
        System.out.println(user5.toString());
        return "index";

    }




}
