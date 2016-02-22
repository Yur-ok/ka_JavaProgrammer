package Lesson_01.kp_05.frame_06;

/**
 * Created by Юрий on 18.02.2016.
 */
public class Book {

    private String name;
    private String author;
    private Genre genre;


    public Book() {
        name = null;
        author = null;
    }

    public Book(String name, String author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

}
