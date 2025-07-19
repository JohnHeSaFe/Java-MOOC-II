package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            if (command.equals("1")) {
                list();
            }
            if (command.equals("2")) {
                add();
            }
            if (command.equals("3")) {
                markAsDone();
            }
            if (command.equals("4")) {
                remove();
            }
        }

        System.out.println("Thank you!");
    }

    private void list() {
        System.out.println("Listing the database contents");
        try {
            for (Todo todo : database.list()) {
                System.out.println(todo);
            }
        } catch (SQLException e) {
            System.out.println("Error: cannot list todos in database");
        }
    }

    private void add() {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();

        try {
            database.add(new Todo(name, description, false));
        } catch (SQLException e) {
            System.out.println("Error: cannot add a todo in database");
        }
    }

    private void markAsDone() {
        System.out.println("\nWhich todo should be marked as done (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());

        try {
            database.markAsDone(id);
        } catch (SQLException e) {
            System.out.println("Error: cannot mark as done a todo in database");
        }
    }

    private void remove() {
        System.out.println("\nWhich todo should be removed (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());

        try {
            database.remove(id);
        } catch (SQLException e) {
            System.out.println("Error: cannot remove a todo in database");
        }
    }
}
