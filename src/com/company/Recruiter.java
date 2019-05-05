package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Recruiter extends Main{

    ArrayList<String> namesFound = new ArrayList<>();
    private ArrayList<Resume> recruiterResumes = new ArrayList<Resume>();




    public Recruiter() {
    }



    public void skillCheck(ArrayList<Resume> resumes, String skill){

        for (Resume resume : resumes) {
            for (String s : resume.displaySKills()) {
                if (skill.equalsIgnoreCase(s)) {
                    addNamesFound(resume.getPersonalInfo(0).getName());
                }
            }

            System.out.println();

        }

        for (String s : namesFound) {
            System.out.println(s);
        }
    }



    public String getNamesFound(int i) {
        return namesFound.get(i);
    }

    public void addNamesFound(String name) {
       namesFound.add(name);
    }

    public Resume getRecruiterResumes(int i) {
        return recruiterResumes.get(i);
    }

    public void addRecruiterResumes(Resume resumes) {
       recruiterResumes.add(resumes);
    }

}
