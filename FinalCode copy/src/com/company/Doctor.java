package com.company;


import java.util.ArrayList;
import java.util.Comparator;

public class Doctor extends Person{

//    static ArrayList<Doctor> doctor_Arraylist = new ArrayList<Doctor>(10);


    private int medical_license_number;
    private String specialisation;

    public Doctor(String lName,String fName, int birthYear, int birthMonth, int birthDate, int mobileNo, int medical_license_number, String specialisation) {
        super(fName, lName, birthYear, birthMonth, birthDate, mobileNo);
        this.medical_license_number = medical_license_number;
        this.specialisation = specialisation;
    }

    public static Comparator<Doctor> surName = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            String surName1 = o1.getlName();
            String surName2 = o2.getlName();
            return surName1.compareTo(surName2);
        }
    };

    public int getMedical_license_number() {
        return medical_license_number;
    }

    public void setMedical_license_number(int medical_license_number) {
        this.medical_license_number = medical_license_number;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
