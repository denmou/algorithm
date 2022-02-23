//37

//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 👍 1129 👎 0


import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入board数组:");
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) {
            String value = scanner.nextLine();
            char[] item = Util.toCharArray(value);
            board[i] = item;
        }
        solution.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j]);
                if (j == 2 || j == 5) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("-----------------------");
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[][] board;
        private final int size = 8;
        private boolean end = false;

        public void solveSudoku(char[][] board) {
            this.board = board;
            go(0, 0);
        }

        private void go(int row, int column) {
            if (row > size) {
                end = true;
            } else {
                if (column > size) {
                    go(row + 1, 0);
                } else if (board[row][column] != '.') {
                    go(row, column + 1);
                } else {
                    for (int i = 1; i <= 9; i++) {
                        char value = (char) (i + '0');
                        if (!exists(row, column, value)) {
                            board[row][column] = value;
                            go(row, column + 1);
                            if (end) {
                                return;
                            } else {
                                board[row][column] = '.';
                            }
                        }
                    }
                }
            }
        }

        private boolean exists(int row, int column, char value) {
            for (int i = 0; i <= size; i++) {
                if (board[row][i] == value || board[i][column] == value) {
                    return true;
                }
            }
            int x = row > 5 ? 6 : (row > 2 ? 3 : 0);
            int y = column > 5 ? 6 : (column > 2 ? 3 : 0);
            int maxX = x + 3;
            int maxY = y + 3;
            for (; x < maxX; x++) {
                for (int i = y; i < maxY; i++) {
                    if (board[x][i] == value) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}