package utils;

import java.util.ArrayList;
import java.util.List;

public class Patron{
    private String name;
    private String address;
    private String phoneNum;
    private List<Book> booksBorrowed;

    public Patron(String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.booksBorrowed = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "  Address: " + address +
                "  Phone Number: " + phoneNum +
                "  Books Borrowed: " + booksBorrowed + "\n";
    }

    public void addBorrowedBooks(Book book) {
        this.booksBorrowed.add(book);
    }
    public void deleteBorrowedBooks(Book book) {
        this.booksBorrowed.remove(book);
    }
}