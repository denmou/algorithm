//
// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1170 👎 0


import java.util.Scanner;
import java.util.Stack;

//Java：最长有效括号
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入s值:");
        String value = scanner.nextLine();
        Object result = solution.longestValidParentheses(value);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int left = 0;
            int[] length = new int[s.length()];
            int index = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    left++;
                    length[++index] = 0;
                } else {
                    if (left > 0) {
                        left--;
                        int count = length[index--] + 2;
                        if (index > -1) {
                            count += length[index--];
                        }
                        length[++index] = count;
                    } else {
                        length[++index] = 0;
                    }
                }
            }
            int max = 0;
            for (int i = 0; i <= index; i++) {
                int value = length[i];
                if (value > max) {
                    max = value;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}