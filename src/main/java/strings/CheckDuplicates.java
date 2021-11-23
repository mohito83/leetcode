package src.main.java.strings;

public class CheckDuplicates {
    boolean containsDuplicate(String str) {
        boolean result = false;
        byte[] barr = new byte[256];
        for (int i=0; i<str.length(); i++) {
            if(barr[str.charAt(i)] == 0) {
                barr[str.charAt(i)] = 1;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        CheckDuplicates cd = new CheckDuplicates();
        String str = "blue";
        System.out.println("This string: \'"+ str +"\' contains duplicates? " + cd.containsDuplicate(str));
    }
}
