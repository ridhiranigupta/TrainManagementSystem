import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainManagementSystem.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainManagementSystem.Bogie("Sleeper", 50));
        bogies.add(new TrainManagementSystem.Bogie("AC Chair", 80));

        List<TrainManagementSystem.Bogie> result =
                TrainManagementSystem.filterWithLoop(bogies);

        assertEquals(1, result.size());
        assertEquals(80, result.get(0).capacity);
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainManagementSystem.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainManagementSystem.Bogie("Sleeper", 40));
        bogies.add(new TrainManagementSystem.Bogie("First Class", 100));

        List<TrainManagementSystem.Bogie> result =
                TrainManagementSystem.filterWithStream(bogies);

        assertEquals(1, result.size());
        assertEquals(100, result.get(0).capacity);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainManagementSystem.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            bogies.add(new TrainManagementSystem.Bogie("Bogie-" + i, i * 10));
        }

        List<TrainManagementSystem.Bogie> loopResult =
                TrainManagementSystem.filterWithLoop(bogies);

        List<TrainManagementSystem.Bogie> streamResult =
                TrainManagementSystem.filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
        assertIterableEquals(loopResult, streamResult);
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainManagementSystem.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainManagementSystem.Bogie("Bogie-" + i, i % 100));
        }

        long start = System.nanoTime();
        TrainManagementSystem.filterWithLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainManagementSystem.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new TrainManagementSystem.Bogie("Bogie-" + i, (i % 100) + 1));
        }

        List<TrainManagementSystem.Bogie> loopResult =
                TrainManagementSystem.filterWithLoop(bogies);

        List<TrainManagementSystem.Bogie> streamResult =
                TrainManagementSystem.filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }
}