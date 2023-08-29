class Solution {

    public void rotate(int[] nums, int k) {
        // withSpace(nums, k);
        usingTwoPointers(nums, k);
    }

    // TC = O(n) SC = O(n)
    public void withSpace(int[] nums, int k) {
        int[] temp = new int[nums.length];

        if (nums.length <= 1) return;

        //will insert the k element at the begining of array
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[index++] = nums[i];
        }

        int numsIndex = 0;
        for (int i = index; i < temp.length; i++) {
            temp[i] = nums[numsIndex++];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    // TC = O(k^n) SC = O(1)
    public void bruteForce(int[] nums, int k) {
        int loop = 1;
        while (loop <= k) {
            int temp = nums[nums.length - 1];

            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }

            nums[0] = temp;

            loop++;
        }
    }
}
