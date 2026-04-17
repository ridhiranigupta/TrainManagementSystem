import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainManagementTest {

    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    public static class PassengerBogie {
        public String type;
        public int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PassengerBogie> bogies = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        System.out.println("=======================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("=======================================\n");

        System.out.print("How many passenger bogies do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print("Enter bogie type: ");
            String type = scanner.nextLine();

            System.out.print("Enter bogie capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());

            try {
                PassengerBogie bogie = new PassengerBogie(type, capacity);
                bogies.add(bogie);
            } catch (InvalidCapacityException e) {
                errors.add("Error for " + type + ": " + e.getMessage());
            }
        }

        System.out.println("\nSummary Report:");
        System.out.println("Valid Bogies:");
        if (bogies.isEmpty()) {
            System.out.println("None");
        } else {
            bogies.forEach(System.out::println);
        }

        System.out.println("\nErrors:");
        if (errors.isEmpty()) {
            System.out.println("None");
        } else {
            errors.forEach(System.out::println);
        }

        System.out.println("\nUC14 exception handling completed ...");
        scanner.close();
    }
}