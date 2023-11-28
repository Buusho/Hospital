package Interface.impl;

import Interface.PatientInterface;
import Model.Doctor;
import Model.Hospital;
import Model.Patient;

import java.util.Arrays;

public class Patientinterfaceimpl implements PatientInterface {


    private DataBase dataBase;

    public Patientinterfaceimpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addPatient(Patient patient, int doctorId) {
        Patient[] patients;
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId() == doctorId) {
                    patients = Arrays.copyOf(doctor.getPatients(), doctor.getPatients().length + 1);
                    patients[patients.length - 1] = patient;
                    doctor.setPatients(patients);

                }
            }
            System.out.println("Patient added successfully");
        }


    }

    @Override
    public void updatePatient(String patientName, Patient patient) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Doctor d : h.getDoctors()) {
                for (Patient p : d.getPatients()) {
                    if (p.getName().equals(patientName)) {
                        p.setName(patient.getName());
                        p.setGender(patient.getGender());
                        p.setDateOfBirth(patient.getDateOfBirth());
                    }
                }
            }
        }
        System.out.println("Patient with name" + patientName +
                " is successfully updated!!!");
        }
        @Override
        public void deletePatient (String patientNAme){
        Patient [] patients;
        int counter = 0;
            for (Hospital h:dataBase.getHospitals()) {
                for (Doctor d:h.getDoctors()) {
                    for (Patient p:d.getPatients()) {
                   if(p.getName().equals(patientNAme)){
                       patients = new Patient[d.getPatients().length-1];
                       for (int i = 0; i < d.getPatients().length; i++) {
                           if(!d.getPatients()[i].getName().equals(patientNAme)){
                              patients[counter] = d.getPatients()[i];
                              counter++;
                           }
                       }
                       d.setPatients(patients);
                       System.out.println("Successfully deleted!!!");
                       break;
                   }
                    }
                }
            }
        }
        @Override
        public Patient getPatientByDoctorId ( int doctorId, String patientName){
            for (Hospital hospital :dataBase.getHospitals()) {
                for (Doctor doctor:hospital.getDoctors()) {
                    for (Patient patient:doctor.getPatients()) {
                       if(doctor.getId()==doctorId && patient.getName().equals(patientName)){
                           return patient;
                        }


                    }

                }
            }
            return null;
        }
        @Override
        public Patient[] getAllPatientByDoctorId ( int doctorId){
            for (Hospital hospital:dataBase.getHospitals()) {
                for (Doctor doctor:hospital.getDoctors()) {
                    if(doctor.getId()==doctorId){
                        return doctor.getPatients();
                    }
                }

            }
return  null;
        }
        @Override
        public Patient[] getAllPatientByHospitalId ( int hospitalId){
            for (Hospital hospital:dataBase.getHospitals()) {
                for (Doctor doctor:hospital.getDoctors()) {
                    if(hospital.getId()==hospitalId){
                        return doctor.getPatients();
                    }
                }
            }
            return  null;
        }

        @Override
        public Doctor getDoctorWithMostPatients () {
            Doctor doctor=null;
        int counter = dataBase.getHospitals()[0].getDoctors()[0].getPatients().length;
            for (int i = 0; i < dataBase.getHospitals().length; i++) {
                for (int j = 0; j < dataBase.getHospitals()[i].getDoctors().length; j++) {
                    if(counter< dataBase.getHospitals()[i].getDoctors()[j].getPatients().length){
                        counter=dataBase.getHospitals()[i].getDoctors()[j].getPatients().length;
                        doctor=dataBase.getHospitals()[i].getDoctors()[j];
                    }
                }
            }
            return doctor;
        }


        @Override
        public int getAgeDifferenceWithDoctor (String patientName,int doctorId){
int age = 0 ;
            for (Hospital hospital :   dataBase.getHospitals()) {
                for (Doctor doctor: hospital.getDoctors()
                     ) {
                    for (Patient patient : doctor.getPatients()) {
                        if(patient.getName().equals(patientName) && doctor.getId()==doctorId){
                            age= doctor.getDateOfBirth().getYear()-patient.getDateOfBirth().getDayOfMonth();

                        }
                        if (age>=0){
                            System.out.println("Возраст доктора на " + age +"больше пациента");
                        }
                        else {
                            System.out.println("Возраст пациента на " +age*-1 +"больше доктора");
                        }
                    }
                }
            }
            return age;
        }

    }
