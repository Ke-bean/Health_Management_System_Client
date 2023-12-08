/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Kebean
 */
public class Therapist implements Serializable{
    private Integer therapistId;
    private String therapistNames;
    private String specialisation;
    private String Contact;
    private Diagnosis diagnosis;
    private Set<Patient> patients = new HashSet<>();

    public Therapist() {
    }

    public Therapist(Integer therapistId) {
        this.therapistId = therapistId;
    }

    public Therapist(Integer therapistId, String therapistNames, String specialisation, String Contact, Diagnosis diagnosis) {
        this.therapistId = therapistId;
        this.therapistNames = therapistNames;
        this.specialisation = specialisation;
        this.Contact = Contact;
        this.diagnosis = diagnosis;
    }

    public Integer getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Integer therapistId) {
        this.therapistId = therapistId;
    }

    public String getTherapistNames() {
        return therapistNames;
    }

    public void setTherapistNames(String therapistNames) {
        this.therapistNames = therapistNames;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
    
}
