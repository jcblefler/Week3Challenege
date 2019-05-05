package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creates a HashMap that will store created resumes with a key of their name
        HashMap<String, Resume> resumes = new HashMap<String, Resume>();
        //Creates an ArrayList to use hold resumes to use for the recruiter class
        ArrayList<Resume> recruiterList = new ArrayList<>();



        String userInput = "";
        String educationAdd;
        String experienceAdd;
        String skillsAdd;
        String descriptionInput;

        String skillInput;
        String changeInput;
        String displayResume;
        String resumeName;

        //Loops to add multiple resume until user inputs (n)
        while(!userInput.equalsIgnoreCase("n")){

            System.out.println("Would you like to add a resume? (y/n)");
            userInput = scanner.next();
            scanner.nextLine();
            //If the user inputs (y) it prompts to add resume details
            if (userInput.equalsIgnoreCase("y")){
                //Creates a new instance of a Resume
                Resume resume = new Resume();

                //Section to add info for Personal class
                Personal resumeInfo;
                System.out.println("Name: ");
                String name = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                System.out.println("Phone Number: ");
                String phone = scanner.nextLine();

                //Loads info into a new Personal class
                resumeInfo = new Personal(name, email, phone);

                //Adds the created Personal Class into the Resume
                resume.addPersonalInfo(resumeInfo);

                //Prompts user if they want to add a Education Section
                educationAdd = "";
                while (!educationAdd.equalsIgnoreCase("n")){
                    System.out.println("Do you want to add an education section? (y/n)");
                    educationAdd = scanner.nextLine();

                    //If (y) then creates a instance of Education
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

                        //Loads info into Education class
                        educations = new Education(degree, major, uniName, gradYear);

                        //Adds the created Education Class into the Resume
                        resume.addEducations(educations);
                    }

                }

                experienceAdd= "";
                while (!experienceAdd.equalsIgnoreCase("n")){
                    System.out.println("Do you want to add an experience section? (y/n)");
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

                        //Prompts user if they want to add descriptions
                        //If (y) will repeat until user inputs (n)
                        descriptionInput = "";
                        while (!descriptionInput.equalsIgnoreCase("n")) {
                            System.out.println("Would you like to enter another Job Description? (y/n)");
                            descriptionInput = scanner.next();
                            scanner.nextLine();
                            if (descriptionInput.equalsIgnoreCase("y")) {
                                System.out.println("Job Description:");

                                //Loads the JobDesciption to the Experience Class
                                experiences.addJobDescription(scanner.nextLine());
                            }
                        }
                        //Loads info into Education class
                        experiences.setCompany(company);
                        experiences.setJobTitle(jobTitle);
                        experiences.setStartDate(startDate);
                        experiences.setEndDate(endDate);

                       // Adds the created Experiences Class into the Resume
                        resume.addExperiences(experiences);


                    }
                }

                skillsAdd = "";
                while (!skillsAdd.equalsIgnoreCase("n")) {
                    System.out.println("Do you want to add a skill section? (y/n)");
                    skillsAdd = scanner.nextLine();
                    if (skillsAdd.equalsIgnoreCase("y")) {
                        Skills skills;
                        System.out.println("Skills");
                        System.out.println("Skill Name:");
                        String skillName = scanner.nextLine();
                        System.out.println("Competency Rating:");
                        String skillCompetency = scanner.nextLine();

                        //Loads info into Skills class
                        skills = new Skills(skillName, skillCompetency);
                        resume.addSkills(skills);
                        skillInput = "";
                        while (!skillInput.equalsIgnoreCase("n")) {
                            System.out.println("Would you like to enter another Skill? (y/n)");
                            skillInput = scanner.next();
                            scanner.nextLine();
                            if (skillInput.equalsIgnoreCase("y")) {
                                System.out.println("Skill Name:");
                                String skillNameAnother = scanner.nextLine();
                                System.out.println("Competency Rating: (Enter one of the following)");
                                System.out.println("Fundamental, Novice, Intermediate, Advanced, Expert");
                                String competencyAnother = scanner.nextLine();

                                //Loads info into Skills class
                                skills = new Skills(skillNameAnother, competencyAnother);

                                // Adds the created Skills Class into the Resume
                                resume.addSkills(skills);
                            }
                        }
                        break;
                    }
                }
                resumes.put(name, resume);
                recruiterList.add(resume);

            }
        }

        //Prompts user to see if they want to change any personal information
        changeInput = "";
        while (!changeInput.equalsIgnoreCase("n")){
            System.out.println("Would you like to make changes to an existing resume? (y/n)");
            changeInput = scanner.nextLine();
            if (changeInput.equalsIgnoreCase("y")){

                //Getting the name on the resume
                //The name is the key of the HashMap so it is used to pull the correct Resume
                System.out.println("What is the name of the Resume:");
                resumeName = scanner.nextLine();

                //Section to change name
                System.out.println("Are you changing your name? (y/n)");
                String n = scanner.nextLine();
                if (n.equalsIgnoreCase("y")){
                    System.out.println("New Name:");
                    resumes.get(resumeName).personalInfo.get(0).setName(scanner.nextLine());
                }

                //Section to change email
                System.out.println("Are you changing your email? (y/n)");
                String e = scanner.nextLine();
                if (e.equalsIgnoreCase("y")){
                    System.out.println("New Email:");
                    resumes.get(resumeName).personalInfo.get(0).setEmail(scanner.nextLine());
                }

                //Section to change phone number
                System.out.println("Are you changing your phone number? (y/n)");
                String p = scanner.nextLine();
                if (p.equalsIgnoreCase("y")){
                    System.out.println("New Phone Number:");
                    resumes.get(resumeName).personalInfo.get(0).setPhone(scanner.nextLine());
                }
                resumes.get(resumeName);
            }
        }

        //Instantiates the Recruiter class
        Recruiter recruiter = new Recruiter();
        System.out.println("Are you a recruiter? (y/n)");
        String r = scanner.nextLine();
        if (r.equalsIgnoreCase("y")){
            System.out.println("What Skill are you looking for?");
            String s = scanner.nextLine();

            //Runs the skillCheck method with the ArrayList of resumes (the recruiterList) and the skill to check (s)
            recruiter.skillCheck(recruiterList, s);
        }


        //Prompts user to see if all resumes should be displayed
        System.out.println("Would you like to display the resumes? (y/n)");
        displayResume = scanner.nextLine();
        if (displayResume.equalsIgnoreCase("y")) {

            //Loop through each Resume in the HashMap and run displayResume method to print out info
            for (HashMap.Entry<String, Resume> resume : resumes.entrySet()) {
                resume.getValue().displayResume();
                System.out.println();

            }
        }

    }
}
