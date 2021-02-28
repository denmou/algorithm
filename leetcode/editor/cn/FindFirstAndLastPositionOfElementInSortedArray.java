//
// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 860 👎 0


import java.util.Scanner;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入n值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        int[] result = solution.searchRange(nums, target);
        System.out.println("执行结果为: [" + result[0] + "," + result[1] + "]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] position = new int[]{-1, -1};
            if (nums.length > 0) {
                int start = 0;
                int end = nums.length - 1;
                while (start <= end) {
                    if (nums[start] == target) {
                        position[0] = start;
                        break;
                    }
                    int index = (start + end) / 2;
                    if (nums[index] < target) {
                        start = index + 1;
                    } else {
                        if (start == index) {
                            start += 1;
                        } else {
                            end = index;
                        }
                    }
                }
                start = 0;
                end = nums.length - 1;
                while (start <= end) {
                    if (nums[end] == target) {
                        position[1] = end;
                        break;
                    }
                    int index = (start + end) / 2;
                    if (nums[index] > target) {
                        end = index - 1;
                    } else {
                        if (start == index) {
                            end -= 1;
                        } else {
                            start = index;
                        }
                    }
                }
            }
            return position;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}