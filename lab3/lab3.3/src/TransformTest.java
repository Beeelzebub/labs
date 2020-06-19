import static org.junit.jupiter.api.Assertions.*;

class TransformTest {

    @org.junit.jupiter.api.Test
    void perform() {
        Transform transform = new Transform();
        StringBuilder str = new StringBuilder("11-22-33");
        transform.perform(str);
        String actual = transform.getStr();
        String expected = new String("11-22-33 11-22-33");
        assertEquals(actual, expected);
    }
}