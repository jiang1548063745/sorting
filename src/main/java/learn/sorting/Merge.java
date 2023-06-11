package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 归并排序(扩展TimSort)
 *  时间复杂度 O(n * log2n)
 *  空间复杂度 O(n)
 *  稳定
 *
 * @author JiangJian
 * @date 2023/06/11 15:06
 */
public class Merge {

    /**
     * 总体思想 先拆分 再合并
     * 归并排序对序列的元素进行逐层折半分组，然后从最小分组开始比较排序，
     * 合并成一个大的分组，逐层进行，最终所有的元素都是有序的
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
//        int[] arr = {1, 4, 7, 8, 3, 6, 9};

        sort(arr, 0, arr.length - 1);

        CommonUtils.printArr(arr);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // 左边排序
        sort(arr, left, mid);
        // 右边排序
        sort(arr, mid + 1, right);

        // 归并
        merge(arr, left, mid + 1, right);
    }

    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int p1 = leftPtr;
        int p2 = rightPtr;
        int p = 0;

        while (p1 <= mid && p2 <= rightBound) {
            temp[p++] = arr[p1] <= arr[p2] ?  arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= rightBound) {
            temp[p++] = arr[p2++];
        }

        System.arraycopy(temp, 0, arr, leftPtr, temp.length);
    }
}
