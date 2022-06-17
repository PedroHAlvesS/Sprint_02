package domain;

public class Movie {
    private int id;
    private String name;
    private String description;
    private int year;

    public Movie(int id, String name, String description, int year) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year = year;
    }

    public void showMovie() {
        System.out.println("( " + this.id + " ) Movie: " + this.name + "| " + this.description + "| ano: " + this.year);
    }
}
