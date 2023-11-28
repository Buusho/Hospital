package Interface.impl;

import Model.Hospital;

import java.util.Arrays;

public class DataBase {

    private Hospital[] hospitals;

    public DataBase(Hospital[] hospitals) {
        this.hospitals = hospitals;
    }

    public Hospital[] getHospitals() {
        return hospitals;
    }

    public void setHospitals(Hospital[] hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "Interface.impl.DataBase{" +
                "hospitals=" + Arrays.toString(hospitals) +
                '}';
    }
}
