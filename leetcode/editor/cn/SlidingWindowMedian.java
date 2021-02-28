//中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics Sliding Window 
// 👍 157 👎 0


import java.util.*;

//Java：滑动窗口中位数
public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMedian().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入k值:");
        value = scanner.nextLine();
        int k = Integer.parseInt(value);
        double[] result = solution.medianSlidingWindow(nums, k);
        System.out.print('[');
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                System.out.print(',');
            }
            System.out.print(result[i]);
        }
        System.out.println(']');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            int length = nums.length - k + 1;
            double[] result = new double[length];
            int[] indices;
            if (k % 2 == 0) {
                indices = new int[]{k / 2, k / 2 - 1};
            } else {
                indices = new int[]{k / 2};
            }
            Item[] array = getArray(nums, k);
            result[0] = getMidden(array, indices);
            for (int i = 1; i < length; i++) {
                int nextIndex = i + k - 1;
                Item next = new Item(nextIndex, nums[nextIndex]);
                getNextArray(array, next, i - 1);
                result[i] = getMidden(array, indices);
            }
            return result;
        }

        class Item {
            public Item(int index, int value) {
                this.index = index;
                this.value = value;
            }

            private int index;
            private int value;
        }

        private void getNextArray(Item[] array, Item next, int index) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == null || array[i].index == index) {
                    array[i] = array[i + 1];
                    array[i + 1] = null;
                }
                if (array[i].value > next.value) {
                    Item temp = array[i];
                    array[i] = next;
                    next = temp;
                }
            }
            array[array.length - 1] = next;
        }

        private Item[] getArray(int[] nums, int offset) {
            Item[] array = new Item[offset];
            for (int i = 0; i < offset; i++) {
                array[i] = new Item(i, nums[i]);
            }
            Arrays.sort(array, Comparator.comparingInt(o -> o.value));
            return array;
        }

        private double getMidden(Item[] array, int[] indices) {
            double value = 0D;
            for (int index : indices) {
                value += array[index].value;
            }
            return value / indices.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}