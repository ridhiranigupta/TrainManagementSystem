import org.junit.Test;
import java.util.*;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

public class TrainManagementTest {

    private boolean isValidTrainId(String trainId) {
        return Pattern.matches("TRN-\\d{4}", trainId);
    }

    private boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRN-123"));
        assertFalse(isValidTrainId("1234-TRN"));
        assertFalse(isValidTrainId("trn-12"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-VR"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET- PVR"));
        assertFalse(isValidCargoCode("PET-V"));
        assertFalse(isValidCargoCode("PET-12"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-1"));
        assertFalse(isValidTrainId("TRN-12"));
        assertFalse(isValidTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-vr"));
        assertFalse(isValidCargoCode("pet-vr"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId("TRN-1234X"));
        assertFalse(isValidCargoCode("PET-ABC"));
    }
}