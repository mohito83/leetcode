package src.main.java.strings;


public class StringCompression {
    String getCompressedString(String str) {
        if (str == null || str.length() <=0) {
            return  str;
        }

        StringBuilder sb = new StringBuilder();
        int i=0, j=i+1, count = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
            } else {
                sb.append(str.charAt(i)).append(count);
                count =1;
                i =j;
            }
            j++;
        }

        sb.append(str.charAt(i)).append(count);

        String result = sb.toString();
        return result.length() > str.length() ? str : result;
    }

    public static void main (String[] args) {
        StringCompression sc = new StringCompression();
        String str  = "aabcccccaaaad";
        System.out.println("Compressed String: " + sc.getCompressedString(str));

        str ="abdc";
        System.out.println("Compressed String: " + sc.getCompressedString(str));
    }
}
