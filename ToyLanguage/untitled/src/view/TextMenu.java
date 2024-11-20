package view;

import model.adts.MyIMap;
import model.adts.MyMap;
import view.commands.Command;

import java.util.HashMap;
import java.util.Scanner;

import java.util.Map;

public class TextMenu {

    private Map<String, Command> commands;

    public TextMenu() {
        this.commands = new HashMap<>();

    }

    public void addCommand(Command command) {
        this.commands.put(command.getKey(), command);
    }

    private void printMenu() {
        for (Command command : this.commands.values()) {
            String line = String.format("%4s : {\n%s\n}\n", command.getKey(), command.getDescription());
            System.out.println(line);
        }
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.printf("Input your option: ");
            String key = scanner.nextLine();
            if (!this.commands.containsKey(key))
                System.out.println("Invalid option");
            else {
                Command command = this.commands.get(key);
                command.execute();
            }
        }
    }

}
