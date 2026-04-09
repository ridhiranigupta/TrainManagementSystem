import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

class Bogie_ {
    String name;
    int capacity;

    Bogie_(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainManagementTest {

    private List<Bogie> getBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("General", 90));
        return list;
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 72)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.capacity == 72));
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 200)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());

        assertEquals(getBogies().size(), result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();

        List<Bogie> result = emptyList.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getBogies();

        List<Bogie> result = original.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(4, original.size());
    }
}
