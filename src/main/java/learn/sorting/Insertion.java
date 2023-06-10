package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 插入排序(基本有序条件下最好用)重点
 *  时间复杂度 O(n2)
 *  空间复杂度 1
 *  稳定
 *
 * @author JiangJian
 * @date 2023/06/10 22:58
 */
public class Insertion {

    /**
     * 从列表中取出一个元素 把他插入到有序列表的合适位置
     * 类似于打牌过程中理牌的概念
     * 只不过在数组中是从第二个元素开始插入 并且涉及到元素的移动
     */
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sort(arr);
        CommonUtils.printArr(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    CommonUtils.swap(arr, j, j-1);
                }
            }
        }
    }
}
