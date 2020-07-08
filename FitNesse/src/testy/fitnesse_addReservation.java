/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy;

import fit.ColumnFixture;
import java.util.*;
import kod.*;

/**
 *
 * @author Wojtek Mielczarek
 */
public class fitnesse_addReservation extends ColumnFixture {

    String title;
    int idaccount;
    int fromY, fromM, fromD, toY, toM, toD;
    public int addReservation() {
        Date from = new Date(fromY-1900,fromM,fromD);
        Date to = new Date(toY-1900,toM,toD);//tworzenie date z int, poniewaz byl problem z przekazaniem daty z fitnessa
        int s1 = reservationAmount(); //sprawdzam liczbe rezerwacji na koncie przed dodaniem
        try {
            SetUp.aplikacja.addReservation(title, idaccount, from, to);
            int s2 = reservationAmount(); //sprawdzam liczbe rezerwacji na koncie po dodaniu rezerwacji
            if (s1 != s2) {
                return 0; //dodalo
            } else {
                return 1; //niedodalo
            }
        } catch (IllegalFormatCodePointException e) {
        }
        return -1; //fail
   
   }
   
//funkcja nie dziala popranie nie wiemy czemu, ponieważ szukamy konta po id, do a przypisujemy to konto. Nigdy nie udaje sie znalezc konta a=null i funkcja zawsze zwraca 0. Przy sprawdzeniu tej funkcji w
// w main wszystko dziala tak jak zakladamy i gdy dodamy pierwsze konto to jego id = 1. I funckja zwraca nam obiekt spod tego indeksu.  
    public int reservationAmount(){
        Account a = SetUp.aplikacja.searchAccount(idaccount); //zwraca obiekt pod tym id
        if(a != null){
            return a.getReservations().size(); //zwraca rozmiar ArrayList rezerwacji(liczba rezerwacji)
        }
        else
            return 0; //nie znaleziono konta o danym id
    }
}

    

