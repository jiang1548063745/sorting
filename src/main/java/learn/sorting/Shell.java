package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 希尔排序(改进的插入排序) 减少交换次数
 *  时间复杂度 O(n1.3)
 *  空间复杂度 1
 *  不稳定
 *
 * @author JiangJian
 * @date 2023/06/10 22:59
 */
public class Shell {

    /**
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止
     */
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};

        sort(arr);
        CommonUtils.printArr(arr);
    }

    public static void sort(int[] arr) {
        // x / 2 == x >> 1

        // 序列
        // h =1
        // h = 3h + 1
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        // 间隔步长
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            // 从间隔位置往后遍历
            for (int i = gap; i < arr.length; i++) {
                // 以间隔步长控制排序分组
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        CommonUtils.swap(arr, j, j - gap);
                    }
                }
            }
        }
    }
}
