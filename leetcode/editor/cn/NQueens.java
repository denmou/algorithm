//51

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1190 👎 0


import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        List<List<String>> result = solution.solveNQueens(8);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> result;
        private int n;
        private int[] location;

        public List<List<String>> solveNQueens(int n) {
            result = new ArrayList<>();
            location = new int[n];
            this.n = n;
            go(0);
            return result;
        }

        private void go(int row) {
            if (row >= n) {
                record();
            } else {
                for (int i = 0; i < n; i++) {
                    if (!hasQueen(row, i)) {
                        location[row] = i;
                        go(row + 1);
                    }
                }
            }
        }

        private boolean hasQueen(int row, int column) {
            for (int i = 0; i < row; i++) {
                if (location[i] == column
                        || location[i] + row - i == column
                        || location[i] - row + i == column) {
                    return true;
                }
            }
            return false;
        }

        private void record() {
            List<String> record = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for (int column : location) {
                builder.setLength(0);
                for (int i = 0; i < column; i++) {
                    builder.append(".");
                }
                builder.append("Q");
                for (int i = column + 1; i < n; i++) {
                    builder.append(".");
                }
                record.add(builder.toString());
            }
            result.add(record);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}