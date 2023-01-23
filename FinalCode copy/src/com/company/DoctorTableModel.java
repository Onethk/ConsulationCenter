package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DoctorTableModel extends AbstractTableModel {

    private ArrayList<Doctor> doctorArrayList;
    private String[] columnNames = {"Last name","First name","Medical License Number","Specialisation","Mobile No","Date of birth"};

    public DoctorTableModel(ArrayList<Doctor> temp){
        doctorArrayList = temp;
    }

    @Override
    public int getRowCount(){
        return doctorArrayList.size();
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
        Object temp1 = null;

        if(columnIndex == 0){
            temp1 = doctorArrayList.get(rowIndex).getlName();
        }else if(columnIndex == 1){
            temp1 = doctorArrayList.get(rowIndex).getfName();
        }else if(columnIndex == 2){
            temp1 = doctorArrayList.get(rowIndex).getMedical_license_number();
        }else if(columnIndex == 3){
            temp1 = doctorArrayList.get(rowIndex).getSpecialisation();
        }else if(columnIndex == 4){
            temp1 = doctorArrayList.get(rowIndex).getMobileNo();
        }else if(columnIndex == 5){
            temp1 = doctorArrayList.get(rowIndex).getBirthYear()+"/"+doctorArrayList.get(rowIndex).getBirthMonth()+"/"+doctorArrayList.get(rowIndex).getBirthDate();
        }
        return temp1;

    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }


}
