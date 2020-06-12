package leetcode.editor.cn;

import java.awt.image.CropImageFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>(numRows);
            if (numRows > 0) {
                List<Integer> firstRow = new ArrayList<>(1);
                firstRow.add(1);
                ans.add(firstRow);
            }

            if (numRows > 1) {
                List<Integer> secondRow = new ArrayList<>(1);
                secondRow.add(1);
                secondRow.add(1);
                ans.add(secondRow);
            }

            if (numRows > 2) {
                for (int i = 3; i <= numRows; i++) {
                    List<Integer> prev = ans.get(ans.size() - 1);
                    List<Integer> row = new ArrayList<>(i);
                    for (int j = 0; j < i; j++) {
                        if (j == 0 || j == i - 1) {
                            row.add(1);
                        } else {
                            row.add(prev.get(j - 1) + prev.get(j));
                        }
                    }
                    ans.add(row);
                }
            }

            return ans;
        }*/

        //官解
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            // First base case; if user requests zero rows, they get zero rows.
            if (numRows == 0) {
                return triangle;
            }

            // Second base case; first row is always [1].
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for (int rowNum = 1; rowNum < numRows; rowNum++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(rowNum-1);

                // The first row element is always 1.
                row.add(1);

                // Each triangle element (other than the first and last of each row)
                // is equal to the sum of the elements above-and-to-the-left and
                // above-and-to-the-right.
                for (int j = 1; j < rowNum; j++) {
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }

                // The last row element is always 1.
                row.add(1);

                triangle.add(row);
            }

            return triangle;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}