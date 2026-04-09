import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainManagementSystem {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(bogie -> {
                    if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                        return bogie.cargo.equalsIgnoreCase("Petroleum");
                    }
                    return true;
                });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.print("How many bogies do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print("Enter bogie type (e.g., Cylindrical, Open, Box): ");
            String type = scanner.nextLine();
            System.out.print("Enter cargo (e.g., Petroleum, Coal, Grain): ");
            String cargo = scanner.nextLine();
            goodsBogies.add(new GoodsBogie(type, cargo));
        }

        System.out.println("\nGoods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = isTrainSafe(goodsBogies);
        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed ...");
        scanner.close();
    }
}