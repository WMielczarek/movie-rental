/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dane.Dane;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Artur
 */
public class AccountTest {
    public static Dane dane;
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dane = new Dane();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testNewAccount() {
        System.out.println("new Account");
        for(int i = 0; i < 8; i++) {
            Account account = new Account(i, dane.dane_klientow[i][0], dane.dane_klientow[i][1], dane.dane_klientow[i][2]);

            assertEquals(i, account.getAccountID());
            assertEquals(dane.dane_klientow[i][0], account.getFirstName());
            assertEquals(dane.dane_klientow[i][1], account.getLastName());
            assertEquals(dane.dane_klientow[i][2], account.getEmail());
        }
    }
}
