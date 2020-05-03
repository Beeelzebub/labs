import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringComparatorTest {

    @org.junit.jupiter.api.Test
    void compare() {
        String[] actual = new String[]{"abc", "bcd"};
        Arrays.sort(actual, new StringComparator("b"));
        String[] expected = new String[]{"bcd", "abc"};
        assertArrayEquals(actual, expected);
    }
}