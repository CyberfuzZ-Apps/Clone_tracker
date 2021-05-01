package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] library = new Book[4];
        library[0] = new Book("Clean code", 567);
        library[1] = new Book("HeadFirst JAVA", 689);
        library[2] = new Book("Herbert Schildt - Java", 987);
        library[3] = new Book("Horstmann C.S. - Core Java", 1200);
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