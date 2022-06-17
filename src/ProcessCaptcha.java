
import java.util.Random;
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
public class ProcessCaptcha {

    Scanner sc = new Scanner(System.in);

    String genCaptcha() {
        char data[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
        String captcha = "";
        Random random = new Random();

        for (int i = 0; i < 5; ++i) {
            int index = random.nextInt(data.length);
            captcha += data[index];
        }

        return captcha;
    }

    void handleCaptcha(String msg, String inputMsg, String errorMsg) {
        String captcha = genCaptcha();
        String input;
        //Loop until user enter correct captcha
        while (true) {
            System.out.println(msg + captcha);
            System.out.print(inputMsg);

            input = sc.nextLine();
            if (!input.matches(captcha)) {
                System.out.println(errorMsg);
            } else {
                break;
            }
        }
    }
}
