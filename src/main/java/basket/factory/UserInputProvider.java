package basket.factory;

import java.util.Scanner;

public class UserInputProvider {
    public int getValidIntInput(int min, int max, Scanner scanner) {
        Integer result = null;
        do {
            if (result != null) {
                System.out.println("Invalid value, " +
                        "must be an integer value between "
                        + min + " and " + max);
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid value, " +
                        "must be an integer value between "
                        + min + " and " + max);
                scanner.next();
            }
            result = scanner.nextInt();
        } while (result < min || result > max);
        return result;
    }
}
