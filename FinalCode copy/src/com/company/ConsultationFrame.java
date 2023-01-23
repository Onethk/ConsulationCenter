package com.company;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ConsultationFrame {

    static ArrayList<Consultation> tempConsul = new ArrayList<Consultation>();

    ConsultationFrame(){

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);


        viewConsultation(frame);
        exitButton(frame);

    }

    private void exitButton(JFrame frame){

        JButton button = new JButton("Back");
        button.setBounds(540, 500, 80, 20);


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

    public static void viewConsultation(JFrame frame){

        JTextField t1;

        JLabel label = new JLabel("View Consultations");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBounds(200, 20, 200, 50);

        t1=new JTextField("Enter patient's ID");
        t1.setBounds(40,100, 200,30);


        ArrayList<Consultation> tempConsul = new ArrayList<Consultation>();

        JButton button = new JButton("Show Details");
        button.setBounds(270, 105, 100, 20);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i=0;i<BookConsultation.booking.size();i++){


                    if(Integer.parseInt(t1.getText()) == (BookConsultation.booking.get(i).getPatID())){
                        // the above if condition checks the user entered patient ID with the patient ID's in the bookings

                        Consultation instance = new Consultation(BookConsultation.booking.get(i).getDocfName(),
                                BookConsultation.booking.get(i).getDoclName(),
                                BookConsultation.booking.get(i).getSpecialisation(), BookConsultation.booking.get(i).getPatfName(),
                                BookConsultation.booking.get(i).getPatlName(),BookConsultation.booking.get(i).getPatID(),
                                BookConsultation.booking.get(i).getPatMobile(),BookConsultation.booking.get(i).getCost(),
                                BookConsultation.booking.get(i).getNotes(),BookConsultation.booking.get(i).getConsulDate());

                        tempConsul.add(instance);

                        ConsulTableModel tableModel = new ConsulTableModel(tempConsul);
                        JTable thisTable = new JTable(tableModel);

                        JScrollPane pane1 = new JScrollPane(thisTable);
                        pane1.setBounds(30, 180, 640, 300);
                        frame.add(pane1);

                    }

                }
            }
        });


        frame.add(t1);
        frame.add(label);
        frame.add(button);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setTitle("Westminster Skin Consultation");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
