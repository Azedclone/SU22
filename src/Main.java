/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Azedclone
 */
public class Main {

    public static void main(String[] args) {
        //Declare variables and objects
        Display display = new Display();
        GetData getData = new GetData();
        EBank eBank = new EBank();

        //Loop until user choose exit program
        while (true) {
            //1. Display menu
            display.displayMenu();

            //2. Ask user to choose an option
            int choice = getData.getChoice("Please choose an option: ", 1, 3);

            //3. Perform option user have chose
            switch (choice) {
                case 1: //Interface use Vietnamese
                    eBank.useVietnamese();
                    break;
                case 2: //Interface use English
                    eBank.useEnglish();
                    break;
                case 3: //Exit program
                    System.exit(0);
            }
        }
    }
}
