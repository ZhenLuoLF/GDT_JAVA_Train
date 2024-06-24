package org.zhen.dao;

import org.zhen.exception.BookNotFoundException;
import org.zhen.exception.BookOutOfLimitException;
import org.zhen.pojo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private int bookId;
    private int bookCount;
    private int bookLimit;
    private List<Book> bookArray;

    public BookDao() {
        bookCount = 0;
        bookId = 0;
        bookLimit = 10;
        bookArray = new ArrayList<Book>();
    }
    public int getBookCount() {
        return bookCount;
    }
    public int getBookLimit(){
        return bookLimit;
    }
    public List<Book> getBookArray() {
        return bookArray;
    }

    public void addBook(String bookName, String authorName, String description) throws BookOutOfLimitException {
        /* Adding new book to the book array
         *
         * */
        if(bookCount >= bookLimit){
            throw new BookOutOfLimitException("Book is out of limit");
        }
        bookCount++;
        bookId++;
        Book book = new Book(bookName, authorName, description, bookId);
        bookArray.add(book);
    }

    public Book getBookById(int bookId){
        /* Get Book by BookId
         *
         */
        Book book = null;
        for(Book b : bookArray){
            if(b.getBookId() == bookId){
                book = b;
            }
        }
        return book;
    }

    public void deleteBook(int bookId) throws BookNotFoundException {
        /* Delete book by bookId
         * */
        // To find if this book exist
        Book book = getBookById(bookId);
        if ( book == null) {
            throw new BookNotFoundException("Book not found");
        }
            // Book exist, delete and build the new book array
        bookCount--;
        bookArray.remove(book);
    }
}
