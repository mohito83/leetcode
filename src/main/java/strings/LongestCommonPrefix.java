package strings;

/**
 * LongestCommonPrefix : LongestCommonPrefix
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix lcf = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest common prefix is: " + lcf.findLongestCommonPrefix(strs));
    }

    private String findLongestCommonPrefix(String[] strs) {
        String seed = strs[0];
        for (int i=1; i<strs.length; i++) {
            seed = commonPrefix(seed, strs[1]);

            if (seed == "") {
                break;
            }
        }
        return seed;
    }

    private String commonPrefix(String seed, String str) {
        int len = Math.min(seed.length(), str.length());
        int commonIndex= -1;
        for (int i=0; i<len; i++) {
            if (seed.charAt(i) == str.charAt(i)) {
                commonIndex++;
            } else {
                break;
            }
        }
        return commonIndex>=0 ? seed.substring(0,commonIndex) : "";
    }

}
