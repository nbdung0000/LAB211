package model;

import common.InOutUtils;
import entity.Candidate;

import java.util.ArrayList;

public class CandidateModel {
    private ArrayList<Candidate> candidatesList;

    public CandidateModel() {
        candidatesList = new ArrayList<>();
    }

    public ArrayList<Candidate> getCandidatesList() {
        return candidatesList;
    }

    public void add(Candidate candidate){
        candidatesList.add(candidate);
    }

    public void search(String name, int type){
        for(Candidate candidate: candidatesList){
            if(candidate.getCadidateType() == type &&
                    (candidate.getfName().contains(name) || candidate.getlName().contains(name))){
                InOutUtils.printMsg(candidate.toString() + "\n");
            }
        }
    }
}
