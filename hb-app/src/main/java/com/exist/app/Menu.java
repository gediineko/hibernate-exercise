package com.exist.app;

import com.exist.app.util.InputUtil;
import com.exist.services.PersonService;
import com.exist.services.impl.PersonServiceImpl;

/**
 * Created by ggolong on 8/10/16.
 */
public class Menu{

    PersonService personService = new PersonServiceImpl();

    public void mainMenu(){
        String mainMenu = "\nMain Menu: [1 Person Management] [2 Role Management] [3 Exit]";
        int mainMenuOpt;
        boolean cont;
        do {
            cont = true;
            mainMenuOpt = InputUtil.getOption(mainMenu);
            switch (mainMenuOpt) {
                case 1:
                    personMenu();
                    break;
                case 2:
                    roleMenu();
                    break;
                case 3:
                    cont = false;
                    break;
                default:
                    System.out.print("Invalid input!");
                    break;
            }
        } while (cont);
        System.out.println("Exiting...");
    }

    public void personMenu(){
        String personMenu = "[Person Management]\n[1 List Person] [2 Add Person] [3 View Person] [4 Back]";
        int personMenuOpt;
        boolean valid;
        do {
            valid = true;
            personMenuOpt = InputUtil.getOption(personMenu);
            try {
                switch (personMenuOpt) {
                    case 1:
                        System.out.println("[ID]\t[NAME]\t[ADDRESS]");
                        personService.findAll(listPersonByMenu(), listOrderMenu());
                        break;
                    case 2:

                        break;
                    case 3:
                        //view person
                        //input id of person
                        break;
                    case 4:
                        //Go back to main menu
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception ex) {
                valid = false;
                System.out.println("Invalid option!");
            }
        } while (!valid);
    }

    public String listPersonByMenu() {
        String listByMenu = "[List Person]\n[1 by GWA] [2 by Date Hired] [3 by Last Name]";
        int listByMenuOpt;
        boolean valid;
        String listBy = null;
        do {
            valid = true;
            listByMenuOpt = InputUtil.getOption(listByMenu);
            try {
                switch (listByMenuOpt){
                    case 1:
                        System.out.print("[List Person by GWA]");
                        listBy = "gwa";
                        break;
                    case 2:
                        System.out.print("[List Person by Date Hired]");
                        listBy = "dateHired";
                        break;
                    case 3:
                        System.out.print("[List Person by Last Name]");
                        listBy = "name.lastName";
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception ex){
                valid = false;
                System.out.println("Invalid option!");
            }
        } while (!valid);
        return listBy;
    }

    public String listOrderMenu() {
        String listOrderMenu = "\n[1 Ascending] [2 Descending]";
        int listOrderOpt;
        boolean valid;
        String order = null;
        do {
            valid = true;
            listOrderOpt = InputUtil.getOption(listOrderMenu);
            try {
                switch (listOrderOpt){
                    case 1:
                        order = "asc";
                        break;
                    case 2:
                        order = "desc";
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception ex){
                valid = false;
                System.out.printf("Invalid option!");
            }
        } while (!valid);
        return order;
    }

    public String viewPerson(){
        String viewPersonId = InputUtil.getInfo("Person ID");
        return viewPersonId;
    }

    // Role Menu
    public void roleMenu() {
        String roleMenu = "[Role Management]\n[1 List Roles] [2 Add Role] [3 View Roles] [4 Back]";
        int roleMenuOpt;
        boolean valid;
        do {
            valid = true;
            roleMenuOpt = InputUtil.getOption(roleMenu);
            try {
                switch (roleMenuOpt) {
                    case 1:
                        //list role
                        break;
                    case 2:
                        //add role
                        break;
                    case 3:
                        //view role
                        break;
                    case 4:
                        //Go back to main menu
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception ex){
                valid = false;
                System.out.println("Invalid option!");
            }
        } while (!valid);
    }
}
