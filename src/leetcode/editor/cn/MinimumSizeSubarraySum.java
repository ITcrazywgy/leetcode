package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int len = new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(len);
    }

    public static
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力解法，超时
        /*public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += nums[k];
                    }
                    if (sum >= s) {
                        ans = Math.min(ans, (j - i + 1));
                        break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                    }
                }
            }
            return (ans != Integer.MAX_VALUE) ? ans : 0;
        }*/

        //优化后的暴力解法
        /*public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0)
                return 0;
            int ans = Integer.MAX_VALUE;
            int[] sums = new int[n];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++)
                sums[i] = sums[i - 1] + nums[i];
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int sum = sums[j] - sums[i] + nums[i];
                    if (sum >= s) {
                        ans = Math.min(ans, (j - i + 1));
                        break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                    }
                }
            }
            return (ans != Integer.MAX_VALUE) ? ans : 0;
        }*/

        // 二分查找
        //sum = sums[j] − sums[i] + nums[i] >= s
        //sums[j] >= s + sums[i] - nums[i]
        int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0)
                return 0;
            int minLen = Integer.MAX_VALUE;
            int[] sums = new int[n];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++)
                sums[i] = sums[i - 1] + nums[i];
            for (int i = 0; i < n; i++) {
                int target = s + sums[i] - nums[i];
                int j = lowerBound(sums, target);
                if (j != -1) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
            return (minLen != Integer.MAX_VALUE) ? minLen : 0;
        }

        //二分查找求下界 大于或等于
        private int lowerBound(int[] nums, int value) {
            int begin = 0, end = nums.length - 1;
            while (begin < end) {
                int mid = (begin + end) / 2;
                if (nums[mid] < value) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (nums[begin] >= value) {
                return begin;
            } else {
                return -1;
            }
        }

        //双指针
        /*int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                while (sum >= s) {
                    ans = Math.min(ans, i - left + 1);
                    sum -= nums[left++];
                }
            }
            return (ans != Integer.MAX_VALUE) ? ans : 0;
        }*/

    }


//leetcode submit region end(Prohibit modification and deletion)


}