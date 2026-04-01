import java.util.HashMap;
import java.util.Map;

public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create a HashMap to store bogie name -> capacity
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert bogie capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 54);
        bogieCapacityMap.put("First Class", 36);

        // Display bogie capacities
        System.out.println("\nBogie capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }
    }
}