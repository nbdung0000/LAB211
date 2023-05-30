package controller;

import common.InOutUtils;
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
    public void addDoctor(){
        doctorModel.addDoctor();
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
