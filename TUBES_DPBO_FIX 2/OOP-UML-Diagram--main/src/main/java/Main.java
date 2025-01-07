import ActivityDiagram.*;
import ClassDiagram.*;
import UseCase.*;
import Sequence.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Main Menu DUML:");
            System.out.println("1. Activity Diagram");
            System.out.println("2. Use Case Diagram");
            System.out.println("3. Sequence Diagram");
            System.out.println("4. Class Diagram");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        MainActivity mainActivity = new MainActivity();
                        mainActivity.main(args);
                        break;
                    case 2:
                        MainUsecase mainUsecase = new MainUsecase();
                        mainUsecase.main(args);
                        break;
                    case 3:
                        MainSequence mainSequence = new MainSequence();
                        mainSequence.main(args);
                        break;
                    case 4:
                        MainClassDiagram mainClassDiagram = new MainClassDiagram();
                        mainClassDiagram.main(args);
                        break;
                    case 5:
                        System.out.println("Bye Bye..");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear invalid input
            }

        } while (choice != 5);

        scanner.close();
    }
}