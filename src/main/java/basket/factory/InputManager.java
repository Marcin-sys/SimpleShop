package basket.factory;

import java.util.Scanner;

public class InputManager {
    public Integer SaveInputToFile(){
        Integer result = null;
        try (Scanner scanner = new Scanner(System.in)){
            result = scanner.nextInt();
        }
        return result;
    }
}
