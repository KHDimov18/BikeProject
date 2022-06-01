package controllers;

import models.User;

import java.util.Scanner;

public class HomeController {
    public static User loggedUser = null;
    private UserController userController;

    public HomeController(UserController userController) {
        this.userController = userController;
    }

    private void printMenu() {
        System.out.println("WELCOME TO THE BIKE APP!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    private void getCommand() {
        Scanner sc = new Scanner(System.in);
        printMenu();

        Integer command = Integer.parseInt(sc.nextLine());
        while(command!=3) {
            switch(command) {
                case 1:
                    userController.login();
                    break;
                case 2:
                    userController.register();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Wrong command!");
            }
            if(HomeController.loggedUser!=null) {
                System.out.println("Logged as: " + loggedUser.getUserName());
                break;
            }
            printMenu();

            command = Integer.parseInt(sc.nextLine());
        }

    }

    public void run() {
        getCommand();

    }
}
