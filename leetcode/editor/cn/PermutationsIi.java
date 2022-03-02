//47

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 957 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入nums数组:");
            String value = scanner.nextLine();
            int[] nums = Util.toIntegerArray(value);
            List<List<Integer>> result = solution.permuteUnique(nums);
            System.out.println("结果为:" + result);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> list;
        private int[] nums;
        private int len;

        public List<List<Integer>> permuteUnique(int[] nums) {
            this.list = new ArrayList<>();
            Arrays.sort(nums);
            this.nums = nums;
            this.len = nums.length;
            action(new ArrayList<>(), 0);
            return this.list;
        }

        private void action(List<Integer> item, int index) {
            if (index < len) {
                for (int i = index; i < len; i++) {
                    int value = nums[i];
                    for (int j = i; j > index; j--) {
                        nums[j] = nums[j - 1];
                    }
                    nums[index] = value;
                    List<Integer> next = new ArrayList<>(item);
                    next.add(nums[index]);
                    action(next, index + 1);
                    for (int j = index; j < i; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[i] = value;
                    while (i + 1 < len && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            } else {
                list.add(item);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}