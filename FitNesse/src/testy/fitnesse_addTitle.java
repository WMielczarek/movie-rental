/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy;
import fit.ColumnFixture;
import java.util.*;
import kod.Title;

/**
 *
 * @author Wojtek Mielczarek
 */
public class fitnesse_addTitle extends ColumnFixture {

    String dane[];
    int danei[];

    public boolean addTitle() {
        int s1 = titleAmount();
        SetUp.aplikacja.addTitle(dane[0], dane[1], dane[2], danei[0], danei[1]);
        int s2 = titleAmount();
        if (s1 == s2) {
            return false;
        } else {
            return true;
        }

    }

    public int titleAmount() {
        ArrayList<Title> lista;
        lista=SetUp.aplikacja.getTitles();
        return lista.size();
        //return SetUp.aplikacja.getTitles().size();
    }
}