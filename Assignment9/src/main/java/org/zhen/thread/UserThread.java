package org.zhen.thread;

import org.zhen.pojo.User;
import org.zhen.service.BookService;
import org.zhen.service.UserService;

import java.util.Scanner;

public class UserThread extends Thread{
    User user;
    UserService userService;
    BookService bookService;

    public UserThread(User user, UserService userService, BookService bookService) {
        this.user = user;
        this.userService = userService;
        this.bookService = bookService;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Hello, please select what you want to do:");
            System.out.println("1. See my books.");
            System.out.println("2. Add book to my collection.");
            System.out.println("3. Get book detail.");
            System.out.println("0. Log out.");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    userService.printUserBookSummary(user, bookService);
                    break;
                case 2:
                    userService.addBookToUserCollection(user, bookService);
                    break;
                case 3:
                    bookService.getBookDetail();
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }

}