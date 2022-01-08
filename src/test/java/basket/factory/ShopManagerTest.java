package basket.factory;

import basket.Basket;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ShopManagerTest {

    @Test
    void shopManagerMenu() {
    }

    @Test
    void getValidIntInput(){
        int min = 0;
        int max = 10;
        Scanner scanner = new Scanner(System.in);

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        Integer expected = null;
        assertEquals(expected,new ShopManager().getValidIntInput(min,max,scanner));
        System.setIn(sysInBackup);
    }
}