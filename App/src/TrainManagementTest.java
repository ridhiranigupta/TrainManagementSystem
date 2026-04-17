import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementTest {

    @Test
    void testException_ValidCapacityCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        UseCase14TrainConsistMgmnt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 50);
        assertNotNull(bogie);
        assertEquals(50, bogie.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        UseCase14TrainConsistMgmnt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        List<UseCase14TrainConsistMgmnt.PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72));
        bogies.add(new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 80));
        bogies.add(new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 100));
        assertEquals(3, bogies.size());
    }
}