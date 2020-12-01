// 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//
//
//
// 示例 1：
//
//
// 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
// 输出：4
// 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
// 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于
// n 的值 3 。
//
//
// 示例 2：
//
//
// 输入：strs = ["10", "0", "1"], m = 1, n = 1
// 输出：2
// 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
//
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] 仅由 '0' 和 '1' 组成
// 1 <= m, n <= 100
//
// Related Topics 动态规划
// 👍 278 👎 0

import java.util.HashMap;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<String, int[]> dict;

    public int findMaxForm(String[] strs, int m, int n) {
        int max = 0;
        if (strs.length == 0) {
            return max;
        }
        dict = new HashMap<>(strs.length);
        for (String str : strs) {
            int zero = str.replaceAll("1", "").length();
            int one = str.replaceAll("0", "").length();
            dict.put(str, new int[] {zero, one});
        }
        int zero = dict.get(strs[0])[0];
        int one = dict.get(strs[0])[1];
        max = Math.max(findMaxFormPerEle(strs, 1, m, n), max);
        if (m - zero >= 0 && n - one >= 0) {
            max = Math.max(findMaxFormPerEle(strs, 1, m - zero, n - one) + 1, max);
        }
        return max;
    }

    private int findMaxFormPerEle(String[] strs, int i, int m, int n) {
        int max = 0;
        if (i == strs.length) {
            return max;
        }
        int zero = dict.get(strs[i])[0];
        int one = dict.get(strs[i])[1];
        max = Math.max(findMaxFormPerEle(strs, i + 1, m, n), max);
        if (m - zero >= 0 && n - one >= 0) {
            max = Math.max(findMaxFormPerEle(strs, i + 1, m - zero, n - one) + 1, max);
        }
        return max;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
