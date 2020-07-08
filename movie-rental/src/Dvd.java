package kod;
public class Dvd {
    private int id;
    private Title title;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
    
    public Dvd(int id, Title title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

}
