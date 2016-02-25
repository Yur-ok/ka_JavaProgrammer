package Lesson_01.kp_05.frame_07_teachVer;

/**
 * Created by Юрий on 23.02.2016.
 */
public class Book {

    private String name;
    private String author;
    private Genre genre;

    public Book() {
    }

    public Book(String name, String author, Genre genre) {
        this.name = name.trim();
        this.author = author.trim();
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
