package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class mainGui{


    mainGui(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setTitle("Westminster Skin Consultation");
        frame.getContentPane().setBackground(Color.WHITE);


        homePageHeading(frame);
        viewDoctor(frame);
        bookConsultation(frame);
        viewConsultation(frame);
        addImage(frame);


        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void addImage(JFrame frame){

        ImageIcon image = new ImageIcon("/Users/oneth/University/OOP CW/FinalCode/image1.png");
        JLabel label = new JLabel();
        label.setIcon(image);
        label.setBounds(-110,50,500,600);
        frame.add(label);

    }

    public static void homePageHeading(JFrame frame){

        JLabel label = new JLabel("Westminster Skin Consultation");
        label.setBounds(120,0,390,100);

        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setForeground(Color.black);
        frame.add(label);

    }

    public static void viewDoctor(JFrame frame){

        JButton button = new JButton("View Doctors");
        button.setBounds(385,130,140,20);

        Color c = new Color(76, 103  , 147);
        button.setBackground(c);
        button.setOpaque(true);
        button.setBorderPainted(false);


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    frame.dispose();
                    try {
                        DoctorFrame doctorFrame = new DoctorFrame();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        });
        button.setForeground(Color.white);
        frame.add(button);
    }



    public static void bookConsultation(JFrame frame){

        JButton button = new JButton("Book Consultation");
        button.setBounds(380,210,160,20);

        Color c = new Color(76, 103  , 147);
        button.setBackground(c);
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    frame.dispose();
                    BookConsultation bookConsul = new BookConsultation();
                }

            }
        });

        button.setForeground(Color.white);
        frame.add(button);

    }

    public static void viewConsultation(JFrame frame){

        JButton button = new JButton("View Booked Consultation");
        button.setBounds(360,290,210,20);

        Color c = new Color(76, 103  , 147);
        button.setBackground(c);
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    frame.dispose();
                    ConsultationFrame bookConsul = new ConsultationFrame();

                }
            }
        });


        button.setForeground(Color.white);
        frame.add(button);

    }




}
