package leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(array));
        new Solution().moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public static
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public void moveZeroes(int[] nums) {
            int lastNonZeroFoundAt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastNonZeroFoundAt++] = nums[i];
                }
            }
            for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
                nums[i] = 0;
            }
        }*/

        public void moveZeroes(int[] nums) {
            for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
                if (nums[cur] != 0) {
                    swap(nums,lastNonZeroFoundAt++, cur);
                }
            }
        }

        private void swap(int [] nums, int i,int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}