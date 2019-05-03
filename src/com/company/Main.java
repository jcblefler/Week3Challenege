package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Resume> resumes = new ArrayList<>();

        String userInput = "";
        String educationAdd;
        String experienceAdd;
        String descriptionInput;

        String skillInput;
        String displayResume;
        int resumeNumber = 0;


        while(!userInput.equalsIgnoreCase("n")){

            System.out.println("Would you like to add a resume? (y/n)");
            userInput = scanner.next();
            scanner.nextLine();
            if (userInput.equalsIgnoreCase("y")){
                Resume resume = new Resume();

                Personal resumeInfo;
                System.out.println("Name: ");
                String name = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                resumeInfo = new Personal(name, email);
                resume.addPersonalInfo(resumeInfo);

                educationAdd = "";
                while (!educationAdd.equalsIgnoreCase("n")){
                    System.out.println("Do you want to add an education section?");
                    educationAdd = scanner.nextLine();
                    if (educationAdd.equalsIgnoreCase("y")){
                        Education educations;
                        System.out.println("Education");
                        System.out.println("Degree type:");
                        String degree = scanner.nextLine();
                        System.out.println("Major:");
                        String major = scanner.nextLine();
                        System.out.println("University Name:");
                        String uniName = scanner.nextLine();
                        System.out.println("Graduation Year:");
                        int gradYear = scanner.nextInt();
                        scanner.nextLine();
                        educations = new Education(degree, major, uniName, gradYear);
                        resume.addEducations(educations);
                    }

                }

                experienceAdd= "";
                while (!experienceAdd.equalsIgnoreCase("n")){
                    System.out.println("Do you want to add an experience section?");
                    experienceAdd = scanner.nextLine();
                    if (experienceAdd.equalsIgnoreCase("y")) {

                        Experience experiences = new Experience();
                        System.out.println("Experience");
                        System.out.println("Company:");
                        String company = scanner.nextLine();
                        System.out.println("Job Title:");
                        String jobTitle = scanner.nextLine();
                        System.out.println("Start Date:");
                        String startDate = scanner.nextLine();
                        System.out.println("End Date:");
                        String endDate = scanner.nextLine();
                        System.out.println("Job Description:");
                        experiences.addJobDescription(scanner.nextLine());
                        descriptionInput = "";
                        while (!descriptionInput.equalsIgnoreCase("n")) {
                            System.out.println("Would you like to enter another Job Description.");
                            descriptionInput = scanner.next();
                            scanner.nextLine();
                            if (descriptionInput.equalsIgnoreCase("y")) {
                                System.out.println("Job Description:");
                                experiences.addJobDescription(scanner.nextLine());
                            }
                        }
                        experiences.setCompany(company);
                        experiences.setJobTitle(jobTitle);
                        experiences.setStartDate(startDate);
                        experiences.setEndDate(endDate);
                        resume.addExperiences(experiences);


                    }
                }

                Skills skills;
                System.out.println("Skills");
                System.out.println("Skill Name:");
                String skillName = scanner.nextLine();
                System.out.println("Competency Rating:");
                String skillCompetency = scanner.nextLine();
                skills = new Skills(skillName, skillCompetency);
                resume.addSkills(skills);
                skillInput = "";
                while(!skillInput.equalsIgnoreCase("n")){
                    System.out.println("Would you like to enter another Skill.");
                    skillInput = scanner.next();
                    scanner.nextLine();
                    if (skillInput.equalsIgnoreCase("y")){
                        System.out.println("Skill Name:");
                        String skillNameAnother = scanner.nextLine();
                        System.out.println("Competency Rating:");
                        String competencyAnother = scanner.nextLine();
                        skills = new Skills(skillNameAnother, competencyAnother);
                        resume.addSkills(skills);
                    }
                }
                resumes.add(resume);

            }
        }


        System.out.println("Would you like to display the resumes? (y/n)");
        displayResume = scanner.nextLine();
        if (displayResume.equalsIgnoreCase("y")){
            for (Resume r: resumes){
                r.displayResume();
            }
        }

//        while (!displayResume.equalsIgnoreCase("n")){
//            System.out.println();
//        }

    }
}
