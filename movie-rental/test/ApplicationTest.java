/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import kod.*;
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
public class ApplicationTest {
    public static Dane dane;
    public static Application app;
    
    public ApplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dane = new Dane();
        app = new Application();
        
        for(int i = 0; i < 4; i++) {
            app.addTitle(dane.dane_filmy[i][0], dane.dane_filmy[i][1], dane.dane_filmy[i][2], Integer.parseInt(dane.dane_filmy[i][3]), Integer.parseInt(dane.dane_filmy[i][4]));
        }
        
        for(int i = 0; i < 8; i++) {
            app.addAccount(dane.dane_klientow[i][0], dane.dane_klientow[i][1], dane.dane_klientow[i][2]);
        }
         
    }
    
    @Test
    public void testSearchTitle() {
        System.out.println("searchTitle");
        
        for(int i = 0; i < 4; i++) {
            Title title = app.searchTitle(new Title(dane.dane_filmy[i][0]));
            
            assertEquals(dane.dane_filmy[i][0], title.getTitle());
            assertEquals(dane.dane_filmy[i][1], title.getDirector());
            assertEquals(dane.dane_filmy[i][2], title.getCompany());
            assertEquals(Integer.parseInt(dane.dane_filmy[i][3]), title.getYear());
            assertEquals(Integer.parseInt(dane.dane_filmy[i][4]), title.getDvds().size());
        }
    }
    
    @Test
    public void testSearchAccount() {
        System.out.println("searchAccount");

        for(int i = 0; i < 8; i++) {
            Account account = app.searchAccount(new Account(i+1));
            
            assertEquals(i+1, account.getAccountID());
            assertEquals(dane.dane_klientow[i][0], account.getFirstName());
            assertEquals(dane.dane_klientow[i][1], account.getLastName());
            assertEquals(dane.dane_klientow[i][2], account.getEmail());
        }
    }
    
    @Test
    public void testAddReservationSameDate() {
        System.out.println("AddReservationSameDate");
        
        for(int i = 0; i < 4; i++) {
            Date d = new Date(dane.dane_daty[0][0][0], dane.dane_daty[0][0][1], dane.dane_daty[0][0][2]);
            Date d2 = new Date(dane.dane_daty[0][1][0], dane.dane_daty[0][1][1], dane.dane_daty[0][1][2]);
            System.out.println(d.toString());
            System.out.println(d2.toString());
            Reservation r1 = app.addReservation(dane.dane_filmy[i][0], i+1, new Date(dane.dane_daty[0][0][0], dane.dane_daty[0][0][1], dane.dane_daty[0][0][2]), new Date(dane.dane_daty[0][1][0], dane.dane_daty[0][1][1], dane.dane_daty[0][1][2]) );
            Reservation r2 = app.addReservation(dane.dane_filmy[i][0], i+1, new Date(dane.dane_daty[0][0][0], dane.dane_daty[0][0][1], dane.dane_daty[0][0][2]), new Date(dane.dane_daty[0][1][0], dane.dane_daty[0][1][1], dane.dane_daty[0][1][2]) );
            
            assertEquals(null, r2);
        }
    }
    
        @Test
    public void testAddReservationBeforeDate() {
        System.out.println("AddReservationBeforeDate");
        
        for(int i = 0; i < 4; i++) {
            Reservation r1 = app.addReservation(dane.dane_filmy[i][0], i+1, new Date(dane.dane_daty[0][0][0], dane.dane_daty[0][0][1], dane.dane_daty[0][0][2]), new Date(dane.dane_daty[0][1][0], dane.dane_daty[0][1][1], dane.dane_daty[0][1][2]) );
            Reservation r2 = app.addReservation(dane.dane_filmy[i][0], i+1, new Date(dane.dane_daty[1][0][0], dane.dane_daty[1][0][1], dane.dane_daty[1][0][2]), new Date(dane.dane_daty[1][1][0], dane.dane_daty[1][1][1], dane.dane_daty[1][1][2]) );
            
            assertNotEquals(null, r2);
        }
    }
    
        @Test
    public void testAddReservationAfterDate() {
        System.out.println("AddReservationBeforeDate");
        
        for(int i = 0; i < 4; i++) {
            Reservation r1 = app.addReservation(dane.dane_filmy[i][0], i+1, new Date(dane.dane_daty[0][0][0], dane.dane_daty[0][0][1], dane.dane_daty[0][0][2]), new Date(dane.dane_daty[0][1][0], dane.dane_daty[0][1][1], dane.dane_daty[0][1][2]) );
            Reservation r2 = app.addReservation(dane.dane_filmy[i][0], i+1, new Date(dane.dane_daty[2][0][0], dane.dane_daty[2][0][1], dane.dane_daty[2][0][2]), new Date(dane.dane_daty[2][1][0], dane.dane_daty[2][1][1], dane.dane_daty[2][1][2]) );
            
            assertNotEquals(null, r2);
        }
    }

    
}
