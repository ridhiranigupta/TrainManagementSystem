import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainManagementTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainManagementSystem.linearSearch(bogieIds, "BG309");
        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainManagementSystem.linearSearch(bogieIds, "BG999");
        assertFalse(result);
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainManagementSystem.linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainManagementSystem.linearSearch(bogieIds, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(TrainManagementSystem.linearSearch(bogieIds, "BG101"));
    }
}