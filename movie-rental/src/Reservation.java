package kod;
import java.util.Date;

public class Reservation {

    private Date from;
    private Date to;
    private Title title;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Reservation() {
    }

    public Reservation(Date from, Date to, Title title) {
        this.from = from;
        this.to = to;
        this.title = title;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
