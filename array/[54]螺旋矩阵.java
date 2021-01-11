// 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1:
//
// 输入:
// [
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
// ]
// 输出: [1,2,3,6,9,8,7,4,5]
//
//
// 示例 2:
//
// 输入:
// [
// [1, 2, 3, 4],
// [5, 6, 7, 8],
// [9,10,11,12]
// ]
// 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
//
// Related Topics 数组
// 👍 578 👎 0

import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0, maxRow = matrix.length - 1, minCol = 0, maxCol = matrix[0].length - 1, len = 0;
        List<Integer> list = new ArrayList<>();
        int count = matrix.length * matrix[0].length;
        while (list.size() < matrix.length * matrix[0].length) {
            // 向右
            for (int i = minCol; i <= maxCol && list.size() < count; i++) {
                list.add(matrix[minRow][i]);
            }
            // 向下
            for (int i = minRow + 1; i <= maxRow && list.size() < count; i++) {
                list.add(matrix[i][maxCol]);
            }
            // 向左
            for (int i = maxCol - 1; i >= minCol && list.size() < count; i--) {
                list.add(matrix[maxRow][i]);
            }
            // 向上
            for (int i = maxRow - 1; i > minRow && list.size() < count; i--) {
                list.add(matrix[i][minCol]);
            }
            minRow++;
            minCol++;
            maxRow--;
            maxCol--;
        }
        return list;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
