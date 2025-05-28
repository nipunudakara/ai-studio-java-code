import java.util.InputMismatchException; // Used for catching non-numeric input
import java.util.Scanner;             // Used for getting user input

public class Main {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Java Calculator!");

        // Loop to allow multiple calculations
        while (true) {
            double num1 = 0;
            double num2 = 0;
            char operator = ' ';
            double result = 0;
            boolean isValidOperation = true; // Flag to check if the current operation is valid

            // --- Step 1: Get the first number ---
            System.out.print("\nEnter first number: ");
            try {
                num1 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
                isValidOperation = false;
                continue; // Skip the rest of this iteration and start over
            }

            // --- Step 2: Get the operator ---
            System.out.print("Enter an operator (+, -, *, /): ");
            String operatorStr = scanner.next();

            // Validate operator input (must be a single character)
            if (operatorStr.length() == 1) {
                operator = operatorStr.charAt(0); // Get the first character of the input string
            } else {
                System.out.println("Invalid operator. Please enter one of +, -, *, /.");
                isValidOperation = false;
                continue; // Skip the rest of this iteration
            }

            // --- Step 3: Get the second number ---
            System.out.print("Enter second number: ");
            try {
                num2 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
                isValidOperation = false;
                continue; // Skip the rest of this iteration
            }

            // --- Step 4: Perform calculation based on the operator ---
            if (isValidOperation) { // Only proceed if previous inputs were valid
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) { // Division by zero check
                            System.out.println("Error: Cannot divide by zero!");
                            isValidOperation = false; // Mark as invalid operation
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default: // Handles any other unexpected character
                        System.out.println("Error: Invalid operator!");
                        isValidOperation = false;
                        break;
                }
            }

            // --- Step 5: Display the result ---
            if (isValidOperation) { // Only display if the operation was successful
                System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            }

            // --- Step 6: Ask user if they want to perform another calculation ---
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().toLowerCase(); // Read choice and convert to lowercase

            if (!choice.equals("yes")) {
                break; // Exit the while loop if the user doesn't type "yes"
            }
        }

        // Close the scanner to release system resources
        scanner.close();
        System.out.println("Calculator closed. Goodbye!");
    }
}