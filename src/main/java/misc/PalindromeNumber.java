package misc;

/**
 * PalindromeNumber : PalindromeNumber
 *
 */
public class PalindromeNumber {

    public static void main (String[] args) {
        int num = 1331;
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println("Is palindrome? " + pn.isPalindrome(num));
    }

    private boolean isPalindrome(int num) {
        boolean result = false;
        if (num < 0) {
            return result;
        }
        int orig = num;
        int newnum = 0;
        while (orig > 0) {
            int r = orig%10;
            newnum = newnum*10 + r;
            orig = orig/10;
        }
        result = newnum == num;
        return result;
    }
}
