package com.company;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class BookConsultation {

    static ArrayList<Consultation> booking = new ArrayList<Consultation>();
    static int count ;


    BookConsultation(){

        JFrame frame = new JFrame();

        count = 0;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(680, 800);
        frame.setTitle("Westminster Skin Consultation");
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setLayout(null);
        frame.setVisible(true);

        formInput(frame);
        exitButton(frame);
    }


    static String path = "";

    private void formInput(JFrame frame){    // In this function the users inputs are taken from the user

        JTextField t1,t2,t3,t4,t5;


        JLabel label1 = new JLabel("Book your Consultation");
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setBounds(200, 20, 300, 50);


        // textfield 1 to get patient's first name
        t1=new JTextField("Enter patient's first name");
        t1.setBounds(50,100, 200,30);

        // textfield 2 to get patient's last name
        t2=new JTextField("Enter patient's surname");
        t2.setBounds(50,160, 200,30);


        // combobox 1 to select birth year of patient

        JLabel label2 = new JLabel("Birth year");
        label2.setFont(new Font("Arial", Font.PLAIN, 13));
        label2.setBounds(60,210,100,20);

        String[] tempYear = new String[122];
        for (int i=0;i<122;i++){
                String temp1 = Integer.toString(i+1901);
                tempYear[i] = temp1;
        }

        JComboBox cmb1 = new JComboBox(tempYear);
        cmb1.setBounds(50,230, 100,30);


        // combobox 2 to select birth month of patient

        JLabel label3 = new JLabel("Birth month");
        label3.setFont(new Font("Arial", Font.PLAIN, 13));
        label3.setBounds(210,210,100,20);


        String[] tempMonth = new String[12];
        for (int i=0;i<12;i++){
            String temp1 = Integer.toString(i+1);
            tempMonth[i] = temp1;
        }

        JComboBox cmb2 = new JComboBox(tempMonth);
        cmb2.setBounds(200,230, 100,30);

        // combobox 3 to select birth date of patient

        JLabel label4 = new JLabel("Birth Date");
        label4.setFont(new Font("Arial", Font.PLAIN, 13));
        label4.setBounds(360,210,100,20);

        String[] tempDate = new String[31];
        for (int i=0;i<31;i++){
            String temp1 = Integer.toString(i+1);
            tempDate[i] = temp1;
        }

        JComboBox cmb3 = new JComboBox(tempDate);
        cmb3.setBounds(350,230, 100,30);


        // textfield 3 to input patient's ID

        t3=new JTextField("Enter patient's ID");
        t3.setBounds(50,290, 200,30);

        //textfield 4 to get patient's mobile number
        t4=new JTextField("Enter patient's mobile number");
        t4.setBounds(50,350, 200,30);


        // combobox 4 to select a doctor

        JLabel label5 = new JLabel("Select Doctor");
        label5.setFont(new Font("Arial", Font.PLAIN, 13));
        label5.setBounds(60,400,100,20);


        String[] tempDoc = new String[WestminsterSkinConsultationManager.doctor_Arraylist.size()];
        if(WestminsterSkinConsultationManager.doctor_Arraylist.size() > 0){
            for (int i=0;i< WestminsterSkinConsultationManager.doctor_Arraylist.size();i++){
                String temp2 = WestminsterSkinConsultationManager.doctor_Arraylist.get(i).getfName() +" | " + WestminsterSkinConsultationManager.doctor_Arraylist.get(i).getlName() +" | " + WestminsterSkinConsultationManager.doctor_Arraylist.get(i).getSpecialisation();
                tempDoc[i] = temp2;
            }
        }

        JComboBox cmb4 = new JComboBox(tempDoc);
        cmb4.setBounds(50,420, 500,30);


        // combobox 5 to select consultation year


        JLabel label6 = new JLabel("Consultation Year");
        label6.setFont(new Font("Arial", Font.PLAIN, 13));
        label6.setBounds(60,470,130,20);

        String[] consulYear = new String[5];
        for (int i=0;i<5;i++){
            String temp3 = Integer.toString(i+2021);
            consulYear[i] = temp3;
        }
        JComboBox cmb5 = new JComboBox(tempYear);
        cmb5.setBounds(50,490, 100,30);


        // combobox 6 to select consultation month

        JLabel label7 = new JLabel("Consultation Month");
        label7.setFont(new Font("Arial", Font.PLAIN, 13));
        label7.setBounds(210,470,130,20);

        String[] consulMonth = new String[12];
        for (int i=0;i<12;i++){
            String temp4 = Integer.toString(i+1);
            consulMonth[i] = temp4;
        }
        JComboBox cmb6 = new JComboBox(consulMonth);
        cmb6.setBounds(200,490, 100,30);



        // combo 7 to select consultation date


        JLabel label8 = new JLabel("Consultation Date");
        label8.setFont(new Font("Arial", Font.PLAIN, 13));
        label8.setBounds(360,470,130,20);

        String[] consulDate = new String[31];
        for (int i=0;i<31;i++){
            String temp5 = Integer.toString(i+1);
            consulDate[i] = temp5;
        }


        JComboBox cmb7 = new JComboBox(consulDate);
        cmb7.setBounds(360,490, 100,30);



        // combobox 8 to select consultation hour


        JLabel label9 = new JLabel("Consultation time");
        label9.setFont(new Font("Arial", Font.PLAIN, 13));
        label9.setBounds(500,470,130,20);

        String[] hour = new String[24];
        for (int i=0;i<24;i++){
            String temp4 = Integer.toString(i);
            hour[i] = temp4;
        }

        JComboBox cmb8 = new JComboBox(hour);
        cmb8.setBounds(490,490, 70,30);


        JComboBox cmb9 = new JComboBox();
        cmb9.addItem(0);
        cmb9.setBounds(570,490, 70,30);


        t5=new JTextField("Special note");
        t5.setBounds(50,550, 200,50);


        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(label8);
        frame.add(label9);

        frame.add(cmb1);
        frame.add(cmb2);
        frame.add(cmb3);
        frame.add(cmb4);
        frame.add(cmb5);
        frame.add(cmb6);
        frame.add(cmb7);
        frame.add(cmb8);
        frame.add(cmb9);


        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);

        JButton button1 = new JButton("Upload Image");
        button1.setBounds(50,650,140,20);


        JFileChooser getfile = new JFileChooser();

        // this function inside the button encrypts the image

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button1){

                    getfile.setCurrentDirectory(new File(System.getProperty("user.home")));
                    //filter the files
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                    getfile.addChoosableFileFilter(filter);
                    int result = getfile.showSaveDialog(null);
                    //if the user click on save in Jfilechooser
                    if(result == JFileChooser.APPROVE_OPTION){
                        File selectedFile = getfile.getSelectedFile();
                        path = selectedFile.getAbsolutePath();
                    }
                    //if the user click on save in Jfilechooser

                    else if(result == JFileChooser.CANCEL_OPTION){
                        System.out.println("No File Select");
                    }
                }

            }
        });



        JButton button = new JButton("Book Consultation");
        button.setBounds(50, 730, 160, 20);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int id = 0;   // variable used to store the current data in the text field

                // below is the patient ID validation, only a integer can be input
                try{
                    id = Integer.parseInt(String.valueOf(t3.getText()));
                }catch (Exception er){
                    JOptionPane.showMessageDialog(null,"Please enter valid patient ID","Invalid Details",JOptionPane.ERROR_MESSAGE);
                }


                // below is the patient mobile number validation, only a integer can be input

                int phonVal = 0;    // variable used to store the current data in the text field
                try{
                    phonVal = Integer.parseInt(String.valueOf(t4.getText()));
                }catch(Exception ef){
                    JOptionPane.showMessageDialog(null,"Please enter valid phone number","Invalid Details",JOptionPane.ERROR_MESSAGE);
                }


                Consultation.visitedPatient.add(id);
                for (int i=0;i<Consultation.visitedPatient.size();i++){
                    System.out.println(Consultation.visitedPatient.get(i));
                }

                int consulFee = 0;

                // consultation fee is calculated below

                if(Consultation.visitedPatient.size() > 0){
                    for (int i=0; i<Consultation.visitedPatient.size();i++){
                        if (Consultation.visitedPatient.get(i) == id){
                            consulFee = 25;
                        }else{
                            consulFee = 15;
                        }
                    }
                }else{
                    consulFee = 15;
                }

                String docF = WestminsterSkinConsultationManager.doctor_Arraylist.get(cmb4.getSelectedIndex()).getfName();
                String docL = WestminsterSkinConsultationManager.doctor_Arraylist.get(cmb4.getSelectedIndex()).getlName();
                String docSpec1 = WestminsterSkinConsultationManager.doctor_Arraylist.get(cmb4.getSelectedIndex()).getSpecialisation();


                String patFName = t1.getText();
                String patLName = t2.getText();
                int patid = id;
                int patPhone = phonVal;
                Date d1 = new Date();
                d1.setYear(Integer.parseInt(cmb5.getSelectedItem().toString()));
                d1.setMonth(Integer.parseInt(cmb6.getSelectedItem().toString()));
                d1.setDate(Integer.parseInt(cmb7.getSelectedItem().toString()));
                d1.setHours(Integer.parseInt(cmb8.getSelectedItem().toString()));
                d1.setMinutes(Integer.parseInt(cmb9.getSelectedItem().toString()));

                if(id>0 && patPhone>0){    // if patient ID and mobile number is integer the if condition is passed
                    if(Consultation.visitedPatient.size() == 1){   // first patient is added directly because there can't be same consultation time overlapped for first patient
                        booking.add(count,new Consultation(docF,
                                docL,docSpec1,
                                patFName,patLName,patid,patPhone,
                                consulFee,
                                t5.getText(),
                                d1));
                        try {        // encrypting the image uploaded by the user
                            FileInputStream file = new FileInputStream(path);
                            FileOutputStream outputStream = new FileOutputStream(id+"Encrypt.jpg");
                            byte k[] = "NiTh5252".getBytes();
                            SecretKeySpec key = new SecretKeySpec(k,"DES");
                            Cipher enc = Cipher.getInstance("DES");
                            enc.init(Cipher.ENCRYPT_MODE,key);
                            CipherOutputStream cos = new CipherOutputStream(outputStream, enc);
                            byte[] buf = new byte[1024];
                            int read;
                            while((read=file.read(buf)) != -1){
                                cos.write(buf,0,read);
                                break;
                            }
                            file.close();
                            outputStream.flush();
                            cos.close();

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null,"The booking is placed successfully");

                    }else{
                        // checkTime method is implemented below
                        if (checkTime(frame,cmb5,cmb6,cmb7,cmb8,cmb9,cmb4)){   //checking if selected date,time and doctor is booked by some other patient

                            JOptionPane.showMessageDialog(null,"This date and time is allocated by another patient");

                            for(int i=0;i<booking.size();i++){  // this loop is used to find another doctor available with same specialisation
//                                System.out.println(docSpec1);
                                if(booking.get(i).getSpecialisation().equals(docSpec1)){
                                    docSpec1 = booking.get(i).getSpecialisation();
//                                JOptionPane.showConfirmDialog(null,docF+docL+"is not available,"+booking.get(i).getDocfName()+booking.get(i).getDoclName()+" can be appointed.",null,JOptionPane.YES_NO_CANCEL_OPTION);
                                    int pane = JOptionPane.showConfirmDialog(null,docF+docL+"is not available,"+booking.get(i).getDocfName()+booking.get(i).getDoclName()+" can be appointed.","Replacement",JOptionPane.YES_NO_CANCEL_OPTION);

                                    // the line above asks the user if they are ok with allocating a different doctor with the same specialisation

                                    if(pane == 0){  // if they select yes booking is added
                                        booking.add(count, new Consultation(booking.get(i).getDocfName(),
                                                booking.get(i).getDoclName(),docSpec1,
                                                patFName,patLName,patid,patPhone,
                                                consulFee,
                                                t5.getSelectedText(),
                                                d1));
                                        try {    // encrypting the image uploaded by the user
                                            FileInputStream file = new FileInputStream(path);
                                            FileOutputStream outputStream = new FileOutputStream(id+"Encrypt.jpg");
                                            byte k[] = "NiTh5252".getBytes();
                                            SecretKeySpec key = new SecretKeySpec(k,"DES");
                                            Cipher enc = Cipher.getInstance("DES");
                                            enc.init(Cipher.ENCRYPT_MODE,key);
                                            CipherOutputStream cos = new CipherOutputStream(outputStream, enc);
                                            byte[] buf = new byte[1024];
                                            int read;
                                            while((read=file.read(buf)) != -1){
                                                cos.write(buf,0,read);
                                                break;
                                            }
                                            file.close();
                                            outputStream.flush();
                                            cos.close();

                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                        JOptionPane.showMessageDialog(null,"The booking is placed successfully");
                                        count++;
                                        break;
                                    }
                                }
                            }

                        }else {   // if no booking is made in the selected date,time and doctor simply the booking is added
                            System.out.println("booking added");
                            booking.add(new Consultation(docF,
                                    docL,docSpec1,
                                    patFName,patLName,patid,patPhone,
                                    consulFee,
                                    t5.getSelectedText(),
                                    d1));
                            try {  // encrypting the image uploaded by the user
                                FileInputStream file = new FileInputStream(path);
                                FileOutputStream outputStream = new FileOutputStream(id+"Encrypt.jpg");

                                byte k[] = "NiTh5252".getBytes();
                                SecretKeySpec key = new SecretKeySpec(k,"DES");
                                Cipher enc = Cipher.getInstance("DES");
                                enc.init(Cipher.ENCRYPT_MODE,key);
                                CipherOutputStream cos = new CipherOutputStream(outputStream, enc);
                                byte[] buf = new byte[1024];
                                int read;
                                while((read=file.read(buf)) != -1){
                                    cos.write(buf,0,read);
                                    break;
                                }
                                file.close();
                                outputStream.flush();
                                cos.close();
//                            JOptionPane.showMessageDialog(null,"The booking is placed successfully");

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            JOptionPane.showMessageDialog(null,"The booking is placed successfully");
                        }

                    }
                }else{
                    System.out.println("Error");
                }

            }
        });

