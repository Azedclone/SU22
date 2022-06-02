
import java.util.ArrayList;
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
public class DoctorManager {

    Display display = new Display();
    IOFile ioFile = new IOFile();
    GetData getData = new GetData();

    //Check if code has existed
    int findIndex(String code, ArrayList<Doctor> listDoctor) {
        int index = -1;

        //Look for index of code if it existed
        for (Doctor doctor : listDoctor) {
            if (doctor.getCode().equals(code)) {
                index = listDoctor.indexOf(doctor);
                break;
            }
        }

        return index;
    }

    //Add doctor
    void addDoctor(ArrayList<Doctor> listDoctor) {
        try {
            //Check if list have load data
            if (listDoctor.isEmpty()) {
                //Load data from file to list
                ioFile.loadDataToList(listDoctor);
            }

            String code = getData.getString("Enter code: ", "^\\w+$", "Must contain only number and letter");

            int index = findIndex(code, listDoctor);
            //Continue only if code does not existed
            if (index == -1) {
                String name = getData.getString("Enter name: ", "^[a-zA-Z\\s]+$", "Must contain only letter");
                String specialization = getData.getString("Enter specialization: ", "^[a-zA-Z\\s]+$", "Must contain only letter");
                int availability = getData.getInt("Enter availability: ", 0, Integer.MAX_VALUE);

                Doctor doctor = new Doctor(code, name, specialization, availability);
                listDoctor.add(doctor);
                ioFile.saveDataToFile(listDoctor);
            } else {
                System.out.println("Code has been existed!");
            }
        } catch (Exception e) {
            System.out.println("Error in addDoctor!");
        }
    }

    //Update doctor
    void updateDoctor(ArrayList<Doctor> listDoctor) {
        try {
            //Check if list have load data
            if (listDoctor.isEmpty()) {
                ioFile.loadDataToList(listDoctor);
            }

            String code = getData.getString("Enter code: ", "^\\w+$", "Must contain only number and letter");
            int index = findIndex(code, listDoctor);

            //Continue only if code existed
            if (index != -1) {
                Doctor doctor = listDoctor.get(index);
                doctor.setName(getData.getString("Enter name: ", "^[a-zA-Z\\s]+$", "Must contain only letter", doctor.getName()));
                doctor.setSpecialization(getData.getString("Enter specialization: ", "^[a-zA-Z\\s]+$", "Must contain only letter", doctor.getSpecialization()));
                doctor.setAvailability(getData.getInt("Enter availability: ", 0, Integer.MAX_VALUE, doctor.getAvailability()));

                ioFile.saveDataToFile(listDoctor);
            }
        } catch (Exception e) {
            System.out.println("Error in updateDoctor!");
        }
    }

    //Delete doctor
    void deleteDoctor(ArrayList<Doctor> listDoctor) {
        try {
            //Check if list have load data
            if (listDoctor.isEmpty()) {
                ioFile.loadDataToList(listDoctor);
            }

            String code = getData.getString("Enter code: ", "^\\w+$", "Must contain only number and letter");
            int index = findIndex(code, listDoctor);

            if (index != -1) {
                listDoctor.remove(index);
                ioFile.saveDataToFile(listDoctor);
            }
        } catch (Exception e) {
            System.out.println("Error in deleteDoctor!");
        }
    }

    //Search doctor
    void searchDoctor(ArrayList<Doctor> listDoctor) {
        try {
            //Check if list have load data
            if (listDoctor.isEmpty()) {
                ioFile.loadDataToList(listDoctor);
            }
            Scanner sc = new Scanner(System.in);
            ArrayList<Doctor> listResult = new ArrayList<>();

            String nameSearch;
            while (true) {
                System.out.print("Enter text: ");
                nameSearch = sc.nextLine();

                if (nameSearch.isEmpty()) {
                    display.displayResult(listDoctor);
                    break;
                } else {
                    if (nameSearch.matches("^[a-zA-Z\\s]+$")) {
                        for (Doctor doctor : listDoctor) {
                            if (doctor.getName().equals(nameSearch)) {
                                listResult.add(doctor);
                            }
                        }
                        display.displayResult(listResult);
                        break;
                    } else {
                        System.out.println("Not match requirement!");
                        System.out.println("Must contain only letter");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error in searchDoctor!");
        }
    }
}
