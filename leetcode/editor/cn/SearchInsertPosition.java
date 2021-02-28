//
// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 823 👎 0


import java.util.Scanner;

//Java：搜索插入位置
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入n值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        Object result = solution.searchInsert(nums, target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (target > nums[nums.length - 1]) {
                return nums.length;
            }
            if (target < nums[0]) {
                return 0;
            }
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int index = (start + end) / 2;
                if (nums[index] == target) {
                    return index;
                } else if (nums[index] > target) {
                    end = index;
                } else {
                    if (index == start) {
                        start++;
                    } else {
                        start = index;
                    }
                }
            }
            return end;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}