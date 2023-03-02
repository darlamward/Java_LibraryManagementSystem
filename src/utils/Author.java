package utils;

import java.util.ArrayList;
import java.util.List;

public class Author{
    private String authorName;
    private String DOB;
    private List<Book> bookList;

    public Author(String authorName, String DOB){
        this.authorName = authorName;
        this.DOB = DOB;
        this.bookList = new ArrayList<>();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author: " + authorName +
                "  DOB: " + DOB +
                "  bookList: " + bookList + '\n';
    }

    public List<Book> addBook(Book book){
        this.bookList.add(book);
        return this.bookList;
    }
}
