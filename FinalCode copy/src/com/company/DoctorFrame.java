package com.company;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DoctorFrame {


    static ArrayList<Doctor> temp = new ArrayList<Doctor>();
    static ArrayList<String> temp_surname = new ArrayList<String>();


    DoctorFrame() throws FileNotFoundException {

        JFrame frame = new JFrame();

        viewDoctor(frame);
        orderButton(frame);
        addImage(frame);
        exitButton(frame);
    }

    public static void addImage(JFrame frame){

        ImageIcon image = new ImageIcon("/Users/oneth/University/OOP CW/FinalCode/image2.png");
        JLabel label = new JLabel();
        label.setIcon(image);
        label.setBounds(-20,10,400,500);
        frame.add(label);

    }

    private void exitButton(JFrame frame){

        JButton button = new JButton("Back");
        button.setBounds(780, 470, 80, 20);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    frame.dispose();
                    mainGui main1 = new mainGui();
                }
            }
        });


        Color c = new Color(76, 103, 147);
        button.setBackground(c);
        button.setOpaque(true);
        button.setBorderPainted(false);



        button.setForeground(Color.white);
        frame.add(button);

    }

    private void orderButton(JFrame frame) {

        JButton button = new JButton("A - Z");
        button.setBounds(355, 470, 80, 20);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {


                    Collections.sort(WestminsterSkinConsultationManager.doctor_Arraylist, Doctor.surName);  // doctors are sorted by their surnames

                    ArrayList<Doctor> temp1 = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctor_Arraylist);


                    DoctorTableModel tableModel = new DoctorTableModel(temp1);  // sorted arraylist is passed to the tableModel and its displayed
                    JTable table = new JTable(tableModel);
                    JScrollPane pane = new JScrollPane(table);

                    // ORDER BUTTON

                    pane.setBounds(350, 120, 510, 300);

                    frame.add(pane);

                }

            }
        });

        Color c = new Color(76, 103, 147);
        button.setBackground(c);
        button.setOpaque(true);
        button.setBorderPainted(false);


        button.setForeground(Color.white);
        frame.add(button);
    };


    public static void viewDoctor(JFrame frame) throws FileNotFoundException {

        JLabel label = new JLabel("Doctor List");
        label.setFont(new Font("Arial", Font.BOLD, 25));


        File file = new File("/Users/oneth/University/OOP CW/FinalCode/doctorDetails.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder cont = new StringBuilder();
            String text;

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String line = Files.readAllLines(Paths.get("/Users/oneth/University/OOP CW/FinalCode/doctorDetails.txt")).get(1);
//            System.out.println(line);
            line.split("|");
        } catch (IOException e) {
            System.out.println(e);
        }



        DoctorTableModel tableModel = new DoctorTableModel(WestminsterSkinConsultationManager.doctor_Arraylist);
        JTable table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane(table);

        // ORDER BUTTON

        pane.setBounds(350, 120, 510, 300);
        label.setBounds(540, 35, 220, 50);
        frame.add(label);

        frame.add(pane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 550);
        frame.setTitle("Westminster Skin Consultation");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setVisible(true);


    }


}
