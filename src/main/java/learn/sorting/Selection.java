package learn.sorting;

import learn.utils.CommonUtils;

/**
 * 选择排序
 *  时间复杂度 O(n2)
 *  空间复杂度 1
 *  稳定性较差
 *
 * @author JiangJian
 * @date 2023/06/10 22:58
 */
public class Selection {

    /**
     * 从数组中找到最小的元素 和首位置替换
     * 根据数据序列移动首位置
     * 根据数据元素个数循环该步骤
     */
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 9, 4, 2};

        // 循环整个数组
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            // 遍历数组获取最小的值的下标
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            // 将最小值移到最前
            CommonUtils.swap(arr, i, minPos);
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
