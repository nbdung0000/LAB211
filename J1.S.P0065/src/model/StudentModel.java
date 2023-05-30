package model;

import common.InOutUtils;
import entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentModel {
    private ArrayList<Student> studentList;

    public StudentModel() {
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void inputStudent() {
        boolean continueInput = true;
        while (continueInput) {
            String name = InOutUtils.inputString("Name: ",20);
            String classes = InOutUtils.inputString("Classes: ",15);
            double math = InOutUtils.inputDouble("Maths: ", 0, 10);
            double chemistry = InOutUtils.inputDouble("Chemistry: ", 0, 10);
            double physics = InOutUtils.inputDouble("Physics: ", 0, 10);
            this.studentList.add(new Student(name, classes, math, chemistry, physics));
            InOutUtils.printMsg("Do you want to enter more student information?(Y/N): ");
            String continueInputStr = InOutUtils.inputString("",1);
            continueInput = continueInputStr.equalsIgnoreCase("Y");
        }
    }

    public HashMap<String, Double> getPercentTypeStudent() {
        int totalStudent = studentList.size();
        int typeACount = 0;
        int typeBCount = 0;
        int typeCCount = 0;
        int typeDCount = 0;

        for (Student student : studentList) {
            switch (student.getType()) {
                case 'A':
                    typeACount++;
                    break;
                case 'B':
                    typeBCount++;
                    break;
                case 'C':
                    typeCCount++;
                    break;
                case 'D':
                    typeDCount++;
                    break;
            }
        }
        HashMap<String, Double> typePercentagets = new HashMap<>();
        typePercentagets.put("A", (double) typeACount / totalStudent * 100);
        typePercentagets.put("B", (double) typeBCount / totalStudent * 100);
        typePercentagets.put("C", (double) typeCCount / totalStudent * 100);
        typePercentagets.put("D", (double) typeDCount / totalStudent * 100);
        return typePercentagets;
    }
}
