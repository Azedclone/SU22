
import java.util.ArrayList;

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

    public static void main(String[] args) throws Exception {
        //Declare variables and objects
        Display display = new Display();
        int choice;
        GetData getData = new GetData();
        DoctorManager doctorManager = new DoctorManager();
        ArrayList<Doctor> listDoctor = new ArrayList<>();

        while (true) {
            //1. Display menu
            display.displayMenu();
            //2. Promt user to choose function from 1->5
            choice = getData.getInt("Choose function from 1->5: ", 1, 5);

            //3. Perform function user have chose
            switch (choice) {
                case 1: //Add doctor
                    doctorManager.addDoctor(listDoctor);
                    break;
                case 2: //Update doctor
                    doctorManager.updateDoctor(listDoctor);
                    break;
                case 3: //Delete doctor
                    doctorManager.deleteDoctor(listDoctor);
                    break;
                case 4: //Search doctor
                    doctorManager.searchDoctor(listDoctor);
                    break;
                case 5: //Exit program
                    System.exit(0);
            }
        }
    }
}
