//
// 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 474 👎 0
/*
5,3,.,.,7,.,.,.,.
6,.,.,1,9,5,.,.,.
.,9,8,.,.,.,.,6,.
8,.,.,.,6,.,.,.,3
4,.,.,8,.,3,.,.,1
7,.,.,.,2,.,.,.,6
.,6,.,.,.,.,2,8,.
.,.,.,4,1,9,.,.,5
.,.,.,.,8,.,.,7,9
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Java：有效的数独
public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入board数组:");
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) {
            String value = scanner.nextLine();
            char[] item = Util.toCharArray(value);
            board[i] = item;
        }
        Object result = solution.isValidSudoku(board);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character>[][] set = new HashSet[3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (set[0][i] == null) {
                            set[0][i] = new HashSet<>();
                        }
                        if (set[0][i].contains(board[i][j])) {
                            return false;
                        } else {
                            set[0][i].add(board[i][j]);
                        }
                        if (set[1][j] == null) {
                            set[1][j] = new HashSet<>();
                        }
                        if (set[1][j].contains(board[i][j])) {
                            return false;
                        } else {
                            set[1][j].add(board[i][j]);
                        }
                        int index = i / 3 * 3 + j / 3;
                        if (set[2][index] == null) {
                            set[2][index] = new HashSet<>();
                        }
                        if (set[2][index].contains(board[i][j])) {
                            return false;
                        } else {
                            set[2][index].add(board[i][j]);
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}