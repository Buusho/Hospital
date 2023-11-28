package Model;

import java.time.LocalDate;
import java.util.Arrays;

public class Doctor {
    private static int idd=0;
    private int id;
    private  String name;
    private  String gender;
    private LocalDate dateOfBirth;

    private  Patient[] patients;

    public Doctor(String name, String gender, LocalDate dateOfBirth, Patient[] patients) {
        this.id = ++idd;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.patients = patients;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Doctor.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", patients=" + Arrays.toString(patients) +
                '}';
    }
}
