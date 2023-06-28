package learn.leecode;

/**
 * 找到数组的中间位置
 *
 * @author JiangJian
 * @date 2023/06/28 19:39
 */
public class Solution1 {

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     *
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     *
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     *
     */
    public static int findMiddleIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 左侧值 X 2 + 当前指针值 = 总数值
            if (max * 2 + nums[i] == total) {
                return i;
            }

            max += nums[i];
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println(findMiddleIndex(nums));
    }
}
