package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Recruiter extends Main{

    ArrayList<String> namesFound = new ArrayList<>();
    private ArrayList<Resume> recruiterResumes = new ArrayList<Resume>();



    //Empty Constructor
    public Recruiter() {
    }


    //Method to check resumes for a skill and prints a list of names that have that skill
    public void skillCheck(ArrayList<Resume> resumes, String skill){

        //Loops through all the resumes
        for (Resume resume : resumes) {

            //For each resume, loop through the skills and check if they equal the desired skill
            for (String s : resume.displaySKills()) {

                //if the skill on resume matches desired skill, add name on the resume to an ArrayList
                if (skill.equalsIgnoreCase(s)) {
                    addNamesFound(resume.getPersonalInfo(0).getName());
                }
            }

            System.out.println();

        }

        //For each name in the ArrayList of names, print out the name
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
