import common.InOutUtils;
import model.StudentModel;
import view.StudentView;

public class MainApp {
    private static StudentModel studentList;
    private static StudentView view;

    public static void main(String[] args) {
        initStudent();
        inputStudents();
        displayListStudents();
        displayClassificationInfo();
    }

    private static void initStudent() {
        studentList = new StudentModel();
        view = new StudentView();
    }

    private static void inputStudents() {
        InOutUtils.printMsg("====== Management Student Program ======\n");
        studentList.inputStudent();
    }

    private static void displayListStudents() {
        view.printStudentList(studentList.getStudentList());
    }

    private static void displayClassificationInfo() {
        view.printClassificationInfo(studentList.getPercentTypeStudent());
    }

}
