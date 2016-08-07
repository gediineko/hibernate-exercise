package com.exist.app;


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

    private void deleteRole() {

    }

    private void updateRole() {

    }

    private void addRole() {

    }

    private void listRole() {

    }

    private void deletePerson() {

    }

    private void updatePerson() {

    }

    private void addPerson() {
        System.out.println("Add a Person:");
        PersonDto person = new PersonDto();

        System.out.println("[Name]");
        String firstName = InputUtil.getInfo("First Name", true);
        String middleName = InputUtil.getInfo("Middle Name");
        String lastName = InputUtil.getInfo("Last Name", true);
        String title = InputUtil.getInfo("Title");
        String suffix = InputUtil.getInfo("Suffix");
        NameDto name = new NameDto(firstName, middleName, lastName, suffix, title);
        person.setName(name);

        System.out.println("[Address]");
        String streetNumber = InputUtil.getInfo("Street Number");
        String barangay = InputUtil.getInfo("Barangay");
        String city = InputUtil.getInfo("City", true);
        String zipCode = InputUtil.getInfo("Zip Code");
        AddressDto address = new AddressDto(streetNumber, barangay, city, zipCode);
        person.setAddress(address);

        System.out.println("[Birth date] format: m/d/yyyy");
        LocalDate birthDate = InputUtil.getDate();
        person.setBirthDate(birthDate);

        System.out.println("[GWA] format: n.nn");

        System.out.println("Currently employed? [1 Yes] [2 No]");
        Boolean employmentStatus = InputUtil.getEmploymentStatus();
        person.setCurrentlyEmployed(employmentStatus);

        System.out.println("[Contact Info]");
        String landLine = InputUtil.getInfo("Land Line");
        String mobileNumber = InputUtil.getInfo("Mobile Number");
        String email = InputUtil.getInfo("Email");
        ContactDto contact = new ContactDto(landLine, mobileNumber, email);
        person.getContactInfo().add(contact);

        System.out.println("[Role]");
        String roleName = InputUtil.getInfo("Role");


    }

    private void listPerson() {
        String listPersonMenu = "List Person: [1 by GWA] [2 by Date Hired] [3 Last Name]";
        String orderMenu = "Order: [1 Ascending] [2 Descending]";
        boolean valid;

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
                default:
                    valid = false;
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!valid);

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
