
import java.util.ArrayList;

import utils.*;
import utils.Library;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        Author StephanieMeyer = new Author("Stephanie Meyer", "12-24-1973");
        Author SarahJMaas = new Author("Sarah J. Maas", "03-06-1986");
        Author BrandonSanderson = new Author("Brandon Sanderson", "12-19-1975");
        Author DrSeuss = new Author("Theodor Seuss Geisel", "03-02-1904");
        Author Boris = new Author("Boris Porti", "05-12-1994");
        Author Craig = new Author("Craig Bestii", "03-03-2000");

        library.addAuthor(StephanieMeyer);
        library.addAuthor(SarahJMaas);
        library.addAuthor(BrandonSanderson);
        library.addAuthor(DrSeuss);
        library.addAuthor(Boris);
        library.addAuthor(Craig);

        Book book1 = new Book("Twilight", StephanieMeyer, "1551", "Penguin", 30);
        Book book2 = new Book("A Court of Thornes and Roses", SarahJMaas, "1990", "Bloomsbury", 25);
        Book book3 = new Book("A Court of Mist and Fury", SarahJMaas, "2016", "Bloomsbury", 25);
        Book book4 = new Book("A Court of Wings and Ruin", SarahJMaas, "2017", "Bloomsbury", 20);
        Book book5 = new Book("A Court of Frost and Starlight", SarahJMaas, "2018", "Bloomsbury", 18);
        Book book6 = new Book("A Court of Silver Flames", SarahJMaas, "2021", "Bloomsbury", 15);
        Book book7 = new Book("New Moon", StephanieMeyer, "1333", "Penguin", 10);
        Book book8 = new Book("The Way of Kings", BrandonSanderson, "2219", "Tor Books", 12);
        Book book9 = new Book("Words of Radiance", BrandonSanderson, "2220", "Tor Books", 8);
        Book book10 = new Book("The Cat in the Hat", DrSeuss, "1957", "Random House", 5);
        Book book11 = new Book("Colored Biscuits", Boris, "3337", "Moose Publishing", 3);
        Book book12 = new Book("Hot Crossed Rolls", Craig, "2760", "Read in Court", 2);

        StephanieMeyer.addBook(book1);
        StephanieMeyer.addBook(book7);

        SarahJMaas.addBook(book2);
        SarahJMaas.addBook(book3);
        SarahJMaas.addBook(book4);
        SarahJMaas.addBook(book5);
        SarahJMaas.addBook(book6);

        BrandonSanderson.addBook(book8);
        BrandonSanderson.addBook(book9);

        DrSeuss.addBook(book10);

        Boris.addBook(book11);

        Craig.addBook(book12);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);
        library.addBook(book11);
        library.addBook(book12);

        Patron patron1 = new Patron("Josh Pike","19 Brooklyn St., Mount Pearl","709-876-7896");
        Patron patron2 = new Patron("Betty Johnson", "3A Primrose Pl., Mount Pearl", "709-547-3382");
        Patron patron3 = new Patron("Jordan Pike", "19 Brooklyn St., Mount Pearl", "709-876-7896");
        Patron patron4 = new Patron("Jessie Bessie", "3 Bisqe Region, St. John's", "709-876-5549");
        Patron patron5 = new Patron("Grimes", "Weapon Pl. St.John's", "888-900-6785");

        library.addPatron(patron1);
        library.addPatron(patron2);
        library.addPatron(patron3);
        library.addPatron(patron4);
        library.addPatron(patron5);

        System.out.println("           LIBRARY MANAGEMENT SYSTEM ");
        System.out.println("          PRINTING OUT ORIGINAL LISTS ");
        System.out.println("Book List:");
        library.printBookList();
        System.out.println("--------------------------------------------------");
        System.out.println("Author List:");
        library.printAuthorList();
        System.out.println("--------------------------------------------------");
        System.out.println("Patron List:");
        library.printPatronList();
        System.out.println("--------------------------------------------------");
        System.out.println("");
        System.out.println("                  BOOK SEARCHES ");
        System.out.println(library.bookSearch("Stephanie Meyer"));
        System.out.println("--------------------------------------------------");
        System.out.println(library.bookSearch("2016"));
        System.out.println("--------------------------------------------------");
        System.out.println(library.bookSearch("Words of Radiance"));
        System.out.println("--------------------------------------------------");
        System.out.println("");
        System.out.println("                  BORROW BOOKS ");
        library.BorrowBook(book1, patron1, 3);
        library.BorrowBook(book7, patron3, 2);
        library.BorrowBook(book11, patron2, 3);
        System.out.println("--------------------------------------------------");
        System.out.println("Patron List:");
        library.printPatronList();
        System.out.println("--------------------------------------------------");
        System.out.println("");
        System.out.println("                  RETURN BOOKS ");
        library.ReturnBook(book11, patron2, 3);
        library.ReturnBook(book1, patron1, 3);
        System.out.println("Patron List:");
        library.printPatronList();
        System.out.println("--------------------------------------------------");
        System.out.println("Book List:");
        library.printBookList();
        System.out.println("                  REMOVE BOOK ");
        library.deleteBook(book11);
        System.out.println("Book List:");
        library.printBookList();
        System.out.println("--------------------------------------------------");
        System.out.println("                    EDIT BOOK ");
        library.editBook(book12, "Hot Cross Rolls", Craig, "2760", "Read in Court", 2);
        System.out.println("Book List:");
        library.printBookList();
        System.out.println("--------------------------------------------------");
        System.out.println("                    EDIT AUTHOR ");
        library.editAuthor(Craig, "Craig Besto", "03-03-2000");
        System.out.println("Author List:");
        library.printAuthorList();
        System.out.println("--------------------------------------------------");
        System.out.println("                    REMOVE AUTHOR ");
        library.deleteAuthor(Boris);
        System.out.println("Author List:");
        library.printAuthorList();
        System.out.println("--------------------------------------------------");
        System.out.println("Book List:");
        library.printBookList();
        System.out.println("--------------------------------------------------");
        System.out.println("                     EDIT PATRON ");
        library.editPatron(patron5,"Lizzy Wizzy", "Weapon Pl. St.John's", "888-900-6785");
        System.out.println("Patron List:");
        library.printPatronList();
        System.out.println("--------------------------------------------------");
        System.out.println("                     REMOVE PATRON ");
        library.deletePatron(patron4);
        System.out.println("Patron List:");
        library.printPatronList();
        System.out.println("--------------------------------------------------");
        System.out.println("           END OF LIBRARY MANAGEMENT SYSTEM ");
    }
}