package com.exist.app;

import com.exist.app.Menu;
import com.exist.app.util.InputUtil;
import com.exist.app.util.PersonInfoUtil;
import com.exist.dto.PersonDto;
import com.exist.services.impl.PersonServiceImpl;

public class App {
    
    public static void main(String[] args) {
        new App().run();
    }

    public void run() {
        new App().mainMenu();
    }

    public void mainMenu() {
        new Menu().mainMenu();
    }

    public void deleteRole() {
        System.out.println("[Delete Role]");
    }

    public void updateRole() {

    }

    public void addRole() {

    }

    public void listRole() {

    }

    public void deletePerson() {
        System.out.println("[DELETE Person]");
        System.out.print("Input ID of Person to DELETE: ");
        // ID input from user
        // Display person to delete
    }

    public void updatePerson() {
        PersonDto person = new PersonDto(); //Person from db
        System.out.println("[UPDATE Person Info]");
        System.out.println("Select information you would like to Update:");
        String menu = "[1 Name] [2 Address] [3 Birthdate] [4 GWA] [5 Employed]"
                + "\n[6 Contact Information] [7 Roles] [8 Back to Main Menu]";
        boolean valid;

        do {
            valid = true;
            int menuOpt = InputUtil.getOption(menu);
            // Get person ID to update
            switch (menuOpt){
                case 1: 
                    System.out.println("Update NAME: "); //Print current
                    person.setName(PersonInfoUtil.addName());
                    break;
                case 2: 
                    System.out.println("Update ADDRESS: "); //Print current
                    person.setAddress(PersonInfoUtil.addAddress());
                    break;
                case 3:
                    System.out.println("Update Bithdate: "); // Print current
                    person.setBirthDate(PersonInfoUtil.addBirthDate());
                    break;
                case 4:
                    System.out.println("Update GWA: "); // Print current
                    person.setGwa(PersonInfoUtil.addGwa());
                    break;
                case 5:
                    System.out.println("Update Employment Status: "); //Print Current
                    person.setCurrentlyEmployed(PersonInfoUtil.addEmploymentStatus());
                    break;
                case 6:
                    System.out.println("Edit contacts: "); //Print Current
                    person.getContactInfo().add(PersonInfoUtil.addContact());
                    break;
                case 7:
                    System.out.println("Update Roles: "); //Print Current
                    //List roles
                    break;
                case 8: 
                    break;
                default:
                    valid = false;
                    break;
            }
        } while (!valid);
        //Print updated person
    }

    public void addPerson() {
        System.out.println("Add a Person:");

        PersonDto person = new PersonDto();

        person.setName(PersonInfoUtil.addName());
        person.setAddress(PersonInfoUtil.addAddress());
        person.setBirthDate(PersonInfoUtil.addBirthDate());
        person.setGwa(PersonInfoUtil.addGwa());
        person.setCurrentlyEmployed(PersonInfoUtil.addEmploymentStatus());
        person.getContactInfo().add(PersonInfoUtil.addContact());
        //Add Role

    }


}
