package org.zhen.dao;

import org.zhen.pojo.Book;

public class BookDao {
    private int bookId;
    private int bookCount;
    private int bookLimit;
    private Book[] bookArray;

    public BookDao() {
        bookCount = 0;
        bookId = 0;
        bookLimit = 10;
        bookArray = new Book[0];
    }
    public int getBookCount() {
        return bookCount;
    }
    public int getBookLimit(){
        return bookLimit;
    }
    public Book[] getBookArray() {
        return bookArray;
    }

    public void addBook(String bookName, String authorName, String description){
        /* Adding new book to the book array
         *
         * */

        bookCount++;

        // Creating a new array that is one more large than origin one
        Book[] newBookArray = new Book[bookCount];

        // Copy the origin array
        System.arraycopy(bookArray, 0, newBookArray, 0, bookArray.length);
        Book book = new Book(bookName, authorName, description, bookId);
        newBookArray[bookArray.length] = book;
        bookArray = newBookArray;
        bookId++;
    }

    public Book getBookById(int bookId){
        /* Get Book by BookId
         *
         */
        for(Book book : bookArray){
            if(book.getBookId() == bookId){
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int bookId) {
        /* Delete book by bookId
         * */
        boolean flag = false;
        // To find if this book exist
        if (getBookById(bookId) != null) {
            flag = true;
        }
        if (flag) {
            // Book exist, delete and build the new book array
            bookCount--;
            Book[] newBookArray = new Book[bookCount];
            // Copy Book from the original array to the new array, skipping the book at the specified id
            for (int i = 0, j = 0; i < bookArray.length; i++) {
                if (bookArray[i].getBookId() != bookId) {
                    newBookArray[j++] = bookArray[i];
                }
            }
            bookArray = newBookArray;
            return true;
        }else{
            // Book doesn't exist, return false
            return false;
        }
    }
}
