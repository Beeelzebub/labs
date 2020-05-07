import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepairTest {

    @Test
    void works() {
        Repair actual = new Repair();
        actual.gasbagsQueue.push(new Gasbag(1, 99, true));
        actual.gasbagsQueue.push(new Gasbag(2, 1, false));
        actual.startProcess();
        boolean expected = true;
        assertEquals(actual.gasbagsQueue.isEmpty(), expected);
    }
}