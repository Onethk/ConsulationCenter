package com.company;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

//import static com.company.Doctor.doctor_Arraylist;

public class WestminsterSkinConsultationManager {


    private int deleteLicenseNumber;

    static ArrayList<Doctor> doctor_Arraylist = new ArrayList<Doctor>(10);


    public static void addDoctor(){

        Scanner addObj1 = new Scanner(System.in);
        Scanner addObj2 = new Scanner(System.in);
        Scanner addObj3 = new Scanner(System.in);
        Scanner addObj4 = new Scanner(System.in);



        System.out.print("Enter doctor's surname name : ");
        String sName = addObj2.nextLine();


        System.out.print("Enter doctor's first name : ");
        String fName = addObj1.nextLine();


        System.out.print("Enter doctor's medical license number : ");
        int medicalLicenseNumber = 0;
        try{
            medicalLicenseNumber = addObj3.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please enter valid medical license number: ");
            addDoctor();
        }



        System.out.print("Enter doctor's specialisation : ");
        String specialisation = addObj4.nextLine();



        Scanner obj1 = new Scanner(System.in);
        System.out.print("Enter the doctor's birth year: ");
        int year = obj1.nextInt() ;
//        d1.setYear(year);

        Scanner obj2 = new Scanner(System.in);
        System.out.print("Enter the doctor's birth month: ");
        int month = obj2.nextInt();
//        d1.setMonth(month);


        Scanner obj3 = new Scanner(System.in);
        System.out.print("Enter the doctor's birth date: ");
        int d_date = obj3.nextInt();
//        d1.setDate(d_date);

        Scanner obj4 = new Scanner(System.in);
        System.out.print("Enter doctor's phone number: ");
        int phoneNo = obj4.nextInt();

        if (doctor_Arraylist.size() > 0){    // doctor instance is added to the arraylist according to the condition
            if (checkDoctor(doctor_Arraylist, medicalLicenseNumber)) {   // checking if doctors are added from medical license number
                doctor_Arraylist.add(new Doctor(sName, fName, year, month, d_date, phoneNo, medicalLicenseNumber, specialisation));
                System.out.println("Doctor added successfully");
            }else{
                System.out.println("Doctors with same medical license number cannot be added");
            }
        } else {
            doctor_Arraylist.add(new Doctor(sName,fName,year,month,d_date,phoneNo,medicalLicenseNumber,specialisation));
            System.out.println("Doctor added successfully");
        }

    }

    public static boolean checkDoctor(ArrayList<Doctor> doctor_Arraylist, int pID){
        boolean checkDoctor = true;
        for (int i = 0; i < doctor_Arraylist.size(); i++){
            if (doctor_Arraylist.get(i).getMedical_license_number() == pID){
                checkDoctor = false;
            }
        }
        return checkDoctor;
    }

    public static void deleteDoctor(){

        Scanner delObj = new Scanner(System.in);
        System.out.print("Enter the medical license number of the doctor you want to delete: ");
        int deleteLicenseNumber = delObj.nextInt();

        for(int i=0;i<doctor_Arraylist.size();i++){

//            System.out.println(doctor_Arraylist.get(i).getlName()+" "+doctor_Arraylist.get(i).getfName()+" with medical ID: "+doctor_Arraylist.get(i).getMedical_license_number()+" is removed from the center");

            if(doctor_Arraylist.get(i).getMedical_license_number() == deleteLicenseNumber){  // checking for the doctor id from arraylist with user's input
                System.out.println(doctor_Arraylist.get(i).getlName()+" "+doctor_Arraylist.get(i).getfName()+" with medical ID: "+doctor_Arraylist.get(i).getMedical_license_number()+" is removed from the center");

                doctor_Arraylist.remove(i);

                if(doctor_Arraylist.size() == 1){
                    System.out.println("Now only " + doctor_Arraylist.size() + " doctor is available at the center");
                }else{
                    System.out.println("Now " + doctor_Arraylist.size() + " doctors are available at the center");
                }

            }
        }
    }

    static ArrayList<String> surname = new ArrayList<String>();

    public static void printDoctors(){


        for(int i=0;i<doctor_Arraylist.size();i++){

            surname.add(doctor_Arraylist.get(i).getlName());

        }

        Collections.sort(WestminsterSkinConsultationManager.doctor_Arraylist, Doctor.surName);

        for(int i=0;i<doctor_Arraylist.size();i++){
            System.out.println(doctor_Arraylist.get(i).getlName() + " "+ doctor_Arraylist.get(i).getfName());
            System.out.println("Medical license number: "+doctor_Arraylist.get(i).getMedical_license_number());
            System.out.println("Specialisation: "+doctor_Arraylist.get(i).getSpecialisation());
            System.out.println("Contact number: "+doctor_Arraylist.get(i).getMobileNo());
            System.out.println("Date of birth: "+doctor_Arraylist.get(i).getBirthYear()+"/"+doctor_Arraylist.get(i).getBirthMonth()+"/"+doctor_Arraylist.get(i).getBirthDate());
        }


//addDoctor();
    }

    public static void saveDoctors(ArrayList<Doctor> doctor_Arraylist) throws IOException {

        try (FileWriter inputFile = new FileWriter("/Users/oneth/University/OOP CW/FinalCode/doctorDetails.txt", true);
             BufferedWriter b = new BufferedWriter(inputFile);
             PrintWriter p = new PrintWriter(b)) {
//            Formatter fmt = new Formatter();
            p.printf("%14s %13s %20s %18s %15s %9s\n", "Last name", "First name", "Medical License No", "Specialisation", "Mobile No", "DOB");

            for (int i = 0; i < doctor_Arraylist.size(); i++) {
                p.printf("%11s %13s %15s %19s %19s %17s\n", doctor_Arraylist.get(i).getlName() +
                        "|", doctor_Arraylist.get(i).getfName() +
                        "|", doctor_Arraylist.get(i).getMedical_license_number() +
                        "|", doctor_Arraylist.get(i).getSpecialisation() +
                        "|", doctor_Arraylist.get(i).getMobileNo() +
                        "|", doctor_Arraylist.get(i).getBirthYear() +
                        "/" + doctor_Arraylist.get(i).getBirthMonth() +
                        "/" + doctor_Arraylist.get(i).getBirthDate());
            }
            System.out.println("Save");
        }
    }

    public static void openGui(){
        new mainGui();
    }
}


