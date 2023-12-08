/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Diagnosis;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Kebean
 */
public interface DiagnosisService {
    Diagnosis registerDiagnosis(Diagnosis diagnosis) throws RemoteException;
    Diagnosis updateDiagnosis(Diagnosis diagnosis) throws RemoteException;
    Diagnosis deleteDiagnosis(Diagnosis diagnosis) throws RemoteException;
    Diagnosis searchDiagnosis(Diagnosis diagnosis) throws RemoteException;
    List<Diagnosis> allDiagnosis() throws RemoteException;
}
