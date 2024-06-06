package GDT_JAVA_Train.Assignment5.src.com.infosys.service;
import java.util.Scanner;

import GDT_JAVA_Train.Assignment5.src.com.infosys.dao.UserDAO;
import GDT_JAVA_Train.Assignment5.src.com.infosys.pojo.User;
public class UserService {
    private UserDAO uda = new UserDAO();

    public void registerClient(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input user name:");
        String name = scanner.nextLine();
        System.out.println("Please input user password:");
        String password = scanner.nextLine();
        String role = "Client";

        uda.addUser(name, password, role);
    }
    public void registerVisitor(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input user name:");
        String name = scanner.nextLine();
        System.out.println("Please input user password:");
        String password = scanner.nextLine();
        String role = "Visitor";

        uda.addUser(name, password, role);
    }

    public User userLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your name:");
        String name = scanner.nextLine();
        System.out.println("Please input your password:");
        String password = scanner.nextLine();

        User u = uda.getUserByName(name);
        if(u == null){
            System.out.println("No such user.");
            return null;
        }
        if(!u.getPassword().equals(password)){
            System.out.println("Wrong password.");
            return null;
        }
        System.out.println("Login success!");
        return u;
    }

    
}
