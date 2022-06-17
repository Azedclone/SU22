
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

    AccountDatabase accountDatabase = new AccountDatabase();
    ArrayList<Account> data = accountDatabase.getAccountDatabase();
    GetData getData = new GetData();
    ProcessCaptcha processCaptcha = new ProcessCaptcha();

    void useVietnamese() {
        Locale localeVi = new Locale("vi");
        login(localeVi);
    }

    void useEnglish() {
        Locale localeEn = new Locale("en");
        login(localeEn);
    }

    private void login(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        String accountNumber = getData.getAccountNumber(bundle.getString("accountNumber"), bundle.getString("invalidAccountNumber"));
        String password = getData.getPassword(bundle.getString("password"), bundle.getString("invalidPassword"));
        processCaptcha.handleCaptcha(bundle.getString("captcha"), bundle.getString("inputCaptcha"), bundle.getString("incorrectCaptcha"));

        Account account = new Account(accountNumber, password);
        boolean isExist = false;

        for (Account acc : data) {
            if (acc.getAccountNumber().equals(account.getAccountNumber()) && acc.getPassword().equals(account.getPassword())) {
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
