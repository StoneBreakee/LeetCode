class Solution {
    /**
     * 1.两部分子数组的和相等，则相当于把原数组的和除与2
     * 2.套用背包思想，dptable的右下角元素与 sum/2 是否相等 即为结果
    */
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int count = Arrays.stream(nums).sum();
        if (count % 2 != 0) {
            return false;
        }
        int target = count >> 1;
        int[][] dptable = new int[nums.length + 1][target + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j >= nums[i - 1]) {
                    dptable[i][j] = Math.max(dptable[i - 1][j], dptable[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dptable[i][j] = dptable[i - 1][j];
                }
            }
        }
        return dptable[nums.length][target] == target;
    }
}
