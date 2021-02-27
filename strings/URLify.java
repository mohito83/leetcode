package strings;

public class URLify {
    String convertToUrl(String str, int len) {
        char[] charr = str.toCharArray();

        for (int i=0; i<str.length(); i++) {
            if (charr[i] == ' ') {
                len = moveCharacter2SpaceRight(charr, i, len);
                charr[i] = '%';
                charr[i+1] = '2';
                charr[i+2] = '0';
            }
        }

        return new String(charr);
    }

    private int moveCharacter2SpaceRight(char[] charr, int start, int len) {
        for (int i=len-1; i>start; i--) {
            charr[i+1] = charr[i];
            charr[i+2] = charr[i];
        }
        return len+2;
    }

    public static void main(String[] args) {
        URLify urLify = new URLify();
        char[] c = {'M','r',' ','J', 'o','h','n', ' ', 'S','m','i','t','h',' ',' ',' ',' ','\0'};
        String str = new String(c);
        System.out.println("Original String: " + str);
        System.out.println("URLified String: " + urLify.convertToUrl(str,13));
    }

}
