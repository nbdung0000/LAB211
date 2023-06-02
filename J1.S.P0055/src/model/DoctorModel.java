package model;

import common.InOutUtils;
import entity.Doctor;

import java.util.ArrayList;

public class DoctorModel {
    private ArrayList<Doctor> doctorList;

    public DoctorModel() {
        doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void addDoctor(Doctor doctor){
        doctorList.add(doctor);
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
