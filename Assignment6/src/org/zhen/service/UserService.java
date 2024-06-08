package org.zhen.service;

import org.zhen.dao.UserDao;
import org.zhen.pojo.User;

import java.util.Scanner;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    public void addBookToUserCollection(User user, BookService bookService){
        /*
        * Add book to user's collection. With choice of which collection to add.
        * */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Here's the all book:");
        bookService.printAllBooksSummary();
        System.out.println("Please enter the id of the book you want to add to the collection:");
        int bookId = scanner.nextInt();
        System.out.println("Please select which collection you want to add to:");
        System.out.println("1. New Book.");
        System.out.println("2. Favorite Book.");
        System.out.println("3. Completed Book.");
        int choice = scanner.nextInt();

        int[] collection;
        switch (choice) {
            // Add book to collection base on choice. Creating new array 1 larger than old and replace the old one.
            case 1:
                collection = user.getNewBook();
                int[] newCollection = new int[collection.length + 1];
                System.arraycopy(collection, 0, newCollection, 0, collection.length);
                newCollection[collection.length] = bookId;
                user.setNewBook(newCollection);
                break;
            case 2:
                collection = user.getFavoriteBook();
                int[] favoriteCollection = new int[collection.length + 1];
                System.arraycopy(collection, 0, favoriteCollection, 0, collection.length);
                favoriteCollection[collection.length] = bookId;
                user.setFavoriteBook(favoriteCollection);
                break;
            case 3:
                collection = user.getCompletedBook();
                int[] completedCollection = new int[collection.length + 1];
                System.arraycopy(collection, 0, completedCollection, 0, collection.length);
                completedCollection[collection.length] = bookId;
                user.setCompletedBook(completedCollection);
                break;
        }
    }
    public void printUserBookSummary(User user, BookService bookService) {
        // Print the book id and book name from user's collection

        int[] newBook = user.getNewBook();
        int[] favoriteBook = user.getFavoriteBook();
        int[] completedBook = user.getCompletedBook();

        System.out.println("Here is your new book:");
        for (int i = 0; i < newBook.length; i++) {
            bookService.printBookSummaryById(newBook[i]);
        }

        System.out.println("Here is your favorite book:");
        for (int i = 0; i < favoriteBook.length; i++) {
            bookService.printBookSummaryById(favoriteBook[i]);
        }

        System.out.println("Here is your completed book:");
        for (int i = 0; i < completedBook.length; i++) {
            bookService.printBookSummaryById(completedBook[i]);
        }
    }
    public void register() {
        // Get User information, register and, add user to user array
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your user name");
        String userName = scanner.nextLine();
        System.out.println("Please enter your email address:");
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        if (userDao.getUserCount() == userDao.getUserLimit()) {
            System.out.println("User number reached the limit.");
            return;
        }
        userDao.addUser(userName, password, email);
        System.out.println("Register successful.");

    }
    public User login() {
        /* User login function. Return user if success and null if failed.
        * */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your username:");
        String username = scanner.nextLine();
        System.out.println("Please input your password:");
        String password = scanner.nextLine();

        User user = userDao.getUserByName(username);
        // Check if user exist.
        if(user == null){
            System.out.println("User name does not exist");
            return null;
        }else{
            // check password
            if(password.equals(user.getPassword())){
                return user;
            }else{
                System.out.println("Wrong password");
                return null;
            }
        }
    }
}
