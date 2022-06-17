/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Azedclone
 */
public class Account {

    private String accountNumber;
    private String password;

    public Account() {
    }

    public Account(String accounNumber, String password) {
        this.accountNumber = accounNumber;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setAccounNumber(String accounNumber) {
        this.accountNumber = accounNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
