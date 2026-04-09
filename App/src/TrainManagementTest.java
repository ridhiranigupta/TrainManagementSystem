import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class TrainManagementTest {

    private List<Bogie> getBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Sleeper", 70));
        list.add(new Bogie("AC Chair", 60));
        return list;
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> map = getBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.containsKey("Sleeper"));
        assertEquals(2, map.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> map = getBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, map.get("AC Chair").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> map = getBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(3, map.keySet().size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        Map<String, List<Bogie>> map = empty.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> map = list.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, map.size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> map = getBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.containsKey("Sleeper"));
        assertTrue(map.containsKey("AC Chair"));
        assertTrue(map.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> map = getBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, map.get("Sleeper").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = getBogies();

        Map<String, List<Bogie>> map = original.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(5, original.size());
    }
}
