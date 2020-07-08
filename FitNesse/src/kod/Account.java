
package kod;
import java.util.ArrayList;
import java.util.Date;
public class Account {

    private int accountID;
    private double charges;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Reservation> reservations;

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public Account(int accountID, String firstName, String lastName, String email) {
        this.accountID = accountID;
        this.charges = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        reservations = new ArrayList();
    }

    public Account(int accountId) {
        this(accountId, "", "", "");
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", charges=" + charges + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", reservations=" + reservations + '}';
    }

    public int getAccountID() {
        return accountID;
    }

    public double getCharges() {
        return charges;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reservation reserve(Date from, Date to, Title title, ArrayList<Account> accounts) {
        if (from.after(to)) {
            return null;
        }
        int resCount = reservations.size();

        if (resCount > 5) {
            return null;
        }

        Reservation res = new Reservation(from, to, title);

        //TODO: freeDvdForReservation nie ma schematu
        int available = title.freeDvdForReservation(res, accounts);

        if (available == 0) {
            return null;
        }

        //TODO: set account na diagramie???
        
        reservations.add(res);

        return res;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.accountID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.accountID != other.accountID) {
            return false;
        }
        return true;
    }

    public Reservation findReservation(Title title) {
        for (Reservation r : reservations) {
            if (r.getTitle().equals(title)) {
                return r;
            }
        }
        return null;
    }

    public boolean removeReservation(Title title) {
        Reservation res = findReservation(title);
        if (res != null) {
            reservations.remove(res);
            return true;
        }
        return false;
    }
}
