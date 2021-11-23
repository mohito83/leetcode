package src.main.java.strings;

public class CheckIfPermutation {
    boolean isPermutation (String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        boolean result = true;

        byte[] barr = new byte[256];

        for (int i=0; i< str1.length(); i++) {
            barr[str1.charAt(i)]++;
        }

        for (int i=0; i< str2.length(); i++) {
            if (--barr[str2.charAt(i)] < 0) {
                result = false;
                break;
            }
        }
        return  result;
    }

    public static void main (String[] args) {
        CheckIfPermutation cp = new CheckIfPermutation();
        System.out.println("Is Permutation Strings? " + cp.isPermutation("baba","abba"));
    }
}
