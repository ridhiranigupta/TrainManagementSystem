public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println(" UC20 - Defensive Search (Empty Train Handling) ");
        System.out.println("=================================================\n");

        String[] emptyBogieIds = {};
        String searchId = "BG412";

        System.out.println("Scenario: Searching empty train consist...");

        try {
            boolean found = searchBogieDefensively(emptyBogieIds, searchId);
            System.out.println("Result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("\n[ERROR CAUGHT] Operation Stopped Immediately.");
            System.out.println("Message: " + e.getMessage());
        }

        System.out.println("\nUC20 defensive programming completed ...");
    }

    public static boolean searchBogieDefensively(String[] arr, String target) {

        // Defensive check
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Cannot perform search: No bogies exist in the train consist.");
        }

        // Linear search
        for (String id : arr) {
            if (id.equals(target)) {
                return true;
            }
        }

        return false;
    }
}