package model;

import common.InOutUtils;
import entity.Doctor;

import java.util.ArrayList;

public class DoctorModel {
    private ArrayList<Doctor> doctorList;

    public DoctorModel() {
        doctorList = new ArrayList<>();
    }

    private boolean isCodeValue(String code){
        for(Doctor doctor: doctorList){
            if(doctor.getCode().equalsIgnoreCase(code)){
                return false;
            }
        }
        return !code.isEmpty();
    }


    public void addDoctor(){
        Doctor doctor = new Doctor();
        boolean checkCode = false;
        String code = "";
        while(!checkCode){
            code = InOutUtils.inputString("Enter Code: ", 10);
            checkCode = isCodeValue(code);
            if(!checkCode){
                InOutUtils.printMsg("Invalid code or duplicate code.\n");
            }
        }
        doctor.setCode(code);
        doctor.setName(InOutUtils.inputString("Enter Name: ", 20));
        doctor.setSpecialization(InOutUtils.inputString("Enter Specialization: ", 20));
        doctor.setAvailability(InOutUtils.inputInt("Enter Availability: ", 0,Integer.MAX_VALUE));
        doctorList.add(doctor);
        InOutUtils.printMsg("Doctor added successfully.\n");
    }

    private Doctor searchDoctorByCode(String code){
        for(Doctor doctor: doctorList){
            if(doctor.getCode().equalsIgnoreCase(code)){
                return doctor;
            }
        }
        return null;
    }

    public void updateDoctor(){
        String code = InOutUtils.inputString("Enter Code: ", 10);
        Doctor doctor = searchDoctorByCode(code);
        if(doctor != null){
            do {
                doctor.setName(InOutUtils.inputString("Enter Name: ", 20));
                if(doctor.getName().isEmpty()){
                    InOutUtils.printMsg("Name cannot be empty.\n");
                }
            }while (doctor.getName().isEmpty());
            do {
                doctor.setSpecialization(InOutUtils.inputString("Enter Specialization: ", 20));;
                if(doctor.getSpecialization().isEmpty()){
                    InOutUtils.printMsg("Specialization cannot be empty.\n");
                }
            }while (doctor.getName().isEmpty());
            doctor.setAvailability(InOutUtils.inputInt("Enter Availability: ", 0,Integer.MAX_VALUE));
            InOutUtils.printMsg("Doctor updated successfully.\n");
        }
        else{
            InOutUtils.printMsg("Doctor code does not exist.\n");
        }
    }

    public void deleteDoctor(){
        String code = InOutUtils.inputString("Enter Code: ", 10);
        Doctor doctor = searchDoctorByCode(code);
        if(doctor != null){
            doctorList.remove(doctor);
            InOutUtils.printMsg("Doctor delete successfully.\n");
        }else{
            InOutUtils.printMsg("Doctor code does not exits.\n");
        }
    }

    public ArrayList<Doctor> searchDoctor(){
        String searchString = InOutUtils.inputString("Enter text: ",50);
        ArrayList<Doctor> foundDoctors = new ArrayList<>();
        for(Doctor doctor: doctorList){
            if(doctor.getCode().contains(searchString) || doctor.getName().contains(searchString)
                    || doctor.getSpecialization().contains(searchString)){
                foundDoctors.add(doctor);
            }
        }
        return foundDoctors;
    }
}
