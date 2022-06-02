
import java.io.*;
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
public class IOFile {

    File file = new File("src\\data.txt");

    //Load all doctor to list
    void loadDataToList(ArrayList<Doctor> listDoctor) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    if (fileInputStream.available() != 0) {
                        listDoctor.add((Doctor) objectInputStream.readObject());
                    } else {
                        break;
                    }
                }
            } else {
                file.createNewFile();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error in loadDataToList!");
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Can't close stream");
            }
        }
    }

    //Save all doctor to file
    void saveDataToFile(ArrayList<Doctor> listDoctor) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Doctor doctor : listDoctor) {
                objectOutputStream.writeObject(doctor);
            }
        } catch (IOException e) {
            System.out.println("Error in saveDataToFile!");
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Can't close stream!");
            }
        }
    }
}
