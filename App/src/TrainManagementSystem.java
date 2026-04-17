import java.util.Arrays;

/**
 * MAIN CLASS - TrainManagementSystem
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 */
public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("===============================================\n");

        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogies) + "\n");

        sortBogies(bogies);

        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogies) + "\n");

        System.out.println("UC17 sorting completed ...");
    }

    // Method used in test
    public static void sortBogies(String[] arr) {
        Arrays.sort(arr);
    }
}