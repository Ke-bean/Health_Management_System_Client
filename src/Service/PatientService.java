/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Patient;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Kebean
 */
public interface PatientService {
    Patient registerPatient(Patient patient) throws RemoteException;
    Patient updatePatient(Patient patient) throws RemoteException;
    Patient deletePatient(Patient patient) throws RemoteException;
    Patient searchPatient(Patient patient) throws RemoteException;
    List<Patient> allPatient() throws RemoteException;
}
