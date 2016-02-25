package Lesson_01.kp_05.frame_07_teachVer;

/**
 * Created by Юрий on 24.02.2016.
 */
public class Launcher {
    public static void main(String[] args) {

        Library lib = new Library();

//        for (Book book : lib.findByGenre(Genre.COMPUTERS)) {
//            if (book != null) {
//                System.out.println(book.getName());
//            }
//        }

//        lib.findByName("Утюг");
//        lib.findByAuthor("Александр Дюма");
        lib.findByGenre(Genre.FANTASY);
        lib.findByGenre(Genre.FANTASY);
        lib.findByGenre(Genre.FANTASY);
        lib.findByGenre(Genre.FANTASY);


    }
}
