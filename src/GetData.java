
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

    int getChoice(String msg, int min, int max) {
        String input;
        int num;

        //Loop until user enter valid input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //Check input is empty or not
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty");
            } else {
                try {
                    num = Integer.parseInt(input);

                    //Check input in range (min, max)
                    if (num >= min && num <= max) {
                        return num;
                    } else {
                        System.out.println("Input must in range (" + min + ", " + max + ")");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input must be an integer!");
                }
            }
        }
    }

    String getAccountNumber(String msg, String errorMsg) {
        String input;

        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //Check input must matches require
            if (!input.matches("^\\d{10}$")) {
                System.out.println(errorMsg);
            } else {
                return input;
            }
        }
    }

    String getPassword(String msg, String errorMsg) {
        String input;

        while (true) {
            System.out.print(msg);
            input = sc.nextLine();

            //Check input must matches require
            if (!input.matches("^\\w{8,31}$")) {
                System.out.println(errorMsg);
            } else {
                return input;
            }
        }
    }

}
