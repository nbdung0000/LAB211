package view;

import common.InOutUtils;
import entity.Doctor;

import javax.print.Doc;
import java.util.ArrayList;

public class DoctorView {

    public Doctor inputDoctor(){
        Doctor doctor = new Doctor();
        doctor.setCode(InOutUtils.inputString("Enter Code: ", 10));
        doctor.setName(InOutUtils.inputString("Enter Name: ", 20));
        doctor.setSpecialization(InOutUtils.inputString("Enter Specialization: ", 20));
        doctor.setAvailability(InOutUtils.inputInt("Enter Availability: ", 0,Integer.MAX_VALUE));
        return doctor;
    }
    public void displayMenu(){
        InOutUtils.printMsg("========= Doctor Management ==========\n");
        InOutUtils.printMsg("1.Add Doctor.\n");
        InOutUtils.printMsg("2.Update Doctor.\n");
        InOutUtils.printMsg("3.Delete Doctor.\n");
        InOutUtils.printMsg("4.Search Doctor.\n");
        InOutUtils.printMsg("5.Exit.\n");
    }

    public void displayDoctors(ArrayList<Doctor> doctorArrayList){
        if(doctorArrayList.isEmpty()){
            InOutUtils.printMsg("Database does not exist\n");
        }else{
            InOutUtils.printMsg("---------------------------Result---------------------------\n");
            System.out.printf("%-10s%-20s%-20s%-12s\n", "Code", "Name", "Specialization", "Availability");
            for(Doctor doctor : doctorArrayList){
                System.out.printf("%-10s%-20s%-20s%-12d\n",
                        doctor.getCode(), doctor.getName(),doctor.getSpecialization(),doctor.getAvailability());
            }

        }
    }
}
