package view;

import common.InOutUtils;
import entity.Candidate;
import entity.ExperienceCandidate;
import entity.FresherCandidate;
import entity.InternCandidate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CandidateView {
    private String inputPhone(){
        String phoneValid = "^\\d{10}\\d*$";
        while(true){
            String phone = InOutUtils.inputString("Enter Phone: ",20).trim();
            if(phone.matches(phoneValid)){
                return phone;
            }else{
                InOutUtils.printMsg("Phone is number with minimum 10 characters\n");
            }
        }
    }

    private String inputEmail(){
        String emailValid = "^[A-Za-z0-9.+-_%]+@+[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
        while(true){
            String email = InOutUtils.inputString("Enter Email: ", 40).trim();
            if(email.matches(emailValid)){
                return email;
            }else{
                InOutUtils.printMsg("Email with format <account name>@<domain>\n");
            }
        }
    }

    private String inputGraduationRank(){
        while(true){
            String rank = InOutUtils.inputString("Enter Graduation Rank: ",10).trim();
            if(rank.equalsIgnoreCase("Excellence")
            ||rank.equalsIgnoreCase("Good")
            ||rank.equalsIgnoreCase("Fair")
            ||rank.equalsIgnoreCase("Poor")){
                return rank;
            }else{
                InOutUtils.printMsg("Please input string: Excellence, Good, Fair, Poor\n");
            }
        }
    }

    private boolean checkDuplicateID(String id, ArrayList<Candidate> candidatesList){
        for(Candidate candidate:candidatesList){
            if(candidate.getCadidateId().equalsIgnoreCase(id)){
                return false;
            }
        }
        return true;
    }
    private void inputCandidate(Candidate candidate, ArrayList<Candidate> candidatesList){
        while(true){
            String id = InOutUtils.inputString("Enter ID: ",10);
            if(checkDuplicateID(id,candidatesList)){
                candidate.setCadidateId(id);
                break;
            }else{
                InOutUtils.printMsg("ID is duplicate. Please enter again!\n");
            }
        }
        candidate.setfName(InOutUtils.inputString("Enter First Name: ", 15).trim());
        candidate.setlName(InOutUtils.inputString("Enter Last Name: ",10).trim());
        candidate.setDateBirth(InOutUtils.inputInt("Enter Birth Date: ",1900,2023));
        candidate.setAddress(InOutUtils.inputString("Enter Address: ", 20));
        candidate.setPhone(inputPhone());
        candidate.setEmail(inputEmail());
        candidate.setCadidateType(InOutUtils.inputInt("Enter Candidate Type: ",0,2));
    }

    public ExperienceCandidate inputExperience(ArrayList<Candidate> candidatesList){
        ExperienceCandidate experience = new ExperienceCandidate();
        inputCandidate(experience, candidatesList);
        experience.setExpInYear(InOutUtils.inputInt("Enter year of experience: ",0,100));
        experience.setProSkill(InOutUtils.inputString("Enter professional skill: ",30));
        return experience;
    }

    public FresherCandidate inputFresherCandidate(ArrayList<Candidate> candidatesList){
        FresherCandidate fresher = new FresherCandidate();
        inputCandidate(fresher,candidatesList);
        fresher.setGraduationDate(InOutUtils.inputString("Enter Graduated Date: ", 20));
        fresher.setGraduationRank((inputGraduationRank()));
        fresher.setEducation(InOutUtils.inputString("Enter Education: ",20));
        return fresher;
    }

    public InternCandidate inputInternCandidate(ArrayList<Candidate> candidatesList){
        InternCandidate intern = new InternCandidate();
        inputCandidate(intern, candidatesList);
        intern.setMajor(InOutUtils.inputString("Enter Major: ", 20));
        intern.setSemester(InOutUtils.inputInt("Enter Semester: ", 1, 9));
        intern.setUniversityName(InOutUtils.inputString("Enter University Name: ",20));
        return intern;
    }

    public void displayAllCandidate(ArrayList<Candidate> candidatesList){
        InOutUtils.printMsg("===========EXPERIENCE CANDIDATE============\n");
        for(Candidate candidate: candidatesList){
            if(candidate instanceof ExperienceCandidate){
                InOutUtils.printMsg(candidate.getfName() + " " + candidate.getlName() + "\n");
            }
        }

        InOutUtils.printMsg("==========FRESHER CANDIDATE==============\n");
        for(Candidate candidate: candidatesList){
            if(candidate instanceof FresherCandidate){
                InOutUtils.printMsg(candidate.getfName() + " " + candidate.getlName() + "\n");
            }
        }

        InOutUtils.printMsg("===========INTERN CANDIDATE==============\n");
        for(Candidate candidate: candidatesList){
            if(candidate instanceof InternCandidate){
                InOutUtils.printMsg(candidate.getfName() + " " + candidate.getlName() + "\n");
            }
        }
    }
}
