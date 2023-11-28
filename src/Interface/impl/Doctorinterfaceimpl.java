package Interface.impl;

import Interface.DoctorInterface;
import Model.Doctor;
import Model.Hospital;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.Arrays;

public class Doctorinterfaceimpl implements DoctorInterface {

    private DataBase dataBase;

    public Doctorinterfaceimpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addDoctor(Doctor doctor, int hospitalId) {
        Doctor[] doctors;
        for (Hospital hospital:dataBase.getHospitals()) {
            if (hospital.getId()==hospitalId){
                doctors = Arrays.copyOf(hospital.getDoctors(),hospital.getDoctors().length+1);
                doctors[doctors.length-1] = doctor;
                hospital.setDoctors(doctors);
                System.out.println("Doctor added successfully");

            }
        }
    }

    @Override
    public void updateDoctor(String doctorName, Doctor doctor) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Doctor d: h.getDoctors()) {
                if(d.getName().equals(doctorName)){
                    d.setName(doctor.getName());
                    d.setGender(doctor.getGender());
                    d.setDateOfBirth(doctor.getDateOfBirth());
                    d.setPatients(doctor.getPatients());
                }

            }

        }
        System.out.println("Doctor with name" + doctorName +
                " is successfully updated!!!");

    }

    @Override
    public void deleteDoctor(String doctorName) {
        Doctor[] doctors;
        int counter=0;
        for (Hospital h: dataBase.getHospitals()) {
            for (Doctor d: h.getDoctors()) {
                if(d.getName().equals(doctorName)) {
                    doctors = new Doctor[h.getDoctors().length - 1];
                    for (int i = 0; i < h.getDoctors().length; i++) {
                        if (!h.getDoctors()[i].getName().equals(doctorName)) {
                            doctors[counter] = h.getDoctors()[i];
                            counter++;
                        }

                    }
                    h.setDoctors(doctors);
                    System.out.println("Successfully deleted!!!");
                    break;
                }

            }

        }
    }

    @Override
    public Doctor getDoctorByName(String doctorName){
        for (Hospital h : dataBase.getHospitals()) {
            for (Doctor d: h.getDoctors()) {
                if(d.getName().equals(doctorName)){
                    return d;
                }

            }

        }
        return null;
    }

    @Override
    public Doctor[] getAllDoctorByHospitalId(int hospitalId) {
        for (Hospital hospital: dataBase.getHospitals()) {
            if(hospital.getId()==hospitalId){
                return hospital.getDoctors();
            }
        }
        return  null;
    }

    @Override
    public Doctor[] getAllDoctors() {
        Doctor[] doctors = new Doctor[1000];
        int counter=0;
        for (Hospital h:
                dataBase.getHospitals()) {
            for (Doctor d: h.getDoctors()) {
                doctors[counter]=d;
                counter++;
            }
        }
        doctors=Arrays.copyOf(doctors,counter);
        return doctors;
    }

    @Override
    public Doctor getOldestDoctor() {
        Doctor oldestDoctor = null;

        for (Hospital h : dataBase.getHospitals()) {
            for (Doctor d : h.getDoctors()) {
                if (oldestDoctor == null || d.getDateOfBirth().isBefore(oldestDoctor.getDateOfBirth())) {
                    oldestDoctor = d;
                }
            }
        }

        return oldestDoctor;



    }

    @Override
    public Doctor getYoungestDoctor() {
        Doctor youngestDoctor = null;
        for (Hospital h:dataBase.getHospitals()) {
            for (Doctor d :h.getDoctors()
                 ) {
               if(youngestDoctor==null || d.getDateOfBirth().isBefore(youngestDoctor.getDateOfBirth())) {
                   youngestDoctor= d;
               }
            }

            }
        return youngestDoctor;
    }

    @Override
    public double getAverageAgeOfPatientOfDoctor(int doctorId) {
        double average = 0;
        int counter = 0;
        for (Hospital hospital:dataBase.getHospitals()
        ) {
            for (Doctor doctor:hospital.getDoctors()
            ) {
                for (int i = 0; i <doctor.getPatients().length ; i++) {
                    if(doctor.getId()==doctorId){
                        average += LocalDate.now().getYear()-doctor.getPatients()[i].getDateOfBirth().getDayOfMonth();
                        counter= doctor.getPatients().length;
                    }
                }
            }
        }
return average/counter;
    }

    @Override
    public double getAverageAgeOfDoctorOfHospital(int hospitalId) {

   double average=0 ;
   int counter = 0;
        for (Hospital hospital:dataBase.getHospitals()
             ) {
            for (int i = 0; i <hospital.getDoctors().length ; i++) {
              if(hospital.getId()==hospitalId){
                  average+= LocalDate.now().getYear()-hospital.getDoctors()[i].getDateOfBirth().getDayOfMonth();
                  counter+=hospital.getDoctors().length;
              }
            }
            }
        return average/counter;
    }





}
