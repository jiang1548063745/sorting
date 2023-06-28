package learn.leecode;

/**
 * 搜索插入位置
 *
 * @author JiangJian
 * @date 2023/06/28 19:52
 */
public class Solution2 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right--;
            } else {
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8, 10};
        System.out.println(searchInsert(nums, 7));
    }
}
