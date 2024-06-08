package org.zhen.controller;
import org.zhen.pojo.User;
import org.zhen.service.BookService;
import org.zhen.service.UserService;

import java.util.Scanner;

public class MagicOfBooks {
    public static void main(String[] args) {

        UserService userService = new UserService();
        BookService bookService = new BookService();

        Scanner scanner = new Scanner(System.in);

        User user = null;

        while(true){
            if(user == null) {
                // If user is null, display the menu require login or register
                System.out.println("Hello, please register or login:");
                System.out.println("1. Register.");
                System.out.println("2. Login.");
                System.out.println("3. Add book.");
                System.out.println("0. Exit.");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        userService.register();
                        break;
                    case 2:
                        user = userService.login();
                        break;
                    case 3:
                        bookService.addBook();
                        break;
                    case 0:
                        return;

                }
            }else{
                System.out.println("Hello, please select what you want to do:");
                System.out.println("1. See my books.");
                System.out.println("2. Add book to my collection.");
                System.out.println("3. Get book detail.");
                System.out.println("4. Log out.");
                System.out.println("0. Exit.");
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
                    case 4:
                        user = null;
                        break;
                    case 0:
                        return;

                }
            }
        }
    }

}
