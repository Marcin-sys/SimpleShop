package basket.factory;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInputProviderTest {

    @Test
    void getValidIntInput() {
        int min = 0;
        int max = 10;
        String data = "4";
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        Integer expected = 4;
        assertEquals(expected, new UserInputProvider().getValidIntInput(min, max, scanner));
    }
}