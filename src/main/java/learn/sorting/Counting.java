package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 计数排序
 *  时间复杂度  N+K
 *  空间复杂度  N+K
 *  不稳定(优化后可稳定)
 *
 * @author JiangJian
 * @date 2023/06/10 23:00
 */
public class Counting {

    /**
     * 利用计数器记录每个元素出现的个数 按顺序生成
     */
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};

        int[] result = sort(arr);

        CommonUtils.printArr(result);
    }

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];

        int[] count = new int[10];

        // 记录出现的次数
        for (int k : arr) {
            count[k]++;
        }

        // 遍历计数器 重新生成新数组
//        for (int i = 0, j = 0; i < count.length; i++) {
//            while (count[i]-- > 0) {
//                result[j++] = i;
//            }
//        }

        for (int i = 1; i < count.length; i++) {
            // 累加数组
            count[i] = count[i] + count[i - 1];
        }

        // 倒序迭代
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }

        return result;
    }
}
