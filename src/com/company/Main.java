package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Resume> resumes = new HashMap<String, Resume>();
//        ArrayList<Resume> resumes = new ArrayList<>();



        String userInput = "";
        String educationAdd;
        String experienceAdd;
        String descriptionInput;

        String skillInput;
        String changeInput;
        String displayResume;
        String resumeName;


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
                System.out.println("Phone Number: ");
                String phone = scanner.nextLine();
                resumeInfo = new Personal(name, email, phone);
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
                resumes.put(name,resume);

            }
        }

        changeInput = "";
        while (!changeInput.equalsIgnoreCase("n")){
            System.out.println("Would you like to make changes to an existing resume? (y/n)");
            changeInput = scanner.nextLine();
            if (changeInput.equalsIgnoreCase("y")){
                System.out.println("What is the name of the Resume:");
                resumeName = scanner.nextLine();
                System.out.println("Are you changing your name? (y/n)");
                String n = scanner.nextLine();
                if (n.equalsIgnoreCase("y")){
                    System.out.println("New Name:");
                    resumes.get(resumeName).personalInfo.get(0).setName(scanner.nextLine());
                }
                System.out.println("Are you changing your email? (y/n)");
                String e = scanner.nextLine();
                if (e.equalsIgnoreCase("y")){
                    System.out.println("New Email:");
                    resumes.get(resumeName).personalInfo.get(0).setEmail(scanner.nextLine());
                }
                System.out.println("Are you changing your phone number? (y/n)");
                String p = scanner.nextLine();
                if (p.equalsIgnoreCase("y")){
                    System.out.println("New Phone Number:");
                    resumes.get(resumeName).personalInfo.get(0).setPhone(scanner.nextLine());
                }
                resumes.get(resumeName);
            }
        }

        Recruiter recruiter = new Recruiter();
        System.out.println("Are you a recruiter? (y/n)");
        String r = scanner.nextLine();
        if (r.equalsIgnoreCase("y")){
            System.out.println("What Skill are you looking for?");
            String s = scanner.nextLine();
            recruiter.skillCheck(s);
        }


        System.out.println("Would you like to display the resumes? (y/n)");
        displayResume = scanner.nextLine();
        if (displayResume.equalsIgnoreCase("y")) {
            for (HashMap.Entry<String, Resume> resume : resumes.entrySet()) {
                resume.getValue().displayResume();
                System.out.println();

            }
        }
//        if (displayResume.equalsIgnoreCase("y")){
//            for (Resume r: resumes){
//                r.displayResume();
//            }
//        }

//        while (!displayResume.equalsIgnoreCase("n")){
//            System.out.println();
//        }

    }
}
