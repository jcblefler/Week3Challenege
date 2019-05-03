package com.company;

import java.util.ArrayList;

public class Experience {

    private String company;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private ArrayList<String> jobDescription = new ArrayList<>();

    public Experience() {
    }

    public Experience(String company, String jobTitle, String startDate, String endDate, ArrayList<String> jobDescription) {
        this.company = company;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
    }


    public void displayExperience(){
        System.out.println(getJobTitle());
        System.out.println(getCompany() + ", " + getStartDate() + " - " + getEndDate());
        for (String description: jobDescription){
            System.out.println("- " + description);
        }
        System.out.println();
    }




    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription(int i) {
        return jobDescription.get(i);
    }

    public void addJobDescription(String description) {
        jobDescription.add(description);
    }
}
