package org.zhen.pojo;

public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private String description;

    public Book(){

    }
    public Book(String bookName, String authorName, String description, int bookId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Id:" + bookId + " Name:" + bookName;
    }
}
