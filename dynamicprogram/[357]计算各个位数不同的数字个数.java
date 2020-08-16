//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 79 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int count = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            n = 10;
        }
        int[] arr = new int[n];
        dfs(0, arr, n);
        return count;
    }

    private void dfs(int n, int[] arr, int target) {
        // n之前的有效数字
        int j = 0;
        while (j < n && arr[j] == 0) {
            j++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = j; i < n; i++) {
            set.add(arr[i]);
        }

        if (n == target - 1) {
            count += 10 - set.size();
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (set.contains(i)) {
                continue;
            }
            arr[n] = i;
            dfs(n + 1, arr, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
