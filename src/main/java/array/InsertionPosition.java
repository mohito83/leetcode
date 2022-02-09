package array;

/**
 * InsertionPosition : InsertionPosition
 *
 * @author: Mohit Aggarwal (mohitw@cisco.com)
 * @version: 0.1 2/8/22
 * @since: 0.1 2/8/22
 */
public class InsertionPosition {
    public static void main (String[] args) {
        InsertionPosition ip = new InsertionPosition();
        int[] arr = {1,3,5,6};
        int target = 2;
        System.out.println("Insertion location: " + ip.getInsertionLocation(arr, target));
    }

    private int getInsertionLocation(int[] arr, int target) {
        int location = -1, start=0, end=arr.length, mid=0;
        while(start < end) {
            mid = (start+end)/2;
            if (arr[mid] > target) {
                end = mid-1;
            } else if (arr[mid] < target) {
                start = mid+1;
            } else {
                location = mid;
                return location;
            }
        }
        if (location == -1) {
            if (arr[mid] > target){
                location = mid;
            } else {
                location = mid+1;
            }
        }

        return location;
    }
}
