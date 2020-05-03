import static org.junit.jupiter.api.Assertions.*;

class TransformTest {

    @org.junit.jupiter.api.Test
    void secondTask() {
        Transform transform = new Transform();
        transform.setStr("11-22-33");
        transform.secondTask();
        String actual = transform.getStr();
        String expected = new String("11-22-33 11-22-33");
        assertEquals(actual, expected);
    }
}