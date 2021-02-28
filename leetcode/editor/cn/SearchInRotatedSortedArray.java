//
// 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1192 👎 0


import java.util.Scanner;

//Java：搜索旋转排序数组
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入n值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        Object result = solution.search(nums, target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int index;
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                index = (start + end) / 2;
                if (nums[index] > nums[end]) {
                    if (start == index) {
                        break;
                    }
                    start = index;
                } else {
                    end = index;
                }
            }
            if (nums[nums.length - 1] >= target) {
                start = end;
                end = nums.length - 1;
            } else {
                start = 0;
                end = Math.max(0, end - 1);
            }
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            if (start == end) {
                return -1;
            }
            index = (end + start) / 2;
            while (start + 1 < end && nums[end] > target) {
                if (nums[index] == target) {
                    return index;
                } else if (nums[index] > target) {
                    end = index;
                    index = (end + start) / 2;
                } else {
                    start = index;
                    index = (end + start) / 2;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}