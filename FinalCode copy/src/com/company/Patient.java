package com.company;

public class Patient extends Person{

    private int patientID;


    public Patient(String fName, String lName, int birthYear, int birthMonth, int birthDate, int mobileNo, int patientID) {
        super(fName, lName, birthYear, birthMonth, birthDate, mobileNo);
        this.patientID = patientID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }


}
