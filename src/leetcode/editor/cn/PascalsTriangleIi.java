package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi {

    public static void main(String[] args) {
        List<Integer> row0 = new Solution().getRow(0);
        System.out.println(row0);

        List<Integer> row1 = new Solution().getRow(1);
        System.out.println(row1.toString());

        List<Integer> row2 = new Solution().getRow(2);
        System.out.println(row2.toString());

        List<Integer> row3 = new Solution().getRow(3);
        System.out.println(row3.toString());
    }

    public static
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            int[] ans = new int[rowIndex + 1];
            int index = 0;
            while (index <= rowIndex) {
                for (int j = index; j > 0; j--) {
                    ans[j] = ans[j - 1] + ans[j];
                }
                ans[index] = 1;
                index++;
            }
            List<Integer> result = new ArrayList<>(ans.length);
            for (int num : ans) {
                result.add(num);
            }
            return result;
        }

       /* public List<Integer> getRow(int rowIndex) {
            List<Integer> ans = new ArrayList<>();
            int index = 0;
            while (index <= rowIndex) {
                for (int i = ans.size() - 1; i > 0; i--) {
                    ans.set(i, ans.get(i) + ans.get(i - 1));
                }
                ans.add(1);
                index++;
            }
            return ans;
        }*/

    }
//leetcode submit region end(Prohibit modification and deletion)


}