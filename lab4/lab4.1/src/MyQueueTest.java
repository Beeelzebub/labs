import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @org.junit.jupiter.api.Test
    void getLength() {
        MyQueue<Integer> actual = new MyQueue<Integer>();
        actual.push(1);
        actual.push(1);
        actual.push(1);
        int expected = 3;
        assertEquals(actual.getLength(), expected);

    }
}