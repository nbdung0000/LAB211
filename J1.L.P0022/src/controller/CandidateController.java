package controller;


import common.InOutUtils;
import model.CandidateModel;
import view.CandidateView;

public class CandidateController {
    private static CandidateModel candidateModel = new CandidateModel();
    private static CandidateView candidateView = new CandidateView();

    public int getchoice(){
        InOutUtils.printMsg("CANDIDATE MANAGEMENT SYSTEM\n" +
                "1.\tExperience\n" +
                "2.\tFresher\n" +
                "3.\tInternship\n" +
                "4.\tSearching\n" +
                "5.\tExit\n");
        return InOutUtils.inputInt("Enter your choice: ", 1, 5);
    }

    public void createExperienceList(){
        while (true) {
            candidateModel.add(candidateView.inputExperience(candidateModel.getCandidatesList()));
            String choose = InOutUtils.inputString("Do you want to continue (Y/N)?.", 1);
            if (choose.equalsIgnoreCase("Y")) {
                continue;
            } else if (choose.equalsIgnoreCase("N")) {
                break;
            } else {
                InOutUtils.printMsg("Invalid, enter again!\n");
            }
        }
        candidateView.displayAllCandidate(candidateModel.getCandidatesList());
    }

    public void createFresherList(){
        while (true) {
            candidateModel.add(candidateView.inputFresherCandidate(candidateModel.getCandidatesList()));
            String choose = InOutUtils.inputString("Do you want to continue (Y/N)?.", 1);
            if (choose.equalsIgnoreCase("Y")) {
                continue;
            } else if (choose.equalsIgnoreCase("N")) {
                break;
            } else {
                InOutUtils.printMsg("Invalid, enter again!\n");
            }
        }
        candidateView.displayAllCandidate(candidateModel.getCandidatesList());
    }

    public void createInternship(){
        while (true) {
            candidateModel.add(candidateView.inputInternCandidate(candidateModel.getCandidatesList()));
            String choose = InOutUtils.inputString("Do you want to continue (Y/N)?.", 1);
            if (choose.equalsIgnoreCase("Y")) {
                continue;
            } else if (choose.equalsIgnoreCase("N")) {
                break;
            } else {
                InOutUtils.printMsg("Invalid, enter again!\n");
            }
        }
        candidateView.displayAllCandidate(candidateModel.getCandidatesList());
    }

    public void search(){
        String searchStr = InOutUtils.inputString("Input Candidate name (First name or Last name): ", 20);
        int type = InOutUtils.inputInt("Input type of candidate: ", 0,2);
        InOutUtils.printMsg("The candidates found:\n");
        candidateModel.search(searchStr,type);
    }
}
