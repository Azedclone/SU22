
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
public class Display {

    void displayMenu() {
        System.out.println("======== Doctor Management ========");
        System.out.println("\t1. Add Doctor");
        System.out.println("\t2. Update Doctor");
        System.out.println("\t3. Delete Doctor");
        System.out.println("\t4. Search Doctor");
        System.out.println("\t5. Exit");
    }

    void displayResult(ArrayList<Doctor> listDoctor) {
        System.out.println("------ Result ------");
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : listDoctor) {
            System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }
}
