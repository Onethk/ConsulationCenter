package com.company;

import  org.junit.Test;
import static org.junit.Assert.assertEquals;
public class WestminsterSkinConsultationManagerTest {

    @Test
    public void addDoctor() {
        WestminsterSkinConsultationManager.doctor_Arraylist.add(new Doctor("Perera","John",2004,2,3,0763101012,123,"Cosmetic"));

        assertEquals("Perera",WestminsterSkinConsultationManager.doctor_Arraylist.get(0).getlName());
    }


    @Test
    public void deleteDoctor() {
        WestminsterSkinConsultationManager.doctor_Arraylist.add(new Doctor("Perera","John",2004,2,3,0763101012,123,"Cosmetic"));
        WestminsterSkinConsultationManager.doctor_Arraylist.add(new Doctor("Kahandawa","Oneth",2002,1,6,0763124444,124,"Dematalogistic"));

        WestminsterSkinConsultationManager.doctor_Arraylist.remove(0);
        assertEquals("Kahandawa",WestminsterSkinConsultationManager.doctor_Arraylist.get(0).getlName());
    }

    @Test
    public void printDoctors() {
        WestminsterSkinConsultationManager.doctor_Arraylist.add(new Doctor("Perera","John",2004,2,3,0763101012,123,"Cosmetic"));
        WestminsterSkinConsultationManager.doctor_Arraylist.add(new Doctor("Kahandawa","Oneth",2002,1,6,0763124444,124,"Dematalogistic"));

        WestminsterSkinConsultationManager.printDoctors();
        assertEquals("Kahandawa",WestminsterSkinConsultationManager.doctor_Arraylist.get(0).getlName());
    }
}