import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainManagementTest {

    @Test
    void testSearch_ValidArray_ItemFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(TrainManagementSystem.searchBogieDefensively(bogieIds, "BG205"));
    }

    @Test
    void testSearch_ValidArray_ItemNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(TrainManagementSystem.searchBogieDefensively(bogieIds, "BG999"));
    }

    @Test
    void testSearch_EmptyArrayThrowsException() {
        String[] emptyBogies = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            TrainManagementSystem.searchBogieDefensively(emptyBogies, "BG101");
        });

        assertEquals("Cannot perform search: No bogies exist in the train consist.", ex.getMessage());
    }

    @Test
    void testSearch_NullArrayThrowsException() {
        String[] nullBogies = null;

        assertThrows(IllegalStateException.class, () -> {
            TrainManagementSystem.searchBogieDefensively(nullBogies, "BG101");
        });
    }
}