package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", 256);
        Book book2 = new Book("Algorithms", 343);
        Book book3 = new Book("Learn Java", 794);
        Book book4 = new Book("Unit Testing", 302);
        Book[] library = new Book[]{book1, book2, book3, book4};
        System.out.println("Список книг в библиотеке:");
        for (Book book : library) {
            System.out.println(book.getName() + ", " + book.getPage() + " pages");
        }
        System.out.println("Меняем книги с инедксом 0 и 3 местами");
        library[0] = book4;
        library[3] = book1;
        System.out.println("Список книг в библиотеке после изменения:");
        for (Book book : library) {
            System.out.println(book.getName() + ", " + book.getPage() + " pages");
        }
        System.out.println("Поиск книги с названием Clean Code");
        for (Book book : library) {
            if (("Clean Code").equals(book.getName())) {
                System.out.println(book.getName() + ", " + book.getPage() + " pages");
            }
        }
    }
}
