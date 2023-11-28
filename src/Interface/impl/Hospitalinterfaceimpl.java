package Interface.impl;

import Interface.HospitalInterface;
import Model.Doctor;
import Model.Hospital;
import Model.Patient;

import java.time.LocalDate;
import java.util.Arrays;

public class Hospitalinterfaceimpl implements HospitalInterface {
    private DataBase dataBase;

    public Hospitalinterfaceimpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addHospital(Hospital hospital) {
       Hospital [] hospitals;
       hospitals= Arrays.copyOf(dataBase.getHospitals(),dataBase.getHospitals().length +1);
       hospitals[hospitals.length-1]=hospital;
       dataBase.setHospitals(hospitals);


    }

    @Override
    public void updateHospital(String hospitalName, Hospital hospital) {
        for (Hospital h:dataBase.getHospitals()) {
            if(h.getName().equals(hospitalName)){
                h.setAddress("Abdyrahmanova 32");
                h.setDoctors( new Doctor[]{new Doctor("Aidai","famle", LocalDate.of(2000,3,17),new Patient[]{new Patient("Adyl","man",LocalDate.of(2005,2,17))})});
                h.setName("Health");
            }
        }
    }
    @Override
    public void deleteHospital(String hospitalName) {
Hospital [] hospitals = Arrays.copyOf(dataBase.getHospitals(),dataBase.getHospitals().length-1);
int counter =0;
        for (Hospital h:dataBase.getHospitals()) {
            if(h.getName().equals(hospitalName)){
                hospitals[counter]=h;
                counter++;
            }
        }
        hospitals=Arrays.copyOf(hospitals,counter);
        dataBase.setHospitals(hospitals);
//        System.out.println(Arrays.toString(hospitals));
    }
    @Override
    public Hospital getHospitalByName(String hospitalName) {
        for (Hospital h:dataBase.getHospitals()) {
            if(h.getName().equals(hospitalName)){
                System.out.println(h);
            }
        }

        return null;
    }
    @Override
    public Hospital[] getAllHospitals() {
       Hospital [] hospitals = new Hospital[1000];
       int counter=0;
        for (Hospital h:dataBase.getHospitals()) {
                hospitals[counter]=h;
                counter++;
            }

hospitals=Arrays.copyOf(hospitals,counter);
        return hospitals;

    }
    @Override
    public Hospital getHospitalWithMostDoctors() {
        Hospital hospital=null;
        int counter = dataBase.getHospitals()[0].getDoctors().length;
        for (int i = 0; i < dataBase.getHospitals().length; i++) {
                if(counter<dataBase.getHospitals()[i].getDoctors().length){
                    counter=dataBase.getHospitals()[i].getDoctors().length;
                    hospital=dataBase.getHospitals()[i];

                }
        }
        return hospital;
    }

    @Override
    public Hospital getHospitalWithMostPatients() {
        Hospital hospital = null;
        int counter = dataBase.getHospitals()[0].getDoctors()[0].getPatients().length;
        for (int i = 0; i < dataBase.getHospitals().length; i++) {
            for (int j = 0; j < dataBase.getHospitals()[i].getDoctors().length; j++) {
                if(counter<dataBase.getHospitals()[i].getDoctors()[j].getPatients().length){
                    counter=dataBase.getHospitals()[i].getDoctors()[j].getPatients().length;
                    hospital=dataBase.getHospitals()[i];
                }
            }
        }
        return  hospital;
    }

    @Override
    public Hospital[] getDoctorAndHospitalPatientName(String patientName) {
        Hospital [] hospitals= new Hospital[dataBase.getHospitals().length];
        int counter=0;
        for (Hospital hospital:dataBase.getHospitals()
             ) {
            for (Doctor doctor:hospital.getDoctors()
                 ) {
                for (Patient patient :doctor.getPatients()) {
                    if(patient.getName().equals(patientName)){
                      hospitals[counter]= hospital;
                        counter++;
                    }
                }
            }
        }
return  hospitals;
    }

    @Override
    public Hospital [] getDoctorAndHospitalDoctorId(int doctorId) {
        Hospital [] hospitals= new Hospital[dataBase.getHospitals().length];
        int counter=0;
        for (Hospital hospital:dataBase.getHospitals()
        ) {
            for (Doctor doctor:hospital.getDoctors()
            ) {
                    if(doctor.getId()==doctorId){
                        hospitals[counter]= hospital;
                        counter++;
                    }
            }
        }
        return  hospitals;
    }

    @Override
    public Hospital getBusiesHospital() {
      Hospital hospital = null;
int counter = dataBase.getHospitals()[0].getDoctors().length;
int counter1 = dataBase.getHospitals()[0].getDoctors()[0].getPatients().length;
        for (int i = 0; i < dataBase.getHospitals().length; i++) {
            if (counter <= dataBase.getHospitals()[i].getDoctors().length) {
                counter = dataBase.getHospitals()[i].getDoctors()[i].getPatients().length;
            }
            for (int j = 0; j < dataBase.getHospitals()[i].getDoctors().length; j++) {
                if (counter1 <= dataBase.getHospitals()[i].getDoctors()[j].getPatients().length) {
                    counter1 = dataBase.getHospitals()[i].getDoctors()[j].getPatients().length;
                    hospital = dataBase.getHospitals()[i];
                }
            }


        }
        return hospital;
    }


    //public Doctor getDoctorWithMostPatients () {
//            Doctor doctor=null;
//        int counter = dataBase.getHospitals()[0].getDoctors()[0].getPatients().length;
//            for (int i = 0; i < dataBase.getHospitals().length; i++) {
//                for (int j = 0; j < dataBase.getHospitals()[i].getDoctors().length; j++) {
//                    if(counter< dataBase.getHospitals()[i].getDoctors()[j].getPatients().length){
//                        counter=dataBase.getHospitals()[i].getDoctors()[j].getPatients().length;
//                        doctor=dataBase.getHospitals()[i].getDoctors()[j];
//                    }
//                }
//            }
//            return doctor;
//        }
}
