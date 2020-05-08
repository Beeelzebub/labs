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
    @org.junit.jupiter.api.Test
    void push(){
        MyQueue<Integer> actual = new MyQueue<Integer>();
        actual.push(1);
        boolean expected = false;
        assertEquals(actual.isEmpty(), expected);
    }

    @org.junit.jupiter.api.Test
    void pull(){
        MyQueue<Integer> actual = new MyQueue<Integer>();
        actual.push(1);
        int temp = actual.pull();
        boolean expected = true;
        assertEquals(actual.isEmpty(), expected);
    }

}