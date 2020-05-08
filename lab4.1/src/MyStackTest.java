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

    @org.junit.jupiter.api.Test
    void push(){
        MyStack actual = new MyStack();
        actual.push(1);
        boolean expected = false;
        assertEquals(actual.isEmpty(), expected);
    }

    @org.junit.jupiter.api.Test
    void pull(){
        MyStack actual = new MyStack();
        actual.push(1);
        int temp = (Integer) actual.pull();
        boolean expected = true;
        assertEquals(actual.isEmpty(), expected);
    }

}