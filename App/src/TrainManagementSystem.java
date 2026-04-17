import java.util.Arrays;

/**
 * MAIN CLASS - TrainManagementSystem
 * Use Case 19: Binary Search for Bogie ID
 */
public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=========================================\n");

        String[] sortedBogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchId = "BG412";

        System.out.println("Available Sorted Bogie IDs:");
        System.out.println(Arrays.toString(sortedBogieIds) + "\n");

        boolean found = binarySearch(sortedBogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }

        System.out.println("\nUC19 search completed ...");
    }

    // Binary Search Method
    public static boolean binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cmp = target.compareTo(arr[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}