package com.company;

import java.util.ArrayList;

public class Resume {

    ArrayList<Personal> personalInfo = new ArrayList<>();
    ArrayList<Education> educations = new ArrayList<>();
    ArrayList<Experience> experiences = new ArrayList<>();
    ArrayList<Skills> skills = new ArrayList<>();

    private String competencyLevel;

    //Empty Constructor
    public Resume(){

    }


    //Method to get info from all parts of the resume and prints them out
    public void displayResume(){
        for (Personal p: personalInfo){
            p.displayPersonal();
        }
        System.out.println("EDUCATION");
        for (Education e: educations){
            e.displayEducation();
        }
        System.out.println("EXPERIENCE");
        for (Experience e: experiences){
            e.displayExperience();
        }
        System.out.println("SKILLS");
        for (Skills s: skills){
            s.displaySkills();
        }
    }

    //Method to add skills into an ArrayList to use in Recruiter Class
    public ArrayList<String> displaySKills() {
        ArrayList<String> skillList = new ArrayList<>();
        for (Skills skill : skills) {
            skillList.add(skill.getSkillName());
        }
        return skillList;
    }

    //Method to add competency level to display with Recruiter Class
    //Not implemented yet
    public String displayCompetency() {
        for (Skills skill : skills) {
            setCompetencyLevel(skill.getSkillCompetency());
        }
        return getCompetencyLevel();
    }


    public Personal getPersonalInfo(int i) {
        return personalInfo.get(i);
    }

    public void addPersonalInfo(Personal info) {
        personalInfo.add(info);
    }

    public Education getEducations(int i) {
        return educations.get(i);
    }

    public void addEducations(Education edu) {
        educations.add(edu);
    }

    public Experience getExperiences(int i) {
        return experiences.get(i);
    }

    public void addExperiences(Experience exp) {
        experiences.add(exp);
    }

    public Skills getSkills(int i) {
        return skills.get(i);
    }

    public void addSkills(Skills skl) {
        skills.add(skl);
    }

    public String getCompetencyLevel() {
        return competencyLevel;
    }

    public void setCompetencyLevel(String competencyLevel) {
        this.competencyLevel = competencyLevel;
    }
}
