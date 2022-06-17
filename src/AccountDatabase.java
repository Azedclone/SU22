
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
public class AccountDatabase {

    ArrayList getAccountDatabase() {
        ArrayList<Account> accountDatabase = new ArrayList<>();
        accountDatabase.add(new Account("0123456789", "longdeptraithe"));
        accountDatabase.add(new Account("0012020267", "Aloaloxyz"));
        
        return accountDatabase;
    }
}
