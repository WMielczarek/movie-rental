/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dane.Dane;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Artur
 */
public class TitleTest {
    public static Dane dane;
    
    public TitleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dane = new Dane();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testNewTitle() {
        System.out.println("new Title");
        for(int i = 0; i < 4; i++) {
            Title title = new Title(dane.dane_filmy[i][0], dane.dane_filmy[i][1], dane.dane_filmy[i][2], Integer.parseInt(dane.dane_filmy[i][3]), Integer.parseInt(dane.dane_filmy[i][4]));

            assertEquals(dane.dane_filmy[i][0], title.getTitle());
            assertEquals(dane.dane_filmy[i][1], title.getDirector());
            assertEquals(dane.dane_filmy[i][2], title.getCompany());
            assertEquals(Integer.parseInt(dane.dane_filmy[i][3]), title.getYear());
            assertEquals(Integer.parseInt(dane.dane_filmy[i][4]), title.getDvds().size());
        }
    }
}
