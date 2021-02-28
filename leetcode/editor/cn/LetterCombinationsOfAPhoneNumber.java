//
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1128 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Java：电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入digits值:");
        String value = scanner.nextLine();
        Object result = solution.letterCombinations(value);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            String[][] keys = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
            String[][] values = new String[digits.length()][];
            for (int i = 0; i < digits.length(); i++) {
                int index = digits.charAt(i) - 50;
                values[i] = keys[index];
            }
            if (values.length > 0) {
                get("", values, result, 0);
            }
            return result;
        }

        private void get(String key, String[][] values, List<String> result, int index) {
            if (index == values.length - 1) {
                for (int i = 0; i < values[index].length; i++) {
                    result.add(key + values[index][i]);
                }
            } else {
                for (int i = 0; i < values[index].length; i++) {
                    get(key + values[index][i], values, result, index + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}