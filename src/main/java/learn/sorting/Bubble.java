package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 冒泡排序
 *  时间复杂度 O(n2)  最优时间复杂度O(n)
 *  空间复杂度 1
 *  稳定较高
 *
 * @author JiangJian
 * @date 2023/06/10 22:58
 */
public class Bubble {

    /**
     * 从一个元素开始 两两排序
     */
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        // 最优条件下 只需要循环一次
//        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        sort(arr);
//        printArr(arr);
    }

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean shouldSwap = findMax(arr, i);

            CommonUtils.printArr(arr);

            if (!shouldSwap) {
                return;
            }
        }
    }

    public static boolean findMax(int[] arr, int maxIndex) {
        boolean shouldSwap = false;
        for (int j = 0; j < maxIndex; j++) {
            if (arr[j] > arr[j + 1]) {
                CommonUtils.swap(arr, j+1, j);
                shouldSwap = true;
            }
        }

        return shouldSwap;
    }
}
