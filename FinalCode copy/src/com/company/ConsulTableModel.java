package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ConsulTableModel extends AbstractTableModel {

    private ArrayList<Consultation> consulArrayList;
    private String[] columnNames = {"Doctor's Name","Patient Name","Patient ID","Consultation Date","Fee","Special Note"};

    public ConsulTableModel(ArrayList<Consultation> tempConsul){
        consulArrayList = tempConsul;
    }

    public int getRowCount(){
        return consulArrayList.size();
    }

    public int getColumnCount(){
        return columnNames.length;
    }


    public Object getValueAt(int rowIndex,int columnIndex){
        Object temp1 = null;

        if(columnIndex == 0){
            temp1 = consulArrayList.get(rowIndex).getDocfName()+" "+consulArrayList.get(rowIndex).getDoclName();
        }else if(columnIndex == 1){
            temp1 = consulArrayList.get(rowIndex).getPatfName()+" "+consulArrayList.get(rowIndex).getPatlName();
        }else if(columnIndex == 2){
            temp1 = consulArrayList.get(rowIndex).getPatID();
        }else if(columnIndex == 3){
            temp1 = consulArrayList.get(rowIndex).getConsulDate();
        }else if(columnIndex == 4){
            temp1 = consulArrayList.get(rowIndex).getCost();
        }else if(columnIndex == 5){
            temp1 = consulArrayList.get(rowIndex).getNotes();
        }return temp1;
    }

    public String getColumnName(int col){
        return columnNames[col];
    }

}
