package Training;
import Training.RegEx.RegExExpressions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        RegExExpressions regExObj = new RegExExpressions();

        while (running) {
            System.out.println("Hello! Let's check my HW. Shoose an option below:" +
                    "\n1. RegEx task" +
                    "\n0. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":

                    System.out.println("You selected RegEx task!");
                    regExObj.doAllTasks();
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Ooops, something went wrong.");
                    break;
            }
        }

        scanner.close();
    }
}
