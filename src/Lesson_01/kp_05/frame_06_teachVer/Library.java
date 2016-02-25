package Lesson_01.kp_05.frame_06_teachVer;

/**
 * Created by Юрий on 23.02.2016.
 */
public class Library {

    private String abc = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private Book[][] booksByName;
    private Book[][] booksByAuthor;
    private Book[][] booksByGenre;
    private int lastIdx;
    private Genre lastGenre;

    public Library() {
        booksByName = new Book[abc.length()][];
        fillDictionary(booksByName);

        booksByAuthor = new Book[abc.length()][];
        fillDictionary(booksByAuthor);

        booksByGenre = new Book[5][];
        fillDictionary(booksByGenre);

        createsBook();
    }

    public Book[] findByName(String name) {
        int idx = abc.indexOf(name.charAt(0));
        Book[] bbn = new Book[booksByName[idx].length];
        for (int i = 0; i < booksByName[idx].length; i++) {
            if (booksByName[idx][i] != null && booksByName[idx][i].getName().equals(name)) {
                if (bbn[i] == null) {
                    bbn[i] = booksByName[idx][i];
                }
            }
        }
        for (int i = 0; i < bbn.length; i++) {
            if (bbn[i] != null) {
                System.out.println("\"" + bbn[i].getName() + "\" [" + bbn[i].getAuthor() + "] " + bbn[i].getGenre());
            }
        }
        return bbn;
    }

    public Book[] findByAuthor(String author) {
        int idx = abc.indexOf(author.charAt(0));
        Book[] bba = new Book[booksByAuthor[idx].length];
        for (int i = 0; i < booksByAuthor[idx].length; i++) {
            if (booksByAuthor[idx][i] != null && booksByAuthor[idx][i].getAuthor().equals(author)) {
                if (bba[i] == null) {
                    bba[i] = booksByAuthor[idx][i];
                }
            }
        }
        for (int i = 0; i < bba.length; i++) {
            if (bba[i] != null) {
                System.out.println("\"" + bba[i].getAuthor() + "\" [" + bba[i].getName() + "] " + bba[i].getGenre());
            }
        }
        return bba;
    }

    public void findByGenre(Genre genre) {
        int numOfRes = 5;
        int idx = genre.getId();
        int start = 0;
        if (lastGenre == genre) {
            start = ++lastIdx;
        }
        for (int i = start; i < booksByGenre[idx].length && numOfRes > 0; i++) {
            if (numOfRes > 0 && booksByGenre[idx][i] != null) {
                System.out.println("\"" + booksByGenre[idx][i].getName() + "\" [" + booksByGenre[idx][i].getAuthor() +
                        "] " + booksByGenre[idx][i].getGenre());
                numOfRes--;
                lastIdx = i;
                lastGenre = genre;
            }
        }
    }

    private void fillDictionary(Book[][] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            dictionary[i] = new Book[10];
        }
    }

    private void addToLibrary(Book book) {
        int position = abc.indexOf(book.getName().charAt(0));
        addToStorage(booksByName[position], book);

        position = abc.indexOf(book.getAuthor().charAt(0));
        addToStorage(booksByAuthor[position], book);

        addToStorage(booksByGenre[book.getGenre().getId()], book);
    }

    private void addToStorage(Book[] storage, Book book) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = book;
                return;
            }
        }
    }

    private void createsBook() {
        Book b;
        b = new Book("100 shell programs in Unix", "Jain Sarika", Genre.COMPUTERS);
        addToLibrary(b);
        b = new Book("A Monkey's Guide to Matrices", "Unknown", Genre.COMPUTERS);
        addToLibrary(b);
        b = new Book("Advanced PIC Microcontroller Projects in C", "Dogan Ibrahim", Genre.COMPUTERS);
        addToLibrary(b);
        b = new Book("Agile Software Development", "Коуберн Алистэр", Genre.COMPUTERS);
        addToLibrary(b);
        b = new Book("Beginning Android", " Murphy Mark L.", Genre.COMPUTERS);
        addToLibrary(b);
        b = new Book("The Mistery of Sasassa Valley", "Arthur Conan Doyle", Genre.FANTASY);
        addToLibrary(b);
        b = new Book("Жизнь Людовика XVI", "Александр Дюма", Genre.HISTORY);
        addToLibrary(b);
        b = new Book("Иоанна Неополитанская", "Александр Дюма", Genre.HISTORY);
        addToLibrary(b);
        b = new Book("Карл Людвиг Занд", "Александр Дюма", Genre.HISTORY);
        addToLibrary(b);
        b = new Book("Людовик XV и его эпоха", "Александр Дюма", Genre.HISTORY);
        addToLibrary(b);
        b = new Book("МЫ и ОНИ", "Галина Мария", Genre.FANTASY);
        addToLibrary(b);
        b = new Book("Пирамиды", "Кувшинов Виктор Юрьевич", Genre.FANTASY);
        addToLibrary(b);
        b = new Book("Рояль Ньютона", "Неграш Сергей Вячеславович", Genre.FANTASY);
        addToLibrary(b);
        b = new Book("Утро нового дня", "Неграш Сергей Вячеславович", Genre.FANTASY);
        addToLibrary(b);
        b = new Book("Утюг", "Михеев Михаил", Genre.FANTASY);
        addToLibrary(b);
    }
}