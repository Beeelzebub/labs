import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {

    @org.junit.jupiter.api.Test
    void read() {
        Handler actual = new Handler();
        actual.read("test.csv");
        Enrollee expected = new Enrollee("Jo", "Jo", 100, 100, 100, 100);
        assertEquals(actual.enrolles.get(0), expected);
    }
}