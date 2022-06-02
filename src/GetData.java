
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Azedclone
 */
public class GetData {

    Scanner sc = new Scanner(System.in);

    int getInt(String msg, int min, int max) {
        String input;
        int num;

        //Only return when user enter valid input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //Check whether input is empty
            if (input.isEmpty()) {
                System.out.println("Could not be empty!");
            } else {
                try {
                    num = Integer.parseInt(input);

                    //Check input must in range
                    if (num >= min && num <= max) {
                        break;
                    } else {
                        System.out.println("Must be in range " + min + "->" + max);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Must be an integer");
                }
            }
        }

        return num;
    }

    String getString(String msg, String regex, String requirement) {
        String input;

        //Only return when user enter valid input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //Check whether user is empty
            if (input.isEmpty()) {
                System.out.println("Could not be empty!");
            } else {
                //Check input must match regular expression
                if (regex.isEmpty() || input.matches(regex)) {
                    break;
                } else {
                    System.out.println("Not match requirement!");
                    System.out.println(requirement);
                }
            }
        }

        return input;
    }

    String getString(String msg, String regex, String requirement, String origin) {
        String input;

        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //If empty then won't change anything
            if (input.isEmpty()) {
                input = origin;
            } else {
                if (regex.isEmpty() || input.matches(regex)) {
                    break;
                } else {
                    System.out.println("Not match");
                    System.out.println(requirement);
                }
            }
        }

        return input;
    }

    int getInt(String msg, int min, int max, int origin) {
        String input;
        int num;

        //Only return when user enter valid input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //Check whether input is empty
            if (input.isEmpty()) {
                num = origin;
                break;
            } else {
                try {
                    num = Integer.parseInt(input);

                    //Check input must in range
                    if (num >= min && num <= max) {
                        break;
                    } else {
                        System.out.println("Must be in range " + min + "->" + max);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Must be an integer");
                }
            }
        }

        return num;
    }
}
