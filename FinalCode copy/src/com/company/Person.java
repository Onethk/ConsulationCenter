package com.company;

public class Person {

    private String fName;
    private String lName;
    private int birthYear;
    private int birthMonth;
    private int birthDate;
    private int mobileNo;

    public Person(String fName, String lName, int birthYear, int birthMonth, int birthDate, int mobileNo) {
        this.fName = fName;
        this.lName = lName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
        this.mobileNo = mobileNo;
    }


    public String getfName() {
        return fName;
    }


    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public static class ConsultationFrame {
    }
}
