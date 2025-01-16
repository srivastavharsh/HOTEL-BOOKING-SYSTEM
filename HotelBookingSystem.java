import java.util.Scanner;
import java.util.ArrayList;

public class HotelBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Room> availableRooms = new ArrayList<>(); // Initialize with available rooms

        while (true) {
            System.out.println("Start");
            System.out.print("Login or Registration? (Yes/No): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Yes")) {
                // Validate login credentials
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (validateCredentials(username, password)) {
                    // Search available rooms
                    availableRooms = searchAvailableRooms();
                    displayAvailableRooms(availableRooms);
                } else {
                    System.out.println("Invalid credentials. Retry login/registration.");
                }
            } else if (choice.equalsIgnoreCase("No")) {
                // Registration logic
                System.out.println("Registration process...");
            } else {
                System.out.println("Invalid input. Please enter Yes or No.");
            }

            // Room selection by customer
            System.out.print("Enter room number to select: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Enter personal and payment details
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter contact: ");
            String contact = scanner.nextLine();
            System.out.print("Enter payment details: ");
            String paymentDetails = scanner.nextLine();

            // Validate payment
            if (validatePayment(paymentDetails)) {
                // Check room availability
                if (isRoomAvailable(roomNumber, availableRooms)) {
                    // Confirm booking
                    confirmBooking(name, contact, roomNumber);
                    updateRoomAvailability(roomNumber, availableRooms);
                    System.out.println("Booking confirmed!");
                } else {
                    System.out.println("Room not available. Please retry.");
                }
            } else {
                System.out.println("Payment failed. Please retry payment.");
            }

            // Admin booking management
            System.out.println("Admin booking management:");
            System.out.println("1. Modify Booking");
            System.out.println("2. Cancel Booking");
            System.out.print("Enter your choice: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (adminChoice) {
                case 1:
                    // Modify booking logic
                    break;
                case 2:
                    // Cancel booking logic
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println("End");
        }
    }

    // Helper methods (implement according to your specific requirements)
    private static boolean validateCredentials(String username, String password) {
        // Your logic to validate credentials
        return true; // Placeholder
    }

    private static ArrayList<Room> searchAvailableRooms() {
        // Your logic to search available rooms from database
        return new ArrayList<>(); // Placeholder
    }

    private static void displayAvailableRooms(ArrayList<Room> rooms) {
        // Your logic to display available rooms
    }

    private static boolean validatePayment(String paymentDetails) {
        // Your logic to validate payment details
        return true; // Placeholder
    }

    private static boolean isRoomAvailable(int roomNumber, ArrayList<Room> rooms) {
        // Your logic to check room availability
        return true; // Placeholder
    }

    private static void confirmBooking(String name, String contact, int roomNumber) {
        // Your logic to confirm booking and insert into database
    }

    private static void updateRoomAvailability(int roomNumber, ArrayList<Room> rooms) {
        // Your logic to update room availability in database
    }
}

// Room class (if needed)
class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    // ... other relevant fields

    // Constructor, getters, and setters
}
