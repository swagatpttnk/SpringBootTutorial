package com.boot.poc.service;

import com.boot.poc.excepions.PatientNotFoundException;
import com.boot.poc.models.Doctor;
import com.boot.poc.models.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class HospitalDaoService {
    private static int patientsCount=3;
    private static List<Patient> patients=new ArrayList<Patient>();
    private static List<Doctor> doctors=new ArrayList<Doctor>();
    static {
        patients.add(new Patient(101,"Patient1", new Date(),"Sickness1","O+"));
        patients.add(new Patient(102,"Patient2", new Date(),"Sickness2","O-"));
        patients.add(new Patient(103,"Patient3", new Date(),"Sickness2","O+"));
        doctors.add(new Doctor(121,"Doctor1",new Date(),"Orthopedic"));
        doctors.add(new Doctor(121,"Doctor2",new Date(),"Pediatric"));
        doctors.add(new Doctor(121,"Doctor3",new Date(),"Nephrologist"));
    }


    public Patient save(Patient patient){
        patient.setId(++patientsCount);
        patients.add(patient);
        return patient;
    }
    public Patient findOne(int id){
        for(Patient patient:patients){
            if(id==patient.getId())
                return patient;
        }
        return null;
    }
    public List<Patient> findAll() throws PatientNotFoundException {
        if(patients==null || patients.isEmpty()){
            throw new PatientNotFoundException("No Patients exist");
        }
        return patients;
    }
    public Patient delete(int id){
        Iterator<Patient> iterator=patients.iterator();
        while(iterator.hasNext()){
            Patient patient=iterator.next();
            if(id==patient.getId()){
                iterator.remove();
                return patient;
            }
        }
        return null;
    }

    public Patient update(int id,Patient patient) {
        Patient updatedPatient=null;
        for(Patient temppatient:patients){
            if(id==temppatient.getId()) {
                temppatient.setName(patient.getName());
                temppatient.setBirthDate(patient.getBirthDate());
                temppatient.setSickness(patient.getSickness());
                temppatient.setBloodGroup(patient.getBloodGroup());
                updatedPatient= patient;
            }
        }
        return updatedPatient;
    }
    /**/
    public List<Doctor> findAllDoctors() {
        if(doctors==null || doctors.isEmpty()){
            //throw new PatientNotFoundException("No Patients exist");
        }
        return doctors;
    }
}