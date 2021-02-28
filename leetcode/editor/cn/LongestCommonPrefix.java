//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1460 👎 0


import java.util.Scanner;

//Java：最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入strs数组:");
        String value = scanner.nextLine();
        String[] array = Util.toArray(value);
        String result = solution.longestCommonPrefix(array);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder builder = new StringBuilder();
            if (strs.length > 0) {
                String str = strs[0];
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    for (int j = 1; j < strs.length; j++) {
                        if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                            return builder.toString();
                        }
                    }
                    builder.append(c);
                }
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}