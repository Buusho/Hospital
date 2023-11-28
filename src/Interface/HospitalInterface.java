package Interface;

import Model.Hospital;

public interface HospitalInterface {
    void addHospital(Hospital hospital);
    void updateHospital(String hospitalName, Hospital hospital);
    void deleteHospital(String hospitalName);
    Hospital getHospitalByName(String hospitalName);
    Hospital[] getAllHospitals();
    Hospital getHospitalWithMostDoctors();
    Hospital getHospitalWithMostPatients();
    Hospital [] getDoctorAndHospitalPatientName(String patientName);
    Hospital[] getDoctorAndHospitalDoctorId(int doctorId);
    Hospital getBusiesHospital();






}
