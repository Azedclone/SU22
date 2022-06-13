
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
    
    GetData getData = new GetData();
    GenCaptcha genCaptcha = new GenCaptcha();
    
    void useVietnamese() {
        String captcha = genCaptcha.genCaptcha();
        Locale localeVi = new Locale("vi", "VN");
        login(localeVi, captcha);
    }
    
    private void login(Locale locale, String captcha) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        
        String accountNumber = getData.getAccountNumber(bundle.getString("accountNumber"), bundle.getString("invalidAccountNumber"));
        String password = getData.getPassword(bundle.getString("password"), bundle.getString("invalidPassword"));
        String captchaInput = getData.getCaptcha(captcha, bundle.getString("inputCaptcha"), bundle.getString("incorrectCaptcha"));
    }
}
