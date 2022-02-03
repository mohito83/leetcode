package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * RomanToInteger : RomanToInteger
 */
public class RomanToInteger {
    private final Map<Character, Integer> map;
    public RomanToInteger() {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInteger r2i = new RomanToInteger();
        String roman = "MCMXCIV";
        System.out.println("Roman:" + roman + " Integer: " + r2i.convertToInteger(roman));
    }

    private int convertToInteger(String roman) {
        if (roman == null || roman.length() == 0) {
            return 0;
        }

        int result = 0;
        char prev = ' ';
        for (int i=roman.length()-1; i>=0; i--) {
            char curr = roman.charAt(i);
            int currVal = map.get(curr);
            int prevVal = 0;
            if (prev != ' ') {
                prevVal = map.get(prev);
            }
            if (prevVal > currVal) {
                result -= currVal;
            } else {
                result += currVal;
            }
            prev = curr;
        }

        return result;
    }

}
