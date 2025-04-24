package com.pluralsight;
import java.util.Scanner;

public class Library {
    private static final Book[] inventory = {
            new Book(1, "978-0-06-025492-6", "Where the Wild Things Are"),
            new Book(2, "978-0-14-240467-6", "Charlotte's Web"),
            new Book(3, "978-0-590-33143-7", "Matilda"),
            new Book(4, "978-0-06-440585-0", "The Giving Tree"),
            new Book(5, "978-0-394-80023-9", "Green Eggs and Ham")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("\nLibrary Home Screen:\n1. Show Available Books\n2. Show Checked-Out Books\nX. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("X")) break;
            else if (choice.equals("1")) showAvailableBooks(scanner);
            else if (choice.equals("2")) showCheckedOutBooks(scanner);
            else System.out.println("Invalid choice, please try again.");
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void showAvailableBooks(Scanner scanner) {
        System.out.println("\nAvailable Books:");
        for (Book book : inventory)
            if (!book.isCheckedOut())
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());

        System.out.print("Enter book ID to check out or 'X' to return: ");
        String bookIdInput = scanner.nextLine().trim().toUpperCase();
        if (bookIdInput.equals("X")) return;

        try {
            int bookId = Integer.parseInt(bookIdInput);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            for (Book book : inventory)
                if (book.getId() == bookId && !book.isCheckedOut()) {
                    book.checkOut(name);
                    return;
                }
            System.out.println("Invalid selection or book already checked out.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a valid book ID or 'X' to return.");
        }
    }

    private static void showCheckedOutBooks(Scanner scanner) {
        System.out.println("\nChecked-Out Books:");
        for (Book book : inventory)
            if (book.isCheckedOut())
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked out by: " + book.getCheckedOutTo());

        System.out.print("Press 'C' to check in a book or 'X' to return: ");
        String userInput = scanner.nextLine().trim().toUpperCase();
        if (userInput.equals("X")) return;
        else if (userInput.equals("C")) {
            System.out.print("Enter book ID to check in: ");
            try {
                int bookId = Integer.parseInt(scanner.nextLine().trim());

                for (Book book : inventory)
                    if (book.getId() == bookId && book.isCheckedOut()) {
                        book.checkIn();
                        return;
                    }
                System.out.println("Invalid selection or book not checked out.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid book ID.");
            }
        } else {
            System.out.println("Invalid input, please enter 'C' to check in or 'X' to return.");
        }
    }
}