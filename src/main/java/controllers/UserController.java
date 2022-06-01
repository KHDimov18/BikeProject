package controllers;

import services.UserService;

import java.util.Scanner;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your username: ");
        String userPassword = sc.nextLine();

        Boolean isValid = userService.isLogin(userName, userPassword);

        if(isValid) {
            //TODO: check if regular user or admin
            System.out.println("You are logged in successfully!");
            HomeController.loggedUser = userService.getLoggedInUser(userName, userPassword);


        } else {
            System.out.println("Wrong username or password! Please try again!");
        }
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password: ");
        String userPassword = sc.nextLine();
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your phone: ");
        String phoneNumber = sc.nextLine();

        Boolean success = userService.addUser(userName, userPassword, firstName, lastName, phoneNumber);

        if(success)
        {
            System.out.println("User registered successfully!");
        }
        else
        {
            System.out.println("There was a problem with your registeration!");
        }
    }
}
