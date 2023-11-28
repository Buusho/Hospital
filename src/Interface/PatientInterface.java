package Interface;

import Model.Doctor;
import Model.Patient;

public interface PatientInterface {
    void addPatient(Patient patient , int doctorId);
    void  updatePatient(String patientName, Patient patient);
    void  deletePatient(String patientNAme);
//    void  searchPatient(String patientName);
   Patient  getPatientByDoctorId(int doctorId,String patientName);
   Patient[] getAllPatientByDoctorId(int doctorId);
   Patient[] getAllPatientByHospitalId(int hospitalId);
    Doctor getDoctorWithMostPatients();

    int getAgeDifferenceWithDoctor(String patientName,int doctorId);


}
