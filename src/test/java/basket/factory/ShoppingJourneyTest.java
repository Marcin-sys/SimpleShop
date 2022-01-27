package basket.factory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


class ShoppingJourneyTest {

    @Test
    void shopManagerMenu() {

        ShopService shopService = Mockito.mock(ShopService.class);

        String data = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        ShoppingJourney shop = new ShoppingJourney();
        shop.shopManagerMenu();
        Mockito.doNothing().when(shopService).printAllProductsInShop();
//        Mockito.verify(shopService).printAllProductsInShop();
    }
}