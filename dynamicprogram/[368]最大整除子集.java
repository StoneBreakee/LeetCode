//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 
//
//
// 如果有多个目标子集，返回其中任何一个均可。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
// 
//
// 示例 2: 
//
// 输入: [1,2,4,8]
//输出: [1,2,4,8]
// 
// Related Topics 数学 动态规划 
// 👍 127 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 先使用动态规划算出最长的等比数列
 * <p>
 * 然后对结果进行回推
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int[] dptable = new int[nums.length];
        Arrays.fill(dptable, 1);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dptable[i] = Math.max(dptable[i], dptable[j] + 1);
                }
            }
            if (max < dptable[i]) {
                max = dptable[i];
                maxIndex = i;
            }
        }
        int currentSize = dptable[maxIndex];
        int currentNum = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (currentNum % nums[i] == 0 && currentSize == dptable[i]) {
                list.add(0, nums[i]);
                currentNum = nums[i];
                currentSize--;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
