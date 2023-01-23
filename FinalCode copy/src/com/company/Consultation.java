package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Consultation {


    private double cost;
    private String notes;
    private String docfName;
    private String doclName;
    private String specialisation;
    private String patfName;
    private String patlName;
    private int patID;
    private int patMobile;
    private Date consulDate;


    static ArrayList<Integer> visitedPatient = new ArrayList<Integer>();


    public Consultation(String docfName, String doclName,String specialisation,String patfName, String patlName, int patID, int patMobile,double cost, String notes,Date consulDate) {
        this.cost = cost;
        this.notes = notes;
        this.specialisation = specialisation;
        this.docfName = docfName;
        this.doclName = doclName;
        this.patfName = patfName;
        this.patlName = patlName;
        this.patID = patID;
        this.patMobile = patMobile;
        this.consulDate = consulDate;
    }



    public double getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public String getDocfName() {
        return docfName;
    }

    public String getDoclName() {
        return doclName;
    }

    public String getPatfName() {
        return patfName;
    }

    public String getPatlName() {
        return patlName;
    }

    public int getPatID() {
        return patID;
    }

    public int getPatMobile() {
        return patMobile;
    }

    public Date getConsulDate() {
        return consulDate;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void addConsultation(){

        Date d1 = new Date();


        Scanner obj1 = new Scanner(System.in);
        System.out.print("Enter the consultation year: ");
        int year = obj1.nextInt() - 1900;
        d1.setYear(year);

        Scanner obj2 = new Scanner(System.in);
        System.out.print("Enter the consultation month: ");
        int month = obj2.nextInt() - 1;
        d1.setMonth(month);


        Scanner obj3 = new Scanner(System.in);
        System.out.print("Enter the consultation date: ");
        int c_date = obj3.nextInt();
        d1.setDate(c_date);



        Scanner obj4 = new Scanner(System.in);
        System.out.print("Enter the consultation hour: ");
        int hours = obj4.nextInt() + 5;
        d1.setHours(hours);

        Scanner obj5 = new Scanner(System.in);
        System.out.print("Enter the consultation minutes: ");
        int minutes = obj5.nextInt() ;
        d1.setMinutes(minutes + 30);

        Scanner obj6 = new Scanner(System.in);
        System.out.print("Enter the consultation seconds: ");
        int seconds = obj6.nextInt();
        d1.setSeconds(seconds);

        System.out.println(d1.toGMTString());

    }
}
