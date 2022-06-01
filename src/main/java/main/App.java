package main;

import controllers.HomeController;
import controllers.UserController;
import repositories.CustomerRepository;
import repositories.UserRepository;
import services.UserService;

public class App {
    public static void main( String... args ) {
        UserRepository userRepository = new UserRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        UserService userService = new UserService(userRepository, customerRepository);
        UserController userController = new UserController(userService);
        HomeController homeController = new HomeController(userController);
        homeController.run();
    }
}
