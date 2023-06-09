import controller.CandidateController;

public class MainApp {
    public static void main(String[] args) {
        CandidateController candidateController = new CandidateController();
        while(true){
            int choice = candidateController.getchoice();
            switch (choice){
                case 1:
                    candidateController.createExperienceList();
                    break;
                case 2:
                    candidateController.createFresherList();
                    break;
                case 3:
                    candidateController.createInternship();
                    break;
                case 4:
                    candidateController.search();
                    break;
                case 5:
                    return;
            }
        }
    }
}
