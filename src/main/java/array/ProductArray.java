package array;

/**
 * ProductArray : ProductArray
 *
 * @author: Mohit Aggarwal (mohitw@cisco.com)
 * @version: 0.1 1/9/22
 * @since: 0.1 1/9/22
 */
public class ProductArray {
    public static void main(String[] arr) {
        ProductArray pa = new ProductArray();
        int[] a = {1,2,3};
        int[] result = pa.getProductArray(a);

        for (int n : result) {
            System.out.println(n);
        }
    }

    private int[] getProductArray(int[] arr) {
        int[] pre = new int[arr.length];
        int[] post = new int[arr.length];
        int[] result = new int[arr.length];
        pre[0] = 1; post[arr.length-1] = 1;

        for (int i=1; i<arr.length; i++) {
            pre[i] = pre[i-1]*arr[i-1];
        }

        for (int i=arr.length-2; i>=0; i--) {
            post[i] = post[i+1]*arr[i+1];
        }

        for (int i=0; i<arr.length; i++) {
            result[i] = pre[i] * post[i];
        }

        return result;
    }
}
