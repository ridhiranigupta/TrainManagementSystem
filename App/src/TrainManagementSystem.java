import java.util.Arrays;

/**
 * MAIN CLASS - TrainManagementSystem
 * Use Case 18: Linear Search for Bogie ID
 */
public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=========================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println();

        boolean found = linearSearch(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed ...");
    }

    // Linear Search Method
    public static boolean linearSearch(String[] arr, String target) {
        for (String id : arr) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }
}