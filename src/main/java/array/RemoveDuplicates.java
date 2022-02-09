package array;

/**
 * RemoveDuplicates : RemoveDuplicates
 */
public class RemoveDuplicates {
    public static void main (String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int endIndex = removeDuplicates(arr);
        for (int i=0; i<endIndex; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
             return 0;
        }
        int start = 0, end=1;
        while (end < arr.length) {
            if (arr[start] != arr[end]) {
                start++;
                arr[start] = arr[end];
            }
            end++;
        }

        return start++;
    }
}
