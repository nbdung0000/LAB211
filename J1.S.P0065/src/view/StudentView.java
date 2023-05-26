package view;

import common.InOutUtils;
import entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentView {
    public void printStudent(Student student) {
        InOutUtils.printMsg("Name: " + student.getName() + "\n");
        InOutUtils.printMsg("Classes: " + student.getClassName() + "\n");
        InOutUtils.printMsg("AVG: " + student.getAverage() + "\n");
        InOutUtils.printMsg("Type: " + student.getType() + "\n");
    }

    public void printStudentList(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            InOutUtils.printMsg("------ Student" + studentList.indexOf(student) + " Info ------\n");
            printStudent(student);
        }
    }

    public void printClassificationInfo(HashMap<String, Double> typePercentages) {
        InOutUtils.printMsg("--------Classification Info -----\n");
        for (String type : typePercentages.keySet()) {
            InOutUtils.printMsg(type + ": " + typePercentages.get(type) + "%\n");
        }
    }
}
