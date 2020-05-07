import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void isEmpty() {
        MyStack actual = new MyStack();
        actual.push(1);
        boolean expected = false;
        assertEquals(actual.isEmpty(), expected);
    }
}