package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIiInputArrayIsSorted {

    public static void main(String[] args) {
        int[] result = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    public static
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(target - numbers[i])) {
                    return new int[]{map.get(target - numbers[i]) + 1, i + 1};
                } else {
                    map.put(numbers[i], i);
                }
            }
            return new int[]{-1, -1};
        }*/


        //官方解法 双指针
        public int[] twoSum(int[] numbers, int target) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (sum == target)
                    return new int[]{low + 1, high + 1};
                else if (sum < target)
                    ++low;
                else
                    --high;
            }
            return new int[]{-1, -1};
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}