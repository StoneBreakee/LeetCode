// 给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出: [[1,6],[8,10],[15,18]]
// 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
// 输出: [[1,5]]
// 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组
// 👍 703 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            int gap = o1[0] - o2[0];
            if (gap == 0) {
                return o2[1] - o1[1];
            }
            return gap;
        });
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(intervals[i][1], right);
            } else {
                int[] tmp = new int[2];
                tmp[0] = left;
                tmp[1] = right;
                list.add(tmp);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        int[] tmp = new int[2];
        tmp[0] = left;
        tmp[1] = right;
        list.add(tmp);

        return list.toArray(new int[list.size()][]);
    }
}
// leetcode submit region end(Prohibit modification and deletion)
