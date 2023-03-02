package utils;

public class Book implements Borrowable {
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private int noOfCopies;
    private Status status;

    public Book(String title, Author author, String ISBN, String publisher, int noOfCopies) {
        this.title = title;
        this.author = author.getAuthorName();
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.noOfCopies = noOfCopies;
        this.status = Status.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "  Author: " + author +
                "  ISBN: " + ISBN +
                "  Publisher: " + publisher +
                "  Number Of Copies in Stock: " + noOfCopies +
                "  Status: " + status + '\n';
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
    @Override
    public void BorrowBook(Book book, Patron patron, int borrowQty) {
        if (this.noOfCopies < borrowQty) {
            book.setStatus(Status.CHECKED_OUT);
            System.out.println("This book is currently checked out");
        } else {
            patron.addBorrowedBooks(book);
            book.setNoOfCopies(book.noOfCopies -= borrowQty);
            if (book.noOfCopies == 0) {
                book.setStatus(Status.CHECKED_OUT);
            } else {
                book.setStatus(Status.AVAILABLE);
            }
        }
    }

    @Override
    public void ReturnBook(Book book, Patron patron, int returnQty) {
        if (patron.getBooksBorrowed().contains(book)) {
            patron.deleteBorrowedBooks(book);
            book.setNoOfCopies(book.getNoOfCopies() + returnQty);
            book.setStatus(Status.AVAILABLE);
            System.out.println("Book returned");
        }
    }
}
