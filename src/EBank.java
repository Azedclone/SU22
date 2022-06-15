
import Account.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Azedclone
 */
public class EBank {

    ListAccount listAccount = new ListAccount();
    ArrayList<Account> database = listAccount.listAccount();

    GetData getData = new GetData();
    Captcha captcha = new Captcha();

    void useVietnamese() {
        Locale localeVi = new Locale("vi", "VN");
        login(localeVi);
    }

    void useEnglish() {
        Locale localeEn = new Locale("en", "US");
        login(localeEn);
    }

    private void login(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        String accountNumber = getData.getAccountNumber(bundle.getString("accountNumber"), bundle.getString("invalidAccountNumber"));
        String password = getData.getPassword(bundle.getString("password"), bundle.getString("invalidPassword"));
        captcha.handleCaptcha(bundle.getString("captcha"), bundle.getString("inputCaptcha"), bundle.getString("incorrectCaptcha"));

        Account account = new Account(accountNumber, password);
        boolean isExist = false;

        for (Account acc : database) {
            if (acc.getAccounNumber().equals(account.getAccounNumber()) && acc.getPassword().equals(account.getPassword())) {
                isExist = true;
            }
        }

        if (isExist) {
            System.out.println(bundle.getString("loginSuccess"));
        } else {
            System.out.println(bundle.getString("loginFail"));
        }
    }

}
