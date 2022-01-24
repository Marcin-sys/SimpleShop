package basket.factory;

public class TextPrinter implements SystemPrinter {
    @Override
    public void printString(String providedString){
        System.out.println(providedString);
    }
}
