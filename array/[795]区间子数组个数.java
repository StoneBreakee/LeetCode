// 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
//
// 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
//
// 例如 :
// 输入:
// A = [2, 1, 4, 3]
// L = 2
// R = 3
// 输出: 3
// 解释: 满足条件的子数组: [2], [2, 1], [3].
//
//
// 注意:
//
//
// L, R 和 A[i] 都是整数，范围在 [0, 10^9]。
// 数组 A 的长度范围在[1, 50000]。
//
// Related Topics 数组
// 👍 94 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = 0;
        int sum = len;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= R) {
                len++;
                if (A[i] >= L) {
                    sum += len;
                } else {
                    int count = 0, backIndex = i;
                    while (backIndex >= 0) {
                        if (A[backIndex] >= L && A[backIndex] <= R) {
                            break;
                        }
                        backIndex--;
                        count++;
                    }
                    if (count > len || backIndex == -1) {
                        continue;
                    } else {
                        sum += len - count;
                    }
                }
            } else if (A[i] > R) {
                len = 0;
            }
        }
        return sum;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
