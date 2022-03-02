//46

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1797 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入nums数组:");
            String value = scanner.nextLine();
            int[] nums = Util.toIntegerArray(value);
            List<List<Integer>> result = solution.permute(nums);
            System.out.println("结果为:" + result);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> list;
        private int[] nums;
        private int len;

        public List<List<Integer>> permute(int[] nums) {
            this.list = new ArrayList<>();
            this.nums = nums;
            this.len = nums.length;
            action(new ArrayList<>(), 0);
            return this.list;
        }

        private void action(List<Integer> item, int index) {
            if (index < len) {
                int value = nums[index];
                for (int i = index; i < len; i++) {
                    nums[index] = nums[i];
                    nums[i] = value;
                    List<Integer> next = new ArrayList<>(item);
                    next.add(nums[index]);
                    action(next, index + 1);
                    nums[i] = nums[index];
                    nums[index] = value;
                }
            } else {
                list.add(item);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}