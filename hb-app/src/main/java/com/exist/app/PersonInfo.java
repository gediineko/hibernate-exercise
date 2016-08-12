package com.exist.app;

import com.exist.app.util.InputUtil;
import com.exist.dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PersonInfo{

    public void addPerson() {
        System.out.println("Add a Person:");
        PersonDto person = new PersonDto();
        person.setName(addName());
        person.setAddress(addAddress());
        person.setBirthDate(addBirthDate());
        person.setGwa(addGwa());
        person.setCurrentlyEmployed(addEmploymentStatus());
    }

	public static NameDto addName(){
        System.out.println("[Name]");
        String firstName = InputUtil.getInfo("First Name", true);
        String middleName = InputUtil.getInfo("Middle Name");
        String lastName = InputUtil.getInfo("Last Name", true);
        String title = InputUtil.getInfo("Title");
        String suffix = InputUtil.getInfo("Suffix");
        return new NameDto(firstName, middleName, lastName, suffix, title);
    }

    public static AddressDto addAddress(){
        System.out.println("[Address]");
        String streetNumber = InputUtil.getInfo("Street Number");
        String barangay = InputUtil.getInfo("Barangay");
        String city = InputUtil.getInfo("City", true);
        String zipCode = InputUtil.getInfo("Zip Code");
        return new AddressDto(streetNumber, barangay, city, zipCode);
    }

    public static LocalDate addBirthDate(){
        System.out.println("[Birth date] format: m/d/yyyy");
        return InputUtil.getDate();
    }

    public static Double addGwa(){
        System.out.println("[GWA] format: n.nn");
        return null; //Input gwa
    }

    public static Boolean addEmploymentStatus(){
        System.out.println("Currently employed? [1 Yes] [2 No]");
        return InputUtil.getEmploymentStatus();
    }

    public static List<ContactDto> addContact(){
        System.out.println("[Contact Info]");
        String landLine = InputUtil.getInfo("Land Line");
        String mobileNumber = InputUtil.getInfo("Mobile Number");
        String email = InputUtil.getInfo("Email");
        ContactDto contactDto = new ContactDto(landLine, mobileNumber, email);
        List<ContactDto> contactDtoList = new ArrayList<>();
        contactDtoList.add(contactDto);
        return contactDtoList;
    }

    public static void addRole(Set<RoleDto> roleDtoSet){
        String name = InputUtil.getInfo("Role");
        RoleDto roleDto = new RoleDto();
        roleDtoSet.add(roleDto);
    }

}