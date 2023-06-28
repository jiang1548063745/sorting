package learn.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author JiangJian
 * @date 2023/06/28 20:29
 */
public class Solution3 {

    /**
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 对子数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        // 合并后的数组
        List<int[]> merged = new ArrayList<>();

        // 比较每个数组
        for (int[] interval : intervals) {
            // 上一个数组
            int preIndex = merged.size() - 1;

            // 左边界 右边界
            int left = interval[0], right = interval[1];

            // 1. 初始化 2. 上一个数组的右边界小于当前的左边界(意味着两个数组没有重叠关联)
            if (merged.size() == 0 || merged.get(preIndex)[1] < left) {
                // 合并
                merged.add(new int[]{left, right});
            } else {
                // 上一个数组和当前数组有重叠 左侧数组已经排序 确定重叠右边界
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(preIndex)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

//        int[][] intervals = {};

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
