package com.exist.app;

import com.exist.app.util.PersonInfoUtil;
import com.exist.app.util.InputUtil;
import com.exist.dto.AddressDto;
import com.exist.dto.ContactDto;
import com.exist.dto.NameDto;
import com.exist.dto.PersonDto;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        new App().run();
    }

    public void run() {
        mainMenu();
    }

    public void mainMenu() {
        String menu = "\nPerson App: Main Menu " +
                "\n[1 List Person] [2 Add Person] [3 Update Person] [4 Delete Person] " +
                "\n[5 List Role] [6 Add Role] [7 Update Role] [8 Delete Role] [9 Exit]";
        boolean cont;
        do {
            cont = true;
            int opt = InputUtil.getOption(menu);
            switch (opt) {
                case 1:
                    listPerson();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    listRole();
                    break;
                case 6:
                    addRole();
                    break;
                case 7:
                    updateRole();
                    break;
                case 8:
                    deleteRole();
                    break;
                case 9:
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (cont);
        System.out.println("Exiting...");
    }

    public void deleteRole() {

    }

    public void updateRole() {

    }

    public void addRole() {

    }

    public void listRole() {

    }

    public void deletePerson() {

    }

    public void updatePerson() {
        PersonDto person = new PersonDto(); // Person from db
        System.out.println("Select information you would like to Update:");
        String menu = "[1 Name] [2 Address] [3 Birthdate] [4 GWA] [5 Employed]"
                + "\n[6 Contact Information] [7 Roles] [8 Back to Main Menu]";
        boolean valid;
        String editMenu = null;

        do {
            valid = true;
            int menuOpt = InputUtil.getOption(menu);
            // Get person ID
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

    public void listPerson() {
        String listPersonMenu = "List Person: [1 by GWA] [2 by Date Hired] [3 Last Name] [4 Back]";
        String orderMenu = "Order: [1 Ascending] [2 Descending]";
        boolean valid;
        boolean cont = true;

        do {
            valid = true;
            int menuOpt = InputUtil.getOption(listPersonMenu);
            switch (menuOpt) {
                case 1:
                    System.out.println("List Person by GWA:");
                    break;
                case 2:
                    System.out.println("List Person by Date Hired");
                    break;
                case 3:
                    System.out.println("List Person by Last Name");
                    break;
                case 4:
                    cont = false;
                    break;
                default:
                    valid = false;
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!valid);

        if (cont) {
            do {
                valid = true;
                int orderOpt = InputUtil.getOption(orderMenu);
                switch (orderOpt) {
                    case 1:
                        System.out.println("List in ascending order...");
                        break;
                    case 2:
                        System.out.println("List in descending order...");
                        break;
                    default:
                        valid = false;
                        System.out.println("Invalid option!");
                        break;
                }
            } while (!valid);
        }

    }

}
