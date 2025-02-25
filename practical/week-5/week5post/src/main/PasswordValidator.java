package main;

import java.util.Scanner;

public class PasswordValidator {

    // Method to validate password length between 5 and 10 characters
    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        int length = password.length();
        return length >= 5 && length <= 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input for the password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Validate the password and display the result
        if (isValidPassword(password)) {
            System.out.println("Valid\npassword: accepted");
        } else {
            System.out.println("Invalid\npassword: rejected");
        }

        // Run basic test cases to ensure correctness
        runTests();

        scanner.close();
    }

    // Basic test cases for TDD approach
    public static void runTests() {
        System.out.println("\nRunning Test Cases:");

        System.out.println("Test 1 (Valid: 'Abc123') - " +
                (isValidPassword("Abc123") ? "Passed" : "Failed"));

        System.out.println("Test 2 (Too short: 'abc') - " +
                (!isValidPassword("abc") ? "Passed" : "Failed"));

        System.out.println("Test 3 (Too long: 'abcdefghijk') - " +
                (!isValidPassword("abcdefghijk") ? "Passed" : "Failed"));

        System.out.println("Test 4 (Empty string: '') - " +
                (!isValidPassword("") ? "Passed" : "Failed"));

        System.out.println("Test 5 (Null input) - " +
                (!isValidPassword(null) ? "Passed" : "Failed"));
    }
}

