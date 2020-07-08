package kod;
import java.util.ArrayList;
import java.util.Date;

public class Application {

    private ArrayList<Title> titles;
    private ArrayList<Account> accounts;

    public Application() {
        accounts = new ArrayList();
        titles = new ArrayList();
    }

    public ArrayList<Title> getTitles() {
        return titles;
    }
    
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Title searchTitle(Title title) {
        int idx = titles.indexOf(title);
        if (idx != -1) {
            return titles.get(idx);
        }
        return null;
    }

    public boolean addTitle(String title, String director, String company, int year, int dvdAmount) {
        Title titleobj = new Title(title, director, company, year, dvdAmount);
        if (searchTitle(titleobj) == null) {
            titles.add(titleobj);
            return true;
        } else {
            return false;
        }
    }

    public Account searchAccount(Account account) {
        int idx = accounts.indexOf(account);
        if (idx != -1) {
            return accounts.get(idx);
        }
        return null;
    }
    public Account searchAccount(int account){
       int idx = accounts.indexOf(this);
       if(idx == account){
           return accounts.get(idx);
       }
       else
           return null;
    }

    public boolean addAccount(String firstName, String lastName, String email) {
        Account acc = new Account(accounts.size() + 1, firstName, lastName, email);
        if (searchAccount(acc) == null) {
            accounts.add(acc);
            return true;
        } else {
            return false;
        }
    }
    
    //TODO: zmien w diagramie resFrom Data na resFrom Date(literowka)
    //TODO: nie typ void bo zwracamy null gdy nie uda sie zarezerwowac
    public Reservation addReservation(String title, int clientId, Date resFrom, Date resTo) {
        Title searchedTitle = new Title(title);
        Title t = searchTitle(searchedTitle);
        
        Account searchedAccount = new Account(clientId);
        Account a = searchAccount(searchedAccount);
        
        Reservation res = a.reserve(resFrom, resTo, t, accounts);
        
        return res;
    }
    
    public boolean removeReservation(String title, int clientId) {
        Title searchedTitle = new Title(title);
        Title t = searchTitle(searchedTitle);
        
        Account searchedAccount = new Account(clientId);
        Account a = searchAccount(searchedAccount);
        
        return a.removeReservation(t);
    }

}
