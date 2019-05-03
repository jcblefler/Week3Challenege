package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Recruiter extends Main{

    Resume resume = new Resume();
    Skills skills = new Skills();
    ArrayList<String> namesFound = new ArrayList<>();
    HashMap<String, Resume> resumes = new HashMap<String, Resume>();
    String nameList;

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }




    public Recruiter() {
    }

    public void skillCheck(String skill){

//        for (HashMap.Entry<String, Resume> r : resumes.entrySet()){
//
//            for (int i = 0; i < resume.skills.size(); i++){
//                if (skill.equalsIgnoreCase(skills.getSkillName())){
//                    namesFound.add(r.getValue().personalInfo.get(0).getName());
//                }
//            }
//
//        }
//
//        for (String w : namesFound){
//            setNameList(getNameList() + w);
//        }

        System.out.println();

        System.out.println(getNameList());
    }


}
