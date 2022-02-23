//52

//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// Related Topics 回溯 👍 334 👎 0


public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        int count = solution.totalNQueens(8);
        System.out.println(count);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count;
        private int n;
        private int[] location;
        
        public int totalNQueens(int n) {
            count = 0;
            this.n = n;
            location = new int[n];
            go(0);
            return count;
        }
        
        private void go(int row) {
            if (row >= n) {
                count++;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}