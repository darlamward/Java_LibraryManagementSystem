package utils;

public interface Borrowable {
    void BorrowBook(Book book, Patron patron, int borrowQty);
    void ReturnBook(Book book, Patron patron, int returnQty);
}
