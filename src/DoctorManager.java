
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;

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
    GetData getData = new GetData();
    File file = new File("src\\data.txt");

    //Load data from file to list
    void loadDataToList(ArrayList<Doctor> listDoctor) throws Exception {

        //Check if file is exist
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;

                //Continue until end of file
                while ((line = br.readLine()) != null) {
                    StringTokenizer data = new StringTokenizer(line, "|");
                    listDoctor.add(new Doctor(data.nextToken().trim(), data.nextToken().trim(), data.nextToken().trim(), Integer.parseInt(data.nextToken().trim())));
                }

                Collections.sort(listDoctor, new Comparator<Doctor>() {
                    @Override
                    public int compare(Doctor o1, Doctor o2) {
                        double s = o1.getCode().compareTo(o2.getCode());
                        if (s > 0) {
                            return 1;
                        }
                        if (s < 0) {
                            return -1;
                        }
                        return 0;
                    }
                });

            } catch (FileNotFoundException e) {
                System.out.println("Can't find file");
            }
        } else {
            file.createNewFile();
        }
    }

    //Append data to end of file
    void appendDataToFile(Doctor doctor) throws Exception {

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(String.format("%s|%s|%s|%d\r\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability()));

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    //Save all data from list to file
    void saveDataToFile(ArrayList<Doctor> listDoctor) throws Exception {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            Collections.sort(listDoctor, new Comparator<Doctor>() {
                @Override
                public int compare(Doctor o1, Doctor o2) {
                    double s = o1.getCode().compareTo(o2.getCode());
                    if (s > 0) {
                        return 1;
                    }
                    if (s < 0) {
                        return -1;
                    }
                    return 0;
                }
            });

            //Write data to file
            for (Doctor doctor : listDoctor) {
                bw.write(String.format("%s|%s|%s|%d\r\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability()));
            }

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

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
                loadDataToList(listDoctor);
            }

            String code = getData.getString("Enter code: ", "^[A-Z]{3}\\s{1}\\d{1,}$", "DOC 1");

            int index = findIndex(code, listDoctor);
            //Continue only if code does not existed
            if (index == -1) {
                String name = getData.getString("Enter name: ", "^[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$", "Vu Thanh Long");
                String specialization = getData.getString("Enter specialization: ", "^[A-Za-z]{1,}$", "orthopedics");
                int availability = getData.getInt("Enter availability: ", 0, Integer.MAX_VALUE);

                Doctor doctor = new Doctor(code, name, specialization, availability);
                listDoctor.add(doctor);
                appendDataToFile(doctor);
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
                loadDataToList(listDoctor);
            }

            String code = getData.getString("Enter code: ", "[A-Z]{3}\\s{1}\\d{1,}", "DOC 1");
            int index = findIndex(code, listDoctor);

            //Continue only if code existed
            if (index != -1) {
                Doctor doctor = listDoctor.get(index);
                doctor.setName(getData.getString("Enter name: ", "^[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$", "Long", doctor.getName()));
                doctor.setSpecialization(getData.getString("Enter specialization: ", "^[A-Za-z]{1,}$", "orthopedics", doctor.getSpecialization()));
                doctor.setAvailability(getData.getInt("Enter availability: ", 0, Integer.MAX_VALUE, doctor.getAvailability()));

                saveDataToFile(listDoctor);
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
                loadDataToList(listDoctor);
            }

            String code = getData.getString("Enter code: ", "[A-Z]{3}\\s{1}\\d{1,}", "DOC 1");
            int index = findIndex(code, listDoctor);

            if (index != -1) {
                listDoctor.remove(index);
                saveDataToFile(listDoctor);
            }
        } catch (Exception e) {
            System.out.println("Error in deleteDoctor!");
        }
    }

    //Search doctor
    void searchDoctor(ArrayList<Doctor> listDoctor) {
        try {
            Scanner sc = new Scanner(System.in);
            ArrayList<Doctor> listResult = new ArrayList<>();
            //Check if list have load data
            if (listDoctor.isEmpty()) {
                loadDataToList(listDoctor);
            }

            String nameSearch;
            while (true) {
                System.out.print("Enter text: ");
                nameSearch = sc.nextLine();

                if (nameSearch.isEmpty()) {
                    display.displayResult(listDoctor);
                    break;
                } else {
                    if (nameSearch.matches("^[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$")) {
                        for (Doctor doctor : listDoctor) {
                            if (doctor.getName().equals(nameSearch)) {
                                listResult.add(doctor);
                            }
                        }
                        break;
                    } else {
                        System.out.println("Not match!");
                        System.out.println("Format is Long");
                    }
                }
            }

            display.displayResult(listResult);
        } catch (Exception e) {
            System.out.println("Error in searchDoctor!");
        }
    }
}
