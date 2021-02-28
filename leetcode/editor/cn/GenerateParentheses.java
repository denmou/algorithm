//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1565 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Java：括号生成
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入n值:");
        String value = scanner.nextLine();
        int target = Integer.parseInt(value);
        Object result = solution.generateParenthesis(target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n > 0) {
                generate("(", 1, n - 1, n);
            }
            return result;
        }

        private void generate(String str, int empty, int left, int right) {
            if (left == 0 && right == 0) {
                result.add(str);
            } else {
                if (empty > 0) {
                    generate(str + ")", empty - 1, left, right - 1);
                }
                if (left > 0) {
                    generate(str + "(", empty + 1, left - 1, right);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}