import java.util.Arrays;

/**
 * Custom Test Runner for TrainConsistManagementApp Bubble Sort logic.
 */
public class TrainManagementTest {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" Running Bubble Sort Test Cases ");
        System.out.println("=========================================\n");

        testSort_BasicSorting();
        testSort_AlreadySortedArray();
        testSort_DuplicateValues();
        testSort_SingleElementArray();
        testSort_AllEqualValues();

        System.out.println("\nAll tests execution finished.");
    }

    // --- TEST CASES ---

    static void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        TrainManagementSystem.bubbleSort(capacities);
        checkAndPrintResult("testSort_BasicSorting", expected, capacities);
    }

    static void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        TrainManagementSystem.bubbleSort(capacities);
        checkAndPrintResult("testSort_AlreadySortedArray", expected, capacities);
    }

    static void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        TrainManagementSystem.bubbleSort(capacities);
        checkAndPrintResult("testSort_DuplicateValues", expected, capacities);
    }

    static void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};

        TrainManagementSystem.bubbleSort(capacities);
        checkAndPrintResult("testSort_SingleElementArray", expected, capacities);
    }

    static void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};

        TrainManagementSystem.bubbleSort(capacities);
        checkAndPrintResult("testSort_AllEqualValues", expected, capacities);
    }

    // --- HELPER METHOD ---

    static void checkAndPrintResult(String testName, int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual:   " + Arrays.toString(actual));
        }
    }
}