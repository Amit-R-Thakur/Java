import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class AdditionOfMatrices {

    public static void main(String[] args) {
        System.out.println("Hey");
        homeScreen();
    }

    public static String[] options = { "Addition", "Subtraction", "Multiplication" };

    public static void homeScreen() {
        clearScreen(); // clear the console
        heading(); // Heading of the application
        int option = getMatrixOption(); // Matrix opration options

    }

    public static int getMatrixOption() {
        Console c = System.console();
        Scanner in = new Scanner(System.in);
        System.out.println();
        int optCount = 1;
        for (String opt : options) {
            System.out.print("\t" + optCount + "." + opt);
            optCount++;
        }
        System.out.print("\n\n\tEnter your choice:");
        int choice = in.nextInt();
        if (choice > options.length || choice < 0) {
            System.out.print("\n\n\tError: Please enter valid option,Press any key for continue....");
            c.readLine();// waiting for input
            homeScreen();
        }

        in.close();
        return choice;
    }

    public static void heading() {

        int terminalWidth = 100;

        String message = "Welcome to Matrix solution Application";
        int welcomePadding = (terminalWidth - message.length()) / 2;
        System.out.println(" " + getDecoration("*", terminalWidth));

        System.out.printf(" *%" + welcomePadding + "s%s%" + (welcomePadding - 2) + "s*\n", "", message, "");
        System.out.println(" " + getDecoration("*", terminalWidth));
        System.out.println();
    }

    // Function to create a decoration string
    public static String getDecoration(String symbol, int width) {
        StringBuilder decoration = new StringBuilder();
        for (int i = 0; i < width; i++) {
            decoration.append(symbol);
        }
        return decoration.toString();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
}