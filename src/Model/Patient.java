/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Kebean
 */
public class Patient implements Serializable{
    private Integer patientId;
    private String names;
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private Set<Therapist> therapists;
    private Diagnosis diagnosis;

    public Patient() {
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Patient(Integer patientId, String names, Date dateOfBirth, String gender, String phone, Set<Therapist> therapists, Diagnosis diagnosis) {
        this.patientId = patientId;
        this.names = names;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.therapists = therapists;
        this.diagnosis = diagnosis;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Therapist> getTherapists() {
        return therapists;
    }

    public void setTherapists(Set<Therapist> therapists) {
        this.therapists = therapists;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
    
}
