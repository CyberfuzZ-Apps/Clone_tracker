package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 567);
        Book book2 = new Book("HeadFirst JAVA", 689);
        Book book3 = new Book("Herbert Schildt - Java", 987);
        Book book4 = new Book("Horstmann C.S. - Core Java", 1200);
        Book[] library = {book1, book2, book3, book4};
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getTitle() + " - "
                    + library[i].getPages() + " pages");
        }
        Book tmp = library[0];
        library[0] = library[3];
        library[3] = tmp;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getTitle() + " - "
                    + library[i].getPages() + " pages");
        }
        for (int i = 0; i < library.length; i++) {
            if ("Clean code".equals(library[i].getTitle())) {
                System.out.println(library[i].getTitle() + " - "
                        + library[i].getPages() + " pages");
            }
        }
    }
}
