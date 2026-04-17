import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrainManagementSystem {

    // ---------------- EXISTING CODE ----------------
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    public static class GoodsBogie {
        public String shape;
        public String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
            } finally {
            }
        }

        public void assignCargo(String cargo, List<String> logs) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                logs.add("Cargo assigned successfully -> " + cargo + " (for " + shape + ")");
            } catch (CargoSafetyException e) {
                logs.add("Error: " + e.getMessage() + " (for " + shape + ")");
            } finally {
                logs.add("Cargo validation completed for " + shape + " bogie");
            }
        }

        @Override
        public String toString() {
            return shape + " -> " + (cargo == null ? "No cargo" : cargo);
        }
    }

    // ---------------- ADD THIS PART ----------------

    public static class Bogie {
        public String type;
        public int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Loop filtering (capacity >= 50)
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity >= 50) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream filtering (capacity >= 50)
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity >= 50)
                .collect(Collectors.toList());
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GoodsBogie> bogies = new ArrayList<>();
        List<String> logs = new ArrayList<>();

        System.out.print("How many goods bogies do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print("Enter bogie shape: ");
            String shape = scanner.nextLine();

            GoodsBogie bogie = new GoodsBogie(shape);

            System.out.print("Enter cargo: ");
            String cargo = scanner.nextLine();

            bogie.assignCargo(cargo, logs);
            bogies.add(bogie);
        }

        System.out.println("\nAssignment Log:");
        logs.forEach(System.out::println);

        System.out.println("\nFinal Train Consist:");
        bogies.forEach(System.out::println);

        scanner.close();
    }
}