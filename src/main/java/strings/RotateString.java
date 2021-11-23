package strings;

public class RotateString {

    boolean isSubString(String str1, String str2) {
        if (str1 == null || str2 == null) {
             return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        int i=0, j=0;

        while (j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                break;
            }
            j++;
        }

        while (i < str1.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                return  false;
            }
            i++;
            j++;
            if (j == str2.length()) {
                j=0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        System.out.println("Are these src.main.java.strings rotation of on e another? " + rs.isSubString(str1, str2));
    }
}
