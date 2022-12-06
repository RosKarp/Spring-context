package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        boolean quit= false;
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.context");
        Cart cart = context.getBean(Cart.class);

        label:

        while (!quit){
            System.out.println("Your cart. What do you want?: / all! / add id / del id / show / quit");
            String request = scanner.nextLine();
            try {
                switch (request.substring(0, 4)) {
                    case "all!":
                        cart.addAll();
                        break;
                    case "add ":
                        cart.addProductById(Long.parseLong(request.substring(4)));
                        break;
                    case "del ":
                        cart.deleteProductById(Long.parseLong(request.substring(4)));
                        break;
                    case "show":
                        cart.showCart();
                        break;
                    case "quit":
                        quit = true;
                        break label;
                    default:
                        System.out.println("Enter correct command.");
                        break;
                }
            } catch (RuntimeException a) {
                System.out.println("Product with this id was not found.");
            }
        }
        context.close();
    }
}
