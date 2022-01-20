package basket.factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;


class ShoppingJourneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shopManagerMenuTesT(int number) {
        int min = 1;
        int max = 6;

        ShopService shopService = Mockito.mock(ShopService.class);
        UserInputProvider input = Mockito.mock(UserInputProvider.class);


        Mockito.when(input.getValidIntInput(eq(min),
                            eq(max), Mockito.any()))
                    .thenReturn(number, 6);

        ShoppingJourney shoppingJourney = new ShoppingJourney(shopService, input);

        shoppingJourney.shopManagerMenu();
        if (number==1) {
            Mockito.verify(shopService).printAllProductsInShop();
        }else if (number==2){
            Mockito.verify(shopService).addNewProductToBasket(Mockito.any());
        }else if (number==3){
            Mockito.verify(shopService).removeProductFromBasket(Mockito.any());
        }else if (number==4){
            Mockito.verify(shopService).showWhatInsideBasket();
        }else {
            Mockito.verify(shopService).payForBasket();
        }
        }
    }
