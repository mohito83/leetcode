package src.main.java.strings;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindromePermutation {
    boolean isPalindromePermutation(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i =0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            if (map.containsKey(str.charAt(i))) {
                int val = map.get(str.charAt(i));
                map.put(str.charAt(i), ++val);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        int count = 0;
        for (char c : map.keySet()) {
            int val = map.get(c);
            if (val %2 ==1){
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        CheckPalindromePermutation cpc = new CheckPalindromePermutation();
        String str = "tact coa";
        System.out.println("Is string: "+str +" palindrome permutation? "+ cpc.isPalindromePermutation(str));
    }
}
