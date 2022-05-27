
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Formatter;
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
    int isExist(String code, ArrayList<Doctor> listDoctor) {
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
    void addDoctor(ArrayList<Doctor> listDoctor) throws Exception {
        //Check if list have load data
        if (listDoctor.isEmpty()) {
            //Load data from file to list
            loadDataToList(listDoctor);
        }
        
        String code = getData.getString("Enter code: ", "^[A-Z]{3}\\s{1}\\d{1,}$", "DOC 1");
        
        int index = isExist(code, listDoctor);
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
    }

    //Update doctor
    void updateDoctor(ArrayList<Doctor> listDoctor) throws Exception {
        //Check if list have load data
        if (listDoctor.isEmpty()) {
            loadDataToList(listDoctor);
        }
        
        String code = getData.getString("Enter code: ", "[A-Z]{3}\\s{1}\\d{1,}", "DOC 1");
        int index = isExist(code, listDoctor);

        //Continue only if code existed
        if (index != -1) {
            Doctor doctor = listDoctor.get(index);
            doctor.setName(getData.getString("Enter name: ", "^[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$", "Long", doctor.getName()));
            doctor.setSpecialization(getData.getString("Enter specialization: ", "^[A-Za-z]{1,}$", "orthopedics", doctor.getSpecialization()));
            doctor.setAvailability(getData.getInt("Enter availability: ", 0, Integer.MAX_VALUE, doctor.getAvailability()));
            
            saveDataToFile(listDoctor);
        }
    }
    
    //Delete doctor
    void deleteDoctor(ArrayList<Doctor> listDoctor) throws Exception {
        
    }
}
