/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy;
import fit.ColumnFixture;
import java.util.*;
import kod.Account;

/**
 *
 * @author Wojtek Mielczarek
 */
public class fitnesse_addAccount extends ColumnFixture {

    String dane[];

    public boolean addAccount() {
        int s1 = accountAmount();
        SetUp.aplikacja.addAccount(dane[0], dane[1], dane[2]);
        int s2 = accountAmount();
        if (s1 == s2) {
            return false;
        } else {
            return true;
        }

    }
    //
    public int accountAmount() {
        ArrayList<Account> lista; //fitnesse nie radzi sobie z wczytaniem listy kont z applikacji,trzeba tworzyc ja na nowo
        lista=SetUp.aplikacja.getAccounts();
        return lista.size();
        //return SetUp.aplikacja.getAccounts().size(); //fitnesse ma problem idk why
    }
}
