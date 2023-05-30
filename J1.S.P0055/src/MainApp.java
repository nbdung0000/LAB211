import controller.DoctorController;

public class MainApp {
    public static void main(String[] args) {
        DoctorController doctorController = new DoctorController();
        while(true){
            int choice = doctorController.getChoice();
            switch (choice){
                case 1:
                    doctorController.addDoctor();
                    break;
                case 2:
                    doctorController.updateDoctor();
                    break;
                case 3:
                    doctorController.deleteDoctor();
                    break;
                case 4:
                    doctorController.searchDoctor();
                    break;
                case 5:
                    return;
            }
        }
    }
}
