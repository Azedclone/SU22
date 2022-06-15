/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

/**
 *
 * @author Azedclone
 */
public class Account {

    private String accounNumber;
    private String password;

    public Account() {
    }

    public Account(String accounNumber, String password) {
        this.accounNumber = accounNumber;
        this.password = password;
    }

    public String getAccounNumber() {
        return accounNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setAccounNumber(String accounNumber) {
        this.accounNumber = accounNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
