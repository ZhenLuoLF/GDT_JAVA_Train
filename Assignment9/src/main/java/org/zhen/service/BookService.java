package org.zhen.service;

import org.zhen.dao.BookDao;
import org.zhen.pojo.Book;

import java.util.List;
import java.util.Scanner;

public class BookService {
    private BookDao bookDao;
    public BookService() {
        bookDao = new BookDao();
    }

    public void printBookDetail(Book book) {
        System.out.println(book);
        System.out.println("Description:");
        System.out.println(book.getDescription());
    }

    public void getBookDetail(){

        printAllBooksSummary();
        System.out.println("Please input id of which book detail you want to get:");
        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();
        List<Book> books = bookDao.getBookArray();
        for (Book book : books) {
            if (book.getBookId() == bookId){
                printBookDetail(book);
                return;
            }
        }
    }
    public void printAllBooksSummary(){
        List<Book> books = bookDao.getBookArray();
        for(Book book:books){
            System.out.println(book);
        }
    }
    public void printBookSummaryById(int bookId) {
        System.out.println(bookDao.getBookById(bookId));
    }
    public void addBook() {
        /*
        Get book information, add book to book array.
         */
        if(bookDao.getBookCount() == bookDao.getBookLimit()){
            System.out.println("The book you have entered is full.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new book to collection.");
        System.out.println("Please enter the name of the book you would like to add:");
        String bookName = scanner.nextLine();
        System.out.println("Please enter the author of the book you would like to add:");
        String author = scanner.nextLine();
        System.out.println("Please enter the description of the book you would like to add:");
        String description = scanner.nextLine();

        try {
            bookDao.addBook(bookName, author, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
