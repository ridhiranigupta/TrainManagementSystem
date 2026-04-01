import java.util.LinkedHashSet;
import java.util.Set;

public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create a LinkedHashSet to store train formation (unique & ordered)
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies in order
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to attach a duplicate bogie (Sleeper)
        trainFormation.add("Sleeper"); // ignored automatically

        // Display final formation
        System.out.println("\nTrain formation (in insertion order, duplicates ignored):");
        System.out.println(trainFormation);
    }
}