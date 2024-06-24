package org.zhen.controller;
import org.zhen.pojo.User;
import org.zhen.service.BookService;
import org.zhen.service.UserService;
import org.zhen.thread.UserThread;

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
                Thread thread = new UserThread(user, userService, bookService);
                thread.start();
                try{
                    thread.join();
                } catch (Exception e){
                    e.printStackTrace();
                }
                user = null;
            }
        }
    }

}
