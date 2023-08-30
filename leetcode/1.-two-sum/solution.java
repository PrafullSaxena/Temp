class Solution {

    public int[] twoSum(int[] nums, int target) {
        // return bruteForce(nums, target);
        return withMap(nums, target);
        // return new int[5];
    }

    public int[] withMap(int[] nums, int target) {
        Map<Integer, Integer> memory = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (memory.containsKey(target - nums[i])) {
                result[0] = memory.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                memory.put(nums[i], i);
            }
        }

        return result;
    }

    public int[] bruteForce(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
