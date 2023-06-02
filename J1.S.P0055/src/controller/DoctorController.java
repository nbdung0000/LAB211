package controller;

import common.InOutUtils;
import entity.Doctor;
import model.DoctorModel;
import view.DoctorView;

public class DoctorController {
    private static DoctorModel doctorModel = new DoctorModel();
    private static DoctorView doctorView = new DoctorView();
    public int getChoice(){
        doctorView.displayMenu();
        int choice = InOutUtils.inputInt("Enter your choice: " , 1, 5);
        return choice;
    }
    private boolean isCodeValue(String code){
        for(Doctor doctor: doctorModel.getDoctorList()){
            if(doctor.getCode().equalsIgnoreCase(code)){
                return false;
            }
        }
        return !code.isEmpty();
    }
    public void addDoctor(){
        Doctor doctor = doctorView.inputDoctor();
        if(!isCodeValue(doctor.getCode())){
            InOutUtils.printMsg("Invalid code or duplicate code.");
            return;
        }
        doctorModel.addDoctor(doctor);
        InOutUtils.printMsg("Doctor added successfully.\n");
    }

    public void updateDoctor(){
        doctorModel.updateDoctor();
    }

    public void deleteDoctor(){
        doctorModel.deleteDoctor();
    }

    public void searchDoctor(){
        doctorView.displayDoctors(doctorModel.searchDoctor());
    }
}
