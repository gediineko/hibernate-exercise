package com.exist.app.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int getOption(String menu) {
        System.out.println(menu);
        int opt = 0;
        try {
            opt = scanner.nextInt();
        } catch (InputMismatchException | IllegalArgumentException ex) {
            //Exception handled by switch default
        }
        scanner.nextLine();
        return opt;
    }

    public static String getInfo(String info) {
        System.out.print(info + ": ");
        return scanner.nextLine();
    }

    public static String getInfo(String info, boolean required) {
        String newInfo;
        boolean valid;
        do {
            valid = true;
            newInfo = getInfo(info);
            if (required && StringUtils.isBlank(newInfo)) {
                valid = false;
                System.out.println("This field is required!");
            }
        } while (!valid);
        return newInfo;
    }

    public static LocalDate getDate() {
        LocalDate date = null;
        boolean valid;
        do {
            valid = true;
            String strDate = scanner.nextLine();
            try {
                if (strDate.matches("([1-9]|1[0-2])/([1-9]|[12][\\d]|3[01])/\\d{4}")) {
                    List<Integer> dateArgs = Arrays.asList(strDate.split("/")).stream().map(Integer::valueOf).collect(Collectors.toList());
                    date = LocalDate.of(dateArgs.get(2), dateArgs.get(0), dateArgs.get(1));
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                valid = false;
                System.out.println("Invalid input!");
            }
        } while (!valid);
        return date;
    }

    public static Boolean getEmploymentStatus() {
        boolean valid;
        Boolean isEmployed = false;
        do {
            valid = true;
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    isEmployed = true;
                    break;
                case 2:
                    isEmployed = false;
                    break;
                default:
                    valid = false;
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!valid);
        return isEmployed;
    }
}
