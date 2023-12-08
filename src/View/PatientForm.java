/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Diagnosis;
import Service.PatientService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Model.Patient;
import Service.DiagnosisService;
import Service.TherapistService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Model.Therapist;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kebean
 */
public class PatientForm extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public PatientForm() {
        initComponents();
        fillDiagCombo();
        fillDoctorCombo();
        addColumn();
        displayPatientInfo();
    }
  private void fillDiagCombo(){
        try{
         Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            DiagnosisService service = (DiagnosisService)registry.lookup("diagnosis");
         List<Diagnosis> diagnosies = service.allDiagnosis();
         for (Diagnosis diag: diagnosies){
             diagCombo.addItem(diag);
         }
        }catch(Exception ex){
            ex.printStackTrace();
        }
  }
    private void fillDoctorCombo(){
        try{
         Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            TherapistService service = (TherapistService)registry.lookup("therapy");
         List<Therapist> therapists = service.allTherapist();
         for (Therapist therap: therapists){
             doctorCombo.addItem(therap);
         }
        }catch(Exception ex){
            ex.printStackTrace();
        }
  }
    DefaultTableModel model = new DefaultTableModel();
        public void addColumn(){
            model.addColumn("Patient ID");
            model.addColumn("Patient Names");
            model.addColumn("Date of Birth");
            model.addColumn("gender");
            model.addColumn("phone");
            model.addColumn("Doctor");
            model.addColumn("Disease");
            PatientTable.setModel(model);
        }
                public void displayPatientInfo(){
            model.setRowCount(0);
            try{
                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
                PatientService service = (PatientService)registry.lookup("patient");
                
                 List<Patient> patients = service.allPatient();
            if(patients != null){
                for (Patient patient: patients){
                    model.addRow(new Object []{
                       patient.getPatientId(),
                       patient.getNames(),
                       patient.getDiagnosis(),
                       patient.getDateOfBirth(),
                       patient.getGender(),
                       patient.getPhone(),
                       patient.getTherapists()
                    });
                }
            }
            }catch(Exception ex){
                ex.printStackTrace();
            }
       

        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        namesTxt = new javax.swing.JTextField();
        birthTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        gendercombo = new javax.swing.JComboBox<>();
        registerBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        diagCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        doctorCombo = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PatientTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Patient Registration Form");

        jLabel2.setText("Patient id: ");

        jLabel3.setText("Names");

        jLabel4.setText("Date of Birth: ");

        jLabel5.setText("Patient Id: ");

        jLabel6.setText("Phone Number: ");

        idTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTxtActionPerformed(evt);
            }
        });

        gendercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Diagnosis");

        jLabel8.setText("Doctor");

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        PatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(PatientTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(15, 15, 15)
                                .addComponent(doctorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addComponent(diagCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel3)
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idTxt)
                                        .addComponent(namesTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(birthTxt))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(gendercombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(phoneTxt)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerBtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(updateBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(birthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(gendercombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diagCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(doctorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn)
                    .addComponent(deleteBtn)
                    .addComponent(updateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTxtActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(namesTxt.getText().trim().isEmpty() || idTxt.getText().trim().isEmpty()
                    || phoneTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "All fields are Mandatory", "Error: Empty fields", JOptionPane.WARNING_MESSAGE);
            }else {
                // I've tried to use what is on top of my head, not sure if it's gonna workout as expected.
                 String emailPattern = "^[+250]+([0-9-]+)$";
                 Pattern pattern = Pattern.compile(emailPattern);
                 Matcher result = pattern.matcher(phoneTxt.getText().trim());

        if (!result.matches()) {
            JOptionPane.showMessageDialog(this, "Invalid email address", "Error: Invalid Email", JOptionPane.WARNING_MESSAGE);
        }else{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            PatientService service = (PatientService)registry.lookup("patient");
            Patient patient = new Patient();
            patient.setNames(namesTxt.getText());
            patient.setPatientId(Integer.parseInt(idTxt.getText()));
            patient.setPhone(phoneTxt.getText());
            patient.setGender((String)gendercombo.getSelectedItem());
            String date = birthTxt.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            patient.setDateOfBirth(sqlDate);
            Diagnosis diagnosis = (Diagnosis)diagCombo.getSelectedItem();
            Therapist therapist = (Therapist)doctorCombo.getSelectedItem();
            patient.setDiagnosis(diagnosis);
            patient.setTherapists((Set<Therapist>) therapist);
            Patient patientObj = service.registerPatient(patient);
            if(patientObj != null){
                JOptionPane.showMessageDialog(this, "Patient Registered Successfully");
            }else{
                JOptionPane.showMessageDialog(this, "Fatal Error: Patient Registration failed");
            }
        }
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(namesTxt.getText().trim().isEmpty() || idTxt.getText().trim().isEmpty()
                    || phoneTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "All fields are Mandatory", "Error: Empty fields", JOptionPane.WARNING_MESSAGE);
            }else {
                // I've tried to use what is on top of my head, not sure if it's gonna workout as expected.
                 String emailPattern = "^[+250]+([0-9-]+)$";
                 Pattern pattern = Pattern.compile(emailPattern);
                 Matcher result = pattern.matcher(phoneTxt.getText().trim());

        if (!result.matches()) {
            JOptionPane.showMessageDialog(this, "Invalid email address", "Error: Invalid Email", JOptionPane.WARNING_MESSAGE);
        }else{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            PatientService service = (PatientService)registry.lookup("patient");
            Patient patient = new Patient();
            patient.setNames(namesTxt.getText());
            patient.setPatientId(Integer.parseInt(idTxt.getText()));
            patient.setPhone(phoneTxt.getText());
            patient.setGender((String)gendercombo.getSelectedItem());
            String date = birthTxt.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            patient.setDateOfBirth(sqlDate);
            Diagnosis diagnosis = (Diagnosis)diagCombo.getSelectedItem();
            Therapist therapist = (Therapist)doctorCombo.getSelectedItem();
            patient.setDiagnosis(diagnosis);
            patient.setTherapists((Set<Therapist>) therapist);
            Patient patientObj = service.updatePatient(patient);
            if(patientObj != null){
                JOptionPane.showMessageDialog(this, "Patient updated Successfully");
            }else{
                JOptionPane.showMessageDialog(this, "Fatal Error: Patient updatation failed");
            }
        }
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(namesTxt.getText().trim().isEmpty() || idTxt.getText().trim().isEmpty()
                    || phoneTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "All fields are Mandatory", "Error: Empty fields", JOptionPane.WARNING_MESSAGE);
            }else {
                // I've tried to use what is on top of my head, not sure if it's gonna workout as expected.
                 String emailPattern = "^[+250]+([0-9-]+)$";
                 Pattern pattern = Pattern.compile(emailPattern);
                 Matcher result = pattern.matcher(phoneTxt.getText().trim());

        if (!result.matches()) {
            JOptionPane.showMessageDialog(this, "Invalid email address", "Error: Invalid Email", JOptionPane.WARNING_MESSAGE);
        }else{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            PatientService service = (PatientService)registry.lookup("patient");
            Patient patient = new Patient();
            patient.setNames(namesTxt.getText());
            patient.setPatientId(Integer.parseInt(idTxt.getText()));
            patient.setPhone(phoneTxt.getText());
            patient.setGender((String)gendercombo.getSelectedItem());
            String date = birthTxt.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            patient.setDateOfBirth(sqlDate);
            Diagnosis diagnosis = (Diagnosis)diagCombo.getSelectedItem();
            Therapist therapist = (Therapist)doctorCombo.getSelectedItem();
            patient.setDiagnosis(diagnosis);
            patient.setTherapists((Set<Therapist>) therapist);
            Patient patientObj = service.deletePatient(patient);
            if(patientObj != null){
                JOptionPane.showMessageDialog(this, "Patient deleted Successfully");
            }else{
                JOptionPane.showMessageDialog(this, "Fatal Error: Patient deletion failed");
            }
        }
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PatientTable;
    private javax.swing.JTextField birthTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<Diagnosis> diagCombo;
    private javax.swing.JComboBox<Therapist> doctorCombo;
    private javax.swing.JComboBox<String> gendercombo;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namesTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
