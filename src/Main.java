import Interface.DoctorInterface;
import Interface.HospitalInterface;
import Interface.PatientInterface;
import Interface.impl.DataBase;
import Interface.impl.Doctorinterfaceimpl;
import Interface.impl.Hospitalinterfaceimpl;
import Interface.impl.Patientinterfaceimpl;
import Model.Doctor;
import Model.Hospital;
import Model.Patient;

import java.time.LocalDate;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Patient patient = new Patient("Aksana","Female", LocalDate.of(1999, 12, 12));
        Patient patient1 = new Patient("Aisana","Female", LocalDate.of(1999, 12, 12));

        Doctor doctor = new Doctor("Adyl","Male",
                LocalDate.of(1999, 12, 12),
                new Patient[]{patient,patient1});

        Doctor doctor1 = new Doctor("Abdy","Male",
                LocalDate.of(1999, 12, 12),
                new Patient[]{new Patient("Akyl","Male",
                        LocalDate.of(1999, 12, 12)),
                        new Patient("Aijan","Female",
                                LocalDate.of(1999, 12, 12))});


        Hospital hospital = new Hospital("Ahunbaeva","Isa Ahunbaeva 125",
                new Doctor[]{doctor,doctor1,new Doctor("Mahabat","Female",
                        LocalDate.of(1996,1,3),new Patient[]{}),new Doctor("Saikal",
                        "Female",LocalDate.of(2008,9,7),new Patient[]{})});

        DataBase dataBase = new DataBase(new Hospital[]{hospital});

        DoctorInterface doctorInterface = new Doctorinterfaceimpl(dataBase);
        doctorInterface.addDoctor(new Doctor("Ainazik","Female",
                LocalDate.of(1999, 12, 12),
                new Patient[]{new Patient("Nuraida","Female",
                        LocalDate.of(1887,11,11))}),1);
        System.out.println(Arrays.toString(doctorInterface.getAllDoctorByHospitalId(1)));
        doctorInterface.deleteDoctor("Abdy");
        System.out.println(Arrays.toString(doctorInterface.getAllDoctorByHospitalId(1)));
        System.out.println(Arrays.toString(doctorInterface.getAllDoctors()));

        System.out.println(doctorInterface.getOldestDoctor());
        System.out.println(doctorInterface.getDoctorByName("Ainazik"));
        System.out.println(Arrays.toString(doctorInterface.getAllDoctors()));
        System.out.println(doctorInterface.getAverageAgeOfDoctorOfHospital(1));
        System.out.println(doctorInterface.getAverageAgeOfPatientOfDoctor(5));
//        System.out.println(doctorInterface.updateDoctor("Ainazik",new Doctor("Vika","Male",LocalDate.of(1998,4,2), new Patient[]{new Patient("Gena","MAle",LocalDate.of(1999,3,4))})));





        PatientInterface patientInterface = new Patientinterfaceimpl(dataBase);
        patientInterface.addPatient(new Patient("Adyl","Male",LocalDate.of(2001,2,3)),5);
        System.out.println(Arrays.toString(patientInterface.getAllPatientByHospitalId(1)));
        patientInterface.deletePatient("Anna");
        System.out.println(patientInterface.getPatientByDoctorId(5,"Adyl"));
        patientInterface.updatePatient("Adyl",new Patient("Abu","MAle",LocalDate.of(1999,12,2)));
        System.out.println(Arrays.toString(patientInterface.getAllPatientByDoctorId(5)));


        HospitalInterface hospitalInterface = new Hospitalinterfaceimpl(dataBase);
        hospitalInterface.addHospital(new Hospital("Ahunbaeva","Maldybaeva56",new Doctor[]{}));
        hospitalInterface.addHospital(new Hospital("Joldo","sa2",new Doctor[]{}));
        hospitalInterface.deleteHospital("Joldo");
        System.out.println(Arrays.toString(hospitalInterface.getAllHospitals()));
        System.out.println(Arrays.toString( hospitalInterface.getDoctorAndHospitalPatientName("Adyl")));
        System.out.println(  hospitalInterface.getHospitalWithMostDoctors());

    }
}