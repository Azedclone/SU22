/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.util.ArrayList;

/**
 *
 * @author Azedclone
 */
public class ListAccount {

    public ArrayList listAccount() {
        ArrayList<Account> listAccount = new ArrayList<>();
        listAccount.add(new Account("1234567890", "long123456"));

        return listAccount;
    }
}
