import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @org.junit.jupiter.api.Test
    void sort() {
        ShellSort shellSort = new ShellSort();
        String[] actualFirst = new String[]{"a", "c", "b"};
        shellSort.sort(actualFirst, new StringComparator());
        String[] expectedFirst = new String[]{"a", "b", "c"};
        assertArrayEquals(actualFirst, expectedFirst);
        Integer[] actualSecond = new Integer[] {5, 1, 4, 2, 3, 20};
        shellSort.sort(actualSecond, new StringComparator());
        Integer[] expectedSecond = new Integer[] {1, 2, 3, 4, 5, 20};
        assertArrayEquals(actualSecond, expectedSecond);
    }
}