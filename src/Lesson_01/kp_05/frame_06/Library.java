package Lesson_01.kp_05.frame_06;

/**
 * Created by Юрий on 18.02.2016.
 */
public class Library {
    public static int genreCount;
    private static int vCount;
    private static int idx = -1;

    public static void main(String[] args) {

        Book[] booksByName = new Book[15];
        booksByName[0] = new Book("100 shell programs in Unix", "Jain Sarika", Genre.COMPUTERS);
        booksByName[1] = new Book("A Monkey's Guide to Matrices", "Unknown", Genre.COMPUTERS);
        booksByName[2] = new Book("Advanced PIC Microcontroller Projects in C", "Dogan Ibrahim", Genre.COMPUTERS);
        booksByName[3] = new Book("Agile Software Development", "Коуберн Алистэр", Genre.COMPUTERS);
        booksByName[4] = new Book("Beginning Android", " Murphy Mark L.", Genre.COMPUTERS);
        booksByName[5] = new Book("The Mistery of Sasassa Valley", "Arthur Conan Doyle", Genre.FANTASY);
        booksByName[6] = new Book("Жизнь Людовика XVI", "Александр Дюма", Genre.HISTORY);
        booksByName[7] = new Book("Иоанна Неополитанская", "Александр Дюма", Genre.HISTORY);
        booksByName[8] = new Book("Карл Людвиг Занд", "Александр Дюма", Genre.HISTORY);
        booksByName[9] = new Book("Людовик XV и его эпоха", "Александр Дюма", Genre.HISTORY);
        booksByName[10] = new Book("МЫ и ОНИ", "Галина Мария", Genre.FANTASY);
        booksByName[11] = new Book("Пирамиды", "Кувшинов Виктор Юрьевич", Genre.FANTASY);
        booksByName[12] = new Book("Рояль Ньютона", "Неграш Сергей Вячеславович", Genre.FANTASY);
        booksByName[13] = new Book("Утро нового дня", "Неграш Сергей Вячеславович", Genre.FANTASY);
        booksByName[14] = new Book("Утюг", "Михеев Михаил", Genre.FANTASY);

        Book[] booksByGenre = new Book[15];
        booksByGenre[0] = new Book("100 shell programs in Unix", "Jain Sarika", Genre.COMPUTERS);
        booksByGenre[1] = new Book("A Monkey's Guide to Matrices", "Unknown", Genre.COMPUTERS);
        booksByGenre[2] = new Book("Advanced PIC Microcontroller Projects in C", "Dogan Ibrahim", Genre.COMPUTERS);
        booksByGenre[3] = new Book("Agile Software Development", "Коуберн Алистэр", Genre.COMPUTERS);
        booksByGenre[4] = new Book("Beginning Android", " Murphy Mark L.", Genre.COMPUTERS);
        booksByGenre[5] = new Book("The Mistery of Sasassa Valley", "Arthur Conan Doyle", Genre.FANTASY);
        booksByGenre[6] = new Book("МЫ и ОНИ", "Галина Мария", Genre.FANTASY);
        booksByGenre[7] = new Book("Пирамиды", "Кувшинов Виктор Юрьевич", Genre.FANTASY);
        booksByGenre[8] = new Book("Рояль Ньютона", "Неграш Сергей Вячеславович", Genre.FANTASY);
        booksByGenre[9] = new Book("Утро нового дня", "Неграш Сергей Вячеславович", Genre.FANTASY);
        booksByGenre[10] = new Book("Утюг", "Михеев Михаил", Genre.FANTASY);
        booksByGenre[11] = new Book("Карл Людвиг Занд", "Александр Дюма", Genre.HISTORY);
        booksByGenre[12] = new Book("Жизнь Людовика XVI", "Александр Дюма", Genre.HISTORY);
        booksByGenre[13] = new Book("Иоанна Неополитанская", "Александр Дюма", Genre.HISTORY);
        booksByGenre[14] = new Book("Людовик XV и его эпоха", "Александр Дюма", Genre.HISTORY);

        lookFor("Утюг", "", booksByName);
        lookFor("Fantasy", booksByGenre);
        lookFor("Fantasy", booksByGenre);
    }


    public static void lookFor(String genre, Book[] books) {
        if (genreCount < 1) {
            genreCount(genre, books); //посчитал кол-во вхождений
        }

        vCount = 5; //кол-во результатов на страницу
        if (genreCount > vCount) {
            genreCount -= vCount;
            System.out.println("The " + vCount + " entries of search's result.");
            for (int i = 0; i <= books.length - 1 && vCount > 0; i++) {
                if (String.valueOf(books[i].getGenre()).equals(genre.toUpperCase())) {
                    System.out.println(books[i].getGenre() + " - \"" + books[i].getName() + "\" - " + books[i].getAuthor());
                    vCount--;
                    idx = i;
                }
            }
        } else {
            System.out.println("Last " + genreCount + " entries of search's result.");
            for (int k = ++idx; genreCount > 0; k++) {
                System.out.println(books[k].getGenre() + " - \"" + books[k].getName() + "\" - " + books[k].getAuthor());
                genreCount--;
            }
        }
    }

    private static void genreCount(String genre, Book[] books) {
        for (int i = 0; i <= books.length - 1; i++) {
            if (String.valueOf(books[i].getGenre()).equals(genre.toUpperCase())) {
                genreCount++;
            }
        }
    }

    public static void lookFor(String name, String author, Book[] books) {
        boolean search = false;
        for (int i = 0; i <= books.length - 1; i++) {
            if (books[i].getName().equals(name) || books[i].getAuthor().equals(author)) {
//                if () {
                System.out.println(books[i].getName() + " - " + books[i].getAuthor() + " - " + books[i].getGenre());
                search = true;
            }
        }
        if (!search) {
            System.out.println("Sorry we have no book like [" + name + "] [" + author +
                    "]\nCheck your query and try again.");
        }
    }
}