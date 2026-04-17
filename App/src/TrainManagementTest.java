import java.util.Arrays;

/**
 * Custom Test Runner for TrainManagementSystem Arrays.sort() logic
 */
public class TrainManagementTest {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" Running Arrays.sort() Test Cases ");
        System.out.println("=========================================\n");

        testSort_BasicAlphabeticalSorting();
        testSort_UnsortedInput();
        testSort_AlreadySortedArray();
        testSort_DuplicateBogieNames();
        testSort_SingleElementArray();

        System.out.println("\nAll tests execution finished.");
    }

    static void testSort_BasicAlphabeticalSorting() {
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        TrainManagementSystem.sortBogies(bogies);
        checkAndPrintResult("testSort_BasicAlphabeticalSorting", expected, bogies);
    }

    static void testSort_UnsortedInput() {
        String[] bogies = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        TrainManagementSystem.sortBogies(bogies);
        checkAndPrintResult("testSort_UnsortedInput", expected, bogies);
    }

    static void testSort_AlreadySortedArray() {
        String[] bogies = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        TrainManagementSystem.sortBogies(bogies);
        checkAndPrintResult("testSort_AlreadySortedArray", expected, bogies);
    }

    static void testSort_DuplicateBogieNames() {
        String[] bogies = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        TrainManagementSystem.sortBogies(bogies);
        checkAndPrintResult("testSort_DuplicateBogieNames", expected, bogies);
    }

    static void testSort_SingleElementArray() {
        String[] bogies = {"Sleeper"};
        String[] expected = {"Sleeper"};

        TrainManagementSystem.sortBogies(bogies);
        checkAndPrintResult("testSort_SingleElementArray", expected, bogies);
    }

    static void checkAndPrintResult(String testName, String[] expected, String[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual:   " + Arrays.toString(actual));
        }
    }
}