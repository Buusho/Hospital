package Model;

import java.util.Arrays;

public class Hospital {
    private  static int idd=0;
    private  int id ;
    private String name;
    private String address;
    private Doctor[] doctors;

    public Hospital( String name, String address, Doctor[] doctors) {
        this.id = ++idd;
        this.name = name;
        this.address = address;
        this.doctors = doctors;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Hospital.idd = idd;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doctors=" + Arrays.toString(doctors) +
                '}';
    }
}
