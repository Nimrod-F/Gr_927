package view;

import controller.Controller;
import exception.RepoException;
import model.Apple;
import model.Book;
import model.Cake;
import model.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    Controller controller;
    double weight;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void readWeight(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter weight in kg: ");
            try {
                weight = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
    }

    public void display() {
        Item[] filteredItems = controller.filterByWeight(weight);

        for(Item item : filteredItems) {
            if(item == null){
                break;
            }
            System.out.println(item);
        }
    }

    public void displayMenu() {
        System.out.println("Choose option:");
        System.out.println("1. Populate in-memory items");
        System.out.println("2. Display Items");
        System.out.println("3. Filter Items");
        System.out.println("4. Exit");
    }

    private void populate() throws RepoException {
        controller.add(new Apple(10, "Jonathan", "Red"));
        controller.add(new Book(20, "some book", "some type"));
        String[] ingredients = new String[4];
        ingredients[0] = "apple";
        ingredients[1] = "red";
        ingredients[2] = "some type";
        ingredients[3] = "some color";
        controller.add(new Cake(30, "cake name", ingredients));
    }

    public void run() throws RepoException {
        while(true) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch(option) {
                case 1: // add
                    populate();
                    break;
                case 2: // display
                    display();
                    break;
                case 3: // filter
                    readWeight();
                    display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
