package kod;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Title {

    private String title;
    private String director;
    private String company;
    private int year;
    private ArrayList<Dvd> dvds;

    public ArrayList<Dvd> getDvds() {
        return dvds;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getCompany() {
        return company;
    }

    public int getYear() {
        return year;
    }

    public Title(String title, String director, String company, int year, int dvdAmount) {
        this.title = title;
        this.director = director;
        this.company = company;
        this.year = year;
        dvds = new ArrayList();

        addDvd(dvdAmount, this);
    }

    public Title(String title) {
        this(title, "", "", 0, 0);
        // this.title = title;

    }

    private void addDvd(int amount, Title title) {
        int size = dvds.size();
        for (int i = size; i < amount; i++) {
            Dvd dvd = new Dvd(i, this);
            dvds.add(dvd);
        }
    }

    @Override
    public String toString() {
        return "Title{" + "title=" + title + ", director=" + director + ", company=" + company + ", year=" + year + ", dvds=" + dvds + '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.title);
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
        final Title other = (Title) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    public ArrayList<Reservation> findReservations(Reservation res, ArrayList<Account> accounts) {
        ArrayList<Reservation> titleReservations = new ArrayList();
        for (Account a : accounts) {
            for (Reservation r : a.getReservations()) {
                if (r.getTitle().equals(res.getTitle())) {
                    titleReservations.add(r);
                }
            }
        }
        
        return titleReservations;
    }

    public int freeDvdForReservation(Reservation res, ArrayList<Account> accounts) {
        ArrayList<Reservation> titleReservations = findReservations(res, accounts);

        int dvdAmount = res.getTitle().getDvds().size();
        int reservationsAmount = titleReservations.size();

        if (dvdAmount > reservationsAmount) {
            return dvdAmount - reservationsAmount;
        }

        int freeDates = 0;

        for (Reservation r : titleReservations) {
            if (res.getTo().before(r.getFrom())) {
                freeDates++;
                continue;
            }
            if (res.getFrom().after(r.getTo())) {
                freeDates++;
                continue;
            }
        }
        return freeDates;
    }

}
