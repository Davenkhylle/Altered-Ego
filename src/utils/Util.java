package utils;

import java.util.*;

public class Util {
    private static final Random random = new Random();

    public static int randomInt(int min, int max) {
        if(min > max) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value.");
        }
        return random.nextInt(min, max + 1);
    }
}
