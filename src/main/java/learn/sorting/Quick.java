package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 快速排序
 *  时间复杂度 O(n * log n)
 *  空间复杂度 Log2N
 *  不稳定
 *
 * @author JiangJian
 * @date 2023/06/10 22:59
 */
public class Quick {

    /**
     *
     */
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 6};

        sort(arr, 0, arr.length - 1);

        CommonUtils.printArr(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }

        int mid = partition(arr, leftBound, rightBound);

        sort(arr, leftBound, mid -1);
        sort(arr, mid + 1, rightBound);
    }

    /**
     * 分区方法
     *
     * @param arr 目标数组
     * @param leftBound 左边界
     * @param rightBound 右边界
     * @return 轴值
     */
    public static int partition(int[] arr, int leftBound, int rightBound) {
        // 右边界为轴
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        // 左边界指针未指到右边界
        while (left <= right) {
            // 左边界的值小于轴
            while (left <= right && arr[left] <= pivot) {
                // 左边界指针移动
                left++;
            }

            // 右边界的值大于轴
            while (left <= right && arr[right] > pivot) {
                // 右指针移动
                right--;
            }

            if (left < right) {
                // 当左指针和右指针指向的值都不在对应区间时 交换
                CommonUtils.swap(arr, left, right);
            }
        }

        // 将轴的值换到中间位置
        CommonUtils.swap(arr, left, rightBound);

        return left;
    }
}
