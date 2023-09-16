import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class MatrixConsole {

    public static void main(String[] args) {
        Console c = System.console();
        boolean cancle = false;
        while (!cancle) {
            homeScreen();
            System.out.print("\n\tPress q to cancle or any key for continue....");

            String key = c.readLine();
            if (key != null && key.length() > 0) {
                if (key.charAt(0) == 'q' || key.charAt(0) == 'Q') {
                    cancle = true;
                }
            }
        }
    }

    public static String[] options = { "Addition", "Subtraction", "Multiplication" };

    public static void homeScreen() {
        Scanner in = new Scanner(System.in);
        clearScreen(); // clear the console
        heading(); // Heading of the application
        int option = getMatrixOption(); // Matrix opration options
        // Get row and column
        System.out.print("\n\tEnter row of the matrix: ");
        int rowOfMatrix = in.nextInt();
        System.out.print("\n\tEnter column of the matrix: ");
        int column = in.nextInt();

        int[][] firstMatrix = getMatrix(rowOfMatrix, column);
        int[][] secondMatrix = getMatrix(rowOfMatrix, column);
        int[][] result = getResult(firstMatrix, secondMatrix, option, rowOfMatrix, column);

        // Printing the result
        System.out.println("\n\t----------------First matrix-----------------");

        printMatrix(firstMatrix);

        System.out.println("\n\t----------------Second matrix-----------------");
        printMatrix(secondMatrix);

        System.out.println("\n\t----------------Answer of matrix-----------------");
        printMatrix(result);

        // in.close();

    }

    public static int[][] getMatrix(int row, int col) {

        int[][] matrix = new int[row][col];

        Scanner in = new Scanner(System.in);

        System.out.print("\n\tEnter the value for the " + row + " X " + col + " matrix: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        return matrix;

    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < matrix[i].length; j++) {
                // printing the first matrix
                System.out.printf(" %-6s ", matrix[i][j], "", "");

            }
            System.out.println();

        }

    }

    public static int[][] getResult(int[][] m1, int[][] m2, int option, int row, int col) {
        int[][] result = {};
        String operation = options[option - 1];
        // "Addition", "Subtraction", "Multiplication"
        switch (operation) {
            case "Addition":
                result = matixAddition(m1, m2, row, col);
                break;
            case "Subtraction":
                result = matixSubtraction(m1, m2, row, col);
                break;
            case "Multiplication":
                result = matixMultiply(m1, m2, row, col);
                break;
            default:
                break;
        }
        return result;
    }

    public static int getMatrixOption() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        int optCount = 1;
        for (String opt : options) {
            System.out.print("\t" + optCount + "." + opt);
            optCount++;
        }
        System.out.print("\n\n\tEnter your choice:");
        int choice = in.nextInt();
        if (choice > options.length || choice < 1) {
            printMessage("Error: Please enter valid option,Press any key for continue....");
            waiting();// waiting for input
            homeScreen();
        }

        return choice;
    }

    public static void waiting() {
        Console c = System.console();
        c.readLine();
    }

    public static void printMessage(String message) {
        System.out.print("\n\n\t" + message);
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

    // Matrix operations Addition, Subtract and Multiplication

    public static int[][] matixAddition(int[][] m1, int[][] m2, int row, int col) {
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return result;

    }

    public static int[][] matixSubtraction(int[][] m1, int[][] m2, int row, int col) {
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = m1[i][j] - m2[i][j];
            }
        }

        return result;

    }

    public static int[][] matixMultiply(int[][] m1, int[][] m2, int row, int col) {
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int calculation = 0;
                for (int k = 0; k < row; k++) {
                    calculation += m1[i][k] * m2[k][j];
                }
                result[i][j] = calculation;
            }
        }

        return result;

    }
}
