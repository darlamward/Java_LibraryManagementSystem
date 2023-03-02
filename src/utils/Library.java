
package utils;

import java.util.ArrayList;
import java.util.List;

public class Library implements Borrowable{
    private List<Book> books;
    private List<Patron> patrons;
    private List<Author> authors;

    public Library(){
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

   public List<Book> bookSearch(String query) {
       ArrayList<Book> matchedBooks = new ArrayList<>();
       for (Book book : books) {
           if (book.getTitle().equals(query) ||
                   book.getAuthor().equals(query) ||
                   book.getISBN().equals(query)
           ){
               matchedBooks.add(book);     //  Add book to arrayList if it matches, so we can return it
           }
       }
       return matchedBooks;
    }
    public void addBook(Book book) {
        if(!this.books.contains(book)){
            this.books.add(book);
        } else {
            System.out.println(book.getTitle() + " is already in the system");
        }
    }

    public void deleteBook(Book book){
        if(!this.books.contains(book)) {
            System.out.println(book.getTitle() + "is not in the system.");
        } else {
            this.books.remove(book);
        }
    }

    public void editBook(Book book, String newTitle, Author newAuthor, String newISBN, String newPublisher, int newNoOfCopies){
        book.setTitle(newTitle);
        book.setAuthor(newAuthor.getAuthorName());
        book.setISBN(newISBN);
        book.setPublisher(newPublisher);
        book.setNoOfCopies(newNoOfCopies);
    }

    public void addAuthor(Author author) {
        if(!this.authors.contains(author)){
            this.authors.add(author);
        } else {
            System.out.println(author.getAuthorName() + " is already in the system");
        }
    }

    public void deleteAuthor(Author author){
        if(!this.authors.contains(author)){
            System.out.println(author.getAuthorName() + "is not in the system.");
        } else {
            this.authors.remove(author);
            for (Book authorBook : author.getBookList()){
                this.deleteBook(authorBook);
            }
        }
    }

    public void editAuthor(Author author, String newName, String newDOB){
        author.setAuthorName(newName);
        author.setDOB(newDOB);
    }

    public void addPatron(Patron patron) {
        if(!this.patrons.contains(patron)){
            this.patrons.add(patron);
        } else {
            System.out.println(patron.getName() + " is already in the system");
        }
    }

    public void deletePatron(Patron patron){
        if(!this.patrons.contains(patron)){
            System.out.println(patron.getName() + "is not in the system.");
        } else {
            patron.getBooksBorrowed().clear();
            this.patrons.remove(patron);
        }
    }

    public void editPatron(Patron patron, String newName, String newAddress, String newPhoneNum){
        patron.setName(newName);
        patron.setAddress(newAddress);
        patron.setPhoneNum(newPhoneNum);
    }

    @Override
    public void BorrowBook(Book book, Patron patron, int borrowQty) {
        if (book.getNoOfCopies() <= borrowQty) {
            patron.addBorrowedBooks(book);
            book.setNoOfCopies(0);
            book.setStatus(Status.CHECKED_OUT);
            System.out.println("You've just checked out all copies of " + book.getTitle() + "!");
        } else {
            patron.addBorrowedBooks(book);
            book.setNoOfCopies(book.getNoOfCopies() - borrowQty);
            if (book.getNoOfCopies() <= 0) {
                book.setStatus(Status.CHECKED_OUT);
                System.out.println("You've just checked out all copies of " + book.getTitle() + "!");
            } else {
                book.setStatus(Status.AVAILABLE);
                System.out.println("You've just checked out " + borrowQty + " copies of " + book.getTitle() + "!");
            }
        }
    }
    @Override
    public void ReturnBook(Book book, Patron patron, int returnQty) {
        // Try making return qty = borrow qty???
        if (patron.getBooksBorrowed().contains(book)) {
            patron.deleteBorrowedBooks(book);
            book.setNoOfCopies(book.getNoOfCopies() + returnQty);
            book.setStatus(Status.AVAILABLE);
            System.out.println("Book returned");
        }
    }

    public void printBookList(){
        System.out.println(books);
    }

    public void printAuthorList() {
        System.out.println(authors);
    }

    public void printPatronList(){
        System.out.println(patrons);
    }
}
