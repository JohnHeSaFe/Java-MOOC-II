import java.util.Scanner;

public class UserInterface {
    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");

            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("add")) {
                add();
            }

            if (command.equalsIgnoreCase("list")) {
                list();
            }

            if (command.equalsIgnoreCase("remove")) {
                remove();
            }

            if (command.equalsIgnoreCase("stop")) {
                break;
            }
        }
    }

    private void add() {
        System.out.print("To add: ");
        String task = scanner.nextLine();

        list.add(task);
    }

    private void list() {
        list.print();
    }

    private void remove() {
        System.out.print("Which one is removed? ");
        int number = Integer.valueOf(scanner.nextLine());

        list.remove(number);
    }
}
