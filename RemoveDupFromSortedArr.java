class RemoveDupFromSortedArr {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int i=0,j=1;
        
        while (j<nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,5,7,9,12,13,13,29,44,44,44,57};
        System.out.println("Length of sorted inetger array after removing all duplicate elements: " + removeDuplicates(arr));
    }
}
