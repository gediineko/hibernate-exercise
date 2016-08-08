package com.exist.app.util;

import com.exist.app.util.InputUtil;
import com.exist.dto.AddressDto;
import com.exist.dto.ContactDto;
import com.exist.dto.NameDto;
import com.exist.dto.PersonDto;

import java.util.List;
import java.time.LocalDate;

public class PersonInfoUtil{

	public static NameDto addName(){
        System.out.println("[Name]");
        String firstName = InputUtil.getInfo("First Name", true);
        String middleName = InputUtil.getInfo("Middle Name");
        String lastName = InputUtil.getInfo("Last Name", true);
        String title = InputUtil.getInfo("Title");
        String suffix = InputUtil.getInfo("Suffix");
        NameDto name = new NameDto(firstName, middleName, lastName, suffix, title);
        return name;
    }

    public static AddressDto addAddress(){
        System.out.println("[Address]");
        String streetNumber = InputUtil.getInfo("Street Number");
        String barangay = InputUtil.getInfo("Barangay");
        String city = InputUtil.getInfo("City", true);
        String zipCode = InputUtil.getInfo("Zip Code");
        AddressDto address = new AddressDto(streetNumber, barangay, city, zipCode);
        return address;
    }

    public static LocalDate addBirthDate(){
        System.out.println("[Birth date] format: m/d/yyyy");
        LocalDate birthDate = InputUtil.getDate();
        return birthDate;
    }

    public static Double addGwa(){
        System.out.println("[GWA] format: n.nn");
        Double gwa = null; //Input gwa
        return gwa;
    }

    public static Boolean addEmploymentStatus(){
        System.out.println("Currently employed? [1 Yes] [2 No]");
        Boolean employmentStatus = InputUtil.getEmploymentStatus();
        return employmentStatus;
    }

    public static ContactDto addContact(){
        System.out.println("[Contact Info]");
        String landLine = InputUtil.getInfo("Land Line");
        String mobileNumber = InputUtil.getInfo("Mobile Number");
        String email = InputUtil.getInfo("Email");
        ContactDto contact = new ContactDto(landLine, mobileNumber, email);
        return contact;
    }

    //Add Role Method

}