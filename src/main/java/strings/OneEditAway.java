package strings;

public class OneEditAway {
    boolean isOneEditingAway (String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        if (str2.length() > str1.length()) {
            return isOneEditingAway(str2, str1);
        }

        int count = 0;
        int i=0, j=0;
        for (; i<str1.length() && j<str2.length(); ) {
            if (str1.charAt(i) != str2.charAt(j)) {
                count++;

                if (str1.charAt(i+1) == str2.charAt(j)) {
                    j--;
                }
            }
            i++;
            j++;
        }
        if (i<str1.length()) {
            count++;
        }

        return count <=1;
    }

    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        String str1 = "cake";
        String str2 = "bakes";

        System.out.println(oneEditAway.isOneEditingAway(str1, str2));
    }

}
