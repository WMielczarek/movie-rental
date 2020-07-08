/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy;
import kod.Application;
import fit.Fixture;
/**
 *
 * @author Wojtek Mielczarek
 */
public class SetUp extends Fixture{
    static Application aplikacja;
    String firstName="woj";
    String lastName="aa";
    String email="bb";
    
    public SetUp(){
        aplikacja=new Application();
        aplikacja.addAccount(firstName, lastName, email); //pierwszy klient id=1 kolejn id=2 itd.
        aplikacja.addAccount(firstName, lastName, email); //pierwszy klient id=1 kolejn id=2 itd.

    }
}