//        frame.add(button);

        frame.add(button1);

        Color c = new Color(76, 103, 147);
        button.setBackground(c);
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.setForeground(Color.white);
        frame.add(button);

    }


    private static boolean checkTime(JFrame frame,JComboBox cmbtest1,JComboBox cmbtest2,JComboBox cmbtest3,JComboBox cmbtest4,JComboBox cmbtest5,JComboBox cmbtest6){
        boolean same = false;

        for(int i=0;i<booking.size();i++){      // checking if time,date and doctor is getting duplicated with bookings
            if(booking.get(i).getConsulDate().getYear() == Integer.parseInt(cmbtest1.getSelectedItem().toString()) &&
            booking.get(i).getConsulDate().getMonth() == Integer.parseInt(cmbtest2.getSelectedItem().toString()) &&
            booking.get(i).getConsulDate().getDate() == Integer.parseInt(cmbtest3.getSelectedItem().toString()) &&
            booking.get(i).getConsulDate().getHours() == Integer.parseInt(cmbtest4.getSelectedItem().toString()) &&
                    booking.get(i).getConsulDate().getMinutes() == Integer.parseInt(cmbtest5.getSelectedItem().toString()) &&
            booking.get(i).getDocfName().equals(WestminsterSkinConsultationManager.doctor_Arraylist.get(cmbtest6.getSelectedIndex()).getfName()) &&
                    booking.get(i).getDoclName().equals(WestminsterSkinConsultationManager.doctor_Arraylist.get(cmbtest6.getSelectedIndex()).getlName())){
                same =  true;
            }else {
                same =  false;
            }
        }
        return same;
    }



    private void exitButton(JFrame frame){

        JButton button = new JButton("Back");
        button.setBounds(480, 730, 80, 20);


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




}
