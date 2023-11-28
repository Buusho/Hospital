package Interface;

import Model.Doctor;

public interface DoctorInterface {
    void addDoctor(Doctor doctor, int hospitalId);
    void updateDoctor(String doctorName,Doctor doctor);
    void deleteDoctor(String doctorName);
    Doctor getDoctorByName(String doctorName);
    Doctor[] getAllDoctorByHospitalId(int hospitalId);
    Doctor[] getAllDoctors();
    Doctor getOldestDoctor();
    Doctor getYoungestDoctor();
    double getAverageAgeOfPatientOfDoctor(int doctorId);
    double getAverageAgeOfDoctorOfHospital(int hospitalId);

}
