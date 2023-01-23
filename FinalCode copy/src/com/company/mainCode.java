package com.company;

import java.io.IOException;
import java.util.Scanner;

public class mainCode {

    public static void main(String[] args) throws IOException {


        Scanner inout = new Scanner(System.in);
        boolean run = true;
        while (run){
            System.out.println("""
                    A: Add Doctor
                    D: Delete Doctor
                    P: Print Doctor
                    S: Save Doctor
                    G: Open GUI
                    E: Exit""");
            switch (Character.toUpperCase(inout.next().charAt(0))){
                case 'A' -> WestminsterSkinConsultationManager.addDoctor();
                case 'D' -> WestminsterSkinConsultationManager.deleteDoctor();
                case 'P' -> WestminsterSkinConsultationManager.printDoctors();
                case 'S' -> WestminsterSkinConsultationManager.saveDoctors(WestminsterSkinConsultationManager.doctor_Arraylist);
                case 'G' -> WestminsterSkinConsultationManager.openGui();
                case 'E' -> run = false;
            }
        }

    }
}
