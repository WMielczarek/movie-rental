package kod;
import java.util.Date;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Application app = new Application();
        ArrayList res = new ArrayList();
        app.addTitle("Harry Potter", "Christopher Columbus", " Warner Brothers", 2005, 1);
        app.addTitle("Gwiezdne Wojny", "Jordze Lukas", " AAAAAAA", 1972, 2);
        app.addTitle("Matrix", "Wachowski", "Universal", 2003, 3);
        app.getTitles().forEach((t) -> {
            System.out.println(t.toString());
        });
        Title a = new Title("Matrix");
        Title b = new Title("Matrix");
        Title search = app.searchTitle(b);
        if (a.equals(b)) {
            System.out.println("Jest fajnie\n" + search.toString());
        } else {
            System.out.println("Nie fajnie");
        }
        System.out.println("Sprawdzanie ");
        app.addAccount("Artur", "Schulz", "218433@student.pwr.edu.pl");
       
        
                app.addAccount("Artur", "Schulz", "218433@student.pwr.edu.pl");

        app.addAccount("Wojciech", "Mielczarek", "222222@student.pwr.edu.pl");
        app.addAccount("Andrzej", "Duda", "prezydent@polska.gov");
        
        app.getAccounts().forEach((t) -> {
           System.out.println(t.toString());
        });
        
        Account andrzej = new Account(3);
        Account acc = app.searchAccount(andrzej);
        if(acc.equals(andrzej)) {
            System.out.println("Jest fajnie\n" + acc.toString());
        } else {
            System.out.println("Nie fajnie");
        }
        
        Date from, to, fromPast, toPast, fromFuture, toFuture;
        from = new Date(2017-1900, 2, 1);
        to   = new Date(2017-1900, 2, 5);
        fromPast = new Date(2015-1900, 2, 1);
        toPast = new Date(2015-1900, 2, 5);
        fromFuture = new Date(2019-1900, 2, 1);
        toFuture = new Date(2019-1900, 2, 5);
        
        
        
        
        ////////////////////////////
        Title t = new Title("Harry Potter");
        Title harry = app.searchTitle(t);
        
        //Dodaj rezerwacje w terminie t
        System.out.println("Film '" + harry.getTitle() + "' ma " + harry.getDvds().size() + " egzemplarzy");
        System.out.println("\nProba rezerwacji  w terminie: " + from.toString() + " - " + to.toString());
        Reservation r = app.addReservation("Harry Potter", 1, from, to);
        if(r != null) {
            System.out.println("Zarezerwowano:  "+ r.getTitle().toString() +"\n W terminie: " + r.getFrom().toString() + " - " + r.getTo().toString());
        } else {
            System.out.println("Rezerwacja nie wyszla");
        }
        
        //Dodaj rezerwacje w terminie t (blad)
        System.out.println("\nProba rezerwacji  w terminie: " + from.toString() + " - " + to.toString());
        Reservation r2 = app.addReservation("Harry Potter", 2, from, to);
        if(r2 != null) {
            System.out.println("Zarezerwowano:  "+ r2.getTitle().toString() +"\n W terminie: " + r2.getFrom().toString() + " - " + r2.getTo().toString());
        } else {
            System.out.println("Rezerwacja nie wyszla");
        }
        
        //Dodaj rezerwacje w terminie t-1
        System.out.println("\nProba rezerwacji  w terminie: " + fromPast.toString() + " - " + toPast.toString());
        Reservation r3 = app.addReservation("Harry Potter", 2, fromPast, toPast);
        if(r3 != null) {
            System.out.println("Zarezerwowano:  "+ r3.getTitle().toString() +"\n W terminie: " + r3.getFrom().toString() + " - " + r3.getTo().toString());
        } else {
            System.out.println("Rezerwacja nie wyszla");
        }
        
        //Dodaj reserwazcje w terminie t+1
        System.out.println("\nProba rezerwacji  w terminie: " + fromFuture.toString() + " - " + toFuture.toString());
        Reservation r4 = app.addReservation("Harry Potter", 2, fromFuture, toFuture);
        if(r4 != null) {
            System.out.println("Zarezerwowano:  "+ r4.getTitle().toString() +"\n W terminie: " + r4.getFrom().toString() + " - " + r4.getTo().toString());
        } else {
            System.out.println("Rezerwacja nie wyszla");
        }
        
        //Usun rezerwacje
        System.out.println("\nProba usuniecia rezerwacji");
        if(app.removeReservation("Harry Potter", 1)) {
            System.out.println("Pomyslnei usunieto rezerwacje");
        } else {
            System.out.println("Nie usunieto rezerwacji");
        }
        

        //Dodaj rezerwacje w terminie t (blad)
        System.out.println("\nProba rezerwacji  w terminie: " + from.toString() + " - " + to.toString());
        Reservation r5 = app.addReservation("Harry Potter", 2, from, to);
        if(r5 != null) {
            System.out.println("Zarezerwowano:  "+ r5.getTitle().toString() +"\n W terminie: " + r5.getFrom().toString() + " - " + r5.getTo().toString());
        } else {
            System.out.println("Rezerwacja nie wyszla");
        }
    }
    
}
