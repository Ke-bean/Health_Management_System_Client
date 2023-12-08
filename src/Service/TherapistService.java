/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Therapist;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Kebean
 */
public interface TherapistService extends Remote{
    Therapist registerTherapist(Therapist therapist) throws RemoteException;
    Therapist updateTherapist(Therapist therapist) throws RemoteException;
    Therapist deleteTherapist(Therapist therapist) throws RemoteException;
    Therapist searchTherapist(Therapist therapist) throws RemoteException;
    List<Therapist> allTherapist() throws RemoteException;
}
