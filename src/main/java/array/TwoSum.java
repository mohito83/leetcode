package array;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum : TwoSum
 *
 * @author: Mohit Aggarwal (mohitw@cisco.com)
 * @version: 0.1 1/16/22
 * @since: 0.1 1/16/22
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] sums = twoSum.getTwoSum(nums, target);
        System.out.println(sums[0] + ", " + sums[1]);
    }

    int[] getTwoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int n = arr[i];
            if (map.containsKey(target - n)) {
                result[0] = map.get(target - n);
                result[1] = i;
                break;
            } else {
                map.put(n, i);
            }
        }
        return result;
    }
}
