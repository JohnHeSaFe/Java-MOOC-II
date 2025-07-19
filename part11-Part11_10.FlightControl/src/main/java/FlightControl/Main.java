package FlightControl;

import java.util.Scanner;

import FlightControl.controller.FlightControl;
import FlightControl.view.TextUI;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        FlightControl flightControl = new FlightControl();
        TextUI ui = new TextUI(flightControl, scanner);

        ui.start();
    }
}
