import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println(" UC9 - Group Bogies by Type");
        System.out.println("===========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogies:\n");

        for (String key : grouped.keySet()) {
            System.out.println("Bogie Type: " + key);
            for (Bogie b : grouped.get(key)) {
                System.out.println("  Capacity -> " + b.capacity);
            }
            System.out.println();
        }

        System.out.println("UC9 grouping completed...");
    }
}
